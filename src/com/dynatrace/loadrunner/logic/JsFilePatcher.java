package com.dynatrace.loadrunner.logic;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.LinkedList;

public class JsFilePatcher {
	
	private static final String DYNATRACE_HEADER_REPLACING_PATTERN = Constants.ADD_HEADER_FUNCTION_TEST+"\\(\".*\"\\);";
	private static final String LR_END_TRANSACTION = "lr.endTransaction";
	private static final String LR_START_TRANSACTION = "lr.startTransaction";
	private static final char EOF = (char) -1;

	private File sourceFile;
	private File targetFile;
	private BufferedWriter writer;
	private JsFileScanner scanner;

	private LinkedList<String> transactionNames;
	private boolean insertCalls;
	private String scriptName;
	
	public JsFilePatcher(File sourceFile, File targetFile, ScriptFile scriptFile)
	{
		writer=null;
		transactionNames=new LinkedList<String>();
		this.targetFile=targetFile;
		this.sourceFile=sourceFile;
	}
	
	public void generateFile(boolean insertCalls,String scriptName) throws IOException
	{
		try {
			this.insertCalls=insertCalls;
			this.scriptName = scriptName;
			writer=new BufferedWriter(new FileWriter(targetFile));
			scanner=new JsFileScanner(sourceFile);
			scanner.init();
			parseFile();
		} catch (IOException e) {
			throw e;
		} 
		finally{
			try {
				writer.close();
			} catch (Exception e) {}
			if (scanner!=null)
				scanner.close();
		}
	}

	private void parseFile() throws IOException
	{
		while (scanner.readInstruction())
			handleInstruction(scanner.getInstruction().toString(), scanner.getCommentedInstruction().toString());
	}
	
	private void handleInstruction(String instruction, String commentedInstruction) throws IOException {
		String write=commentedInstruction;
		if (write==null)
			write=instruction;
		write=removeEOF(commentedInstruction);
		if (!instruction.contains(Constants.ADD_HEADER_FUNCTION_TEST))
		{
			if (instruction.contains(LR_START_TRANSACTION))
				transactionNames.add(getFirstStringParameter(write));
			else if (instruction.contains(LR_END_TRANSACTION))
				transactionNames.remove(getFirstStringParameter(write));
			else
			{
				for (String keyword: Constants.JS_KEYWORDS)
				{
					if (instruction.contains(keyword))
					{
						if (insertCalls)
						{
							
							String pageContext=getFirstStringParameter(instruction);
							write=insertMethodCall(keyword, write, pageContext);
						}
						break;
					}
				}
			}
			writer.write(write);
		}
		else
		{
			writer.write(write.replaceAll(DYNATRACE_HEADER_REPLACING_PATTERN, ""));
			scanner.readWhiteSpaces();
		}
	}

	private String insertMethodCall(String keyword, String commentedInstruction, String pageContext) throws UnsupportedEncodingException {
		int insertPosition=0;
		int keywordIndex=0;
		char aktChar;
		for (int i=0;i<commentedInstruction.length();i++)
		{
			aktChar=commentedInstruction.charAt(i);
			if (aktChar==keyword.charAt(keywordIndex))
			{
				keywordIndex++;
				if (keywordIndex==keyword.length())
				{
					insertPosition=i-keywordIndex+1;
					break;
				}
			}
			else
			{
				keywordIndex=0;
				if (aktChar==keyword.charAt(keywordIndex))
				{
					keywordIndex++;
				}
				else if (aktChar=='/')
				{
					aktChar=commentedInstruction.charAt(++i);
					if (aktChar=='*')
						i = skipBlockComment(commentedInstruction, i);
					else if (aktChar=='/')
						i = skipLine(commentedInstruction, aktChar, i);
				}
				else if (aktChar=='#')
					i = skipLine(commentedInstruction, aktChar, i);
			}
		}

		String start=commentedInstruction.substring(0, insertPosition);
		String end=commentedInstruction.substring(insertPosition);

		String parameter="\"";
		String TSN = createTimerName();
		if(!TSN.isEmpty()) {
			parameter+="TSN="+TSN+";";
		}
		if (!isClickAndScriptKeyword(keyword)) {
			parameter+="PC=" + pageContext+";";
			parameter+="SI=LoadRunner;";
			if(!scriptName.isEmpty()) {
				parameter+="LSN="+scriptName+";";
			}
		}
		parameter+="\"";
		String instruction=start+Constants.ADD_HEADER_FUNCTION_TEST+"("+parameter+");"+ Constants.CRLF_OS_INDEPENDENT+scanner.getIndention()+end;

		return instruction;
	}

	private boolean isClickAndScriptKeyword(String keyword)
	{
		for (String word: Constants.JS_CLICK_AND_SCRIPT_KEYWORDS)
		{
			if (word.equals(keyword))
				return true;
		}
		return false;
	}

	private String createTimerName() throws UnsupportedEncodingException
	{
		StringBuilder builder=new StringBuilder();
		boolean first=true;
		for (String transactionName: transactionNames)
		{
			if (!first)
				builder.append(" - ");
			first=false;
			builder.append(transactionName);
		}
		return builder.toString();
	}

	private int skipLine(String commentedInstruction, char aktCh, int i) {
		char oldChar='/', olderChar, aktChar=aktCh;
		int index=i;
		do
		{
			olderChar=oldChar;
			oldChar=aktChar;
			aktChar=commentedInstruction.charAt(++index);
			if ((aktChar=='\n' && oldChar!='\\') || (aktChar=='\n' && oldChar=='\r' && olderChar!='\\'))
				break;
		}while (index<commentedInstruction.length());
		return index;
	}

	private int skipBlockComment(String commentedInstruction, int i) {
		char aktChar;
		int index = i;
		
		while (index < commentedInstruction.length() - 1)
		{
			aktChar = commentedInstruction.charAt(++index);
			while (aktChar == '*' && index < commentedInstruction.length() - 1)
			{
				aktChar=commentedInstruction.charAt(++index);
				if (aktChar == '/') {
					return index;
				}
			}
		} 
		return index;
	}
	
	private String getFirstStringParameter(String instruction) {
		StringBuilder builder=new StringBuilder();
		int i=instruction.indexOf('\'')+1;
		if (i == 0)
			return "";
		char ch=instruction.charAt(i++), old='\'';
		while (i<instruction.length())
		{
			if (ch=='\'' && old!='\\')
				break;
			builder.append(ch);
			old=ch;
			ch=instruction.charAt(i++);
		}
		return builder.toString();
	}
	
	private String removeEOF(String instruction) {
		String write=instruction;
		if (instruction.length()>0 && instruction.charAt(instruction.length()-1)==EOF)
			write=instruction.substring(0, instruction.length()-1);
		return write;
	}


}

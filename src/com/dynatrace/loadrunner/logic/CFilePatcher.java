package com.dynatrace.loadrunner.logic;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.LinkedList;

import com.dynatrace.loadrunner.data.ScriptFile;
import com.dynatrace.loadrunner.data.ScriptFileState;

public class CFilePatcher {
	private static final String DYNATRACE_HEADER_REPLACING_PATTERN = Constants.ADD_HEADER_FUNCTION+"\\(\"\\S*\"\\);$";
	private static final String LR_END_TRANSACTION = "lr_end_transaction";
	private static final String LR_START_TRANSACTION = "lr_start_transaction";
	private static final char EOF = (char) -1;

	private File sourceFile;
	private File targetFile;
	private BufferedWriter writer;
	private CFileScanner scanner;

	private LinkedList<String> transactionNames;
	private ScriptFile scriptFile;
	private boolean insertCalls;

	public CFilePatcher(File sourceFile, File targetFile, ScriptFile scriptFile)
	{
		writer=null;
		transactionNames=new LinkedList<String>();
		this.targetFile=targetFile;
		this.sourceFile=sourceFile;
		this.scriptFile=scriptFile;
	}

	/**
	 * Parses the sourceFile and writes it to targetFile.
	 *
	 * @param insertCalls if true is passed, it will add calls to the dynaTraceAddHeader method,
	 * 		if false is passed, it will remove those calls
	 * @throws IOException
	 * @author simon.schatka
	 */
	public void generateFile(boolean insertCalls) throws IOException
	{
		try {
			this.insertCalls=insertCalls;
			writer=new BufferedWriter(new FileWriter(targetFile));
			scanner=new CFileScanner(sourceFile);
			scanner.init();
			scriptFile.setState(ScriptFileState.Running);
			parseFile();
			scriptFile.setState(ScriptFileState.Handled);
		} catch (IOException e) {
			scriptFile.setState(ScriptFileState.Error);
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

	/**
	 * Inserts the addDynaTraceHeader Instruction and extracts the Transaction Name
	 *
	 * @param instruction
	 * @param commentedInstruction
	 * @throws IOException
	 */
	private void handleInstruction(String instruction, String commentedInstruction) throws IOException {
		String write=commentedInstruction;
		if (write==null)
			write=instruction;
		write=removeEOF(commentedInstruction);
		if (!instruction.contains(Constants.ADD_HEADER_FUNCTION))
		{
			if (instruction.contains(LR_START_TRANSACTION))
				transactionNames.add(getFirstStringParameter(instruction));
			else if (instruction.contains(LR_END_TRANSACTION))
				transactionNames.remove(getFirstStringParameter(instruction));
			else
			{
				//Does the current instruction contain one of the keywords?
				for (String keyword: Constants.KEYWORDS)
				{
					if (instruction.startsWith(keyword))
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
		//Remove our Instructions to add headers and WhiteSpaces to retain the correct Code Format
		else
		{
			writer.write(write.replaceAll(DYNATRACE_HEADER_REPLACING_PATTERN, ""));
			scanner.readWhiteSpaces();
		}
	}

	/**
	 * Inserts a call to addDynaTraceHeader in front of the function call
	 *
	 * @param keyword
	 * @param commentedInstruction
	 * @param pageContext
	 * @return a String containing comments, a call to addDynaTraceHeader and the real function call
	 * @throws UnsupportedEncodingException
	 */
	private String insertMethodCall(String keyword, String commentedInstruction, String pageContext) throws UnsupportedEncodingException {
		//We need to parse the Instruction again and find the last occurrence of the keyword,
		//that is NOT in a comment
		int insertPosition=0;
		int keywordIndex=0;
		char aktChar;
		for (int i=0;i<commentedInstruction.length();i++)
		{
			aktChar=commentedInstruction.charAt(i);
			//Found the next char of our keyword
			if (aktChar==keyword.charAt(keywordIndex))
			{
				keywordIndex++;
				//Found the keyword
				if (keywordIndex==keyword.length())
				{
					insertPosition=i-keywordIndex+1;
					break;
				}
			}
			//next char of our keyword not found-->start over
			else
			{
				keywordIndex=0;
				//maybe the current char is the start of the keyword.
				//Since all of our keywords are more than 1 chars long, we do not
				//need to worry that we found our insertPosition
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

		//Split the String right in front of the Instruction
		String start=commentedInstruction.substring(0, insertPosition);
		String end=commentedInstruction.substring(insertPosition);

		String urlEncodedPageContext=URLEncoder.encode(pageContext, "UTF-8");

		//Insert the call to the addDynaTraceHeader function right in front of the call-->
		//no Comments between the call to our function and the call of the web_* function
		String parameter="\"NA="+createTimerName();
		if (!isClickAndScriptKeyword(keyword))
			parameter+=";PC=" + urlEncodedPageContext;
		parameter+="\"";
		String instruction=start+Constants.ADD_HEADER_FUNCTION+"("+parameter+");"+ Constants.CRLF_OS_INDEPENDENT+scanner.getIndention()+end;

		return instruction;
	}

	private boolean isClickAndScriptKeyword(String keyword)
	{
		for (String word: Constants.CLICK_AND_SCRIPT_KEYWORDS)
		{
			if (word.equals(keyword))
				return true;
		}
		return false;
	}

	/**
	 * @return a string containing an appended list of all started instructions
	 * @author simon.schatka
	 * @throws UnsupportedEncodingException
	 */
	private String createTimerName() throws UnsupportedEncodingException
	{
		StringBuilder builder=new StringBuilder();
		boolean first=true;
		for (String transactionName: transactionNames)
		{
			if (!first)
				builder.append("_");
			first=false;
			builder.append(transactionName);
		}
		return URLEncoder.encode(builder.toString(), "UTF-8");
	}

	/**
	 *
	 * Skips a line(if it contains \ at the end-->next line too)
	 *
	 * @param commentedInstruction
	 * @param aktCh
	 * @param i
	 * @return the offset that indicates where the line ends
	 * @author simon.schatka
	 */
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

	/**
	 * Skips a Blockcomment
	 *
	 * @param commentedInstruction
	 * @param i
	 * @return the offset that indicates, where the blockcomment ends
	 * @author simon.schatka
	 */
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
		
	/**
	 * @param instruction
	 * @return the first Parameter of an instruction(First word that is enclosed in "")
	 */
	private String getFirstStringParameter(String instruction) {
		StringBuilder builder=new StringBuilder();
		int i=instruction.indexOf('"')+1;
		if (i == 0)	//instruction.indexOf('"') is -1, no '"' found
			return "";
		char ch=instruction.charAt(i++), old='"';
		while (i<instruction.length())
		{
			if (ch=='"' && old!='\\')
				break;
			builder.append(ch);
			old=ch;
			ch=instruction.charAt(i++);
		}
		return builder.toString();
	}

	/**
	 * @param instruction
	 * @return Returns the instruction Parameter without a trailing EOF character
	 */
	private String removeEOF(String instruction) {
		String write=instruction;
		if (instruction.length()>0 && instruction.charAt(instruction.length()-1)==EOF)
			write=instruction.substring(0, instruction.length()-1);
		return write;
	}
}
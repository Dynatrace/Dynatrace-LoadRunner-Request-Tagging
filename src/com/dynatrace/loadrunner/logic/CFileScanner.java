package com.dynatrace.loadrunner.logic;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;


/**
 * Reads one Instruction after another from a File
 *
 * @author simon.schatka
 */
public class CFileScanner {
	private static final char EOF = (char) -1;
	private char ch, old, older;
	private String indention="";
	private String newIndention="";
	private boolean insideString=false;
	private StringBuilder instruction;
	private StringBuilder commentedInstruction;
	private File sourceFile;
	private BufferedReader reader;

	public CFileScanner(File sourceFile)
	{
		this.sourceFile=sourceFile;
	}

	/**
	 * Opens the file specified to read Instructions from it
	 *
	 * @throws IOException
	 * @author simon.schatka
	 */
	public void init() throws IOException
	{
		reader=new BufferedReader(new FileReader(sourceFile));
		readChar();
	}

	/**
	 * Reads the next Instruction and returns if the end of the file has been reached
	 *
	 * @throws IOException
	 */
	public boolean readInstruction() throws IOException {
		if (ch==EOF)
			return false;
		instruction=new StringBuilder();
		commentedInstruction=new StringBuilder();
		indention="";
		while (ch!=EOF)
		{
			if (ch==';' && !insideString)
				break;
			else if (ch=='}' && !insideString)
				break;
			else if (ch=='"' )
			{
				if (old!='\\')
					insideString=!insideString;
			}
			else if (ch=='/' && !insideString)
			{
				readChar();
				if (ch=='*' && !insideString)
				{
					appendCommentBegin();
					commentedInstruction.append(readBlockComment());
					continue;
				}
				else if (ch=='/' && !insideString)
				{
					appendCommentBegin();
					commentedInstruction.append(readToLineEnd());
					continue;
				}
				else
				{
					appendChar(old);
				}
			}
			else if (!Character.isWhitespace(ch) && indention.isEmpty())
				indention=newIndention;

			appendChar(ch);
			readChar();
		}
		appendChar(ch);
		readChar();
		return true;
	}

	private void appendChar(char character) {
		if (!Character.isWhitespace(character))
			instruction.append(character);
		commentedInstruction.append(character);
	}

	private void appendCommentBegin() {
		commentedInstruction.append(old);
		commentedInstruction.append(ch);
	}

	/**
	 * @return Reads a BlockComment and returns it as String
	 * @throws IOException
	 */
	private String readBlockComment() throws IOException {
		StringBuilder comment=new StringBuilder();
		boolean endFound = false;
		do
		{
			readChar();
			comment.append(ch);
			while (ch=='*' && !endFound)
			{
				readChar();
				comment.append(ch);
				if (ch=='/')	//we found a '*/'
					endFound = true;
			}
		}while (ch!=EOF && !endFound);
		readChar();
		return comment.toString();
	}

	/**
	 * @return Reads until it reaches a line end and returns all characters read until then
	 * @throws IOException
	 */
	private String readToLineEnd() throws IOException {
		StringBuilder comment=new StringBuilder();
		do
		{
			readChar();
			comment.append(ch);
			//If the line ends with \(no trailing whitespaces),
			//the preprocessor instruction/comment continues on the next line
			if ((ch=='\n' && old!='\\') || (ch=='\n' && old=='\r' && older!='\\'))
				break;
		}while (ch!=EOF);
		readChar();
		return comment.toString();
	}

	/**
	 * Reads the next character from the Stream and calculates the indentionString
	 */
	private void readChar()
	{
		try {
			older=old;
			old=ch;
			ch=(char)reader.read();
			if (ch=='\n')
				newIndention="";
			else if (ch=='\t' || ch==' ')
				newIndention+=ch;
		} catch (IOException e) {
			ch=EOF;
		}
	}

	/**
	 * @return Reads as many White Spaces as possible and returns them as String
	 * @throws IOException
	 */
	public String readWhiteSpaces() throws IOException
	{
		StringBuilder whitespaces=new StringBuilder();
		while (ch!=EOF && Character.isWhitespace(ch))
		{
			readChar();
			whitespaces.append(ch);
		}
		if (whitespaces.length()>0)
			return whitespaces.substring(0,whitespaces.length()-1);
		return "";
	}

	/**
	 * Closes the internal reader
	 *
	 * @author simon.schatka
	 */
	public void close()
	{
		try{
			reader.close();
		} catch (Exception e) {}
	}

	public String getIndention() {
		return indention;
	}

	/**
	 * @return the last instruction that has been read
	 * @author simon.schatka
	 */
	public StringBuilder getInstruction() {
		return instruction;
	}


	/**
	 * @return the last instruction that has been read, including all comments
	 * @author simon.schatka
	 */
	public StringBuilder getCommentedInstruction() {
		return commentedInstruction;
	}
}

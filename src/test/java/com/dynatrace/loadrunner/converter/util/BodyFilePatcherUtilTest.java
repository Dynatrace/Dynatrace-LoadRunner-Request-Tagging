package com.dynatrace.loadrunner.converter.util;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class BodyFilePatcherUtilTest {

	@Test
	public void getInsertPositionTest() {
		String unmodifiedInstruction = "	web_url(\"xaOI6zd9HW9.js_2\"";
		String unmodifiedInstructionWithComment = "/*just some test comment*/web_url(\"uhh91198.js\",)";
		String unmodifiedInstructionWithLineComment = "//web_url(\"uhh91198.js\",)";
		String unmodifiedInstructionWithoutKeyword = "just some random text without keyword";
		String keyword = "web_url";
		assertEquals(1, BodyFilePatcherUtil.getInsertPosition(unmodifiedInstruction, keyword));
		assertEquals(26, BodyFilePatcherUtil.getInsertPosition(unmodifiedInstructionWithComment, keyword));
		assertEquals(0, BodyFilePatcherUtil.getInsertPosition(unmodifiedInstructionWithLineComment, keyword));
		assertEquals(0, BodyFilePatcherUtil.getInsertPosition(unmodifiedInstructionWithoutKeyword, keyword));
	}

	@Test
	public void concatTransactionNamesTest() {
		String expectedResult = "transaction1 - transaction2 - transaction3 and transaction4";
		List<String> transactions = Arrays.asList("transaction1", "transaction2", "transaction3 and transaction4");
		String transactionString = BodyFilePatcherUtil.concatTransactionNames(transactions);
		assertEquals(expectedResult, transactionString);
	}

	@Test
	public void getFirstStringParameter() {
		char cParam = '"';
		char jsParam = '\'';
		String instructionJs = "web.url({name:'orange-booking-finish.jsf_3',url:'http://localhost:8079/orange-booking-finish.jsf?success=1&journeyId=1',resource:0,recContentType:'text/html',referer:'http://localhost:8079/orange-booking-finish.jsf?journeyId=1',snapshot:'t33.inf',mode:'HTML',extraRes:[{url:'/img/gradient/Verlauf_Orange_Button_2.png',referer:'http://localhost:8079/orange-booking-finish.jsf?success=1&journeyId=1'}";
		String expectedResultJs = "orange-booking-finish.jsf_3";
		String instructionC = "";
		String expectedResultC = "";
		assertEquals(expectedResultJs, BodyFilePatcherUtil.getFirstStringParameter(instructionJs, jsParam));
		assertEquals(expectedResultC, BodyFilePatcherUtil.getFirstStringParameter(instructionC, cParam));
	}

}

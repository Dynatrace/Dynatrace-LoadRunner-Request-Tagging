 ////////////////////////////////////////////////////////////////////////////////////////
//
// 	Script Title       	: 07_BrowserReport_BALS
// 	Summary			   	: This function call is the action block for 07_BrowserReport_BALS(balance Sheet report- excel format)
// 	Author			   	: Infosys  Limited
// 	Email			   	:
//  Date:				: 10/18/2011
//  Version            	: 1.0
//
////////////////////////////////////////////////////////////////////////////////////////
//  Revision History
//  ======================
//
//
//
////////////////////////////////////////////////////////////////////////////////////////
/*******************************************************************************
	*   Action "Action_BALS_Excel"
*******************************************************************************/
Action_BALS_Excel()
{
	int HttpRetCode,i;
    char transactionName[256];

	lr_vuser_status_message( "Current Iteration #%s",lr_eval_string("{Iteration}") );

	//--------------------------------------------------------------------------------------------------------------
	
	sprintf( transactionName,"07_BrowserReport_%s_S01_GO_TOP",lr_eval_string("{quickJump}") );
/*******************************************************************************/
	lr_start_transaction(transactionName);

	JumpTo_Bals();

	/*EXCEL*/

	lr_end_transaction(transactionName, LR_AUTO);
/*******************************************************************************/
	//////////// RENDEZVOUS FUNCTION /////////////////////
	if (i_isRendezvousEnabled) {
 		lr_rendezvous("07_BrowserReport_BALS_S02_View");
 	}
	//////////// RENDEZVOUS FUNCTION /////////////////////

	/*Account Number
	Must be a single account but can be any type.
	*/

	/*20363*/

	/*Current Date
	*/

	/*Hit <Enter> or Click <View>
	*/
/*******************************************************************************/
	lr_start_transaction("07_BrowserReport_BALS_S02_View");

    web_reg_find("Text=View Report",
		LAST);

	web_submit_data("submitReportRequestPage.do",//Added for new build - a490649
		//"submitReportRequestPage.do;jsessionid={jsessionId}", //ObJz8srmbNz__d50P8gQbJ4 Commented for new buld - a490649
		//"Action={gbl_INVESTONE_Host_Port}/submitReportRequestPage.do;jsessionid={jsessionId}", //ObJz8srmbNz__d50P8gQbJ4 Commented for new buld - a490649
		"Action={gbl_INVESTONE_Host_Port}/submitReportRequestPage.do",//Added for new build - a490649
		"Method=POST",
		"TargetFrame=",
		"RecContentType=text/html",
		"Referer={gbl_INVESTONE_Host_Port}/getReportRequestPage.do?reportId={ReportId}",
		"Snapshot=t11.inf",
		"Mode=HTML",
		ITEMDATA,
		//"Name=jsessionid", "Value={jsessionId}", ENDITEM, //ObJz8srmbNz__d50P8gQbJ4 // Commented for new build -a490649
		"Name=docFormName", "Value=reportRequestPageForm", ENDITEM, //Added for new build - a490649
		"Name=isAdhocReportExecution", "Value=FALSE", ENDITEM, //Added for new build - a490649
		"Name=reportId", "Value={ReportId}", ENDITEM,
		"Name=Account", "Value={AccountNumber}", ENDITEM,
		"Name=View", "Value=FA", ENDITEM, //Added for new build - a490649
		"Name=global_account", "Value=N", ENDITEM,
		"Name=From_Date", "Value={PriorDate}", ENDITEM,
		"Name=To_Date", "Value={NextDate}", ENDITEM,
		"Name=Multi_Period_Report", "Value={MultiPeriod}", ENDITEM,
		//"Name=IAMode", "Value=N", ENDITEM, Commented for new buld - a490649
		"Name=View", "Value=FA", ENDITEM, //Added for new build - a490649
		"Name=reportOutputType", "Value={ReportOutput}", ENDITEM,
		//Extrares Added for new build - a490649
		EXTRARES,
		"Url=cabs/ReportViewer.jar?version-id=1.0.1.9", "Referer=", ENDITEM,
		"Url=cabs/essd9.jar?version-id=1.0.0.2", "Referer=", ENDITEM,
		"Url=cabs/itext-1.01.jar?version-id=1.0.0.2", "Referer=", ENDITEM,
		LAST);

    //Below call Commented for new build - a490649

	/*web_url("CustomerHeader.jsp_3",
		"URL={gbl_INVESTONE_Host_Port}/CustomerHeader.jsp",
		"TargetFrame=", 
		"Resource=0", 
		"RecContentType=text/html", 
		"Referer={gbl_INVESTONE_Host_Port}/logon.do",
		"Snapshot=t12.inf",
		"Mode=HTML",
		EXTRARES,
		"Url=cabs/ReportViewer.jar?version-id=1.0.1.11", "Referer=", ENDITEM,
		"Url=cabs/essd9.jar?version-id=1.0.0.1", "Referer=", ENDITEM,
		"Url=cabs/itext-1.01.jar?version-id=1.0.0.1", "Referer=", ENDITEM,
		LAST);*/

	/*view  frame app*/

	/*SecurityCertificate - Click on Yes*/

	web_custom_request("execSyncReport.do",//Added for new build -a490649
		//"execSyncReport.do;jsessionid={jsessionId}", Commented for new build - a490649
		//"URL={gbl_INVESTONE_Host_Port}/execSyncReport.do;jsessionid={jsessionId}?To_Date=07%2F13%2F2010&reportOutputType={ReportOutput}&Account={AccountNumber}&Multi_Period_Report={MultiPeriod}&IAMode=N&reportId={ReportId}&From_Date=27%2F27%2F2010&global_account=N", Commented for new build - a490649
		"URL={gbl_INVESTONE_Host_Port}/execSyncReport.do?To_Date={NextDate_MM}%2F{NextDate_DD}%2F{NextDate_YY}&View=FA&reportOutputType={ReportOutput}&Account={AccountNumber}&Multi_Period_Report={MultiPeriod}&reportId={ReportId}&From_Date={PriorDate_MM}%2F{PriorDate_DD}%2F{PriorDate_YY}&global_account=N&isAdhocReportExecution=FALSE&docFormName=reportRequestPageForm",//Added for new build - a490649
		"Method=POST",
		"TargetFrame=",
		"Resource=0",
		"RecContentType=application/vnd.ms-excel",
		"Referer=", 
		"Snapshot=t13.inf",
		"Mode=HTML", 
		"EncType=",
		LAST);

	/*Report is returned.
	*/

	/*Various report output types are:
	Report Output Type: EXCEL FILE XML CSV  */

	HttpRetCode = web_get_int_property(HTTP_INFO_RETURN_CODE);

	i = web_get_int_property(HTTP_INFO_DOWNLOAD_SIZE);

    if (HttpRetCode == 200)
	{
		lr_output_message("INFORMATION : The script successfully accessed the report.");
    	if(i <= 0)
			{
                 lr_end_transaction("07_BrowserReport_BALS_S02_View",LR_FAIL);
			}
			else
			{
                lr_output_message("INFORMATION:The download size of the Report was: %d",i);
        		lr_end_transaction("07_BrowserReport_BALS_S02_View",LR_PASS);
			}
	}
    else
	{
		lr_output_message("INFORMATION:The script failed to access the report.");
		lr_end_transaction("07_BrowserReport_BALS_S02_View",LR_FAIL);
	}

	/*Report opened with data.*/

/*******************************************************************************/
	return 0;
}

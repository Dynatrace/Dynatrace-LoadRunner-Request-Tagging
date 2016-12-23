 ////////////////////////////////////////////////////////////////////////////////////////
//
// 	Script Title       	: 1_05_BrowserReports_FIDPREPRICENAV
// 	Summary			   	: This function call is the action block for 1_05_BrowserReports_FIDPREPRICENAV
// 						  Steps:
// 						  Jump To FIDPREPRICENAV1
//						  Select Account Number
//						  Select Date
//						  Click on View
// 	Author			   	: Infosys  Limited
//  Date:				: 11/19/2011
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
	*   Action "Action_FIDPREPRICENAV"
*******************************************************************************/

Action_FIDPREPRICENAV()
{

	int iHttpRetCode,iReportSize;

	lr_vuser_status_message( "Current Iteration #%s",lr_eval_string("{Iteration}") );

	mExecTimer=lr_start_timer();

	/*Jump To FIDPREPRICENAV*/

	/*******************************************************************************/
	//			Step 1 : Jump to FIDPREPRICENAV Screen
	/*******************************************************************************/

	/*****************************************************************************/


	JumpTo_FIDPREPRICENAV();


	/*****************************************************************************/

  	/*Select Account Number*/

	/*****************************************************************************/

	web_url("invokeRsCheckReportingAccount.do",
		"URL={gbl_INVESTONE_Host_Port}/general/invokeRsCheckReportingAccount.do?_method=IsValidAccount&_mtype=execute&pcount=1&p0={AccountNumber}&rand=1321438348156",
		"TargetFrame=",
		"Resource=0",
		"RecContentType=text/html",
		"Referer={gbl_INVESTONE_Host_Port}/excel/invokeParms.do?tmpl={tmpl}",
		"Snapshot=t11.inf",
		"Mode=HTML",
		LAST);

	/*Select Date*/


	web_url("invokeRsCheckReportingAccount.do_2",
		"URL={gbl_INVESTONE_Host_Port}/general/invokeRsCheckReportingAccount.do?_method=IsValidAccount&_mtype=execute&pcount=1&p0={AccountNumber}&rand=1321438363891",
		"TargetFrame=",
		"Resource=0",
		"RecContentType=text/html",
		"Referer={gbl_INVESTONE_Host_Port}/excel/invokeParms.do?tmpl={tmpl}",
		"Snapshot=t12.inf",
		"Mode=HTML",
		LAST);

	web_url("invokeRsCheckReportingAccount.do_3",
		"URL={gbl_INVESTONE_Host_Port}/general/invokeRsCheckReportingAccount.do?_method=IsValidAccount&_mtype=execute&pcount=1&p0={AccountNumber}&rand=1321438399719",
		"TargetFrame=",
		"Resource=0",
		"RecContentType=text/html",
		"Referer={gbl_INVESTONE_Host_Port}/excel/invokeParms.do?tmpl={tmpl}",
		"Snapshot=t13.inf",
		"Mode=HTML",
		LAST);

	web_reg_find("Text={reg_find_text1}",
				 "Fail=NotFound",
				 "SaveCount=VerificationTextCount",
				 LAST);

	/*****************************************************************************/
		 //////////// RENDEZVOUS FUNCTION /////////////////////
	if (i_isRendezvousEnabled) {
		lr_rendezvous("1_05_BR_FIDPREPRICENAV_S02_View");
	}
	/*****************************************************************************/

	/*Click on VIEW*/

	web_reg_save_param("URLKey",
					   "LB=URLkey=",
					   "RB=&RLogTaskID",
					   "IgnoreRedirections=Yes",
					   LAST);

	/*******************************************************************************/
	//			Step 2 : FIDPREPRICENAV - View Transaction
	/*******************************************************************************/

	lr_start_transaction("1_05_BR_FIDPREPRICENAV_S02_View");

	web_url("invokeIoexcel.do",
		"URL={gbl_INVESTONE_Host_Port}/excel/invokeIoexcel.do?tmpl={tmpl}&Account={AccountNumber}&Date={CurrentBusinessDate}&VIEW=&ranNum=55.65377527497954",
		"TargetFrame=", 
		"Resource=0", 
		"RecContentType=text/html", 
		"Referer={gbl_INVESTONE_Host_Port}/landingPage.do?startscreen=none&startScreenUrl=none&selectRoleFlag=false",
		"Snapshot=t14.inf",
		"Mode=HTML",
		LAST);

	if(atoi(lr_eval_string("{VerificationTextCount}"))==0)
	{
		sprintf(acLogMessage,"Text: %s not found", lr_eval_string ("{reg_find_text1}") );
		investone_gbl_logmessage(ERROR,acLogMessage);

		sprintf(acLogMessage,"Transaction %s ended with Fail status","1_05_BR_FIDPREPRICENAV_S02_View");
		investone_gbl_logmessage(ERROR,acLogMessage);

		lr_end_transaction("1_05_BR_FIDPREPRICENAV_S02_View", LR_FAIL);
	}
	else
	{
		sprintf(acLogMessage,"Text: %s found", lr_eval_string ("{reg_find_text1}") );
		investone_gbl_logmessage(INFO,acLogMessage);
	}

	web_custom_request("invokeReptblob.do",
		"URL={gbl_INVESTONE_Host_Port}/excel/invokeReptblob.do?UseReportPathURL=true&URLkey={URLKey}&RLogTaskID=",
		"Method=POST",
		"TargetFrame=",
		"Resource=0",
		"RecContentType=application/vnd.ms-excel",
		"Referer=", 
		"Snapshot=t15.inf",
		"Mode=HTML", 
		"EncType=",
		LAST);

	/*end of Action*/

	/*Report is generated*/

	/*Validation steps added for Successful report generation - a490649*/

	iHttpRetCode = web_get_int_property(HTTP_INFO_RETURN_CODE);

	iReportSize = web_get_int_property(HTTP_INFO_DOWNLOAD_SIZE);

    if (iHttpRetCode == 200)
	{
		investone_gbl_logmessage(INFO,"The script successfully accessed the report");

    	if(iReportSize <= 0)
			{
				investone_gbl_logmessage(ERROR,"No data in report");

				sprintf(acLogMessage,"Transaction %s ended with Fail status","1_05_BR_FIDPREPRICENAV_S02_View");
				investone_gbl_logmessage(ERROR,acLogMessage);

				lr_end_transaction("1_05_BR_FIDPREPRICENAV_S02_View", LR_FAIL);
			}
			else
			{
				sprintf(acLogMessage,"Download size of Report: %d",iReportSize);
				investone_gbl_logmessage(INFO,acLogMessage);

				lr_end_transaction("1_05_BR_FIDPREPRICENAV_S02_View", LR_AUTO);
      		}
	}
    else
	{
		investone_gbl_logmessage(ERROR,"The script failed to access the report");

		sprintf(acLogMessage,"Transaction %s ended with Fail status","1_05_BR_FIDPREPRICENAV_S02_View");
		investone_gbl_logmessage(ERROR,acLogMessage);

		lr_end_transaction("1_05_BR_FIDPREPRICENAV_S02_View", LR_FAIL);
	}

	/*******************************************************************************/
	dElapsedExecTime = lr_end_timer(mExecTimer);
	investone_gbl_pacingtime(dEstimatedPacingTime,dElapsedExecTime);

	return 0;
}

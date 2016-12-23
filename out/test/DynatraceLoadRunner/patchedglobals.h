#ifndef _GLOBALS_H 
#define _GLOBALS_H

//--------------------------------------------------------------------
// Include Files
#include "lrun.h"
#include "web_api.h"
#include "lrw_custom_body.h"

void addDynaTraceHeader(char* header){
	char* headerValue;
	int headerValueLength;
	int vuserid, scid;
	char *groupid, *timestamp;
	char* vuserstring=(char*) malloc(sizeof(char) * 10);

	web_save_timestamp_param("TimeStamp", LAST);
	timestamp=lr_eval_string("{TimeStamp}");

	lr_whoami(&vuserid, &groupid, &scid);
	itoa(vuserid,vuserstring,10);

	headerValueLength = strlen(header) + 4 + strlen(vuserstring) + 4 + strlen(timestamp) + 1;
	headerValue = (char*) malloc(sizeof(char) * headerValueLength);
	strcpy(headerValue, header);
	strcat(headerValue,";VU=");
	strcat(headerValue,vuserstring);
	strcat(headerValue,";ID=");
	strcat(headerValue,timestamp);

	web_add_header("X-dynaTrace", headerValue);
	free(headerValue);
	free(vuserstring);
}

//--------------------------------------------------------------------
// Global Variables

#endif // _GLOBALS_H

#ifndef _GLOBALS_H 
#define _GLOBALS_H

//--------------------------------------------------------------------
// Include Files
#include "lrun.h"
#include "web_api.h"
#include "lrw_custom_body.h"

void addDynatraceHeaderTest(char* header){
	char* headerValue;
	int headerValueLength;
	int vuserid, scid;
	char *groupid, *timestamp;
	char* vuserstring=(char*) malloc(sizeof(char) * 10);
	char* ltnString=(char*) malloc(sizeof(char) * 10);

	if(lr_get_attrib_string("DynatraceLTN")!=NULL){
		strcpy(ltnString,lr_get_attrib_string("DynatraceLTN"));
	}
	lr_whoami(&vuserid, &groupid, &scid);
	itoa(vuserid,vuserstring,10);

	headerValueLength = strlen(header) + 4 + strlen(vuserstring) + 4 + strlen(ltnString) + 4;
	headerValue = (char*) malloc(sizeof(char) * headerValueLength);
	strcpy(headerValue, header);
	if(lr_get_attrib_string("DynatraceLTN")!=NULL){
		strcat(headerValue,"LTN=");
		strcat(headerValue,ltnString);
		strcat(headerValue,";");
	}
	strcat(headerValue,"VU=");
	strcat(headerValue,vuserstring);
	strcat(headerValue,";");

	web_add_header("X-dynaTrace-Test", headerValue);
	free(headerValue);
	free(vuserstring);
}

//--------------------------------------------------------------------
// Global Variables

#endif // _GLOBALS_H

//"'''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''
//" Global Section       : 
//"	List of global variables and objects.
//" 
//"'''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''



//Begin Global Section
function addDynatraceHeaderTest(headerString) {
	result = lr.whoami();
	var vuserID = "VU="+result[0];
	var header = headerString;
	var LTN = lr.getAttribString("DynatraceLTN");
	if(LTN){
		header+= "LTN="+LTN+";";
	}
	header += vuserID+';'
	web.addHeader("X-dynaTrace-Test",header)
}
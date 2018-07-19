//"'''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''
//" Script Title       : 
//"                      
//" Script Date        : Mon Jul  2 12:05:39 2018
//"                       
//"'''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''

function Action()
{
	web.setSocketsOption('SSL_VERSION', '2&3');

	web.addCookie('rxVisitor=15289676842149FIH2R0COG08SQDJN86HE28FCKU0M8LK; DOMAIN=localhost');

	web.addCookie('rxvt=1530527599567|1530525649324; DOMAIN=localhost');

	web.addCookie('dtPC=5$525799393_984h1vHMDJCCELBJFMHPCLMOLPGGBDHBPPFEDK; DOMAIN=localhost');

	web.addCookie('dtSa=-; DOMAIN=localhost');

	web.addCookie('dtLatC=1; DOMAIN=localhost');

	web.addCookie('rxvt=1530527654128|1530525649324; DOMAIN=localhost');

	web.addCookie('dtLatC=19; DOMAIN=localhost');

/*Correlation comment - Do not change!  Original value='2848D1DAE693DC0BC8A43DCB73B54AB8.jvmRoute-8280' Name ='jsessionid' Type ='ResponseBased'*/
	web.regSaveParamRegexp(
		{
			paramName : 'jsessionid', 
			regExp : 'JSESSIONID=(.*?);', 
			scope : 'Cookies', 
			IgnoreRedirections : 'No', 
			requestUrl : '*/localhost:8079/*'
		}
	);

/*Correlation comment - Do not change!  Original value='-7347118785443004971:-285508887967948890' Name ='javax.faces.ViewState' Type ='ResponseBased'*/
	web.regSaveParamAttrib(
		{
			paramName : 'javax.faces.ViewState', 
			tagName : 'input', 
			extract : 'value', 
			name : 'javax.faces.ViewState', 
			id : 'javax.faces.ViewState', 
			type : 'hidden', 
			ignoreRedirections : 'No', 
			requestUrl : '*/localhost:8079/*'
		}
	);

/*Correlation comment - Do not change!  Original value='irjj43jkcc' Name ='ice.window' Type ='ResponseBased'*/
	web.regSaveParamAttrib(
		{
			paramName : 'ice.window', 
			tagName : 'input', 
			extract : 'value', 
			name : 'ice.window', 
			type : 'hidden', 
			ignoreRedirections : 'No', 
			requestUrl : '*/localhost:8079/*'
		}
	);

/*Correlation comment - Do not change!  Original value='vkvklff9' Name ='ice.view' Type ='ResponseBased'*/
	web.regSaveParamAttrib(
		{
			paramName : 'ice.view', 
			tagName : 'input', 
			extract : 'value', 
			name : 'ice.view', 
			type : 'hidden', 
			ignoreRedirections : 'No', 
			requestUrl : '*/localhost:8079/*'
		}
	);



	web.url(
		{
			name : 'localhost:8079', 
			url : 'http://localhost:8079/', 
			resource : 0, 
			recContentType : 'text/html', 
			referer : '', 
			snapshot : 't1.inf', 
			mode : 'HTML', 
			extraRes :  [
				{url : '/img/header.png'},
				{url : '/img/gradient/Verlauf_Grau_Loginbox.png'},
				{url : '/img/gradient/Verlauf_Grau_Button_4.png'},
				{url : '/img/gradient/Verlauf_Orange_Button_4.png'},
				{url : '/img/journey_box.png'},
				{url : '/img/searchbox.png'},
				{url : '/css/css-images/cal_button.gif'},
				{url : '/css/css-images/ajax-loader.gif'},
				{url : '/img/menupunkt_trennung_transparent.png'},
				{url : '/img/gradient/Verlauf_Orange_Hauptfeld.png'},
				{url : '/img/gradient/Verlauf_Grau_ganzeBreite.png'},
				{url : '/img/gradient/Verlauf_Orange_Button_1.png'},
				{url : '/img/login/Loginwindow_textbox.png'},
				{url : '/img/gradient/Verlauf_Grau_Button_3.png'},
				{url : '/img/gradient/Verlauf_Grau_Hauptfeld.png'},
				{url : '/img/logo_layer_bottom.png'},
				{url : '/img/booking/Booking_transaction_textbox_medium1_page_3.png'},
				{url : '/img/menupunkt_auswahl_transparent.png'},
				{url : '/img/header2.jpg'},
				{url : '/img/header3.jpg'},
				{url : '/img/header4.jpg'},
				{url : '/img/header5.jpg'},
				{url : 'http://localhost:8092/image/road1.png'},
				{url : 'http://localhost:8092/image/winter.jpeg'},
				{url : '/img/header6.jpg'},
				{url : '/img/header7.jpg'}
			]
		}
	);

	web.addCookie('rxvt=1530527609601|1530525649324; DOMAIN=localhost');

	
	// Possible OAUTH authorization was detected. It is recommended to correlate the authorization parameters.
	web.addCookie('rxvt=1530527619604|1530525649324; DOMAIN=localhost');

	web.addCookie('dtPC=5$525799393_984h2vHMDJCCELBJFMHPCLMOLPGGBDHBPPFEDK; DOMAIN=localhost');

	web.addHeader('X-Requested-With', 
		'XMLHttpRequest');

	web.customRequest(
		{
			name : 'CalculateRecommendations', 
			url : 'http://localhost:8079/CalculateRecommendations?_=1530525821624', 
			method : 'GET', 
			resource : 0, 
			recContentType : 'text/html', 
			referer : 'http://localhost:8079/', 
			snapshot : 't3.inf', 
			mode : 'HTML', 
			encType : 'application/x-www-form-urlencoded; charset=UTF-8'
		}
	);



	lr.startTransaction('customer login');

	web.addAutoHeader('Faces-Request', 
		'partial/ajax');

	web.submitData(
		{
			name : 'orange.jsf;jsessionid=2848D1DAE693DC0BC8A43DCB73B54AB8.jvmRoute-8280', 
			action : 'http://localhost:8079/orange.jsf;jsessionid={jsessionid}', 
			method : 'POST', 
			recContentType : 'text/xml', 
			referer : 'http://localhost:8079/', 
			snapshot : 't7.inf', 
			mode : 'HTML', 
			encodeAtSign : 'YES', 
			itemData : 
				[
					{ name : 'loginForm', value : 'loginForm' }, 
					{ name : 'javax.faces.ViewState', value : '{javax.faces.ViewState}' }, 
					{ name : 'ice.window', value : '{ice.window}' }, 
					{ name : 'ice.view', value : '{ice.view}' }, 
					{ name : 'loginForm:username', value : '' }, 
					{ name : 'loginForm:password', value : '' }, 
					{ name : 'icefacesCssUpdates', value : '' }, 
					{ name : 'loginForm:j_idcl', value : 'loginForm:loginLink' }, 
					{ name : 'javax.faces.source', value : 'loginForm:loginLink' }, 
					{ name : 'javax.faces.partial.event', value : 'click' }, 
					{ name : 'javax.faces.partial.execute', value : '@all' }, 
					{ name : 'javax.faces.partial.render', value : '@all' }, 
					{ name : 'ice.window', value : '{ice.window}' }, 
					{ name : 'ice.view', value : '{ice.view}' }, 
					{ name : 'ice.focus', value : 'loginForm:loginLink' }, 
					{ name : 'loginForm:loginLink', value : 'loginForm:loginLink' }, 
					{ name : 'ice.event.target', value : 'loginForm:loginLink' }, 
					{ name : 'ice.event.captured', value : 'loginForm:loginLink' }, 
					{ name : 'ice.event.type', value : 'onclick' }, 
					{ name : 'ice.event.alt', value : 'false' }, 
					{ name : 'ice.event.ctrl', value : 'false' }, 
					{ name : 'ice.event.shift', value : 'false' }, 
					{ name : 'ice.event.meta', value : 'false' }, 
					{ name : 'ice.event.x', value : '1024' }, 
					{ name : 'ice.event.y', value : '44' }, 
					{ name : 'ice.event.left', value : 'true' }, 
					{ name : 'ice.event.right', value : 'false' }, 
					{ name : 'ice.submit.type', value : 'ice.s' }, 
					{ name : 'ice.submit.serialization', value : 'form' }, 
					{ name : 'javax.faces.partial.ajax', value : 'true' }
				]
		}
	);

	web.submitData(
		{
			name : 'orange.jsf', 
			action : 'http://localhost:8079/orange.jsf', 
			method : 'POST', 
			recContentType : 'text/xml', 
			referer : 'http://localhost:8079/', 
			snapshot : 't8.inf', 
			mode : 'HTML', 
			encodeAtSign : 'YES', 
			itemData : 
				[
					{ name : 'loginForm', value : 'loginForm' }, 
					{ name : 'javax.faces.ViewState', value : '{javax.faces.ViewState}' }, 
					{ name : 'ice.window', value : '{ice.window}' }, 
					{ name : 'ice.view', value : '{ice.view}' }, 
					{ name : 'loginForm:username', value : '' }, 
					{ name : 'loginForm:password', value : '' }, 
					{ name : 'icefacesCssUpdates', value : '' }, 
					{ name : 'loginForm:j_idcl', value : '' }, 
					{ name : 'javax.faces.source', value : 'loginForm:j_idt58' }, 
					{ name : 'javax.faces.partial.event', value : 'click' }, 
					{ name : 'javax.faces.partial.execute', value : '@all' }, 
					{ name : 'javax.faces.partial.render', value : '@all' }, 
					{ name : 'ice.window', value : '{ice.window}' }, 
					{ name : 'ice.view', value : '{ice.view}' }, 
					{ name : 'ice.focus', value : 'loginForm:j_idt58' }, 
					{ name : 'loginForm:j_idt58', value : '' }, 
					{ name : 'ice.event.target', value : 'loginForm:j_idt58' }, 
					{ name : 'ice.event.captured', value : 'loginForm:j_idt58' }, 
					{ name : 'ice.event.type', value : 'onclick' }, 
					{ name : 'ice.event.alt', value : 'false' }, 
					{ name : 'ice.event.ctrl', value : 'false' }, 
					{ name : 'ice.event.shift', value : 'false' }, 
					{ name : 'ice.event.meta', value : 'false' }, 
					{ name : 'ice.event.x', value : '844.7999877929687' }, 
					{ name : 'ice.event.y', value : '172.8000030517578' }, 
					{ name : 'ice.event.left', value : 'true' }, 
					{ name : 'ice.event.right', value : 'false' }, 
					{ name : 'ice.submit.type', value : 'ice.s' }, 
					{ name : 'ice.submit.serialization', value : 'form' }, 
					{ name : 'javax.faces.partial.ajax', value : 'true' }
				]
		}
	);

	web.submitData(
		{
			name : 'orange.jsf_2', 
			action : 'http://localhost:8079/orange.jsf', 
			method : 'POST', 
			recContentType : 'text/xml', 
			referer : 'http://localhost:8079/', 
			snapshot : 't9.inf', 
			mode : 'HTML', 
			encodeAtSign : 'YES', 
			itemData : 
				[
					{ name : 'loginForm', value : 'loginForm' }, 
					{ name : 'javax.faces.ViewState', value : '{javax.faces.ViewState}' }, 
					{ name : 'ice.window', value : '{ice.window}' }, 
					{ name : 'ice.view', value : '{ice.view}' }, 
					{ name : 'loginForm:username', value : '' }, 
					{ name : 'loginForm:password', value : '' }, 
					{ name : 'icefacesCssUpdates', value : '' }, 
					{ name : 'password', value : '{password}' }, 
					{ name : 'loginForm:j_idcl', value : 'loginForm:j_idt63:2:j_idt64' }, 
					{ name : 'userName', value : '{user}' }, 
					{ name : 'javax.faces.source', value : 'loginForm:j_idt63:2:j_idt64' }, 
					{ name : 'javax.faces.partial.event', value : 'click' }, 
					{ name : 'javax.faces.partial.execute', value : '@all' }, 
					{ name : 'javax.faces.partial.render', value : '@all' }, 
					{ name : 'ice.window', value : '{ice.window}' }, 
					{ name : 'ice.view', value : '{ice.view}' }, 
					{ name : 'ice.focus', value : 'loginForm:j_idt63:2:j_idt64' }, 
					{ name : 'loginForm:j_idt63:2:j_idt64', value : 'loginForm:j_idt63:2:j_idt64' }, 
					{ name : 'ice.event.target', value : 'loginForm:j_idt63:2:j_idt64' }, 
					{ name : 'ice.event.captured', value : 'loginForm:j_idt63:2:j_idt64' }, 
					{ name : 'ice.event.type', value : 'onclick' }, 
					{ name : 'ice.event.alt', value : 'false' }, 
					{ name : 'ice.event.ctrl', value : 'false' }, 
					{ name : 'ice.event.shift', value : 'false' }, 
					{ name : 'ice.event.meta', value : 'false' }, 
					{ name : 'ice.event.x', value : '763.2000122070312' }, 
					{ name : 'ice.event.y', value : '246.39999389648437' }, 
					{ name : 'ice.event.left', value : 'true' }, 
					{ name : 'ice.event.right', value : 'false' }, 
					{ name : 'ice.submit.type', value : 'ice.s' }, 
					{ name : 'ice.submit.serialization', value : 'form' }, 
					{ name : 'javax.faces.partial.ajax', value : 'true' }
				]
		}
	);

	web.revertAutoHeader('Faces-Request');

	
	lr.endTransaction('customer login', lr.AUTO);

	lr.startTransaction('search journey');

	web.addAutoHeader('Faces-Request', 
		'partial/ajax');

	web.submitData(
		{
			name : 'orange.jsf_3', 
			action : 'http://localhost:8079/orange.jsf', 
			method : 'POST', 
			recContentType : 'text/xml', 
			referer : 'http://localhost:8079/', 
			snapshot : 't11.inf', 
			mode : 'HTML', 
			encodeAtSign : 'YES', 
			itemData : 
				[
					{ name : 'iceform', value : 'iceform' }, 
					{ name : 'javax.faces.ViewState', value : '{javax.faces.ViewState}' }, 
					{ name : 'ice.window', value : '{ice.window}' }, 
					{ name : 'ice.view', value : '{ice.view}' }, 
					{ name : 'iceform:travellers', value : '4' }, 
					{ name : 'iceform:destination', value : 'p' }, 
					{ name : 'iceform:destination_idx', value : '' }, 
					{ name : 'iceform:fromDate', value : '' }, 
					{ name : 'iceform:toDate', value : '' }, 
					{ name : 'icefacesCssUpdates', value : '' }, 
					{ name : 'iceform:fromDate_cc', value : '' }, 
					{ name : 'iceform:j_idcl', value : '' }, 
					{ name : 'iceform:j_idiceform:toDatesp', value : '' }, 
					{ name : 'iceform:toDate_cc', value : '' }, 
					{ name : 'iceform:j_idiceform:fromDatesp', value : '' }, 
					{ name : 'javax.faces.source', value : 'iceform:destination' }, 
					{ name : 'javax.faces.partial.execute', value : '@all' }, 
					{ name : 'javax.faces.partial.render', value : '@all' }, 
					{ name : 'ice.window', value : '{ice.window}' }, 
					{ name : 'ice.view', value : '{ice.view}' }, 
					{ name : 'ice.focus', value : 'iceform:destination' }, 
					{ name : 'ice.event.target', value : 'iceform:destination' }, 
					{ name : 'ice.event.captured', value : 'iceform:destination' }, 
					{ name : 'ice.event.type', value : 'onunknown' }, 
					{ name : 'ice.submit.type', value : 'ice.s' }, 
					{ name : 'ice.submit.serialization', value : 'form' }, 
					{ name : 'ice.submit.partial', value : 'true' }, 
					{ name : 'javax.faces.partial.ajax', value : 'true' }
				]
		}
	);

	lr.thinkTime(6);
	web.submitData(
		{
			name : 'orange.jsf_4', 
			action : 'http://localhost:8079/orange.jsf', 
			method : 'POST', 
			recContentType : 'text/xml', 
			referer : 'http://localhost:8079/', 
			snapshot : 't12.inf', 
			mode : 'HTML', 
			encodeAtSign : 'YES', 
			itemData : 
				[
					{ name : 'iceform', value : 'iceform' }, 
					{ name : 'javax.faces.ViewState', value : '{javax.faces.ViewState}' }, 
					{ name : 'ice.window', value : '{ice.window}' }, 
					{ name : 'ice.view', value : '{ice.view}' }, 
					{ name : 'iceform:travellers', value : '4' }, 
					{ name : 'iceform:destination', value : 'pa' }, 
					{ name : 'iceform:destination_idx', value : '' }, 
					{ name : 'iceform:fromDate', value : '' }, 
					{ name : 'iceform:toDate', value : '' }, 
					{ name : 'icefacesCssUpdates', value : '' }, 
					{ name : 'iceform:fromDate_cc', value : '' }, 
					{ name : 'iceform:j_idcl', value : '' }, 
					{ name : 'iceform:j_idiceform:toDatesp', value : '' }, 
					{ name : 'iceform:toDate_cc', value : '' }, 
					{ name : 'iceform:j_idiceform:fromDatesp', value : '' }, 
					{ name : 'javax.faces.source', value : 'iceform:destination' }, 
					{ name : 'javax.faces.partial.execute', value : '@all' }, 
					{ name : 'javax.faces.partial.render', value : '@all' }, 
					{ name : 'ice.window', value : '{ice.window}' }, 
					{ name : 'ice.view', value : '{ice.view}' }, 
					{ name : 'ice.focus', value : 'iceform:destination' }, 
					{ name : 'ice.event.target', value : 'iceform:destination' }, 
					{ name : 'ice.event.captured', value : 'iceform:destination' }, 
					{ name : 'ice.event.type', value : 'onunknown' }, 
					{ name : 'ice.submit.type', value : 'ice.s' }, 
					{ name : 'ice.submit.serialization', value : 'form' }, 
					{ name : 'ice.submit.partial', value : 'true' }, 
					{ name : 'javax.faces.partial.ajax', value : 'true' }
				]
		}
	);

	web.submitData(
		{
			name : 'orange.jsf_5', 
			action : 'http://localhost:8079/orange.jsf', 
			method : 'POST', 
			recContentType : 'text/xml', 
			referer : 'http://localhost:8079/', 
			snapshot : 't13.inf', 
			mode : 'HTML', 
			encodeAtSign : 'YES', 
			itemData : 
				[
					{ name : 'iceform', value : 'iceform' }, 
					{ name : 'javax.faces.ViewState', value : '{javax.faces.ViewState}' }, 
					{ name : 'ice.window', value : '{ice.window}' }, 
					{ name : 'ice.view', value : '{ice.view}' }, 
					{ name : 'iceform:travellers', value : '4' }, 
					{ name : 'iceform:destination', value : 'par' }, 
					{ name : 'iceform:destination_idx', value : '' }, 
					{ name : 'iceform:fromDate', value : '' }, 
					{ name : 'iceform:toDate', value : '' }, 
					{ name : 'icefacesCssUpdates', value : '' }, 
					{ name : 'iceform:fromDate_cc', value : '' }, 
					{ name : 'iceform:j_idcl', value : '' }, 
					{ name : 'iceform:j_idiceform:toDatesp', value : '' }, 
					{ name : 'iceform:toDate_cc', value : '' }, 
					{ name : 'iceform:j_idiceform:fromDatesp', value : '' }, 
					{ name : 'javax.faces.source', value : 'iceform:destination' }, 
					{ name : 'javax.faces.partial.execute', value : '@all' }, 
					{ name : 'javax.faces.partial.render', value : '@all' }, 
					{ name : 'ice.window', value : '{ice.window}' }, 
					{ name : 'ice.view', value : '{ice.view}' }, 
					{ name : 'ice.focus', value : 'iceform:destination' }, 
					{ name : 'ice.event.target', value : 'iceform:destination' }, 
					{ name : 'ice.event.captured', value : 'iceform:destination' }, 
					{ name : 'ice.event.type', value : 'onunknown' }, 
					{ name : 'ice.submit.type', value : 'ice.s' }, 
					{ name : 'ice.submit.serialization', value : 'form' }, 
					{ name : 'ice.submit.partial', value : 'true' }, 
					{ name : 'javax.faces.partial.ajax', value : 'true' }
				]
		}
	);

	web.submitData(
		{
			name : 'orange.jsf_6', 
			action : 'http://localhost:8079/orange.jsf', 
			method : 'POST', 
			recContentType : 'text/xml', 
			referer : 'http://localhost:8079/', 
			snapshot : 't14.inf', 
			mode : 'HTML', 
			encodeAtSign : 'YES', 
			itemData : 
				[
					{ name : 'iceform', value : 'iceform' }, 
					{ name : 'javax.faces.ViewState', value : '{javax.faces.ViewState}' }, 
					{ name : 'ice.window', value : '{ice.window}' }, 
					{ name : 'ice.view', value : '{ice.view}' }, 
					{ name : 'iceform:travellers', value : '4' }, 
					{ name : 'iceform:destination', value : 'pari' }, 
					{ name : 'iceform:destination_idx', value : '' }, 
					{ name : 'iceform:fromDate', value : '' }, 
					{ name : 'iceform:toDate', value : '' }, 
					{ name : 'icefacesCssUpdates', value : '' }, 
					{ name : 'iceform:fromDate_cc', value : '' }, 
					{ name : 'iceform:j_idcl', value : '' }, 
					{ name : 'iceform:j_idiceform:toDatesp', value : '' }, 
					{ name : 'iceform:toDate_cc', value : '' }, 
					{ name : 'iceform:j_idiceform:fromDatesp', value : '' }, 
					{ name : 'javax.faces.source', value : 'iceform:destination' }, 
					{ name : 'javax.faces.partial.execute', value : '@all' }, 
					{ name : 'javax.faces.partial.render', value : '@all' }, 
					{ name : 'ice.window', value : '{ice.window}' }, 
					{ name : 'ice.view', value : '{ice.view}' }, 
					{ name : 'ice.focus', value : 'iceform:destination' }, 
					{ name : 'ice.event.target', value : 'iceform:destination' }, 
					{ name : 'ice.event.captured', value : 'iceform:destination' }, 
					{ name : 'ice.event.type', value : 'onunknown' }, 
					{ name : 'ice.submit.type', value : 'ice.s' }, 
					{ name : 'ice.submit.serialization', value : 'form' }, 
					{ name : 'ice.submit.partial', value : 'true' }, 
					{ name : 'javax.faces.partial.ajax', value : 'true' }
				]
		}
	);

	web.submitData(
		{
			name : 'orange.jsf_7', 
			action : 'http://localhost:8079/orange.jsf', 
			method : 'POST', 
			recContentType : 'text/xml', 
			referer : 'http://localhost:8079/', 
			snapshot : 't15.inf', 
			mode : 'HTML', 
			encodeAtSign : 'YES', 
			itemData : 
				[
					{ name : 'iceform', value : 'iceform' }, 
					{ name : 'javax.faces.ViewState', value : '{javax.faces.ViewState}' }, 
					{ name : 'ice.window', value : '{ice.window}' }, 
					{ name : 'ice.view', value : '{ice.view}' }, 
					{ name : 'iceform:travellers', value : '4' }, 
					{ name : 'iceform:destination', value : 'Paris' }, 
					{ name : 'iceform:destination_idx', value : '0' }, 
					{ name : 'iceform:fromDate', value : '' }, 
					{ name : 'iceform:toDate', value : '' }, 
					{ name : 'icefacesCssUpdates', value : '' }, 
					{ name : 'iceform:fromDate_cc', value : '' }, 
					{ name : 'iceform:j_idcl', value : '' }, 
					{ name : 'iceform:j_idiceform:toDatesp', value : '' }, 
					{ name : 'iceform:toDate_cc', value : '' }, 
					{ name : 'iceform:j_idiceform:fromDatesp', value : '' }, 
					{ name : 'javax.faces.source', value : 'iceform:destination' }, 
					{ name : 'javax.faces.partial.event', value : 'click' }, 
					{ name : 'javax.faces.partial.execute', value : '@all' }, 
					{ name : 'javax.faces.partial.render', value : '@all' }, 
					{ name : 'ice.window', value : '{ice.window}' }, 
					{ name : 'ice.view', value : '{ice.view}' }, 
					{ name : 'ice.focus', value : '' }, 
					{ name : 'ice.event.target', value : 'iceform:destination:j_idt133-0-0' }, 
					{ name : 'ice.event.captured', value : 'iceform:destination' }, 
					{ name : 'ice.event.type', value : 'onclick' }, 
					{ name : 'ice.event.alt', value : 'false' }, 
					{ name : 'ice.event.ctrl', value : 'false' }, 
					{ name : 'ice.event.shift', value : 'false' }, 
					{ name : 'ice.event.meta', value : 'false' }, 
					{ name : 'ice.event.x', value : '426.3999938964844' }, 
					{ name : 'ice.event.y', value : '400' }, 
					{ name : 'ice.event.left', value : 'true' }, 
					{ name : 'ice.event.right', value : 'false' }, 
					{ name : 'ice.submit.type', value : 'ice.s' }, 
					{ name : 'ice.submit.serialization', value : 'form' }, 
					{ name : 'javax.faces.partial.ajax', value : 'true' }
				]
		}
	);

	web.revertAutoHeader('Faces-Request');

	web.addHeader('X-Requested-With', 
		'XMLHttpRequest');

	web.customRequest(
		{
			name : 'CalculateRecommendations_2', 
			url : 'http://localhost:8079/CalculateRecommendations?_=1530525883929', 
			method : 'GET', 
			resource : 0, 
			recContentType : 'text/html', 
			referer : 'http://localhost:8079/', 
			snapshot : 't16.inf', 
			mode : 'HTML', 
			encType : 'application/x-www-form-urlencoded; charset=UTF-8'
		}
	);

	web.addHeader('Faces-Request', 
		'partial/ajax');

	web.submitData(
		{
			name : 'orange.jsf_8', 
			action : 'http://localhost:8079/orange.jsf', 
			method : 'POST', 
			recContentType : 'text/xml', 
			referer : 'http://localhost:8079/', 
			snapshot : 't17.inf', 
			mode : 'HTML', 
			encodeAtSign : 'YES', 
			itemData : 
				[
					{ name : 'iceform', value : 'iceform' }, 
					{ name : 'javax.faces.ViewState', value : '{javax.faces.ViewState}' }, 
					{ name : 'ice.window', value : '{ice.window}' }, 
					{ name : 'ice.view', value : '{ice.view}' }, 
					{ name : 'iceform:travellers', value : '4' }, 
					{ name : 'iceform:destination', value : 'Paris' }, 
					{ name : 'iceform:destination_idx', value : '' }, 
					{ name : 'iceform:fromDate', value : '' }, 
					{ name : 'iceform:toDate', value : '' }, 
					{ name : 'icefacesCssUpdates', value : '' }, 
					{ name : 'iceform:fromDate_cc', value : '' }, 
					{ name : 'iceform:j_idcl', value : '' }, 
					{ name : 'iceform:j_idiceform:toDatesp', value : '' }, 
					{ name : 'iceform:toDate_cc', value : '' }, 
					{ name : 'iceform:j_idiceform:fromDatesp', value : '' }, 
					{ name : 'javax.faces.source', value : 'iceform:search' }, 
					{ name : 'javax.faces.partial.event', value : 'click' }, 
					{ name : 'javax.faces.partial.execute', value : '@all' }, 
					{ name : 'javax.faces.partial.render', value : '@all' }, 
					{ name : 'ice.window', value : '{ice.window}' }, 
					{ name : 'ice.view', value : '{ice.view}' }, 
					{ name : 'ice.focus', value : 'iceform:search' }, 
					{ name : 'iceform:search', value : 'Search' }, 
					{ name : 'ice.event.target', value : 'iceform:search' }, 
					{ name : 'ice.event.captured', value : 'iceform:search' }, 
					{ name : 'ice.event.type', value : 'onclick' }, 
					{ name : 'ice.event.alt', value : 'false' }, 
					{ name : 'ice.event.ctrl', value : 'false' }, 
					{ name : 'ice.event.shift', value : 'false' }, 
					{ name : 'ice.event.meta', value : 'false' }, 
					{ name : 'ice.event.x', value : '566.3999633789062' }, 
					{ name : 'ice.event.y', value : '497.5999755859375' }, 
					{ name : 'ice.event.left', value : 'true' }, 
					{ name : 'ice.event.right', value : 'false' }, 
					{ name : 'ice.submit.type', value : 'ice.s' }, 
					{ name : 'ice.submit.serialization', value : 'form' }, 
					{ name : 'javax.faces.partial.ajax', value : 'true' }
				]
		}
	);


	web.addCookie('dtSa=true%7CC%7C-1%7CBook%20Now%7C-%7C1530525887198%7C525799393_984%7Chttp%3A%2F%2Flocalhost%3A8079%2F%7CeasyTravel%20-%20One%20step%20to%20happiness%7C1530525854129%7C; DOMAIN=localhost');

	web.addCookie('rxvt=1530527687772|1530525649324; DOMAIN=localhost');

	web.addCookie('dtPC=5$525887767_717h1vHMDJCCELBJFMHPCLMOLPGGBDHBPPFEDK; DOMAIN=localhost');

	web.addCookie('dtLatC=62; DOMAIN=localhost');

/*Correlation comment - Do not change!  Original value='-5857870484237393577:8609660813365958028' Name ='javax.faces.ViewState_1' Type ='ResponseBased'*/
	web.regSaveParamAttrib(
		{
			paramName : 'javax.faces.ViewState_1', 
			tagName : 'input', 
			extract : 'value', 
			name : 'javax.faces.ViewState', 
			id : 'javax.faces.ViewState', 
			type : 'hidden', 
			ignoreRedirections : 'No', 
			requestUrl : '*/orange-booking-review.jsf*'
		}
	);

/*Correlation comment - Do not change!  Original value='vkvklffa' Name ='ice.view_1' Type ='ResponseBased'*/
	web.regSaveParamAttrib(
		{
			paramName : 'ice.view_1', 
			tagName : 'input', 
			extract : 'value', 
			name : 'ice.view', 
			type : 'hidden', 
			ignoreRedirections : 'No', 
			requestUrl : '*/orange-booking-review.jsf*'
		}
	);

	web.url(
		{
			name : 'orange-booking-review.jsf', 
			url : 'http://localhost:8079/orange-booking-review.jsf?journeyId=1', 
			resource : 0, 
			recContentType : 'text/html', 
			referer : 'http://localhost:8079/', 
			snapshot : 't20.inf', 
			mode : 'HTML', 
			extraRes :  [
				{url : '/img/booking/stepindicator_2_active.png', referer : 'http://localhost:8079/orange-booking-review.jsf?journeyId=1'},
				{url : '/img/booking/Slider_empty_shadow.png', referer : 'http://localhost:8079/orange-booking-review.jsf?journeyId=1'},
				{url : '/img/booking/stepindicator.png', referer : 'http://localhost:8079/orange-booking-review.jsf?journeyId=1'},
				{url : '/img/booking/stepindicator_1_inactive.png', referer : 'http://localhost:8079/orange-booking-review.jsf?journeyId=1'},
				{url : '/img/booking/stepindicator_3_inactive.png', referer : 'http://localhost:8079/orange-booking-review.jsf?journeyId=1'},
				{url : '/img/booking/stepindicator_4_inactive.png', referer : 'http://localhost:8079/orange-booking-review.jsf?journeyId=1'},
				{url : '/img/gradient/Verlauf_Grau_Button_1.png', referer : 'http://localhost:8079/orange-booking-review.jsf?journeyId=1'}
			]
		}
	);

	lr.endTransaction('search journey', lr.AUTO);



	lr.startTransaction('book journey');


	lr.thinkTime(4);

	web.addHeader('Faces-Request', 
		'partial/ajax');

	web.submitData(
		{
			name : 'orange-booking-review.jsf_2', 
			action : 'http://localhost:8079/orange-booking-review.jsf', 
			method : 'POST', 
			recContentType : 'text/xml', 
			referer : 'http://localhost:8079/orange-booking-review.jsf?journeyId=1', 
			snapshot : 't23.inf', 
			mode : 'HTML', 
			encodeAtSign : 'YES', 
			itemData : 
				[
					{ name : 'iceform', value : 'iceform' }, 
					{ name : 'javax.faces.ViewState', value : '{javax.faces.ViewState_1}' }, 
					{ name : 'ice.window', value : '{ice.window}' }, 
					{ name : 'ice.view', value : '{ice.view_1}' }, 
					{ name : 'iceform:travellers', value : '3' }, 
					{ name : 'icefacesCssUpdates', value : '' }, 
					{ name : 'javax.faces.source', value : 'iceform:travellers' }, 
					{ name : 'javax.faces.partial.event', value : 'change' }, 
					{ name : 'javax.faces.partial.execute', value : '@all' }, 
					{ name : 'javax.faces.partial.render', value : '@all' }, 
					{ name : 'ice.window', value : '{ice.window}' }, 
					{ name : 'ice.view', value : '{ice.view_1}' }, 
					{ name : 'ice.focus', value : '' }, 
					{ name : 'ice.event.target', value : 'iceform:travellers' }, 
					{ name : 'ice.event.captured', value : 'iceform:travellers' }, 
					{ name : 'ice.event.type', value : 'onchange' }, 
					{ name : 'ice.submit.type', value : 'ice.s' }, 
					{ name : 'ice.submit.serialization', value : 'form' }, 
					{ name : 'ice.submit.partial', value : 'true' }, 
					{ name : 'javax.faces.partial.ajax', value : 'true' }
				]
		}
	);

	web.addCookie('dtSa=true%7CC%7C-1%7CNext%7C-%7C1530525901177%7C525887767_717%7Chttp%3A%2F%2Flocalhost%3A8079%2Forange-booking-review.jsf%3FjourneyId%3D1%7CeasyTravel%20-%20Booking%20-%20Your%20Journey%7C1530525896884%7C; DOMAIN=localhost');

	web.addCookie('rxvt=1530527701674|1530525649324; DOMAIN=localhost');

	web.addCookie('dtPC=5$525901668_152h1vHMDJCCELBJFMHPCLMOLPGGBDHBPPFEDK; DOMAIN=localhost');

	web.addCookie('dtLatC=55; DOMAIN=localhost');

/*Correlation comment - Do not change!  Original value='6789725570363733081:7162529281004502345' Name ='javax.faces.ViewState_2' Type ='ResponseBased'*/
	web.regSaveParamAttrib(
		{
			paramName : 'javax.faces.ViewState_2', 
			tagName : 'input', 
			extract : 'value', 
			name : 'javax.faces.ViewState', 
			id : 'javax.faces.ViewState', 
			type : 'hidden', 
			ignoreRedirections : 'No', 
			requestUrl : '*/orange-booking-payment.jsf*'
		}
	);

/*Correlation comment - Do not change!  Original value='vkvklffb' Name ='ice.view_2' Type ='ResponseBased'*/
	web.regSaveParamAttrib(
		{
			paramName : 'ice.view_2', 
			tagName : 'input', 
			extract : 'value', 
			name : 'ice.view', 
			type : 'hidden', 
			ignoreRedirections : 'No', 
			requestUrl : '*/orange-booking-payment.jsf*'
		}
	);

	web.url(
		{
			name : 'orange-booking-payment.jsf', 
			url : 'http://localhost:8079/orange-booking-payment.jsf?journeyId=1', 
			resource : 0, 
			recContentType : 'text/html', 
			referer : 'http://localhost:8079/orange-booking-review.jsf?journeyId=1', 
			snapshot : 't24.inf', 
			mode : 'HTML', 
			extraRes :  [
				{url : '/img/booking/stepindicator_2_inactive.png', referer : 'http://localhost:8079/orange-booking-payment.jsf?journeyId=1'},
				{url : '/img/booking/stepindicator_3_active.png', referer : 'http://localhost:8079/orange-booking-payment.jsf?journeyId=1'},
				{url : '/img/booking/Booking_transaction_textbox_large_page_3.png', referer : 'http://localhost:8079/orange-booking-payment.jsf?journeyId=1'},
				{url : '/img/booking/Booking_transaction_textbox_medium2_page_3.png', referer : 'http://localhost:8079/orange-booking-payment.jsf?journeyId=1'},
				{url : '/img/booking/Booking_transaction_textbox_small_page_3.png', referer : 'http://localhost:8079/orange-booking-payment.jsf?journeyId=1'}
			]
		}
	);

	web.convertParam(
		{
			paramName : 'javax.faces.ViewState_2_URL2', 
			sourceString : '{javax.faces.ViewState_2}', 
			sourceEncoding : 'HTML', 
			targetEncoding : 'URL'
		}
	);


	web.addHeader('Faces-Request', 
		'partial/ajax');

	web.submitData(
		{
			name : 'orange-booking-payment.jsf_2', 
			action : 'http://localhost:8079/orange-booking-payment.jsf', 
			method : 'POST', 
			recContentType : 'text/xml', 
			referer : 'http://localhost:8079/orange-booking-payment.jsf?journeyId=1', 
			snapshot : 't26.inf', 
			mode : 'HTML', 
			encodeAtSign : 'YES', 
			itemData : 
				[
					{ name : 'iceform', value : 'iceform' }, 
					{ name : 'javax.faces.ViewState', value : '{javax.faces.ViewState_2}' }, 
					{ name : 'ice.window', value : '{ice.window}' }, 
					{ name : 'ice.view', value : '{ice.view_2}' }, 
					{ name : 'iceform:creditCardType', value : 'VISA' }, 
					{ name : 'iceform:creditCardNumber', value : '' }, 
					{ name : 'iceform:creditCardOwner', value : '' }, 
					{ name : 'iceform:expirationMonth', value : '' }, 
					{ name : 'iceform:expirationYear', value : '' }, 
					{ name : 'iceform:verificationNumber', value : '' }, 
					{ name : 'icefacesCssUpdates', value : '' }, 
					{ name : 'iceform:j_idcl', value : '' }, 
					{ name : 'javax.faces.source', value : 'iceform:j_idt118' }, 
					{ name : 'javax.faces.partial.event', value : 'click' }, 
					{ name : 'javax.faces.partial.execute', value : '@all' }, 
					{ name : 'javax.faces.partial.render', value : '@all' }, 
					{ name : 'ice.window', value : '{ice.window}' }, 
					{ name : 'ice.view', value : '{ice.view_2}' }, 
					{ name : 'ice.focus', value : 'iceform:j_idt118' }, 
					{ name : 'iceform:j_idt118', value : '' }, 
					{ name : 'ice.event.target', value : 'iceform:j_idt118' }, 
					{ name : 'ice.event.captured', value : 'iceform:j_idt118' }, 
					{ name : 'ice.event.type', value : 'onclick' }, 
					{ name : 'ice.event.alt', value : 'false' }, 
					{ name : 'ice.event.ctrl', value : 'false' }, 
					{ name : 'ice.event.shift', value : 'false' }, 
					{ name : 'ice.event.meta', value : 'false' }, 
					{ name : 'ice.event.x', value : '671.2000122070312' }, 
					{ name : 'ice.event.y', value : '468' }, 
					{ name : 'ice.event.left', value : 'true' }, 
					{ name : 'ice.event.right', value : 'false' }, 
					{ name : 'ice.submit.type', value : 'ice.s' }, 
					{ name : 'ice.submit.serialization', value : 'form' }, 
					{ name : 'javax.faces.partial.ajax', value : 'true' }
				]
		}
	);

	
	lr.thinkTime(7);
	web.customRequest(
		{
			name : 'orange-booking-payment.jsf_3', 
			url : 'http://localhost:8079/orange-booking-payment.jsf', 
			method : 'POST', 
			resource : 0, 
			recContentType : 'text/xml', 
			referer : 'http://localhost:8079/orange-booking-payment.jsf?journeyId=1', 
			snapshot : 't28.inf', 
			mode : 'HTML', 
			body : 'iceform=iceform&javax.faces.ViewState={javax.faces.ViewState_2_URL2}&ice.window={ice.window}&ice.view={ice.view_2}&iceform%3AcreditCardType=VISA&iceform%3AcreditCardNumber=1938948611964294055&iceform%3AcreditCardOwner=Armelle%20Pelletier&iceform%3AexpirationMonth=December&iceform%3AexpirationYear=2020&iceform%3AverificationNumber=1302&icefacesCssUpdates=&iceform%3Aj_idcl=&javax.faces.source=iceform%3AbookPaymentNext&javax.faces.partial.event=click&javax.faces.partial.execute=%40all&javax.faces.partial.render=%40all&ice.window={ice.window}&ice.view={ice.view_2}&ice.focus=iceform%3AbookPaymentNext&iceform%3AbookPaymentNext=Next&ice.event.target=iceform%3AbookPaymentNext&ice.event.captured=iceform%3AbookPaymentNext&ice.event.type=onclick&ice.event.alt=false&ice.event.ctrl=false&ice.event.shift=false&ice.event.meta=false&ice.event.x=682.3999633789062&ice.event.y=496&ice.event.left=true&ice.event.right=false&ice.submit.type=ice.s&ice.submit.serialization=form&javax.faces.partial.ajax=true'
		}
	);

	web.addCookie('dtSa=true%7CC%7C-1%7CNext%7C-%7C1530525913827%7C525901668_152%7Chttp%3A%2F%2Flocalhost%3A8079%2Forange-booking-payment.jsf%3FjourneyId%3D1%7CeasyTravel%20-%20Booking%20-%20Payment%7C1530525906874%7C; DOMAIN=localhost');

	web.addCookie('rxvt=1530527715888|1530525649324; DOMAIN=localhost');

	web.addCookie('dtPC=5$525915880_492h1vHMDJCCELBJFMHPCLMOLPGGBDHBPPFEDK; DOMAIN=localhost');

	web.addCookie('dtLatC=82; DOMAIN=localhost');

/*Correlation comment - Do not change!  Original value='-6872181069256417607:-8311538115732693238' Name ='javax.faces.ViewState_3' Type ='ResponseBased'*/
	web.regSaveParamAttrib(
		{
			paramName : 'javax.faces.ViewState_3', 
			tagName : 'input', 
			extract : 'value', 
			name : 'javax.faces.ViewState', 
			id : 'javax.faces.ViewState', 
			type : 'hidden', 
			ignoreRedirections : 'No', 
			requestUrl : '*/orange-booking-finish.jsf*'
		}
	);

/*Correlation comment - Do not change!  Original value='vkvklffc' Name ='ice.view_3' Type ='ResponseBased'*/
	web.regSaveParamAttrib(
		{
			paramName : 'ice.view_3', 
			tagName : 'input', 
			extract : 'value', 
			name : 'ice.view', 
			type : 'hidden', 
			ignoreRedirections : 'No', 
			requestUrl : '*/orange-booking-finish.jsf*'
		}
	);


//web.url(



	web.url(
		{
			name : 'orange-booking-finish.jsf', 
			url : 'http://localhost:8079/orange-booking-finish.jsf?journeyId=1', 
			resource : 0, 
			recContentType : 'text/html', 
			referer : 'http://localhost:8079/orange-booking-payment.jsf?journeyId=1', 
			snapshot : 't29.inf', 
			mode : 'HTML', 
			extraRes :  [
				{url : '/img/booking/Slider_empty.png', referer : 'http://localhost:8079/orange-booking-finish.jsf?journeyId=1'},
				{url : '/img/booking/stepindicator_4_active.png', referer : 'http://localhost:8079/orange-booking-finish.jsf?journeyId=1'}
			]
		}
	);
	

//	web.regFind("Finish");
	


	web.submitData(
		{
			name : 'orange-booking-finish.jsf_2', 
			action : 'http://localhost:8079/orange-booking-finish.jsf', 
			method : 'POST', 
			recContentType : 'text/xml', 
			referer : 'http://localhost:8079/orange-booking-finish.jsf?journeyId=1', 
			snapshot : 't32.inf', 
			mode : 'HTML', 
			encodeAtSign : 'YES', 
			itemData : 
				[
					{ name : 'iceform', value : 'iceform' }, 
					{ name : 'javax.faces.ViewState', value : '{javax.faces.ViewState_3}' }, 
					{ name : 'ice.window', value : '{ice.window}' }, 
					{ name : 'ice.view', value : '{ice.view_3}' }, 
					{ name : 'icefacesCssUpdates', value : '' }, 
					{ name : 'javax.faces.source', value : 'iceform:bookFinishFinish' }, 
					{ name : 'javax.faces.partial.event', value : 'click' }, 
					{ name : 'javax.faces.partial.execute', value : '@all' }, 
					{ name : 'javax.faces.partial.render', value : '@all' }, 
					{ name : 'ice.window', value : '{ice.window}' }, 
					{ name : 'ice.view', value : '{ice.view_3}' }, 
					{ name : 'ice.focus', value : 'iceform:bookFinishFinish' }, 
					{ name : 'iceform:bookFinishFinish', value : 'Finish' }, 
					{ name : 'ice.event.target', value : 'iceform:bookFinishFinish' }, 
					{ name : 'ice.event.captured', value : 'iceform:bookFinishFinish' }, 
					{ name : 'ice.event.type', value : 'onclick' }, 
					{ name : 'ice.event.alt', value : 'false' }, 
					{ name : 'ice.event.ctrl', value : 'false' }, 
					{ name : 'ice.event.shift', value : 'false' }, 
					{ name : 'ice.event.meta', value : 'false' }, 
					{ name : 'ice.event.x', value : '668.7999877929687' }, 
					{ name : 'ice.event.y', value : '492' }, 
					{ name : 'ice.event.left', value : 'true' }, 
					{ name : 'ice.event.right', value : 'false' }, 
					{ name : 'ice.submit.type', value : 'ice.s' }, 
					{ name : 'ice.submit.serialization', value : 'form' }, 
					{ name : 'javax.faces.partial.ajax', value : 'true' }
				]
		}
	);

	web.addCookie('dtSa=true%7CC%7C-1%7CFinish%7C-%7C1530525920851%7C525915880_492%7Chttp%3A%2F%2Flocalhost%3A8079%2Forange-booking-finish.jsf%3FjourneyId%3D1%7CeasyTravel%20-%20Booking%20-%20Finish%7C1530525920970%7C; DOMAIN=localhost');

	web.addCookie('rxvt=1530527722640|1530525649324; DOMAIN=localhost');

	web.addCookie('dtPC=5$525922637_402h1vHMDJCCELBJFMHPCLMOLPGGBDHBPPFEDK; DOMAIN=localhost');

	web.addCookie('dtLatC=29; DOMAIN=localhost');

	web.url(
		{
			name : 'orange-booking-finish.jsf_3', 
			url : 'http://localhost:8079/orange-booking-finish.jsf?success=1&journeyId=1', 
			resource : 0, 
			recContentType : 'text/html', 
			referer : 'http://localhost:8079/orange-booking-finish.jsf?journeyId=1', 
			snapshot : 't33.inf', 
			mode : 'HTML', 
			extraRes :  [
				{url : '/img/gradient/Verlauf_Orange_Button_2.png', referer : 'http://localhost:8079/orange-booking-finish.jsf?success=1&journeyId=1'}
			]
		}
	);


	lr.endTransaction('book journey', lr.AUTO);


	return 0;
}
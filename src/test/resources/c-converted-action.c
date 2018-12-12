Action()
{

	web_add_cookie("rxVisitor=1530534276673RGLPOKT459A1LMBFO13616TBAI7S5Q2Q; DOMAIN=localhost");

	web_add_cookie("dtPC=1$534276621_895h1vIFEDHEFAOHPTKMBFAJCMFLDKJBCJNIBN; DOMAIN=localhost");

	web_add_cookie("rxvt=1530536076750|1530534276697; DOMAIN=localhost");

	web_add_cookie("dtSa=-; DOMAIN=localhost");

	web_add_cookie("rxvt=1530536081459|1530534276697; DOMAIN=localhost");

    // web_url("WRONG_PARAMETER", "URL=https://something.com/", "TargetFrame=", "Resource=0", "RecContentType=text/html");
    lr_start_transaction("GlobalTransaction");

    lr_start_transaction("InitialTransaction");

	addDynatraceHeaderTest("TSN=GlobalTransaction - InitialTransaction;PC=localhost:8079;SI=LoadRunner;LSN=script name;");
	web_url("localhost:8079", 
		"URL=http://localhost:8079/", 
		"Resource=0", 
		"RecContentType=text/html", 
		"Referer=", 
		"Snapshot=t1.inf", 
		"Mode=HTML", 
		EXTRARES, 
		"Url=/img/journey_box.png", ENDITEM, 
		"Url=/img/header.png", ENDITEM, 
		"Url=https://apis.google.com/_/scs/apps-static/_/js/k=oz.gapi.pl.de2wM28ILrc.O/m=plusone/rt=j/sv=1/d=1/ed=1/am=wQ/rs=AGLTcCO5c-Kd6sZuD9hEQyRIuOc1MKFaQA/cb=gapi.loaded_0", ENDITEM, 
		"Url=/img/gradient/Verlauf_Grau_Button_4.png", ENDITEM, 
		"Url=/img/gradient/Verlauf_Orange_Button_4.png", ENDITEM, 
		"Url=/img/gradient/Verlauf_Grau_Loginbox.png", ENDITEM, 
		"Url=/img/searchbox.png", ENDITEM, 
		"Url=/css/css-images/cal_button.gif", ENDITEM, 
		"Url=/img/menupunkt_trennung_transparent.png", ENDITEM, 
		"Url=/css/css-images/ajax-loader.gif", ENDITEM, 
		"Url=/img/gradient/Verlauf_Orange_Hauptfeld.png", ENDITEM, 
		"Url=/img/gradient/Verlauf_Orange_Button_1.png", ENDITEM, 
		"Url=/img/gradient/Verlauf_Grau_ganzeBreite.png", ENDITEM, 
		"Url=/img/gradient/Verlauf_Grau_Hauptfeld.png", ENDITEM, 
		"Url=/img/login/Loginwindow_textbox.png", ENDITEM, 
		"Url=/img/gradient/Verlauf_Grau_Button_3.png", ENDITEM, 
		"Url=http://connect.facebook.net/en_US/all.js", ENDITEM, 
		"Url=/img/menupunkt_auswahl_transparent.png", ENDITEM, 
		"Url=/img/logo_layer_bottom.png", ENDITEM, 
		"Url=/img/booking/Booking_transaction_textbox_medium1_page_3.png", ENDITEM, 
		"Url=https://platform.linkedin.com/js/secureAnonymousFramework?v=1.0.328-1429&lang=en_US", ENDITEM, 
		"Url=https://apis.google.com/_/scs/apps-static/_/js/k=oz.gapi.pl.de2wM28ILrc.O/m=auth/exm=plusone/rt=j/sv=1/d=1/ed=1/am=wQ/rs=AGLTcCO5c-Kd6sZuD9hEQyRIuOc1MKFaQA/cb=gapi.loaded_1", ENDITEM, 
		"Url=http://assets.pinterest.com/js/pinit_main.js?0.47113422356133966", ENDITEM, 
		"Url=http://localhost:8092/image/winter.jpeg", ENDITEM, 
		"Url=https://platform.twitter.com/js/button.efa03583c158eb89fd00b8c75a70efae.js", ENDITEM, 
		"Url=https://static.licdn.com/scds/common/u/images/apps/connect/sprites/sprite_connect_v14.png", ENDITEM, 
		"Url=https://syndication.twitter.com/i/jot?l="
		"%7B%22widget_origin%22%3A%22http%3A%2F%2Flocalhost%3A8079%2F%22%2C%22widget_frame%22%3Afalse%2C%22language%22%3A%22en%22%2C%22message%22%3A%22m%3Awithcount%3A%22%2C%22_category_%22%3A%22tfw_client_event%22%2C%22triggered_on%22%3A1530534286043%2C%22dnt%22%3Afalse%2C%22client_version%22%3A%22910cbce%3A1530167310832%22%2C%22format_version%22%3A1%2C%22event_namespace%22%3A%7B%22client%22%3A%22tfw%22%2C%22page%22%3A%22button%22%2C%22section%22%3A%22follow%22%2C%22action%22%3A%22impression%22%7D%7D", ENDITEM, 
		"Url=/img/header2.jpg", ENDITEM, 
		"Url=https://syndication.twitter.com/i/jot?l="
		"%7B%22widget_origin%22%3A%22http%3A%2F%2Flocalhost%3A8079%2F%22%2C%22widget_frame%22%3Anull%2C%22duration_ms%22%3A19171.83664939617%2C%22_category_%22%3A%22tfw_client_event%22%2C%22triggered_on%22%3A1530534299194%2C%22dnt%22%3Afalse%2C%22client_version%22%3A%22910cbce%3A1530167310832%22%2C%22format_version%22%3A1%2C%22event_namespace%22%3A%7B%22client%22%3A%22tfw%22%2C%22action%22%3A%22render%22%2C%22page%22%3A%22page%22%2C%22component%22%3A%22performance%22%7D%7D", ENDITEM, 
		LAST);

	web_set_sockets_option("SSL_VERSION", "2&3");

	addDynatraceHeaderTest("TSN=GlobalTransaction - InitialTransaction;PC=xaOI6zd9HW9.js;SI=LoadRunner;LSN=script name;");
	web_url("xaOI6zd9HW9.js", 
		"URL=http://staticxx.facebook.com/connect/xd_arbiter/r/xaOI6zd9HW9.js?version=42", 
		"Resource=0", 
		"RecContentType=text/html", 
		"Referer=http://localhost:8079/", 
		"Snapshot=t2.inf", 
		"Mode=HTML", 
		LAST);

	addDynatraceHeaderTest("TSN=GlobalTransaction - InitialTransaction;PC=xaOI6zd9HW9.js_2;SI=LoadRunner;LSN=script name;");
	web_url("xaOI6zd9HW9.js_2", 
		"URL=https://staticxx.facebook.com/connect/xd_arbiter/r/xaOI6zd9HW9.js?version=42", 
		"Resource=0", 
		"RecContentType=text/html", 
		"Referer=http://localhost:8079/", 
		"Snapshot=t3.inf", 
		"Mode=HTML", 
		LAST);

	addDynatraceHeaderTest("TSN=GlobalTransaction - InitialTransaction;PC=fastbutton;SI=LoadRunner;LSN=script name;");
	web_url("fastbutton", 
		"URL=https://apis.google.com/se/0/_/+1/fastbutton?usegapi=1&origin=http%3A%2F%2Flocalhost%3A8079&url=http%3A%2F%2Fwww.dynatrace.com%2F&gsrc=3p&ic=1&jsh=m%3B%2F_%2Fscs%2Fapps-static%2F_%2Fjs%2Fk%3Doz.gapi.pl.de2wM28ILrc.O%2Fm%3D__features__%2Fam%3DwQ%2Frt%3Dj%2Fd%3D1%2Frs%3DAGLTcCO5c-Kd6sZuD9hEQyRIuOc1MKFaQA", 
		"Resource=0", 
		"RecContentType=text/html", 
		"Referer=http://localhost:8079/", 
		"Snapshot=t4.inf", 
		"Mode=HTML", 
		LAST);

	web_add_header("Faces-Request", 
		"partial/ajax");

	addDynatraceHeaderTest("TSN=GlobalTransaction - InitialTransaction;PC=orange.jsf;jsessionid=72EB3CB4C6062B6D52E6E59F8724DFC2.jvmRoute-8280;SI=LoadRunner;LSN=script name;");
	web_submit_data("orange.jsf;jsessionid=72EB3CB4C6062B6D52E6E59F8724DFC2.jvmRoute-8280", 
		"Action=http://localhost:8079/orange.jsf;jsessionid=72EB3CB4C6062B6D52E6E59F8724DFC2.jvmRoute-8280", 
		"Method=POST", 
		"RecContentType=text/xml", 
		"Referer=http://localhost:8079/", 
		"Snapshot=t5.inf", 
		"Mode=HTML", 
		"EncodeAtSign=YES", 
		ITEMDATA, 
		"Name=loginForm", "Value=loginForm", ENDITEM, 
		"Name=javax.faces.ViewState", "Value=-1088058446389217368:-4496397503878788666", ENDITEM, 
		"Name=ice.window", "Value=oqjj48l9qs", ENDITEM, 
		"Name=ice.view", "Value=vfxe7zp71n", ENDITEM, 
		"Name=loginForm:username", "Value=", ENDITEM, 
		"Name=loginForm:password", "Value=", ENDITEM, 
		"Name=icefacesCssUpdates", "Value=", ENDITEM, 
		"Name=loginForm:j_idcl", "Value=loginForm:loginLink", ENDITEM, 
		"Name=javax.faces.source", "Value=loginForm:loginLink", ENDITEM, 
		"Name=javax.faces.partial.event", "Value=click", ENDITEM, 
		"Name=javax.faces.partial.execute", "Value=@all", ENDITEM, 
		"Name=javax.faces.partial.render", "Value=@all", ENDITEM, 
		"Name=ice.window", "Value=oqjj48l9qs", ENDITEM, 
		"Name=ice.view", "Value=vfxe7zp71n", ENDITEM, 
		"Name=ice.focus", "Value=loginForm:loginLink", ENDITEM, 
		"Name=loginForm:loginLink", "Value=loginForm:loginLink", ENDITEM, 
		"Name=ice.event.target", "Value=loginForm:loginLink", ENDITEM, 
		"Name=ice.event.captured", "Value=loginForm:loginLink", ENDITEM, 
		"Name=ice.event.type", "Value=onclick", ENDITEM, 
		"Name=ice.event.alt", "Value=false", ENDITEM, 
		"Name=ice.event.ctrl", "Value=false", ENDITEM, 
		"Name=ice.event.shift", "Value=false", ENDITEM, 
		"Name=ice.event.meta", "Value=false", ENDITEM, 
		"Name=ice.event.x", "Value=1358", ENDITEM, 
		"Name=ice.event.y", "Value=43", ENDITEM, 
		"Name=ice.event.left", "Value=true", ENDITEM, 
		"Name=ice.event.right", "Value=false", ENDITEM, 
		"Name=ice.submit.type", "Value=ice.s", ENDITEM, 
		"Name=ice.submit.serialization", "Value=form", ENDITEM, 
		"Name=javax.faces.partial.ajax", "Value=true", ENDITEM, 
		LAST);

    lr_end_transaction("InitialTransaction", 2);

	addDynatraceHeaderTest("TSN=GlobalTransaction;PC=widget_iframe.bed9e19e565ca3b578705de9e73c29ed.html;SI=LoadRunner;LSN=script name;");
	web_url("widget_iframe.bed9e19e565ca3b578705de9e73c29ed.html", 
		"URL=https://platform.twitter.com/widgets/widget_iframe.bed9e19e565ca3b578705de9e73c29ed.html?origin=http%3A%2F%2Flocalhost%3A8079&settingsEndpoint=https%3A%2F%2Fsyndication.twitter.com%2Fsettings", 
		"Resource=0", 
		"RecContentType=text/html", 
		"Referer=http://localhost:8079/", 
		"Snapshot=t6.inf", 
		"Mode=HTML", 
		LAST);

	addDynatraceHeaderTest("TSN=GlobalTransaction;PC=follow_button.bed9e19e565ca3b578705de9e73c29ed.en.html;SI=LoadRunner;LSN=script name;");
	web_url("follow_button.bed9e19e565ca3b578705de9e73c29ed.en.html", 
		"URL=https://platform.twitter.com/widgets/follow_button.bed9e19e565ca3b578705de9e73c29ed.en.html", 
		"Resource=0", 
		"RecContentType=text/html", 
		"Referer=http://localhost:8079/", 
		"Snapshot=t7.inf", 
		"Mode=HTML", 
		EXTRARES, 
		"Url=https://cdn.syndication.twimg.com/widgets/followbutton/info.json?callback=__twttr.setFollowersCountAndFollowing&lang=en&screen_names=dynatrace", ENDITEM, 
		LAST);

	web_add_cookie("rxvt=1530536086774|1530534276697; DOMAIN=localhost");

	addDynatraceHeaderTest("TSN=GlobalTransaction;PC=rb_1;SI=LoadRunner;LSN=script name;");
	web_custom_request("rb_1", 
		"URL=http://localhost:8079/rb_1?type=js&session=1%2490732712A19CFE460D187D5D153DF84F&svrid=1&flavor=post&referer=http%3A%2F%2Flocalhost%3A8079%2F&visitID=IFEDHEFAOHPTKMBFAJCMFLDKJBCJNIBN", 
		"Method=POST", 
		"Resource=0", 
		"RecContentType=text/plain", 
		"Referer=http://localhost:8079/", 
		"Snapshot=t8.inf", 
		"Mode=HTML", 
		"EncType=text/plain;charset=UTF-8", 
		"Body=$a="
		"1%7C1%7C_load_%7C_load_%7C-%7C1530534276368%7C0%7C329%2C2%7C2%7CUnable%20to%20get%20property%20%27configuration%27%20of%20undefined%20or%20null%20reference%7C_error_%7C-%7C1530534281458%7C1530534281458%7C-1%2C3%7C3%7Chttp%3A%2F%2Flocalhost%3A8079%2Fjavax.faces.resource%2Fbridge.js.jsf%5Esjsessionid%3D72EB3CB4C6062B6D52E6E59F8724DFC2.jvmRoute-8280%3Frand%3D963083509%5Ep42%5Ep13%7C_location_%7C-%7C1530534281459%7C1530534281459%7C-1%2C3%7C4%7CTypeError%3A%20Unable%20to%20get%20property%20%27configura"
		"tion%27%20of%20undefined%20or%20null%20reference%5Ep%20%20%20at%20configurationOf%20%28http%3A%2F%2Flocalhost%3A8079%2Fjavax.faces.resource%2Fbridge.js.jsf%5Esjsessionid%3D72EB3CB4C6062B6D52E6E59F8724DFC2.jvmRoute-8280%3Frand%3D963083509%3A42%3A13%29%5Ep%20%20%20at%20viewIDOf%20%28http%3A%2F%2Flocalhost%3A8079%2Fjavax.faces.resource%2Fbridge.js.jsf%5Esjsessionid%3D72EB3CB4C6062B6D52E6E59F8724DFC2.jvmRoute-8280%3Frand%3D963083509%3A51%3A13%29%5Ep%20%20%20at%20fullSubmit%20%28http%3A%2F%2Flocalhost%"
		"3A8079%2Fjavax.faces.resource%2Fbridge.js.jsf%5Esjsessionid%3D72EB3CB4C6062B6D52E6E59F8724DFC2.jvmRoute-8280%3Frand%3D963083509%3A1928%3A13%29%5Ep%20%20%20at%20submit%20%28http%3A%2F%2Flocalhost%3A8079%2Fjavax.faces.resource%2Fbridge.js.jsf%5Esjsessionid%3D72EB3CB4C6062B6D52E6E59F8724DFC2.jvmRoute-8280%3Frand%3D963083509%3A1986%3A9%29%5Ep%20%20%20at%20aw%20%28http%3A%2F%2Flocalhost%3A8079%2Fjavax.faces.resource%2Fcompat.js.jsf%5Esjsessionid%3D72EB3CB4C6062B6D52E6E59F8724DFC2.jvmRoute-8280%3A1%3A15"
		"331%29%5Ep%20%20%20at%20onclick%20%28http%3A%2F%2Flocalhost%3A8079%2F%3A64%3A213%29%7C_stack_%7C-%7C1530534281460%7C1530534281460%7C-1%2C3%7C5%7C4837%7C_ts_%7C-%7C1530534281461%7C1530534281461%7C-1%2C3%7C6%7CC%5EpLogin%7C_useraction_%7C-%7C1530534281461%7C1530534281461%7C-1$PV=1$rId=RID_2418$rpId=1914199235$url=http%3A%2F%2Flocalhost%3A8079%2F$title=easyTravel%20-%20One%20step%20to%20happiness$visitID=IFEDHEFAOHPTKMBFAJCMFLDKJBCJNIBN$fId=534276621_895$v=10150180628221724$time=1530534286774", 
		LAST);

	addDynatraceHeaderTest("TSN=GlobalTransaction;PC=like.php;SI=LoadRunner;LSN=script name;");
	web_url("like.php", 
		"URL=https://www.facebook.com/plugins/like.php?app_id=&channel=http%3A%2F%2Fstaticxx.facebook.com%2Fconnect%2Fxd_arbiter%2Fr%2FxaOI6zd9HW9.js%3Fversion%3D42%23cb%3Df190f22b0574fe9%26domain%3Dlocalhost%26origin%3Dhttp%253A%252F%252Flocalhost%253A8079%252Ffa68c3fb208807%26relation%3Dparent.parent&container_width=850&font=arial&href=http%3A%2F%2Flocalhost%3A8079%2Fwww.dynatrace.com&locale=en_US&sdk=joey&send=false&show_faces=false&width=300", 
		"Resource=0", 
		"RecContentType=text/html", 
		"Referer=http://localhost:8079/", 
		"Snapshot=t9.inf", 
		"Mode=HTML", 
		LAST);

    lr_end_transaction("GlobalTransaction", 2);

	/*Possible OAUTH authorization was detected. It is recommended to correlate the authorization parameters.*/

	addDynatraceHeaderTest("PC=postmessageRelay;SI=LoadRunner;LSN=script name;");
	web_url("postmessageRelay", 
		"URL=https://accounts.google.com/o/oauth2/postmessageRelay?parent=http%3A%2F%2Flocalhost%3A8079&jsh=m%3B%2F_%2Fscs%2Fapps-static%2F_%2Fjs%2Fk%3Doz.gapi.pl.de2wM28ILrc.O%2Fm%3D__features__%2Fam%3DwQ%2Frt%3Dj%2Fd%3D1%2Frs%3DAGLTcCO5c-Kd6sZuD9hEQyRIuOc1MKFaQA", 
		"Resource=0", 
		"RecContentType=text/html", 
		"Referer=http://localhost:8079/", 
		"Snapshot=t10.inf", 
		"Mode=HTML", 
		LAST);

	addDynatraceHeaderTest("PC=log.pinterest.com;SI=LoadRunner;LSN=script name;");
	web_url("log.pinterest.com", 
		"URL=https://log.pinterest.com/?guid=9HPC4azgtdJ1&tv=2018050702&type=pidget&sub=pl&button_count=1&follow_count=0&pin_count=0&profile_count=0&board_count=0&section_count=0&lang=pl&via=http%3A%2F%2Flocalhost%3A8079%2F&callback=PIN_1530534283557.f.callback[0]", 
		"Resource=0", 
		"Referer=http://localhost:8079/", 
		"Snapshot=t11.inf", 
		"Mode=HTML", 
		EXTRARES, 
		"Url=https://static.xx.fbcdn.net/rsrc.php/v3iEpO4/yY/l/en_US/qpR8vvH3FBB.js", "Referer=https://www.facebook.com/plugins/like.php?app_id=&channel=http%3A%2F%2Fstaticxx.facebook.com%2Fconnect%2Fxd_arbiter%2Fr%2FxaOI6zd9HW9.js%3Fversion%3D42%23cb%3Df190f22b0574fe9%26domain%3Dlocalhost%26origin%3Dhttp%253A%252F%252Flocalhost%253A8079%252Ffa68c3fb208807%26relation%3Dparent.parent&container_width=850&font=arial&href=http%3A%2F%2Flocalhost%3A8079%2Fwww.dynatrace.com&locale=en_US&sdk=joey&send=false&"
		"show_faces=false&width=300", ENDITEM, 
		"Url=https://apis.google.com/_/scs/apps-static/_/js/k=oz.gapi.pl.de2wM28ILrc.O/m=rpc,shindig_random/rt=j/sv=1/d=1/ed=1/am=wQ/rs=AGLTcCO5c-Kd6sZuD9hEQyRIuOc1MKFaQA/cb=gapi.loaded_0", "Referer=https://accounts.google.com/o/oauth2/postmessageRelay?parent=http%3A%2F%2Flocalhost%3A8079&jsh=m%3B%2F_%2Fscs%2Fapps-static%2F_%2Fjs%2Fk%3Doz.gapi.pl.de2wM28ILrc.O%2Fm%3D__features__%2Fam%3DwQ%2Frt%3Dj%2Fd%3D1%2Frs%3DAGLTcCO5c-Kd6sZuD9hEQyRIuOc1MKFaQA", ENDITEM, 
		LAST);

	web_add_header("Origin", 
		"https://platform.twitter.com");

	addDynatraceHeaderTest("PC=settings;SI=LoadRunner;LSN=script name;");
	web_url("settings", 
		"URL=https://syndication.twitter.com/settings", 
		"Resource=0", 
		"RecContentType=application/json", 
		"Referer=https://platform.twitter.com/widgets/widget_iframe.bed9e19e565ca3b578705de9e73c29ed.html?origin=http%3A%2F%2Flocalhost%3A8079&settingsEndpoint=https%3A%2F%2Fsyndication.twitter.com%2Fsettings", 
		"Snapshot=t12.inf", 
		"Mode=HTML", 
		LAST);

	web_add_header("Faces-Request", 
		"partial/ajax");

	addDynatraceHeaderTest("PC=orange.jsf;SI=LoadRunner;LSN=script name;");
	web_submit_data("orange.jsf", 
		"Action=http://localhost:8079/orange.jsf", 
		"Method=POST", 
		"RecContentType=text/xml", 
		"Referer=http://localhost:8079/", 
		"Snapshot=t13.inf", 
		"Mode=HTML", 
		"EncodeAtSign=YES", 
		ITEMDATA, 
		"Name=loginForm", "Value=loginForm", ENDITEM, 
		"Name=javax.faces.ViewState", "Value=-1088058446389217368:-4496397503878788666", ENDITEM, 
		"Name=ice.window", "Value=oqjj48l9qs", ENDITEM, 
		"Name=ice.view", "Value=vfxe7zp71n", ENDITEM, 
		"Name=loginForm:username", "Value=labuser", ENDITEM, 
		"Name=loginForm:password", "Value=labpass", ENDITEM, 
		"Name=icefacesCssUpdates", "Value=", ENDITEM, 
		"Name=loginForm:j_idcl", "Value=", ENDITEM, 
		"Name=javax.faces.source", "Value=loginForm:password", ENDITEM, 
		"Name=javax.faces.partial.event", "Value=keypress", ENDITEM, 
		"Name=javax.faces.partial.execute", "Value=@all", ENDITEM, 
		"Name=javax.faces.partial.render", "Value=@all", ENDITEM, 
		"Name=ice.window", "Value=oqjj48l9qs", ENDITEM, 
		"Name=ice.view", "Value=vfxe7zp71n", ENDITEM, 
		"Name=ice.focus", "Value=loginForm:password", ENDITEM, 
		"Name=ice.event.target", "Value=loginForm:password", ENDITEM, 
		"Name=ice.event.captured", "Value=loginForm:password", ENDITEM, 
		"Name=ice.event.type", "Value=onkeypress", ENDITEM, 
		"Name=ice.event.alt", "Value=false", ENDITEM, 
		"Name=ice.event.ctrl", "Value=false", ENDITEM, 
		"Name=ice.event.shift", "Value=false", ENDITEM, 
		"Name=ice.event.meta", "Value=false", ENDITEM, 
		"Name=ice.event.keycode", "Value=13", ENDITEM, 
		"Name=ice.submit.type", "Value=ice.s", ENDITEM, 
		"Name=ice.submit.serialization", "Value=form", ENDITEM, 
		"Name=javax.faces.partial.ajax", "Value=true", ENDITEM, 
		LAST);

	web_add_cookie("rxvt=1530536095351|1530534276697; DOMAIN=localhost");

	addDynatraceHeaderTest("PC=rb_1_2;SI=LoadRunner;LSN=script name;");
	web_custom_request("rb_1_2", 
		"URL=http://localhost:8079/rb_1?type=js&session=1%2490732712A19CFE460D187D5D153DF84F%7CRUM%2BDefault%2BApplication%7C1&svrid=1&flavor=post&referer=http%3A%2F%2Flocalhost%3A8079%2F&visitID=IFEDHEFAOHPTKMBFAJCMFLDKJBCJNIBN", 
		"Method=POST", 
		"Resource=0", 
		"RecContentType=text/plain", 
		"Referer=http://localhost:8079/", 
		"Snapshot=t14.inf", 
		"Mode=HTML", 
		"EncType=text/plain;charset=UTF-8", 
		"Body=$a=1%7C7%7Crx_visittag%3Dlabuser%7C_rs_%7C-%7C1530534295347%7C1530534295347%7C331$rId=RID_2418$rpId=1914199235$domR=1530534282880$fd=j1.8.1^so1.7^six$url=http%3A%2F%2Flocalhost%3A8079%2F$title=easyTravel%20-%20One%20step%20to%20happiness$vd=8576$visitID=IFEDHEFAOHPTKMBFAJCMFLDKJBCJNIBN$fId=534276621_895$v=10150180628221724$vID=1530534276673RGLPOKT459A1LMBFO13616TBAI7S5Q2Q$nV=1$nVAT=1$time=1530534295351", 
		EXTRARES, 
		"Url=/img/favicon_orange_plane.ico", "Referer=", ENDITEM, 
		LAST);

	web_add_cookie("dtPC=1$534276621_895h8vIFEDHEFAOHPTKMBFAJCMFLDKJBCJNIBN; DOMAIN=localhost");

	web_add_cookie("rxvt=1530536099060|1530534276697; DOMAIN=localhost");

	web_add_cookie("dtCookie=1$90732712A19CFE460D187D5D153DF84F|RUM+Default+Application|1; DOMAIN=localhost");

	web_add_auto_header("X-Requested-With", 
		"XMLHttpRequest");

	addDynatraceHeaderTest("PC=CalculateRecommendations;SI=LoadRunner;LSN=script name;");
	web_custom_request("CalculateRecommendations", 
		"URL=http://localhost:8079/CalculateRecommendations?_=1530534300070", 
		"Method=GET", 
		"Resource=0", 
		"RecContentType=text/html", 
		"Referer=http://localhost:8079/", 
		"Snapshot=t15.inf", 
		"Mode=HTML", 
		"EncType=application/x-www-form-urlencoded; charset=UTF-8", 
		LAST);

	web_revert_auto_header("X-Requested-With");

	addDynatraceHeaderTest("PC=CalculateRecommendations_2;SI=LoadRunner;LSN=script name;");
	web_custom_request("CalculateRecommendations_2", 
		"URL=http://localhost:8079/CalculateRecommendations?_=1530534300072", 
		"Method=GET", 
		"Resource=0", 
		"RecContentType=text/html", 
		"Referer=http://localhost:8079/", 
		"Snapshot=t16.inf", 
		"Mode=HTML", 
		"EncType=application/x-www-form-urlencoded; charset=UTF-8", 
		LAST);

	web_add_cookie("rxvt=1530536101888|1530534276697; DOMAIN=localhost");

	web_add_cookie("dtSa=true%7CC%7C-1%7CBook%20Now%7C-%7C1530534301830%7C534276621_895%7Chttp%3A%2F%2Flocalhost%3A8079%2F%7CeasyTravel%20-%20One%20step%20to%20happiness%7C1530534295353%7C; DOMAIN=localhost");

	addDynatraceHeaderTest("PC=BookNow;SI=LoadRunner;LSN=script name;");
	web_link("Book Now", 
		"Text=Book Now", 
		"Ordinal=1", 
		"Snapshot=t17.inf", 
		LAST);

	web_add_cookie("dtPC=1$534302214_201h1vIFEDHEFAOHPTKMBFAJCMFLDKJBCJNIBN; DOMAIN=localhost");

	web_add_cookie("rxvt=1530536102217|1530534276697; DOMAIN=localhost");

	web_add_cookie("dtLatC=37; DOMAIN=localhost");

	addDynatraceHeaderTest("PC=rb_1_3;SI=LoadRunner;LSN=script name;");
	web_custom_request("rb_1_3", 
		"URL=http://localhost:8079/rb_1?type=js&session=1%2490732712A19CFE460D187D5D153DF84F%7CRUM%2BDefault%2BApplication%7C1&svrid=1&flavor=post&referer=http%3A%2F%2Flocalhost%3A8079%2F&visitID=IFEDHEFAOHPTKMBFAJCMFLDKJBCJNIBN", 
		"Method=POST", 
		"Resource=0", 
		"RecContentType=text/plain", 
		"Referer=http://localhost:8079/", 
		"Snapshot=t18.inf", 
		"Mode=HTML", 
		"EncType=text/plain;charset=UTF-8", 
		"Body=$a="
		"1%7C1%7C_load_%7C_load_%7C-%7C1530534276368%7C0%7C329%2C2%7C2%7CUnable%20to%20get%20property%20%27configuration%27%20of%20undefined%20or%20null%20reference%7C_error_%7C-%7C1530534281458%7C1530534281461%7C-1%2C3%7C3%7Chttp%3A%2F%2Flocalhost%3A8079%2Fjavax.faces.resource%2Fbridge.js.jsf%5Esjsessionid%3D72EB3CB4C6062B6D52E6E59F8724DFC2.jvmRoute-8280%3Frand%3D963083509%5Ep42%5Ep13%7C_location_%7C-%7C1530534281459%7C1530534281459%7C-1%2C3%7C4%7CTypeError%3A%20Unable%20to%20get%20property%20%27configura"
		"tion%27%20of%20undefined%20or%20null%20reference%5Ep%20%20%20at%20configurationOf%20%28http%3A%2F%2Flocalhost%3A8079%2Fjavax.faces.resource%2Fbridge.js.jsf%5Esjsessionid%3D72EB3CB4C6062B6D52E6E59F8724DFC2.jvmRoute-8280%3Frand%3D963083509%3A42%3A13%29%5Ep%20%20%20at%20viewIDOf%20%28http%3A%2F%2Flocalhost%3A8079%2Fjavax.faces.resource%2Fbridge.js.jsf%5Esjsessionid%3D72EB3CB4C6062B6D52E6E59F8724DFC2.jvmRoute-8280%3Frand%3D963083509%3A51%3A13%29%5Ep%20%20%20at%20fullSubmit%20%28http%3A%2F%2Flocalhost%"
		"3A8079%2Fjavax.faces.resource%2Fbridge.js.jsf%5Esjsessionid%3D72EB3CB4C6062B6D52E6E59F8724DFC2.jvmRoute-8280%3Frand%3D963083509%3A1928%3A13%29%5Ep%20%20%20at%20submit%20%28http%3A%2F%2Flocalhost%3A8079%2Fjavax.faces.resource%2Fbridge.js.jsf%5Esjsessionid%3D72EB3CB4C6062B6D52E6E59F8724DFC2.jvmRoute-8280%3Frand%3D963083509%3A1986%3A9%29%5Ep%20%20%20at%20aw%20%28http%3A%2F%2Flocalhost%3A8079%2Fjavax.faces.resource%2Fcompat.js.jsf%5Esjsessionid%3D72EB3CB4C6062B6D52E6E59F8724DFC2.jvmRoute-8280%3A1%3A15"
		"331%29%5Ep%20%20%20at%20onclick%20%28http%3A%2F%2Flocalhost%3A8079%2F%3A64%3A213%29%7C_stack_%7C-%7C1530534281460%7C1530534281460%7C-1%2C3%7C5%7C4837%7C_ts_%7C-%7C1530534281461%7C1530534281461%7C-1%2C3%7C6%7CC%5EpLogin%7C_useraction_%7C-%7C1530534281461%7C1530534281461%7C-1%2C2%7C8%7C_onload_%7C_load_%7C-%7C1530534299060%7C0%7C329$rId=RID_2418$rpId=1914199235$domR=1530534299059$w=1920$h=1082$sw=1920$sh=1200$nt=a0b1530534276368e0f0g0h0i0k0l0m58n0o6512p6512q6635r22691s22693t22693$V=22560|c$S="
		"9322$url=http%3A%2F%2Flocalhost%3A8079%2F$title=easyTravel%20-%20One%20step%20to%20happiness$isUnload=true$visitID=IFEDHEFAOHPTKMBFAJCMFLDKJBCJNIBN$fId=534276621_895$v=10150180628221724$vID=1530534276673RGLPOKT459A1LMBFO13616TBAI7S5Q2Q$nV=1$time=1530534301888", 
		EXTRARES, 
		"Url=/img/booking/stepindicator.png", "Referer=http://localhost:8079/orange-booking-review.jsf?journeyId=9449", ENDITEM, 
		"Url=/img/booking/Slider_empty_shadow.png", "Referer=http://localhost:8079/orange-booking-review.jsf?journeyId=9449", ENDITEM, 
		"Url=/img/booking/stepindicator_1_inactive.png", "Referer=http://localhost:8079/orange-booking-review.jsf?journeyId=9449", ENDITEM, 
		"Url=/img/booking/stepindicator_2_active.png", "Referer=http://localhost:8079/orange-booking-review.jsf?journeyId=9449", ENDITEM, 
		"Url=/img/booking/stepindicator_3_inactive.png", "Referer=http://localhost:8079/orange-booking-review.jsf?journeyId=9449", ENDITEM, 
		"Url=/img/booking/stepindicator_4_inactive.png", "Referer=http://localhost:8079/orange-booking-review.jsf?journeyId=9449", ENDITEM, 
		"Url=/img/gradient/Verlauf_Grau_Button_1.png", "Referer=http://localhost:8079/orange-booking-review.jsf?journeyId=9449", ENDITEM, 
		LAST);

	addDynatraceHeaderTest("PC=widget_iframe.bed9e19e565ca3b578705de9e73c29ed.html_2;SI=LoadRunner;LSN=script name;");
	web_url("widget_iframe.bed9e19e565ca3b578705de9e73c29ed.html_2", 
		"URL=https://platform.twitter.com/widgets/widget_iframe.bed9e19e565ca3b578705de9e73c29ed.html?origin=http%3A%2F%2Flocalhost%3A8079&settingsEndpoint=https%3A%2F%2Fsyndication.twitter.com%2Fsettings", 
		"Resource=0", 
		"RecContentType=text/html", 
		"Referer=http://localhost:8079/orange-booking-review.jsf?journeyId=9449", 
		"Snapshot=t19.inf", 
		"Mode=HTML", 
		LAST);

	addDynatraceHeaderTest("PC=fastbutton_2;SI=LoadRunner;LSN=script name;");
	web_url("fastbutton_2", 
		"URL=https://apis.google.com/se/0/_/+1/fastbutton?usegapi=1&origin=http%3A%2F%2Flocalhost%3A8079&url=http%3A%2F%2Fwww.dynatrace.com%2F&gsrc=3p&ic=1&jsh=m%3B%2F_%2Fscs%2Fapps-static%2F_%2Fjs%2Fk%3Doz.gapi.pl.de2wM28ILrc.O%2Fm%3D__features__%2Fam%3DwQ%2Frt%3Dj%2Fd%3D1%2Frs%3DAGLTcCO5c-Kd6sZuD9hEQyRIuOc1MKFaQA", 
		"Resource=0", 
		"RecContentType=text/html", 
		"Referer=http://localhost:8079/orange-booking-review.jsf?journeyId=9449", 
		"Snapshot=t20.inf", 
		"Mode=HTML", 
		LAST);

	addDynatraceHeaderTest("PC=postmessageRelay_2;SI=LoadRunner;LSN=script name;");
	web_url("postmessageRelay_2", 
		"URL=https://accounts.google.com/o/oauth2/postmessageRelay?parent=http%3A%2F%2Flocalhost%3A8079&jsh=m%3B%2F_%2Fscs%2Fapps-static%2F_%2Fjs%2Fk%3Doz.gapi.pl.de2wM28ILrc.O%2Fm%3D__features__%2Fam%3DwQ%2Frt%3Dj%2Fd%3D1%2Frs%3DAGLTcCO5c-Kd6sZuD9hEQyRIuOc1MKFaQA", 
		"Resource=0", 
		"RecContentType=text/html", 
		"Referer=http://localhost:8079/orange-booking-review.jsf?journeyId=9449", 
		"Snapshot=t21.inf", 
		"Mode=HTML", 
		EXTRARES, 
		"Url=http://assets.pinterest.com/js/pinit_main.js?0.14202571753375087", "Referer=http://localhost:8079/orange-booking-review.jsf?journeyId=9449", ENDITEM, 
		LAST);

	addDynatraceHeaderTest("PC=xaOI6zd9HW9.js_3;SI=LoadRunner;LSN=script name;");
	web_url("xaOI6zd9HW9.js_3", 
		"URL=https://staticxx.facebook.com/connect/xd_arbiter/r/xaOI6zd9HW9.js?version=42", 
		"Resource=0", 
		"RecContentType=text/html", 
		"Referer=http://localhost:8079/orange-booking-review.jsf?journeyId=9449", 
		"Snapshot=t22.inf", 
		"Mode=HTML", 
		LAST);

	addDynatraceHeaderTest("PC=follow_button.bed9e19e565ca3b578705de9e73c29ed.en.html_2;SI=LoadRunner;LSN=script name;");
	web_url("follow_button.bed9e19e565ca3b578705de9e73c29ed.en.html_2", 
		"URL=https://platform.twitter.com/widgets/follow_button.bed9e19e565ca3b578705de9e73c29ed.en.html", 
		"Resource=0", 
		"RecContentType=text/html", 
		"Referer=http://localhost:8079/orange-booking-review.jsf?journeyId=9449", 
		"Snapshot=t23.inf", 
		"Mode=HTML", 
		LAST);

	addDynatraceHeaderTest("PC=like.php_2;SI=LoadRunner;LSN=script name;");
	web_url("like.php_2", 
		"URL=https://www.facebook.com/plugins/like.php?app_id=&channel=http%3A%2F%2Fstaticxx.facebook.com%2Fconnect%2Fxd_arbiter%2Fr%2FxaOI6zd9HW9.js%3Fversion%3D42%23cb%3Df316dfbb4fc305%26domain%3Dlocalhost%26origin%3Dhttp%253A%252F%252Flocalhost%253A8079%252Ffcc19db8c7ed06%26relation%3Dparent.parent&container_width=850&font=arial&href=http%3A%2F%2Flocalhost%3A8079%2Fwww.dynatrace.com&locale=en_US&sdk=joey&send=false&show_faces=false&width=300", 
		"Resource=0", 
		"RecContentType=text/html", 
		"Referer=http://localhost:8079/orange-booking-review.jsf?journeyId=9449", 
		"Snapshot=t24.inf", 
		"Mode=HTML", 
		LAST);

	addDynatraceHeaderTest("PC=jot;SI=LoadRunner;LSN=script name;");
	web_submit_data("jot", 
		"Action=https://syndication.twitter.com/i/jot", 
		"Method=POST", 
		"RecContentType=text/html", 
		"Referer=", 
		"Snapshot=t25.inf", 
		"Mode=HTML", 
		ITEMDATA, 
		"Name=dnt", "Value=0", ENDITEM, 
		"Name=tfw_redirect", "Value=https://platform.twitter.com/jot.html", ENDITEM, 
		"Name=l", "Value={\"widget_origin\":\"http://localhost:8079/orange-booking-review.jsf?journeyId=9449\",\"widget_frame\":false,\"language\":\"en\",\"message\":\"m:withcount:\",\"_category_\":\"tfw_client_event\",\"triggered_on\":1530534303102,\"dnt\":false,\"client_version\":\"910cbce:1530167310832\",\"format_version\":1,\"event_namespace\":{\"client\":\"tfw\",\"page\":\"button\",\"section\":\"follow\",\"action\":\"impression\"}}", ENDITEM, 
		"Name=l", "Value={\"widget_origin\":\"http://localhost:8079/orange-booking-review.jsf?journeyId=9449\",\"widget_frame\":null,\"duration_ms\":396.67223849993274,\"_category_\":\"tfw_client_event\",\"triggered_on\":1530534303102,\"dnt\":false,\"client_version\":\"910cbce:1530167310832\",\"format_version\":1,\"event_namespace\":{\"client\":\"tfw\",\"action\":\"render\",\"page\":\"page\",\"component\":\"performance\"}}", ENDITEM, 
		LAST);

	addDynatraceHeaderTest("PC=log.pinterest.com_2;SI=LoadRunner;LSN=script name;");
	web_url("log.pinterest.com_2", 
		"URL=https://log.pinterest.com/?guid=iW6oinQMeQzY&tv=2018050702&type=pidget&sub=pl&button_count=1&follow_count=0&pin_count=0&profile_count=0&board_count=0&section_count=0&lang=pl&via=http%3A%2F%2Flocalhost%3A8079%2Forange-booking-review.jsf%3FjourneyId%3D9449&callback=PIN_1530534302668.f.callback[0]", 
		"Resource=0", 
		"Referer=http://localhost:8079/orange-booking-review.jsf?journeyId=9449", 
		"Snapshot=t26.inf", 
		"Mode=HTML", 
		LAST);

	web_add_cookie("rxvt=1530536105105|1530534276697; DOMAIN=localhost");

	web_add_cookie("dtSa=true%7CC%7C-1%7CNext%7C-%7C1530534305045%7C534302214_201%7Chttp%3A%2F%2Flocalhost%3A8079%2Forange-booking-review.jsf%3FjourneyId%3D9449%7CeasyTravel%20-%20Booking%20-%20Your%20Journey%7C1530534295353%7C; DOMAIN=localhost");

	addDynatraceHeaderTest("PC=orange-booking-payment.jsf;SI=LoadRunner;LSN=script name;");
	web_url("orange-booking-payment.jsf", 
		"URL=http://localhost:8079/orange-booking-payment.jsf?journeyId=9449", 
		"Resource=0", 
		"RecContentType=text/html", 
		"Referer=http://localhost:8079/orange-booking-review.jsf?journeyId=9449", 
		"Snapshot=t27.inf", 
		"Mode=HTML", 
		LAST);

	web_add_cookie("dtPC=1$534305430_219h1vIFEDHEFAOHPTKMBFAJCMFLDKJBCJNIBN; DOMAIN=localhost");

	web_add_cookie("rxvt=1530536105433|1530534276697; DOMAIN=localhost");

	web_add_cookie("dtLatC=39; DOMAIN=localhost");

	addDynatraceHeaderTest("PC=rb_1_4;SI=LoadRunner;LSN=script name;");
	web_custom_request("rb_1_4", 
		"URL=http://localhost:8079/rb_1?type=js&session=1%2490732712A19CFE460D187D5D153DF84F%7CRUM%2BDefault%2BApplication%7C1&svrid=1&flavor=post&referer=http%3A%2F%2Flocalhost%3A8079%2Forange-booking-review.jsf%3FjourneyId%3D9449&visitID=IFEDHEFAOHPTKMBFAJCMFLDKJBCJNIBN", 
		"Method=POST", 
		"Resource=0", 
		"RecContentType=text/plain", 
		"Referer=http://localhost:8079/orange-booking-review.jsf?journeyId=9449", 
		"Snapshot=t28.inf", 
		"Mode=HTML", 
		"EncType=text/plain;charset=UTF-8", 
		"Body=$a=d%7C-1%7CBook%20Now%7CC%7C-%7C534276621_895%7C1530534301830%7Chttp%3A%2F%2Flocalhost%3A8079%2F%7CeasyTravel%20-%20One%20step%20to%20happiness%2C1%7C1%7C_load_%7C_load_%7C-%7C1530534301893%7C0%7C286%7C-%7C-%7C-%7C-%7C-%7Chttp%3A%2F%2Flocalhost%3A8079%2F%2C2%7C2%7C_onload_%7C_load_%7C-%7C1530534303281%7C1530534303283%7C286$rId=RID_876237400$rpId=-195975343$domR=1530534303280$w=1920$h=1082$sw=1920$sh=1200$nt=a0b1530534301893e39f39g39h39i39k75l79m83n79o492p492q562r1387s1388t1390$V=1022|c$S="
		"463$fd=j1.8.1^so1.7^six$url=http%3A%2F%2Flocalhost%3A8079%2Forange-booking-review.jsf%3FjourneyId%3D9449$title=easyTravel%20-%20Booking%20-%20Your%20Journey$vd=9750$isUnload=true$latC=37$visitID=IFEDHEFAOHPTKMBFAJCMFLDKJBCJNIBN$fId=534302214_201$v=10150180628221724$vID=1530534276673RGLPOKT459A1LMBFO13616TBAI7S5Q2Q$time=1530534305105", 
		EXTRARES, 
		"Url=/img/booking/Booking_transaction_textbox_large_page_3.png", "Referer=http://localhost:8079/orange-booking-payment.jsf?journeyId=9449", ENDITEM, 
		"Url=/img/booking/stepindicator_3_active.png", "Referer=http://localhost:8079/orange-booking-payment.jsf?journeyId=9449", ENDITEM, 
		"Url=/img/booking/stepindicator_2_inactive.png", "Referer=http://localhost:8079/orange-booking-payment.jsf?journeyId=9449", ENDITEM, 
		"Url=/img/booking/Booking_transaction_textbox_small_page_3.png", "Referer=http://localhost:8079/orange-booking-payment.jsf?journeyId=9449", ENDITEM, 
		"Url=/img/booking/Booking_transaction_textbox_medium2_page_3.png", "Referer=http://localhost:8079/orange-booking-payment.jsf?journeyId=9449", ENDITEM, 
		LAST);

	addDynatraceHeaderTest("PC=widget_iframe.bed9e19e565ca3b578705de9e73c29ed.html_3;SI=LoadRunner;LSN=script name;");
	web_url("widget_iframe.bed9e19e565ca3b578705de9e73c29ed.html_3", 
		"URL=https://platform.twitter.com/widgets/widget_iframe.bed9e19e565ca3b578705de9e73c29ed.html?origin=http%3A%2F%2Flocalhost%3A8079&settingsEndpoint=https%3A%2F%2Fsyndication.twitter.com%2Fsettings", 
		"Resource=0", 
		"RecContentType=text/html", 
		"Referer=http://localhost:8079/orange-booking-payment.jsf?journeyId=9449", 
		"Snapshot=t29.inf", 
		"Mode=HTML", 
		LAST);

	addDynatraceHeaderTest("PC=fastbutton_3;SI=LoadRunner;LSN=script name;");
	web_url("fastbutton_3", 
		"URL=https://apis.google.com/se/0/_/+1/fastbutton?usegapi=1&origin=http%3A%2F%2Flocalhost%3A8079&url=http%3A%2F%2Fwww.dynatrace.com%2F&gsrc=3p&ic=1&jsh=m%3B%2F_%2Fscs%2Fapps-static%2F_%2Fjs%2Fk%3Doz.gapi.pl.de2wM28ILrc.O%2Fm%3D__features__%2Fam%3DwQ%2Frt%3Dj%2Fd%3D1%2Frs%3DAGLTcCO5c-Kd6sZuD9hEQyRIuOc1MKFaQA", 
		"Resource=0", 
		"RecContentType=text/html", 
		"Referer=http://localhost:8079/orange-booking-payment.jsf?journeyId=9449", 
		"Snapshot=t30.inf", 
		"Mode=HTML", 
		LAST);

	addDynatraceHeaderTest("PC=postmessageRelay_3;SI=LoadRunner;LSN=script name;");
	web_url("postmessageRelay_3", 
		"URL=https://accounts.google.com/o/oauth2/postmessageRelay?parent=http%3A%2F%2Flocalhost%3A8079&jsh=m%3B%2F_%2Fscs%2Fapps-static%2F_%2Fjs%2Fk%3Doz.gapi.pl.de2wM28ILrc.O%2Fm%3D__features__%2Fam%3DwQ%2Frt%3Dj%2Fd%3D1%2Frs%3DAGLTcCO5c-Kd6sZuD9hEQyRIuOc1MKFaQA", 
		"Resource=0", 
		"RecContentType=text/html", 
		"Referer=http://localhost:8079/orange-booking-payment.jsf?journeyId=9449", 
		"Snapshot=t31.inf", 
		"Mode=HTML", 
		EXTRARES, 
		"Url=http://assets.pinterest.com/js/pinit_main.js?0.17254513468103805", "Referer=http://localhost:8079/orange-booking-payment.jsf?journeyId=9449", ENDITEM, 
		LAST);

	addDynatraceHeaderTest("PC=follow_button.bed9e19e565ca3b578705de9e73c29ed.en.html_3;SI=LoadRunner;LSN=script name;");
	web_url("follow_button.bed9e19e565ca3b578705de9e73c29ed.en.html_3", 
		"URL=https://platform.twitter.com/widgets/follow_button.bed9e19e565ca3b578705de9e73c29ed.en.html", 
		"Resource=0", 
		"RecContentType=text/html", 
		"Referer=http://localhost:8079/orange-booking-payment.jsf?journeyId=9449", 
		"Snapshot=t32.inf", 
		"Mode=HTML", 
		LAST);

	addDynatraceHeaderTest("PC=xaOI6zd9HW9.js_4;SI=LoadRunner;LSN=script name;");
	web_url("xaOI6zd9HW9.js_4", 
		"URL=https://staticxx.facebook.com/connect/xd_arbiter/r/xaOI6zd9HW9.js?version=42", 
		"Resource=0", 
		"RecContentType=text/html", 
		"Referer=http://localhost:8079/orange-booking-payment.jsf?journeyId=9449", 
		"Snapshot=t33.inf", 
		"Mode=HTML", 
		LAST);

	addDynatraceHeaderTest("PC=like.php_3;SI=LoadRunner;LSN=script name;");
	web_url("like.php_3", 
		"URL=https://www.facebook.com/plugins/like.php?app_id=&channel=http%3A%2F%2Fstaticxx.facebook.com%2Fconnect%2Fxd_arbiter%2Fr%2FxaOI6zd9HW9.js%3Fversion%3D42%23cb%3Df1715feb5ee6ba%26domain%3Dlocalhost%26origin%3Dhttp%253A%252F%252Flocalhost%253A8079%252Ff3ac65e10671c38%26relation%3Dparent.parent&container_width=850&font=arial&href=http%3A%2F%2Flocalhost%3A8079%2Fwww.dynatrace.com&locale=en_US&sdk=joey&send=false&show_faces=false&width=300", 
		"Resource=0", 
		"RecContentType=text/html", 
		"Referer=http://localhost:8079/orange-booking-payment.jsf?journeyId=9449", 
		"Snapshot=t34.inf", 
		"Mode=HTML", 
		LAST);

	addDynatraceHeaderTest("PC=log.pinterest.com_3;SI=LoadRunner;LSN=script name;");
	web_url("log.pinterest.com_3", 
		"URL=https://log.pinterest.com/?guid=oT55CHQX324F&tv=2018050702&type=pidget&sub=pl&button_count=1&follow_count=0&pin_count=0&profile_count=0&board_count=0&section_count=0&lang=pl&via=http%3A%2F%2Flocalhost%3A8079%2Forange-booking-payment.jsf%3FjourneyId%3D9449&callback=PIN_1530534305917.f.callback[0]", 
		"Resource=0", 
		"Referer=http://localhost:8079/orange-booking-payment.jsf?journeyId=9449", 
		"Snapshot=t35.inf", 
		"Mode=HTML", 
		LAST);

	addDynatraceHeaderTest("PC=jot_2;SI=LoadRunner;LSN=script name;");
	web_submit_data("jot_2", 
		"Action=https://syndication.twitter.com/i/jot", 
		"Method=POST", 
		"RecContentType=text/html", 
		"Referer=", 
		"Snapshot=t36.inf", 
		"Mode=HTML", 
		ITEMDATA, 
		"Name=dnt", "Value=0", ENDITEM, 
		"Name=tfw_redirect", "Value=https://platform.twitter.com/jot.html", ENDITEM, 
		"Name=l", "Value={\"widget_origin\":\"http://localhost:8079/orange-booking-payment.jsf?journeyId=9449\",\"widget_frame\":false,\"language\":\"en\",\"message\":\"m:withcount:\",\"_category_\":\"tfw_client_event\",\"triggered_on\":1530534306731,\"dnt\":false,\"client_version\":\"910cbce:1530167310832\",\"format_version\":1,\"event_namespace\":{\"client\":\"tfw\",\"page\":\"button\",\"section\":\"follow\",\"action\":\"impression\"}}", ENDITEM, 
		"Name=l", "Value={\"widget_origin\":\"http://localhost:8079/orange-booking-payment.jsf?journeyId=9449\",\"widget_frame\":null,\"duration_ms\":773.5584342568816,\"_category_\":\"tfw_client_event\",\"triggered_on\":1530534306731,\"dnt\":false,\"client_version\":\"910cbce:1530167310832\",\"format_version\":1,\"event_namespace\":{\"client\":\"tfw\",\"action\":\"render\",\"page\":\"page\",\"component\":\"performance\"}}", ENDITEM, 
		LAST);

	web_add_cookie("rxvt=1530536108515|1530534276697; DOMAIN=localhost");

	addDynatraceHeaderTest("PC=rb_1_5;SI=LoadRunner;LSN=script name;");
	web_custom_request("rb_1_5", 
		"URL=http://localhost:8079/rb_1?type=js&session=1%2490732712A19CFE460D187D5D153DF84F%7CRUM%2BDefault%2BApplication%7C1&svrid=1&flavor=post&referer=http%3A%2F%2Flocalhost%3A8079%2Forange-booking-payment.jsf%3FjourneyId%3D9449&visitID=IFEDHEFAOHPTKMBFAJCMFLDKJBCJNIBN", 
		"Method=POST", 
		"Resource=0", 
		"RecContentType=text/plain", 
		"Referer=http://localhost:8079/orange-booking-payment.jsf?journeyId=9449", 
		"Snapshot=t37.inf", 
		"Mode=HTML", 
		"EncType=text/plain;charset=UTF-8", 
		"Body=$a=d%7C-1%7CNext%7CC%7C-%7C534302214_201%7C1530534305045%7Chttp%3A%2F%2Flocalhost%3A8079%2Forange-booking-review.jsf%3FjourneyId%3D9449%7CeasyTravel%20-%20Booking%20-%20Your%20Journey%2C1%7C1%7C_load_%7C_load_%7C-%7C1530534305110%7C1530534306558%7C279%7C-%7C-%7C-%7C-%7C-%7Chttp%3A%2F%2Flocalhost%3A8079%2Forange-booking-review.jsf%3FjourneyId%3D9449%2C2%7C2%7C_onload_%7C_load_%7C-%7C1530534306556%7C1530534306558%7C278$rId=RID_359402546$rpId=934729829$domR=1530534306555$w=1920$h=1082$sw=1920$sh"
		"=1200$nt=a0b1530534305110e50f50g50h50i50k78l81m84n81o501p501q565r1445s1446t1448$V=866|c$S=445$fd=j1.8.1^so1.7^six$url=http%3A%2F%2Flocalhost%3A8079%2Forange-booking-payment.jsf%3FjourneyId%3D9449$title=easyTravel%20-%20Booking%20-%20Payment$vd=13161$latC=39$visitID=IFEDHEFAOHPTKMBFAJCMFLDKJBCJNIBN$fId=534305430_219$v=10150180628221724$vID=1530534276673RGLPOKT459A1LMBFO13616TBAI7S5Q2Q$time=1530534308515", 
		LAST);

	web_add_cookie("dtPC=1$534305430_219h-vIFEDHEFAOHPTKMBFAJCMFLDKJBCJNIBN; DOMAIN=localhost");

	web_add_cookie("rxvt=1530536110586|1530534276697; DOMAIN=localhost");

	web_add_cookie("dtLatC=1; DOMAIN=localhost");

	addDynatraceHeaderTest("PC=rb_1_6;SI=LoadRunner;LSN=script name;");
	web_custom_request("rb_1_6", 
		"URL=http://localhost:8079/rb_1?type=js&session=1%2490732712A19CFE460D187D5D153DF84F%7CRUM%2BDefault%2BApplication%7C1&svrid=1&flavor=post&referer=http%3A%2F%2Flocalhost%3A8079%2Forange-booking-payment.jsf%3FjourneyId%3D9449&visitID=IFEDHEFAOHPTKMBFAJCMFLDKJBCJNIBN", 
		"Method=POST", 
		"Resource=0", 
		"RecContentType=text/plain", 
		"Referer=http://localhost:8079/orange-booking-payment.jsf?journeyId=9449", 
		"Snapshot=t38.inf", 
		"Mode=HTML", 
		"EncType=text/plain;charset=UTF-8", 
		"Body=$3p="
		"1-1530534305110%3Blocalhost%7Cu%7C32%7C0%7C0%7C9%7C0%7C32%7C%7C0%7C0%7C0%7C101_212_428_428_499_545%7C8%7C0%7C111%7C13%7C0%7C0%7C13%7C0%7C13%7C%7C0%7C0%7C0%7C90_97_108_109%7C0%7C0%7C1%7C5%7C0%7C0%7C5%7C85_90%7C1%7C1%7C1%7C4%7C0%7C0%7C4%7C98_100%7C1%7C1%7C1%3Bapis.google.com%7Ck%7C1%7C0%7C0%7C1%7C0%7C1%7C%7C0%7C0%7C0%7C97_98%7C1%7C1%7C1%7C3%7C0%7C0%7C1%7C370_372_541_545_561_798%7C80%7C1%7C237%3Bassets.dynatrace.com%7C2%7C1%7C0%7C0%7C0%7C0%7C1%7C%7C0%7C0%7C0%7C101_101%7C0%7C0%7C0%3Bplatform.twitter.c"
		"om%7Ck%7C2%7C0%7C0%7C2%7C0%7C2%7C%7C0%7C0%7C0%7C102_103_566_567%7C1%7C1%7C1%7C3%7C0%7C0%7C1%7C534_1050%7C184%7C0%7C320%3Bplatform.linkedin.com%7Ck%7C1%7C0%7C0%7C1%7C0%7C1%7C%7C0%7C0%7C0%7C103_105%7C1%7C1%7C1%7C1%7C0%7C0%7C1%7C471_472%7C1%7C1%7C1%3Bassets.pinterest.com%7C6%7C1%7C0%7C0%7C1%7C0%7C1%7C%7C0%7C0%7C0%7C105_107%7C2%7C2%7C2%7C2%7C0%7C0%7C1%7C0%7C2%7C%7C0%7C0%7C0%7C106_108_712_805%7C47%7C1%7C93%3Bconnect.facebook.net%7C4%7C1%7C0%7C0%7C1%7C0%7C1%7C%7C0%7C0%7C0%7C425_426%7C1%7C1%7C1%3Bstatic."
		"licdn.com%7C2%7C1%7C0%7C0%7C1%7C0%7C1%7C%7C0%7C0%7C0%7C501_501%7C0%7C0%7C0%3Baccounts.google.com%7Cg%7C1%7C0%7C0%7C0%7C590_806%7C216%7C216%7C216%3Bstaticxx.facebook.com%7C4%7C2%7C0%7C0%7C0%7C0%7C2%7C%7C0%7C0%7C0%7C678_1073%7C220%7C78%7C362%3Bwww.facebook.com%7Cg%7C2%7C0%7C0%7C1%7C858_1318%7C230%7C0%7C460%3Blog.pinterest.com%7Cg%7C1%7C0%7C0%7C0%7C1822_2008%7C186%7C186%7C186$rt="
		"1-1530534305110%3Bhttp%3A%2F%2Flocalhost%3A8079%2Fcss%2FBaseProd.css%7Cb85e1f1g1h1i1k1l1m1%7Chttp%3A%2F%2Flocalhost%3A8079%2Fcss%2Ffooter.css%7Cb86e1f1g1h1i1k1l1m1%7Chttp%3A%2F%2Flocalhost%3A8079%2Fcss%2Frime.css%7Cb87e1f1g1h1i1k1l1m1%7Chttp%3A%2F%2Flocalhost%3A8079%2Fcss%2Frating.css%7Cb88e0f0g0h0i0k0l0m1%7Chttp%3A%2F%2Flocalhost%3A8079%2Fcss%2Forange.css%7Cb89e1f1g1h1i1k1l1m1%7Chttp%3A%2F%2Flocalhost%3A8079%2Fjs%2Fjquery-1.8.1.js%7Cb90e0f0g0h0i0k0l0m1%7Chttp%3A%2F%2Flocalhost%3A8079%2Fjs%2Fjquer"
		"y-ui-1.8.2.min.js%7Cb90e1f1g1h1i1k1l1m1%7Chttp%3A%2F%2Flocalhost%3A8079%2Fjs%2Fversion.js%7Cb91e0f0g0h0i0k0l0m1%7Chttp%3A%2F%2Flocalhost%3A8079%2Fjs%2FdtagentApi.js%7Cb92e0f0g0h0i0k0l0m1%7Chttp%3A%2F%2Flocalhost%3A8079%2Fjs%2FFrameworkProd.js%7Cb93e0f0g0h0i0k0l0m1%7Chttp%3A%2F%2Flocalhost%3A8079%2Fjs%2Fjquery.formLabels1.0.js%7Cb93e0f0g0h0i0k0l0m1%7Chttp%3A%2F%2Flocalhost%3A8079%2Fjs%2FheaderRotation.js%7Cb94e0f0g0h0i0k0l0m1%7Chttp%3A%2F%2Flocalhost%3A8079%2Fjs%2Frating.js%7Cb95e0f0g0h0i0k0l0m1%7C"
		"http%3A%2F%2Flocalhost%3A8079%2Fjs%2Frecommendation.js%7Cb96e0f0g0h0i0k0l0m1%7Chttp%3A%2F%2Flocalhost%3A8079%2Fproblempatterns%2Fchangedetectionlib.js%7Cb96e0f0g0h0i0k0l0m0%7Chttp%3A%2F%2Flocalhost%3A8079%2Fjs%2Fusertimings.js%7Cb97e0f0g0h0i0k0l0m1%7Chttps%3A%2F%2Fapis.google.com%2Fjs%2Fplusone.js%7Cb97e0f0g0h0i0k0l0m1%7Chttp%3A%2F%2Flocalhost%3A8079%2Fjavax.faces.resource%2Fjsf.js.jsf%3Fln%3Djavax.faces%7Cb98e0f0g0h0i0k0l0m1%7Chttp%3A%2F%2Flocalhost%3A8079%2Fjavax.faces.resource%2Fbridge.js.jsf%3"
		"Frand%3D963083509%7Cb99e0f0g0h0i0k0l0m1%7Chttp%3A%2F%2Flocalhost%3A8079%2Fjavax.faces.resource%2Fcompat.js.jsf%7Cb99e0f0g0h0i0k0l0m1%7Chttp%3A%2F%2Flocalhost%3A8079%2Fjavax.faces.resource%2Ficefaces-compat.js.jsf%7Cb100e0f0g0h0i0k0l0m1%7Chttp%3A%2F%2Flocalhost%3A8079%2Fimg%2Fapple%2Fapple.png%7Cb101e0f0g0h0i0k0l0m0%7Chttp%3A%2F%2Flocalhost%3A8079%2Fimg%2Fandroidbutton.png%7Cb101e0f0g0h0i0k0l0m0%7Chttp%3A%2F%2Flocalhost%3A8079%2Fimg%2Ffacebookbutton.png%7Cb101e0f0g0h0i0k0l0m0%7Chttp%3A%2F%2Flocalho"
		"st%3A8079%2Fimg%2Ftwitterbutton.png%7Cb101e0f0g0h0i0k0l0m0%7Chttps%3A%2F%2Fassets.dynatrace.com%2Fglobal%2Ficons%2Ffavicon.ico%7Cb101e0f0g0h0i0k0l0m0%7Chttp%3A%2F%2Flocalhost%3A8079%2Fimg%2Frssbutton.png%7Cb101e0f0g0h0i0k0l0m0%7Chttp%3A%2F%2Flocalhost%3A8079%2Fimg%2Fprivacypolicy_5Flock.png%7Cb101e0f0g0h0i0k0l0m0%7Chttp%3A%2F%2Flocalhost%3A8079%2Fimg%2Fbooking%2FBooking_5Ftransaction_5FVersiSign.png%7Cb101e0f0g0h0i0k0l105m110%7Chttp%3A%2F%2Flocalhost%3A8079%2Fimg%2Fbooking%2FBooking_5Ftransaction_"
		"5Fcreditcards.png%7Cb101e0f0g0h0i0k0l100m105%7Chttp%3A%2F%2Flocalhost%3A8079%2Fimg%2Fbooking%2FBooking_5Ftransaction_5Fcreditcode.png%7Cb102e0f0g0h0i0k0l109m111%7Chttp%3A%2F%2Flocalhost%3A8092%2Fimage%2Fwinter.jpeg%7Cb102e0f0g0h0i0k0l0m0%7Chttp%3A%2F%2Fplatform.twitter.com%2Fwidgets.js%7Cb102e1m1%7Chttps%3A%2F%2Fplatform.linkedin.com%2Fin.js%7Cb103e1m1%7Chttps%3A%2F%2Fassets.pinterest.com%2Fimages%2Fpidgets%2Fpinit_5Ffg_5Fen_5Frect_5Fgray_5F20.png%7Cb105e1m2%7Chttps%3A%2F%2Fassets.pinterest.com%2F"
		"js%2Fpinit.js%7Cb106e1m1%7Chttp%3A%2F%2Flocalhost%3A8079%2Fjs%2FGlobalProd.js%7Cb108e1f1g1h1i1k1l1m1%7Chttp%3A%2F%2Flocalhost%3A8079%2Fjs%2Fjquery.js%7Cb109e0f0g0h0i0k0l0m1%7Chttps%3A%2F%2Fapis.google.com%2F_5F%2Fscs%2Fapps-static%2F_5F%2Fjs%2Fk%3Doz.gapi.pl.de2wM28ILrc.O%2Fm%3Dplusone%2Frt%3Dj%2Fsv%3D1%2Fd%3D1%2Fed%3D1%2Fam%3DwQ%2Frs%3DAGLTcCO5c-Kd6sZuD9hEQyRIuOc1MKFaQA%2Fcb%3Dgapi.loaded_5F0%7Cb370e1m1%7Chttp%3A%2F%2Fconnect.facebook.net%2Fen_5FUS%2Fall.js%23xfbml%3D1%7Cb425e1f1g1h1i1k1l1m1%7Cht"
		"tp%3A%2F%2Flocalhost%3A8079%2Fimg%2Fheader.png%7Cb428e0f0g0h0i0k0l0m0%7Chttp%3A%2F%2Flocalhost%3A8079%2Fimg%2Fgradient%2FVerlauf_5FGrau_5FLoginbox.png%7Cb428e0f0g0h0i0k0l0m0%7Chttp%3A%2F%2Flocalhost%3A8079%2Fimg%2Fgradient%2FVerlauf_5FGrau_5FButton_5F4.png%7Cb428e0f0g0h0i0k0l0m0%7Chttp%3A%2F%2Flocalhost%3A8079%2Fimg%2Fgradient%2FVerlauf_5FOrange_5FButton_5F4.png%7Cb428e0f0g0h0i0k0l0m0%7Chttp%3A%2F%2Flocalhost%3A8079%2Fimg%2Fgradient%2FVerlauf_5FGrau_5FHauptfeld.png%7Cb428e0f0g0h0i0k0l0m0%7Chttp%3A"
		"%2F%2Flocalhost%3A8079%2Fimg%2Fbooking%2FBooking_5Ftransaction_5Ftextbox_5Fmedium1_5Fpage_5F3.png%7Cb428e0f0g0h0i0k0l0m0%7Chttps%3A%2F%2Fplatform.linkedin.com%2Fjs%2FsecureAnonymousFramework%3Fv%3D1.0.328-1429%26lang%3Den_5FUS%7Cb471e1m1%7Chttp%3A%2F%2Flocalhost%3A8079%2Fimg%2Fgradient%2FVerlauf_5FOrange_5FButton_5F1.png%7Cb499e0f0g0h0i0k0l0m0%7Chttp%3A%2F%2Flocalhost%3A8079%2Fimg%2Fmenupunkt_5Ftrennung_5Ftransparent.png%7Cb499e0f0g0h0i0k0l0m0%7Chttp%3A%2F%2Flocalhost%3A8079%2Fimg%2Fgradient%2FVer"
		"lauf_5FOrange_5FHauptfeld.png%7Cb499e0f0g0h0i0k0l0m0%7Chttp%3A%2F%2Flocalhost%3A8079%2Fimg%2Fbooking%2Fstepindicator.png%7Cb499e0f0g0h0i0k0l0m0%7Chttp%3A%2F%2Flocalhost%3A8079%2Fimg%2Fbooking%2Fstepindicator_5F1_5Finactive.png%7Cb499e0f0g0h0i0k0l0m0%7Chttp%3A%2F%2Flocalhost%3A8079%2Fimg%2Fbooking%2Fstepindicator_5F2_5Finactive.png%7Cb499e0f0g0h0i0k0l30m39%7Chttp%3A%2F%2Flocalhost%3A8079%2Fimg%2Fbooking%2FSlider_5Fempty_5Fshadow.png%7Cb500e0f0g0h0i0k0l0m0%7Chttp%3A%2F%2Flocalhost%3A8079%2Fimg%2Fboo"
		"king%2Fstepindicator_5F3_5Factive.png%7Cb500e0f0g0h0i0k0l24m29%7Chttp%3A%2F%2Flocalhost%3A8079%2Fimg%2Fbooking%2Fstepindicator_5F4_5Finactive.png%7Cb500e0f0g0h0i0k0l0m0%7Chttp%3A%2F%2Flocalhost%3A8079%2Fimg%2Fbooking%2FBooking_5Ftransaction_5Ftextbox_5Flarge_5Fpage_5F3.png%7Cb500e0f0g0h0i0k0l19m29%7Chttp%3A%2F%2Flocalhost%3A8079%2Fimg%2Fbooking%2FBooking_5Ftransaction_5Ftextbox_5Fmedium2_5Fpage_5F3.png%7Cb500e0f0g0h0i0k1l38m45%7Chttp%3A%2F%2Flocalhost%3A8079%2Fimg%2Fbooking%2FBooking_5Ftransaction"
		"_5Ftextbox_5Fsmall_5Fpage_5F3.png%7Cb501e0f0g0h0i0k0l32m37%7Chttp%3A%2F%2Flocalhost%3A8079%2Fimg%2Fgradient%2FVerlauf_5FGrau_5FButton_5F1.png%7Cb501e0f0g0h0i0k0l0m0%7Chttps%3A%2F%2Fstatic.licdn.com%2Fscds%2Fcommon%2Fu%2Fimages%2Fapps%2Fconnect%2Fsprites%2Fsprite_5Fconnect_5Fv14.png%7Cb501e0f0g0h0i0k0l0m0%7Chttp%3A%2F%2Flocalhost%3A8079%2Fimg%2Flogo_5Flayer_5Fbottom.png%7Cb501e0f0g0h0i0k0l0m0%7Chttp%3A%2F%2Flocalhost%3A8079%2Fimg%2Flogin%2FLoginwindow_5Ftextbox.png%7Cb501e0f0g0h0i0k0l0m0%7Chttp%3A%"
		"2F%2Flocalhost%3A8079%2Fimg%2Fgradient%2FVerlauf_5FGrau_5FButton_5F3.png%7Cb501e0f0g0h0i0k0l0m0%7Chttps%3A%2F%2Fplatform.twitter.com%2Fwidgets%2Fwidget_5Fiframe.bed9e19e565ca3b578705de9e73c29ed.html%3Forigin%3Dhttp_253A_252F_252Flocalhost_253A8079%26settingsEndpoint%3Dhttps_253A_252F_252Fsyndication.twitter.com_252Fsettings%7Cb534e223m235Bi5%7Chttps%3A%2F%2Fapis.google.com%2F_5F%2Fscs%2Fapps-static%2F_5F%2Fjs%2Fk%3Doz.gapi.pl.de2wM28ILrc.O%2Fm%3Dauth%2Fexm%3Dplusone%2Frt%3Dj%2Fsv%3D1%2Fd%3D1%2Fed%"
		"3D1%2Fam%3DwQ%2Frs%3DAGLTcCO5c-Kd6sZuD9hEQyRIuOc1MKFaQA%2Fcb%3Dgapi.loaded_5F1%7Cb541e3m4%7Chttps%3A%2F%2Fapis.google.com%2Fse%2F0%2F_5F%2F%2B1%2Ffastbutton%7Cb561e199f199g199h199i199k199l200m237Bi%7Chttps%3A%2F%2Fplatform.twitter.com%2Fjs%2Fbutton.efa03583c158eb89fd00b8c75a70efae.js%7Cb566e1m1%7Chttps%3A%2F%2Faccounts.google.com%2Fo%2Foauth2%2FpostmessageRelay%7Cb590e171m216Bi%7Chttp%3A%2F%2Fstaticxx.facebook.com%2Fconnect%2Fxd_5Farbiter%2Fr%2FxaOI6zd9HW9.js%3Fversion%3D42%7Cb678e1m78Bi%7Chttps%3"
		"A%2F%2Fstaticxx.facebook.com%2Fconnect%2Fxd_5Farbiter%2Fr%2FxaOI6zd9HW9.js%3Fversion%3D42%7Cb710e160m362Bi%7Chttp%3A%2F%2Fassets.pinterest.com%2Fjs%2Fpinit_5Fmain.js%3F0.17254513468103805%7Cb712e0m93%7Chttps%3A%2F%2Fplatform.twitter.com%2Fwidgets%2Ffollow_5Fbutton.bed9e19e565ca3b578705de9e73c29ed.en.html%7Cb730e93m320Bi%7Chttps%3A%2F%2Fwww.facebook.com%2Fplugins%2Flike.php%7Cb858e221f221g221h221i221k221l424m460Bi4%7Chttps%3A%2F%2Fplatform.twitter.com%2Fwidgets%2Ffollow_5Fbutton.bed9e19e565ca3b5787"
		"05de9e73c29ed.en.html%7Cb1045m0Bi%7Chttps%3A%2F%2Fwww.facebook.com%2Fplugins%2Flike.php%7Cb1312m0Bi4%7Chttps%3A%2F%2Flog.pinterest.com%2F%7Cb1822e1m186$url=http%3A%2F%2Flocalhost%3A8079%2Forange-booking-payment.jsf%3FjourneyId%3D9449$title=easyTravel%20-%20Booking%20-%20Payment$latC=1$visitID=IFEDHEFAOHPTKMBFAJCMFLDKJBCJNIBN$fId=534305430_219$v=10150180628221724$vID=1530534276673RGLPOKT459A1LMBFO13616TBAI7S5Q2Q$time=1530534310586", 
		LAST);

	web_add_auto_header("Faces-Request", 
		"partial/ajax");

	addDynatraceHeaderTest("PC=orange-booking-payment.jsf_2;SI=LoadRunner;LSN=script name;");
	web_submit_data("orange-booking-payment.jsf_2", 
		"Action=http://localhost:8079/orange-booking-payment.jsf", 
		"Method=POST", 
		"RecContentType=text/xml", 
		"Referer=http://localhost:8079/orange-booking-payment.jsf?journeyId=9449", 
		"Snapshot=t39.inf", 
		"Mode=HTML", 
		"EncodeAtSign=YES", 
		ITEMDATA, 
		"Name=iceform", "Value=iceform", ENDITEM, 
		"Name=javax.faces.ViewState", "Value=-932247047312321508:6671456150616442616", ENDITEM, 
		"Name=ice.window", "Value=oqjj48l9qs", ENDITEM, 
		"Name=ice.view", "Value=vfxe7zp72q", ENDITEM, 
		"Name=iceform:creditCardType", "Value=VISA", ENDITEM, 
		"Name=iceform:creditCardNumber", "Value=123123", ENDITEM, 
		"Name=iceform:creditCardOwner", "Value=adsd", ENDITEM, 
		"Name=iceform:expirationMonth", "Value=March", ENDITEM, 
		"Name=iceform:expirationYear", "Value=2019", ENDITEM, 
		"Name=iceform:verificationNumber", "Value=111", ENDITEM, 
		"Name=icefacesCssUpdates", "Value=", ENDITEM, 
		"Name=iceform:j_idcl", "Value=", ENDITEM, 
		"Name=javax.faces.source", "Value=iceform:bookPaymentNext", ENDITEM, 
		"Name=javax.faces.partial.event", "Value=click", ENDITEM, 
		"Name=javax.faces.partial.execute", "Value=@all", ENDITEM, 
		"Name=javax.faces.partial.render", "Value=@all", ENDITEM, 
		"Name=ice.window", "Value=oqjj48l9qs", ENDITEM, 
		"Name=ice.view", "Value=vfxe7zp72q", ENDITEM, 
		"Name=ice.focus", "Value=iceform:bookPaymentNext", ENDITEM, 
		"Name=iceform:bookPaymentNext", "Value=Next", ENDITEM, 
		"Name=ice.event.target", "Value=iceform:bookPaymentNext", ENDITEM, 
		"Name=ice.event.captured", "Value=iceform:bookPaymentNext", ENDITEM, 
		"Name=ice.event.type", "Value=onclick", ENDITEM, 
		"Name=ice.event.alt", "Value=false", ENDITEM, 
		"Name=ice.event.ctrl", "Value=false", ENDITEM, 
		"Name=ice.event.shift", "Value=false", ENDITEM, 
		"Name=ice.event.meta", "Value=false", ENDITEM, 
		"Name=ice.event.x", "Value=1020", ENDITEM, 
		"Name=ice.event.y", "Value=480", ENDITEM, 
		"Name=ice.event.left", "Value=true", ENDITEM, 
		"Name=ice.event.right", "Value=false", ENDITEM, 
		"Name=ice.submit.type", "Value=ice.s", ENDITEM, 
		"Name=ice.submit.serialization", "Value=form", ENDITEM, 
		"Name=javax.faces.partial.ajax", "Value=true", ENDITEM, 
		EXTRARES, 
		"Url=http://localhost:8092/image/easyTravel_banner.png", "Referer=http://localhost:8079/orange-booking-payment.jsf?journeyId=9449", ENDITEM, 
		"Url=/img/header3.jpg", "Referer=http://localhost:8079/orange-booking-payment.jsf?journeyId=9449", ENDITEM, 
		LAST);

	addDynatraceHeaderTest("PC=orange-booking-payment.jsf_3;SI=LoadRunner;LSN=script name;");
	web_submit_data("orange-booking-payment.jsf_3", 
		"Action=http://localhost:8079/orange-booking-payment.jsf", 
		"Method=POST", 
		"RecContentType=text/xml", 
		"Referer=http://localhost:8079/orange-booking-payment.jsf?journeyId=9449", 
		"Snapshot=t40.inf", 
		"Mode=HTML", 
		"EncodeAtSign=YES", 
		ITEMDATA, 
		"Name=iceform", "Value=iceform", ENDITEM, 
		"Name=javax.faces.ViewState", "Value=-932247047312321508:6671456150616442616", ENDITEM, 
		"Name=ice.window", "Value=oqjj48l9qs", ENDITEM, 
		"Name=ice.view", "Value=vfxe7zp72q", ENDITEM, 
		"Name=iceform:creditCardType", "Value=VISA", ENDITEM, 
		"Name=iceform:creditCardNumber", "Value=2222333344445555", ENDITEM, 
		"Name=iceform:creditCardOwner", "Value=adsd", ENDITEM, 
		"Name=iceform:expirationMonth", "Value=March", ENDITEM, 
		"Name=iceform:expirationYear", "Value=2019", ENDITEM, 
		"Name=iceform:verificationNumber", "Value=111", ENDITEM, 
		"Name=icefacesCssUpdates", "Value=", ENDITEM, 
		"Name=iceform:j_idcl", "Value=", ENDITEM, 
		"Name=javax.faces.source", "Value=iceform:bookPaymentNext", ENDITEM, 
		"Name=javax.faces.partial.event", "Value=click", ENDITEM, 
		"Name=javax.faces.partial.execute", "Value=@all", ENDITEM, 
		"Name=javax.faces.partial.render", "Value=@all", ENDITEM, 
		"Name=ice.window", "Value=oqjj48l9qs", ENDITEM, 
		"Name=ice.view", "Value=vfxe7zp72q", ENDITEM, 
		"Name=ice.focus", "Value=iceform:bookPaymentNext", ENDITEM, 
		"Name=iceform:bookPaymentNext", "Value=Next", ENDITEM, 
		"Name=ice.event.target", "Value=iceform:bookPaymentNext", ENDITEM, 
		"Name=ice.event.captured", "Value=iceform:bookPaymentNext", ENDITEM, 
		"Name=ice.event.type", "Value=onclick", ENDITEM, 
		"Name=ice.event.alt", "Value=false", ENDITEM, 
		"Name=ice.event.ctrl", "Value=false", ENDITEM, 
		"Name=ice.event.shift", "Value=false", ENDITEM, 
		"Name=ice.event.meta", "Value=false", ENDITEM, 
		"Name=ice.event.x", "Value=1029", ENDITEM, 
		"Name=ice.event.y", "Value=489", ENDITEM, 
		"Name=ice.event.left", "Value=true", ENDITEM, 
		"Name=ice.event.right", "Value=false", ENDITEM, 
		"Name=ice.submit.type", "Value=ice.s", ENDITEM, 
		"Name=ice.submit.serialization", "Value=form", ENDITEM, 
		"Name=javax.faces.partial.ajax", "Value=true", ENDITEM, 
		LAST);

	web_add_cookie("dtSa=true%7CU%7C-1%7CNext%7C-%7C1530534322790%7C534305430_219%7Chttp%3A%2F%2Flocalhost%3A8079%2Forange-booking-payment.jsf%3FjourneyId%3D9449%7CeasyTravel%20-%20Booking%20-%20Payment%7C1530534310588%7C; DOMAIN=localhost");

	web_revert_auto_header("Faces-Request");

	web_add_cookie("dtPC=1$534324386_970h1vIFEDHEFAOHPTKMBFAJCMFLDKJBCJNIBN; DOMAIN=localhost");

	web_add_cookie("rxvt=1530536124389|1530534276697; DOMAIN=localhost");

	web_add_cookie("dtLatC=17; DOMAIN=localhost");

	addDynatraceHeaderTest("PC=orange-booking-finish.jsf;SI=LoadRunner;LSN=script name;");
	web_url("orange-booking-finish.jsf", 
		"URL=http://localhost:8079/orange-booking-finish.jsf?journeyId=9449", 
		"Resource=0", 
		"RecContentType=text/html", 
		"Referer=http://localhost:8079/orange-booking-payment.jsf?journeyId=9449", 
		"Snapshot=t41.inf", 
		"Mode=HTML", 
		EXTRARES, 
		"Url=/img/booking/Slider_empty.png", "Referer=http://localhost:8079/orange-booking-finish.jsf?journeyId=9449", ENDITEM, 
		"Url=/img/booking/stepindicator_4_active.png", "Referer=http://localhost:8079/orange-booking-finish.jsf?journeyId=9449", ENDITEM, 
		LAST);

	addDynatraceHeaderTest("PC=widget_iframe.bed9e19e565ca3b578705de9e73c29ed.html_4;SI=LoadRunner;LSN=script name;");
	web_url("widget_iframe.bed9e19e565ca3b578705de9e73c29ed.html_4", 
		"URL=https://platform.twitter.com/widgets/widget_iframe.bed9e19e565ca3b578705de9e73c29ed.html?origin=http%3A%2F%2Flocalhost%3A8079&settingsEndpoint=https%3A%2F%2Fsyndication.twitter.com%2Fsettings", 
		"Resource=0", 
		"RecContentType=text/html", 
		"Referer=http://localhost:8079/orange-booking-finish.jsf?journeyId=9449", 
		"Snapshot=t42.inf", 
		"Mode=HTML", 
		LAST);

	addDynatraceHeaderTest("PC=fastbutton_4;SI=LoadRunner;LSN=script name;");
	web_url("fastbutton_4", 
		"URL=https://apis.google.com/se/0/_/+1/fastbutton?usegapi=1&origin=http%3A%2F%2Flocalhost%3A8079&url=http%3A%2F%2Fwww.dynatrace.com%2F&gsrc=3p&ic=1&jsh=m%3B%2F_%2Fscs%2Fapps-static%2F_%2Fjs%2Fk%3Doz.gapi.pl.de2wM28ILrc.O%2Fm%3D__features__%2Fam%3DwQ%2Frt%3Dj%2Fd%3D1%2Frs%3DAGLTcCO5c-Kd6sZuD9hEQyRIuOc1MKFaQA", 
		"Resource=0", 
		"RecContentType=text/html", 
		"Referer=http://localhost:8079/orange-booking-finish.jsf?journeyId=9449", 
		"Snapshot=t43.inf", 
		"Mode=HTML", 
		LAST);

	addDynatraceHeaderTest("PC=postmessageRelay_4;SI=LoadRunner;LSN=script name;");
	web_url("postmessageRelay_4", 
		"URL=https://accounts.google.com/o/oauth2/postmessageRelay?parent=http%3A%2F%2Flocalhost%3A8079&jsh=m%3B%2F_%2Fscs%2Fapps-static%2F_%2Fjs%2Fk%3Doz.gapi.pl.de2wM28ILrc.O%2Fm%3D__features__%2Fam%3DwQ%2Frt%3Dj%2Fd%3D1%2Frs%3DAGLTcCO5c-Kd6sZuD9hEQyRIuOc1MKFaQA", 
		"Resource=0", 
		"RecContentType=text/html", 
		"Referer=http://localhost:8079/orange-booking-finish.jsf?journeyId=9449", 
		"Snapshot=t44.inf", 
		"Mode=HTML", 
		EXTRARES, 
		"Url=http://assets.pinterest.com/js/pinit_main.js?0.5688087694051419", "Referer=http://localhost:8079/orange-booking-finish.jsf?journeyId=9449", ENDITEM, 
		LAST);

	addDynatraceHeaderTest("PC=xaOI6zd9HW9.js_5;SI=LoadRunner;LSN=script name;");
	web_url("xaOI6zd9HW9.js_5", 
		"URL=https://staticxx.facebook.com/connect/xd_arbiter/r/xaOI6zd9HW9.js?version=42", 
		"Resource=0", 
		"RecContentType=text/html", 
		"Referer=http://localhost:8079/orange-booking-finish.jsf?journeyId=9449", 
		"Snapshot=t45.inf", 
		"Mode=HTML", 
		LAST);

	addDynatraceHeaderTest("PC=follow_button.bed9e19e565ca3b578705de9e73c29ed.en.html_4;SI=LoadRunner;LSN=script name;");
	web_url("follow_button.bed9e19e565ca3b578705de9e73c29ed.en.html_4", 
		"URL=https://platform.twitter.com/widgets/follow_button.bed9e19e565ca3b578705de9e73c29ed.en.html", 
		"Resource=0", 
		"RecContentType=text/html", 
		"Referer=http://localhost:8079/orange-booking-finish.jsf?journeyId=9449", 
		"Snapshot=t46.inf", 
		"Mode=HTML", 
		LAST);

	addDynatraceHeaderTest("PC=like.php_4;SI=LoadRunner;LSN=script name;");
	web_url("like.php_4", 
		"URL=https://www.facebook.com/plugins/like.php?app_id=&channel=http%3A%2F%2Fstaticxx.facebook.com%2Fconnect%2Fxd_arbiter%2Fr%2FxaOI6zd9HW9.js%3Fversion%3D42%23cb%3Dfd9a51bbf694d4%26domain%3Dlocalhost%26origin%3Dhttp%253A%252F%252Flocalhost%253A8079%252Ff7fd594af1cd0c%26relation%3Dparent.parent&container_width=850&font=arial&href=http%3A%2F%2Flocalhost%3A8079%2Fwww.dynatrace.com&locale=en_US&sdk=joey&send=false&show_faces=false&width=300", 
		"Resource=0", 
		"RecContentType=text/html", 
		"Referer=http://localhost:8079/orange-booking-finish.jsf?journeyId=9449", 
		"Snapshot=t47.inf", 
		"Mode=HTML", 
		LAST);

	addDynatraceHeaderTest("PC=jot_3;SI=LoadRunner;LSN=script name;");
	web_submit_data("jot_3", 
		"Action=https://syndication.twitter.com/i/jot", 
		"Method=POST", 
		"RecContentType=text/html", 
		"Referer=", 
		"Snapshot=t48.inf", 
		"Mode=HTML", 
		ITEMDATA, 
		"Name=dnt", "Value=0", ENDITEM, 
		"Name=tfw_redirect", "Value=https://platform.twitter.com/jot.html", ENDITEM, 
		"Name=l", "Value={\"widget_origin\":\"http://localhost:8079/orange-booking-finish.jsf?journeyId=9449\",\"widget_frame\":false,\"language\":\"en\",\"message\":\"m:withcount:\",\"_category_\":\"tfw_client_event\",\"triggered_on\":1530534325129,\"dnt\":false,\"client_version\":\"910cbce:1530167310832\",\"format_version\":1,\"event_namespace\":{\"client\":\"tfw\",\"page\":\"button\",\"section\":\"follow\",\"action\":\"impression\"}}", ENDITEM, 
		"Name=l", "Value={\"widget_origin\":\"http://localhost:8079/orange-booking-finish.jsf?journeyId=9449\",\"widget_frame\":null,\"duration_ms\":256.30794153024794,\"_category_\":\"tfw_client_event\",\"triggered_on\":1530534325130,\"dnt\":false,\"client_version\":\"910cbce:1530167310832\",\"format_version\":1,\"event_namespace\":{\"client\":\"tfw\",\"action\":\"render\",\"page\":\"page\",\"component\":\"performance\"}}", ENDITEM, 
		LAST);

	addDynatraceHeaderTest("PC=log.pinterest.com_4;SI=LoadRunner;LSN=script name;");
	web_url("log.pinterest.com_4", 
		"URL=https://log.pinterest.com/?guid=sirnaakLrme1&tv=2018050702&type=pidget&sub=pl&button_count=1&follow_count=0&pin_count=0&profile_count=0&board_count=0&section_count=0&lang=pl&via=http%3A%2F%2Flocalhost%3A8079%2Forange-booking-finish.jsf%3FjourneyId%3D9449&callback=PIN_1530534324843.f.callback[0]", 
		"Resource=0", 
		"Referer=http://localhost:8079/orange-booking-finish.jsf?journeyId=9449", 
		"Snapshot=t49.inf", 
		"Mode=HTML", 
		LAST);

	web_add_cookie("rxvt=1530536127564|1530534276697; DOMAIN=localhost");

	addDynatraceHeaderTest("PC=rb_1_7;SI=LoadRunner;LSN=script name;");
	web_custom_request("rb_1_7", 
		"URL=http://localhost:8079/rb_1?type=js&session=1%2490732712A19CFE460D187D5D153DF84F%7CRUM%2BDefault%2BApplication%7C1&svrid=1&flavor=post&referer=http%3A%2F%2Flocalhost%3A8079%2Forange-booking-finish.jsf%3FjourneyId%3D9449&visitID=IFEDHEFAOHPTKMBFAJCMFLDKJBCJNIBN", 
		"Method=POST", 
		"Resource=0", 
		"RecContentType=text/plain", 
		"Referer=http://localhost:8079/orange-booking-finish.jsf?journeyId=9449", 
		"Snapshot=t50.inf", 
		"Mode=HTML", 
		"EncType=text/plain;charset=UTF-8", 
		"Body=$a=d%7C-1%7CNext%7CU%7C-%7C534305430_219%7C1530534322790%7Chttp%3A%2F%2Flocalhost%3A8079%2Forange-booking-payment.jsf%3FjourneyId%3D9449%7CeasyTravel%20-%20Booking%20-%20Payment%2C1%7C1%7C_load_%7C_load_%7C-%7C1530534324097%7C1530534325509%7C207%7C-%7C-%7C-%7C-%7C-%7Chttp%3A%2F%2Flocalhost%3A8079%2Forange-booking-payment.jsf%3FjourneyId%3D9449%2C2%7C2%7C_onload_%7C_load_%7C-%7C1530534325507%7C1530534325509%7C206$rId=RID_864209405$rpId=770995669$domR=1530534325506$w=1920$h=1082$sw=1920$sh="
		"1200$nt=a0b1530534324097e16f16g16h16i16k34l36m38n36o462p462q520r1409s1410t1412$V=869|c$S=406$fd=j1.8.1^so1.7^six$url=http%3A%2F%2Flocalhost%3A8079%2Forange-booking-finish.jsf%3FjourneyId%3D9449$title=easyTravel%20-%20Booking%20-%20Finish$vd=16975$latC=17$visitID=IFEDHEFAOHPTKMBFAJCMFLDKJBCJNIBN$fId=534324386_970$v=10150180628221724$vID=1530534276673RGLPOKT459A1LMBFO13616TBAI7S5Q2Q$time=1530534327564", 
		LAST);

	web_add_cookie("rxvt=1530536125557|1530534276697; DOMAIN=localhost");

	web_add_header("Faces-Request", 
		"partial/ajax");

	addDynatraceHeaderTest("PC=orange-booking-finish.jsf_2;SI=LoadRunner;LSN=script name;");
	web_submit_data("orange-booking-finish.jsf_2", 
		"Action=http://localhost:8079/orange-booking-finish.jsf", 
		"Method=POST", 
		"RecContentType=text/xml", 
		"Referer=http://localhost:8079/orange-booking-finish.jsf?journeyId=9449", 
		"Snapshot=t51.inf", 
		"Mode=HTML", 
		"EncodeAtSign=YES", 
		ITEMDATA, 
		"Name=iceform", "Value=iceform", ENDITEM, 
		"Name=javax.faces.ViewState", "Value=261378843353078209:-6429494183871565578", ENDITEM, 
		"Name=ice.window", "Value=oqjj48l9qs", ENDITEM, 
		"Name=ice.view", "Value=vfxe7zp73m", ENDITEM, 
		"Name=icefacesCssUpdates", "Value=", ENDITEM, 
		"Name=javax.faces.source", "Value=iceform:bookFinishFinish", ENDITEM, 
		"Name=javax.faces.partial.event", "Value=click", ENDITEM, 
		"Name=javax.faces.partial.execute", "Value=@all", ENDITEM, 
		"Name=javax.faces.partial.render", "Value=@all", ENDITEM, 
		"Name=ice.window", "Value=oqjj48l9qs", ENDITEM, 
		"Name=ice.view", "Value=vfxe7zp73m", ENDITEM, 
		"Name=ice.focus", "Value=iceform:bookFinishFinish", ENDITEM, 
		"Name=iceform:bookFinishFinish", "Value=Finish", ENDITEM, 
		"Name=ice.event.target", "Value=iceform:bookFinishFinish", ENDITEM, 
		"Name=ice.event.captured", "Value=iceform:bookFinishFinish", ENDITEM, 
		"Name=ice.event.type", "Value=onclick", ENDITEM, 
		"Name=ice.event.alt", "Value=false", ENDITEM, 
		"Name=ice.event.ctrl", "Value=false", ENDITEM, 
		"Name=ice.event.shift", "Value=false", ENDITEM, 
		"Name=ice.event.meta", "Value=false", ENDITEM, 
		"Name=ice.event.x", "Value=978", ENDITEM, 
		"Name=ice.event.y", "Value=485", ENDITEM, 
		"Name=ice.event.left", "Value=true", ENDITEM, 
		"Name=ice.event.right", "Value=false", ENDITEM, 
		"Name=ice.submit.type", "Value=ice.s", ENDITEM, 
		"Name=ice.submit.serialization", "Value=form", ENDITEM, 
		"Name=javax.faces.partial.ajax", "Value=true", ENDITEM, 
		LAST);

	web_add_cookie("dtPC=1$534324386_970h-vIFEDHEFAOHPTKMBFAJCMFLDKJBCJNIBN; DOMAIN=localhost");

	web_add_cookie("rxvt=1530536129239|1530534276697; DOMAIN=localhost");

	web_add_cookie("dtSa=true%7CC%7C-1%7CFinish%7C-%7C1530534327007%7C534324386_970%7Chttp%3A%2F%2Flocalhost%3A8079%2Forange-booking-finish.jsf%3FjourneyId%3D9449%7CeasyTravel%20-%20Booking%20-%20Finish%7C1530534327566%7C; DOMAIN=localhost");

	web_add_cookie("dtLatC=2; DOMAIN=localhost");

	addDynatraceHeaderTest("PC=rb_1_8;SI=LoadRunner;LSN=script name;");
	web_custom_request("rb_1_8", 
		"URL=http://localhost:8079/rb_1?type=js&session=1%2490732712A19CFE460D187D5D153DF84F%7CRUM%2BDefault%2BApplication%7C1&svrid=1&flavor=post&referer=http%3A%2F%2Flocalhost%3A8079%2Forange-booking-finish.jsf%3FjourneyId%3D9449&visitID=IFEDHEFAOHPTKMBFAJCMFLDKJBCJNIBN", 
		"Method=POST", 
		"Resource=0", 
		"RecContentType=text/plain", 
		"Referer=http://localhost:8079/orange-booking-finish.jsf?journeyId=9449", 
		"Snapshot=t52.inf", 
		"Mode=HTML", 
		"EncType=text/plain;charset=UTF-8", 
		"Body=$3p="
		"1-1530534324097%3Blocalhost%7Cu%7C26%7C0%7C0%7C8%7C0%7C26%7C%7C0%7C0%7C0%7C55_86_389_389_461_490%7C0%7C0%7C30%7C13%7C0%7C0%7C13%7C0%7C13%7C%7C0%7C0%7C0%7C43_51_63_64%7C0%7C0%7C1%7C5%7C0%7C0%7C5%7C39_43%7C1%7C1%7C1%7C4%7C0%7C0%7C4%7C52_55%7C1%7C1%7C1%3Bapis.google.com%7Ck%7C1%7C0%7C0%7C1%7C0%7C1%7C%7C0%7C0%7C0%7C51_52%7C1%7C1%7C1%7C3%7C0%7C0%7C2%7C337_339_497_498_515_743%7C76%7C1%7C228%3Bassets.dynatrace.com%7C2%7C1%7C0%7C0%7C0%7C0%7C1%7C%7C0%7C0%7C0%7C56_56%7C0%7C0%7C0%3Bplatform.twitter.com%7Ck%7"
		"C2%7C0%7C0%7C2%7C0%7C2%7C%7C0%7C0%7C0%7C57_59_521_522%7C1%7C1%7C2%7C3%7C0%7C0%7C1%7C492_825%7C122%7C0%7C189%3Bplatform.linkedin.com%7Ck%7C1%7C0%7C0%7C1%7C0%7C1%7C%7C0%7C0%7C0%7C59_60%7C1%7C1%7C1%7C1%7C0%7C0%7C1%7C434_435%7C1%7C1%7C1%3Bassets.pinterest.com%7C6%7C1%7C0%7C0%7C1%7C0%7C1%7C%7C0%7C0%7C0%7C61_62%7C1%7C1%7C1%7C2%7C0%7C0%7C1%7C0%7C2%7C%7C0%7C0%7C0%7C62_63_631_726%7C48%7C1%7C95%3Bconnect.facebook.net%7C4%7C1%7C0%7C0%7C1%7C0%7C1%7C%7C0%7C0%7C0%7C386_388%7C1%7C1%7C1%3Bstatic.licdn.com%7C2%7C1"
		"%7C0%7C0%7C0%7C0%7C1%7C%7C0%7C0%7C0%7C462_462%7C0%7C0%7C0%3Baccounts.google.com%7Cg%7C1%7C0%7C0%7C0%7C545_760%7C215%7C215%7C215%3Bstaticxx.facebook.com%7C4%7C2%7C0%7C0%7C0%7C0%7C2%7C%7C0%7C0%7C0%7C595_797%7C120%7C73%7C168%3Bwww.facebook.com%7Cg%7C2%7C0%7C0%7C1%7C861_1313%7C226%7C0%7C452%3Blog.pinterest.com%7Cg%7C1%7C0%7C0%7C0%7C1773_1971%7C198%7C198%7C198$rt="
		"1-1530534324097%3Bhttp%3A%2F%2Flocalhost%3A8079%2Fcss%2FBaseProd.css%7Cb39e1f1g1h1i1k1l1m1%7Chttp%3A%2F%2Flocalhost%3A8079%2Fcss%2Ffooter.css%7Cb40e0f0g0h0i0k0l0m1%7Chttp%3A%2F%2Flocalhost%3A8079%2Fcss%2Frime.css%7Cb41e0f0g0h0i0k0l0m1%7Chttp%3A%2F%2Flocalhost%3A8079%2Fcss%2Frating.css%7Cb42e0f0g0h0i0k0l0m1%7Chttp%3A%2F%2Flocalhost%3A8079%2Fcss%2Forange.css%7Cb42e0f0g0h0i0k0l0m1%7Chttp%3A%2F%2Flocalhost%3A8079%2Fjs%2Fjquery-1.8.1.js%7Cb43e0f0g0h0i0k0l0m1%7Chttp%3A%2F%2Flocalhost%3A8079%2Fjs%2Fjquer"
		"y-ui-1.8.2.min.js%7Cb44e0f0g0h0i0k0l0m1%7Chttp%3A%2F%2Flocalhost%3A8079%2Fjs%2Fversion.js%7Cb44e0f0g0h0i0k0l0m1%7Chttp%3A%2F%2Flocalhost%3A8079%2Fjs%2FdtagentApi.js%7Cb45e0f0g0h0i0k0l0m1%7Chttp%3A%2F%2Flocalhost%3A8079%2Fjs%2FFrameworkProd.js%7Cb46e1f1g1h1i1k1l1m1%7Chttp%3A%2F%2Flocalhost%3A8079%2Fjs%2Fjquery.formLabels1.0.js%7Cb46e1f1g1h1i1k1l1m1%7Chttp%3A%2F%2Flocalhost%3A8079%2Fjs%2FheaderRotation.js%7Cb48e1f1g1h1i1k1l1m1%7Chttp%3A%2F%2Flocalhost%3A8079%2Fjs%2Frating.js%7Cb49e1f1g1h1i1k1l1m1%7C"
		"http%3A%2F%2Flocalhost%3A8079%2Fjs%2Frecommendation.js%7Cb50e0f0g0h0i0k0l0m1%7Chttp%3A%2F%2Flocalhost%3A8079%2Fproblempatterns%2Fchangedetectionlib.js%7Cb50e0f0g0h0i0k0l0m0%7Chttp%3A%2F%2Flocalhost%3A8079%2Fjs%2Fusertimings.js%7Cb51e1f1g1h1i1k1l1m1%7Chttps%3A%2F%2Fapis.google.com%2Fjs%2Fplusone.js%7Cb51e1f1g1h1i1k1l1m1%7Chttp%3A%2F%2Flocalhost%3A8079%2Fjavax.faces.resource%2Fjsf.js.jsf%3Fln%3Djavax.faces%7Cb52e1f1g1h1i1k1l1m1%7Chttp%3A%2F%2Flocalhost%3A8079%2Fjavax.faces.resource%2Fbridge.js.jsf%3"
		"Frand%3D963083509%7Cb53e1f1g1h1i1k1l1m1%7Chttp%3A%2F%2Flocalhost%3A8079%2Fjavax.faces.resource%2Fcompat.js.jsf%7Cb54e0f0g0h0i0k0l0m1%7Chttp%3A%2F%2Flocalhost%3A8079%2Fjavax.faces.resource%2Ficefaces-compat.js.jsf%7Cb55e0f0g0h0i0k0l0m1%7Chttp%3A%2F%2Flocalhost%3A8079%2Fimg%2Fapple%2Fapple.png%7Cb55e0f0g0h0i0k0l0m0%7Chttp%3A%2F%2Flocalhost%3A8079%2Fimg%2Fandroidbutton.png%7Cb55e0f0g0h0i0k0l0m0%7Chttp%3A%2F%2Flocalhost%3A8079%2Fimg%2Ffacebookbutton.png%7Cb56e0f0g0h0i0k0l0m0%7Chttp%3A%2F%2Flocalhost%3"
		"A8079%2Fimg%2Ftwitterbutton.png%7Cb56e0f0g0h0i0k0l0m0%7Chttps%3A%2F%2Fassets.dynatrace.com%2Fglobal%2Ficons%2Ffavicon.ico%7Cb56e0f0g0h0i0k0l0m0%7Chttp%3A%2F%2Flocalhost%3A8079%2Fimg%2Frssbutton.png%7Cb56e0f0g0h0i0k0l0m0%7Chttp%3A%2F%2Flocalhost%3A8079%2Fimg%2Fprivacypolicy_5Flock.png%7Cb56e0f0g0h0i0k0l0m0%7Chttp%3A%2F%2Flocalhost%3A8079%2Fimg%2Fbooking%2FeasyTravel_5Fbookingtransaction_5FHeader.png%7Cb56e0f0g0h0i0k0l13m30%7Chttp%3A%2F%2Flocalhost%3A8092%2Fimage%2Froad1.png%7Cb56e0f0g0h0i0k0l0m2%7C"
		"http%3A%2F%2Fplatform.twitter.com%2Fwidgets.js%7Cb57e2m2%7Chttps%3A%2F%2Fplatform.linkedin.com%2Fin.js%7Cb59e1m1%7Chttps%3A%2F%2Fassets.pinterest.com%2Fimages%2Fpidgets%2Fpinit_5Ffg_5Fen_5Frect_5Fgray_5F20.png%7Cb61e1m1%7Chttps%3A%2F%2Fassets.pinterest.com%2Fjs%2Fpinit.js%7Cb62e1m1%7Chttp%3A%2F%2Flocalhost%3A8079%2Fjs%2FGlobalProd.js%7Cb63e1f1g1h1i1k1l1m1%7Chttp%3A%2F%2Flocalhost%3A8079%2Fjs%2Fjquery.js%7Cb64e1f1g1h1i1k1l1m1%7Chttps%3A%2F%2Fapis.google.com%2F_5F%2Fscs%2Fapps-static%2F_5F%2Fjs%2Fk%"
		"3Doz.gapi.pl.de2wM28ILrc.O%2Fm%3Dplusone%2Frt%3Dj%2Fsv%3D1%2Fd%3D1%2Fed%3D1%2Fam%3DwQ%2Frs%3DAGLTcCO5c-Kd6sZuD9hEQyRIuOc1MKFaQA%2Fcb%3Dgapi.loaded_5F0%7Cb337e1m1%7Chttp%3A%2F%2Fconnect.facebook.net%2Fen_5FUS%2Fall.js%23xfbml%3D1%7Cb386e1f1g1h1i1k1l1m1%7Chttp%3A%2F%2Flocalhost%3A8079%2Fimg%2Fgradient%2FVerlauf_5FGrau_5FButton_5F4.png%7Cb389e0f0g0h0i0k0l0m0%7Chttp%3A%2F%2Flocalhost%3A8079%2Fimg%2Fgradient%2FVerlauf_5FOrange_5FButton_5F4.png%7Cb389e0f0g0h0i0k0l0m0%7Chttp%3A%2F%2Flocalhost%3A8079%2Fim"
		"g%2Fheader.png%7Cb389e0f0g0h0i0k0l0m0%7Chttp%3A%2F%2Flocalhost%3A8079%2Fimg%2Fgradient%2FVerlauf_5FGrau_5FLoginbox.png%7Cb389e0f0g0h0i0k0l0m0%7Chttp%3A%2F%2Flocalhost%3A8079%2Fimg%2Fgradient%2FVerlauf_5FGrau_5FHauptfeld.png%7Cb389e0f0g0h0i0k0l0m0%7Chttp%3A%2F%2Flocalhost%3A8079%2Fimg%2Fgradient%2FVerlauf_5FOrange_5FButton_5F1.png%7Cb389e0f0g0h0i0k0l0m0%7Chttps%3A%2F%2Fplatform.linkedin.com%2Fjs%2FsecureAnonymousFramework%3Fv%3D1.0.328-1429%26lang%3Den_5FUS%7Cb434e1m1%7Chttp%3A%2F%2Flocalhost%3A807"
		"9%2Fimg%2Fmenupunkt_5Ftrennung_5Ftransparent.png%7Cb461e0f0g0h0i0k0l0m0%7Chttp%3A%2F%2Flocalhost%3A8079%2Fimg%2Fgradient%2FVerlauf_5FOrange_5FHauptfeld.png%7Cb461e0f0g0h0i0k0l0m0%7Chttp%3A%2F%2Flocalhost%3A8079%2Fimg%2Fbooking%2Fstepindicator.png%7Cb461e0f0g0h0i0k0l0m0%7Chttp%3A%2F%2Flocalhost%3A8079%2Fimg%2Fbooking%2Fstepindicator_5F1_5Finactive.png%7Cb461e0f0g0h0i0k0l0m0%7Chttp%3A%2F%2Flocalhost%3A8079%2Fimg%2Fbooking%2Fstepindicator_5F2_5Finactive.png%7Cb461e0f0g0h0i0k0l0m0%7Chttp%3A%2F%2Flocal"
		"host%3A8079%2Fimg%2Fbooking%2Fstepindicator_5F3_5Finactive.png%7Cb461e0f0g0h0i0k0l0m0%7Chttp%3A%2F%2Flocalhost%3A8079%2Fimg%2Fbooking%2FSlider_5Fempty.png%7Cb461e0f0g0h0i0k0l14m16%7Chttp%3A%2F%2Flocalhost%3A8079%2Fimg%2Fbooking%2Fstepindicator_5F4_5Factive.png%7Cb462e0f0g0h0i0k14l27m28%7Chttp%3A%2F%2Flocalhost%3A8079%2Fimg%2Fgradient%2FVerlauf_5FGrau_5FButton_5F1.png%7Cb462e0f0g0h0i0k0l0m0%7Chttps%3A%2F%2Fstatic.licdn.com%2Fscds%2Fcommon%2Fu%2Fimages%2Fapps%2Fconnect%2Fsprites%2Fsprite_5Fconnect_5"
		"Fv14.png%7Cb462e0f0g0h0i0k0l0m0%7Chttp%3A%2F%2Flocalhost%3A8079%2Fimg%2Flogo_5Flayer_5Fbottom.png%7Cb462e0f0g0h0i0k0l0m0%7Chttp%3A%2F%2Flocalhost%3A8079%2Fimg%2Flogin%2FLoginwindow_5Ftextbox.png%7Cb462e0f0g0h0i0k0l0m0%7Chttp%3A%2F%2Flocalhost%3A8079%2Fimg%2Fgradient%2FVerlauf_5FGrau_5FButton_5F3.png%7Cb462e0f0g0h0i0k0l0m0%7Chttps%3A%2F%2Fplatform.twitter.com%2Fwidgets%2Fwidget_5Fiframe.bed9e19e565ca3b578705de9e73c29ed.html%3Forigin%3Dhttp_253A_252F_252Flocalhost_253A8079%26settingsEndpoint%3Dhttps"
		"_253A_252F_252Fsyndication.twitter.com_252Fsettings%7Cb492e178m189Bi5%7Chttps%3A%2F%2Fapis.google.com%2F_5F%2Fscs%2Fapps-static%2F_5F%2Fjs%2Fk%3Doz.gapi.pl.de2wM28ILrc.O%2Fm%3Dauth%2Fexm%3Dplusone%2Frt%3Dj%2Fsv%3D1%2Fd%3D1%2Fed%3D1%2Fam%3DwQ%2Frs%3DAGLTcCO5c-Kd6sZuD9hEQyRIuOc1MKFaQA%2Fcb%3Dgapi.loaded_5F1%7Cb497e1m1%7Chttps%3A%2F%2Fapis.google.com%2Fse%2F0%2F_5F%2F%2B1%2Ffastbutton%7Cb515e157f157g157h157i157k157l158m228Bi%7Chttps%3A%2F%2Fplatform.twitter.com%2Fjs%2Fbutton.efa03583c158eb89fd00b8c75"
		"a70efae.js%7Cb521e1m1%7Chttps%3A%2F%2Faccounts.google.com%2Fo%2Foauth2%2FpostmessageRelay%7Cb545e129m215Bi%7Chttp%3A%2F%2Fstaticxx.facebook.com%2Fconnect%2Fxd_5Farbiter%2Fr%2FxaOI6zd9HW9.js%3Fversion%3D42%7Cb595e1m73Bi%7Chttps%3A%2F%2Fstaticxx.facebook.com%2Fconnect%2Fxd_5Farbiter%2Fr%2FxaOI6zd9HW9.js%3Fversion%3D42%7Cb629e140m168Bi%7Chttp%3A%2F%2Fassets.pinterest.com%2Fjs%2Fpinit_5Fmain.js%3F0.5688087694051419%7Cb631e0m95%7Chttps%3A%2F%2Fplatform.twitter.com%2Fwidgets%2Ffollow_5Fbutton.bed9e19e56"
		"5ca3b578705de9e73c29ed.en.html%7Cb647e125m178Bi%7Chttps%3A%2F%2Fplatform.twitter.com%2Fwidgets%2Ffollow_5Fbutton.bed9e19e565ca3b578705de9e73c29ed.en.html%7Cb822m0Bi%7Chttps%3A%2F%2Fwww.facebook.com%2Fplugins%2Flike.php%7Cb861e415f415g415h415i415k415l419m452Bi4%7Chttps%3A%2F%2Fwww.facebook.com%2Fplugins%2Flike.php%7Cb1308m0Bi4%7Chttps%3A%2F%2Flog.pinterest.com%2F%7Cb1773e0m198$url=http%3A%2F%2Flocalhost%3A8079%2Forange-booking-finish.jsf%3FjourneyId%3D9449$title="
		"easyTravel%20-%20Booking%20-%20Finish$isUnload=true$latC=2$visitID=IFEDHEFAOHPTKMBFAJCMFLDKJBCJNIBN$fId=534324386_970$v=10150180628221724$vID=1530534276673RGLPOKT459A1LMBFO13616TBAI7S5Q2Q$time=1530534329239", 
		LAST);

	web_add_cookie("dtPC=1$534329542_11h1vIFEDHEFAOHPTKMBFAJCMFLDKJBCJNIBN; DOMAIN=localhost");

	web_add_cookie("rxvt=1530536129545|1530534276697; DOMAIN=localhost");

	addDynatraceHeaderTest("PC=orange-booking-finish.jsf_3;SI=LoadRunner;LSN=script name;");
	web_url("orange-booking-finish.jsf_3", 
		"URL=http://localhost:8079/orange-booking-finish.jsf?success=1&journeyId=9449", 
		"Resource=0", 
		"RecContentType=text/html", 
		"Referer=http://localhost:8079/orange-booking-finish.jsf?journeyId=9449", 
		"Snapshot=t53.inf", 
		"Mode=HTML", 
		EXTRARES, 
		"Url=/img/gradient/Verlauf_Orange_Button_2.png", "Referer=http://localhost:8079/orange-booking-finish.jsf?success=1&journeyId=9449", ENDITEM, 
		LAST);

	addDynatraceHeaderTest("PC=widget_iframe.bed9e19e565ca3b578705de9e73c29ed.html_5;SI=LoadRunner;LSN=script name;");
	web_url("widget_iframe.bed9e19e565ca3b578705de9e73c29ed.html_5", 
		"URL=https://platform.twitter.com/widgets/widget_iframe.bed9e19e565ca3b578705de9e73c29ed.html?origin=http%3A%2F%2Flocalhost%3A8079&settingsEndpoint=https%3A%2F%2Fsyndication.twitter.com%2Fsettings", 
		"Resource=0", 
		"RecContentType=text/html", 
		"Referer=http://localhost:8079/orange-booking-finish.jsf?success=1&journeyId=9449", 
		"Snapshot=t54.inf", 
		"Mode=HTML", 
		LAST);

	addDynatraceHeaderTest("PC=fastbutton_5;SI=LoadRunner;LSN=script name;");
	web_url("fastbutton_5", 
		"URL=https://apis.google.com/se/0/_/+1/fastbutton?usegapi=1&origin=http%3A%2F%2Flocalhost%3A8079&url=http%3A%2F%2Fwww.dynatrace.com%2F&gsrc=3p&ic=1&jsh=m%3B%2F_%2Fscs%2Fapps-static%2F_%2Fjs%2Fk%3Doz.gapi.pl.de2wM28ILrc.O%2Fm%3D__features__%2Fam%3DwQ%2Frt%3Dj%2Fd%3D1%2Frs%3DAGLTcCO5c-Kd6sZuD9hEQyRIuOc1MKFaQA", 
		"Resource=0", 
		"RecContentType=text/html", 
		"Referer=http://localhost:8079/orange-booking-finish.jsf?success=1&journeyId=9449", 
		"Snapshot=t55.inf", 
		"Mode=HTML", 
		LAST);

	addDynatraceHeaderTest("PC=postmessageRelay_5;SI=LoadRunner;LSN=script name;");
	web_url("postmessageRelay_5", 
		"URL=https://accounts.google.com/o/oauth2/postmessageRelay?parent=http%3A%2F%2Flocalhost%3A8079&jsh=m%3B%2F_%2Fscs%2Fapps-static%2F_%2Fjs%2Fk%3Doz.gapi.pl.de2wM28ILrc.O%2Fm%3D__features__%2Fam%3DwQ%2Frt%3Dj%2Fd%3D1%2Frs%3DAGLTcCO5c-Kd6sZuD9hEQyRIuOc1MKFaQA", 
		"Resource=0", 
		"RecContentType=text/html", 
		"Referer=http://localhost:8079/orange-booking-finish.jsf?success=1&journeyId=9449", 
		"Snapshot=t56.inf", 
		"Mode=HTML", 
		EXTRARES, 
		"Url=http://assets.pinterest.com/js/pinit_main.js?0.034845580390163", "Referer=http://localhost:8079/orange-booking-finish.jsf?success=1&journeyId=9449", ENDITEM, 
		LAST);

	addDynatraceHeaderTest("PC=xaOI6zd9HW9.js_6;SI=LoadRunner;LSN=script name;");
	web_url("xaOI6zd9HW9.js_6", 
		"URL=https://staticxx.facebook.com/connect/xd_arbiter/r/xaOI6zd9HW9.js?version=42", 
		"Resource=0", 
		"RecContentType=text/html", 
		"Referer=http://localhost:8079/orange-booking-finish.jsf?success=1&journeyId=9449", 
		"Snapshot=t57.inf", 
		"Mode=HTML", 
		LAST);

	addDynatraceHeaderTest("PC=follow_button.bed9e19e565ca3b578705de9e73c29ed.en.html_5;SI=LoadRunner;LSN=script name;");
	web_url("follow_button.bed9e19e565ca3b578705de9e73c29ed.en.html_5", 
		"URL=https://platform.twitter.com/widgets/follow_button.bed9e19e565ca3b578705de9e73c29ed.en.html", 
		"Resource=0", 
		"RecContentType=text/html", 
		"Referer=http://localhost:8079/orange-booking-finish.jsf?success=1&journeyId=9449", 
		"Snapshot=t58.inf", 
		"Mode=HTML", 
		LAST);

	addDynatraceHeaderTest("PC=like.php_5;SI=LoadRunner;LSN=script name;");
	web_url("like.php_5", 
		"URL=https://www.facebook.com/plugins/like.php?app_id=&channel=http%3A%2F%2Fstaticxx.facebook.com%2Fconnect%2Fxd_arbiter%2Fr%2FxaOI6zd9HW9.js%3Fversion%3D42%23cb%3Df3ecbbcb781a1d8%26domain%3Dlocalhost%26origin%3Dhttp%253A%252F%252Flocalhost%253A8079%252Ff3db9a69f04b4b%26relation%3Dparent.parent&container_width=850&font=arial&href=http%3A%2F%2Flocalhost%3A8079%2Fwww.dynatrace.com&locale=en_US&sdk=joey&send=false&show_faces=false&width=300", 
		"Resource=0", 
		"RecContentType=text/html", 
		"Referer=http://localhost:8079/orange-booking-finish.jsf?success=1&journeyId=9449", 
		"Snapshot=t59.inf", 
		"Mode=HTML", 
		LAST);

	addDynatraceHeaderTest("PC=jot_4;SI=LoadRunner;LSN=script name;");
	web_submit_data("jot_4", 
		"Action=https://syndication.twitter.com/i/jot", 
		"Method=POST", 
		"RecContentType=text/html", 
		"Referer=", 
		"Snapshot=t60.inf", 
		"Mode=HTML", 
		ITEMDATA, 
		"Name=dnt", "Value=0", ENDITEM, 
		"Name=tfw_redirect", "Value=https://platform.twitter.com/jot.html", ENDITEM, 
		"Name=l", "Value={\"widget_origin\":\"http://localhost:8079/orange-booking-finish.jsf?success=1&journeyId=9449\",\"widget_frame\":false,\"language\":\"en\",\"message\":\"m:withcount:\",\"_category_\":\"tfw_client_event\",\"triggered_on\":1530534330337,\"dnt\":false,\"client_version\":\"910cbce:1530167310832\",\"format_version\":1,\"event_namespace\":{\"client\":\"tfw\",\"page\":\"button\",\"section\":\"follow\",\"action\":\"impression\"}}", ENDITEM, 
		"Name=l", "Value={\"widget_origin\":\"http://localhost:8079/orange-booking-finish.jsf?success=1&journeyId=9449\",\"widget_frame\":null,\"duration_ms\":329.4270629159096,\"_category_\":\"tfw_client_event\",\"triggered_on\":1530534330338,\"dnt\":false,\"client_version\":\"910cbce:1530167310832\",\"format_version\":1,\"event_namespace\":{\"client\":\"tfw\",\"action\":\"render\",\"page\":\"page\",\"component\":\"performance\"}}", ENDITEM, 
		LAST);

	addDynatraceHeaderTest("PC=log.pinterest.com_5;SI=LoadRunner;LSN=script name;");
	web_url("log.pinterest.com_5", 
		"URL=https://log.pinterest.com/?guid=uS1fyx8kc1ZY&tv=2018050702&type=pidget&sub=pl&button_count=1&follow_count=0&pin_count=0&profile_count=0&board_count=0&section_count=0&lang=pl&via=http%3A%2F%2Flocalhost%3A8079%2Forange-booking-finish.jsf%3Fsuccess%3D1%26journeyId%3D9449&callback=PIN_1530534329988.f.callback[0]", 
		"Resource=0", 
		"Referer=http://localhost:8079/orange-booking-finish.jsf?success=1&journeyId=9449", 
		"Snapshot=t61.inf", 
		"Mode=HTML", 
		LAST);

	web_add_cookie("rxvt=1530536132575|1530534276697; DOMAIN=localhost");

	addDynatraceHeaderTest("PC=rb_1_9;SI=LoadRunner;LSN=script name;");
	web_custom_request("rb_1_9", 
		"URL=http://localhost:8079/rb_1?type=js&session=1%2490732712A19CFE460D187D5D153DF84F%7CRUM%2BDefault%2BApplication%7C1&svrid=1&flavor=post&referer=http%3A%2F%2Flocalhost%3A8079%2Forange-booking-finish.jsf%3Fsuccess%3D1%26journeyId%3D9449&visitID=IFEDHEFAOHPTKMBFAJCMFLDKJBCJNIBN", 
		"Method=POST", 
		"Resource=0", 
		"RecContentType=text/plain", 
		"Referer=http://localhost:8079/orange-booking-finish.jsf?success=1&journeyId=9449", 
		"Snapshot=t62.inf", 
		"Mode=HTML", 
		"EncType=text/plain;charset=UTF-8", 
		"Body=$a=d%7C-1%7CFinish%7CC%7C-%7C534324386_970%7C1530534327007%7Chttp%3A%2F%2Flocalhost%3A8079%2Forange-booking-finish.jsf%3FjourneyId%3D9449%7CeasyTravel%20-%20Booking%20-%20Finish%2C1%7C1%7C_load_%7C_load_%7C-%7C1530534329243%7C1530534331366%7C209%7C-%7C-%7C-%7C-%7C-%7Chttp%3A%2F%2Flocalhost%3A8079%2Forange-booking-finish.jsf%3FjourneyId%3D9449%2C2%7C2%7C_onload_%7C_load_%7C-%7C1530534331365%7C1530534331366%7C209$rId=RID_94524396$rpId=865248795$domR=1530534331364$w=1920$h=1082$sw=1920$sh="
		"1200$nt=a0b1530534329243e15f15g15h15i15k34l36m38n36o464p464q521r2121s2122t2123$V=946|c$S=439$fd=j1.8.1^so1.7^six$url=http%3A%2F%2Flocalhost%3A8079%2Forange-booking-finish.jsf%3Fsuccess%3D1%26journeyId%3D9449$title=easyTravel%20-%20Booking%20-%20Finish$vd=5008$latC=17$visitID=IFEDHEFAOHPTKMBFAJCMFLDKJBCJNIBN$fId=534329542_11$v=10150180628221724$vID=1530534276673RGLPOKT459A1LMBFO13616TBAI7S5Q2Q$time=1530534332574", 
		LAST);

	web_add_cookie("dtPC=1$534329542_11h-vIFEDHEFAOHPTKMBFAJCMFLDKJBCJNIBN; DOMAIN=localhost");

	web_add_cookie("rxvt=1530536134011|1530534276697; DOMAIN=localhost");

	web_add_cookie("dtSa=true%7CC%7C-1%7CNew%20Search%7C-%7C1530534333959%7C534329542_11%7Chttp%3A%2F%2Flocalhost%3A8079%2Forange-booking-finish.jsf%3Fsuccess%3D1%26journeyId%3D9449%7CeasyTravel%20-%20Booking%20-%20Finish%7C1530534332576%7C; DOMAIN=localhost");

	addDynatraceHeaderTest("PC=orange.jsf_2;SI=LoadRunner;LSN=script name;");
	web_url("orange.jsf_2", 
		"URL=http://localhost:8079/orange.jsf", 
		"Resource=0", 
		"RecContentType=text/html", 
		"Referer=http://localhost:8079/orange-booking-finish.jsf?success=1&journeyId=9449", 
		"Snapshot=t63.inf", 
		"Mode=HTML", 
		EXTRARES, 
		"Url=http://assets.pinterest.com/js/pinit_main.js?0.3874888186402181", ENDITEM, 
		LAST);

	addDynatraceHeaderTest("PC=rb_1_10;SI=LoadRunner;LSN=script name;");
	web_custom_request("rb_1_10", 
		"URL=http://localhost:8079/rb_1?type=js&session=1%2490732712A19CFE460D187D5D153DF84F%7CRUM%2BDefault%2BApplication%7C1&svrid=1&flavor=post&referer=http%3A%2F%2Flocalhost%3A8079%2Forange-booking-finish.jsf%3Fsuccess%3D1%26journeyId%3D9449&visitID=IFEDHEFAOHPTKMBFAJCMFLDKJBCJNIBN", 
		"Method=POST", 
		"Resource=0", 
		"RecContentType=text/plain", 
		"Referer=http://localhost:8079/orange-booking-finish.jsf?success=1&journeyId=9449", 
		"Snapshot=t64.inf", 
		"Mode=HTML", 
		"EncType=text/plain;charset=UTF-8", 
		"Body=$3p="
		"1-1530534329243%3Blocalhost%7Cu%7C25%7C0%7C0%7C7%7C0%7C25%7C%7C0%7C0%7C0%7C54_55_400_400_463_479%7C0%7C0%7C16%7C13%7C0%7C0%7C13%7C0%7C13%7C%7C0%7C0%7C0%7C43_50_58_60%7C0%7C0%7C1%7C5%7C0%7C0%7C5%7C39_43%7C0%7C0%7C1%7C4%7C0%7C0%7C4%7C51_54%7C1%7C1%7C1%3Bapis.google.com%7Ck%7C1%7C0%7C0%7C1%7C0%7C1%7C%7C0%7C0%7C0%7C51_51%7C1%7C1%7C1%7C3%7C0%7C0%7C2%7C346_348_493_494_517_738%7C74%7C1%7C221%3Bassets.dynatrace.com%7C2%7C1%7C0%7C0%7C0%7C0%7C1%7C%7C0%7C0%7C0%7C54_54%7C0%7C0%7C0%3Bplatform.twitter.com%7Ck%7"
		"C2%7C0%7C0%7C2%7C0%7C2%7C%7C0%7C0%7C0%7C55_56_521_523%7C1%7C1%7C1%7C3%7C0%7C0%7C1%7C488_904%7C158%7C0%7C258%3Bplatform.linkedin.com%7Ck%7C1%7C0%7C0%7C1%7C0%7C1%7C%7C0%7C0%7C0%7C56_57%7C1%7C1%7C1%7C1%7C0%7C0%7C1%7C438_439%7C1%7C1%7C1%3Bassets.pinterest.com%7C6%7C1%7C0%7C0%7C1%7C0%7C1%7C%7C0%7C0%7C0%7C57_57%7C1%7C1%7C1%7C2%7C0%7C0%7C1%7C0%7C2%7C%7C0%7C0%7C0%7C57_58_627_743%7C58%7C1%7C115%3Bconnect.facebook.net%7C4%7C1%7C0%7C0%7C1%7C0%7C1%7C%7C0%7C0%7C0%7C397_398%7C1%7C1%7C1%3Bstatic.licdn.com%7C2%7C"
		"1%7C0%7C0%7C1%7C0%7C1%7C%7C0%7C0%7C0%7C464_464%7C0%7C0%7C0%3Baccounts.google.com%7Cg%7C1%7C0%7C0%7C0%7C545_745%7C200%7C200%7C200%3Bstaticxx.facebook.com%7C4%7C2%7C0%7C0%7C0%7C0%7C2%7C%7C0%7C0%7C0%7C596_877%7C174%7C97%7C251%3Bwww.facebook.com%7Cg%7C2%7C0%7C0%7C1%7C937_2028%7C545%7C0%7C1091%3Blog.pinterest.com%7Cg%7C1%7C0%7C0%7C0%7C1762_2019%7C257%7C257%7C257$rt="
		"1-1530534329243%3Bhttp%3A%2F%2Flocalhost%3A8079%2Fcss%2FBaseProd.css%7Cb39e1f1g1h1i1k1l1m1%7Chttp%3A%2F%2Flocalhost%3A8079%2Fcss%2Ffooter.css%7Cb40e0f0g0h0i0k0l0m1%7Chttp%3A%2F%2Flocalhost%3A8079%2Fcss%2Frime.css%7Cb41e0f0g0h0i0k0l0m1%7Chttp%3A%2F%2Flocalhost%3A8079%2Fcss%2Frating.css%7Cb42e0f0g0h0i0k0l0m0%7Chttp%3A%2F%2Flocalhost%3A8079%2Fcss%2Forange.css%7Cb42e0f0g0h0i0k0l0m1%7Chttp%3A%2F%2Flocalhost%3A8079%2Fjs%2Fjquery-1.8.1.js%7Cb43e0f0g0h0i0k0l0m1%7Chttp%3A%2F%2Flocalhost%3A8079%2Fjs%2Fjquer"
		"y-ui-1.8.2.min.js%7Cb44e0f0g0h0i0k0l0m1%7Chttp%3A%2F%2Flocalhost%3A8079%2Fjs%2Fversion.js%7Cb44e0f0g0h0i0k0l0m1%7Chttp%3A%2F%2Flocalhost%3A8079%2Fjs%2FdtagentApi.js%7Cb45e1f1g1h1i1k1l1m1%7Chttp%3A%2F%2Flocalhost%3A8079%2Fjs%2FFrameworkProd.js%7Cb46e0f0g0h0i0k0l0m1%7Chttp%3A%2F%2Flocalhost%3A8079%2Fjs%2Fjquery.formLabels1.0.js%7Cb47e0f0g0h0i0k0l0m1%7Chttp%3A%2F%2Flocalhost%3A8079%2Fjs%2FheaderRotation.js%7Cb48e0f0g0h0i0k0l0m1%7Chttp%3A%2F%2Flocalhost%3A8079%2Fjs%2Frating.js%7Cb48e0f0g0h0i0k0l0m1%7C"
		"http%3A%2F%2Flocalhost%3A8079%2Fjs%2Frecommendation.js%7Cb49e0f0g0h0i0k0l0m1%7Chttp%3A%2F%2Flocalhost%3A8079%2Fproblempatterns%2Fchangedetectionlib.js%7Cb50e0f0g0h0i0k0l0m0%7Chttp%3A%2F%2Flocalhost%3A8079%2Fjs%2Fusertimings.js%7Cb50e0f0g0h0i0k0l0m1%7Chttps%3A%2F%2Fapis.google.com%2Fjs%2Fplusone.js%7Cb51e0f0g0h0i0k0l0m1%7Chttp%3A%2F%2Flocalhost%3A8079%2Fjavax.faces.resource%2Fjsf.js.jsf%3Fln%3Djavax.faces%7Cb51e0f0g0h0i0k0l0m1%7Chttp%3A%2F%2Flocalhost%3A8079%2Fjavax.faces.resource%2Fbridge.js.jsf%3"
		"Frand%3D963083509%7Cb52e0f0g0h0i0k0l0m1%7Chttp%3A%2F%2Flocalhost%3A8079%2Fjavax.faces.resource%2Fcompat.js.jsf%7Cb53e0f0g0h0i0k0l0m1%7Chttp%3A%2F%2Flocalhost%3A8079%2Fjavax.faces.resource%2Ficefaces-compat.js.jsf%7Cb53e0f0g0h0i0k0l0m1%7Chttp%3A%2F%2Flocalhost%3A8079%2Fimg%2Fapple%2Fapple.png%7Cb54e0f0g0h0i0k0l0m0%7Chttp%3A%2F%2Flocalhost%3A8079%2Fimg%2Fandroidbutton.png%7Cb54e0f0g0h0i0k0l0m0%7Chttp%3A%2F%2Flocalhost%3A8079%2Fimg%2Ffacebookbutton.png%7Cb54e0f0g0h0i0k0l0m0%7Chttp%3A%2F%2Flocalhost%3"
		"A8079%2Fimg%2Ftwitterbutton.png%7Cb54e0f0g0h0i0k0l0m0%7Chttps%3A%2F%2Fassets.dynatrace.com%2Fglobal%2Ficons%2Ffavicon.ico%7Cb54e0f0g0h0i0k0l0m0%7Chttp%3A%2F%2Flocalhost%3A8079%2Fimg%2Frssbutton.png%7Cb54e0f0g0h0i0k0l0m0%7Chttp%3A%2F%2Flocalhost%3A8079%2Fimg%2Fprivacypolicy_5Flock.png%7Cb54e0f0g0h0i0k0l0m0%7Chttp%3A%2F%2Flocalhost%3A8079%2Fimg%2Fbooking%2FeasyTravel_5Fbookingtransaction_5FHeader.png%7Cb55e0f0g0h0i0k0l0m0%7Chttp%3A%2F%2Flocalhost%3A8092%2Fimage%2FeasyTravel_5Fbanner.png%7Cb55e0f0g0h"
		"0i0k0l0m1%7Chttp%3A%2F%2Fplatform.twitter.com%2Fwidgets.js%7Cb55e1m1%7Chttps%3A%2F%2Fplatform.linkedin.com%2Fin.js%7Cb56e0m1%7Chttps%3A%2F%2Fassets.pinterest.com%2Fimages%2Fpidgets%2Fpinit_5Ffg_5Fen_5Frect_5Fgray_5F20.png%7Cb57e0m1%7Chttps%3A%2F%2Fassets.pinterest.com%2Fjs%2Fpinit.js%7Cb57e1m1%7Chttp%3A%2F%2Flocalhost%3A8079%2Fjs%2FGlobalProd.js%7Cb58e1f1g1h1i1k1l1m1%7Chttp%3A%2F%2Flocalhost%3A8079%2Fjs%2Fjquery.js%7Cb59e0f0g0h0i0k0l0m1%7Chttps%3A%2F%2Fapis.google.com%2F_5F%2Fscs%2Fapps-static%2F_"
		"5F%2Fjs%2Fk%3Doz.gapi.pl.de2wM28ILrc.O%2Fm%3Dplusone%2Frt%3Dj%2Fsv%3D1%2Fd%3D1%2Fed%3D1%2Fam%3DwQ%2Frs%3DAGLTcCO5c-Kd6sZuD9hEQyRIuOc1MKFaQA%2Fcb%3Dgapi.loaded_5F0%7Cb346e1m1%7Chttp%3A%2F%2Fconnect.facebook.net%2Fen_5FUS%2Fall.js%23xfbml%3D1%7Cb397e1f1g1h1i1k1l1m1%7Chttp%3A%2F%2Flocalhost%3A8079%2Fimg%2Fheader.png%7Cb400e0f0g0h0i0k0l0m0%7Chttp%3A%2F%2Flocalhost%3A8079%2Fimg%2Fgradient%2FVerlauf_5FGrau_5FLoginbox.png%7Cb400e0f0g0h0i0k0l0m0%7Chttp%3A%2F%2Flocalhost%3A8079%2Fimg%2Fgradient%2FVerlauf_5"
		"FOrange_5FButton_5F4.png%7Cb400e0f0g0h0i0k0l0m0%7Chttp%3A%2F%2Flocalhost%3A8079%2Fimg%2Fgradient%2FVerlauf_5FGrau_5FButton_5F4.png%7Cb400e0f0g0h0i0k0l0m0%7Chttps%3A%2F%2Fplatform.linkedin.com%2Fjs%2FsecureAnonymousFramework%3Fv%3D1.0.328-1429%26lang%3Den_5FUS%7Cb438e1m1%7Chttp%3A%2F%2Flocalhost%3A8079%2Fimg%2Fmenupunkt_5Ftrennung_5Ftransparent.png%7Cb463e0f0g0h0i0k0l0m0%7Chttp%3A%2F%2Flocalhost%3A8079%2Fimg%2Fgradient%2FVerlauf_5FGrau_5FHauptfeld.png%7Cb463e0f0g0h0i0k0l0m0%7Chttp%3A%2F%2Flocalhost"
		"%3A8079%2Fimg%2Fgradient%2FVerlauf_5FOrange_5FHauptfeld.png%7Cb463e0f0g0h0i0k0l0m0%7Chttp%3A%2F%2Flocalhost%3A8079%2Fimg%2Fbooking%2Fstepindicator.png%7Cb463e0f0g0h0i0k0l0m0%7Chttp%3A%2F%2Flocalhost%3A8079%2Fimg%2Fbooking%2Fstepindicator_5F1_5Finactive.png%7Cb463e0f0g0h0i0k0l0m0%7Chttp%3A%2F%2Flocalhost%3A8079%2Fimg%2Fbooking%2Fstepindicator_5F2_5Finactive.png%7Cb463e0f0g0h0i0k0l0m0%7Chttp%3A%2F%2Flocalhost%3A8079%2Fimg%2Fbooking%2Fstepindicator_5F3_5Finactive.png%7Cb463e0f0g0h0i0k0l0m0%7Chttp%3A%"
		"2F%2Flocalhost%3A8079%2Fimg%2Fbooking%2FSlider_5Fempty.png%7Cb463e0f0g0h0i0k0l0m0%7Chttp%3A%2F%2Flocalhost%3A8079%2Fimg%2Fbooking%2Fstepindicator_5F4_5Factive.png%7Cb464e0f0g0h0i0k0l0m0%7Chttp%3A%2F%2Flocalhost%3A8079%2Fimg%2Fgradient%2FVerlauf_5FOrange_5FButton_5F2.png%7Cb464e0f0g0h0i0k0l15m16%7Chttps%3A%2F%2Fstatic.licdn.com%2Fscds%2Fcommon%2Fu%2Fimages%2Fapps%2Fconnect%2Fsprites%2Fsprite_5Fconnect_5Fv14.png%7Cb464e0f0g0h0i0k0l0m0%7Chttp%3A%2F%2Flocalhost%3A8079%2Fimg%2Flogo_5Flayer_5Fbottom.png"
		"%7Cb464e0f0g0h0i0k0l0m0%7Chttp%3A%2F%2Flocalhost%3A8079%2Fimg%2Flogin%2FLoginwindow_5Ftextbox.png%7Cb464e0f0g0h0i0k0l0m0%7Chttp%3A%2F%2Flocalhost%3A8079%2Fimg%2Fgradient%2FVerlauf_5FGrau_5FButton_5F3.png%7Cb464e0f0g0h0i0k0l0m0%7Chttps%3A%2F%2Fplatform.twitter.com%2Fwidgets%2Fwidget_5Fiframe.bed9e19e565ca3b578705de9e73c29ed.html%3Forigin%3Dhttp_253A_252F_252Flocalhost_253A8079%26settingsEndpoint%3Dhttps_253A_252F_252Fsyndication.twitter.com_252Fsettings%7Cb488e206m218Bi5%7Chttps%3A%2F%2Fapis.google"
		".com%2F_5F%2Fscs%2Fapps-static%2F_5F%2Fjs%2Fk%3Doz.gapi.pl.de2wM28ILrc.O%2Fm%3Dauth%2Fexm%3Dplusone%2Frt%3Dj%2Fsv%3D1%2Fd%3D1%2Fed%3D1%2Fam%3DwQ%2Frs%3DAGLTcCO5c-Kd6sZuD9hEQyRIuOc1MKFaQA%2Fcb%3Dgapi.loaded_5F1%7Cb493e1m1%7Chttps%3A%2F%2Fapis.google.com%2Fse%2F0%2F_5F%2F%2B1%2Ffastbutton%7Cb517e179f179g179h179i179k179l180m221Bi%7Chttps%3A%2F%2Fplatform.twitter.com%2Fjs%2Fbutton.efa03583c158eb89fd00b8c75a70efae.js%7Cb521e1m1%7Chttps%3A%2F%2Faccounts.google.com%2Fo%2Foauth2%2FpostmessageRelay%7Cb545e"
		"154m200Bi%7Chttp%3A%2F%2Fstaticxx.facebook.com%2Fconnect%2Fxd_5Farbiter%2Fr%2FxaOI6zd9HW9.js%3Fversion%3D42%7Cb596e1m97Bi%7Chttps%3A%2F%2Fstaticxx.facebook.com%2Fconnect%2Fxd_5Farbiter%2Fr%2FxaOI6zd9HW9.js%3Fversion%3D42%7Cb626e138m251Bi%7Chttp%3A%2F%2Fassets.pinterest.com%2Fjs%2Fpinit_5Fmain.js%3F0.034845580390163%7Cb627e0m115%7Chttps%3A%2F%2Fplatform.twitter.com%2Fwidgets%2Ffollow_5Fbutton.bed9e19e565ca3b578705de9e73c29ed.en.html%7Cb646e205m258Bi%7Chttps%3A%2F%2Fplatform.twitter.com%2Fwidgets%2F"
		"follow_5Fbutton.bed9e19e565ca3b578705de9e73c29ed.en.html%7Cb902m0Bi%7Chttps%3A%2F%2Fwww.facebook.com%2Fplugins%2Flike.php%7Cb937e847f847g847h847i847k847l865m1091Bi4%7Chttps%3A%2F%2Flog.pinterest.com%2F%7Cb1762e1m257%7Chttps%3A%2F%2Fwww.facebook.com%2Fplugins%2Flike.php%7Cb2023m0Bi4$url=http%3A%2F%2Flocalhost%3A8079%2Forange-booking-finish.jsf%3Fsuccess%3D1%26journeyId%3D9449$title=easyTravel%20-%20Booking%20-%20Finish$isUnload=true$latC=1$visitID=IFEDHEFAOHPTKMBFAJCMFLDKJBCJNIBN$fId=534329542_11$v"
		"=10150180628221724$vID=1530534276673RGLPOKT459A1LMBFO13616TBAI7S5Q2Q$time=1530534334011", 
		LAST);

	addDynatraceHeaderTest("PC=widget_iframe.bed9e19e565ca3b578705de9e73c29ed.html_6;SI=LoadRunner;LSN=script name;");
	web_url("widget_iframe.bed9e19e565ca3b578705de9e73c29ed.html_6", 
		"URL=https://platform.twitter.com/widgets/widget_iframe.bed9e19e565ca3b578705de9e73c29ed.html?origin=http%3A%2F%2Flocalhost%3A8079&settingsEndpoint=https%3A%2F%2Fsyndication.twitter.com%2Fsettings", 
		"Resource=0", 
		"RecContentType=text/html", 
		"Referer=http://localhost:8079/orange.jsf", 
		"Snapshot=t65.inf", 
		"Mode=HTML", 
		LAST);

	addDynatraceHeaderTest("PC=fastbutton_6;SI=LoadRunner;LSN=script name;");
	web_url("fastbutton_6", 
		"URL=https://apis.google.com/se/0/_/+1/fastbutton?usegapi=1&origin=http%3A%2F%2Flocalhost%3A8079&url=http%3A%2F%2Fwww.dynatrace.com%2F&gsrc=3p&ic=1&jsh=m%3B%2F_%2Fscs%2Fapps-static%2F_%2Fjs%2Fk%3Doz.gapi.pl.de2wM28ILrc.O%2Fm%3D__features__%2Fam%3DwQ%2Frt%3Dj%2Fd%3D1%2Frs%3DAGLTcCO5c-Kd6sZuD9hEQyRIuOc1MKFaQA", 
		"Resource=0", 
		"RecContentType=text/html", 
		"Referer=http://localhost:8079/orange.jsf", 
		"Snapshot=t66.inf", 
		"Mode=HTML", 
		LAST);

	addDynatraceHeaderTest("PC=postmessageRelay_6;SI=LoadRunner;LSN=script name;");
	web_url("postmessageRelay_6", 
		"URL=https://accounts.google.com/o/oauth2/postmessageRelay?parent=http%3A%2F%2Flocalhost%3A8079&jsh=m%3B%2F_%2Fscs%2Fapps-static%2F_%2Fjs%2Fk%3Doz.gapi.pl.de2wM28ILrc.O%2Fm%3D__features__%2Fam%3DwQ%2Frt%3Dj%2Fd%3D1%2Frs%3DAGLTcCO5c-Kd6sZuD9hEQyRIuOc1MKFaQA", 
		"Resource=0", 
		"RecContentType=text/html", 
		"Referer=http://localhost:8079/orange.jsf", 
		"Snapshot=t67.inf", 
		"Mode=HTML", 
		LAST);

	addDynatraceHeaderTest("PC=follow_button.bed9e19e565ca3b578705de9e73c29ed.en.html_6;SI=LoadRunner;LSN=script name;");
	web_url("follow_button.bed9e19e565ca3b578705de9e73c29ed.en.html_6", 
		"URL=https://platform.twitter.com/widgets/follow_button.bed9e19e565ca3b578705de9e73c29ed.en.html", 
		"Resource=0", 
		"RecContentType=text/html", 
		"Referer=http://localhost:8079/orange.jsf", 
		"Snapshot=t68.inf", 
		"Mode=HTML", 
		LAST);

	addDynatraceHeaderTest("PC=xaOI6zd9HW9.js_7;SI=LoadRunner;LSN=script name;");
	web_url("xaOI6zd9HW9.js_7", 
		"URL=https://staticxx.facebook.com/connect/xd_arbiter/r/xaOI6zd9HW9.js?version=42", 
		"Resource=0", 
		"RecContentType=text/html", 
		"Referer=http://localhost:8079/orange.jsf", 
		"Snapshot=t69.inf", 
		"Mode=HTML", 
		LAST);

	addDynatraceHeaderTest("PC=like.php_6;SI=LoadRunner;LSN=script name;");
	web_url("like.php_6", 
		"URL=https://www.facebook.com/plugins/like.php?app_id=&channel=http%3A%2F%2Fstaticxx.facebook.com%2Fconnect%2Fxd_arbiter%2Fr%2FxaOI6zd9HW9.js%3Fversion%3D42%23cb%3Df38bb36ed573204%26domain%3Dlocalhost%26origin%3Dhttp%253A%252F%252Flocalhost%253A8079%252Ff3153c0432816b%26relation%3Dparent.parent&container_width=850&font=arial&href=http%3A%2F%2Flocalhost%3A8079%2Fwww.dynatrace.com&locale=en_US&sdk=joey&send=false&show_faces=false&width=300", 
		"Resource=0", 
		"RecContentType=text/html", 
		"Referer=http://localhost:8079/orange.jsf", 
		"Snapshot=t70.inf", 
		"Mode=HTML", 
		LAST);

	addDynatraceHeaderTest("PC=log.pinterest.com_6;SI=LoadRunner;LSN=script name;");
	web_url("log.pinterest.com_6", 
		"URL=https://log.pinterest.com/?guid=hZDcZ7TYKvsQ&tv=2018050702&type=pidget&sub=pl&button_count=1&follow_count=0&pin_count=0&profile_count=0&board_count=0&section_count=0&lang=pl&via=http%3A%2F%2Flocalhost%3A8079%2Forange.jsf&callback=PIN_1530534334961.f.callback[0]", 
		"Resource=0", 
		"Referer=http://localhost:8079/orange.jsf", 
		"Snapshot=t71.inf", 
		"Mode=HTML", 
		LAST);

	web_add_cookie("dtPC=1$534334382_303h1vIFEDHEFAOHPTKMBFAJCMFLDKJBCJNIBN; DOMAIN=localhost");

	web_add_cookie("rxvt=1530536138089|1530534276697; DOMAIN=localhost");

	web_add_cookie("dtSa=true%7CC%7C-1%7CLogout%7C-%7C1530534338029%7C534334382_303%7Chttp%3A%2F%2Flocalhost%3A8079%2Forange.jsf%7CeasyTravel%20-%20One%20step%20to%20happiness%7C1530534332576%7C; DOMAIN=localhost");

	web_add_cookie("dtLatC=38; DOMAIN=localhost");

	addDynatraceHeaderTest("PC=j_invalidate_session;SI=LoadRunner;LSN=script name;");
	web_url("j_invalidate_session", 
		"URL=http://localhost:8079/j_invalidate_session", 
		"Resource=0", 
		"RecContentType=text/html", 
		"Referer=http://localhost:8079/orange.jsf", 
		"Snapshot=t72.inf", 
		"Mode=HTML", 
		LAST);

	web_add_cookie("JSESSIONID=72EB3CB4C6062B6D52E6E59F8724DFC2.jvmRoute-8280; DOMAIN=localhost");

	addDynatraceHeaderTest("PC=rb_1_11;SI=LoadRunner;LSN=script name;");
	web_custom_request("rb_1_11", 
		"URL=http://localhost:8079/rb_1?type=js&session=1%2490732712A19CFE460D187D5D153DF84F%7CRUM%2BDefault%2BApplication%7C1&svrid=1&flavor=post&referer=http%3A%2F%2Flocalhost%3A8079%2Forange.jsf&visitID=IFEDHEFAOHPTKMBFAJCMFLDKJBCJNIBN", 
		"Method=POST", 
		"Resource=0", 
		"RecContentType=text/plain", 
		"Referer=http://localhost:8079/orange.jsf", 
		"Snapshot=t73.inf", 
		"Mode=HTML", 
		"EncType=text/plain;charset=UTF-8", 
		"Body=$a=d%7C-1%7CNew%20Search%7CC%7C-%7C534329542_11%7C1530534333959%7Chttp%3A%2F%2Flocalhost%3A8079%2Forange-booking-finish.jsf%3Fsuccess%3D1%26journeyId%3D9449%7CeasyTravel%20-%20Booking%20-%20Finish%2C1%7C1%7C_load_%7C_load_%7C-%7C1530534334015%7C0%7C341%7C-%7C-%7C-%7C-%7C-%7Chttp%3A%2F%2Flocalhost%3A8079%2Forange-booking-finish.jsf%3Fsuccess%3D1%26journeyId%3D9449$rId=RID_-1981805739$rpId=1544108374$domR=1530534334569$w=1920$h=1082$sw=1920$sh=1200$nt="
		"a0b1530534334015e45f45g45h45i45k76l79m81n79o554p554q606$V=3968|f$S=501$fd=j1.8.1^so1.7^six$url=http%3A%2F%2Flocalhost%3A8079%2Forange.jsf$title=easyTravel%20-%20One%20step%20to%20happiness$vd=5511$isUnload=true$latC=38$visitID=IFEDHEFAOHPTKMBFAJCMFLDKJBCJNIBN$fId=534334382_303$v=10150180628221724$vID=1530534276673RGLPOKT459A1LMBFO13616TBAI7S5Q2Q$time=1530534338088", 
		LAST);

	addDynatraceHeaderTest("PC=jot_5;SI=LoadRunner;LSN=script name;");
	web_submit_data("jot_5", 
		"Action=https://syndication.twitter.com/i/jot", 
		"Method=POST", 
		"RecContentType=text/html", 
		"Referer=", 
		"Snapshot=t74.inf", 
		"Mode=HTML", 
		ITEMDATA, 
		"Name=dnt", "Value=0", ENDITEM, 
		"Name=tfw_redirect", "Value=https://platform.twitter.com/jot.html", ENDITEM, 
		"Name=l", "Value={\"widget_origin\":\"http://localhost:8079/orange.jsf\",\"widget_frame\":false,\"language\":\"en\",\"message\":\"m:withcount:\",\"_category_\":\"tfw_client_event\",\"triggered_on\":1530534335137,\"dnt\":false,\"client_version\":\"910cbce:1530167310832\",\"format_version\":1,\"event_namespace\":{\"client\":\"tfw\",\"page\":\"button\",\"section\":\"follow\",\"action\":\"impression\"}}", ENDITEM, 
		"Name=l", "Value={\"widget_origin\":\"http://localhost:8079/orange.jsf\",\"widget_frame\":null,\"duration_ms\":209.37995274728064,\"_category_\":\"tfw_client_event\",\"triggered_on\":1530534335137,\"dnt\":false,\"client_version\":\"910cbce:1530167310832\",\"format_version\":1,\"event_namespace\":{\"client\":\"tfw\",\"action\":\"render\",\"page\":\"page\",\"component\":\"performance\"}}", ENDITEM, 
		LAST);

	addDynatraceHeaderTest("PC=j_invalidate_session_2;SI=LoadRunner;LSN=script name;");
	web_url("j_invalidate_session_2", 
		"URL=http://localhost:8079/j_invalidate_session", 
		"Resource=0", 
		"RecContentType=text/html", 
		"Referer=http://localhost:8079/orange.jsf", 
		"Snapshot=t75.inf", 
		"Mode=HTML", 
		EXTRARES, 
		"Url=http://assets.pinterest.com/js/pinit_main.js?0.0728040569722922", "Referer=http://localhost:8079/logout.jsf", ENDITEM, 
		LAST);

	addDynatraceHeaderTest("PC=widget_iframe.bed9e19e565ca3b578705de9e73c29ed.html_7;SI=LoadRunner;LSN=script name;");
	web_url("widget_iframe.bed9e19e565ca3b578705de9e73c29ed.html_7", 
		"URL=https://platform.twitter.com/widgets/widget_iframe.bed9e19e565ca3b578705de9e73c29ed.html?origin=http%3A%2F%2Flocalhost%3A8079&settingsEndpoint=https%3A%2F%2Fsyndication.twitter.com%2Fsettings", 
		"Resource=0", 
		"RecContentType=text/html", 
		"Referer=http://localhost:8079/logout.jsf", 
		"Snapshot=t76.inf", 
		"Mode=HTML", 
		LAST);

	addDynatraceHeaderTest("PC=fastbutton_7;SI=LoadRunner;LSN=script name;");
	web_url("fastbutton_7", 
		"URL=https://apis.google.com/se/0/_/+1/fastbutton?usegapi=1&origin=http%3A%2F%2Flocalhost%3A8079&url=http%3A%2F%2Fwww.dynatrace.com%2F&gsrc=3p&ic=1&jsh=m%3B%2F_%2Fscs%2Fapps-static%2F_%2Fjs%2Fk%3Doz.gapi.pl.de2wM28ILrc.O%2Fm%3D__features__%2Fam%3DwQ%2Frt%3Dj%2Fd%3D1%2Frs%3DAGLTcCO5c-Kd6sZuD9hEQyRIuOc1MKFaQA", 
		"Resource=0", 
		"RecContentType=text/html", 
		"Referer=http://localhost:8079/logout.jsf", 
		"Snapshot=t77.inf", 
		"Mode=HTML", 
		LAST);

	addDynatraceHeaderTest("PC=postmessageRelay_7;SI=LoadRunner;LSN=script name;");
	web_url("postmessageRelay_7", 
		"URL=https://accounts.google.com/o/oauth2/postmessageRelay?parent=http%3A%2F%2Flocalhost%3A8079&jsh=m%3B%2F_%2Fscs%2Fapps-static%2F_%2Fjs%2Fk%3Doz.gapi.pl.de2wM28ILrc.O%2Fm%3D__features__%2Fam%3DwQ%2Frt%3Dj%2Fd%3D1%2Frs%3DAGLTcCO5c-Kd6sZuD9hEQyRIuOc1MKFaQA", 
		"Resource=0", 
		"RecContentType=text/html", 
		"Referer=http://localhost:8079/logout.jsf", 
		"Snapshot=t78.inf", 
		"Mode=HTML", 
		LAST);

	web_add_cookie("dtPC=1$534334382_303h1p1$534338958_59h1vIFEDHEFAOHPTKMBFAJCMFLDKJBCJNIBN; DOMAIN=localhost");

	web_add_cookie("rxvt=1530536139060|1530534276697; DOMAIN=localhost");

	web_add_cookie("dtLatC=53; DOMAIN=localhost");

	addDynatraceHeaderTest("PC=rb_1_12;SI=LoadRunner;LSN=script name;");
	web_custom_request("rb_1_12", 
		"URL=http://localhost:8079/rb_1?type=js&session=1%2490732712A19CFE460D187D5D153DF84F%7CRUM%2BDefault%2BApplication%7C1&svrid=1&flavor=post&referer=http%3A%2F%2Flocalhost%3A8079%2Flogout.jsf&visitID=IFEDHEFAOHPTKMBFAJCMFLDKJBCJNIBN", 
		"Method=POST", 
		"Resource=0", 
		"RecContentType=text/plain", 
		"Referer=http://localhost:8079/logout.jsf", 
		"Snapshot=t79.inf", 
		"Mode=HTML", 
		"EncType=text/plain;charset=UTF-8", 
		"Body=$a=1%7C2%7Cvisit%20end%7C_endVisit_%7C-%7C1530534339057%7C1530534339057%7C-1$rId=RID_-838773383$rpId=-1669656246$fd=j1.8.1^so1.7^six$url=http%3A%2F%2Flocalhost%3A8079%2Flogout.jsf$title=easyTravel%20-%20Logout$vd=6483$latC=53$visitID=IFEDHEFAOHPTKMBFAJCMFLDKJBCJNIBN$fId=534338958_59$v=10150180628221724$vID=1530534276673RGLPOKT459A1LMBFO13616TBAI7S5Q2Q$time=1530534339060", 
		LAST);

	addDynatraceHeaderTest("PC=follow_button.bed9e19e565ca3b578705de9e73c29ed.en.html_7;SI=LoadRunner;LSN=script name;");
	web_url("follow_button.bed9e19e565ca3b578705de9e73c29ed.en.html_7", 
		"URL=https://platform.twitter.com/widgets/follow_button.bed9e19e565ca3b578705de9e73c29ed.en.html", 
		"Resource=0", 
		"RecContentType=text/html", 
		"Referer=http://localhost:8079/logout.jsf", 
		"Snapshot=t80.inf", 
		"Mode=HTML", 
		LAST);

	addDynatraceHeaderTest("PC=xaOI6zd9HW9.js_8;SI=LoadRunner;LSN=script name;");
	web_url("xaOI6zd9HW9.js_8", 
		"URL=https://staticxx.facebook.com/connect/xd_arbiter/r/xaOI6zd9HW9.js?version=42", 
		"Resource=0", 
		"RecContentType=text/html", 
		"Referer=http://localhost:8079/logout.jsf", 
		"Snapshot=t81.inf", 
		"Mode=HTML", 
		LAST);

	addDynatraceHeaderTest("PC=like.php_7;SI=LoadRunner;LSN=script name;");
	web_url("like.php_7", 
		"URL=https://www.facebook.com/plugins/like.php?app_id=&channel=http%3A%2F%2Fstaticxx.facebook.com%2Fconnect%2Fxd_arbiter%2Fr%2FxaOI6zd9HW9.js%3Fversion%3D42%23cb%3Dfd1598f6287bf5%26domain%3Dlocalhost%26origin%3Dhttp%253A%252F%252Flocalhost%253A8079%252Ffde7b793e2cfe9%26relation%3Dparent.parent&container_width=850&font=arial&href=http%3A%2F%2Flocalhost%3A8079%2Fwww.dynatrace.com&locale=en_US&sdk=joey&send=false&show_faces=false&width=300", 
		"Resource=0", 
		"RecContentType=text/html", 
		"Referer=http://localhost:8079/logout.jsf", 
		"Snapshot=t82.inf", 
		"Mode=HTML", 
		LAST);

	addDynatraceHeaderTest("PC=jot_6;SI=LoadRunner;LSN=script name;");
	web_submit_data("jot_6", 
		"Action=https://syndication.twitter.com/i/jot", 
		"Method=POST", 
		"RecContentType=text/html", 
		"Referer=", 
		"Snapshot=t83.inf", 
		"Mode=HTML", 
		ITEMDATA, 
		"Name=dnt", "Value=0", ENDITEM, 
		"Name=tfw_redirect", "Value=https://platform.twitter.com/jot.html", ENDITEM, 
		"Name=l", "Value={\"widget_origin\":\"http://localhost:8079/logout.jsf\",\"widget_frame\":false,\"language\":\"en\",\"message\":\"m:withcount:\",\"_category_\":\"tfw_client_event\",\"triggered_on\":1530534339633,\"dnt\":false,\"client_version\":\"910cbce:1530167310832\",\"format_version\":1,\"event_namespace\":{\"client\":\"tfw\",\"page\":\"button\",\"section\":\"follow\",\"action\":\"impression\"}}", ENDITEM, 
		"Name=l", "Value={\"widget_origin\":\"http://localhost:8079/logout.jsf\",\"widget_frame\":null,\"duration_ms\":204.81889926309827,\"_category_\":\"tfw_client_event\",\"triggered_on\":1530534339633,\"dnt\":false,\"client_version\":\"910cbce:1530167310832\",\"format_version\":1,\"event_namespace\":{\"client\":\"tfw\",\"action\":\"render\",\"page\":\"page\",\"component\":\"performance\"}}", ENDITEM, 
		LAST);

	addDynatraceHeaderTest("PC=log.pinterest.com_7;SI=LoadRunner;LSN=script name;");
	web_url("log.pinterest.com_7", 
		"URL=https://log.pinterest.com/?guid=yKy0HPdLED1V&tv=2018050702&type=pidget&sub=pl&button_count=1&follow_count=0&pin_count=0&profile_count=0&board_count=0&section_count=0&lang=pl&via=http%3A%2F%2Flocalhost%3A8079%2Flogout.jsf&callback=PIN_1530534339412.f.callback[0]", 
		"Resource=0", 
		"Referer=http://localhost:8079/logout.jsf", 
		"Snapshot=t84.inf", 
		"Mode=HTML", 
		LAST);

	web_add_cookie("dtPC=1$534334382_303h1p1$534338958_59h1vIFEDHEFBKIJNPMBFAJCMEPMMHECJNIBN; DOMAIN=localhost");

	web_add_cookie("rxvt=1530536141947|1530534339061; DOMAIN=localhost");

	web_add_cookie("dtSa=true%7CC%7C-1%7CClick%20here%20to%20return%20to%20the%20home%20page.%7C-%7C1530534341895%7C534338958_59%7Chttp%3A%2F%2Flocalhost%3A8079%2Flogout.jsf%7CeasyTravel%20-%20Logout%7C1530534339061%7C; DOMAIN=localhost");

	addDynatraceHeaderTest("PC=localhost:8079_2;SI=LoadRunner;LSN=script name;");
	web_url("localhost:8079_2", 
		"URL=http://localhost:8079/", 
		"Resource=0", 
		"RecContentType=text/html", 
		"Referer=http://localhost:8079/logout.jsf", 
		"Snapshot=t85.inf", 
		"Mode=HTML", 
		EXTRARES, 
		"Url=http://assets.pinterest.com/js/pinit_main.js?0.08245911620938023", ENDITEM, 
		LAST);

	addDynatraceHeaderTest("PC=rb_1_13;SI=LoadRunner;LSN=script name;");
	web_custom_request("rb_1_13", 
		"URL=http://localhost:8079/rb_1?type=js&session=1%2490732712A19CFE460D187D5D153DF84F%7CRUM%2BDefault%2BApplication%7C1&svrid=1&flavor=post&referer=http%3A%2F%2Flocalhost%3A8079%2Flogout.jsf&visitID=IFEDHEFBKIJNPMBFAJCMEPMMHECJNIBN", 
		"Method=POST", 
		"Resource=0", 
		"RecContentType=text/plain", 
		"Referer=http://localhost:8079/logout.jsf", 
		"Snapshot=t86.inf", 
		"Mode=HTML", 
		"EncType=text/plain;charset=UTF-8", 
		"Body=$a=d%7C-1%7CLogout%7CC%7C-%7C534334382_303%7C1530534338029%7Chttp%3A%2F%2Flocalhost%3A8079%2Forange.jsf%7CeasyTravel%20-%20One%20step%20to%20happiness%2C1%7C1%7C_load_%7C_load_%7C-%7C1530534338242%7C0%7C124%7C-%7C-%7C-%7C-%7C-%7Chttp%3A%2F%2Flocalhost%3A8079%2Forange.jsf%2C2%7C3%7C_onload_%7C_load_%7C-%7C1530534340437%7C1530534340439%7C202$rId=RID_-838773383$rpId=-1669656246$domR=1530534340436$w=1920$h=1082$sw=1920$sh=1200$nt="
		"a0b1530534338242c50d92e92f92g92h92i92k92l92m94n92o889p889q938r2194s2195t2197$V=1259|c$S=862$url=http%3A%2F%2Flocalhost%3A8079%2Flogout.jsf$title=easyTravel%20-%20Logout$vd=2884$isUnload=true$latC=53$visitID=IFEDHEFBKIJNPMBFAJCMEPMMHECJNIBN$fId=534338958_59$v=10150180628221724$vID=1530534276673RGLPOKT459A1LMBFO13616TBAI7S5Q2Q$time=1530534341947", 
		LAST);

	addDynatraceHeaderTest("PC=widget_iframe.bed9e19e565ca3b578705de9e73c29ed.html_8;SI=LoadRunner;LSN=script name;");
	web_url("widget_iframe.bed9e19e565ca3b578705de9e73c29ed.html_8", 
		"URL=https://platform.twitter.com/widgets/widget_iframe.bed9e19e565ca3b578705de9e73c29ed.html?origin=http%3A%2F%2Flocalhost%3A8079&settingsEndpoint=https%3A%2F%2Fsyndication.twitter.com%2Fsettings", 
		"Resource=0", 
		"RecContentType=text/html", 
		"Referer=http://localhost:8079/", 
		"Snapshot=t87.inf", 
		"Mode=HTML", 
		LAST);

	addDynatraceHeaderTest("PC=fastbutton_8;SI=LoadRunner;LSN=script name;");
	web_url("fastbutton_8", 
		"URL=https://apis.google.com/se/0/_/+1/fastbutton?usegapi=1&origin=http%3A%2F%2Flocalhost%3A8079&url=http%3A%2F%2Fwww.dynatrace.com%2F&gsrc=3p&ic=1&jsh=m%3B%2F_%2Fscs%2Fapps-static%2F_%2Fjs%2Fk%3Doz.gapi.pl.de2wM28ILrc.O%2Fm%3D__features__%2Fam%3DwQ%2Frt%3Dj%2Fd%3D1%2Frs%3DAGLTcCO5c-Kd6sZuD9hEQyRIuOc1MKFaQA", 
		"Resource=0", 
		"RecContentType=text/html", 
		"Referer=http://localhost:8079/", 
		"Snapshot=t88.inf", 
		"Mode=HTML", 
		LAST);

	addDynatraceHeaderTest("PC=postmessageRelay_8;SI=LoadRunner;LSN=script name;");
	web_url("postmessageRelay_8", 
		"URL=https://accounts.google.com/o/oauth2/postmessageRelay?parent=http%3A%2F%2Flocalhost%3A8079&jsh=m%3B%2F_%2Fscs%2Fapps-static%2F_%2Fjs%2Fk%3Doz.gapi.pl.de2wM28ILrc.O%2Fm%3D__features__%2Fam%3DwQ%2Frt%3Dj%2Fd%3D1%2Frs%3DAGLTcCO5c-Kd6sZuD9hEQyRIuOc1MKFaQA", 
		"Resource=0", 
		"RecContentType=text/html", 
		"Referer=http://localhost:8079/", 
		"Snapshot=t89.inf", 
		"Mode=HTML", 
		LAST);

	addDynatraceHeaderTest("PC=follow_button.bed9e19e565ca3b578705de9e73c29ed.en.html_8;SI=LoadRunner;LSN=script name;");
	web_url("follow_button.bed9e19e565ca3b578705de9e73c29ed.en.html_8", 
		"URL=https://platform.twitter.com/widgets/follow_button.bed9e19e565ca3b578705de9e73c29ed.en.html", 
		"Resource=0", 
		"RecContentType=text/html", 
		"Referer=http://localhost:8079/", 
		"Snapshot=t90.inf", 
		"Mode=HTML", 
		LAST);

	addDynatraceHeaderTest("PC=xaOI6zd9HW9.js_9;SI=LoadRunner;LSN=script name;");
	web_url("xaOI6zd9HW9.js_9", 
		"URL=https://staticxx.facebook.com/connect/xd_arbiter/r/xaOI6zd9HW9.js?version=42", 
		"Resource=0", 
		"RecContentType=text/html", 
		"Referer=http://localhost:8079/", 
		"Snapshot=t91.inf", 
		"Mode=HTML", 
		LAST);

	addDynatraceHeaderTest("PC=like.php_8;SI=LoadRunner;LSN=script name;");
	web_url("like.php_8", 
		"URL=https://www.facebook.com/plugins/like.php?app_id=&channel=http%3A%2F%2Fstaticxx.facebook.com%2Fconnect%2Fxd_arbiter%2Fr%2FxaOI6zd9HW9.js%3Fversion%3D42%23cb%3Df396528c7d57984%26domain%3Dlocalhost%26origin%3Dhttp%253A%252F%252Flocalhost%253A8079%252Ff853dcf6ad4ac4%26relation%3Dparent.parent&container_width=850&font=arial&href=http%3A%2F%2Flocalhost%3A8079%2Fwww.dynatrace.com&locale=en_US&sdk=joey&send=false&show_faces=false&width=300", 
		"Resource=0", 
		"RecContentType=text/html", 
		"Referer=http://localhost:8079/", 
		"Snapshot=t92.inf", 
		"Mode=HTML", 
		LAST);

	return 0;
}
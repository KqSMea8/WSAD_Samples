<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<HTML>
<HEAD>
<META name="GENERATOR" content="IBM WebSphere Studio">
<META http-equiv="Content-Style-Type" content="text/css">
<LINK href="/TimeApp/theme/Master.css" rel="stylesheet" type="text/css">
<TITLE>TimeApp Application Error Page</TITLE>
<%@page session="true" isThreadSafe="true" isErrorPage="true"%>
</HEAD>
<BODY>
<H1>Error Occurred in Time Sheet Application<BR>
<% if (exception != null) {
    out.println("<h1>Exception: " + exception.getMessage() + "</h1>");
} %><BR>
<A href="/TimeApp/index.html"><IMG src="/TimeApp/images/HomeButton.gif" width="113" height="30" border="0"></A></H1>
</BODY>
</HTML>

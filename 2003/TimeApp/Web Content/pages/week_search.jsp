<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">
<!-- Sample HTML file -->
<%@taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<html:html locale="false">
<HEAD>
<META http-equiv="Content-Style-Type" content="text/css">
<TITLE>Employee TimeSheet Search</TITLE>
<LINK href="/TimeApp/theme/Master.css" rel="stylesheet" type="text/css">

</HEAD>

<BODY BGCOLOR="#FFFFFF">
<jsp:useBean class="com.wsbook.casestudy.util.Formatter" id="formatter"
	scope="session" />
<FONT COLOR="#FF0000"><html:errors /></FONT>
<html:form action="EmployeeTimeSheet.do">

<TABLE WIDTH="75%" BORDER="0" BGCOLOR="#777999" CELLSPACING="0"
	CELLPADDING="1">
	<TBODY>
		<TR>
			<TD>
			<TABLE width="100%" border="0" bgcolor="#FFFFFF" cellspacing="0"
				cellpadding="3">
				<TBODY>
					<TR>
						<TD colspan="3" bgcolor="#009900" align="center">
						<H1><B>Employee TimeSheet Search</B></H1>
						</TD>
					</TR>
					<TR>
						<TD ALIGN="right"><B>Employee:</B></TD>

						<TD><html:select property="submitterId">
							<html:options collection="employees" property="id"
								labelProperty="name"></html:options>
						</html:select></TD>

						<TD>&nbsp;</TD>
					</TR>
					<TR>
						<TD ALIGN="right"><B>Week Ending:</B></TD>
						<TD><html:text property="weekending"/></TD>
						<TD ALIGN="left"><I>( mm/dd/yyyy )</I></TD>
					</TR>
					<TR>
						<TD>&nbsp;</TD>
						<TD><html:submit>Search</html:submit></TD>
						<TD>&nbsp;</TD>
					</TR>
				</TBODY>
			</TABLE>
			</TD>
		</TR>
	</TBODY>
</TABLE>

</html:form>
<P><I><FONT color="#000000">Select an employee. Optionally specify a
weekending date. <BR>
If the </FONT>date is not found or not specified, then a list of
existing weekend dates will be displayed.</I> <BR>
Also, <I>If the date is not already defined, a <B>CREATE</B> link will
be supplied.</I><BR>
<BR>

</P>
<TABLE width="80%">
	<TBODY>
		<TR>
			<TD><A href="/TimeApp/index.html"><IMG
				src="/TimeApp/images/HomeButton.gif" width="113" height="30"
				border="0"></A></TD>
			<TD align="right">Active Date Format: <%--METADATA type="DynamicData" startspan
<WSPX:PROPERTY property="formatter.displayFormat">
--%>
				<%= formatter.getDisplayFormat() %>
			<%--METADATA type="DynamicData" endspan--%></TD>
			<TD><A href="/TimeApp/pages/setdatepreference.jsp"><IMG
				src="/TimeApp/images/ChangeDateFormatButton.gif" width="202"
				height="30" border="0"></A></TD>
		</TR>
		<TR>
			<TD></TD>
			<TD></TD>
			<TD></TD>
		</TR>
	</TBODY>
</TABLE>
</BODY>
</html:html>

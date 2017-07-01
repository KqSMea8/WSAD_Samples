<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<HTML>
<HEAD>
<META name="GENERATOR" content="IBM WebSphere Studio">
<META http-equiv="Content-Style-Type" content="text/css">
<LINK href="/TimeApp/theme/Master.css" rel="stylesheet" type="text/css">
<TITLE>Select TimeSheet for Employee</TITLE>
<%@taglib uri="http://www.wsbook.com/taglib" prefix="timeApp"%>
</HEAD>
<BODY>
<jsp:useBean class="com.wsbook.casestudy.value.WeekEndings"
	id="weekendings" scope="request" />
<jsp:useBean class="com.wsbook.casestudy.domain.Employee" id="employee"
	scope="request" />
<jsp:useBean id="create" class="java.lang.String" scope="request" />
<jsp:useBean class="com.wsbook.casestudy.util.Formatter" id="formatter"
	scope="session" />
<FORM method="POST" action="/TimeApp/TimeSheetSelect.do">
<TABLE border="1" width="80%">
	<COL span="1" width="75%">
	<TBODY>
		<TR>
			<TD bgcolor="#00ffff" colspan="2">

			<H1 align="center">Timesheets available for <%= employee.getName() %></H1>
			</TD>
		</TR>
		<TR bgcolor="#cccccc">
			<TD align="right"><B>Weekending</B></TD>
			<TD align="center"><B>Select/Create</B></TD>
		</TR>
		<%
try {
  com.wsbook.casestudy.value.WeekEnding[] _a0 = weekendings.getWeekEnding();
  com.wsbook.casestudy.value.WeekEnding _p0 = _a0[0]; // throws an exception if empty. 
     for (int _i0 = 0; ; ) { %>
		<TR bgcolor="#80ff80">
			<TD align="right"><timeApp:formatDate calendar="<%= _p0.getDate() %>"
				formatId="formatter"></timeApp:formatDate></TD>
			<TD align="center"><INPUT name="weekending" type="radio"
				value="<%= _p0.getIdString() %>"></TD>
		</TR>
		<%
        _i0++;
        try {
          _p0 = _a0[_i0];
        }
        catch (java.lang.ArrayIndexOutOfBoundsException _e0) {
          break;
        }
      } 
      
}
catch (java.lang.ArrayIndexOutOfBoundsException _e0) { // skip row(s)
}  if (!create.equals("")) { %>
		<TR bgcolor="#ff80ff">
			<TD align="right"><B>Create</B> - <%= create %></TD>
			<TD align="center"><INPUT name="weekending" type="radio"
				value="<%= create %>"></TD>
		</TR>
		<% } %>
		<TR>
			<TD align="center" colspan="2"><INPUT name="Select" type="submit"
				value="Select or Create"></TD>
		</TR>
	</TBODY>
</TABLE>
<INPUT name="submitterId" type="hidden" value="<%= employee.getId() %>"></FORM>
<P><BR>
</P>
<TABLE width="80%">
	<TBODY>
		<TR>
			<TD><A href="/TimeApp/index.html"><IMG
				src="/TimeApp/images/HomeButton.gif" width="113" height="30"
				border="0"></A></TD>
			<TD align="right">Active Date Format: <%= formatter.getDisplayFormat() %></TD>
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
</HTML>

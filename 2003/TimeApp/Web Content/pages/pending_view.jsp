<!-- Sample HTML file -->
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">
<%@taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<html:html locale="false">
<HEAD>

<META name="GENERATOR" content="IBM WebSphere Page Designer V3.5 for Windows">
<META http-equiv="Content-Style-Type" content="text/css">
<TITLE>Pending Time Sheets</TITLE>
<LINK href="/TimeApp/theme/Master.css" rel="stylesheet" type="text/css">
<%@taglib uri="http://www.wsbook.com/taglib" prefix="timeApp"%>
</HEAD>

<BODY BGCOLOR="#FFFFFF">
<jsp:useBean id="timesheet" type="com.wsbook.casestudy.domain.TimeSheet" scope="request"/>
<jsp:useBean id="projects" type="com.wsbook.casestudy.value.Projects" scope="request"/>
<jsp:useBean class="com.wsbook.casestudy.util.Formatter" id="formatter" scope="session"/>
<html:errors/>

<P align="center"><IMG src="/TimeApp/images/PendingTSLogo.gif" width="442" height="95" border="0"><BR>
</P>
<FORM action="/TimeApp/UpdateTimeSheet.do" method="POST">

<TABLE width="100%" border="0" cellpadding="3" cellspacing="0">
	
    <TR BGCOLOR="#EEEECC">
		<TD colspan="3" bgcolor="#009900"><FONT SIZE="4" CLASS=FOUR><B><A NAME="performance">
		<%= timesheet.getEmployee().getName() %> - Week Ending: <%= timesheet.getFormattedWeekend() %></A></B></FONT></TD>
		<TD bgcolor="#009900" align="right"><B>Pending</B>&nbsp;</TD>
	</TR>
	
<%
try {
  com.wsbook.casestudy.domain.TimeSheetEntry[] _a0 = timesheet.getEntry();
  com.wsbook.casestudy.domain.TimeSheetEntry _p0 = _a0[0]; // throws an exception if empty. %>
    <TR BGCOLOR="#99cccc">
		<TD align="center" width="5%" bgcolor="#98e179"><B>Remove</B></TD>
		<TD align="center" width="30%" bgcolor="#98e179"><B>Date</B></TD>
		<TD align="center" width="50%" bgcolor="#98e179"><B>Project</B></TD>
		<TD align="center" width="15%" bgcolor="#98e179"><B>Hours</B></TD>
	</TR>


<%
    for (int _i0 = 0; ; ) { %>
      <TR bgcolor="#999999">
        <TD align="center">
          <INPUT name="removeEntryId" type="checkbox" value="<%= _p0.getTimeSheetEntryID() %>"></TD>
        <TD align="center"><timeApp:formatDate calendar="<%= _p0.getDate() %>" formatId="formatter"></timeApp:formatDate></TD>
        <TD align="center"><%= _p0.getProject().getName() %></TD>
        <TD align="right"><%= _p0.getHours() %></TD>
      </TR>
      <TR>
        <TD align="center" bgcolor="#009999" width="5%"></TD>
        <TD align="center" bgcolor='#009999"' width="30%"></TD>
        <TD align="center" bgcolor='#009999"' width="40%"></TD>
        <TD align="center" bgcolor="#009999" width="25%"></TD>
      </TR><%
      _i0++;
      try {
        _p0 = _a0[_i0];
      }
      catch (java.lang.ArrayIndexOutOfBoundsException _e0) {
        break;
      }
    } %>
    <TR>
      <TD align="left" bgcolor="#98e179" colspan="3"><B>Total</B></TD>
      <TD align="right" bgcolor="#98e179"><%= timesheet.getTotalHours() %></TD>
    </TR>
<%
}
catch (java.lang.ArrayIndexOutOfBoundsException _e0) {
} %>

     <TR>
      <TD><B> ADD </B></TD>
      <TD align="center">Date: <INPUT size="12" type="text" name="addDate" maxlength="10"> (MM/dd/yyyy)</TD>
      <TD align="center">Project: <%
try {
  com.wsbook.casestudy.domain.Project[] _a0 = projects.getProject();
  com.wsbook.casestudy.domain.Project _p0 = _a0[0]; // throws an exception if empty.
  %><SELECT name="addProjectId"><%
    for (int _i0 = 0; ; ) { %>
      <OPTION value="<%= _p0.getNumber() %>"><%= _p0.getName() %></OPTION><%
      _i0++;
      try {
        _p0 = _a0[_i0];
      }
      catch (java.lang.ArrayIndexOutOfBoundsException _e0) {
        break;
      }
    } %></SELECT><%
}
catch (java.lang.ArrayIndexOutOfBoundsException _e0) {
} %></TD>
      <TD align="right">Hours: <INPUT size="6" type="text" name="addHours"></TD>
    </TR>

	<TR>
       <TD align="center" colspan="4" ><INPUT type="submit" value="Save"></TD>
    </TR>

</TABLE>
<INPUT name="approverId" type="hidden" value = "49">
<!-- NOTE This is TEMPORARY until we have a chance to change the JSPs -->
<INPUT name="submitterId" type="hidden" value="<%= timesheet.getEmployee().getId() %>">
<INPUT name="weekending" type="hidden" value="<%= timesheet.getFormattedWeekend() %>">
</FORM>
<P><BR>
<B><I>The current time sheet has NOT been approved,
click to<%--METADATA type="DynamicData" startspan
<A href="/TimeApp/ApproveTimeSheet.do" hrefproperty="weekending=$(timesheet.formattedWeekend)&employeeId=$(timesheet.employee.id)" dynamicelement> approve</A>
--%><A href="/TimeApp/DisplayTimeSheetForApproval.do?weekending=<%= java.net.URLEncoder.encode(timesheet.getFormattedWeekend()) %>&submitterId=<%= java.net.URLEncoder.encode(timesheet.getEmployee().getId()) %>"> approve</A><%--METADATA type="DynamicData" endspan--%></I></B><BR>
<BR>
<A href="/TimeApp/SearchTimeSheets.do">Another Search</A></P>
<P><BR>
</P>
<TABLE width="80%">
    <TBODY>
        <TR>
            <TD><A href="/TimeApp/index.html"><IMG src="/TimeApp/images/HomeButton.gif" width="113" height="30" border="0"></A></TD>
            <TD align="right">Active Date Format: <%--METADATA type="DynamicData" startspan
<WSPX:PROPERTY property="formatter.displayFormat">
--%><%= formatter.getDisplayFormat() %><%--METADATA type="DynamicData" endspan--%></TD>
            <TD><A href="/TimeApp/pages/setdatepreference.jsp"><IMG src="/TimeApp/images/ChangeDateFormatButton.gif" width="202" height="30" border="0"></A></TD>
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

<!-- Sample HTML file -->
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">
<HTML>
<HEAD>

<META name="GENERATOR" content="IBM WebSphere Page Designer V3.5 for Windows">
<META http-equiv="Content-Style-Type" content="text/css">
<TITLE>Pending Time Sheets</TITLE>
<LINK href="/TimeApp/theme/Master.css" rel="stylesheet" type="text/css">
</HEAD>

<BODY BGCOLOR="#FFFFFF">
<jsp:useBean id="timesheet" type="com.wsbook.casestudy.domain.TimeSheet" scope="request"/>
<P align="center"><IMG src="/TimeApp/images/ApprovedTSLogo.gif" width="442" height="95" border="0"><BR>
</P>
<FORM action="/TimeApp/UpdateTimeSheet.do" method="POST">

<TABLE width="100%" border="0" cellpadding="3" cellspacing="0">
    <TR BGCOLOR="#EEEECC">
		<TD colspan="2" bgcolor="#009900"><FONT SIZE="4" CLASS=FOUR><B><A NAME="performance">
<%= timesheet.getEmployee().getName() %> - Week Ending: 
<%= timesheet.getFormattedWeekend() %> </A></B></FONT></TD>
		<TD bgcolor="#009900" align="right">Approved&nbsp;</TD>
	</TR>



    <TR BGCOLOR="#99cccc">
		<TD align="center" width="30%" bgcolor="#98e179"><B>Date</B></TD>
		<TD align="center" width="60%" bgcolor="#98e179"><B>Project</B></TD>
		<TD align="center" width="10%" bgcolor="#98e179"><B>Hours</B></TD>
	</TR>

<%
try {
  com.wsbook.casestudy.domain.TimeSheetEntry[] _a0 = timesheet.getEntry();
  com.wsbook.casestudy.domain.TimeSheetEntry _p0 = _a0[0]; // throws an exception if empty. %>
    <TR bgcolor="#009900">
      <TD align="center" bgcolor="#98e179" width="30%"></TD>
      <TD align="center" bgcolor="#98e179" width="60%"></TD>
      <TD align="center" bgcolor="#98e179" width="10%"></TD>
    </TR>
    <%
    for (int _i0 = 0; ; ) { %>
      <TR bgcolor="#999999">
        <TD align="center" width="30%"><%= _p0.getFormattedDate() %></TD>
        <TD align="center" width="60%"><%= _p0.getProject().getName() %></TD>
        <TD align="right" width="10%"><%= _p0.getHours() %></TD>
      </TR>
      <TR>
        <TD align="center" bgcolor="#009999" width="30%"></TD>
        <TD align="center" bgcolor='#009999"' width="60%"></TD>
        <TD align="center" bgcolor='#009999"' width="10%"></TD>
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
      <TD align="left" bgcolor="#98e179" colspan="2"><B>Total</B></TD>
      <TD align="right" bgcolor="#98e179"><%= timesheet.getTotalHours() %></TD>
    </TR>
<%
}
catch (java.lang.ArrayIndexOutOfBoundsException _e0) {
} %>

</TABLE>

<B><I>The current time sheet has been approved, click to un-approve</I></B><BR>
<BR>
<A href="/TimeApp/SearchTimeSheets.do">Another Search</A>
<P></P>
<TABLE width="80%">
    <TBODY>
        <TR>
            <TD><A href="/TimeApp/index.html"><IMG src="/TimeApp/images/HomeButton.gif" width="113" height="30" border="0"></A></TD>
            <TD align="right"> </TD>
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

</HTML>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN"><!-- Sample JSP file -->
<HTML>
<HEAD>
<META name="GENERATOR" content="IBM WebSphere Page Designer V3.5 for Windows">
<META http-equiv="Content-Style-Type" content="text/css">
<LINK href="/TimeApp/theme/Master.css" rel="stylesheet" type="text/css">
<TITLE>
Approved Time Sheets
</TITLE>
<%@taglib uri="http://www.wsbook.com/taglib" prefix="timeApp"%>
</HEAD>

<BODY>
<jsp:useBean id="approved_timesheets" type="com.wsbook.casestudy.value.TimeSheets" scope="request"/>
<jsp:useBean class="com.wsbook.casestudy.util.Formatter" id="formatter" scope="session"/>
<%--METADATA type="DynamicData" startspan
<TABLE innerloopproperty="approved_timesheets.timeSheet[]" innerloopdirection="vertical" innerloopstartindex="2" innerloopendindex="2" dynamicelement>
  <TBODY>
        <TR>
            <TD colspan="3" align="center">
            <H1>Approved Time Sheets</H1>
            </TD>
        </TR>
        <TR>
      <TD width="144" align="center" bgcolor="#009999"><FONT size="+1">Name</FONT></TD>
      <TD width="101" align="center" bgcolor="#009999"><FONT size="+1">Week Ending</FONT></TD>
      <TD width="132" align="center" bgcolor="#009999"><FONT size="+1">Hours</FONT></TD>
    </TR>

    <TR>
      <TD bgcolor="#cccccc"><WSPX:PROPERTY property="approved_timesheets.timeSheet[].employee.name"></TD>
      <TD bgcolor="#cccccc"><timeApp:formatDate formatId="formatter" calendar="<%= _p0.getWeekend() %>"></timeApp:formatDate></TD>
      <TD bgcolor="#cccccc"><WSPX:PROPERTY property="approved_timesheets.timeSheet[].totalHours"></TD>
    </TR>
  </TBODY>
</TABLE>
--%><%
try {
  com.wsbook.casestudy.domain.TimeSheet[] _a0 = approved_timesheets.getTimeSheet();
  com.wsbook.casestudy.domain.TimeSheet _p0 = _a0[0]; // throws an exception if empty. %>
  <TABLE>
    <TBODY>
      <TR>
        <TD align="center" colspan="3">
            
          <H1>Approved Time Sheets</H1>
            </TD>
      </TR>
      <TR>
        <TD align="center" bgcolor="#009999" width="144"><FONT size="+1">Name</FONT></TD>
        <TD align="center" bgcolor="#009999" width="101"><FONT size="+1">Week Ending</FONT></TD>
        <TD align="center" bgcolor="#009999" width="132"><FONT size="+1">Hours</FONT></TD>
      </TR><%
      for (int _i0 = 0; ; ) { %>
        <TR>
          <TD bgcolor="#cccccc"><%= _p0.getEmployee().getName() %></TD>
          <TD bgcolor="#cccccc"><timeApp:formatDate calendar="<%= _p0.getWeekend() %>" formatId="formatter"></timeApp:formatDate></TD>
          <TD bgcolor="#cccccc"><%= _p0.getTotalHours() %></TD>
        </TR><%
        _i0++;
        try {
          _p0 = _a0[_i0];
        }
        catch (java.lang.ArrayIndexOutOfBoundsException _e0) {
          break;
        }
      } %>
    </TBODY>
  </TABLE><%
}
catch (java.lang.ArrayIndexOutOfBoundsException _e0) {
} %><%--METADATA type="DynamicData" endspan--%>
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
</HTML>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN"><!-- Sample JSP file -->
<%@taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<html:html locale="false">
<HEAD>
<META name="GENERATOR" content="IBM WebSphere Page Designer V3.5 for Windows">
<META http-equiv="Content-Style-Type" content="text/css">
<LINK href="/TimeApp/theme/Master.css" rel="stylesheet" type="text/css">
<TITLE>
Pending Time Sheets
</TITLE>
<%@taglib uri="http://www.wsbook.com/taglib" prefix="timeApp"%>
</HEAD>

<BODY BGCOLOR="#FFFFFF">
<jsp:useBean id="timesheet" type="com.wsbook.casestudy.domain.TimeSheet" scope="request"/>
<jsp:useBean id="employees" type="java.util.ArrayList" scope="session"/>
<jsp:useBean class="com.wsbook.casestudy.util.Formatter" id="formatter" scope="session"/>
<CENTER>
<html:form action="/ApproveTimeSheet.do">
  <TABLE>
    <TBODY>
      <TR>
        <TD align="center" colspan="3">     
          <H1>Approve Time Sheet</H1>
        </TD>
      </TR>
      <TR>
        <TD align="center" bgcolor="#009999" width="144"><FONT size="+1">Name</FONT></TD>
        <TD align="center" bgcolor="#009999" width="101"><FONT size="+1">Week Ending</FONT></TD>
        <TD align="center" bgcolor="#009999" width="132"><FONT size="+1">Hours</FONT></TD>
      </TR>
        <TR>
          <TD bgcolor="#cccccc"><%= timesheet.getEmployee().getName() %></TD>
          <TD bgcolor="#cccccc"><timeApp:formatDate calendar="<%= timesheet.getWeekend() %>" formatId="formatter"></timeApp:formatDate></TD>
          <TD bgcolor="#cccccc"><%= timesheet.getTotalHours() %></TD>
        </TR>
      <TR>
    </TBODY>
  </TABLE>
  <BR>
	<FONT size="+1">Approving Manager:</FONT>

	<SELECT name="approverId">
	<%  
		java.util.Iterator iter = employees.iterator();
		while (iter.hasNext()) {
			com.wsbook.casestudy.domain.Employee emp = (com.wsbook.casestudy.domain.Employee) iter.next(); %>
		<OPTION value="<%=emp.getId()%>"><%= emp.getName()%></OPTION>
	<%} %>
	</SELECT>
	<INPUT type="hidden" name="weekending" 
		value="<%=timesheet.getFormattedWeekend() %>">
	<INPUT type="hidden" name="submitterId" 
		value="<%= timesheet.getEmployee().getId() %>">
	<BR>
	<BR>
	<html:submit>Approve</html:submit>
</html:form>
</CENTER>
<P><BR>
</P>
<TABLE width="80%">
    <TBODY>
        <TR>
            <TD><A href="/TimeApp/index.html"><IMG src="/TimeApp/images/HomeButton.gif" width="113" height="30" border="0"></A></TD>
            <TD align="right">Active Date Format: <%--METADATA type="DynamicData" startspan
<WSPX:PROPERTY property="formatter.displayFormat">
--%>
	<%= formatter.getDisplayFormat() %>
	<%--METADATA type="DynamicData" endspan--%>
	</TD>
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
	</TABLE></BODY>
</html:html>

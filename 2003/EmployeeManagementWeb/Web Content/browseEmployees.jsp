<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Frameset//EN">
<HTML>
<HEAD>
<%@ page 
	language="java"
	contentType="text/html; charset=WINDOWS-1252"
	import="com.wsbook.acme.Employee,
			java.util.Iterator"%>
<META http-equiv="Content-Type"
	content="text/html; charset=WINDOWS-1252">
<META name="GENERATOR" content="IBM WebSphere Studio">

<TITLE>Browse Employees (JSP version)</TITLE>
</HEAD>
<BODY>
<jsp:useBean id="employees" 
	type="java.util.Collection" scope="request"></jsp:useBean>
<h3 align="center">All Employees</h3>
<TABLE align="center" BORDER="yes" CELLSPACING="2" CELLPADDING="0"
	WIDTH="70%">
	<TR>
		<TD>
		<center><b>Id</b></center>
		</TD>
		<TD>
		<center><b>Name</b></center>
		</TD>
		<TD width="40">
		<center><b>Age</b></center>
		</TD>
	</TR>
		<%  Iterator emps = employees.iterator();
		    while (emps.hasNext()) {
			Employee employee = (Employee) emps.next();%>
	<TR>
		<TD><A HREF="ShowEmployeeDetail?id=<%=employee.getId()%>"
			target="detail"> <%=employee.getId()%></A></TD>
		<TD><%=employee.getName()%></TD>
		<TD width="40"><%=employee.getAge()%></TD>
	</TR>
		<% } %>
	<TR>
		<TD colspan="3"><A href="newEmployee.jsp" target="detail"> Create
		Employee... </A></TD>
	</TR>
</TABLE>
</BODY>
</HTML>

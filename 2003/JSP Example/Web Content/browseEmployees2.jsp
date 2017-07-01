<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Frameset//EN">

<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c_rt"%>
<HTML>
<HEAD>
<%@ page 
	language="java"
	contentType="text/html; charset=WINDOWS-1252"
	import="com.wsbook.servletexample.domain.Employee,
			java.sql.SQLException,java.util.Iterator"%>
<META http-equiv="Content-Type"
	content="text/html; charset=WINDOWS-1252">
<META name="GENERATOR" content="IBM WebSphere Studio">

<TITLE>Browse Employees (JSP version)</TITLE>
</HEAD>
<jsp:useBean id="employees" class="java.util.ArrayList" scope="request">
</jsp:useBean>
<BODY>
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
	<c_rt:forEach var="emp" items="<%=employees%>">
		<%Employee emp = (Employee)pageContext.getAttribute("emp");%>
		<TR>
			<TD><A
				HREF="ShowEmployeeDetail?id=<%=emp.getId()%>"
				target="detail"> <%=emp.getId()%></A></TD>
			<TD><%=emp.getName()%></TD>
			<TD width="40"><%=emp.getAge()%></TD>
		</TR>
	</c_rt:forEach>
	<TR>
		<TD colspan="3"><A href="ShowEmployeeDetail" target="detail">Create
		Employee...</A></TD>
	</TR>
</TABLE>
</BODY>
</HTML>

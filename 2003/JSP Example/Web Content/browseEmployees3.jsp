<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Frameset//EN">
<%@taglib uri="http://java.sun.com/jstl/core" prefix="c"%>
<HTML>
<HEAD>
<%@ page 
	language="java"
	contentType="text/html; charset=WINDOWS-1252"
	import="com.wsbook.servletexample.domain.Employee, java.util.Collection, java.util.Iterator"%>
<META http-equiv="Content-Type"
	content="text/html; charset=WINDOWS-1252">
<META name="GENERATOR" content="IBM WebSphere Studio">

<TITLE>Browse Employees (JSP version)</TITLE>
</HEAD>
<BODY>
<jsp:useBean id="employees" class="java.util.ArrayList" scope="request">
</jsp:useBean>
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
	<c:catch>
	<c:forEach var="emp" items="${employees}">
	<TR>
		<TD><A HREF="ShowEmployeeDetail?id=<c:out value="${emp.id}"/>"
			target="detail"> <c:out value="${emp.id}"/></A></TD>
		<TD><c:out value="${emp.name}"/></TD>
		<TD width="40"><c:out value="${emp.age}"/></TD>
	</TR>
	</c:forEach>
	</c:catch>
	<TR>
		<TD colspan="3"><A href="newEmployee.jsp" target="detail">Create
		Employee...</A></TD>
	</TR>
</TABLE>
</BODY>
</HTML>

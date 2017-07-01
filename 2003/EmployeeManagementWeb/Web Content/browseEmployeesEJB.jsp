<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Frameset//EN">
<HTML>
<HEAD>
<%@ page 
	language="java"
	contentType="text/html; charset=WINDOWS-1252"
	import="com.wsbook.acme.Employee,
			com.wsbook.acme.management.EmployeeManagementLocalHome,
			com.wsbook.acme.management.EmployeeManagementLocal,
			javax.naming.Context,
			javax.naming.InitialContext,
			java.sql.SQLException,
			java.util.Iterator"%>
<META http-equiv="Content-Type"
	content="text/html; charset=WINDOWS-1252">
<META name="GENERATOR" content="IBM WebSphere Studio">

<TITLE>Browse Employees (JSP version)</TITLE>
</HEAD>
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
	<%try {
		InitialContext context = new InitialContext();
		EmployeeManagementLocalHome emh = (EmployeeManagementLocalHome)
			context.lookup("java:comp/env/ejb/EmployeeManagementLocal");
		EmployeeManagementLocal em = emh.create();
        Iterator employees = em.findAll().iterator();
		while (employees.hasNext()) {
			Employee employee = (Employee) employees.next();%>
	<TR>
		<TD><A HREF="employeeDetails.jsp?id=<%=employee.getId()%>"
			target="detail"> <%=employee.getId()%></A></TD>
		<TD><%=employee.getName()%></TD>
		<TD width="40"><%=employee.getAge()%></TD>
	</TR>
		<%}
    } catch (Exception e) {
    	e.printStackTrace();
    }%>
	<TR>
		<TD colspan="3">
			<A href="newEmployee.jsp" target="detail">
				Create Employee...
			</A></TD>
	</TR>
</TABLE>
</BODY>
</HTML>

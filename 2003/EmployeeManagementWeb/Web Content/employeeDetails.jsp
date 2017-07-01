<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Frameset//EN">
<html>
<head>
<%@ page 
  language="java"
  contentType="text/html; charset=ISO-8859-1"
  import="com.wsbook.acme.Employee"
  errorPage="noSuchEmployee.jsp"%>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="GENERATOR" content="IBM WebSphere Studio">
<title>Employee Details</title>
</head>
<body>
	<jsp:useBean id="employee"
		class="com.wsbook.acme.Employee" 
		scope="session">
	</jsp:useBean>
	<h3 align="center">Employee Details</h3>
	<div align="center">
<form name="updateEmployee" target="_top" method="post"
	action="UpdateEmployee">
	<input type="hidden" name="id" value="<%=employee.getId()%>"/>
<table align="center" border="1" cellpadding="0" cellspacing="0"
	width="70%">
	<tr>
		<td width="60">
		<div align="right">Name:</div>
		</td>
		<td><input type="text" name="name" size="70"
			value="<%=employee.getName()%>" /></td>
	</tr>
	<tr>
		<td width="60">
		<div align="right">Age:</div>
		</td>
		<td><input type="text" name="age" size="70"
			value="<%=employee.getAge()%>" /></td>
	</tr>
	<tr>
		<td width="60">
		<div align="right">Street:</div>
		</td>
		<td><input type="text" name="street" size="70"
			value="<%=employee.getAddress().getStreet()%>" /></td>
	</tr>
	<tr>
		<td colspan="2">
		<table border="0" cellpadding="0" cellspacing="0">
			<tr>
				<td width="60">
				<div align="right">City:</div>
				</td>
				<td><input type="text" name="city" size="27"
					value="<%=employee.getAddress().getCity()%>" /></td>
				<td width="30">
				<div align="right">State:</div>
				</td>
				<td><input type="text" name="state" size="6"
					value="<%=employee.getAddress().getState()%>" /></td>
				<td width="30">
				<div align="right">Zip:</div>
				</td>
				<td><input type="text" name="zip" size="10"
					value="<%=employee.getAddress().getZip()%>" /></td>
			</tr>
		</table>
		</td>
	</tr>
	<td colspan="2">
	<div align="center">
		<input type="submit" name="submit" 
			value="Update"
			align="center"/> 
		<input type="submit" name="submit" 
			value="Delete"
			align="center"/>
	</div>
	</td>
	</tr>
</table>
</form>
</div>
</body>
</html>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Frameset//EN">
<html>
<head>
<%@ page 
	language="java"
	contentType="text/html; charset=ISO-8859-1"
	import="com.wsbook.servletexample.domain.Employee,
			java.sql.SQLException,java.util.Iterator,
			com.wsbook.servletexample.exception.NoSuchObjectException"
%>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="GENERATOR" content="IBM WebSphere Studio">
<title>Create Employee</title>
</head>
<body>
<h3 align="center">Create Employee</h3>
<div align="center">
<form name="CreateEmployeeEmployee" target="_top" method="post"
	action="CreateEmployee">
<table align="center" border="1" cellpadding="0" cellspacing="0"
	width="70%">
	<tr>
		<td width="60">
		<div align="right">Id:</div>
		</td>
		<td><input type="text" name="id" size="70"/></td>
	</tr>
	<tr>
		<td width="60">
		<div align="right">Name:</div>
		</td>
		<td><input type="text" name="name" size="70"/></td>
	</tr>
	<tr>
		<td width="60">
		<div align="right">Age:</div>
		</td>
		<td><input type="text" name="age" size="70"/></td>
	</tr>
	<tr>
		<td width="60">
		<div align="right">Street:</div>
		</td>
		<td><input type="text" name="street" size="70"/></td>
	</tr>
	<tr>
		<td colspan="2">
		<table border="0" cellpadding="0" cellspacing="0">
			<tr>
				<td width="60">
				<div align="right">City:</div>
				</td>
				<td><input type="text" name="city" size="27"/></td>
				<td width="30">
				<div align="right">State:</div>
				</td>
				<td><input type="text" name="state" size="6"/></td>
				<td width="30">
				<div align="right">Zip:</div>
				</td>
				<td><input type="text" name="zip" size="10"/></td>
			</tr>
		</table>
		</td>
	</tr>
	<td colspan="2">
	<div align="center"><input type="submit" name="submit" value="Submit"
		align="center"></div>
	</td>
	</tr>
</table>
</form>
</div>
</body>
</html>

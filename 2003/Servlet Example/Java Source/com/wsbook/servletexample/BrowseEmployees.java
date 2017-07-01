package com.wsbook.servletexample;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.Iterator;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wsbook.servletexample.domain.Employee;

/** Create an HTML page that returns a list of employees in 
 * the database, allows for creation of new employees, and
 * supports updating information on existing employees.
 * @version 	1.0
 * @author
 */
public class BrowseEmployees extends HttpServlet {

	/**
	* @see javax.servlet.http.HttpServlet#void (javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	*/
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
		throws ServletException, IOException {

		PrintWriter out = resp.getWriter();
		out.println("<HTML>");
		out.println("<BODY>");
		out.println("<h3 align=\"center\">All Employees</h3>");
		out.println(
			"<TABLE align=\"center\" BORDER=\"yes\" CELLSPACING=2 CELLPADDING=0 WIDTH=\"70%\">");
		out.println("<TR>");
		out.println("<TD><center><b>Id</b></center></TD>");
		out.println("<TD><center><b>Name</b></center></TD>");
		out.println("<TD width=\"40\"><center><b>Age</b></center></TD>");
		out.println("</TR>");
		try {
			Iterator employees = Employee.findAll().iterator();
			while (employees.hasNext()) {
				Employee employee = (Employee) employees.next();
				out.println("<TR>");
				out.println(
					"<TD><A HREF=\"EmployeeDetails?id="
						+ employee.getId()
						+ "\" target=\"detail\">"
						+ employee.getId()
						+ "</A></TD>");
				out.println("<TD>" + employee.getName() + "</TD>");
				out.println("<TD width=\"40\">" + employee.getAge() + "</TD>");
				out.println("</TR>");
			}
		} catch (SQLException e) {
		}
		out.println("<TR>");
		out.println(
			"<TD colspan=\"3\"><A href=\"EmployeeDetails\" target=\"detail\">Create Employee...</A></TD>");
		out.println("</TR>");
		out.println("</TABLE>");
		out.println("</BODY>");
		out.println("</HTML>");
	}

}

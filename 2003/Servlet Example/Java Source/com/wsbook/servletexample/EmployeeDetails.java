package com.wsbook.servletexample;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wsbook.servletexample.domain.Employee;
import com.wsbook.servletexample.exception.NoSuchObjectException;

/** Display the details for an employee.
 * @version 	1.0
 * @author
 */
public class EmployeeDetails extends HttpServlet {

	/**
	* @see javax.servlet.http.HttpServlet#void (javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	*/
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
		throws ServletException, IOException {

		String employeeId = req.getParameter("id");
		Employee employee = new Employee();
		if (employeeId != null) {
			try {
				employee = Employee.findByPrimaryKey(employeeId);
			} catch (NoSuchObjectException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		PrintWriter out = resp.getWriter();

		out.println(
			"<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">");
		out.println("<html>");
		out.println("<head>");
		out.println("<title>Employee Details</title>");
		out.println(
			"<meta http-equiv=\"Content-Type\" content=\"text/html; charset=iso-8859-1\">");
		out.println("</head>");
		out.println("<body bgcolor=\"#FFFFFF\" text=\"#000000\">");
		out.println("<h3 align=\"center\">Employee Details</h3>");
		out.println("<div align=\"center\">");
		String action = "UpdateEmployee";
		if (employeeId == null) action = "CreateEmployee";
		out.println(
			"<form name=\"updateEmployee\" target=\"_top\" method=\"post\" action=\""+action+"\">");
		if (employeeId != null)
			out.println(
				"  <input type=\"hidden\" name=\"id\" value=\""
					+ employee.getId()
					+ "\"/>");
		out.println(
			"  <table align=\"center\" border=\"1\" cellpadding=\"0\" cellspacing=\"0\" width=\"70%\">");
		if (employeeId == null) {
			out.println("    <tr>");
			out.println("      <td width=\"60\">");
			out.println("        <div align=\"right\">Id:</div>");
			out.println("      </td>");
			out.println("      <td>");
			out.println(
				"        <input type=\"text\" name=\"id\" size=\"70\" value=\""
					+ employee.getId()
					+ "\"/>");
			out.println("      </td>");
			out.println("    </tr>");
		}
		out.println("    <tr>");
		out.println("      <td width=\"60\">");
		out.println("        <div align=\"right\">Name:</div>");
		out.println("      </td>");
		out.println("      <td>");
		out.println(
			"        <input type=\"text\" name=\"name\" size=\"70\" value=\""
				+ employee.getName()
				+ "\"/>");
		out.println("      </td>");
		out.println("    </tr>");
		out.println("    <tr>");
		out.println("      <td width=\"60\">");
		out.println("        <div align=\"right\">Age:</div>");
		out.println("      </td>");
		out.println("      <td>");
		out.println(
			"        <input type=\"text\" name=\"age\" size=\"70\" value=\""
				+ employee.getAge()
				+ "\"/>");
		out.println("      </td>");
		out.println("    </tr>");
		out.println("    <tr>");
		out.println("      <td width=\"60\">");
		out.println("        <div align=\"right\">Street:</div>");
		out.println("      </td>");
		out.println("      <td>");
		out.println(
			"        <input type=\"text\" name=\"street\" size=\"70\" value=\""
				+ employee.getStreet()
				+ "\"/>");
		out.println("      </td>");
		out.println("    </tr>");
		out.println("    <tr>");
		out.println("      <td colspan=\"2\">");
		out.println(
			"        <table border=\"0\" cellpadding=\"0\" cellspacing=\"0\">");
		out.println("          <tr>");
		out.println("            <td width=\"60\">");
		out.println("              <div align=\"right\">City:</div>");
		out.println("            </td>");
		out.println("            <td>");
		out.println(
			"              <input type=\"text\" name=\"city\" size=\"27\" value=\""
				+ employee.getCity()
				+ "\">");
		out.println("            </td>");
		out.println("            <td width=\"30\">");
		out.println("              <div align=\"right\">State:</div>");
		out.println("            </td>");
		out.println("            <td>");
		out.println(
			"              <input type=\"text\" name=\"state\" size=\"6\" value=\""
				+ employee.getState()
				+ "\">");
		out.println("            </td>");
		out.println("            <td width=\"30\">");
		out.println("              <div align=\"right\">Zip:</div>");
		out.println("            </td>");
		out.println("            <td>");
		out.println(
			"              <input type=\"text\" name=\"zip\" size=\"10\" value=\""
				+ employee.getZip()
				+ "\">");
		out.println("            </td>");
		out.println("          </tr>");
		out.println("        </table>");
		out.println("      </td>");
		out.println("    </tr>");
		out.println("      <td colspan=\"2\">");
		out.println("        <div align=\"center\">");
		out.println(
			"          <input type=\"submit\" name=\"submit\" value=\"Submit\" align=\"center\">");
		if (employeeId != null) {
			out.println(
			"          <input type=\"submit\" name=\"submit\" value=\"Delete\" align=\"center\">");
		}
		out.println("        </div>");
		out.println("      </td>");
		out.println("    </tr>");
		out.println("  </table>");
		out.println("</form>");
		out.println("</div>");
		out.println("</body>");
		out.println("</html>");
	}
}

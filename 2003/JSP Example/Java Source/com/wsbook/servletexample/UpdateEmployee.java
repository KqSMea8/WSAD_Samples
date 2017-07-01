package com.wsbook.servletexample;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wsbook.servletexample.domain.Employee;
import com.wsbook.servletexample.exception.MappingException;
import com.wsbook.servletexample.exception.NoSuchObjectException;

/** Update an employee.
 * @version 	1.0
 * @author
 */
public class UpdateEmployee extends HttpServlet {

	/**
	* @see javax.servlet.http.HttpServlet#void (javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	*/
	public void doPost(HttpServletRequest req, HttpServletResponse resp)
		throws ServletException, IOException {

		// Update the employee and address information
		Employee employee = (Employee)req.getSession().getAttribute("employee");
		// see what button the user pressed
		String action = req.getParameter("submit");
		if (action.equals("Delete")) {
			try {
				employee.delete();
			} catch (SQLException e) {
				log("***Error deleting an employee: "+e);
			} catch (MappingException e) {
			}
		} else {
			employee.setName(req.getParameter("name"));
			try {
				employee.setAge(Integer.parseInt(req.getParameter("age")));
			} catch (NumberFormatException exc) {
				log("***Error, employee id must be a number");
			}
			employee.setStreet(req.getParameter("street"));
			employee.setCity(req.getParameter("city"));
			employee.setState(req.getParameter("state"));
			employee.setZip(req.getParameter("zip"));
			try {
				employee.update();
			} catch (MappingException e) {
				log("***Error, couldn't save employee or address");
			} catch (SQLException e) {
				log("***Error updating employee: ", e);
			}
		}
		req.getSession().removeAttribute("employee");
		// refresh the employee's list so it shows the updates	
		resp.sendRedirect("BrowseEmployees");
	}

}

package com.wsbook.servletexample;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wsbook.servletexample.domain.Employee;
import com.wsbook.servletexample.exception.DuplicateKeyException;

/**
 * @version 	1.0
 * @author
 */
public class CreateEmployee extends HttpServlet {

	/**
	* @see javax.servlet.http.HttpServlet#void (javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	*/
	public void doPost(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		// Update the employee and address information and 
		String employeeId = req.getParameter("id");
		Employee employee = new Employee(employeeId);
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
			employee.create();
		} catch (DuplicateKeyException e) {
			log("***Error, couldn't save employee or address");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		// refresh the employee's list so it shows the updates	
		resp.sendRedirect("BrowseEmployees");
	}

}

package com.wsbook.acme.management;
import java.io.IOException;
import java.sql.SQLException;

import javax.naming.InitialContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wsbook.acme.Employee;
import com.wsbook.mapping.MappingException;

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

		try {
			// Update the employee and address information and 
			InitialContext context = new InitialContext();
			EmployeeManagementLocalHome emh = (EmployeeManagementLocalHome)
				context.lookup("java:comp/env/ejb/EmployeeManagementLocal");
			EmployeeManagementLocal em = emh.create();
	
			// see what button the user pressed
			String action = req.getParameter("submit");
			if (action.equals("Delete")) {
				em.deleteAnEmployee(req.getParameter("id"));
			} else {
				em.update(req.getParameterMap());
			}
		} catch (Exception e) {
			log("***Error, couldn't save employee or address");
			e.printStackTrace();
		}
		// refresh the employee's list so it shows the updates	
		resp.sendRedirect("browseEmployees.html");
	}

}

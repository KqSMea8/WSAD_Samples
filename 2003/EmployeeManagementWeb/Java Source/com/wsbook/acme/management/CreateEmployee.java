package com.wsbook.acme.management;
import java.io.IOException;

import javax.naming.InitialContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
		try {
			InitialContext context = new InitialContext();
			EmployeeManagementLocalHome emh = (EmployeeManagementLocalHome)
				context.lookup("java:comp/env/ejb/EmployeeManagementLocal");
			EmployeeManagementLocal em = emh.create();
			em.createNewEmployee(req.getParameterMap());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		// refresh the employee's list so it shows the updates	
		resp.sendRedirect("browseEmployees.html");
	}

}

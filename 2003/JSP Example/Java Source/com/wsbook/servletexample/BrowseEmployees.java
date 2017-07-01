package com.wsbook.servletexample;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Collection;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wsbook.servletexample.domain.Employee;

/**
 * @version 	1.0
 * @author
 */
public class BrowseEmployees extends HttpServlet {

	/**
	* This method performs a findAll on the Employee Active Record object
	* And then places the iterator of populated objects in the request for the
	* browseEmployees jsp to process.
	*/
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
		throws ServletException, IOException {
			
			try {
				Collection employees = Employee.findAll();
				req.setAttribute("employees", employees);
				RequestDispatcher rd = getServletContext().getRequestDispatcher("/browseEmployees.jsp");
				rd.forward(req,resp);
			} catch (SQLException e) {
				
				RequestDispatcher rd = getServletContext().getRequestDispatcher("/databaseError.html");
				rd.forward(req,resp);
				
			}

	}

}

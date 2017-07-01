package com.wsbook.servletexample;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.wsbook.servletexample.domain.Employee;
import com.wsbook.servletexample.exception.NoSuchObjectException;

/**
 * ShowEmployeeDetail Servlet
 * @version 	1.0
 * @author
 */
public class ShowEmployeeDetail extends HttpServlet {

	/**
	* This servlet retrieves the Employee for a particular id passed in as a parameter
	*/
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
		throws ServletException, IOException {

		try {

			String employeeId = req.getParameter("id");
			Employee employee = Employee.findByPrimaryKey(employeeId);
			HttpSession session = req.getSession(true);
			session.setAttribute("employee", employee);
			RequestDispatcher rd =
				getServletContext().getRequestDispatcher(
					"/employeeDetails.jsp");
			rd.forward(req, resp);
		} catch (NoSuchObjectException e) {
			RequestDispatcher rd =
				getServletContext().getRequestDispatcher("/noSuchEmployee.jsp");
			rd.forward(req, resp);

		} catch (SQLException e) {
			log("***Error attempting to find employee", e);
			RequestDispatcher rd =
				getServletContext().getRequestDispatcher("/databaseError.html");
			rd.forward(req, resp);

		}

	}

}

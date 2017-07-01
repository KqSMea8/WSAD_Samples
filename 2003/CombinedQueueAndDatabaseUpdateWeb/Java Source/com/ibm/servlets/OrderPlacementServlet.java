package com.ibm.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;

import javax.naming.InitialContext;
import javax.rmi.PortableRemoteObject;
import javax.servlet.ServletException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ibm.ejb.tests.*;

/**
 * @version 	1.0
 * @author
 */
public class OrderPlacementServlet extends HttpServlet {

	/**
	* @see javax.servlet.GenericServlet#void ()
	*/
	public void destroy() {

		super.destroy();

	}

	/**
	* @see javax.servlet.http.HttpServlet#void (javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	*/
	public void doPost(HttpServletRequest req, HttpServletResponse resp)
		throws ServletException, IOException {
			
			Date aDate = new Date(System.currentTimeMillis());
			
			Order anOrder = new Order();
			anOrder.setOrderNumber(req.getParameter("OrderNumber"));
			anOrder.setCustomerNumber(req.getParameter("CustomerNumber"));
			anOrder.setPlacementDate(aDate);
			anOrder.setStatus("New");
			
			String result = "Order Written.";
			
			try {
			InitialContext ctx = new InitialContext();
			Object homeRef = ctx.lookup("java:comp/env/ejb/OrderPlacementHome");
			OrderPlacementHome home = (OrderPlacementHome) PortableRemoteObject.narrow(homeRef, OrderPlacementHome.class);
			
			OrderPlacement orderPlacer = home.create();
			orderPlacer.processOrder(anOrder);
			
			} catch (OrderException e) {
				System.out.println("Order Exception caught " + e);
				result = "OrderException caught " + e;
			} catch (Exception e) {
				System.out.println("Other Exception caught " + e);
				result = "Other Exception caught " + e;
			}
			
			PrintWriter out = resp.getWriter();
			out.println("<HTML>");
			out.println(result);
			out.println("<HTML>");
	}

	/**
	* @see javax.servlet.GenericServlet#void ()
	*/
	public void init() throws ServletException {

		super.init();

	}

}

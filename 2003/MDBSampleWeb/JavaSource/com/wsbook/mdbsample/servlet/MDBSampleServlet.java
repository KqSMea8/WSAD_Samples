package com.wsbook.mdbsample.servlet;

import java.io.IOException;

import javax.jms.*;
import javax.naming.*;
import javax.servlet.*;
import javax.servlet.http.*;

/**
 * @version 	1.0
 * @author		Greg Hester
 */
public class MDBSampleServlet extends HttpServlet {
	public static final String CONN_FACTORY_NAME = "Java:comp/env/Sample/jms/SampleQCF";
	public static String QUEUE_NAME = "Java:comp/env/Sample/jms/SampleQ";
	

	/**
	* @see javax.servlet.http.HttpServlet#void (javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	*/
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
		throws ServletException, IOException {

		try
		{
			ServletOutputStream out = resp.getOutputStream();
			out.println("<HTML><BODY>");
			
			out.println("<P>Getting Initial Context</P>");
			InitialContext context = new InitialContext();
			
			out.println("<P>Getting Connection Factory</P>");
			QueueConnectionFactory qConnectionFactory = (QueueConnectionFactory)context.lookup(CONN_FACTORY_NAME);		
			out.println(qConnectionFactory.toString());
			
			out.println("<P>Getting Queue</P>");
			Queue queue = (Queue)context.lookup(QUEUE_NAME);
			
			out.println("<P>Creating connection");
			QueueConnection qConnection = qConnectionFactory.createQueueConnection();
			
			out.println("<P>Creating Session</P>");
			QueueSession qSession = qConnection.createQueueSession(false,Session.AUTO_ACKNOWLEDGE);
			
			out.println("<P>Creating Sender</P>");
			QueueSender sender = qSession.createSender(queue);
			
			out.println("<P>Creating Text</P>");
			TextMessage message = qSession.createTextMessage();
			
			out.println("<P>Appending command Line</P>");
			
			String messageToSend = req.getParameter("message");
			if(messageToSend == null)
			{
				messageToSend = "Default Message";
			}
			
			out.println("<P>Setting Text</P>");
			message.setText(messageToSend);
			
			out.println("<P>Sending message</P>");
			sender.send(message);
			
			out.println("<P>Closing sender</P>");
			sender.close();
			
			out.println("<P>Closing session</P>");
			qSession.close();
			
			out.println("<P>Closing connection</P>");
			qConnection.close();
			
			out.println("<P>Connection closed</P>");
			out.println("</HTML></BODY>");
		}
		catch(NamingException ne)
		{
			ne.printStackTrace(System.out);
		}
		catch(JMSException e)
		{
			e.printStackTrace(System.out);
			Exception linked = e.getLinkedException();
			linked.printStackTrace(System.out);
		}

	}

}


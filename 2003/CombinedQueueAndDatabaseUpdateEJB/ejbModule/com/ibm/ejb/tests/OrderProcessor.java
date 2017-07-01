package com.ibm.ejb.tests;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.jms.Queue;
import javax.jms.QueueConnection;
import javax.jms.QueueConnectionFactory;
import javax.jms.QueueSender;
import javax.jms.QueueSession;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.naming.InitialContext;
import javax.sql.DataSource;
import javax.transaction.UserTransaction;

/**
 * @author kbrown
 *
 * To change this generated comment edit the template variable "typecomment":
 * Window>Preferences>Java>Templates.
 * To enable and disable the creation of type comments go to
 * Window>Preferences>Java>Code Generation.
 */
public class OrderProcessor {
	
	private String createSQL = "CREATE TABLE KBROWN.ORDER (orderNum VARCHAR(250), custNum VARCHAR(250), datePlaced DATE, status VARCHAR(250));";

	public void processOrder(Order anOrder) throws OrderException {

			String xmlString = buildXML(anOrder);
			writeOrderToOutputQueue(xmlString);
			storeOrderInOrderDatabase(anOrder);
	}

	/**
	 * Method buildXML.
	 * @param anOrder
	 * @return String
	 */
	private String buildXML(Order anOrder) {
		StringBuffer out = new StringBuffer(512);
		out.append("<Order number=");
		out.append(anOrder.getCustomerNumber());
		out.append(">");

		out.append("<CustomerNumber>");
		out.append(anOrder.getCustomerNumber());
		out.append("</CustomerNumber>");

		out.append("<DatePlaced>");
		out.append(anOrder.getPlacementDate());
		out.append("</DatePlaced>");
		
		out.append("<Status>");
		out.append(anOrder.getStatus());
		out.append("</Status>");

		out.append("</Order>");

		return out.toString();
	}
	
	public String selectStatement =
		"select custNum,datePlaced,status from Order where orderNum = ?";
	
	Order retrieveOrderFromDatabase(String orderNumber) throws OrderException {

		Connection con = null;
		PreparedStatement stmt = null;
		try {
			InitialContext ctx = new InitialContext();
			DataSource ds =
				(DataSource) ctx.lookup("java:comp/env/jdbc/Db2XADataSource");
			con = ds.getConnection();
			stmt = con.prepareStatement(selectStatement);
			stmt.setString(1, orderNumber);
			ResultSet results = stmt.executeQuery();
			if (results.next()) {
				Order anOrder = new Order();
				anOrder.setOrderNumber(orderNumber);
				anOrder.setCustomerNumber(results.getString(1));
				anOrder.setPlacementDate(results.getDate(2));
				anOrder.setStatus(results.getString(3));
				return anOrder;				
			}
			throw new OrderException("Order not found for number " + orderNumber);

		} catch (Exception e) {
			System.out.println("Exception caught in StoreOrderinDatabase");
			throw new OrderException(e.toString());
		} finally {
			try {
				if (con != null)
					con.close();
				if (stmt != null)
					stmt.close();
			} catch (Exception e2) {
				System.out.println("Exception in closing JDBC resources");
				// log it and eat it
			}
		}

	}
	

	public String insertStatement =
		"insert into Order(orderNum,custNum,datePlaced, status) values(?, ?, ?, ?)";

	void storeOrderInOrderDatabase(Order anOrder) throws OrderException {

		Connection con = null;
		PreparedStatement stmt = null;
		boolean updated = false;
		try {
			InitialContext ctx = new InitialContext();
			DataSource ds =
				(DataSource) ctx.lookup("java:comp/env/jdbc/Db2XADataSource");
			con = ds.getConnection();
			stmt = con.prepareStatement(insertStatement);
			stmt.setString(1, anOrder.orderNumber);
			stmt.setString(2, anOrder.customerNumber);
			stmt.setDate(3, anOrder.placementDate);
			stmt.setString(4, anOrder.status);
			updated = stmt.execute();

		} catch (Exception e) {
			System.out.println("Exception caught in StoreOrderinDatabase");
			throw new OrderException(e.toString());
		} finally {
			try {
				if (con != null)
					con.close();
				if (stmt != null)
					stmt.close();
			} catch (Exception e2) {
				System.out.println("Exception in closing JDBC resources");
				// log it and eat it
			}
		}
		
		//if (!updated)
			//throw new OrderException("Database not written");

	}

	void writeOrderToOutputQueue(String text) throws OrderException {

		QueueConnection connection = null;
		QueueSession session = null;

		try {
			InitialContext ctx = new InitialContext();

			QueueConnectionFactory qcf =
				(QueueConnectionFactory) ctx.lookup(
					"java:comp/env/jms/QueueConnectionFactory");
			Queue queue = (Queue) ctx.lookup("java:comp/env/jms/OutputQueue");

			connection = qcf.createQueueConnection();
			session =
				connection.createQueueSession(true, Session.AUTO_ACKNOWLEDGE);

			QueueSender sender = session.createSender(queue);
			TextMessage message = session.createTextMessage(text);
			sender.send(message);

		} catch (Exception e) {
			System.out.println("exception in put to queue " + e);
			throw new OrderException(e.toString());
		} finally {
			try {
				if (session != null)
					session.close();
				if (connection != null)
					connection.close();
			} catch (Exception e2) {
				System.out.println("Exception in closing JMS resources");
				// log it and eat it
			}
		}

	}

}

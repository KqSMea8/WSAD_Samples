package com.ibm.ejb.tests;

import javax.jms.JMSException;
import javax.jms.TextMessage;

/**
 * Bean implementation class for Enterprise Bean: OrderQueueClearingMDB
 */
public class OrderQueueClearingMDBBean
	implements javax.ejb.MessageDrivenBean, javax.jms.MessageListener {
	private javax.ejb.MessageDrivenContext fMessageDrivenCtx;
	/**
	 * getMessageDrivenContext
	 */
	public javax.ejb.MessageDrivenContext getMessageDrivenContext() {
		return fMessageDrivenCtx;
	}
	/**
	 * setMessageDrivenContext
	 */
	public void setMessageDrivenContext(javax.ejb.MessageDrivenContext ctx) {
		fMessageDrivenCtx = ctx;
	}
	/**
	 * ejbCreate
	 */
	public void ejbCreate() {
	}
	/**
	 * onMessage
	 */
	public void onMessage(javax.jms.Message msg) {
		// Just pull it off and send the text to the console.
		try {
			TextMessage message = (TextMessage) msg;
			System.out.println("Order received == " + message.getText());
		} catch (JMSException e) {
			System.out.println("JMS Exception caught " + e);
		}
	}
	/**
	 * ejbRemove
	 */
	public void ejbRemove() {
	}
}

package com.wsbook.mdbsample;

import javax.jms.TextMessage;


/**
 * Bean implementation class for Enterprise Bean: SampleMDB
 */
public class SampleMDBBean
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
		try {
			System.out.println("Invoking MDB onMessage() now.");
			System.out.println("Message Object is: " + msg);
			System.out.println("Text message is: " + ((TextMessage) msg).getText());
		} catch (Exception e) {
			System.out.println("Exception occured: " + e);
			e.printStackTrace();
		}
	}
	/**
	 * ejbRemove
	 */
	public void ejbRemove() {
	}
}

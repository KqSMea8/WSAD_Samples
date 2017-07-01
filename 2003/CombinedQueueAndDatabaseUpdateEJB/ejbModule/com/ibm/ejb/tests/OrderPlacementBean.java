package com.ibm.ejb.tests;

/**
 * Bean implementation class for Enterprise Bean: OrderPlacement
 */
public class OrderPlacementBean implements javax.ejb.SessionBean {
	private javax.ejb.SessionContext mySessionCtx;
	/**
	 * getSessionContext
	 */
	public javax.ejb.SessionContext getSessionContext() {
		return mySessionCtx;
	}
	/**
	 * setSessionContext
	 */
	public void setSessionContext(javax.ejb.SessionContext ctx) {
		mySessionCtx = ctx;
	}
	/**
	 * ejbCreate
	 */
	public void ejbCreate() throws javax.ejb.CreateException {
	}
	/**
	 * ejbActivate
	 */
	public void ejbActivate() {
	}
	/**
	 * ejbPassivate
	 */
	public void ejbPassivate() {
	}
	/**
	 * ejbRemove
	 */
	public void ejbRemove() {
	}

	public void processOrder(Order anOrder) throws OrderException {
		try {
			OrderProcessor processor = new OrderProcessor();
			processor.processOrder(anOrder);
		} catch (OrderException e) {
			mySessionCtx.setRollbackOnly();
			throw e;
		}
	}
	
	public Order retrieveOrder(String orderKey) throws OrderException {
		Order anOrder = null;
		try {
			OrderProcessor processor = new OrderProcessor();
			anOrder = processor.retrieveOrderFromDatabase(orderKey);
		} catch (OrderException e) {
			mySessionCtx.setRollbackOnly();
			throw e;
		}	
		return anOrder;
	}

}

package com.wsbook.casestudy.ejb.utilities;

import java.util.Random;

/**
 * Bean implementation class for Enterprise Bean: RandomIDGenerator
 */
public class RandomIDGeneratorBean implements javax.ejb.SessionBean {
	private javax.ejb.SessionContext mySessionCtx;
	private Random random;
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
	
	public int calculateID() {
		return getRandom().nextInt();
	}

	private Random getRandom() {
		if (random == null)
			random = new Random(System.currentTimeMillis());
		return random;
	}

}

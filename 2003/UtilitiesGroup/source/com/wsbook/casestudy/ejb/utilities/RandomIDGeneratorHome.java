package com.wsbook.casestudy.ejb.utilities;
/**
 * Home interface for Enterprise Bean: RandomIDGenerator
 */
public interface RandomIDGeneratorHome extends javax.ejb.EJBHome {
	/**
	 * Creates a default instance of Session Bean: RandomIDGenerator
	 */
	public com.wsbook.casestudy.ejb.utilities.RandomIDGenerator create()
		throws javax.ejb.CreateException, java.rmi.RemoteException;
}

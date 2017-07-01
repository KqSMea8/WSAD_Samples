package com.ibm.ejb.tests;
/**
 * Home interface for Enterprise Bean: OrderPlacement
 */
public interface OrderPlacementHome extends javax.ejb.EJBHome {
	/**
	 * Creates a default instance of Session Bean: OrderPlacement
	 */
	public com.ibm.ejb.tests.OrderPlacement create()
		throws javax.ejb.CreateException, java.rmi.RemoteException;
}

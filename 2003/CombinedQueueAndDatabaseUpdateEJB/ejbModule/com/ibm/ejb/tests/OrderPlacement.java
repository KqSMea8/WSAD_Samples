package com.ibm.ejb.tests;
import com.ibm.ejb.tests.Order;
import com.ibm.ejb.tests.OrderException;
/**
 * Remote interface for Enterprise Bean: OrderPlacement
 */
public interface OrderPlacement extends javax.ejb.EJBObject {
	public void processOrder(Order anOrder) throws java.rmi.RemoteException, OrderException;
	public Order retrieveOrder(String orderKey)
		throws OrderException, java.rmi.RemoteException;
}

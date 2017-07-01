package com.wsbook.casestudy.ejb.utilities;
/**
 * Remote interface for Enterprise Bean: RandomIDGenerator
 */
public interface RandomIDGenerator extends javax.ejb.EJBObject {
	public int calculateID() throws java.rmi.RemoteException;
}

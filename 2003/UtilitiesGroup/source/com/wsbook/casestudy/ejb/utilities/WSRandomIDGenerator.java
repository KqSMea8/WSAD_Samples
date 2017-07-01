package com.wsbook.casestudy.ejb.utilities;
/**
 * Remote interface for Enterprise Bean: RandomIDGenerator
 */
public interface WSRandomIDGenerator extends java.rmi.Remote {
	public int calculateID() throws java.rmi.RemoteException;
}

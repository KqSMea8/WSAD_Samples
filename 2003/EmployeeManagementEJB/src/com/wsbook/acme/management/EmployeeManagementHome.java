package com.wsbook.acme.management;

import com.wsbook.acme.Employee;

/**
 * Home interface for Enterprise Bean: EmployeeManagement
 */
public interface EmployeeManagementHome extends javax.ejb.EJBHome {
	/**
	 * Creates a default instance of Session Bean: EmployeeManagement
	 */
	public com.wsbook.acme.management.EmployeeManagement create()
		throws javax.ejb.CreateException, java.rmi.RemoteException;

}

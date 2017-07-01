package com.wsbook.acme.management;
/**
 * Local Home interface for Enterprise Bean: EmployeeManagement
 */
public interface EmployeeManagementLocalHome extends javax.ejb.EJBLocalHome {
	/**
	 * Creates a default instance of Session Bean: EmployeeManagement
	 */
	public com.wsbook.acme.management.EmployeeManagementLocal create()
		throws javax.ejb.CreateException;
}

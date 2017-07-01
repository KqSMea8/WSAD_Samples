package com.wsbook.casestudy.ejb;
/**
 * Local Home interface for Enterprise Bean: EmployeeEJB
 */
public interface EmployeeEJBHome extends javax.ejb.EJBLocalHome {
	/**
	 * Creates an instance from a key for Entity Bean: EmployeeEJB
	 */
	public com.wsbook.casestudy.ejb.EmployeeEJB create(
		java.lang.String empId)
		throws javax.ejb.CreateException;
	/**
	 * Finds an instance using a key for Entity Bean: EmployeeEJB
	 */
	public com.wsbook.casestudy.ejb.EmployeeEJB findByPrimaryKey(
		java.lang.String primaryKey)
		throws javax.ejb.FinderException;
	/**
	 * create
	 */
	public com.wsbook.casestudy.ejb.EmployeeEJB create(
		java.lang.String empId,
		String name)
		throws javax.ejb.CreateException;
	/**
		 * findAll
		 */
	public java.util.Collection findAll() throws javax.ejb.FinderException;
}

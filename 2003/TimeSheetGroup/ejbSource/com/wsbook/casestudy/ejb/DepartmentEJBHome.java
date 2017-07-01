package com.wsbook.casestudy.ejb;
/**
 * Local Home interface for Enterprise Bean: DepartmentEJB
 */
public interface DepartmentEJBHome extends javax.ejb.EJBLocalHome {
	/**
	 * Creates an instance from a key for Entity Bean: DepartmentEJB
	 */
	public com.wsbook.casestudy.ejb.DepartmentEJB create(int deptNumber)
		throws javax.ejb.CreateException;
	/**
	 * Finds an instance using a key for Entity Bean: DepartmentEJB
	 */
	public com.wsbook.casestudy.ejb.DepartmentEJB findByPrimaryKey(
		com.wsbook.casestudy.ejb.DepartmentEJBKey primaryKey)
		throws javax.ejb.FinderException;
	/**
		 * findAll
		 */
	public java.util.Collection findAll() throws javax.ejb.FinderException;
	/**
	 * create
	 */
	public com.wsbook.casestudy.ejb.DepartmentEJB create(
		int deptNumber,
		java.lang.String name)
		throws javax.ejb.CreateException;
}

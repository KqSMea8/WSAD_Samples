package com.wsbook.casestudy.ejb;
/**
 * Local Home interface for Enterprise Bean: CustomerEJB
 */
public interface CustomerEJBHome extends javax.ejb.EJBLocalHome {
	/**
	 * Finds an instance using a key for Entity Bean: CustomerEJB
	 */
	public com.wsbook.casestudy.ejb.CustomerEJB findByPrimaryKey(
		com.wsbook.casestudy.ejb.CustomerEJBKey primaryKey)
		throws javax.ejb.FinderException;
	/**
	 * create
	 */
	public com.wsbook.casestudy.ejb.CustomerEJB create(
		int arg1,
		java.lang.String arg2)
		throws javax.ejb.CreateException;
}

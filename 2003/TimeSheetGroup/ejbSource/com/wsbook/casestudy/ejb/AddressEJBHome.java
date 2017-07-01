package com.wsbook.casestudy.ejb;
/**
 * Local Home interface for Enterprise Bean: AddressEJB
 */
public interface AddressEJBHome extends javax.ejb.EJBLocalHome {
	/**
	 * Creates an instance from a key for Entity Bean: AddressEJB
	 */
	public com.wsbook.casestudy.ejb.AddressEJB create(int addressKey)
		throws javax.ejb.CreateException;
	/**
	 * Finds an instance using a key for Entity Bean: AddressEJB
	 */
	public com.wsbook.casestudy.ejb.AddressEJB findByPrimaryKey(
		com.wsbook.casestudy.ejb.AddressEJBKey primaryKey)
		throws javax.ejb.FinderException;
}

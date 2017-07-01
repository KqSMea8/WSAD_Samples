package com.wsbook.casestudy.ejb;
/**
 * Local Home interface for Enterprise Bean: ProjectEJB
 */
public interface ProjectEJBHome extends javax.ejb.EJBLocalHome {
	/**
	 * Creates an instance from a key for Entity Bean: ProjectEJB
	 */
	public com.wsbook.casestudy.ejb.ProjectEJB create(
		java.lang.String projNumber)
		throws javax.ejb.CreateException;
	/**
	 * Finds an instance using a key for Entity Bean: ProjectEJB
	 */
	public com.wsbook.casestudy.ejb.ProjectEJB findByPrimaryKey(
		java.lang.String primaryKey)
		throws javax.ejb.FinderException;
	/**
		 * findAll
		 */
	public java.util.Collection findAll() throws javax.ejb.FinderException;
	/**
	 * create
	 */
	public com.wsbook.casestudy.ejb.ProjectEJB create(
		java.lang.String projNumber,
		java.lang.String name)
		throws javax.ejb.CreateException;
	public com.wsbook.casestudy.ejb.ProjectEJB findByName(String name) throws javax.ejb.FinderException;
}

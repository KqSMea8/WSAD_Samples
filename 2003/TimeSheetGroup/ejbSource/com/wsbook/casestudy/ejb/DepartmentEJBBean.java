package com.wsbook.casestudy.ejb;
/**
 * Bean implementation class for Enterprise Bean: DepartmentEJB
 */
public abstract class DepartmentEJBBean implements javax.ejb.EntityBean {

	private javax.ejb.EntityContext myEntityCtx;
	/**
	 * getEntityContext
	 */
	public javax.ejb.EntityContext getEntityContext() {
		return myEntityCtx;
	}
	/**
	 * setEntityContext
	 */
	public void setEntityContext(javax.ejb.EntityContext ctx) {
		myEntityCtx = ctx;
	}
	/**
	 * unsetEntityContext
	 */
	public void unsetEntityContext() {
		myEntityCtx = null;
	}
	/**
	 * ejbActivate
	 */
	public void ejbActivate() {
	}
	/**
	 * ejbCreate
	 */
	public com.wsbook.casestudy.ejb.DepartmentEJBKey ejbCreate(int deptNumber)
		throws javax.ejb.CreateException {
		setDeptNumber(deptNumber);
		return null;
	}
	/** 
	 * ejbCreate
	 * @param deptNumber key
	 * @param name display name of the Department
	 */
	public DepartmentEJBKey ejbCreate(int deptNumber, String name) throws javax.ejb.CreateException {
		setDeptNumber(deptNumber);
		setName(name);
		return null;
	}
	public void ejbPostCreate(int deptNumber, String name) throws javax.ejb.CreateException {
	} 
	/**
	 * ejbLoad
	 */
	public void ejbLoad() {
	}
	/**
	 * ejbPassivate
	 */
	public void ejbPassivate() {
	}
	/**
	 * ejbPostCreate
	 */
	public void ejbPostCreate(int deptNumber) throws javax.ejb.CreateException {
	}
	/**
	 * ejbRemove
	 */
	public void ejbRemove() throws javax.ejb.RemoveException {
	}
	/**
	 * ejbStore
	 */
	public void ejbStore() {
	}
	/**
	 * Get accessor for persistent attribute: name
	 */
	public abstract java.lang.String getName();
	/**
	 * Set accessor for persistent attribute: name
	 */
	public abstract void setName(java.lang.String newName);
	/**
	 * Get accessor for persistent attribute: deptNumber
	 */
	public abstract int getDeptNumber();
	/**
	 * Set accessor for persistent attribute: deptNumber
	 */
	public abstract void setDeptNumber(int newDeptNumber);
}

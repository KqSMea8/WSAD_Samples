package com.wsbook.casestudy.ejb;
/**
 * Bean implementation class for Enterprise Bean: ProjectEJB
 */
public abstract class ProjectEJBBean implements javax.ejb.EntityBean {

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
	public java.lang.String ejbCreate(java.lang.String projNumber)
		throws javax.ejb.CreateException {
		setProjNumber(projNumber);
		return null;
	}
	/**
	 * ejbCreate method for a CMP entity bean.
	 */
	public String ejbCreate(java.lang.String projNumber, String name) throws javax.ejb.CreateException {
		setProjNumber(projNumber);
		setName(name);
		return null;
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
	public void ejbPostCreate(String projNumber) throws javax.ejb.CreateException {
	}
	/**
	 * ejbPostCreate
	 */
	public void ejbPostCreate(String projNumber, String name) throws javax.ejb.CreateException {
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
	 * Get accessor for persistent attribute: projNumber
	 */
	public abstract java.lang.String getProjNumber();
	/**
	 * Set accessor for persistent attribute: projNumber
	 */
	public abstract void setProjNumber(java.lang.String newProjNumber);
	/**
	 * This method was generated for supporting the relationship role named timesheetentry.
	 * It will be deleted/edited when the relationship is deleted/edited.
	 */
	public abstract java.util.Collection getTimesheetentry();
	/**
	 * This method was generated for supporting the relationship role named timesheetentry.
	 * It will be deleted/edited when the relationship is deleted/edited.
	 */
	public abstract void setTimesheetentry(
		java.util.Collection aTimesheetentry);
}

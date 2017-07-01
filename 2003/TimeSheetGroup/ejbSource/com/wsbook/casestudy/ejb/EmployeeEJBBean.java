package com.wsbook.casestudy.ejb;
/**
 * Bean implementation class for Enterprise Bean: EmployeeEJB
 */
public abstract class EmployeeEJBBean implements javax.ejb.EntityBean {

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
	public java.lang.String ejbCreate(java.lang.String empId)
		throws javax.ejb.CreateException {
		setEmpId(empId);
		return null;
	}
	/**
	 * ejbCreate method for a CMP entity bean.
	 */
	public String ejbCreate(String empId, String name) throws javax.ejb.CreateException {
		setEmpId(empId);
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
	public void ejbPostCreate(java.lang.String empId)
		throws javax.ejb.CreateException {
	}
	/**
	 * ejbPostCreate
	 */
	public void ejbPostCreate(java.lang.String empId, String name) throws javax.ejb.CreateException {
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
	 * Get accessor for persistent attribute: empId
	 */
	public abstract java.lang.String getEmpId();
	/**
	 * Set accessor for persistent attribute: empId
	 */
	public abstract void setEmpId(java.lang.String newEmpId);
	/**
	 * This method was generated for supporting the relationship role named homeAddress.
	 * It will be deleted/edited when the relationship is deleted/edited.
	 */
	public abstract com.wsbook.casestudy.ejb.AddressEJB getHomeAddress();
	/**
	 * This method was generated for supporting the relationship role named homeAddress.
	 * It will be deleted/edited when the relationship is deleted/edited.
	 */
	public abstract void setHomeAddress(
		com.wsbook.casestudy.ejb.AddressEJB aHomeAddress);
	/**
	 * This method was generated for supporting the relationship role named timesheets.
	 * It will be deleted/edited when the relationship is deleted/edited.
	 */
	public abstract java.util.Collection getTimesheets();
	/**
	 * This method was generated for supporting the relationship role named timesheets.
	 * It will be deleted/edited when the relationship is deleted/edited.
	 */
	public abstract void setTimesheets(java.util.Collection aTimesheets);
	/**
	 * This method was generated for supporting the relationship role named approvedTimesheets.
	 * It will be deleted/edited when the relationship is deleted/edited.
	 */
	public abstract java.util.Collection getApprovedTimesheets();
	/**
	 * This method was generated for supporting the relationship role named approvedTimesheets.
	 * It will be deleted/edited when the relationship is deleted/edited.
	 */
	public abstract void setApprovedTimesheets(
		java.util.Collection anApprovedTimesheets);
	/**
	 * Get accessor for persistent attribute: name
	 */
	public abstract java.lang.String getName();
	/**
	 * Set accessor for persistent attribute: name
	 */
	public abstract void setName(java.lang.String newName);
	/**
	 * Get accessor for persistent attribute: office
	 */
	public abstract com.wsbook.casestudy.ejb.OfficeLocation getOffice();
	/**
	 * Set accessor for persistent attribute: office
	 */
	public abstract void setOffice(
		com.wsbook.casestudy.ejb.OfficeLocation newOffice);
}

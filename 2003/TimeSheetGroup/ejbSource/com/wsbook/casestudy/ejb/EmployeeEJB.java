package com.wsbook.casestudy.ejb;
/**
 * Local interface for Enterprise Bean: EmployeeEJB
 */
public interface EmployeeEJB extends javax.ejb.EJBLocalObject {
	/**
	 * This method was generated for supporting the relationship role named homeAddress.
	 * It will be deleted/edited when the relationship is deleted/edited.
	 */
	public com.wsbook.casestudy.ejb.AddressEJB getHomeAddress();
	/**
	 * This method was generated for supporting the relationship role named homeAddress.
	 * It will be deleted/edited when the relationship is deleted/edited.
	 */
	public void setHomeAddress(
		com.wsbook.casestudy.ejb.AddressEJB aHomeAddress);
	/**
	 * This method was generated for supporting the relationship role named timesheets.
	 * It will be deleted/edited when the relationship is deleted/edited.
	 */
	public java.util.Collection getTimesheets();
	/**
	 * This method was generated for supporting the relationship role named timesheets.
	 * It will be deleted/edited when the relationship is deleted/edited.
	 */
	public void setTimesheets(java.util.Collection aTimesheets);
	/**
	 * This method was generated for supporting the relationship role named approvedTimesheets.
	 * It will be deleted/edited when the relationship is deleted/edited.
	 */
	public java.util.Collection getApprovedTimesheets();
	/**
	 * This method was generated for supporting the relationship role named approvedTimesheets.
	 * It will be deleted/edited when the relationship is deleted/edited.
	 */
	public void setApprovedTimesheets(
		java.util.Collection anApprovedTimesheets);
	/**
	 * Get accessor for persistent attribute: name
	 */
	public java.lang.String getName();
	/**
	 * Set accessor for persistent attribute: name
	 */
	public void setName(java.lang.String newName);
	/**
	 * Get accessor for persistent attribute: office
	 */
	public com.wsbook.casestudy.ejb.OfficeLocation getOffice();
	/**
	 * Set accessor for persistent attribute: office
	 */
	public void setOffice(com.wsbook.casestudy.ejb.OfficeLocation newOffice);
}

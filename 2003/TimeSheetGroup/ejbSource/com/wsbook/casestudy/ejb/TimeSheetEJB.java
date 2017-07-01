package com.wsbook.casestudy.ejb;
/**
 * Local interface for Enterprise Bean: TimeSheetEJB
 */
public interface TimeSheetEJB extends javax.ejb.EJBLocalObject {
	/**
	 * getWeekend
	 */
	public java.lang.String getWeekend();
	/**
	 * setWeekend
	 */
	public void setWeekend(java.lang.String newWeekend);
	/**
	 * getState
	 */
	public java.lang.String getState();
	/**
	 * setState
	 */
	public void setState(java.lang.String newState);
	/**
	 * This method was generated for supporting the relationship role named entries.
	 * It will be deleted/edited when the relationship is deleted/edited.
	 */
	public java.util.Collection getEntries();
	/**
	 * This method was generated for supporting the relationship role named entries.
	 * It will be deleted/edited when the relationship is deleted/edited.
	 */
	public void setEntries(java.util.Collection anEntries);
	/**
	 * This method was generated for supporting the relationship role named submitter.
	 * It will be deleted/edited when the relationship is deleted/edited.
	 */
	public com.wsbook.casestudy.ejb.EmployeeEJB getSubmitter();
	/**
	 * This method was generated for supporting the relationship role named submitter.
	 * It will be deleted/edited when the relationship is deleted/edited.
	 */
	public void setSubmitter(
		com.wsbook.casestudy.ejb.EmployeeEJB aSubmitter);
	/**
	 * This method was generated for supporting the relationship role named approver.
	 * It will be deleted/edited when the relationship is deleted/edited.
	 */
	public com.wsbook.casestudy.ejb.EmployeeEJB getApprover();
	/**
	 * This method was generated for supporting the relationship role named approver.
	 * It will be deleted/edited when the relationship is deleted/edited.
	 */
	public void setApprover(
		com.wsbook.casestudy.ejb.EmployeeEJB anApprover);
}

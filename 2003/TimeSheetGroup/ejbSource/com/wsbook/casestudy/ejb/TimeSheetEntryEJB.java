package com.wsbook.casestudy.ejb;
/**
 * Local interface for Enterprise Bean: TimeSheetEntryEJB
 */
public interface TimeSheetEntryEJB extends javax.ejb.EJBLocalObject {
	/**
	 * getDate
	 */
	public java.lang.String getDate();
	/**
	 * setDate
	 */
	public void setDate(java.lang.String newDate);
	/**
	 * getHours
	 */
	public double getHours();
	/**
	 * setHours
	 */
	public void setHours(double newHours);
	/**
	 * This method was generated for supporting the relationship role named timesheet.
	 * It will be deleted/edited when the relationship is deleted/edited.
	 */
	public com.wsbook.casestudy.ejb.TimeSheetEJB getTimesheet();
	/**
	 * This method was generated for supporting the relationship role named timesheet.
	 * It will be deleted/edited when the relationship is deleted/edited.
	 */
	public void setTimesheet(
		com.wsbook.casestudy.ejb.TimeSheetEJB aTimesheet);
	/**
	 * This method was generated for supporting the relationship role named project.
	 * It will be deleted/edited when the relationship is deleted/edited.
	 */
	public com.wsbook.casestudy.ejb.ProjectEJB getProject();
	/**
	 * This method was generated for supporting the relationship role named project.
	 * It will be deleted/edited when the relationship is deleted/edited.
	 */
	public void setProject(com.wsbook.casestudy.ejb.ProjectEJB aProject);
}

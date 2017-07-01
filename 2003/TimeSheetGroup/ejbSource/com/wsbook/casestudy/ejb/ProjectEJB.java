package com.wsbook.casestudy.ejb;
/**
 * Local interface for Enterprise Bean: ProjectEJB
 */
public interface ProjectEJB extends javax.ejb.EJBLocalObject {
	/**
	 * getName
	 */
	public java.lang.String getName();
	/**
	 * setName
	 */
	public void setName(java.lang.String newName);
	/**
	 * This method was generated for supporting the relationship role named timesheetentry.
	 * It will be deleted/edited when the relationship is deleted/edited.
	 */
	public java.util.Collection getTimesheetentry();
	/**
	 * This method was generated for supporting the relationship role named timesheetentry.
	 * It will be deleted/edited when the relationship is deleted/edited.
	 */
	public void setTimesheetentry(java.util.Collection aTimesheetentry);
}

package com.wsbook.casestudy.ejb.websphere_deploy;

/**
 * Cache Entry interface for Enterprise Bean: TimeSheetEntryEJB
 */
public interface TimeSheetEntryEJBBeanCacheEntry_f7c19b5d extends java.io.Serializable {
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
	 * getEntryId
	 */
	public int getEntryId();
	/**
	 * setEntryId
	 */
	public void setEntryId(int newEntryId);
	/**
	 * getTimesheet_timeSheetId
	 */
	public int getTimesheet_timeSheetId();
	/**
	 * setTimesheet_timeSheetId
	 */
	public void setTimesheet_timeSheetId(int newTimesheet_timeSheetId);
	/**
	 * getProject_projNumber
	 */
	public java.lang.String getProject_projNumber();
	/**
	 * setProject_projNumber
	 */
	public void setProject_projNumber(java.lang.String newProject_projNumber);
	/**
	 * getTimesheetKey
	 */
	public com.wsbook.casestudy.ejb.TimeSheetEJBKey getTimesheetKey();
	/**
	 * getProjectKey
	 */
	public java.lang.String getProjectKey();
}

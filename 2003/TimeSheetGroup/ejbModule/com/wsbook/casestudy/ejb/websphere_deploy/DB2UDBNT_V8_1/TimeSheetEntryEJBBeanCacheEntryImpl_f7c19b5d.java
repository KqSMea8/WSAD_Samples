package com.wsbook.casestudy.ejb.websphere_deploy.DB2UDBNT_V8_1;

/**
 * TimeSheetEntryEJBBeanCacheEntryImpl_f7c19b5d
 */
public class TimeSheetEntryEJBBeanCacheEntryImpl_f7c19b5d extends com.ibm.ws.ejbpersistence.cache.DataCacheEntry implements com.wsbook.casestudy.ejb.websphere_deploy.TimeSheetEntryEJBBeanCacheEntry_f7c19b5d {
	/**
	 * getDate
	 */
	public java.lang.String getDate() {
		return DATE1_Data;
	}
	/**
	 * setDate
	 */
	public void setDate(String data) {
		this.DATE1_Data=data;
	}
	/**
	 * setDataForDATE1
	 */
	public void setDataForDATE1(String data) {
		this.DATE1_Data=data;
	}
	private String DATE1_Data;
	/**
	 * getHours
	 */
	public double getHours() {
		return HOURS1_Data;
	}
	/**
	 * setHours
	 */
	public void setHours(double data) {
		this.HOURS1_Data=data;
	}
	/**
	 * setDataForHOURS1
	 */
	public void setDataForHOURS1(double data) {
		this.HOURS1_Data=data;
	}
	private double HOURS1_Data;
	/**
	 * getEntryId
	 */
	public int getEntryId() {
		return ENTRYID_Data;
	}
	/**
	 * setEntryId
	 */
	public void setEntryId(int data) {
		this.ENTRYID_Data=data;
	}
	/**
	 * setDataForENTRYID
	 */
	public void setDataForENTRYID(int data) {
		this.ENTRYID_Data=data;
	}
	private int ENTRYID_Data;
	/**
	 * getTimesheet_timeSheetId
	 */
	public int getTimesheet_timeSheetId() {
		return TIMESHEET_TIMESHEETID_Data;
	}
	/**
	 * setTimesheet_timeSheetId
	 */
	public void setTimesheet_timeSheetId(int data) {
		this.TIMESHEET_TIMESHEETID_Data=data;
	}
	/**
	 * setDataForTIMESHEET_TIMESHEETID
	 */
	public void setDataForTIMESHEET_TIMESHEETID(int data, boolean isNull) {
		this.TIMESHEET_TIMESHEETID_Data=data;
		this.TIMESHEET_TIMESHEETID_IsNull=isNull;
	}
	private int TIMESHEET_TIMESHEETID_Data;
	private boolean TIMESHEET_TIMESHEETID_IsNull = true;
	/**
	 * getProject_projNumber
	 */
	public java.lang.String getProject_projNumber() {
		return PROJECT_PROJNUMBER_Data;
	}
	/**
	 * setProject_projNumber
	 */
	public void setProject_projNumber(String data) {
		this.PROJECT_PROJNUMBER_Data=data;
	}
	/**
	 * setDataForPROJECT_PROJNUMBER
	 */
	public void setDataForPROJECT_PROJNUMBER(String data) {
		this.PROJECT_PROJNUMBER_Data=data;
	}
	private String PROJECT_PROJNUMBER_Data;
	/**
	 * getTimesheetKey
	 */
	public com.wsbook.casestudy.ejb.TimeSheetEJBKey getTimesheetKey() {
		if(TIMESHEET_TIMESHEETID_IsNull)
			return null;
		com.wsbook.casestudy.ejb.TimeSheetEJBKey key=new com.wsbook.casestudy.ejb.TimeSheetEJBKey();
		key.timeSheetId=TIMESHEET_TIMESHEETID_Data;
		return key;
	}
	/**
	 * getProjectKey
	 */
	public java.lang.String getProjectKey() {
		return PROJECT_PROJNUMBER_Data;
	}
	/**
	 * getForeignKey
	 */
	public Object getForeignKey(String role) {
		if(role.equals("timesheet"))
			return getTimesheetKey();
		if(role.equals("project"))
			return getProjectKey();
		else
			return null;
	}
}

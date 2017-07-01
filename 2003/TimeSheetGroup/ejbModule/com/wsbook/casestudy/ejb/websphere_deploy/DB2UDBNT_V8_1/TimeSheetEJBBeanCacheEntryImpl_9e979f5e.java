package com.wsbook.casestudy.ejb.websphere_deploy.DB2UDBNT_V8_1;

/**
 * TimeSheetEJBBeanCacheEntryImpl_9e979f5e
 */
public class TimeSheetEJBBeanCacheEntryImpl_9e979f5e extends com.ibm.ws.ejbpersistence.cache.DataCacheEntry implements com.wsbook.casestudy.ejb.websphere_deploy.TimeSheetEJBBeanCacheEntry_9e979f5e {
	/**
	 * getWeekend
	 */
	public java.lang.String getWeekend() {
		return WEEKEND_Data;
	}
	/**
	 * setWeekend
	 */
	public void setWeekend(String data) {
		this.WEEKEND_Data=data;
	}
	/**
	 * setDataForWEEKEND
	 */
	public void setDataForWEEKEND(String data) {
		this.WEEKEND_Data=data;
	}
	private String WEEKEND_Data;
	/**
	 * getState
	 */
	public java.lang.String getState() {
		return STATE1_Data;
	}
	/**
	 * setState
	 */
	public void setState(String data) {
		this.STATE1_Data=data;
	}
	/**
	 * setDataForSTATE1
	 */
	public void setDataForSTATE1(String data) {
		this.STATE1_Data=data;
	}
	private String STATE1_Data;
	/**
	 * getTimeSheetId
	 */
	public int getTimeSheetId() {
		return TIMESHEETID_Data;
	}
	/**
	 * setTimeSheetId
	 */
	public void setTimeSheetId(int data) {
		this.TIMESHEETID_Data=data;
	}
	/**
	 * setDataForTIMESHEETID
	 */
	public void setDataForTIMESHEETID(int data) {
		this.TIMESHEETID_Data=data;
	}
	private int TIMESHEETID_Data;
	/**
	 * getSubmitter_empId
	 */
	public java.lang.String getSubmitter_empId() {
		return SUBMITTER_EMPID_Data;
	}
	/**
	 * setSubmitter_empId
	 */
	public void setSubmitter_empId(String data) {
		this.SUBMITTER_EMPID_Data=data;
	}
	/**
	 * setDataForSUBMITTER_EMPID
	 */
	public void setDataForSUBMITTER_EMPID(String data) {
		this.SUBMITTER_EMPID_Data=data;
	}
	private String SUBMITTER_EMPID_Data;
	/**
	 * getApprover_empId
	 */
	public java.lang.String getApprover_empId() {
		return APPROVER_EMPID_Data;
	}
	/**
	 * setApprover_empId
	 */
	public void setApprover_empId(String data) {
		this.APPROVER_EMPID_Data=data;
	}
	/**
	 * setDataForAPPROVER_EMPID
	 */
	public void setDataForAPPROVER_EMPID(String data) {
		this.APPROVER_EMPID_Data=data;
	}
	private String APPROVER_EMPID_Data;
	/**
	 * getSubmitterKey
	 */
	public java.lang.String getSubmitterKey() {
		return SUBMITTER_EMPID_Data;
	}
	/**
	 * getApproverKey
	 */
	public java.lang.String getApproverKey() {
		return APPROVER_EMPID_Data;
	}
	/**
	 * getForeignKey
	 */
	public Object getForeignKey(String role) {
		if(role.equals("submitter"))
			return getSubmitterKey();
		if(role.equals("approver"))
			return getApproverKey();
		else
			return null;
	}
}

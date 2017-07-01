package com.wsbook.casestudy.ejb.websphere_deploy;

/**
 * Injector interface for Enterprise Bean: TimeSheetEJB
 */
public interface TimeSheetEJBBeanInjector_9e979f5e extends com.ibm.ws.ejbpersistence.beanextensions.EJBInjector {
	/**
	 * ejbFindApprovedTimesheetsByApprover
	 */
	public void ejbFindApprovedTimesheetsByApprover(java.lang.String inKey, javax.resource.cci.IndexedRecord record);
	/**
	 * ejbFindPendingByEmployee
	 */
	public void ejbFindPendingByEmployee(java.lang.String empId, javax.resource.cci.IndexedRecord record);
	/**
	 * ejbFindTimesheetsBySubmitter
	 */
	public void ejbFindTimesheetsBySubmitter(java.lang.String inKey, javax.resource.cci.IndexedRecord record);
	/**
	 * findTimesheetByEntriesKey_Local
	 */
	public void findTimesheetByEntriesKey_Local(com.wsbook.casestudy.ejb.TimeSheetEntryEJBKey key, javax.resource.cci.IndexedRecord record);
	/**
	 * findTimesheetsBySubmitterKey_Local
	 */
	public void findTimesheetsBySubmitterKey_Local(java.lang.String key, javax.resource.cci.IndexedRecord record);
	/**
	 * findApprovedTimesheetsByApproverKey_Local
	 */
	public void findApprovedTimesheetsByApproverKey_Local(java.lang.String key, javax.resource.cci.IndexedRecord record);
}

package com.wsbook.casestudy.ejb.websphere_deploy;

/**
 * Injector interface for Enterprise Bean: TimeSheetEntryEJB
 */
public interface TimeSheetEntryEJBBeanInjector_f7c19b5d extends com.ibm.ws.ejbpersistence.beanextensions.EJBInjector {
	/**
	 * findEntriesByTimesheetKey_Local
	 */
	public void findEntriesByTimesheetKey_Local(com.wsbook.casestudy.ejb.TimeSheetEJBKey key, javax.resource.cci.IndexedRecord record);
	/**
	 * findTimesheetentryByProjectKey_Local
	 */
	public void findTimesheetentryByProjectKey_Local(java.lang.String key, javax.resource.cci.IndexedRecord record);
}

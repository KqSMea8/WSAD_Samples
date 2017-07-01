package com.wsbook.casestudy.ejb.websphere_deploy;

/**
 * Injector interface for Enterprise Bean: ProjectEJB
 */
public interface ProjectEJBBeanInjector_8ce694f3 extends com.ibm.ws.ejbpersistence.beanextensions.EJBInjector {
	/**
	 * ejbFindByName
	 */
	public void ejbFindByName(java.lang.String name, javax.resource.cci.IndexedRecord record);
	/**
	 * findProjectByTimesheetentryKey_Local
	 */
	public void findProjectByTimesheetentryKey_Local(com.wsbook.casestudy.ejb.TimeSheetEntryEJBKey key, javax.resource.cci.IndexedRecord record);
}

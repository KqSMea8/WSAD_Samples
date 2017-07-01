package com.wsbook.casestudy.ejb.websphere_deploy;

/**
 * Internal Local Home interface for Enterprise Bean: TimeSheetEntryEJB
 */
public interface TimeSheetEntryEJBBeanInternalLocalHome_f7c19b5d {
	/**
	 * findEntriesByTimesheetKey_Local
	 */
	public java.util.Collection findEntriesByTimesheetKey_Local(com.wsbook.casestudy.ejb.TimeSheetEJBKey key) throws javax.ejb.FinderException;
	/**
	 * findTimesheetentryByProjectKey_Local
	 */
	public java.util.Collection findTimesheetentryByProjectKey_Local(java.lang.String key) throws javax.ejb.FinderException;
}

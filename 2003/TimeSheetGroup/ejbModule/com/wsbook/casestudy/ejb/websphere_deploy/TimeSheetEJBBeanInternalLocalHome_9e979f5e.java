package com.wsbook.casestudy.ejb.websphere_deploy;

/**
 * Internal Local Home interface for Enterprise Bean: TimeSheetEJB
 */
public interface TimeSheetEJBBeanInternalLocalHome_9e979f5e {
	/**
	 * findTimesheetByEntriesKey_Local
	 */
	public com.wsbook.casestudy.ejb.TimeSheetEJB findTimesheetByEntriesKey_Local(com.wsbook.casestudy.ejb.TimeSheetEntryEJBKey key) throws javax.ejb.FinderException;
	/**
	 * findTimesheetsBySubmitterKey_Local
	 */
	public java.util.Collection findTimesheetsBySubmitterKey_Local(java.lang.String key) throws javax.ejb.FinderException;
	/**
	 * findApprovedTimesheetsByApproverKey_Local
	 */
	public java.util.Collection findApprovedTimesheetsByApproverKey_Local(java.lang.String key) throws javax.ejb.FinderException;
	/**
	 * findByPrimaryKeyForCMR
	 */
	public com.wsbook.casestudy.ejb.TimeSheetEJB findByPrimaryKeyForCMR(com.wsbook.casestudy.ejb.TimeSheetEJBKey key) throws javax.ejb.FinderException;
}

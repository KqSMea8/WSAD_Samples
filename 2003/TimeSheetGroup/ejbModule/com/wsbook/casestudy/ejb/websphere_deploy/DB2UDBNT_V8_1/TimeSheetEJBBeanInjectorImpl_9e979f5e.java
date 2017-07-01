package com.wsbook.casestudy.ejb.websphere_deploy.DB2UDBNT_V8_1;

/**
 * TimeSheetEJBBeanInjectorImpl_9e979f5e
 */
public class TimeSheetEJBBeanInjectorImpl_9e979f5e implements com.wsbook.casestudy.ejb.websphere_deploy.TimeSheetEJBBeanInjector_9e979f5e {
	/**
	 * ejbCreate
	 */
	public void ejbCreate(com.ibm.ws.ejbpersistence.beanextensions.ConcreteBean cb, javax.resource.cci.IndexedRecord record) {
		com.wsbook.casestudy.ejb.ConcreteTimeSheetEJB_9e979f5e concreteBean=(com.wsbook.casestudy.ejb.ConcreteTimeSheetEJB_9e979f5e)cb;
		record.set(0,concreteBean.getWeekend());
		record.set(1,concreteBean.getState());
		record.set(2,new Integer(concreteBean.getTimeSheetId()));
		record.set(3,concreteBean.getSubmitterKey());
		record.set(4,concreteBean.getApproverKey());
	}
	/**
	 * ejbStore
	 */
	public void ejbStore(com.ibm.ws.ejbpersistence.beanextensions.ConcreteBean cb, javax.resource.cci.IndexedRecord record) {
		com.wsbook.casestudy.ejb.ConcreteTimeSheetEJB_9e979f5e concreteBean=(com.wsbook.casestudy.ejb.ConcreteTimeSheetEJB_9e979f5e)cb;
		record.set(0,concreteBean.getWeekend());
		record.set(1,concreteBean.getState());
		record.set(2,new Integer(concreteBean.getTimeSheetId()));
		record.set(3,concreteBean.getSubmitterKey());
		record.set(4,concreteBean.getApproverKey());
	}
	/**
	 * ejbRemove
	 */
	public void ejbRemove(com.ibm.ws.ejbpersistence.beanextensions.ConcreteBean cb, javax.resource.cci.IndexedRecord record) {
		com.wsbook.casestudy.ejb.ConcreteTimeSheetEJB_9e979f5e concreteBean=(com.wsbook.casestudy.ejb.ConcreteTimeSheetEJB_9e979f5e)cb;
		record.set(2,new Integer(concreteBean.getTimeSheetId()));
	}
	/**
	 * ejbFindPendingByEmployee
	 */
	public void ejbFindPendingByEmployee(java.lang.String empId, javax.resource.cci.IndexedRecord record) {
		record.set(0,empId);
	}
	/**
	 * ejbFindApprovedTimesheetsByApprover
	 */
	public void ejbFindApprovedTimesheetsByApprover(java.lang.String inKey, javax.resource.cci.IndexedRecord record) {
		record.set(0,inKey);
	}
	/**
	 * ejbFindByPrimaryKey
	 */
	public void ejbFindByPrimaryKey(Object pkeyObject, javax.resource.cci.IndexedRecord record) {
		com.wsbook.casestudy.ejb.TimeSheetEJBKey pkey=(com.wsbook.casestudy.ejb.TimeSheetEJBKey)pkeyObject;
		record.set(0,new Integer(pkey.timeSheetId));
	}
	/**
	 * ejbFindTimesheetsBySubmitter
	 */
	public void ejbFindTimesheetsBySubmitter(java.lang.String inKey, javax.resource.cci.IndexedRecord record) {
		record.set(0,inKey);
	}
	/**
	 * findTimesheetsBySubmitterKey_Local
	 */
	public void findTimesheetsBySubmitterKey_Local(java.lang.String fkey, javax.resource.cci.IndexedRecord record) {
		record.set(0,fkey);
	}
	/**
	 * findApprovedTimesheetsByApproverKey_Local
	 */
	public void findApprovedTimesheetsByApproverKey_Local(java.lang.String fkey, javax.resource.cci.IndexedRecord record) {
		record.set(0,fkey);
	}
	/**
	 * findTimesheetByEntriesKey_Local
	 */
	public void findTimesheetByEntriesKey_Local(com.wsbook.casestudy.ejb.TimeSheetEntryEJBKey fkey, javax.resource.cci.IndexedRecord record) {
		record.set(0,new Integer(fkey.entryId));
	}
}

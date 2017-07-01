package com.wsbook.casestudy.ejb.websphere_deploy.DB2UDBNT_V8_1;

/**
 * TimeSheetEntryEJBBeanInjectorImpl_f7c19b5d
 */
public class TimeSheetEntryEJBBeanInjectorImpl_f7c19b5d implements com.wsbook.casestudy.ejb.websphere_deploy.TimeSheetEntryEJBBeanInjector_f7c19b5d {
	/**
	 * ejbCreate
	 */
	public void ejbCreate(com.ibm.ws.ejbpersistence.beanextensions.ConcreteBean cb, javax.resource.cci.IndexedRecord record) {
		com.wsbook.casestudy.ejb.TimeSheetEJBKey tempTimeSheetEJBKey;

		com.wsbook.casestudy.ejb.ConcreteTimeSheetEntryEJB_f7c19b5d concreteBean=(com.wsbook.casestudy.ejb.ConcreteTimeSheetEntryEJB_f7c19b5d)cb;
		record.set(0,concreteBean.getDate());
		record.set(1,new Double(concreteBean.getHours()));
		record.set(2,new Integer(concreteBean.getEntryId()));
		tempTimeSheetEJBKey= concreteBean.getTimesheetKey();
		if(tempTimeSheetEJBKey==null)
			record.set(3,null);
		else
			record.set(3,new Integer(tempTimeSheetEJBKey.timeSheetId));
		record.set(4,concreteBean.getProjectKey());
	}
	/**
	 * ejbStore
	 */
	public void ejbStore(com.ibm.ws.ejbpersistence.beanextensions.ConcreteBean cb, javax.resource.cci.IndexedRecord record) {
		com.wsbook.casestudy.ejb.TimeSheetEJBKey tempTimeSheetEJBKey;

		com.wsbook.casestudy.ejb.ConcreteTimeSheetEntryEJB_f7c19b5d concreteBean=(com.wsbook.casestudy.ejb.ConcreteTimeSheetEntryEJB_f7c19b5d)cb;
		record.set(0,concreteBean.getDate());
		record.set(1,new Double(concreteBean.getHours()));
		record.set(2,new Integer(concreteBean.getEntryId()));
		tempTimeSheetEJBKey= concreteBean.getTimesheetKey();
		if(tempTimeSheetEJBKey==null)
			record.set(3,null);
		else
			record.set(3,new Integer(tempTimeSheetEJBKey.timeSheetId));
		record.set(4,concreteBean.getProjectKey());
	}
	/**
	 * ejbRemove
	 */
	public void ejbRemove(com.ibm.ws.ejbpersistence.beanextensions.ConcreteBean cb, javax.resource.cci.IndexedRecord record) {
		com.wsbook.casestudy.ejb.ConcreteTimeSheetEntryEJB_f7c19b5d concreteBean=(com.wsbook.casestudy.ejb.ConcreteTimeSheetEntryEJB_f7c19b5d)cb;
		record.set(2,new Integer(concreteBean.getEntryId()));
	}
	/**
	 * ejbFindByPrimaryKey
	 */
	public void ejbFindByPrimaryKey(Object pkeyObject, javax.resource.cci.IndexedRecord record) {
		com.wsbook.casestudy.ejb.TimeSheetEntryEJBKey pkey=(com.wsbook.casestudy.ejb.TimeSheetEntryEJBKey)pkeyObject;
		record.set(0,new Integer(pkey.entryId));
	}
	/**
	 * findEntriesByTimesheetKey_Local
	 */
	public void findEntriesByTimesheetKey_Local(com.wsbook.casestudy.ejb.TimeSheetEJBKey fkey, javax.resource.cci.IndexedRecord record) {
		record.set(0,new Integer(fkey.timeSheetId));
	}
	/**
	 * findTimesheetentryByProjectKey_Local
	 */
	public void findTimesheetentryByProjectKey_Local(java.lang.String fkey, javax.resource.cci.IndexedRecord record) {
		record.set(0,fkey);
	}
}

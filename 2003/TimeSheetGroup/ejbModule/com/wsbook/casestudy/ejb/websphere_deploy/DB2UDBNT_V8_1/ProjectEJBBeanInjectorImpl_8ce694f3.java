package com.wsbook.casestudy.ejb.websphere_deploy.DB2UDBNT_V8_1;

/**
 * ProjectEJBBeanInjectorImpl_8ce694f3
 */
public class ProjectEJBBeanInjectorImpl_8ce694f3 implements com.wsbook.casestudy.ejb.websphere_deploy.ProjectEJBBeanInjector_8ce694f3 {
	/**
	 * ejbCreate
	 */
	public void ejbCreate(com.ibm.ws.ejbpersistence.beanextensions.ConcreteBean cb, javax.resource.cci.IndexedRecord record) {
		com.wsbook.casestudy.ejb.ConcreteProjectEJB_8ce694f3 concreteBean=(com.wsbook.casestudy.ejb.ConcreteProjectEJB_8ce694f3)cb;
		record.set(0,concreteBean.getName());
		record.set(1,concreteBean.getProjNumber());
	}
	/**
	 * ejbStore
	 */
	public void ejbStore(com.ibm.ws.ejbpersistence.beanextensions.ConcreteBean cb, javax.resource.cci.IndexedRecord record) {
		com.wsbook.casestudy.ejb.ConcreteProjectEJB_8ce694f3 concreteBean=(com.wsbook.casestudy.ejb.ConcreteProjectEJB_8ce694f3)cb;
		record.set(0,concreteBean.getName());
		record.set(1,concreteBean.getProjNumber());
	}
	/**
	 * ejbRemove
	 */
	public void ejbRemove(com.ibm.ws.ejbpersistence.beanextensions.ConcreteBean cb, javax.resource.cci.IndexedRecord record) {
		com.wsbook.casestudy.ejb.ConcreteProjectEJB_8ce694f3 concreteBean=(com.wsbook.casestudy.ejb.ConcreteProjectEJB_8ce694f3)cb;
		record.set(1,concreteBean.getProjNumber());
	}
	/**
	 * ejbFindByName
	 */
	public void ejbFindByName(java.lang.String name, javax.resource.cci.IndexedRecord record) {
		record.set(0,name);
	}
	/**
	 * ejbFindByPrimaryKey
	 */
	public void ejbFindByPrimaryKey(Object pkeyObject, javax.resource.cci.IndexedRecord record) {
		java.lang.String pkey=(java.lang.String)pkeyObject;
		record.set(0,pkey);
	}
	/**
	 * findProjectByTimesheetentryKey_Local
	 */
	public void findProjectByTimesheetentryKey_Local(com.wsbook.casestudy.ejb.TimeSheetEntryEJBKey fkey, javax.resource.cci.IndexedRecord record) {
		record.set(0,new Integer(fkey.entryId));
	}
}

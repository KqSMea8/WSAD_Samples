package com.wsbook.casestudy.ejb.websphere_deploy.DB2UDBNT_V8_1;

/**
 * DepartmentEJBBeanInjectorImpl_6d23b983
 */
public class DepartmentEJBBeanInjectorImpl_6d23b983 implements com.wsbook.casestudy.ejb.websphere_deploy.DepartmentEJBBeanInjector_6d23b983 {
	/**
	 * ejbCreate
	 */
	public void ejbCreate(com.ibm.ws.ejbpersistence.beanextensions.ConcreteBean cb, javax.resource.cci.IndexedRecord record) {
		com.wsbook.casestudy.ejb.ConcreteDepartmentEJB_6d23b983 concreteBean=(com.wsbook.casestudy.ejb.ConcreteDepartmentEJB_6d23b983)cb;
		record.set(0,concreteBean.getName());
		record.set(1,new Integer(concreteBean.getDeptNumber()));
	}
	/**
	 * ejbStore
	 */
	public void ejbStore(com.ibm.ws.ejbpersistence.beanextensions.ConcreteBean cb, javax.resource.cci.IndexedRecord record) {
		com.wsbook.casestudy.ejb.ConcreteDepartmentEJB_6d23b983 concreteBean=(com.wsbook.casestudy.ejb.ConcreteDepartmentEJB_6d23b983)cb;
		record.set(0,concreteBean.getName());
		record.set(1,new Integer(concreteBean.getDeptNumber()));
	}
	/**
	 * ejbRemove
	 */
	public void ejbRemove(com.ibm.ws.ejbpersistence.beanextensions.ConcreteBean cb, javax.resource.cci.IndexedRecord record) {
		com.wsbook.casestudy.ejb.ConcreteDepartmentEJB_6d23b983 concreteBean=(com.wsbook.casestudy.ejb.ConcreteDepartmentEJB_6d23b983)cb;
		record.set(1,new Integer(concreteBean.getDeptNumber()));
	}
	/**
	 * ejbFindByPrimaryKey
	 */
	public void ejbFindByPrimaryKey(Object pkeyObject, javax.resource.cci.IndexedRecord record) {
		com.wsbook.casestudy.ejb.DepartmentEJBKey pkey=(com.wsbook.casestudy.ejb.DepartmentEJBKey)pkeyObject;
		record.set(0,new Integer(pkey.deptNumber));
	}
}

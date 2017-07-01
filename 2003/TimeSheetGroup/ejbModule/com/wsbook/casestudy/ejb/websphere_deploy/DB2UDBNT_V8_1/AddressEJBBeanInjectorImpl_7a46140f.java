package com.wsbook.casestudy.ejb.websphere_deploy.DB2UDBNT_V8_1;

/**
 * AddressEJBBeanInjectorImpl_7a46140f
 */
public class AddressEJBBeanInjectorImpl_7a46140f implements com.wsbook.casestudy.ejb.websphere_deploy.AddressEJBBeanInjector_7a46140f {
	/**
	 * ejbCreate
	 */
	public void ejbCreate(com.ibm.ws.ejbpersistence.beanextensions.ConcreteBean cb, javax.resource.cci.IndexedRecord record) {
		com.wsbook.casestudy.ejb.ConcreteAddressEJB_7a46140f concreteBean=(com.wsbook.casestudy.ejb.ConcreteAddressEJB_7a46140f)cb;
		record.set(0,concreteBean.getCity());
		record.set(1,concreteBean.getState());
		record.set(2,concreteBean.getStreetAddress());
		record.set(3,concreteBean.getZipCode());
		record.set(4,new Integer(concreteBean.getAddressKey()));
	}
	/**
	 * ejbStore
	 */
	public void ejbStore(com.ibm.ws.ejbpersistence.beanextensions.ConcreteBean cb, javax.resource.cci.IndexedRecord record) {
		com.wsbook.casestudy.ejb.ConcreteAddressEJB_7a46140f concreteBean=(com.wsbook.casestudy.ejb.ConcreteAddressEJB_7a46140f)cb;
		record.set(0,concreteBean.getCity());
		record.set(1,concreteBean.getState());
		record.set(2,concreteBean.getStreetAddress());
		record.set(3,concreteBean.getZipCode());
		record.set(4,new Integer(concreteBean.getAddressKey()));
	}
	/**
	 * ejbRemove
	 */
	public void ejbRemove(com.ibm.ws.ejbpersistence.beanextensions.ConcreteBean cb, javax.resource.cci.IndexedRecord record) {
		com.wsbook.casestudy.ejb.ConcreteAddressEJB_7a46140f concreteBean=(com.wsbook.casestudy.ejb.ConcreteAddressEJB_7a46140f)cb;
		record.set(4,new Integer(concreteBean.getAddressKey()));
	}
	/**
	 * ejbFindByPrimaryKey
	 */
	public void ejbFindByPrimaryKey(Object pkeyObject, javax.resource.cci.IndexedRecord record) {
		com.wsbook.casestudy.ejb.AddressEJBKey pkey=(com.wsbook.casestudy.ejb.AddressEJBKey)pkeyObject;
		record.set(0,new Integer(pkey.addressKey));
	}
	/**
	 * findHomeAddressByEmployeeKey_Local
	 */
	public void findHomeAddressByEmployeeKey_Local(java.lang.String fkey, javax.resource.cci.IndexedRecord record) {
		record.set(0,fkey);
	}
}

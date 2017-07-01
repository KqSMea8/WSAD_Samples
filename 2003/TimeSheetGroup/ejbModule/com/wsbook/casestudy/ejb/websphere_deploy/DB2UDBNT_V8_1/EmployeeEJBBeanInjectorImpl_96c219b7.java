package com.wsbook.casestudy.ejb.websphere_deploy.DB2UDBNT_V8_1;

/**
 * EmployeeEJBBeanInjectorImpl_96c219b7
 */
public class EmployeeEJBBeanInjectorImpl_96c219b7 implements com.wsbook.casestudy.ejb.websphere_deploy.EmployeeEJBBeanInjector_96c219b7 {
	/**
	 * ejbCreate
	 */
	public void ejbCreate(com.ibm.ws.ejbpersistence.beanextensions.ConcreteBean cb, javax.resource.cci.IndexedRecord record) {
		com.wsbook.casestudy.ejb.AddressEJBKey tempAddressEJBKey;

		com.wsbook.casestudy.ejb.ConcreteEmployeeEJB_96c219b7 concreteBean=(com.wsbook.casestudy.ejb.ConcreteEmployeeEJB_96c219b7)cb;
		Object[] tempComposerArray_office;
		tempComposerArray_office = com.wsbook.casestudy.ejb.OfficeLocationComposer.singleton().dataFrom(concreteBean.getOffice());
		java.lang.String tempComposerArray_office_0;
		tempComposerArray_office_0 = (java.lang.String) tempComposerArray_office[0];
		java.lang.String tempComposerArray_office_1;
		tempComposerArray_office_1 = (java.lang.String) tempComposerArray_office[1];
		java.lang.String tempComposerArray_office_2;
		tempComposerArray_office_2 = (java.lang.String) tempComposerArray_office[2];
		java.lang.String tempComposerArray_office_3;
		tempComposerArray_office_3 = (java.lang.String) tempComposerArray_office[3];
		record.set(0,concreteBean.getEmpId());
		record.set(1,concreteBean.getName());
		record.set(2,tempComposerArray_office_0);
		record.set(3,tempComposerArray_office_1);
		record.set(4,tempComposerArray_office_2);
		record.set(5,tempComposerArray_office_3);
		tempAddressEJBKey= concreteBean.getHomeAddressKey();
		if(tempAddressEJBKey==null)
			record.set(6,null);
		else
			record.set(6,new Integer(tempAddressEJBKey.addressKey));
	}
	/**
	 * ejbStore
	 */
	public void ejbStore(com.ibm.ws.ejbpersistence.beanextensions.ConcreteBean cb, javax.resource.cci.IndexedRecord record) {
		com.wsbook.casestudy.ejb.AddressEJBKey tempAddressEJBKey;

		com.wsbook.casestudy.ejb.ConcreteEmployeeEJB_96c219b7 concreteBean=(com.wsbook.casestudy.ejb.ConcreteEmployeeEJB_96c219b7)cb;
		Object[] tempComposerArray_office;
		tempComposerArray_office = com.wsbook.casestudy.ejb.OfficeLocationComposer.singleton().dataFrom(concreteBean.getOffice());
		java.lang.String tempComposerArray_office_0;
		tempComposerArray_office_0 = (java.lang.String) tempComposerArray_office[0];
		java.lang.String tempComposerArray_office_1;
		tempComposerArray_office_1 = (java.lang.String) tempComposerArray_office[1];
		java.lang.String tempComposerArray_office_2;
		tempComposerArray_office_2 = (java.lang.String) tempComposerArray_office[2];
		java.lang.String tempComposerArray_office_3;
		tempComposerArray_office_3 = (java.lang.String) tempComposerArray_office[3];
		record.set(0,concreteBean.getEmpId());
		record.set(1,concreteBean.getName());
		record.set(2,tempComposerArray_office_0);
		record.set(3,tempComposerArray_office_1);
		record.set(4,tempComposerArray_office_2);
		record.set(5,tempComposerArray_office_3);
		tempAddressEJBKey= concreteBean.getHomeAddressKey();
		if(tempAddressEJBKey==null)
			record.set(6,null);
		else
			record.set(6,new Integer(tempAddressEJBKey.addressKey));
	}
	/**
	 * ejbRemove
	 */
	public void ejbRemove(com.ibm.ws.ejbpersistence.beanextensions.ConcreteBean cb, javax.resource.cci.IndexedRecord record) {
		com.wsbook.casestudy.ejb.ConcreteEmployeeEJB_96c219b7 concreteBean=(com.wsbook.casestudy.ejb.ConcreteEmployeeEJB_96c219b7)cb;
		Object[] tempComposerArray_office;
		tempComposerArray_office = com.wsbook.casestudy.ejb.OfficeLocationComposer.singleton().dataFrom(concreteBean.getOffice());
		java.lang.String tempComposerArray_office_0;
		tempComposerArray_office_0 = (java.lang.String) tempComposerArray_office[0];
		java.lang.String tempComposerArray_office_1;
		tempComposerArray_office_1 = (java.lang.String) tempComposerArray_office[1];
		java.lang.String tempComposerArray_office_2;
		tempComposerArray_office_2 = (java.lang.String) tempComposerArray_office[2];
		java.lang.String tempComposerArray_office_3;
		tempComposerArray_office_3 = (java.lang.String) tempComposerArray_office[3];
		record.set(0,concreteBean.getEmpId());
	}
	/**
	 * ejbFindByPrimaryKey
	 */
	public void ejbFindByPrimaryKey(Object pkeyObject, javax.resource.cci.IndexedRecord record) {
		java.lang.String pkey=(java.lang.String)pkeyObject;
		record.set(0,pkey);
	}
	/**
	 * findEmployeeByHomeAddressKey_Local
	 */
	public void findEmployeeByHomeAddressKey_Local(com.wsbook.casestudy.ejb.AddressEJBKey fkey, javax.resource.cci.IndexedRecord record) {
		record.set(0,new Integer(fkey.addressKey));
	}
	/**
	 * findSubmitterByTimesheetsKey_Local
	 */
	public void findSubmitterByTimesheetsKey_Local(com.wsbook.casestudy.ejb.TimeSheetEJBKey fkey, javax.resource.cci.IndexedRecord record) {
		record.set(0,new Integer(fkey.timeSheetId));
	}
	/**
	 * findApproverByApprovedTimesheetsKey_Local
	 */
	public void findApproverByApprovedTimesheetsKey_Local(com.wsbook.casestudy.ejb.TimeSheetEJBKey fkey, javax.resource.cci.IndexedRecord record) {
		record.set(0,new Integer(fkey.timeSheetId));
	}
}

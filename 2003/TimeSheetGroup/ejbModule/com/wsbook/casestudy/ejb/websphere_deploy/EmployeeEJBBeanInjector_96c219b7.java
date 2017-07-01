package com.wsbook.casestudy.ejb.websphere_deploy;

/**
 * Injector interface for Enterprise Bean: EmployeeEJB
 */
public interface EmployeeEJBBeanInjector_96c219b7 extends com.ibm.ws.ejbpersistence.beanextensions.EJBInjector {
	/**
	 * findEmployeeByHomeAddressKey_Local
	 */
	public void findEmployeeByHomeAddressKey_Local(com.wsbook.casestudy.ejb.AddressEJBKey key, javax.resource.cci.IndexedRecord record);
	/**
	 * findSubmitterByTimesheetsKey_Local
	 */
	public void findSubmitterByTimesheetsKey_Local(com.wsbook.casestudy.ejb.TimeSheetEJBKey key, javax.resource.cci.IndexedRecord record);
	/**
	 * findApproverByApprovedTimesheetsKey_Local
	 */
	public void findApproverByApprovedTimesheetsKey_Local(com.wsbook.casestudy.ejb.TimeSheetEJBKey key, javax.resource.cci.IndexedRecord record);
}

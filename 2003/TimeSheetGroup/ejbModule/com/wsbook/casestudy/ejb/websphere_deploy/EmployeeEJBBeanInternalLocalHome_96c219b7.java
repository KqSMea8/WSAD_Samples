package com.wsbook.casestudy.ejb.websphere_deploy;

/**
 * Internal Local Home interface for Enterprise Bean: EmployeeEJB
 */
public interface EmployeeEJBBeanInternalLocalHome_96c219b7 {
	/**
	 * findEmployeeByHomeAddressKey_Local
	 */
	public com.wsbook.casestudy.ejb.EmployeeEJB findEmployeeByHomeAddressKey_Local(com.wsbook.casestudy.ejb.AddressEJBKey key) throws javax.ejb.FinderException;
	/**
	 * findSubmitterByTimesheetsKey_Local
	 */
	public com.wsbook.casestudy.ejb.EmployeeEJB findSubmitterByTimesheetsKey_Local(com.wsbook.casestudy.ejb.TimeSheetEJBKey key) throws javax.ejb.FinderException;
	/**
	 * findApproverByApprovedTimesheetsKey_Local
	 */
	public com.wsbook.casestudy.ejb.EmployeeEJB findApproverByApprovedTimesheetsKey_Local(com.wsbook.casestudy.ejb.TimeSheetEJBKey key) throws javax.ejb.FinderException;
	/**
	 * findByPrimaryKeyForCMR
	 */
	public com.wsbook.casestudy.ejb.EmployeeEJB findByPrimaryKeyForCMR(java.lang.String key) throws javax.ejb.FinderException;
}

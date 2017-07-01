package com.wsbook.casestudy.ejb.websphere_deploy;

/**
 * Cache Entry interface for Enterprise Bean: EmployeeEJB
 */
public interface EmployeeEJBBeanCacheEntry_96c219b7 extends java.io.Serializable {
	/**
	 * getEmpId
	 */
	public java.lang.String getEmpId();
	/**
	 * setEmpId
	 */
	public void setEmpId(java.lang.String newEmpId);
	/**
	 * getName
	 */
	public java.lang.String getName();
	/**
	 * setName
	 */
	public void setName(java.lang.String newName);
	/**
	 * getOffice
	 */
	public com.wsbook.casestudy.ejb.OfficeLocation getOffice();
	/**
	 * setOffice
	 */
	public void setOffice(com.wsbook.casestudy.ejb.OfficeLocation newOffice);
	/**
	 * getHomeAddress_addressKey
	 */
	public int getHomeAddress_addressKey();
	/**
	 * setHomeAddress_addressKey
	 */
	public void setHomeAddress_addressKey(int newHomeAddress_addressKey);
	/**
	 * getHomeAddressKey
	 */
	public com.wsbook.casestudy.ejb.AddressEJBKey getHomeAddressKey();
}

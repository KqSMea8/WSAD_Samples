package com.wsbook.casestudy.ejb;
/**
 * Local interface for Enterprise Bean: AddressEJB
 */
public interface AddressEJB extends javax.ejb.EJBLocalObject {
	/**
	 * getCity
	 */
	public java.lang.String getCity();
	/**
	 * setCity
	 */
	public void setCity(java.lang.String newCity);
	/**
	 * getState
	 */
	public java.lang.String getState();
	/**
	 * setState
	 */
	public void setState(java.lang.String newState);
	/**
	 * getStreetAddress
	 */
	public java.lang.String getStreetAddress();
	/**
	 * setStreetAddress
	 */
	public void setStreetAddress(java.lang.String newStreetAddress);
	/**
	 * getZipCode
	 */
	public java.lang.String getZipCode();
	/**
	 * setZipCode
	 */
	public void setZipCode(java.lang.String newZipCode);
	/**
	 * This method was generated for supporting the relationship role named employee.
	 * It will be deleted/edited when the relationship is deleted/edited.
	 */
	public com.wsbook.casestudy.ejb.EmployeeEJB getEmployee();
	/**
	 * This method was generated for supporting the relationship role named employee.
	 * It will be deleted/edited when the relationship is deleted/edited.
	 */
	public void setEmployee(
		com.wsbook.casestudy.ejb.EmployeeEJB anEmployee);
}

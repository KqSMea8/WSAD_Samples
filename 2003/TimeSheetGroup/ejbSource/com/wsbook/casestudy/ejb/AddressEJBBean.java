package com.wsbook.casestudy.ejb;
/**
 * Bean implementation class for Enterprise Bean: AddressEJB
 */
public abstract class AddressEJBBean implements javax.ejb.EntityBean {

	private javax.ejb.EntityContext myEntityCtx;
	/**
	 * getEntityContext
	 */
	public javax.ejb.EntityContext getEntityContext() {
		return myEntityCtx;
	}
	/**
	 * setEntityContext
	 */
	public void setEntityContext(javax.ejb.EntityContext ctx) {
		myEntityCtx = ctx;
	}
	/**
	 * unsetEntityContext
	 */
	public void unsetEntityContext() {
		myEntityCtx = null;
	}
	/**
	 * ejbActivate
	 */
	public void ejbActivate() {
	}
	/**
	 * ejbCreate
	 */
	public com.wsbook.casestudy.ejb.AddressEJBKey ejbCreate(int addressKey)
		throws javax.ejb.CreateException {
		setAddressKey(addressKey);
		return null;
	}
	/**
	 * ejbLoad
	 */
	public void ejbLoad() {
	}
	/**
	 * ejbPassivate
	 */
	public void ejbPassivate() {
	}
	/**
	 * ejbPostCreate
	 */
	public void ejbPostCreate(int addressKey)
		throws javax.ejb.CreateException {
	}
	/**
	 * ejbRemove
	 */
	public void ejbRemove() throws javax.ejb.RemoveException {
	}
	/**
	 * ejbStore
	 */
	public void ejbStore() {
	}
	/**
	 * Get accessor for persistent attribute: city
	 */
	public abstract java.lang.String getCity();
	/**
	 * Set accessor for persistent attribute: city
	 */
	public abstract void setCity(java.lang.String newCity);
	/**
	 * Get accessor for persistent attribute: state
	 */
	public abstract java.lang.String getState();
	/**
	 * Set accessor for persistent attribute: state
	 */
	public abstract void setState(java.lang.String newState);
	/**
	 * Get accessor for persistent attribute: streetAddress
	 */
	public abstract java.lang.String getStreetAddress();
	/**
	 * Set accessor for persistent attribute: streetAddress
	 */
	public abstract void setStreetAddress(java.lang.String newStreetAddress);
	/**
	 * Get accessor for persistent attribute: zipCode
	 */
	public abstract java.lang.String getZipCode();
	/**
	 * Set accessor for persistent attribute: zipCode
	 */
	public abstract void setZipCode(java.lang.String newZipCode);
	/**
	 * Get accessor for persistent attribute: addressKey
	 */
	public abstract int getAddressKey();
	/**
	 * Set accessor for persistent attribute: addressKey
	 */
	public abstract void setAddressKey(int newAddressKey);
	/**
	 * This method was generated for supporting the relationship role named employee.
	 * It will be deleted/edited when the relationship is deleted/edited.
	 */
	public abstract com.wsbook.casestudy.ejb.EmployeeEJB getEmployee();
	/**
	 * This method was generated for supporting the relationship role named employee.
	 * It will be deleted/edited when the relationship is deleted/edited.
	 */
	public abstract void setEmployee(
		com.wsbook.casestudy.ejb.EmployeeEJB anEmployee);
}

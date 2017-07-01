package com.wsbook.casestudy.domain;

/**
 * This is an Employee domain object.  It is obtained via a Factory
 * from information from a CMP EJB.
 *
 * When EJB's are disabled, a sample set of these are used.
 *
 */
public class Employee extends TsObject {
	private String fieldId = new String();
	private String fieldName = new String();
	private Address address;
	private int     deptId;
	/**
	 * Employee constructor.
	 */
	public Employee() {
		super();
	}
	
	public Employee(String id) {
		fieldId = id;
	}
	/**
	 * Return true if anObject is equivalent to this
	 */
	public boolean equals(Object anObject) {
		if (anObject == null) {
			return false;
		}
		if (!(anObject instanceof Employee)) {
			return false;
		}
		Employee anEmployee = (Employee) anObject;
		return anEmployee.getId().equals(getId());
	}
	/**
	 * Gets the id property (java.lang.String) value.
	 * @return The id property value.
	 * @see #setId
	 */
	public String getId() {
		return fieldId;
	}
	/**
	 * Gets the name property (java.lang.String) value.
	 * @return The name property value.
	 * @see #setName
	 */
	public String getName() {
		return fieldName;
	}
	/**
	 * Sets the id property (java.lang.String) value.
	 * @param id The new value for the property.
	 * @see #getId
	 */
	public void setId(String id) {
		fieldId = id;
	}
	/**
	 * Sets the name property (java.lang.String) value.
	 * @param name The new value for the property.
	 * @see #getName
	 */
	public void setName(String name) {
		fieldName = name;
	}
	/**
	 * Gets the address
	 * @return Returns a Address
	 */
	public Address getAddress() {
		return address;
	}
	/**
	 * Sets the address
	 * @param address The address to set
	 */
	public void setAddress(Address address) {
		this.address = address;
	}

}
package com.wsbook.casestudy.domain;

/**
 * This class is a Department Domain object
 * It is used as a "data bean" or value object returned from
 * a Factory using data obtained from a CMP.
 *
 * When EJB's are disabled, a "sample" set of these is used.
 */
public class Department extends TsObject {
	private int fieldNumber;
	private String fieldName = new String();
	/**
	 * Department constructor.
	 */
	public Department() {
		super();
	}
	/**
	 * This method was created in VisualAge.
	 */
	public boolean equals(Object anObject) {
		if (anObject == null) {
			return false;
		}
		if (!(anObject instanceof Department)) {
			return false;
		}
		Department aDepartment = (Department) anObject;
		return aDepartment.getNumber() == getNumber();
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
	 * Sets the name property (java.lang.String) value.
	 * @param name The new value for the property.
	 * @see #getName
	 */
	public void setName(String name) {
		fieldName = name;
	}
	/**
	 * Gets the number
	 * @return Returns a int
	 */
	public int getNumber() {
		return fieldNumber;
	}
	/**
	 * Sets the number
	 * @param fieldNumber The number to set
	 */
	public void setNumber(int fieldNumber) {
		this.fieldNumber = fieldNumber;
	}

}
package com.wsbook.casestudy.domain;

/**
 * This class represents a Project domain object.  A Project represents a particular
 * "project" that time is billed against. Projects are obtained
 * via a Factory from information held in an EJB.
 *
 * When EJB's are disabled a "default" set of these are used.
 *
 */
public class Project extends TsObject {
	private String fieldName = new String();
	private String fieldNumber = new String();

	/**
	 * Project constructor.
	 */
	public Project() {
		super();
	}
	
	public Project(String id) {
		fieldNumber = id;
	}
	
	public Project(String name, String id) {
		fieldName = name;
		fieldNumber = id;
	}
	
	public boolean equals(Object anObject) {
		if (anObject == null) {
			return false;
		}
		if (!(anObject instanceof Project)) {
			return false;
		}
		Project aProject = (Project) anObject;
		return aProject.getNumber().equals(getNumber());
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
	 * Gets the number property (java.lang.String) value.
	 * @return The number property value.
	 * @see #setNumber
	 */
	public String getNumber() {
		return fieldNumber;
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
	 * Sets the number property (java.lang.String) value.
	 * @param number The new value for the property.
	 * @see #getNumber
	 */
	public void setNumber(String number) {
		fieldNumber = number;
	}
}
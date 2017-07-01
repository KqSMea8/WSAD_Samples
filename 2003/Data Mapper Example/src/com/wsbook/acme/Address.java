package com.wsbook.acme;

import java.io.Serializable;

import com.wsbook.mapping.DomainObject;
import com.wsbook.mapping.MappingException;

/**
 * @author jamsden
 *
 * To change this generated comment edit the template variable "typecomment":
 * Window>Preferences>Java>Templates.
 * To enable and disable the creation of type comments go to
 * Window>Preferences>Java>Code Generation.
 */
public class Address implements Serializable {
	private String street;
	private String city;
	private String state;
	private String zip;
	private Employee employee;
	
	private Address() {}
	
	public Address(Employee emp) {
		employee = emp;
		try {
			emp.setAddress(this);
		} catch (MappingException e) {
		}
	}
	
	/**
	 * Gets the employee's street address
	 * @return String
	 */
	public String getStreet() {
		return street;
	}

	/**
	 * Gets the employee's city
	 * @return the employe's city
	 */
	public String getCity() {
		return city;
	}

	/**
	 * Return the state
	 * @return the employee's state
	 */
	public String getState() {
		return state;
	}

	/**
	 * Return the zip code
	 * @return the employee's zip code
	 */
	public String getZip() {
		return zip;
	}

	/**
	 * Set the street address
	 * @param value the new street address
	 */
	public void setStreet(String value) throws MappingException {
		street = value;
		employee.markUpdated();
	}

	/**
	 * Set the city
	 * @param value the new city
	 */
	public void setCity(String value) throws MappingException {
		city = value;
		employee.markUpdated();
	}

	/**
	 * Set the State
	 * @param value the new state
	 */
	public void setState(String value) {
		state = value;
	}

	/**
	 * Set the zip code
	 * @param value the new zip code
	 */
	public void setZip(String value) {
		zip = value;
	}
	
}

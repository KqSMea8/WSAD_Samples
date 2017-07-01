package com.wsbook.acme;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.wsbook.acme.mappers.DepartmentMapper;
import com.wsbook.mapping.ApplicationProperties;
import com.wsbook.mapping.DomainObject;
import com.wsbook.mapping.DuplicateKeyException;
import com.wsbook.mapping.MapperRegistry;
import com.wsbook.mapping.MappingException;
import com.wsbook.mapping.NoSuchObjectException;

/**
 * This is an Employee domain object. This implementation follows
 * Martin Fowler's ActiveRecord pattern where the domain object
 * is responsible for managing its own persistence.
 */
public class Employee extends DomainObject implements Serializable {
	private String id = "";
	private String name = "";
	private int age = 0;
	private Address address = null;
	private Department department = null;

	/**
	 * Employee constructor.
	 */
	private Employee() {
	}

	/** Domain objects must be created with a key
	 */
	public Employee(String id) throws MappingException {
		this.id = id;
		markCreated();
	}
	
	/** Returns the immutable identifier for an Employee.
	 */
	public Object getID() {
		return getId();
	}
	
	/**
	 * Gets the employee id, an attribute that
	 * uniquely identifies an employee.
	 * @return The id property value.
	 * @see #setId
	 */
	public String getId() {
		return id;
	}

	/**
	 * Gets the employee name.
	 * @return The name property value.
	 * @see #setName
	 */
	public String getName() {
		return name;
	}

	/**
	 * Gets the employee's age
	 * @return the employee's age
	 * @see #setAge
	 */
	public int getAge() {
		return age;
	}

	/**
	 * Sets the employee's name
	 * @param value the new name
	 * @see #getName
	 */
	public void setName(String value) throws MappingException  {
		name = value;
		markUpdated();
	}

	/**
	 * Sets employee's age
	 * @param value the employee's age
	 * @see #getAge
	 */
	public void setAge(int value) throws MappingException  {
		age = value;
		markUpdated();
	}

	/**
	 * Returns the address.
	 * @return Address
	 */
	public Address getAddress() {
		return address;
	}

	/**
	 * Returns the department.
	 * @return Department
	 */
	public Department getDepartment() {
		if (department != null && department.isGhost()) {
			try {
				department = (Department)MapperRegistry.getMapper(Department.class).findByPrimaryKey(department.getID());
			} catch (NoSuchObjectException e) {
			}
		}
		return department;
	}

	/**
	 * Sets the address.
	 * @param address The address to set
	 */
	public void setAddress(Address address) throws MappingException  {
		this.address = address;
		markUpdated();
	}

	/**
	 * Sets the department.
	 * @param department The department to set
	 */
	public void setDepartment(Department department) throws MappingException  {
		if (department != null) department.getEmployees().remove(this);
		this.department = department;
		if (department != null) department.getEmployees().add(this);
		markUpdated();
	}

}
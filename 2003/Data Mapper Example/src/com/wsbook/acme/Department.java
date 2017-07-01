package com.wsbook.acme;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

import com.wsbook.acme.mappers.*;
import com.wsbook.mapping.DomainObject;
import com.wsbook.mapping.MapperRegistry;
import com.wsbook.mapping.MappingException;

/**
 * @author jamsden
 *
 * To change this generated comment edit the template variable "typecomment":
 * Window>Preferences>Java>Templates.
 * To enable and disable the creation of type comments go to
 * Window>Preferences>Java>Code Generation.
 */
public class Department extends DomainObject implements Serializable {
	private int id;
	private String name;
	private String description;
	Collection employees = null;
		
	/** Create a department with no id. Useful as a proxy for
	 * lazy load as all departments must have an id.
	 */
	public Department() {
	}

	public Department(int id) throws MappingException {
		this.id = id;
		markCreated();
	}
	
	public Object getID() {
		if (id == 0) return null;
		return new Integer(getId());
	}
	
	/**
	 * Returns the id.
	 * @return int
	 */
	public int getId() {
		return id;
	}

	/**
	 * Returns the name.
	 * @return String
	 */
	public String getName() {
		return name;
	}

	/**
	 * Returns the description.
	 * @return String
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * Sets the name.
	 * @param name The name to set
	 */
	public void setName(String name) throws MappingException {
		this.name = name;
		markUpdated();
	}

	/**
	 * Sets the description.
	 * @param description The description to set
	 */
	public void setDescription(String description) throws MappingException {
		this.description = description;
		markUpdated();
	}
	
	/** Get the employees that belong to this department
	 */
	public Collection getEmployees() {
		// lazy load the employees in this department
		if (employees == null) {
			employees = new ArrayList();
			EmployeeMapper employeeMapper = (EmployeeMapper)MapperRegistry.getMapper(Employee.class);
			employees.addAll(employeeMapper.findByDepartment(this));
		}
		return employees;
	}
	
	public void addEmployee(Employee employee) throws MappingException {
		employee.setDepartment(this);
	}
	
	public void removeEmployee(Employee employee) throws MappingException {
		employee.setDepartment(null);
	}

}

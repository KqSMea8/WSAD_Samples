package com.wsbook.casestudy.domain;

import com.wsbook.casestudy.domain.*;
/**
 * This type filters TimeSheet objects by Employee.
 */
public class EmployeeFilter extends Filter {
	Employee employee = null;
	/**
	 * EmployeeFilter constructor.
	 */
	public EmployeeFilter() {
		super();
	}
	/**
	 * EmployeeFilter constructor.
	 */
	public EmployeeFilter(Employee anEmployee) {
		super();
		employee = anEmployee;
	}
	/**
	 * Return true if supplied Timesheet employee matches 
	 * filter employee.
	 */
	public boolean match(TimeSheet aTimeSheet) {
		if (employee.getId().equalsIgnoreCase(aTimeSheet.getEmployee().getId())) {
			return true;
		}
		return false;
	}
}
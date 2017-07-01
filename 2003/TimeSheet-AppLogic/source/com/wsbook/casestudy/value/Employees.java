package com.wsbook.casestudy.value;

import java.io.Serializable;
import java.util.ArrayList;

import com.wsbook.casestudy.domain.Employee;


public class Employees implements Serializable {
	private ArrayList employees = null;

	public Employees() {
	}

	public Employees(ArrayList employees) {
		this.employees = employees;
	}

	public Employee[] getEmployee() {
		if (employees == null) return null;
		int numToCopy = employees.size();
		Employee[] emps = new Employee[numToCopy];
		for (int i = 0; i < numToCopy; i++) {
			emps[i] = (Employee) employees.get(i);
		}
		return emps;
	}

	public Employee getEmployee(int index) {
		if (employees == null) return null;
		return (Employee) employees.get(index);
	}

}
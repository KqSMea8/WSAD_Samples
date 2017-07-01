package com.wsbook.casestudy.mapping;

import com.wsbook.casestudy.domain.Employee;
import com.wsbook.casestudy.exception.NoSuchEmployeeException;



public interface EmployeeMapper extends Mapper {

	public Employee findById(String empId) throws NoSuchEmployeeException;

}


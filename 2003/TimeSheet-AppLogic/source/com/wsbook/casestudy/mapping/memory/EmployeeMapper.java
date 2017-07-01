package com.wsbook.casestudy.mapping.memory;

import java.util.ArrayList;
import java.util.ListIterator;

import com.wsbook.casestudy.domain.Employee;
import com.wsbook.casestudy.domain.TsObject;
import com.wsbook.casestudy.exception.NoSuchEmployeeException;
/**
 * This is the default, in-memory Employee mapper
 * Creation date: (2/3/00 5:25:18 PM)
 * @author: Administrator
 */
public class EmployeeMapper
	extends ObjectMapper
	implements com.wsbook.casestudy.mapping.EmployeeMapper {
	protected static ArrayList cache = null;
	/**
	 * DepartmentMapper constructor.
	 */
	public EmployeeMapper() {
		super();
	}

	protected ArrayList getCache() {
		if (cache == null) {
			cache = initialLoad();
		}
		return cache;
	}
	/**
	 * Create and return a "default" ArrayList of sample Employee Objects.
	 * Creation date: (2/7/00 7:06:58 PM)
	 */
	ArrayList initialLoad() {
		ArrayList v = new ArrayList();
		Employee e = new Employee();
		e.setName("John Doe");
		e.setId("A100");
		v.add(e);
		e = new Employee();
		e.setId("B200");
		e.setName("Jane Doe");
		v.add(e);
		e = new Employee();
		e.setId("C300");
		e.setName("Clark Griswold");
		v.add(e);
		return v;
	}

	public Employee findById(String empId) throws NoSuchEmployeeException {
		ArrayList cache = getCache();
		ListIterator iter = cache.listIterator();
		while (iter.hasNext()) {
			Employee currentEmployee = (Employee) iter.next();
			if (currentEmployee.getId().equals(empId))
				return currentEmployee;
		}
		throw new NoSuchEmployeeException("No matching Employee Found");
	}

	public TsObject findByPrimaryKey(TsObject empKey) throws NoSuchEmployeeException {
		Employee emp = (Employee) empKey;
		return findById(emp.getId());
	}

	public void clearCache() {
		cache = new ArrayList();
	}
}
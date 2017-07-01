package com.wsbook.acme.management;

import java.rmi.RemoteException;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.wsbook.acme.Address;
import com.wsbook.acme.Employee;
import com.wsbook.acme.mappers.EmployeeMapper;
import com.wsbook.mapping.DuplicateKeyException;
import com.wsbook.mapping.MapperRegistry;
import com.wsbook.mapping.MappingException;
import com.wsbook.mapping.UnitOfWork;

/**
 * Bean implementation class for Enterprise Bean: EmployeeManagement
 */
public class EmployeeManagementBean implements javax.ejb.SessionBean {
	private javax.ejb.SessionContext mySessionCtx;
	/**
	 * getSessionContext
	 */
	public javax.ejb.SessionContext getSessionContext() {
		return mySessionCtx;
	}
	/**
	 * setSessionContext
	 */
	public void setSessionContext(javax.ejb.SessionContext ctx) {
		mySessionCtx = ctx;
	}
	/**
	 * ejbCreate
	 */
	public void ejbCreate() throws javax.ejb.CreateException {
	}
	/**
	 * ejbActivate
	 */
	public void ejbActivate() {
	}
	/**
	 * ejbPassivate
	 */
	public void ejbPassivate() {
	}
	/**
	 * ejbRemove
	 */
	public void ejbRemove() {
	}
	
	public Collection findAll() {
		Collection employees = null;
		try {
			UnitOfWork.begin(); {
			EmployeeMapper mapper = (EmployeeMapper)MapperRegistry.getMapper(Employee.class);
			employees = mapper.findAll();
			} UnitOfWork.getCurrent().commit();
		} catch (MappingException e) {
			e.printStackTrace();
		}
		return employees;
	}
	
	public Employee getEmployee(String id) {
		Employee employee = null;
		try {
			UnitOfWork.begin(); {
			EmployeeMapper mapper = (EmployeeMapper)MapperRegistry.getMapper(Employee.class);
			employee = (Employee)mapper.findByPrimaryKey(id);
			} UnitOfWork.getCurrent().commit();
		} catch (MappingException e) {
			e.printStackTrace();
		}
		return employee;
	}

	public void update(Map args) {
		try {
			UnitOfWork.begin(); {
				EmployeeMapper mapper = (EmployeeMapper)MapperRegistry.getMapper(Employee.class);
				Employee emp = (Employee)mapper.findByPrimaryKey(getParameter(args, "id"));
				emp.setName(getParameter(args, "name"));
				emp.setAge(Integer.parseInt(getParameter(args, "age")));
				emp.getAddress().setStreet(getParameter(args, "street"));
				emp.getAddress().setCity(getParameter(args, "city"));
				emp.getAddress().setState(getParameter(args, "state"));
				emp.getAddress().setZip(getParameter(args, "zip"));
			} UnitOfWork.getCurrent().commit();
		} catch (MappingException e) {
			e.printStackTrace();
		}
	}

	public void createNewEmployee(Map args) {
		try {
			UnitOfWork.begin(); {
				EmployeeMapper mapper = (EmployeeMapper)MapperRegistry.getMapper(Employee.class);
				Employee emp = new Employee(getParameter(args, "id"));
				emp.setName(getParameter(args, "name"));
				emp.setAge(Integer.parseInt(getParameter(args, "age")));
				new Address(emp);
				emp.getAddress().setStreet(getParameter(args, "street"));
				emp.getAddress().setCity(getParameter(args, "city"));
				emp.getAddress().setState(getParameter(args, "state"));
				emp.getAddress().setZip(getParameter(args, "zip"));
			} UnitOfWork.getCurrent().commit();
		} catch (MappingException e) {
			e.printStackTrace();
		}
	}

	public void deleteAnEmployee(String id) {
		try {
			UnitOfWork.begin(); {
				EmployeeMapper mapper = (EmployeeMapper)MapperRegistry.getMapper(Employee.class);
				Employee emp = (Employee)mapper.findByPrimaryKey(id);
				emp.delete();
			} UnitOfWork.getCurrent().commit();
		} catch (MappingException e) {
			e.printStackTrace();
		}
	}
	
	public String getParameter(Map map, String id) {
		String value = null;
		String[] values = (String[])map.get(id);
		if (values != null && values.length > 0) {
			value = values[0];
		}
		return value;
	}
}

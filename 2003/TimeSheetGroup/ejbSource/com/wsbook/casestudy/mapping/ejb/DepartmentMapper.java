package com.wsbook.casestudy.mapping.ejb;

import java.util.Collection;
import java.util.Enumeration;

import javax.ejb.EJBLocalObject;
import javax.ejb.EJBObject;
import javax.rmi.PortableRemoteObject;

import com.wsbook.casestudy.domain.Department;
import com.wsbook.casestudy.domain.TsObject;
import com.wsbook.casestudy.ejb.DepartmentEJB;
import com.wsbook.casestudy.ejb.DepartmentEJBHome;
import com.wsbook.casestudy.ejb.DepartmentEJBKey;
import com.wsbook.casestudy.exception.MappingException;
import com.wsbook.casestudy.system.AppService;
import com.wsbook.casestudy.system.TraceCapable;
/**
 * This is a factory for Department objects.  It obtains them from
 * Department EJB's.
 *
 * Creation date: (2/20/00 9:36:28 PM)
 * @author: Administrator
 */
public class DepartmentMapper extends DomainEJBMapper{
	DepartmentEJBHome departmentHome;
/**
 * EmployeeFactory constructor.
 */
public DepartmentMapper() {
	super();
	createInitialContext();
	createDepartmentHome();
}
/**
 * Create a DepartmentEJB from a Department domain object.
 * Creation date: (2/20/00 9:41:44 PM)
 */
public void insert(TsObject obj) throws MappingException {
	try {
		Department dept = (Department) obj;
		DepartmentEJB departmentEJB = departmentHome.create(dept.getNumber(), dept.getName());
	} catch (Exception e) {
		AppService.log(TraceCapable.ERROR_LEVEL,"Exception " + e + " caught in create()");
		throw new MappingException(e, ("Wrapped Exception " + e + " caught in insert()"));
	}
}
/**
 * This method retrieves an instance of DepartmentEJBHome from the JNDI initial context.
 * Creation date: (2/19/00 3:02:08 PM)
 */
protected void createDepartmentHome() {
	try {
		departmentHome = (DepartmentEJBHome) initContext.lookup("java:comp/env/ejb/DepartmentEJB");
	} catch (Exception e) { // Error getting the home interface
		AppService.log(TraceCapable.ERROR_LEVEL,"Exception " + e + " in createDepartmentHome()");
	}
}
/**
 * This method returns an Enumeration of all EJB's of type DepartmentEJB.
 * Creation date: (2/19/00 3:02:08 PM)
 */
protected Collection findAllEJBs() throws MappingException {
	try {
		return departmentHome.findAll();
	} catch (Exception e) {
		throw new MappingException(e, ("Wrapped exception : " + e));
	}
}
/**
 * Return all of the EJBObjects matching this domainObject
 * Creation date: (3/20/00 11:57:55 AM)
 * @return javax.ejb.EJBObject
 * @param domainObject java.lang.Object
 */
protected EJBLocalObject findEJBObjectMatching(TsObject domainObject) throws MappingException {
	EJBLocalObject department = null;
	try {
		int keyValue = ((Department)domainObject).getNumber();
		DepartmentEJBKey key = new DepartmentEJBKey(keyValue);
		department = departmentHome.findByPrimaryKey(key);
	} catch (Exception e) {
		AppService.log(TraceCapable.ERROR_LEVEL,"Exception " + e + " caught in DepartmentFactory.findEJBObjectMatching()");
		throw new MappingException(e, ("Wrapped Exception " + e + " caught in DepartmentFactory.findEJBObjectMatching()"));
	}
	return department;
}
/**
 * Map this EJBObject into a domain object (e.g. a Department)
 * Creation date: (2/20/00 9:41:44 PM)
 */
public TsObject map(EJBLocalObject input) throws MappingException {
	DepartmentEJB ejb;
	try {
		ejb = (DepartmentEJB) input;
	} catch (ClassCastException e) {
		throw new MappingException(e, "Attempt to map a non DepartmentEJB in DepartmentFactory");
	}
	Department dept = null;
	try {
		dept = new Department();
		dept.setNumber(((DepartmentEJBKey) ejb.getPrimaryKey()).deptNumber);
		dept.setName(ejb.getName());
	} catch (Exception e) {
		AppService.log(TraceCapable.ERROR_LEVEL,"Exception " + e + " caught in DepartmentFactory.map()");
		throw new MappingException(e, ("Wrapped Exception " + e + " caught in DepartmentFactory.map()"));
	}
	return dept;
}
/**
 * Update the EJB that maps to this Department domain object.
 * Creation date: (2/20/00 9:41:44 PM)
 */
public void update(TsObject obj) throws MappingException{
	try {
		Department dept = (Department) obj;
		DepartmentEJB departmentEJB = departmentHome.findByPrimaryKey(new DepartmentEJBKey(dept.getNumber()));
		departmentEJB.setName(dept.getName());
	} catch (Exception e) {
		AppService.log(TraceCapable.ERROR_LEVEL,"Exception " + e + " caught in DepartmentFactory.update()");
		throw new MappingException(e, ("Wrapped Exception " + e + " caught in DepartmentFactory.update()"));
	}
}

}

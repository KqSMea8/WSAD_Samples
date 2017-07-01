package com.wsbook.casestudy.mapping.ejb;

import java.util.Collection;
import java.util.Enumeration;

import javax.ejb.EJBLocalObject;
import javax.ejb.EJBObject;
import javax.rmi.PortableRemoteObject;

import com.wsbook.casestudy.domain.Address;
import com.wsbook.casestudy.domain.Employee;
import com.wsbook.casestudy.domain.TsObject;
import com.wsbook.casestudy.ejb.AddressEJB;
import com.wsbook.casestudy.ejb.AddressEJBHome;
import com.wsbook.casestudy.ejb.AddressEJBKey;
import com.wsbook.casestudy.ejb.EmployeeEJB;
import com.wsbook.casestudy.ejb.EmployeeEJBHome;
import com.wsbook.casestudy.exception.MappingException;
import com.wsbook.casestudy.exception.NoSuchEmployeeException;
import com.wsbook.casestudy.system.AppService;
import com.wsbook.casestudy.system.TraceCapable;
/**
 * This is the Factory Object for Employees.  It creates Employee Objects from EmployeeEJBs and
 * vice-versa.
 *
 * Creation date: (2/20/00 9:36:28 PM)
 * @author: Administrator
 */
public class EmployeeMapper
	extends DomainEJBMapper
	implements com.wsbook.casestudy.mapping.EmployeeMapper {
	EmployeeEJBHome employeeHome;
	AddressEJBHome addressHome;

	/**
	 * EmployeeFactory constructor.
	 */
	public EmployeeMapper() {
		super();
		createInitialContext();
		createEmployeeHome();
		createAddressHome();
	}
	/**
	 * Create an EmployeeEJB in the persistent store from this Employeee domain object.
	 * Creation date: (2/20/00 9:41:44 PM)
	 */
	public void insert(TsObject obj) throws MappingException {
		try {
			Employee emp = (Employee) obj;
			EmployeeEJB employeeEJB =
				employeeHome.create(emp.getId(), emp.getName());
			Address addr = emp.getAddress();
			AddressEJB anAddressEJB = addressHome.create(addr.getKey());
			anAddressEJB.setStreetAddress(addr.getStreetAddress());
			anAddressEJB.setCity(addr.getCity());
			anAddressEJB.setState(addr.getState());
			anAddressEJB.setZipCode(addr.getZip());
			employeeEJB.setHomeAddress(anAddressEJB);
		} catch (Exception e) {
			AppService.log(
				TraceCapable.ERROR_LEVEL,
				"Exception " + e + " caught in insert()");
			throw new MappingException(e, 
				("Wrapped Exception " + e + " caught in create()"));
		}
	}

	/**
	 * Create an EmployeeEJB in the persistent store from this Employeee domain object.
	 * Creation date: (2/20/00 9:41:44 PM)
	 */
	public Employee findById(String id) throws NoSuchEmployeeException {
		Employee emp = null;
		try {

			EmployeeEJB employeeEJB = employeeHome.findByPrimaryKey(id);
			emp = (Employee) map(employeeEJB);
		} catch (Exception e) {
			AppService.log(
				TraceCapable.ERROR_LEVEL,
				"Exception " + e + " caught in findById()");
			throw new NoSuchEmployeeException(e, 
				("Wrapped Exception " + e + " caught in findById()"));
		}
		return emp;
	}

	/**
	 * This method retrieves an instance of EmployeeEJBHome from the JNDI initial context.
	 * Creation date: (2/19/00 3:02:08 PM)
	 */
	protected void createEmployeeHome() {

		try {
			employeeHome =
				(EmployeeEJBHome) initContext.lookup(
					"java:comp/env/ejb/EmployeeEJB");
		} catch (Exception e) { // Error getting the home interface
			AppService.log(
				TraceCapable.ERROR_LEVEL,
				"Exception " + e + " in createEmployeeHome()");
		}

	}

	/**
	 * This method retrieves an instance of EmployeeEJBHome from the JNDI initial context.
	 * Creation date: (2/19/00 3:02:08 PM)
	 */
	protected void createAddressHome() {

		try {
			addressHome =
				(AddressEJBHome) initContext.lookup(
					"java:comp/env/ejb/AddressEJB");
		} catch (Exception e) { // Error getting the home interface
			AppService.log(
				TraceCapable.ERROR_LEVEL,
				"Exception " + e + " in createAddressHome()");
		}

	}
	/**
	 * This method retrieves all EJB's of this type
	 * Creation date: (2/19/00 3:02:08 PM)
	 */
	protected Collection findAllEJBs() throws MappingException {
		try {
			return employeeHome.findAll();
		} catch (Exception e) {
			throw new MappingException(
				e,
				("Wrapped exception caught in findAllEJBs : " + e));
		}
	}
	/**
	 * Return the single EJBObject matching this domain object.
	 * Creation date: (2/20/00 9:41:44 PM)
	 */
	public EJBLocalObject findEJBObjectMatching(TsObject domainObject)
		throws MappingException {
		EmployeeEJB employeeEJB = null;
		if (domainObject != null) {
			try {
				Employee emp = (Employee) domainObject;
				employeeEJB = employeeHome.findByPrimaryKey(emp.getId());
			} catch (Exception e) {
				AppService.log(
					TraceCapable.ERROR_LEVEL,
					"Exception " + e + " caught in findEJBObjectMatching()");
				throw new MappingException(
					e,
					("Wrapped Exception "
						+ e
						+ " caught in findEJBObjectMatching()"));
			}
		}
		return employeeEJB;
	}
	/**
	 * Map this EJBObject to an Domain object and return that domain object.
	 * Creation date: (2/20/00 9:41:44 PM)
	 */
	public TsObject map(EJBLocalObject input) throws MappingException {
		EmployeeEJB ejb;
		try {
			ejb = (EmployeeEJB) input;
		} catch (ClassCastException e) {
			throw new MappingException(
				e, "Attempt to map a non EmployeeEJB in EmployeeFactory");
		}

		Employee emp = null;
		if (ejb != null) {
			try {
				emp = new Employee();
				emp.setId((String) ejb.getPrimaryKey());
				emp.setName(ejb.getName());
				AddressEJB ejbAddress = ejb.getHomeAddress();
				if (ejbAddress != null) {
					Address addr = new Address();
					AddressEJBKey key =
						(AddressEJBKey) ejbAddress.getPrimaryKey();
					addr.setKey(key.addressKey);
					addr.setStreetAddress(ejbAddress.getStreetAddress());
					addr.setCity(ejbAddress.getCity());
					addr.setState(ejbAddress.getState());
					addr.setZip(ejbAddress.getZipCode());
					emp.setAddress(addr);
				}
			} catch (Exception e) {
				AppService.log(
					TraceCapable.ERROR_LEVEL,
					"Exception " + e + " caught in EmployeeFactory.map()");
				throw new MappingException(
					e,
					("Wrapped Exception "
						+ e
						+ " caught in EmployeeFactory.map()"));
			}
		}
		return emp;
	}
	/**
	 * Update this domain object in the persistent store.
	 * Creation date: (2/20/00 9:41:44 PM)
	 */
	public void update(TsObject obj) throws MappingException {
		try {
			Employee emp = (Employee) obj;
			EmployeeEJB employeeEJB =
				employeeHome.findByPrimaryKey(emp.getId());
			employeeEJB.setName(emp.getName());
			// Should update Address as well
		} catch (Exception e) {
			AppService.log(
				TraceCapable.ERROR_LEVEL,
				"Exception " + e + " caught in update()");
			throw new MappingException(
				e,
				("Wrapped Exception " + e + " caught in update()"));
		}
	}

}

package com.wsbook.casestudy.mapper.jdbc.test;
import java.util.ArrayList;

import junit.framework.TestCase;

import com.wsbook.casestudy.domain.Address;
import com.wsbook.casestudy.domain.Employee;
import com.wsbook.casestudy.exception.MappingException;
import com.wsbook.casestudy.mapping.EmployeeMapper;
import com.wsbook.casestudy.mapping.Mapper;
import com.wsbook.casestudy.system.AppService;
import com.wsbook.casestudy.system.TraceCapable;

/**
 * Insert the type's description here.
 * Creation date: (3/16/2001 2:06:58 PM)
 * @author: ILS User
 */
public class EmployeeMapperTest extends JDBCMapperTest {
	/**
	 * CustomerMapperTest constructor comment.
	 * @param name java.lang.String
	 */
	public EmployeeMapperTest(String name) {
		super(name);
	}

	private void shallowVerify(Employee refEmp, Employee compEmp) {
		assertNotNull("Mapper failed to retrieve Employee ", compEmp);
		// Check for name
		String name = compEmp.getName();
		assertNotNull("Null name for Employee ", name);
		assertEquals("Different retrieved Employee name", name, refEmp.getName());

		// Check for Id
		assertEquals("Different retrieved Employee id", refEmp.getId(), compEmp.getId());

		verifyAddress(refEmp.getAddress(), compEmp.getAddress());
	}

	private void verifyAddress(Address refAddr, Address compAddr) {
		// Check for street
		String street = compAddr.getStreetAddress();
		assertNotNull("Null name for street ", street);
		assertEquals("Different retrieved Street Address", street, refAddr.getStreetAddress());
		// Check for name
		String city = compAddr.getCity();
		assertNotNull("Null name for city ", city);
		assertEquals("Different retrieved City", city, refAddr.getCity());
		// Check for name
		String state = compAddr.getState();
		assertNotNull("Null name for state ", state);
		assertEquals("Different retrieved state", state, refAddr.getState());
		// Check for name
		String zip = compAddr.getZip();
		assertNotNull("Null name for zip ", zip);
		assertEquals("Different retrieved Zip", zip, refAddr.getZip());
	}

	private Employee buildTestEmployee() {
		Employee newEmployee = new Employee();
		newEmployee.setAddress(getTestAddress());
		newEmployee.setId("T9900");
		newEmployee.setName("Joe Smith");
		return newEmployee;
	}

	private void changeData(Employee empToUpdate) {
		empToUpdate.setName("Changed Name");
		empToUpdate.setAddress(updateAddress(empToUpdate.getAddress()));
	}

	private Address getTestAddress() {
		Address newAddress = new Address();
		newAddress.setStreetAddress("123 Elm Street");
		newAddress.setCity("Anytown");
		newAddress.setState("XX");
		newAddress.setZip("99900");
		return newAddress;
	}

	private Address updateAddress(Address addr) {
		addr.setStreetAddress("321 Broad Street");
		addr.setCity("AnyCity");
		addr.setState("YY");
		addr.setZip("11100");
		return addr;
	}

	/**
	 * Insert the method's description here.
	 * Creation date: (3/19/2001 8:32:42 AM)
	 */
	public void testCreateUpdateRemove() throws MappingException {
		Employee newEmployee = buildTestEmployee();
		Mapper mapper1 = newEmployee.getMapper();
		// create object in pStore
		mapper1.insert(newEmployee);
		Employee checkEmployee = new Employee();

		// set primary key only to retrieve data
		checkEmployee.setId(newEmployee.getId());
		Mapper mapper2 = checkEmployee.getMapper();

		// retrieve newly created object
		Employee returnedEmployee = (Employee) mapper2.findByPrimaryKey(checkEmployee);

		// compare that retrieved (populated) data is correct
		shallowVerify(newEmployee, returnedEmployee);

		// now update data
		changeData(newEmployee);
		mapper1.update(newEmployee);

		// retrieve updated object
		returnedEmployee = (Employee) mapper2.findByPrimaryKey(checkEmployee);

		// compare that retrieve (populated) data is correct
		shallowVerify(newEmployee, returnedEmployee);

		// now remove object from pStore	
		mapper2.remove(newEmployee);
		returnedEmployee = null;
		try {
			returnedEmployee = (Employee) mapper2.findByPrimaryKey(checkEmployee);
		} catch (MappingException me) {
		}
		assertNull("Failed to remove Employee", returnedEmployee);
	}

	/**
	 * Insert the method's description here.
	 * Creation date: (3/16/2001 2:09:19 PM)
	 */
	public void testFindEmployee() throws MappingException {
		Employee newEmployee = buildTestEmployee();
		EmployeeMapper mapper1 = (EmployeeMapper) newEmployee.getMapper();
		assertNotNull("Can't retrieve Mapper for Employee", mapper1);
		mapper1.insert(newEmployee);
		Employee empKey = new Employee();
		empKey.setId("T9900");
		Mapper mapper = empKey.getMapper();
		assertNotNull("Can't retrieve Mapper for Employee", mapper);

		Employee retrievedEmp = (Employee) mapper.findByPrimaryKey(empKey);
		// check for not null data
		shallowVerify(retrievedEmp, retrievedEmp);
	}
	
	public void testFindById() throws MappingException {
		Employee newEmployee = buildTestEmployee();
		EmployeeMapper mapper1 = (EmployeeMapper) newEmployee.getMapper();
		assertNotNull("Can't retrieve Mapper for Employee", mapper1);
		
		// create object in pStore
		mapper1.insert(newEmployee);
		// now try to retrieve it
		Employee retrievedEmp = (Employee) mapper1.findById("T9900");
		// check for not null data
		shallowVerify(retrievedEmp, retrievedEmp);
	}
	
	public void testFindAll() throws MappingException {
		Employee newEmployee = buildTestEmployee();
		EmployeeMapper mapper1 = (EmployeeMapper) newEmployee.getMapper();
		assertNotNull("Can't retrieve Mapper for Employee", mapper1);
		mapper1.insert(newEmployee);

		ArrayList empList = mapper1.findAll();
		assertNotNull("No employees found by findAll", empList);
		if (empList != null)
			AppService.log(TraceCapable.INFO_LEVEL,"Number of Employess found is " + empList.size());
		assertTrue("Expected at exactly 1 employees from findAll", empList.size() == 1);
	}
		

}
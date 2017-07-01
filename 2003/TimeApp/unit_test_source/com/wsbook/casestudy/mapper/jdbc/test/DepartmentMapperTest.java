package com.wsbook.casestudy.mapper.jdbc.test;
import junit.framework.TestCase;

import com.wsbook.casestudy.domain.Department;
import com.wsbook.casestudy.exception.MappingException;
import com.wsbook.casestudy.mapping.Mapper;

/**
 * Insert the type's description here.
 * Creation date: (3/16/2001 2:06:58 PM)
 * @author: ILS User
 */
public class DepartmentMapperTest extends TestCase {
/**
 * CustomerMapperTest constructor comment.
 * @param name java.lang.String
 */
public DepartmentMapperTest(String name) {
	super(name);
}

private void shallowVerify(Department refDept, Department compDept) {
	assertNotNull("Mapper failed to retrieve department ", compDept);
	// Check for name
	String name = compDept.getName();
	assertNotNull("Null name for department ", name);
	assertEquals("Different retrieved department name", name, refDept.getName());
	// Check for Number
	assertEquals("Different retrieved department number", refDept.getNumber(), compDept.getNumber());
}

private Department buildTestDepartment() {
	Department newDepartment = new Department();
	newDepartment.setNumber(99);
	newDepartment.setName("Test Department");
	return newDepartment;
}

private void changeData(Department deptToUpdate) {
	deptToUpdate.setName("Changed Dept Name");
}

/**
 * Insert the method's description here.
 * Creation date: (3/19/2001 8:32:42 AM)
 */
public void testCreateUpdateRemove() throws MappingException {
	Department newDepartment = buildTestDepartment();
	Mapper mapper1 = newDepartment.getMapper();
	// create object in pStore
	mapper1.insert(newDepartment);
	Department checkDepartment = new Department();
	checkDepartment.setNumber(newDepartment.getNumber());
	Mapper mapper2 = checkDepartment.getMapper();
	
	// retrieve newly created object
	Department returnedDepartment = (Department)mapper2.findByPrimaryKey(checkDepartment);
	
	// compare that retrieve (populated) data is correct
	shallowVerify(newDepartment, returnedDepartment);
	
	// now update data
	changeData(newDepartment);
	mapper1.update(newDepartment);
	
	// retrieve updated object
	returnedDepartment = (Department)mapper2.findByPrimaryKey(checkDepartment);
	
	// compare that retrieve (populated) data is correct
	shallowVerify(newDepartment, returnedDepartment);

	// now remove object from pStore	
	mapper2.remove(checkDepartment);
	returnedDepartment = null;
	try {
		returnedDepartment = (Department)mapper2.findByPrimaryKey(checkDepartment);
	}
	catch (MappingException me) {}
	assertNull("Failed to remove Department", returnedDepartment);
}

/**
 * Insert the method's description here.
 * Creation date: (3/16/2001 2:09:19 PM)
 */
public void testFindDepartment() throws MappingException {
	Department deptKey = new Department();
	deptKey.setNumber(10);
	Mapper mapper = deptKey.getMapper();
	assertNotNull("Can't retrieve Mapper for TestArea", mapper);
	
	Department retrievedDept = (Department)mapper.findByPrimaryKey(deptKey);
	// fill in Name for reference object
	deptKey.setName(retrievedDept.getName());
	shallowVerify(deptKey, retrievedDept);
}


}
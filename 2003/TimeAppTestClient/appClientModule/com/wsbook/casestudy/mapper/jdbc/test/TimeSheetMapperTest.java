package com.wsbook.casestudy.mapper.jdbc.test;
import java.util.ArrayList;
import java.util.Calendar;

import junit.framework.TestCase;

import com.wsbook.casestudy.domain.Address;
import com.wsbook.casestudy.domain.ApprovedState;
import com.wsbook.casestudy.domain.Employee;
import com.wsbook.casestudy.domain.TimeSheet;
import com.wsbook.casestudy.domain.TimeSheetEntry;
import com.wsbook.casestudy.domain.TimeSheetState;
import com.wsbook.casestudy.exception.MappingException;
import com.wsbook.casestudy.mapping.Mapper;
import com.wsbook.casestudy.mapping.TimeSheetMapper;

/**
 * Insert the type's description here.
 * Creation date: (3/16/2001 2:06:58 PM)
 * @author: ILS User
 */
public class TimeSheetMapperTest extends JDBCMapperTest {

	/**
	 * CustomerMapperTest constructor comment.
	 * @param name java.lang.String
	 */
	public TimeSheetMapperTest(String name) {
		super(name);
	}

	private void shallowVerify(TimeSheet refTs, TimeSheet compTs) {
		assertNotNull("Mapper failed to retrieve TimeSheet ", compTs);
		
		Calendar weekend = compTs.getWeekend();
		assertNotNull("Missing Weekend date in TimeSheet", weekend);
		assertEquals("Different weekend dates in TimeSheet", weekend, refTs.getWeekend());
		
		Employee compEmp = compTs.getEmployee();
		assertNotNull("Missing Employee in TimeSheet", compEmp);
		String empId = compEmp.getId();
		assertEquals("Different Employees (name) in TimeSheet", empId, refTs.getEmployee().getId());
		
		TimeSheetState state = compTs.getState();
		assertNotNull("Missing State in TimeSheet", state);
		assertEquals("Different State for TimeSheets", state, refTs.getState());
	}
	
	private void entryVerify(TimeSheet refTs) {
		TimeSheetEntry[] entries = refTs.getEntry();
		assertTrue("Empty list of Entries for TimeSheet", entries.length > 0);
		
		// choose the last entry
		TimeSheetEntry entry = entries[entries.length-1];
		assertNotNull("Null Entry is list for TimeSheet", entry);
		
		// now check for valid date in entry
		assertNotNull("Null Date for entry", entry.getDate());
		assertNotNull("Null Project for Entry", entry.getProject());
		assertEquals("TimeSheetEntry not wired to its enclosing TimeSheet", refTs.getTimesheetID(), entry.getTimeSheet().getTimesheetID());
	}

	private TimeSheet buildTestTimeSheet() {
		TimeSheet newTimeSheet = new TimeSheet();
		newTimeSheet.setWeekendFromFormattedString("05/25/2002");
		newTimeSheet.setEmployee(getOwner());
		newTimeSheet.setApprovedBy(null);
		newTimeSheet.setState(TimeSheetState.getPendingState());
		return newTimeSheet;
	}
	
	private TimeSheet buildC300TestTimeSheet() {
		TimeSheet newTimeSheet = new TimeSheet();
		newTimeSheet.setWeekendFromFormattedString("05/25/2002");
		newTimeSheet.setEmployee(getC300Owner());
		newTimeSheet.setApprovedBy(null);
		newTimeSheet.setState(TimeSheetState.getApprovedState());
		return newTimeSheet;
	}
	
	private Employee getC300Owner() {
		Employee owner = new Employee();
		owner.setName("Fred Johnson");
		Address addr = new Address();
		addr.setKey(0);
		owner.setAddress(addr);
		owner.setId("C300");
		return owner;
	}
	
	private Employee getOwner() {
		Employee owner = new Employee();
		owner.setName("John Doe");
		Address addr = new Address();
		addr.setKey(0);
		owner.setAddress(addr);
		owner.setId("A100");
		return owner;
	}

	private void changeData(TimeSheet tsToUpdate) {
		tsToUpdate.setState(TimeSheetState.getApprovedState());
	}


	/**
	 * Insert the method's description here.
	 * Creation date: (3/19/2001 8:32:42 AM)
	 */
	public void testCreateUpdateRemove() throws MappingException {

		TimeSheet newTimeSheet = buildTestTimeSheet();
		Mapper mapper1 = newTimeSheet.getMapper();
		// create object in pStore
		mapper1.insert(newTimeSheet);
		assertTrue("ID expected to be set on creation", newTimeSheet.getTimesheetID() > 0);
		
		Employee emp1 = getOwner();
		Mapper mapper3 = emp1.getMapper();
		mapper3.insert(emp1);
		
		TimeSheet checkTimeSheet = new TimeSheet();

		// set primary key only to retrieve data
		checkTimeSheet.setTimesheetID(newTimeSheet.getTimesheetID());
		Mapper mapper2 = checkTimeSheet.getMapper();

		// retrieve newly created object
		TimeSheet returnedTimeSheet = (TimeSheet) mapper2.findByPrimaryKey(checkTimeSheet);

		// compare that retrieved (populated) data is correct
		shallowVerify(newTimeSheet, returnedTimeSheet);

		// now update data
		changeData(newTimeSheet);
		mapper1.update(newTimeSheet);

		// retrieve updated object
		returnedTimeSheet = (TimeSheet) mapper2.findByPrimaryKey(checkTimeSheet);

		// compare that retrieve (populated) data is correct
		shallowVerify(newTimeSheet, returnedTimeSheet);

		// now remove object from pStore	
		mapper2.remove(newTimeSheet);
		returnedTimeSheet = null;
		try {
			returnedTimeSheet = (TimeSheet) mapper2.findByPrimaryKey(checkTimeSheet);
		} catch (MappingException me) {
		}
		assertNull("Failed to remove TimeSheet", returnedTimeSheet);

	}

	/**
	 * Insert the method's description here.
	 * Creation date: (3/16/2001 2:09:19 PM)
	 */
	public void testFindTimeSheet() throws MappingException {

		TimeSheet newTimeSheet = buildTestTimeSheet();
		Mapper mapper1 = newTimeSheet.getMapper();
		// create object in pStore
		mapper1.insert(newTimeSheet);
		assertTrue("ID expected to be set on creation", newTimeSheet.getTimesheetID() > 0);
		Employee emp1 = getOwner();
		Mapper mapper2 = emp1.getMapper();
		mapper2.insert(emp1);

		TimeSheet tsKey = new TimeSheet();
		tsKey.setTimesheetID(newTimeSheet.getTimesheetID());
		Mapper mapper = tsKey.getMapper();
		assertNotNull("Can't retrieve Mapper for TimeSheet", mapper);

		TimeSheet retrievedTs = (TimeSheet) mapper.findByPrimaryKey(tsKey);
		// check for not null data
		shallowVerify(retrievedTs, retrievedTs);
		entryVerify(retrievedTs);
	}

	public void testFindAll() throws MappingException {
		
		TimeSheet newTimeSheet = buildTestTimeSheet();
		Mapper mapper1 = newTimeSheet.getMapper();
		// create object in pStore
		mapper1.insert(newTimeSheet);
		assertTrue("ID expected to be set on creation", newTimeSheet.getTimesheetID() > 0);

		TimeSheet tsKey = new TimeSheet();
		TimeSheetMapper mapper = (TimeSheetMapper) tsKey.getMapper();
		assertNotNull("Can't retrieve Mapper for TimeSheet", mapper);

		ArrayList tsList = mapper.findAll();
		assertNotNull("No TimeSheets found by findAll", tsList);
		assertTrue("Expected exactly 1 TimeSheets from findAll", tsList.size() == 1);
	}
	
	public void testFindForEmployee() throws MappingException {
		TimeSheet newTimeSheet = buildTestTimeSheet();
		Mapper mapper1 = newTimeSheet.getMapper();
		// create object in pStore
		mapper1.insert(newTimeSheet);
		assertTrue("ID expected to be set on creation", newTimeSheet.getTimesheetID() > 0);
		
		Employee emp1 = getOwner();
		Mapper empMap = emp1.getMapper();
		empMap.insert(emp1);
		
		TimeSheetMapper mapper = new com.wsbook.casestudy.mapping.jdbc.TimeSheetMapper();
		ArrayList tsList = mapper.findForEmployee("A100");
		// retrieving entries for John Doe
		assertNotNull("No TimeSheets found for employee A100", tsList);
		assertTrue("Expected at least 1 TimeSheet for A100", tsList.size() >= 1);
		
		// now check the validity of the contents.
		TimeSheet ts = (TimeSheet)tsList.get(0);
		Employee emp = ts.getEmployee();
		assertNotNull("No valid Employee for A100 list of timesheets", emp);
		assertEquals("Unexpected Employee for retrieved TimeSheet, A100", emp.getId(), "A100");
		
		// now check that don't get anything for a non-existent employee id
		tsList = mapper.findForEmployee("X765");
		// should get back an empty ArrayList
		assertNotNull("Null list for non-existent employee", tsList);
		assertTrue("Expected empty list for X765", tsList.size() == 0);
	}

	public void testFindPendingForEmployee() throws MappingException {

		TimeSheet newTimeSheet = buildTestTimeSheet();
		Mapper mapper1 = newTimeSheet.getMapper();
		// create object in pStore
		mapper1.insert(newTimeSheet);
		assertTrue("ID expected to be set on creation", newTimeSheet.getTimesheetID() > 0);
		Employee emp1 = getOwner();
		Mapper mapper2 = emp1.getMapper();
		mapper2.insert(emp1);

		TimeSheetMapper mapper = new com.wsbook.casestudy.mapping.jdbc.TimeSheetMapper();
		ArrayList tsList = mapper.findPendingForEmployee("A100");
		// retrieving entries for John Doe
		assertNotNull("No TimeSheets found for employee A100", tsList);
		assertTrue("Expected at least 1 TimeSheet for A100", tsList.size() >= 1);
		
		// now check the validity of the contents.
		TimeSheet ts = (TimeSheet)tsList.get(0);
		Employee emp = ts.getEmployee();
		assertNotNull("No valid Employee for A100 list of timesheets", emp);
		assertEquals("Unexpected Employee for retrieved TimeSheet, A100", emp.getId(), "A100");
		
		// now check that don't get anything for a id C300
		tsList = mapper.findPendingForEmployee("C300");
		// should get back an empty ArrayList
		assertNotNull("Null list for non-existent employee", tsList);
		assertTrue("Expected empty list for Clark", tsList.size() == 0);
	}

	public void testFindApprovedForEmployee() throws MappingException {
		
		TimeSheet newTimeSheet = buildC300TestTimeSheet();
		Mapper mapper1 = newTimeSheet.getMapper();
		// create object in pStore
		mapper1.insert(newTimeSheet);
		assertTrue("ID expected to be set on creation", newTimeSheet.getTimesheetID() > 0);
		
		Employee emp1 = getC300Owner();
		Mapper mapper2 = emp1.getMapper();
		mapper2.insert(emp1);
		
		
		TimeSheetMapper mapper = new com.wsbook.casestudy.mapping.jdbc.TimeSheetMapper();
		ArrayList tsList = mapper.findApprovedForEmployee("C300");
		// retrieving entries for John Doe
		assertNotNull("No TimeSheets found for employee C300", tsList);
		assertTrue("Expected at least 1 TimeSheet for C300", tsList.size() >= 1);
		
		// now check the validity of the contents.
		TimeSheet ts = (TimeSheet)tsList.get(0);
		Employee emp = ts.getEmployee();
		assertNotNull("No valid Employee for C300 list of timesheets", emp);
		assertEquals("Unexpected Employee for retrieved TimeSheet, C300", emp.getId(), "C300");
		
		// now check that don't get anything for a employee id B200
		tsList = mapper.findApprovedForEmployee("B200");
		// should get back an empty ArrayList
		assertNotNull("Null list for non-existent employee", tsList);
		assertTrue("Expected empty list for B200", tsList.size() == 0);
	}

	public void testFindAllPending() throws MappingException {
		TimeSheet newTimeSheet = buildTestTimeSheet();
		Mapper mapper1 = newTimeSheet.getMapper();
		// create object in pStore
		mapper1.insert(newTimeSheet);
		assertTrue("ID expected to be set on creation", newTimeSheet.getTimesheetID() > 0);
		
		TimeSheetMapper mapper = new com.wsbook.casestudy.mapping.jdbc.TimeSheetMapper();
		ArrayList tsList = mapper.findAllPending();
		// retrieving entries for John Doe
		assertNotNull("No Pending TimeSheets found", tsList);
		assertTrue("Expected at least 1 Pending TimeSheet", tsList.size() >= 1);
	}

	public void testFindAllApproved() throws MappingException {

		TimeSheet newTimeSheet = buildTestTimeSheet();
		newTimeSheet.setState(new ApprovedState());
		Mapper mapper1 = newTimeSheet.getMapper();
		// create object in pStore
		mapper1.insert(newTimeSheet);
		assertTrue("ID expected to be set on creation", newTimeSheet.getTimesheetID() > 0);
		
		TimeSheetMapper mapper = new com.wsbook.casestudy.mapping.jdbc.TimeSheetMapper();
		ArrayList tsList = mapper.findAllApproved();
		// retrieving entries for John Doe
		assertNotNull("No Approved TimeSheets found", tsList);
		assertTrue("Expected at least 1 Approved TimeSheet", tsList.size() >= 1);
		
	}
	
	public void testFindByKey() throws MappingException {
		TimeSheet newTimeSheet = buildTestTimeSheet();
		Mapper mapper1 = newTimeSheet.getMapper();
		// create object in pStore
		mapper1.insert(newTimeSheet);
		assertTrue("ID expected to be set on creation", newTimeSheet.getTimesheetID() > 0);
		
		TimeSheetMapper mapper = new com.wsbook.casestudy.mapping.jdbc.TimeSheetMapper();
		TimeSheet ts = mapper.findByKey("A100", "05/25/2002");
		// retrieving entries for John Doe
		assertNotNull("No TimeSheet found", ts);
	}
		
		
}
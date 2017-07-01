package com.wsbook.casestudy.mapper.jdbc.test;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

import junit.framework.TestCase;

import com.wsbook.casestudy.domain.Address;
import com.wsbook.casestudy.domain.Project;
import com.wsbook.casestudy.domain.TimeSheetEntry;
import com.wsbook.casestudy.exception.MappingException;
import com.wsbook.casestudy.mapping.Mapper;
import com.wsbook.casestudy.mapping.TimeSheetEntryMapper;

/**
 * Insert the type's description here.
 * Creation date: (3/16/2001 2:06:58 PM)
 * @author: ILS User
 */
public class TimeSheetEntryMapperTest extends TestCase {

	private int createId = -1;
	/**
	 * CustomerMapperTest constructor comment.
	 * @param name java.lang.String
	 */
	public TimeSheetEntryMapperTest(String name) {
		super(name);
	}

	private void shallowVerify(TimeSheetEntry refEmp, TimeSheetEntry compEmp) {
		assertNotNull("Mapper failed to retrieve TimeSheetEntry ", compEmp);
		// Check for name
		Calendar date = compEmp.getDate();
		assertNotNull("Null Date for TimeSheetEntry ", date);

		// Check for Id
		assertTrue("Different retrieved TimeSheetEntry hours", refEmp.getHours() == compEmp.getHours());

		// Not checking for Project or timesheetId
	}

	private TimeSheetEntry buildTestTimeSheetEntry() {
		TimeSheetEntry newTimeSheetEntry = new TimeSheetEntry();
		newTimeSheetEntry.setDate(new GregorianCalendar());
		newTimeSheetEntry.setTimeSheetEntryID(999);
		newTimeSheetEntry.setHours(8.0);
		newTimeSheetEntry.setProject(buildMockProject());
		return newTimeSheetEntry;
	}

	private void changeData(TimeSheetEntry empToUpdate) {
		empToUpdate.setHours(4.2);
	}

	private Project buildMockProject() {
		Project project = new Project();
		project.setNumber("P1");
		project.setName("Development at ABC Corp.");
		return project;
	}

	/**
	 * Insert the method's description here.
	 * Creation date: (3/19/2001 8:32:42 AM)
	 */
	public void testCreateUpdateRemove() throws MappingException {
		createId = -1;
		TimeSheetEntry newTimeSheetEntry = buildTestTimeSheetEntry();
		Mapper mapper1 = newTimeSheetEntry.getMapper();
		// create object in pStore
		mapper1.insert(newTimeSheetEntry);
		assertTrue("Entry ID expected to be set on creation", newTimeSheetEntry.getTimeSheetEntryID() > 0);
		createId = newTimeSheetEntry.getTimeSheetEntryID();
		TimeSheetEntry checkTimeSheetEntry = new TimeSheetEntry();

		// set primary key only to retrieve data
		checkTimeSheetEntry.setTimeSheetEntryID(newTimeSheetEntry.getTimeSheetEntryID());
		Mapper mapper2 = checkTimeSheetEntry.getMapper();

		// retrieve newly created object
		TimeSheetEntry returnedTimeSheetEntry = (TimeSheetEntry) mapper2.findByPrimaryKey(checkTimeSheetEntry);

		// compare that retrieved (populated) data is correct
		shallowVerify(newTimeSheetEntry, returnedTimeSheetEntry);

		// now update data
		changeData(newTimeSheetEntry);
		mapper1.update(newTimeSheetEntry);

		// retrieve updated object
		returnedTimeSheetEntry = (TimeSheetEntry) mapper2.findByPrimaryKey(checkTimeSheetEntry);

		// compare that retrieve (populated) data is correct
		shallowVerify(newTimeSheetEntry, returnedTimeSheetEntry);

		// now remove object from pStore	
		mapper2.remove(checkTimeSheetEntry);
		returnedTimeSheetEntry = null;
		try {
			returnedTimeSheetEntry = (TimeSheetEntry) mapper2.findByPrimaryKey(checkTimeSheetEntry);
		} catch (MappingException me) {
		}
		assertNull("Failed to remove TimeSheetEntry", returnedTimeSheetEntry);
		createId = -1;
	}

	public void tearDown() {
		// make sure cleanup after ourselves.
		if (createId != -1) {
			TimeSheetEntry newTimeSheetEntry = buildTestTimeSheetEntry();
			newTimeSheetEntry.setTimeSheetEntryID(createId);
			try {
				newTimeSheetEntry.getMapper().remove(newTimeSheetEntry);
			} catch (MappingException me) {
			}
		}
	}

	/**
	 * Insert the method's description here.
	 * Creation date: (3/16/2001 2:09:19 PM)
	 */
	public void testFindTimeSheetEntry() throws MappingException {
		createId = -1;
		TimeSheetEntry empKey = new TimeSheetEntry();
		empKey.setTimeSheetEntryID(1);
		Mapper mapper = empKey.getMapper();
		assertNotNull("Can't retrieve Mapper for TimeSheetEntry", mapper);

		TimeSheetEntry retrievedEmp = (TimeSheetEntry) mapper.findByPrimaryKey(empKey);
		// check for not null data
		shallowVerify(retrievedEmp, retrievedEmp);
	}

	public void testFindAll() throws MappingException {
		createId = -1;
		TimeSheetEntry empKey = new TimeSheetEntry();
		TimeSheetEntryMapper mapper = (TimeSheetEntryMapper) empKey.getMapper();
		assertNotNull("Can't retrieve Mapper for TimeSheetEntry", mapper);

		ArrayList empList = mapper.findAll();
		assertNotNull("No TimeSheetEntrys found by findAll", empList);
		assertTrue("Expected at least 2 TimeSheetEntrys from findAll", empList.size() >= 2);
	}
}
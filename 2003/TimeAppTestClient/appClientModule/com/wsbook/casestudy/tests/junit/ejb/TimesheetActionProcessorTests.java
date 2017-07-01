package com.wsbook.casestudy.tests.junit.ejb;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import com.wsbook.casestudy.command.UpdateTimesheetFormCommand;
import com.wsbook.casestudy.domain.Address;
import com.wsbook.casestudy.domain.Employee;
import com.wsbook.casestudy.domain.Project;
import com.wsbook.casestudy.domain.TimeSheet;
import com.wsbook.casestudy.domain.TimeSheetEntry;
import com.wsbook.casestudy.domain.TimeSheetState;
import com.wsbook.casestudy.exception.MappingException;
import com.wsbook.casestudy.exception.ModelException;
import com.wsbook.casestudy.exception.NoSuchEmployeeException;
import com.wsbook.casestudy.model.ActionProcessorFactory;
import com.wsbook.casestudy.model.TimeSheetActionProcessor;
import com.wsbook.casestudy.system.AppService;
import com.wsbook.casestudy.system.TraceCapable;
import com.wsbook.casestudy.util.ApplProperties;
import com.wsbook.casestudy.util.Formatter;

import junit.framework.TestCase;

/**
 * This class contains the JUnit Tests for the TimesheetActionProcessor.
 * It tests the Business delegate, facade and mapper layers.  It is 
 * compatible with either the In-Memory or Entity EJB Mappers.
 */
public class TimesheetActionProcessorTests extends TestCase {
	private static final String DELETE_TIMESHEETENTRIES =
		"delete from ISHAFFIGULIN.TIMESHEETENTRYEJB";
	private static final String DELETE_TIMESHEETS =
		"delete from ISHAFFIGULIN.TIMESHEETEJB";
	private static final String DELETE_EMPLOYEES =
		"delete from ISHAFFIGULIN.EMPLOYEEEJB";
	private static final String DELETE_ADDRESSES =
		"delete from ISHAFFIGULIN.ADDRESSEJB";
	private static final String DELETE_PROJECTS =
		"delete from ISHAFFIGULIN.PROJECTEJB";

	private DataSource ds;

	//	private static final String DATASOURCE_NAME =  "java:comp/env/jdbc/WSBOOK";
	private static final String DATASOURCE_NAME = "jdbc/WSBOOK";

	/**
	 * Constructor for TimesheetActionProcessorTests.
	 * @param arg0
	 */
	public TimesheetActionProcessorTests(String arg0) {
		super(arg0);
	}

	public void testAddFindTimesheet() {

		// test adding, finding and removing a Timesheet from the model
		TimeSheetActionProcessor processor =
			(
				TimeSheetActionProcessor) ActionProcessorFactory
					.getActionProcessor(
				"TimeSheet");

		Employee fred = new Employee();
		fred.setId("88");
		fred.setName("Fred Jones");
		Address fredHome = new Address();
		fredHome.setStreetAddress("211 Maple Leaf Rag Way");
		fredHome.setCity("Cary");
		fredHome.setState("NC");
		fredHome.setKey(47);
		fred.setAddress(fredHome);

		try {

			processor.addEmployee(fred);

			TimeSheet ts = processor.createTimeSheet("88", "04/04/2003");
			Employee fredClone = ts.getEmployee();
			checkForDeepEquality(fred, fredClone);
			TimeSheetState state = ts.getState();
			assertTrue("State is not pending", state.isPending());

			TimeSheet tsClone =
				processor.findTimeSheetByKey("88", "04/04/2003");
			checkForDeepEquality(ts, tsClone);

		} catch (Exception e) {
			fail("Exception caught in testAddDeleteTimesheet " + e);
		}

	}
	
	
	public void testAddMultipleTimesheets() {

		// test adding two timesheets for different weeks for the same employee
		TimeSheetActionProcessor processor =
			(
				TimeSheetActionProcessor) ActionProcessorFactory
					.getActionProcessor(
				"TimeSheet");

		Employee fred = new Employee();
		fred.setId("88");
		fred.setName("Fred Jones");
		Address fredHome = new Address();
		fredHome.setStreetAddress("211 Maple Leaf Rag Way");
		fredHome.setCity("Cary");
		fredHome.setState("NC");
		fredHome.setKey(47);
		fred.setAddress(fredHome);

		try {

			processor.addEmployee(fred);

			TimeSheet ts = processor.createTimeSheet("88", "04/04/2003");
			Employee fredClone = ts.getEmployee();
			checkForDeepEquality(fred, fredClone);
			TimeSheetState state = ts.getState();
			assertTrue("State is not pending", state.isPending());

			TimeSheet tsClone =
				processor.findTimeSheetByKey("88", "04/04/2003");
			checkForDeepEquality(ts, tsClone);
			
			TimeSheet tsTwo = processor.createTimeSheet("88", "04/11/2003");
			Employee fredCloneTwo = ts.getEmployee();
			checkForDeepEquality(fred, fredCloneTwo);
			TimeSheetState anotherState = ts.getState();
			assertTrue("State is not pending", anotherState.isPending());

			TimeSheet tsCloneTwo =
				processor.findTimeSheetByKey("88", "04/11/2003");
			checkForDeepEquality(tsTwo, tsCloneTwo);


		} catch (Exception e) {
			fail("Exception caught in testAddDeleteTimesheet " + e);
		}

	}

	public void testTimesheetApproval() {

		// test adding, finding and removing a Timesheet from the model
		TimeSheetActionProcessor processor =
			(
				TimeSheetActionProcessor) ActionProcessorFactory
					.getActionProcessor(
				"TimeSheet");

		Employee fred = new Employee();
		fred.setId("88");
		fred.setName("Fred Jones");
		Address fredHome = new Address();
		fredHome.setStreetAddress("211 Maple Leaf Rag Way");
		fredHome.setCity("Cary");
		fredHome.setState("NC");
		fredHome.setKey(47);
		fred.setAddress(fredHome);
		
		Employee jane = new Employee();
		jane.setId("77");
		jane.setName("Jamie Woo");
		Address janeHome = new Address();
		janeHome.setStreetAddress("421 Broadcloth Drive");
		janeHome.setCity("Apex");
		janeHome.setState("NC");
		janeHome.setKey(41);
		jane.setAddress(janeHome);

		Project purple = new Project();
		purple.setNumber("99");
		purple.setName("Project Purple");

		try {
			processor.addEmployee(fred);
			processor.addEmployee(jane);
			processor.addProject(purple);

			TimeSheet ts = processor.createTimeSheet("88", "04/04/2003");
			
			UpdateTimesheetFormCommand command = new UpdateTimesheetFormCommand();
			command.setAddDate("04/03/2003");
			command.setAddHours("8.0");
			command.setAddProjectId("99");
			command.setEmployeeId("88");
			command.setWeekending("04/04/2003");
			
			processor.updateTimesheet(command);
			
			command = new UpdateTimesheetFormCommand();
			command.setAddDate("04/02/2003");
			command.setAddHours("8.0");
			command.setAddProjectId("99");
			command.setEmployeeId("88");
			command.setWeekending("04/04/2003");
			
			processor.updateTimesheet(command);
			
			command = new UpdateTimesheetFormCommand();
			command.setAddDate("04/01/2003");
			command.setAddHours("8.0");
			command.setAddProjectId("99");
			command.setEmployeeId("88");
			command.setWeekending("04/04/2003");
			
			processor.updateTimesheet(command);
			
			command = new UpdateTimesheetFormCommand();
			command.setAddDate("3/31/2003");
			command.setAddHours("8.0");
			command.setAddProjectId("99");
			command.setEmployeeId("88");
			command.setWeekending("04/04/2003");
			
			processor.updateTimesheet(command);
			
			processor.approveTimeSheetByKey("88","04/04/2003", "77");
			
			TimeSheet found = processor.findTimeSheetByKey("88", "04/04/2003");
		
			assertTrue("State not Approved",found.getState().isApproved());
			
			checkForDeepEquality(jane, found.getApprovedBy());
			

		} catch (Exception e) {
			fail("Exception caught in testAddDeleteTimesheet " + e);
		}

	}
	
	public void testAddTimesheetEntry() {

		// test adding, finding and removing a Timesheet from the model
		TimeSheetActionProcessor processor =
			(
				TimeSheetActionProcessor) ActionProcessorFactory
					.getActionProcessor(
				"TimeSheet");

		Employee fred = new Employee();
		fred.setId("88");
		fred.setName("Fred Jones");
		Address fredHome = new Address();
		fredHome.setStreetAddress("211 Maple Leaf Rag Way");
		fredHome.setCity("Cary");
		fredHome.setState("NC");
		fredHome.setKey(47);
		fred.setAddress(fredHome);

		Project purple = new Project();
		purple.setNumber("99");
		purple.setName("Project Purple");

		try {
			processor.addEmployee(fred);
			processor.addProject(purple);

			TimeSheet ts = processor.createTimeSheet("88", "04/04/2003");
			
			UpdateTimesheetFormCommand command = new UpdateTimesheetFormCommand();
			command.setAddDate("04/03/2003");
			command.setAddHours("8.0");
			command.setAddProjectId("99");
			command.setEmployeeId("88");
			command.setWeekending("04/04/2003");
			
			processor.updateTimesheet(command);
			
			TimeSheet found = processor.findTimeSheetByKey("88", "04/04/2003");
			TimeSheetEntry entry = found.getEntry(0);
			
			TimeSheetEntry tsEntry = new TimeSheetEntry();
			Calendar aprilThird = Formatter.convertToDate("04/03/2003");
			tsEntry.setHours(8.0);
			tsEntry.setProject(purple);
			tsEntry.setDate(aprilThird);
			
			checkForDeepEquality(entry, tsEntry);
			

		} catch (Exception e) {
			fail("Exception caught in testAddDeleteTimesheet " + e);
		}

	}

	/**
	 * Method checkForDeepEquality.
	 * @param entry
	 * @param tsEntry
	 */
	private void checkForDeepEquality(
		TimeSheetEntry entry,
		TimeSheetEntry tsEntry) {
			assertEquals("Dates don't match",entry.getFormattedDate(), tsEntry.getFormattedDate());
			assertEquals("Hours don't match", entry.getHours(), tsEntry.getHours(), 0.5);
			assertEquals("Projects don't match", entry.getProject().getName(), tsEntry.getProject().getName());
			
	}


	/**
	 * Method checkForDeepEquality.
	 * @param ts
	 * @param tsClone
	 */
	private void checkForDeepEquality(TimeSheet ts, TimeSheet tsClone) {
		Employee original = ts.getEmployee();
		Employee clone = tsClone.getEmployee();
		checkForDeepEquality(original, clone);
		TimeSheetState originalState = ts.getState();
		TimeSheetState cloneState = tsClone.getState();
		assertEquals(
			"States don't match",
			originalState.toString(),
			cloneState.toString());
		assertEquals(
			"Weekends don't match",
			ts.getFormattedWeekend(),
			tsClone.getFormattedWeekend());
	}

	public void testAddFindDeleteProject() {

		// test adding, finding and removing a Project from the model
		TimeSheetActionProcessor processor =
			(
				TimeSheetActionProcessor) ActionProcessorFactory
					.getActionProcessor(
				"TimeSheet");

		try {

			Project purple = new Project();
			purple.setNumber("99");
			purple.setName("Project Purple");
			processor.addProject(purple);

			Project clone = processor.findProjectByKey("99");
			assertEquals(
				"Names don't Match for Project",
				purple.getName(),
				clone.getName());

			processor.removeProject("99");

			try {
				processor.findProjectByKey("99");
				fail("Should have raised NoSuchProjectException");
			} catch (Exception e) {
				// Eat it -- it should fail
			}

		} catch (MappingException e) {
			fail("MappingException caught " + e);
		}

	}

	public void testAddFindDeleteEmployee() {

		// test adding, finding and removing an Employee from the model
		TimeSheetActionProcessor processor =
			(
				TimeSheetActionProcessor) ActionProcessorFactory
					.getActionProcessor(
				"TimeSheet");

		try {

			Employee fred = new Employee();
			fred.setId("88");
			fred.setName("Fred Jones");
			Address fredHome = new Address();
			fredHome.setStreetAddress("211 Maple Leaf Rag Way");
			fredHome.setCity("Cary");
			fredHome.setState("NC");
			fredHome.setKey(47);
			fred.setAddress(fredHome);
			processor.addEmployee(fred);

			Employee fredsClone = processor.findEmployeeByKey("88");
			checkForDeepEquality(fred, fredsClone);

			processor.removeEmployee("88");

			try {
				processor.findEmployeeByKey("88");
				fail("Should have raised NoSuchEmployeeException");
			} catch (Exception e) {
				// Eat it -- it should fail
			}

		} catch (MappingException e) {

			fail("MappingException caught " + e);
		}

	}
	
	public void testFindPendingForEmployee() {
		
			// test adding two timesheets for different weeks for the same employee
		TimeSheetActionProcessor processor =
			(
				TimeSheetActionProcessor) ActionProcessorFactory
					.getActionProcessor(
				"TimeSheet");

		Employee fred = new Employee();
		fred.setId("88");
		fred.setName("Fred Jones");
		Address fredHome = new Address();
		fredHome.setStreetAddress("211 Maple Leaf Rag Way");
		fredHome.setCity("Cary");
		fredHome.setState("NC");
		fredHome.setKey(47);
		fred.setAddress(fredHome);
		
		Employee jane = new Employee();
		jane.setId("77");
		jane.setName("Jane Woo");
		Address janeHome = new Address();
		janeHome.setStreetAddress("421 Broadcloth Drive");
		janeHome.setCity("Apex");
		janeHome.setState("NC");
		janeHome.setKey(41);
		jane.setAddress(janeHome);

		Project purple = new Project();
		purple.setNumber("99");
		purple.setName("Project Purple");
		

		try {

			processor.addEmployee(fred);
			processor.addEmployee(jane);
			processor.addProject(purple);

			TimeSheet ts = processor.createTimeSheet("88", "04/04/2003");
			TimeSheet tsTwo = processor.createTimeSheet("88", "04/11/2003");
			TimeSheet tsThree = processor.createTimeSheet("88", "04/18/2003");

			UpdateTimesheetFormCommand command = new UpdateTimesheetFormCommand();
			command.setAddDate("04/03/2003");
			command.setAddHours("8.0");
			command.setAddProjectId("99");
			command.setEmployeeId("88");
			command.setWeekending("04/04/2003");
			
			processor.updateTimesheet(command);
			
			processor.approveTimeSheetByKey("88","04/04/2003", "77");
			
			ArrayList list = processor.findPendingForEmployee("88");
			
			assertTrue("Number of sheets returned incorrect", (list.size() == 2));
			
		} catch (Exception e) {
			fail("Exception caught in testFindPendingForEmployee " + e);
		}
		
		
	}

	/**
	 * Method checkForEmployeeDeepEquality.
	 * @param fred
	 * @param fredsClone
	 */
	private void checkForDeepEquality(
		Employee fred,
		Employee fredsClone) {
		assertEquals("IDs Don't Match", fred.getId(), fredsClone.getId());
		assertEquals("Names Don't Match", fred.getName(), fredsClone.getName());

		checkForDeepEquality(
			fred.getAddress(),
			fredsClone.getAddress());

	}

	/**
	 * Method checkForAdddressDeepEquality.
	 * @param address
	 * @param address1
	 */
	private void checkForDeepEquality(
		Address address,
		Address address1) {
		assertEquals(
			"Street addresses don't match",
			address.getStreetAddress(),
			address1.getStreetAddress());
		assertEquals(
			"Cities don't match",
			address.getCity(),
			address1.getCity());
		assertEquals(
			"States don't match",
			address.getState(),
			address1.getState());
		assertEquals("Zips don't match", address.getZip(), address1.getZip());
	}

	public void setUp() {
		if (ApplProperties.getCurrentMapperName().equals("EJB")) 
			deleteAllRows();
		if (ApplProperties.getCurrentMapperName().equals("MEMORY")) 
			deleteAllCache();
	}

	/**
	 * Method deleteAllRows.
	 */
	private void deleteAllRows() {
		Connection jdbcConn = null;
		PreparedStatement sqlStatement = null;
		try {
			jdbcConn = getConnection();
			sqlStatement = jdbcConn.prepareStatement(DELETE_TIMESHEETENTRIES);
			sqlStatement.executeUpdate();
			sqlStatement.close();
			sqlStatement = jdbcConn.prepareStatement(DELETE_TIMESHEETS);
			sqlStatement.executeUpdate();
			sqlStatement.close();
			sqlStatement = jdbcConn.prepareStatement(DELETE_EMPLOYEES);
			sqlStatement.executeUpdate();
			sqlStatement.close();
			sqlStatement = jdbcConn.prepareStatement(DELETE_ADDRESSES);
			sqlStatement.executeUpdate();
			sqlStatement.close();
			sqlStatement = jdbcConn.prepareStatement(DELETE_PROJECTS);
			sqlStatement.executeUpdate();
			sqlStatement.close();
		} catch (SQLException se) {
			AppService.log(TraceCapable.ERROR_LEVEL,"Exception in deleteAllrows" + se.getMessage());
		} catch (NamingException ne) {
			AppService.log(TraceCapable.ERROR_LEVEL,"Exception in deleteAllrows" + ne.getMessage());
		} finally {
			try {
				if (sqlStatement != null)
					sqlStatement.close();
				if (jdbcConn != null)
					jdbcConn.close();
			} catch (SQLException e) {
				AppService.log(TraceCapable.ERROR_LEVEL,
					"Error in deleteAllRows() -- failure to close");
			}
		}

	}

	/**
	 * Method getConnection.
	 * @return Connection
	 */
	private Connection getConnection() throws SQLException, NamingException {
		if (ds == null) {
			InitialContext initContext = new InitialContext();
			ds = (DataSource) initContext.lookup(DATASOURCE_NAME);
		}
		return ds.getConnection();

	}

	public void tearDown() {
		if (ApplProperties.getCurrentMapperName().equals("EJB")) 
			deleteAllRows();
		if (ApplProperties.getCurrentMapperName().equals("MEMORY")) 
			deleteAllCache();
	}

	/**
	 * Method deleteAllCache.
	 */
	private void deleteAllCache() {
				TimeSheetActionProcessor processor =
			(
				TimeSheetActionProcessor) ActionProcessorFactory
					.getActionProcessor(
				"TimeSheet");
				processor.clearInMemoryCaches();
		
	}


}

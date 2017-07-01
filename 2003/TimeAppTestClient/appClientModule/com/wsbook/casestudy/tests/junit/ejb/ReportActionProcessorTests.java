package com.wsbook.casestudy.tests.junit.ejb;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import com.wsbook.casestudy.command.UpdateTimesheetFormCommand;
import com.wsbook.casestudy.domain.Address;
import com.wsbook.casestudy.domain.Employee;
import com.wsbook.casestudy.domain.Project;
import com.wsbook.casestudy.domain.TimeSheet;
import com.wsbook.casestudy.exception.ModelException;
import com.wsbook.casestudy.model.ActionProcessorFactory;
import com.wsbook.casestudy.model.ReportActionProcessor;
import com.wsbook.casestudy.model.TimeSheetActionProcessor;
import com.wsbook.casestudy.system.AppService;
import com.wsbook.casestudy.system.TraceCapable;
import com.wsbook.casestudy.util.ApplProperties;
import com.wsbook.casestudy.value.Report;
import com.wsbook.casestudy.value.ReportCollection;

import junit.framework.TestCase;

/**
 * This is a simple test case for the ReportActionProcessor.  It shares 
 * most of the features with the TimesheetActoinProcessorTests.  It could
 * be refactored to have a common superclass at some point.
 */
public class ReportActionProcessorTests extends TestCase {
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

	private static final String DATASOURCE_NAME = "jdbc/WSBOOK";

	/**
	 * Constructor for ReportActionProcessorTests.
	 * @param arg0
	 */
	public ReportActionProcessorTests(String arg0) {
		super(arg0);
	}

	public void testReportActionProcessor() {

		// Test retrieving a Report for the timesheet added.
		ReportActionProcessor processor =
			(ReportActionProcessor) ActionProcessorFactory.getActionProcessor(
				"Report");

		createDataForReport();
		Report monthly = null;
		try {
			monthly = processor.generateEmployeeByMonthReport();
		} catch (ModelException e) {
			fail("Model Exception caught " + e);
		}
		assertNotNull("Report is null", monthly);
		assertTrue("Report does not have two elements", monthly.getCollections().length == 2);
		ReportCollection[] coll = monthly.getCollections();
		ReportCollection first = coll[0];
		assertEquals("First category not Fred","Fred Jones",first.getCategory());
		assertEquals("Total hours not 24.0", 24.0, first.getTotalHours(), 0.5);

	}

	public void createDataForReport() {

		// Add a TimeSheet and some entries to the model.
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

			UpdateTimesheetFormCommand command =
				new UpdateTimesheetFormCommand();
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

			processor.approveTimeSheetByKey("88", "04/04/2003", "77");

			TimeSheet found = processor.findTimeSheetByKey("88", "04/04/2003");

			assertTrue("State not Approved", found.getState().isApproved());

		} catch (Exception e) {
			fail("Exception caught in testAddDeleteTimesheet " + e);
		}

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
			AppService.log(
				TraceCapable.ERROR_LEVEL,
				"Exception in deleteAllrows" + se.getMessage());
		} catch (NamingException ne) {
			AppService.log(
				TraceCapable.ERROR_LEVEL,
				"Exception in deleteAllrows" + ne.getMessage());
		} finally {
			try {
				if (sqlStatement != null)
					sqlStatement.close();
				if (jdbcConn != null)
					jdbcConn.close();
			} catch (SQLException e) {
				AppService.log(
					TraceCapable.ERROR_LEVEL,
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

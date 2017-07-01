package com.wsbook.casestudy.mapper.jdbc.test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import com.wsbook.casestudy.system.AppService;
import com.wsbook.casestudy.system.TraceCapable;

import junit.framework.TestCase;

/**
 * @author kbrown
 *
 * To change this generated comment edit the template variable "typecomment":
 * Window>Preferences>Java>Templates.
 * To enable and disable the creation of type comments go to
 * Window>Preferences>Java>Code Generation.
 */
public class JDBCMapperTest extends TestCase {
	
	private static final String DELETE_TIMESHEETENTRIES =
		"delete from USERID.TIMESHEETENTRY";
	private static final String DELETE_TIMESHEETS =
		"delete from USERID.TIMESHEET";
	private static final String DELETE_EMPLOYEES =
		"delete from USERID.EMPLOYEE";
	private static final String DELETE_ADDRESSES =
		"delete from USERID.ADDRESS";
	private static final String DELETE_PROJECTS =
		"delete from USERID.PROJECT";

	private DataSource ds;

	private static final String DATASOURCE_NAME = "jdbc/WSBOOK";

	/**
	 * Constructor for JDBCMapperTest.
	 * @param arg0
	 */
	public JDBCMapperTest(String arg0) {
		super(arg0);
	}
	
	
	public void setUp() {
		deleteAllRows();
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
		deleteAllRows();
	}

}

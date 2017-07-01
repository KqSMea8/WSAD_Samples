package com.wsbook.casestudy.mapping.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.ListIterator;

import com.wsbook.casestudy.domain.Employee;
import com.wsbook.casestudy.domain.TimeSheet;
import com.wsbook.casestudy.domain.TimeSheetEntry;
import com.wsbook.casestudy.domain.TimeSheetState;
import com.wsbook.casestudy.domain.TsObject;
import com.wsbook.casestudy.exception.DuplicateKeyException;
import com.wsbook.casestudy.exception.MappingException;
import com.wsbook.casestudy.exception.NoSuchTimeSheetException;
import com.wsbook.casestudy.system.AppService;
import com.wsbook.casestudy.system.TraceCapable;
import com.wsbook.casestudy.util.ApplProperties;
import com.wsbook.casestudy.util.Formatter;

public class TimeSheetMapper extends JDBCMapper implements com.wsbook.casestudy.mapping.TimeSheetMapper {

	private static final String _createString =
		"INSERT INTO " + ApplProperties.getDatasourceSchema() + ".TIMESHEET (TIMESHEETID, WEEKEND, STATE, EMPID, APPROVE_EMPID) VALUES (?, ?, ?, ?, ?)";
	private static final String _removeString = "DELETE FROM " + ApplProperties.getDatasourceSchema() + ".TIMESHEET  WHERE TIMESHEETID = ?";
	private static final String _storeString =
		"UPDATE " + ApplProperties.getDatasourceSchema() + ".TIMESHEET  SET WEEKEND = ?, STATE = ?, APPROVE_EMPID = ? WHERE TIMESHEETID = ?";
	private static final String _loadString =
		"SELECT TIMESHEETID, WEEKEND, STATE, EMPID, APPROVE_EMPID FROM " + ApplProperties.getDatasourceSchema() + ".TIMESHEET WHERE TIMESHEETID = ?";
	private static final String findByKeyString =
		"SELECT TIMESHEETID, WEEKEND, STATE, EMPID, APPROVE_EMPID FROM "
			+ ApplProperties.getDatasourceSchema()
			+ ".TIMESHEET WHERE EMPID = ? AND WEEKEND = ?";
	private static final String findForEmployeeString =
		"SELECT TIMESHEETID, WEEKEND, STATE, EMPID, APPROVE_EMPID FROM " + ApplProperties.getDatasourceSchema() + ".TIMESHEET WHERE EMPID = ?";
	private static final String findPendingString =
		"SELECT TIMESHEETID, WEEKEND, STATE, EMPID, APPROVE_EMPID FROM "
			+ ApplProperties.getDatasourceSchema()
			+ ".TIMESHEET WHERE EMPID = ? AND STATE = 'PENDING'";
	private static final String findApprovedString =
		"SELECT TIMESHEETID, WEEKEND, STATE, EMPID, APPROVE_EMPID FROM "
			+ ApplProperties.getDatasourceSchema()
			+ ".TIMESHEET WHERE EMPID = ? AND STATE = 'APPROVED'";
	private static final String findAllString =
		"SELECT TIMESHEETID, WEEKEND, STATE, EMPID, APPROVE_EMPID FROM " + ApplProperties.getDatasourceSchema() + ".TIMESHEET";
	private static final String findAllPendingString =
		"SELECT TIMESHEETID, WEEKEND, STATE, EMPID, APPROVE_EMPID FROM " + ApplProperties.getDatasourceSchema() + ".TIMESHEET WHERE STATE = 'PENDING'";
	private static final String findAllApprovedString =
		"SELECT TIMESHEETID, WEEKEND, STATE, EMPID, APPROVE_EMPID FROM " + ApplProperties.getDatasourceSchema() + ".TIMESHEET WHERE STATE = 'APPROVED'";
	protected static final String _maxKeyString = "SELECT MAX(TIMESHEETID) FROM " + ApplProperties.getDatasourceSchema() + ".TIMESHEET";

	private transient TimeSheetEntryMapper entryMapper;
	private transient EmployeeMapper empMapper;

	private TimeSheetEntryMapper getTimeSheetEntryMapper() {
		if (entryMapper == null)
			entryMapper = new TimeSheetEntryMapper();
		return entryMapper;
	}
	private EmployeeMapper getEmployeeMapper() {
		if (empMapper == null)
			empMapper = new EmployeeMapper();
		return empMapper;
	}
	/**
	 * Constructor for TimeSheetMapper
	 */
	public TimeSheetMapper() {
		super();
	}
	
	public TimeSheet addEntry(int id, TimeSheetEntry entry) throws NoSuchTimeSheetException {
		TimeSheetEntryMapper mapper = new TimeSheetEntryMapper();
		return mapper.addEntry(id, entry);
		
	}

	protected int generateNewId(Connection conn) {
		int id = 0;
		try {
			PreparedStatement getMaxKeyPS = conn.prepareStatement(_maxKeyString);
			ResultSet key = getMaxKeyPS.executeQuery();
			if (key.next()) {
				id = key.getInt(1) + 1;
			}
		} catch (SQLException se) {
		}
		return id;
	}
	/**
	 * @see JDBCMapper#updateImpl(Connection, TsObject)
	 */
	protected void updateImpl(Connection conn, TsObject anObject) throws SQLException, MappingException {
		TimeSheet ts = null;
		Calendar tsWeekend = null;
		int id = -1;
		if (anObject instanceof TimeSheet) {
			ts = (TimeSheet) anObject;
			tsWeekend = ts.getWeekend();
			id = ts.getTimesheetID();
		} else
			// update fails
			throw new MappingException("Update Failed " + anObject);
		PreparedStatement ps = conn.prepareStatement(_storeString);
		ps.setString(1, Formatter.dateFormat(tsWeekend));
		ps.setString(2, ts.getState().toString());
		if (ts.getApprovedBy() != null)
			ps.setString(3, ts.getApprovedBy().getId());
		else
			ps.setString(3, null);
		ps.setInt(4, id);
		int rows = ps.executeUpdate();
		if (rows == 1) {
			// now need to remove all entries and repopulate
			TimeSheetEntryMapper mapper = getTimeSheetEntryMapper();
			ArrayList previousEntries = mapper.findByTimesheetId(conn, id);
			if (previousEntries != null) {
				// something to remove
				ListIterator iter = previousEntries.listIterator();
				while (iter.hasNext()) {
					TimeSheetEntry entry = (TimeSheetEntry) iter.next();
					mapper.removeImpl(conn, entry);
				}
			}
			// now go and insert currentEntries.
			ArrayList currentEntries = ts.getEntries();
			if (currentEntries != null) {
				// something to remove
				ListIterator iter = currentEntries.listIterator();
				while (iter.hasNext()) {
					TimeSheetEntry entry = (TimeSheetEntry) iter.next();
					mapper.createImpl(conn, entry);
				}
			}
			return;
		} else
			// failed
			throw new MappingException("Update Failed " + anObject);

	}

	/**
	 * @see JDBCMapper#removeImpl(Connection, TsObject)
	 */
	protected void removeImpl(Connection conn, TsObject domainObject) throws SQLException, MappingException {
		TimeSheet ts = null;
		int id = -1;
		if (domainObject instanceof TimeSheet) {
			ts = (TimeSheet) domainObject;
			id = ts.getTimesheetID();
		} else
			throw new MappingException("Invalid Domain object supplied to TimeSheetMapper.remove");

		// first remove any entries
		TimeSheetEntryMapper mapper = getTimeSheetEntryMapper();
		ArrayList previousEntries = mapper.findByTimesheetId(conn, id);
		if (previousEntries != null) {
			// something to remove
			ListIterator iter = previousEntries.listIterator();
			while (iter.hasNext()) {
				TimeSheetEntry entry = (TimeSheetEntry) iter.next();
				mapper.removeImpl(conn, entry);
			}
		}
		
		// now remove TimeSheet entry itself
		PreparedStatement ps = conn.prepareStatement(_removeString);
		ps.setInt(1, id);
		ps.executeUpdate();
	}

	/**
	 * @see JDBCMapper#findByPrimaryKeyImpl(Connection, TsObject)
	 */
	protected TsObject findByPrimaryKeyImpl(Connection conn, TsObject domainObjectWithKeyValues) throws SQLException, MappingException {
		TimeSheet ts = null;
		int tsId = -1;
		if (domainObjectWithKeyValues instanceof TimeSheet) {
			tsId = ((TimeSheet) domainObjectWithKeyValues).getTimesheetID();
		} else
			return null;
		PreparedStatement ps = conn.prepareStatement(_loadString);
		ps.setInt(1, tsId);
		ResultSet rs = ps.executeQuery();
		rs.next();
		ts = activate(conn, rs);
		return ts;
	}

	/**
	 * @see JDBCMapper#createImpl(Connection, TsObject)
	 */
	protected Object createImpl(Connection conn, TsObject domainObject) throws SQLException, DuplicateKeyException {
		int tsId = 0;
		Calendar weekend = null;
		TimeSheet ts = null;
		if (domainObject instanceof TimeSheet) {
			ts = (TimeSheet) domainObject;
			weekend = ts.getWeekend();
		} else
			// update fails
			throw new DuplicateKeyException("Create Failed " + domainObject);
		tsId = generateNewId(conn);
		PreparedStatement ps = conn.prepareStatement(_createString);
		ps.setInt(1, tsId);
		ps.setString(2, Formatter.dateFormat(weekend));
		ps.setString(3, ts.getState().toString());
		ps.setString(4, ts.getEmployee().getId());
		if (ts.getApprovedBy() != null)
			ps.setString(5, ts.getApprovedBy().getId());
		else
			ps.setString(5, null);
		int rows = ps.executeUpdate();
		if (rows == 1) {
			ts.setTimesheetID(tsId);
			// now go and create the corresponding entries
			ArrayList entries = ts.getEntries();
			if (entries != null) {
				TimeSheetEntryMapper mapper = getTimeSheetEntryMapper();
				ListIterator iter = entries.listIterator();
				while (iter.hasNext()) {
					TimeSheetEntry entry = (TimeSheetEntry) iter.next();
					mapper.createImpl(conn, entry);
				}
			}
			return domainObject;
		} else
			// failed
			throw new DuplicateKeyException("Create Failed " + domainObject);
	}

	/**
	 * @see Mapper#insert(TsObject)
	 */
	public void insert(TsObject anObject) throws DuplicateKeyException {
		Connection conn = null;
		try {
			conn = getConnection();
			createImpl(conn, anObject);
			return;
		} catch (SQLException se) {
			throw new DuplicateKeyException(se, ("Insert Failed " + anObject));
		} finally {
			close(conn);
		}
	}

	/**
	 * @see Mapper#findAll()
	 */
	public ArrayList findAll() {
		ArrayList result = new ArrayList();
		Connection conn = null;
		try {
			conn = getConnection();
			TimeSheet ts = null;
			PreparedStatement ps = conn.prepareStatement(findAllString);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				ts = activate(conn, rs);
				result.add(ts);
			}
		} catch (SQLException se) {
		} finally {
			close(conn);
		}
		return result;
	}

	public ArrayList findForEmployee(String empId) {
		ArrayList result = new ArrayList();
		Connection conn = null;
		try {
			conn = getConnection();
			TimeSheet ts = null;
			PreparedStatement ps = conn.prepareStatement(findForEmployeeString);
			ps.setString(1, empId);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				ts = activate(conn, rs);
				result.add(ts);
			}
		} catch (SQLException se) {
		} finally {
			close(conn);
		}
		return result;
	}

	public ArrayList findPendingForEmployee(String empId) {
		ArrayList result = new ArrayList();
		Connection conn = null;
		try {
			conn = getConnection();
			TimeSheet ts = null;
			PreparedStatement ps = conn.prepareStatement(findPendingString);
			ps.setString(1, empId);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				ts = activate(conn, rs);
				result.add(ts);
			}
		} catch (SQLException se) {
		} finally {
			close(conn);
		}
		return result;
	}

	public ArrayList findApprovedForEmployee(String empId) {
		ArrayList result = new ArrayList();
		Connection conn = null;
		try {
			conn = getConnection();
			TimeSheet ts = null;
			PreparedStatement ps = conn.prepareStatement(findApprovedString);
			ps.setString(1, empId);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				ts = activate(conn, rs);
				result.add(ts);
			}
		} catch (SQLException se) {
		} finally {
			close(conn);
		}
		return result;
	}

	public ArrayList findAllPending() {
		ArrayList result = new ArrayList();
		Connection conn = null;
		try {
			conn = getConnection();
			TimeSheet ts = null;
			PreparedStatement ps = conn.prepareStatement(findAllPendingString);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				ts = activate(conn, rs);
				result.add(ts);
			}
		} catch (SQLException se) {
		} finally {
			close(conn);
		}
		return result;
	}

	public ArrayList findAllApproved() {
		ArrayList result = new ArrayList();
		Connection conn = null;
		try {
			conn = getConnection();
			TimeSheet ts = null;
			PreparedStatement ps = conn.prepareStatement(findAllApprovedString);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				ts = activate(conn, rs);
				result.add(ts);
			}
		} catch (SQLException se) {
		} finally {
			close(conn);
		}
		return result;
	}

	public TimeSheet findByKey(String empId, String weekEnding) {
		Connection conn = null;
		try {
			conn = getConnection();
			PreparedStatement ps = conn.prepareStatement(findByKeyString);
			ps.setString(1, empId);
			ps.setString(2, weekEnding);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				return activate(conn, rs);
			}
		} catch (SQLException se) {
		} finally {
			close(conn);
		}
		return null;
	}
	// TIMESHEETID, WEEKEND, STATE, EMPID, APPROVE_EMPID
	private TimeSheet activate(Connection conn, ResultSet rs) {
		TimeSheet ts = new TimeSheet();
		try {
			int tsId = rs.getInt(1);
			ts.setTimesheetID(tsId);
			ts.setWeekend(Formatter.convertToDate(rs.getString(2)));
			String state = rs.getString(3);
			if ("PENDING".equals(state.trim()))
				ts.setState(TimeSheetState.getPendingState());
			else
				ts.setState(TimeSheetState.getApprovedState());
			ArrayList tsEntries = getTimeSheetEntryMapper().findByTimesheetId(conn, tsId);
			ts.setEntries(tsEntries);
			String owner = rs.getString(4);
			String approver = rs.getString(5);
			if (owner != null)
				ts.setEmployee((Employee) getEmployeeMapper().findByPrimaryKeyImpl(conn, new Employee(owner)));
			if (approver != null)
				ts.setApprovedBy((Employee) getEmployeeMapper().findByPrimaryKeyImpl(conn, new Employee(approver)));
			return ts;
		} catch (Exception se) {
			AppService.log(TraceCapable.ERROR_LEVEL,"Failed to activate timesheet: exception - " + se);
			return null;
		}
	}
}
package com.wsbook.casestudy.mapping.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;

import com.wsbook.casestudy.domain.Project;
import com.wsbook.casestudy.domain.TimeSheet;
import com.wsbook.casestudy.domain.TimeSheetEntry;
import com.wsbook.casestudy.domain.TsObject;
import com.wsbook.casestudy.exception.DuplicateKeyException;
import com.wsbook.casestudy.exception.MappingException;
import com.wsbook.casestudy.exception.NoSuchObjectException;
import com.wsbook.casestudy.exception.NoSuchTimeSheetException;
import com.wsbook.casestudy.util.ApplProperties;
import com.wsbook.casestudy.util.Formatter;

public class TimeSheetEntryMapper
	extends JDBCMapper
	implements com.wsbook.casestudy.mapping.TimeSheetEntryMapper {

	protected static final String _createString =
		"INSERT INTO "
			+ ApplProperties.getDatasourceSchema()
			+ ".TIMESHEETENTRY (ENTRYID, DATE, HOURS, TIMESHEETID, PROJNO) VALUES (?, ?, ?, ?, ?)";
	protected static final String _removeString =
		"DELETE FROM "
			+ ApplProperties.getDatasourceSchema()
			+ ".TIMESHEETENTRY  WHERE ENTRYID = ?";
	protected static final String _storeString =
		"UPDATE "
			+ ApplProperties.getDatasourceSchema()
			+ ".TIMESHEETENTRY  SET DATE = ?, HOURS = ?, PROJNO = ? WHERE ENTRYID = ?";
	protected static final String _loadString =
		"SELECT ENTRYID, DATE, HOURS, TIMESHEETID, PROJNO FROM "
			+ ApplProperties.getDatasourceSchema()
			+ ".TIMESHEETENTRY  WHERE ENTRYID = ?";
	protected static final String findAllString =
		"SELECT ENTRYID, DATE, HOURS, TIMESHEETID, PROJNO FROM "
			+ ApplProperties.getDatasourceSchema()
			+ ".TIMESHEETENTRY";
	protected static final String findByTSString =
		"SELECT ENTRYID, DATE, HOURS, TIMESHEETID, PROJNO FROM "
			+ ApplProperties.getDatasourceSchema()
			+ ".TIMESHEETENTRY  WHERE TIMESHEETID = ?";
	private static final String _loadForUpdateString =
		_loadString + " FOR UPDATE";
	protected static final String _maxKeyString =
		"SELECT MAX(ENTRYID) FROM "
			+ ApplProperties.getDatasourceSchema()
			+ ".TIMESHEETENTRY";

	private transient ProjectMapper projectMapper = null;
	private transient TimeSheetMapper timeSheetMapper = null;
	/**
	 * Constructor for TimeSheetEntryMapper
	 */
	public TimeSheetEntryMapper() {
		super();
	}

	protected int generateNewId(Connection conn) {
		int id = 0;
		try {
			PreparedStatement getMaxKeyPS =
				conn.prepareStatement(_maxKeyString);
			ResultSet key = getMaxKeyPS.executeQuery();
			if (key.next()) {
				id = key.getInt(1) + 1;
			}
		} catch (SQLException se) {
		}
		return id;
	}

	private ProjectMapper getProjectMapper() {
		if (projectMapper == null)
			projectMapper = new ProjectMapper();
		return projectMapper;
	}

	private TimeSheetMapper getTimeSheetMapper() {
		if (timeSheetMapper == null)
			timeSheetMapper = new TimeSheetMapper();
		return timeSheetMapper;
	}

	/**
	 * @see JDBCMapper#updateImpl(Connection, TsObject)
	 */
	protected void updateImpl(Connection conn, TsObject domainObject)
		throws SQLException, MappingException {
		String tsDate = null, tsProjectNo = null;
		double tsHours = 0.0;
		int tsEntryId = 0, tsSheetId = 0;
		TimeSheetEntry entry = null;
		if (domainObject instanceof TimeSheetEntry) {
			entry = (TimeSheetEntry) domainObject;
			tsDate = entry.getFormattedDate();
			tsProjectNo = entry.getProject().getNumber();
			tsHours = entry.getHours();
			tsEntryId = entry.getTimeSheetEntryID();
			// not updating timesheet id;  that implies moving entry from one timesheet to another.
			//tsSheetId = ((TimeSheetEntry) domainObject).getTimeSheet().getTimesheetID();
		} else
			// update fails
			throw new MappingException("Update Failed " + domainObject);
		PreparedStatement ps = conn.prepareStatement(_storeString);
		ps.setInt(4, tsEntryId);
		ps.setDouble(2, tsHours);
		ps.setString(1, tsDate);
		//ps.setInt(4, tsSheetId);
		ps.setString(3, tsProjectNo);
		int rows = ps.executeUpdate();
		if (rows == 1)
			return;
		else
			// failed
			throw new MappingException("Update Failed " + domainObject);

	}

	/**
	 * @see JDBCMapper#removeImpl(Connection, TsObject)
	 */
	protected void removeImpl(Connection conn, TsObject domainObject)
		throws SQLException, MappingException {
		int tsEntryId = 0;
		if (domainObject instanceof TimeSheetEntry) {
			tsEntryId = ((TimeSheetEntry) domainObject).getTimeSheetEntryID();
		} else
			throw new MappingException("Removed Failed" + domainObject);
		PreparedStatement ps = conn.prepareStatement(_removeString);
		ps.setInt(1, tsEntryId);
		int rows = ps.executeUpdate();
		if (rows == 1)
			return;
		else
			// failed
			throw new MappingException("Remove Failed " + domainObject);
	}

	public ArrayList findByTimesheetId(Connection conn, int timesheetId)
		throws NoSuchTimeSheetException {
		ArrayList result = new ArrayList();
		TimeSheetEntry entry = null;
		try {
			PreparedStatement ps = conn.prepareStatement(findByTSString);
			ps.setInt(1, timesheetId);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				entry = activate(conn, rs);
				result.add(entry);
			}
		} catch (SQLException se) {
			throw new NoSuchTimeSheetException(
				se, ("Can't retrieve entries for TS = " + timesheetId));
		}
		return result;
	}

	/**
	 * @see JDBCMapper#findByPrimaryKeyImpl(Connection, TsObject)
	 */
	protected TsObject findByPrimaryKeyImpl(
		Connection conn,
		TsObject domainObjectWithKeyValues)
		throws SQLException, MappingException {
		TimeSheetEntry entry = null;
		int tsEntryId = 0;
		if (domainObjectWithKeyValues instanceof TimeSheetEntry) {
			tsEntryId =
				((TimeSheetEntry) domainObjectWithKeyValues)
					.getTimeSheetEntryID();
		} else
			return null;
		PreparedStatement ps = conn.prepareStatement(_loadString);
		ps.setInt(1, tsEntryId);
		ResultSet rs = ps.executeQuery();
		rs.next();
		entry = activate(conn, rs);
		return entry;
	}

	/**
	 * @see JDBCMapper#createImpl(Connection, TsObject)
	 */
	//	protected static final String _createString =
	//		"INSERT INTO " + ApplProperties.getDatasourceSchema() + ".TIMESHEETENTRY (ENTRYID, DATE, HOURS, TIMESHEETID, PROJNO) VALUES (?, ?, ?, ?, ?)";

	protected Object createImpl(Connection conn, TsObject domainObject)
		throws SQLException, DuplicateKeyException {
		int tsId = 0;
		TimeSheet ts = null;
		TimeSheetEntry entry = null;
		if (domainObject instanceof TimeSheetEntry) {
			entry = (TimeSheetEntry) domainObject;
			ts = entry.getTimeSheet();
			if (ts != null)
				tsId = ts.getTimesheetID();
			return createHelper(conn, entry, tsId);
		} else
			// update fails
			throw new DuplicateKeyException("Create Failed " + domainObject);
	}

	protected TimeSheetEntry createHelper(
		Connection conn,
		TimeSheetEntry entry,
		int tsId)
		throws SQLException, DuplicateKeyException {
		String projectId = null;
		Project project = null;
		Calendar entryDate = null;
		double hours = 0.0;
		int id = 0;

		project = entry.getProject();
		if (project != null)
			projectId = project.getNumber();
		entryDate = entry.getDate();
		hours = entry.getHours();

		id = generateNewId(conn);

		PreparedStatement ps = conn.prepareStatement(_createString);
		ps.setInt(1, id);
		ps.setString(2, Formatter.dateFormat(entryDate));
		ps.setDouble(3, hours);
		ps.setInt(4, tsId);
		ps.setString(5, projectId);
		int rows = ps.executeUpdate();
		if (rows == 1) {
			entry.setTimeSheetEntryID(id);
			return entry;
		} else
			// failed
			throw new DuplicateKeyException("Create Failed " + entry);
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
			TimeSheetEntry tse = null;
			PreparedStatement ps = conn.prepareStatement(findAllString);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				tse = activate(conn, rs);
				result.add(tse);
			}
		} catch (SQLException se) {
		} finally {
			close(conn);
		}
		return result;
	}

	public TimeSheet removeByKey(int timesheetId, int entryId)
		throws NoSuchTimeSheetException {
		Connection conn = null;
		try {
			conn = getConnection();
			TimeSheetEntry entry = new TimeSheetEntry();
			entry.setTimeSheetEntryID(entryId);
			removeImpl(conn, entry);
		} catch (MappingException me) {
			throw new NoSuchTimeSheetException(me, "no such entry");
		} catch (SQLException se) {
			throw new NoSuchTimeSheetException(se, "no such entry");
		} finally {
			close(conn);
		}
		return null;
	}

	// This is supposed to return the enclosing TimeSheet object
	// insert first.  Then return findByPrimaryKey for TimeSheet.
	public TimeSheet addEntry(int timesheetId, TimeSheetEntry entry)
		throws NoSuchTimeSheetException {
		Connection conn = null;
		try {
			conn = getConnection();
			createHelper(conn, entry, timesheetId);

			// now go and retrieve timesheet.
			TimeSheetMapper mapper = getTimeSheetMapper();
			TimeSheet ts = new TimeSheet();
			ts.setTimesheetID(timesheetId);
			return (TimeSheet) mapper.findByPrimaryKey(ts);
		} catch (SQLException se) {
			throw new NoSuchTimeSheetException(se, ("addEntry failed" + entry));
		} catch (DuplicateKeyException de) {
			throw new NoSuchTimeSheetException(de, ("addEntry failed" + entry));
		} catch (NoSuchObjectException ne) {
			throw new NoSuchTimeSheetException(ne, ("addEntry failed" + entry));

		} finally {
			close(conn);
		}
	}

	// Not going to instantiate TimeSheet.   Assume activation occurs
	// in scope of retrieving a containing TimeSheet.
	protected TimeSheetEntry activate(Connection conn, ResultSet rs)
		throws SQLException {
		TimeSheetEntry entry = new TimeSheetEntry();
		entry.setTimeSheetEntryID(rs.getInt(1));
		entry.setDate(Formatter.convertToDate(rs.getString(2)));
		entry.setHours(rs.getDouble(3));
		Project project = getProjectMapper().findById(conn, rs.getString(5));
		entry.setProject(project);
		return entry;

	}

}
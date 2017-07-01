package com.wsbook.casestudy.mapping.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.wsbook.casestudy.domain.Department;
import com.wsbook.casestudy.domain.TsObject;
import com.wsbook.casestudy.exception.DuplicateKeyException;
import com.wsbook.casestudy.exception.MappingException;
import com.wsbook.casestudy.util.ApplProperties;

public class DepartmentMapper extends JDBCMapper {

	protected static final String _createString =
		"INSERT INTO "
			+ ApplProperties.getDatasourceSchema()
			+ ".DEPARTMENT (DEPTNUMBER, NAME) VALUES (?, ?)";
	protected static final String _removeString =
		"DELETE FROM "
			+ ApplProperties.getDatasourceSchema()
			+ ".DEPARTMENT  WHERE DEPTNUMBER = ?";
	protected static final String _storeString =
		"UPDATE "
			+ ApplProperties.getDatasourceSchema()
			+ ".DEPARTMENT  SET NAME = ? WHERE DEPTNUMBER = ?";
	protected static final String _loadString =
		"SELECT DEPTNUMBER, NAME FROM "
			+ ApplProperties.getDatasourceSchema()
			+ ".DEPARTMENT WHERE DEPTNUMBER = ?";
	protected static final String _findAllString =
		"SELECT DEPTNUMBER, NAME FROM "
			+ ApplProperties.getDatasourceSchema()
			+ ".DEPARTMENT";
	private static final String _loadForUpdateString =
		_loadString + " FOR UPDATE";

	public DepartmentMapper() {
		super();
	}

	/**
	 * @see JDBCMapper#updateImpl(Connection, TsObject)
	 */
	protected void updateImpl(Connection conn, TsObject domainObject)
		throws SQLException, MappingException {
		int deptId = 0;
		String deptName = null;
		if (domainObject instanceof Department) {
			deptId = ((Department) domainObject).getNumber();
			deptName = ((Department) domainObject).getName();
		} else
			// update fails
			throw new MappingException("Update Failed " + domainObject);
		PreparedStatement ps = conn.prepareStatement(_storeString);
		ps.setString(1, deptName);
		ps.setInt(2, deptId);
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
		int deptId = 0;
		if (domainObject instanceof Department) {
			deptId = ((Department) domainObject).getNumber();
		} else
			throw new MappingException("Removed Failed" + domainObject);
		PreparedStatement ps = conn.prepareStatement(_removeString);
		ps.setInt(1, deptId);
		int rows = ps.executeUpdate();
		if (rows == 1)
			return;
		else
			// failed
			throw new MappingException("Remove Failed " + domainObject);

	}

	/**
	 * @see JDBCMapper#findByPrimaryKeyImpl(Connection, TsObject)
	 */
	protected TsObject findByPrimaryKeyImpl(
		Connection conn,
		TsObject domainObjectWithKeyValues)
		throws SQLException, MappingException {
		Department dept = null;
		int deptId = 0;
		if (domainObjectWithKeyValues instanceof Department) {
			deptId = ((Department) domainObjectWithKeyValues).getNumber();
		} else
			return null;
		PreparedStatement ps = conn.prepareStatement(_loadString);
		ps.setInt(1, deptId);
		ResultSet rs = ps.executeQuery();
		rs.next();
		dept = activate(rs);
		return dept;
	}

	/**
	 * @see JDBCMapper#createImpl(Connection, TsObject)
	 */
	protected Object createImpl(Connection conn, TsObject domainObject)
		throws SQLException, DuplicateKeyException {
		int deptId = 0;
		String deptName = null;
		if (domainObject instanceof Department) {
			deptId = ((Department) domainObject).getNumber();
			deptName = ((Department) domainObject).getName();
		} else
			// update fails
			throw new DuplicateKeyException("Create Failed " + domainObject);
		PreparedStatement ps = conn.prepareStatement(_createString);
		ps.setInt(1, deptId);
		ps.setString(2, deptName);
		int rows = ps.executeUpdate();
		if (rows == 1)
			return domainObject;
		else
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
		ArrayList list = new ArrayList();
		Department dept = null;
		Connection conn = null;
		try {
			conn = getConnection();
			PreparedStatement ps = conn.prepareStatement(_findAllString);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				dept = activate(rs);
				list.add(dept);
			}
			return list;
		} catch (SQLException se) {
			return null;
		} finally {
			close(conn);
		}
	}

	protected Department activate(ResultSet rs) throws SQLException {
		Department dept = new Department();
		dept.setNumber(rs.getInt(1));
		dept.setName(rs.getString(2));
		return dept;
	}

}

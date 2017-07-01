package com.wsbook.casestudy.mapping.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.wsbook.casestudy.domain.Project;
import com.wsbook.casestudy.domain.TsObject;
import com.wsbook.casestudy.exception.DuplicateKeyException;
import com.wsbook.casestudy.exception.MappingException;
import com.wsbook.casestudy.util.ApplProperties;

public class ProjectMapper
	extends JDBCMapper
	implements com.wsbook.casestudy.mapping.ProjectMapper {

	protected static final String _createString =
		"INSERT INTO "
			+ ApplProperties.getDatasourceSchema()
			+ ".PROJECT (PROJNO, NAME) VALUES (?, ?)";
	protected static final String _removeString =
		"DELETE FROM "
			+ ApplProperties.getDatasourceSchema()
			+ ".PROJECT  WHERE PROJNO = ?";
	protected static final String _storeString =
		"UPDATE "
			+ ApplProperties.getDatasourceSchema()
			+ ".PROJECT  SET NAME = ? WHERE PROJNO = ?";
	protected static final String _loadString =
		"SELECT NAME, PROJNO FROM "
			+ ApplProperties.getDatasourceSchema()
			+ ".PROJECT WHERE PROJNO = ?";
	protected static final String _loadForUpdateString =
		_loadString + " FOR UPDATE";
	protected static final String findByNameSqlString =
		"SELECT NAME, PROJNO FROM "
			+ ApplProperties.getDatasourceSchema()
			+ ".PROJECT WHERE NAME = ?";
	protected static final String findAllSqlString =
		"SELECT NAME, PROJNO FROM "
			+ ApplProperties.getDatasourceSchema()
			+ ".PROJECT";

	/**
	 * Constructor for ProjectMapper
	 */
	public ProjectMapper() {
		super();
	}

	/**
	 * @see JDBCMapper#updateImpl(Connection, TsObject)
	 */
	protected void updateImpl(Connection conn, TsObject domainObject)
		throws SQLException, MappingException {
		String projectId = null, projectName = null;
		if (domainObject instanceof Project) {
			projectId = ((Project) domainObject).getNumber();
			projectName = ((Project) domainObject).getName();
		} else
			// update fails
			throw new MappingException("Update Failed " + domainObject);
		PreparedStatement ps = conn.prepareStatement(_storeString);
		ps.setString(1, projectName);
		ps.setString(2, projectId);
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
		String projectId = null;
		if (domainObject instanceof Project) {
			projectId = ((Project) domainObject).getNumber();
		} else
			throw new MappingException("Removed Failed" + domainObject);
		PreparedStatement ps = conn.prepareStatement(_removeString);
		ps.setString(1, projectId);
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
		Project proj = null;
		String projectId = null;
		if (domainObjectWithKeyValues instanceof Project) {
			projectId = ((Project) domainObjectWithKeyValues).getNumber();
		} else
			return null;
		PreparedStatement ps = conn.prepareStatement(_loadString);
		ps.setString(1, projectId);
		ResultSet rs = ps.executeQuery();
		rs.next();
		proj = activate(rs);
		return proj;
	}

	/**
	 * @see JDBCMapper#createImpl(Connection, TsObject)
	 */
	protected Object createImpl(Connection conn, TsObject domainObject)
		throws SQLException, DuplicateKeyException {
		String projectId = null, projectName = null;
		if (domainObject instanceof Project) {
			projectId = ((Project) domainObject).getNumber();
			projectName = ((Project) domainObject).getName();
		} else
			// update fails
			throw new DuplicateKeyException("Create Failed " + domainObject);
		PreparedStatement ps = conn.prepareStatement(_createString);
		ps.setString(1, projectId);
		ps.setString(2, projectName);
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
		Project proj = null;
		Connection conn = null;
		try {
			conn = getConnection();
			PreparedStatement ps = conn.prepareStatement(findAllSqlString);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				proj = activate(rs);
				list.add(proj);
			}
			return list;
		} catch (SQLException se) {
			return null;
		} finally {
			close(conn);
		}
	}

	public Project findByName(String projectName) {
		Project proj = null;
		Connection conn = null;
		try {
			conn = getConnection();
			PreparedStatement ps = conn.prepareStatement(findByNameSqlString);
			ps.setString(1, projectName);
			ResultSet rs = ps.executeQuery();
			rs.next();
			proj = activate(rs);
			return proj;
		} catch (SQLException se) {
			return null;
		} finally {
			close(conn);
		}
	}

	public Project findById(String projectId) {
		Project proj = null;
		Connection conn = null;
		try {
			conn = getConnection();
			return findById(conn, projectId);
		} catch (SQLException se) {
			return null;
		} finally {
			close(conn);
		}
	}

	public Project findById(Connection conn, String projectId)
		throws SQLException {
		PreparedStatement ps = conn.prepareStatement(_loadString);
		ps.setString(1, projectId);
		ResultSet rs = ps.executeQuery();
		rs.next();
		return activate(rs);
	}

	protected Project activate(ResultSet rs) throws SQLException {
		Project proj = new Project();
		proj.setName(rs.getString(1));
		proj.setNumber(rs.getString(2));
		return proj;
	}

}
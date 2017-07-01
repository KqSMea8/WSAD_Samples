package com.wsbook.acme.mappers;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;

import com.wsbook.mapping.ApplicationProperties;
import com.wsbook.mapping.DomainObject;
import com.wsbook.mapping.DuplicateKeyException;
import com.wsbook.mapping.MappingException;
import com.wsbook.mapping.UnitOfWork;
import com.wsbook.acme.Department;
import com.wsbook.acme.Employee;
import com.wsbook.acme.Personnel;
import com.wsbook.acme.Purchasing;
import com.wsbook.mapping.jdbc.JDBCMapper;

/**
 * @author jamsden
 *
 * To change this generated comment edit the template variable "typecomment":
 * Window>Preferences>Java>Templates.
 * To enable and disable the creation of type comments go to
 * Window>Preferences>Java>Code Generation.
 */
public class DepartmentMapper extends JDBCMapper {

	static final String authId = ApplicationProperties.getDatasourceSchemaName();

	public static final int DEPARTMENT = 0;
	public static final int PERSONNEL  = 1;
	public static final int PURCHASING = 2;
	
	
	protected static final String _createString =
		"INSERT INTO "+authId+".DEPARTMENT "+
		"(ID, NAME, DESCRIPTION, CODE, EXTERNALBUDGET, TYPE)"+
		"VALUES (?, ?, ?, ?, ?, ?)";
				
	protected static final String _readString =
		"SELECT ID, NAME, DESCRIPTION, CODE, EXTERNALBUDGET, TYPE FROM "+ authId+ ".DEPARTMENT " +
		"WHERE ID = ?";
			
	protected static final String _findAllString =
		"SELECT ID, NAME, DESCRIPTION, CODE, EXTERNALBUDGET, TYPE  FROM "+authId+".DEPARTMENT ";

	protected static final String _updateString =
		"UPDATE "+ authId+".DEPARTMENT "+
		"SET ID=?, NAME=?, DESCRIPTION=?, CODE=?, EXTERNALBUDGET=? TYPE=?"+
		"WHERE ID = ?";

	protected static final String _deleteString =
		"DELETE FROM "+authId+".DEPARTMENT  WHERE ID = ?";

	/**
	 * @see com.wsbook.mapping.jdbc.JDBCMapper#activate(ResultSet)
	 */
	protected DomainObject activate(ResultSet rs) {
		try {
			Integer id = new Integer(rs.getInt(1));
			UnitOfWork current = UnitOfWork.getCurrent();
			if (current.containsID(id)) return current.getLoaded(id);
			Department dept = null;
			int type = rs.getInt(6);
			switch (type) {
				case DepartmentMapper.DEPARTMENT: {
					dept = new Department(id.intValue()); 
					break;
				}
				case DepartmentMapper.PERSONNEL: {
					dept = new Personnel(id.intValue()); 
					break;
				}
				case DepartmentMapper.PURCHASING: {
					dept = new Purchasing(id.intValue()); 
					break;
				}
			}
			doActivate(dept, rs);
			dept.markUnchanged();
			return dept;
		} catch (SQLException se) {
			return null;
		} catch (MappingException me) {
			return null;
		}
	}
	
	protected void doActivate(DomainObject domainObject, ResultSet rs) 
		throws SQLException, MappingException {
		Department dept = (Department)domainObject;
		dept.setName(rs.getString(2));
		dept.setDescription(rs.getString(3));
	}

	/**
	 * @see com.wsbook.mapping.jdbc.JDBCMapper#createImpl(Connection, DomainObject)
	 */
	protected void createImpl(Connection conn, DomainObject domainObject)
		throws SQLException, MappingException {
		PreparedStatement ps = conn.prepareStatement(_createString);
		passivate(domainObject,ps);
		int rows = ps.executeUpdate();
		if (rows != 1) {
			throw new DuplicateKeyException("Create Failed " + domainObject);
		}
	}
	
	protected void passivate(DomainObject domainObject, PreparedStatement ps) 
		throws SQLException, MappingException {
		if (!(domainObject instanceof Department)) throw new MappingException("Expecting a Department");
		Department dept = (Department)domainObject;
		ps.setInt(1, dept.getId());
		ps.setString(2, dept.getName());
		ps.setString(3, dept.getDescription());
		ps.setNull(4, Types.VARCHAR);
		ps.setNull(5, Types.FLOAT);
		ps.setInt(6, DepartmentMapper.DEPARTMENT);
	}
	
	protected String getFindAllString() {
		return _findAllString;
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
			PreparedStatement ps = conn.prepareStatement(getFindAllString());
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				dept = (Department)activate(rs);
				list.add(dept);
			}
			return list;
		} catch (SQLException se) {
			se.printStackTrace();
			return null;
		} finally {
			close(conn);
		}
	}

	/**
	 * @see com.wsbook.mapping.jdbc.JDBCMapper#findByPrimaryKeyImpl(Connection, Object)
	 */
	protected DomainObject findByPrimaryKeyImpl(Connection conn, Object id)
		throws SQLException, MappingException {
		PreparedStatement ps = conn.prepareStatement(_readString);
		ps.setInt(1, ((Integer)id).intValue());
		ResultSet rs = ps.executeQuery();
		rs.next();
		return activate(rs);
	}

	/**
	 * @see com.wsbook.mapping.jdbc.JDBCMapper#updateImpl(Connection, DomainObject)
	 */
	protected void updateImpl(Connection conn, DomainObject anObject)
		throws SQLException, MappingException {
		if (!(anObject instanceof Department)) throw new MappingException("Update Failed " + anObject);
		PreparedStatement ps = conn.prepareStatement(_updateString);
		passivate(anObject, ps);
		ps.setInt(7, ((Integer)anObject.getID()).intValue());
		int rows = ps.executeUpdate();
		if (rows != 1) throw new MappingException("Update Failed " + anObject);
	}

	/**
	 * @see com.wsbook.mapping.jdbc.JDBCMapper#deleteImpl(Connection, DomainObject)
	 */
	protected void deleteImpl(Connection conn, DomainObject domainObject)
		throws SQLException, MappingException {
		if (!(domainObject instanceof Department)) throw new MappingException("Delete Failed " + domainObject);
		Department dept = (Department)domainObject;
		PreparedStatement ps = conn.prepareStatement(_deleteString);
		ps.setInt(1, dept.getId());
		int rows = ps.executeUpdate();
		if (rows != 1) throw new MappingException("Remove Failed " + domainObject);
	}
}

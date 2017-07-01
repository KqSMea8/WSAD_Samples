package com.wsbook.acme.mappers;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.Collection;

import com.wsbook.mapping.ApplicationProperties;
import com.wsbook.mapping.DomainObject;
import com.wsbook.mapping.DuplicateKeyException;
import com.wsbook.mapping.MappingException;
import com.wsbook.mapping.UnitOfWork;
import com.wsbook.acme.Address;
import com.wsbook.acme.Department;
import com.wsbook.acme.Employee;
import com.wsbook.mapping.jdbc.JDBCMapper;

public class EmployeeMapper extends JDBCMapper {
	static final String authId = ApplicationProperties.getDatasourceSchemaName();
	
	protected static final String _createString =
		"INSERT INTO "+authId+".EMPLOYEE "+
		"(ID, NAME, AGE, STREET, CITY, STATE, ZIP, DEPTID)"+
		"VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
		
	protected static final String _readString =
		"SELECT ID, NAME, AGE, STREET, CITY, STATE, ZIP, DEPTID FROM "+ authId+ ".EMPLOYEE " +
		"WHERE ID = ?";
			
	protected static final String _findAllString =
		"SELECT ID, NAME, AGE, STREET, CITY, STATE, ZIP, DEPTID  FROM "+authId+".EMPLOYEE ";

	protected static final String _updateString =
		"UPDATE "+ authId+".EMPLOYEE "+
		"SET ID=?, NAME=?, AGE=?, STREET=?, CITY=?, STATE=?, ZIP=?, DEPTID=?"+
		"WHERE ID = ?";

	protected static final String _deleteString =
		"DELETE FROM "+authId+".EMPLOYEE  WHERE ID = ?";

	public EmployeeMapper() {
		super();
	}

	/**
	 * @see JDBCMapper#createImpl(Connection, Object)
	 */
	protected void createImpl(Connection conn, DomainObject domainObject) throws SQLException, DuplicateKeyException, MappingException {
		if (!(domainObject instanceof Employee)) throw new MappingException("Expecting an Employee");
		Employee emp = (Employee)domainObject;
		PreparedStatement ps = conn.prepareStatement(_createString);
		passivate(emp, ps);
		int rows = ps.executeUpdate();
		if (rows != 1) {
			throw new DuplicateKeyException("Create Failed " + domainObject);
		}
	}

	/**
	 * @see Mapper#findAll()
	 */
	public ArrayList findAll() {
		ArrayList list = new ArrayList();
		Employee emp = null;
		Connection conn = null;
		try {
			conn = getConnection();
			PreparedStatement ps = conn.prepareStatement(_findAllString);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				emp = (Employee)activate(rs);
				list.add(emp);
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
	 * @see JDBCMapper#findByPrimaryKeyImpl(Connection, Object)
	 */
	protected DomainObject findByPrimaryKeyImpl(Connection conn, Object id) throws SQLException, MappingException {
		PreparedStatement ps = conn.prepareStatement(_readString);
		ps.setString(1, (String)id);
		ResultSet rs = ps.executeQuery();
		rs.next();
		return activate(rs);
	}

	protected static final String _findByDepartmentQuery =
		"SELECT ID, NAME, AGE, STREET, CITY, STATE, ZIP, DEPTID FROM "+ authId+ ".EMPLOYEE " +
		"WHERE DEPTID = ?";
			
	public Collection findByDepartment(Department department) {
		ArrayList list = new ArrayList();
		Employee emp = null;
		Connection conn = null;
		try {
			conn = getConnection();
			PreparedStatement ps = conn.prepareStatement(_findByDepartmentQuery);
			ps.setInt(1, department.getId());
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				emp = (Employee)activate(rs);
				list.add(emp);
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
	 * @see JDBCMapper#updateImpl(Connection, Object)
	 * Note we are not updating Address information right now.
	 */
	protected void updateImpl(Connection conn, DomainObject domainObject) throws SQLException, MappingException {
		if (!(domainObject instanceof Employee)) throw new MappingException("Update Failed " + domainObject);
		Employee emp = (Employee)domainObject;
		PreparedStatement ps = conn.prepareStatement(_updateString);
		passivate(emp, ps);
		ps.setString(9, (String)emp.getID());
		int rows = ps.executeUpdate();
		if (rows != 1) throw new MappingException("Update Failed " + domainObject);
	}

	/**
	 * @see JDBCMapper#removeImpl(Connection, Object)
	 */
	protected void deleteImpl(Connection conn, DomainObject domainObject) throws SQLException, MappingException {
		if (!(domainObject instanceof Employee)) throw new MappingException("Delete Failed " + domainObject);
		Employee emp = (Employee)domainObject;
		PreparedStatement ps = conn.prepareStatement(_deleteString);
		ps.setString(1, emp.getId());
		int rows = ps.executeUpdate();
		if (rows != 1) throw new MappingException("Remove Failed " + domainObject);
	}

	/** activate Object from ResultSet **/
	protected DomainObject activate(ResultSet rs) {
		try {
			String id = rs.getString(1);
			UnitOfWork current = UnitOfWork.getCurrent();
			if (current.containsID(id)) return current.getLoaded(id);
			Employee emp = new Employee(id);
			doActivate(emp, rs);
			emp.markUnchanged();
			return emp;
		} catch (SQLException se) {
			return null;
		} catch (MappingException me) {
			return null;
		}
	}
	
	protected void doActivate(DomainObject domainObject, ResultSet rs) 
		throws SQLException, MappingException {
		Employee emp = (Employee)domainObject;
		emp.setName(rs.getString(2));
		emp.setAge(rs.getInt(3));
		emp.setAddress(new Address(emp));
		emp.getAddress().setStreet(rs.getString(4));
		emp.getAddress().setCity(rs.getString(5));
		emp.getAddress().setState(rs.getString(6));
		emp.getAddress().setZip(rs.getString(7));
		int deptId = rs.getInt(8);
		if (deptId != 0) {
			Department dept = new Department(rs.getInt(8));
			dept.setIsGhost(true);
			emp.setDepartment(dept);
		}
	}	

	protected void passivate(DomainObject domainObject, PreparedStatement ps) 
		throws SQLException, MappingException {
		Employee emp = (Employee)domainObject;
		ps.setString(1, emp.getId());
		ps.setString(2, emp.getName());
		ps.setInt(3, emp.getAge());
		if (emp.getAddress() != null) {
			ps.setString(4, emp.getAddress().getStreet());
			ps.setString(5, emp.getAddress().getCity());
			ps.setString(6, emp.getAddress().getState());
			ps.setString(7, emp.getAddress().getZip());
		} else {
			ps.setNull(4, Types.CHAR);
			ps.setNull(5, Types.CHAR);
			ps.setNull(6, Types.CHAR);
			ps.setNull(7, Types.CHAR);
		}
		if (emp.getDepartment() != null) {
			ps.setInt(8, emp.getDepartment().getId());
		} else {
			ps.setNull(8, Types.INTEGER);
		}
	}	
}

package com.wsbook.casestudy.mapping.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.wsbook.casestudy.domain.Address;
import com.wsbook.casestudy.domain.Employee;
import com.wsbook.casestudy.domain.TsObject;
import com.wsbook.casestudy.exception.DuplicateKeyException;
import com.wsbook.casestudy.exception.MappingException;
import com.wsbook.casestudy.exception.NoSuchEmployeeException;
import com.wsbook.casestudy.system.AppService;
import com.wsbook.casestudy.system.TraceCapable;
import com.wsbook.casestudy.util.ApplProperties;

public class EmployeeMapper
	extends JDBCMapper
	implements com.wsbook.casestudy.mapping.EmployeeMapper {

	protected static final String _createString =
		"INSERT INTO "
			+ ApplProperties.getDatasourceSchema()
			+ ".EMPLOYEE (EMPID, NAME, ADDRESSKEY) VALUES (?, ?, ?)";
	protected static final String _removeString =
		"DELETE FROM "
			+ ApplProperties.getDatasourceSchema()
			+ ".EMPLOYEE  WHERE EMPID = ?";
	protected static final String _removeAddrString =
		"DELETE FROM "
			+ ApplProperties.getDatasourceSchema()
			+ ".ADDRESS  WHERE ADDRESSKEY = ?";
	protected static final String _storeString =
		"UPDATE "
			+ ApplProperties.getDatasourceSchema()
			+ ".EMPLOYEE SET NAME = ? WHERE EMPID = ?";
	protected static final String _updateAddressString =
		"UPDATE "
			+ ApplProperties.getDatasourceSchema()
			+ ".ADDRESS SET STREETADDRESS = ?, CITY = ?, STATE = ?, ZIPCODE = ? WHERE ADDRESSKEY = ?";
	protected static final String _loadString =
		"SELECT T1.EMPID, T1.NAME, T2.STREETADDRESS, T2.CITY, T2.STATE, T2.ZIPCODE, T2.ADDRESSKEY FROM "
			+ ApplProperties.getDatasourceSchema()
			+ ".EMPLOYEE T1, "
			+ ApplProperties.getDatasourceSchema()
			+ ".ADDRESS T2 WHERE EMPID = ? AND T1.ADDRESSKEY = T2.ADDRESSKEY";
	protected static final String _findAllString =
		"SELECT T1.EMPID, T1.NAME, T2.STREETADDRESS, T2.CITY, T2.STATE, T2.ZIPCODE, T2.ADDRESSKEY FROM "
			+ ApplProperties.getDatasourceSchema()
			+ ".EMPLOYEE  T1, "
			+ ApplProperties.getDatasourceSchema()
			+ ".ADDRESS  T2 WHERE T1.ADDRESSKEY = T2.ADDRESSKEY";
	private static final String _loadForUpdateString =
		_loadString + " FOR UPDATE";
	protected static final String _maxAddrKeyString =
		"SELECT MAX(ADDRESSKEY) FROM "
			+ ApplProperties.getDatasourceSchema()
			+ ".ADDRESS";
	protected static final String _createAddrString =
		"INSERT INTO "
			+ ApplProperties.getDatasourceSchema()
			+ ".ADDRESS (ADDRESSKEY, STREETADDRESS, CITY, STATE, ZIPCODE) VALUES (?, ?, ?, ?, ?)";

	public EmployeeMapper() {
		super();
	}

	/**
	 * @see JDBCMapper#updateImpl(Connection, TsObject)
	 * Note we are not updating Address information right now.
	 */
	protected void updateImpl(Connection conn, TsObject domainObject)
		throws SQLException, MappingException {
		String empId = null, empName = null;
		Address addr = null;
		int deptId = 0;
		int addressKey = 0;
		if (domainObject instanceof Employee) {
			empId = ((Employee) domainObject).getId();
			empName = ((Employee) domainObject).getName();
			addr = ((Employee) domainObject).getAddress();
			if (addr != null) {
				addressKey = addr.getKey();
			}
		} else
			// update fails
			throw new MappingException("Update Failed " + domainObject);
		PreparedStatement ps = conn.prepareStatement(_storeString);
		ps.setString(1, empName);
		//ps.setInt(3, addressKey);
		ps.setString(2, empId);
		int rows = ps.executeUpdate();
		if (rows == 1) {
			// now update Address entries
			ps = conn.prepareStatement(_updateAddressString);
			ps.setString(1, addr.getStreetAddress());
			ps.setString(2, addr.getCity());
			ps.setString(3, addr.getState());
			ps.setString(4, addr.getZip());
			ps.setInt(5, addressKey);
			rows = ps.executeUpdate();
			if (rows == 1)
				return;
		}
		// failed
		throw new MappingException("Update Failed " + domainObject);
	}

	/**
	 * @see JDBCMapper#removeImpl(Connection, TsObject)
	 */
	protected void removeImpl(Connection conn, TsObject domainObject)
		throws SQLException, MappingException {
		String empId = null;
		int addrKey = -1;
		Address addr = null;
		if (domainObject instanceof Employee) {
			empId = ((Employee) domainObject).getId();
			addr = ((Employee) domainObject).getAddress();
			if (addr != null)
				addrKey = addr.getKey();
		} else
			throw new MappingException("Removed Failed" + domainObject);
		PreparedStatement ps = conn.prepareStatement(_removeString);
		ps.setString(1, empId);
		int rows = ps.executeUpdate();
		if (rows == 1) {
			AppService.log(
				TraceCapable.ERROR_LEVEL,
				"Removing address with key = " + addrKey);
			ps = conn.prepareStatement(_removeAddrString);
			ps.setInt(1, addrKey);
			rows = ps.executeUpdate();
			return;
		} else
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
		Employee emp = null;
		String empId = null;
		if (domainObjectWithKeyValues instanceof Employee) {
			empId = ((Employee) domainObjectWithKeyValues).getId();
		} else
			return null;
		emp = findById(conn, empId);
		return emp;
	}

	protected Employee findById(Connection conn, String empId)
		throws java.sql.SQLException {
		Employee emp;
		PreparedStatement ps = conn.prepareStatement(_loadString);
		ps.setString(1, empId);
		ResultSet rs = ps.executeQuery();
		rs.next();
		emp = activate(rs);
		return emp;
	}

	public Employee findById(String empId) throws NoSuchEmployeeException {
		Connection conn = null;
		Employee emp = null;
		try {
			conn = getConnection();
			emp = findById(conn, empId);
			return emp;
		} catch (SQLException se) {
			throw new NoSuchEmployeeException(se, "SQL Exception caught in findById");
		} finally {
			close(conn);
		}
	}

	/**
	 * @see JDBCMapper#createImpl(Connection, TsObject)
	 */
	protected Object createImpl(Connection conn, TsObject domainObject)
		throws SQLException, DuplicateKeyException {
		String empId = null, empName = null;
		int deptId = 0;
		Address addr = null;
		int addressKey = 0;
		if (domainObject instanceof Employee) {
			empId = ((Employee) domainObject).getId();
			empName = ((Employee) domainObject).getName();
			addr = ((Employee) domainObject).getAddress();
		} else
			// update fails
			throw new DuplicateKeyException("Create Failed " + domainObject);
		if (addr != null) {
			// insert address, generate key
			PreparedStatement getMaxKeyPS =
				conn.prepareStatement(_maxAddrKeyString);
			ResultSet key = getMaxKeyPS.executeQuery();
			if (key.next()) {
				addressKey = key.getInt(1) + 1;
			}
			// initialize key for address
			addr.setKey(addressKey);

			PreparedStatement createAddress =
				conn.prepareStatement(_createAddrString);
			createAddress.setInt(1, addressKey);
			createAddress.setString(2, addr.getStreetAddress());
			createAddress.setString(3, addr.getCity());
			createAddress.setString(4, addr.getState());
			createAddress.setString(5, addr.getZip());
			int addr_row = createAddress.executeUpdate();
			if (addr_row != 1)
				throw new DuplicateKeyException(
					"Create Failed " + domainObject);
		}

		PreparedStatement ps = conn.prepareStatement(_createString);
		ps.setString(1, empId);
		ps.setString(2, empName);
		ps.setInt(3, addressKey);
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
		Employee emp = null;
		Connection conn = null;
		try {
			conn = getConnection();
			PreparedStatement ps = conn.prepareStatement(_findAllString);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				emp = activate(rs);
				list.add(emp);
			}
			return list;
		} catch (SQLException se) {
			return null;
		} finally {
			close(conn);
		}
	}

	/** activate TsObject from ResultSet **/
	protected Employee activate(ResultSet rs) throws SQLException {
		Employee emp = new Employee();
		Address addr = new Address();
		emp.setId(rs.getString(1));
		emp.setName(rs.getString(2));
		// map Address
		addr.setStreetAddress(rs.getString(3));
		addr.setCity(rs.getString(4));
		addr.setState(rs.getString(5));
		addr.setZip(rs.getString(6));
		addr.setKey(rs.getInt(7));
		emp.setAddress(addr);
		return emp;
	}

}
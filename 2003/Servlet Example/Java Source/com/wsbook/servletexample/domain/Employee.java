package com.wsbook.servletexample.domain;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.wsbook.servletexample.ApplicationProperties;
import com.wsbook.servletexample.exception.DuplicateKeyException;
import com.wsbook.servletexample.exception.MappingException;
import com.wsbook.servletexample.exception.NoSuchObjectException;

/**
 * This is an Employee domain object. This implementation follows
 * Martin Fowler's ActiveRecord pattern where the domain object
 * is responsible for managing its own persistence.
 */
public class Employee {
	private String id = "";
	private String name = "";
	private int age = 0;
	private String street = "";
	private String city = "";
	private String state = "";
	private String zip = "";

	/**
	 * Employee constructor.
	 */
	public Employee() {
		super();
	}
	public Employee(String id) {
		this.id = id;
	}
	
	/**
	 * Return true if anObject is equivalent to 
	 * this employee (i.e., has the same id).
	 */
	public boolean equals(Object anObject) {
		if (anObject == null) {
			return false;
		}
		if (!(anObject instanceof Employee)) {
			return false;
		}
		Employee anEmployee = (Employee) anObject;
		return anEmployee.getId().equals(getId());
	}

	/**
	 * Gets the employee id, an attribute that
	 * uniquely identifies an employee.
	 * @return The id property value.
	 * @see #setId
	 */
	public String getId() {
		return id;
	}

	/**
	 * Gets the employee name.
	 * @return The name property value.
	 * @see #setName
	 */
	public String getName() {
		return name;
	}

	/**
	 * Gets the employee's age
	 * @return the employee's age
	 * @see #setAge
	 */
	public int getAge() {
		return age;
	}

	/**
	 * Gets the employee's street address
	 * @return String
	 */
	public String getStreet() {
		return street;
	}

	/**
	 * Gets the employee's city
	 * @return the employe's city
	 */
	public String getCity() {
		return city;
	}

	/**
	 * Return the state
	 * @return the employee's state
	 */
	public String getState() {
		return state;
	}

	/**
	 * Return the zip code
	 * @return the employee's zip code
	 */
	public String getZip() {
		return zip;
	}

	/**
	 * Sets the employee's name
	 * @param value the new name
	 * @see #getName
	 */
	public void setName(String value) {
		name = value;
	}

	/**
	 * Sets employee's age
	 * @param value the employee's age
	 * @see #getAge
	 */
	public void setAge(int value) {
		age = value;
	}

	/**
	 * Set the street address
	 * @param value the new street address
	 */
	public void setStreet(String value) {
		street = value;
	}

	/**
	 * Set the city
	 * @param value the new city
	 */
	public void setCity(String value) {
		city = value;
	}

	/**
	 * Set the State
	 * @param value the new state
	 */
	public void setState(String value) {
		state = value;
	}

	/**
	 * Set the zip code
	 * @param value the new zip code
	 */
	public void setZip(String value) {
		zip = value;
	}
	
	//-----------------------------------------------------------------
	
	// ActiveRecord methods

	static final String authId = ApplicationProperties.getDatasourceSchemaName();
	
	protected static final String _createString =
		"INSERT INTO "+authId+".EMPLOYEE "+
		"(ID, NAME, AGE, STREET, CITY, STATE, ZIP)"+
		"VALUES (?, ?, ?, ?, ?, ?, ?)";
		
	protected static final String _readString =
		"SELECT * FROM "+ authId+ ".EMPLOYEE " +
		"WHERE ID = ?";
			
	protected static final String _findAllString =
		"SELECT * FROM "+authId+".EMPLOYEE ";

	protected static final String _updateString =
		"UPDATE "+ authId+".EMPLOYEE "+
		"SET NAME=?, AGE=?, STREET=?, CITY=?, STATE=?, ZIP=? "+
		"WHERE ID = ?";

	protected static final String _deleteString =
		"DELETE FROM "+authId+".EMPLOYEE  WHERE ID = ?";
		
	
	/** Create this employee in the database.
	 */ 	
	public void create() throws SQLException, DuplicateKeyException {
		Connection connection = null;
		try {
			connection = getConnection();
			PreparedStatement ps = connection.prepareStatement(_createString);
			ps.setString(1, getId());
			ps.setString(2, getName());
			ps.setInt(3, getAge());
			ps.setString(4, getStreet());
			ps.setString(5, getCity());
			ps.setString(6, getState());
			ps.setString(7, getZip());
			int rows = ps.executeUpdate();
			if (rows != 1) {
				throw new DuplicateKeyException("Duplicate employee "+id);
			}
		} finally {
			close(connection);
		} 
	}
	
	/** Find an employee by primary key or null if there is no
	 * such employee.
	 */
	public static Employee findByPrimaryKey(String id) throws SQLException, NoSuchObjectException {
		Connection connection = null;
		try {
			connection = getConnection();
			PreparedStatement ps = connection.prepareStatement(_readString);
			ps.setString(1, id);
			ResultSet rs = ps.executeQuery();
			rs.next();
	/*
			if (rs.getFetchSize() == 0) {
				throw new NoSuchObjectException("No employee with id "+id);
			}
	*/		
			return load(rs);
		} finally {
			close(connection);
		} 
	}
	
	
	/** Return all the employees in the database
	 * @return a Collection of Employee objects
	 */
	public static Collection findAll() throws SQLException {
		ArrayList list = new ArrayList();
		Employee emp = null;
		Connection connection = null;
		try {
			connection = getConnection();
			PreparedStatement ps = connection.prepareStatement(_findAllString);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				emp = load(rs);
				list.add(emp);
			}
			return list;
		} finally {
			close(connection);
		} 
	}

	/** Load an employee instance from a row in the database.
	 * @param rs the ResultSet at the current cursor position
	 * @return an Employee initialized from the result set
	 */
	private static Employee load(ResultSet rs) throws SQLException {
		Employee emp = new Employee();
		emp.id = rs.getString(1);
		emp.setName(rs.getString(2));
		emp.setAge(rs.getInt(3));
		emp.setStreet(rs.getString(4));
		emp.setCity(rs.getString(5));
		emp.setState(rs.getString(6));
		emp.setZip(rs.getString(7));
		return emp;
	}
	
	/** Update this employee in the database
	 */
	public void update() throws SQLException, MappingException {
		Connection connection = null;
		try {
			connection = getConnection();
			PreparedStatement ps = connection.prepareStatement(_updateString);
			// can't update the id
			ps.setString(1, getName());
			ps.setInt(2, getAge());
			ps.setString(3, getStreet());
			ps.setString(4, getCity());
			ps.setString(5, getState());
			ps.setString(6, getZip());
			ps.setString(7, getId());
			int rows = ps.executeUpdate();
			if (rows != 1) {
				throw new MappingException("Unable to update employee "+id);
			}
		} finally {
			close(connection);
		} 
	}
	
	/** Delete this employee from the database. It is a client error 
	 * to continue using the employee after it has been deleted.
	 */
	public void delete() throws SQLException, MappingException {
		Connection connection = null;
		try {
			connection = getConnection();
			PreparedStatement ps = connection.prepareStatement(_deleteString);
			ps.setString(1, getId());
			int rows = ps.executeUpdate();
			if (rows != 1) {
				throw new MappingException("Unable to delete employee "+id);
			}
		} finally {
			close(connection);
		} 
	}
	
	/**
	 * Access a Connection from the Datasource
	 * @return a managed Connection
	 */
	public static Connection getConnection() throws SQLException {
		// get a connection
		DataSource ds = getDataSource();
		return ds.getConnection(ApplicationProperties.getDatasourceUserId(), 
								 ApplicationProperties.getDatasourcePassword());
	}

	/**
	 * Get a DataSource configured for this application and 
	 * suitable for storing domain objects.
	 * 
	 * @return javax.sql.DataSource
	 */
	public static DataSource getDataSource() {
		DataSource ds = null;
		try {
			InitialContext context = new InitialContext();
			ds = (DataSource) context.lookup(ApplicationProperties.getDatasourceJndiName());
		} catch (javax.naming.NamingException ne) {
			MappingException e = new MappingException("NamingException: cannot find DataSource in initialContext");
			ne.printStackTrace();
		}
		return ds;
	}


	/** Close an database connection.
	 * 
	 * @param conn the connection to close.
	 */
	protected static void close(Connection conn) {
		try {
			if (conn != null) conn.close();
		} catch (SQLException e) {
		}
	}
}
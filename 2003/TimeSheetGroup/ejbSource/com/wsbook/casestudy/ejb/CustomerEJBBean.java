package com.wsbook.casestudy.ejb;

import javax.naming.*;
import java.sql.*;
import java.rmi.RemoteException;
import java.security.Identity;
import java.util.Properties;
import javax.ejb.*;
import javax.sql.*;

import com.wsbook.casestudy.system.AppService;
import com.wsbook.casestudy.system.TraceCapable;

/**
 * This is an Entity Bean class with BMP fields
 */
public class CustomerEJBBean implements EntityBean {
	private javax.ejb.EntityContext entityContext = null;
	final static long serialVersionUID = 3206093459760846163L;

	private DataSource ds;

	private int customerNumber;
	private java.lang.String customerName;
	private int accountBalance;

	public static final String LOAD_STRING = "SELECT cNum, cName, acctBal from Cust WHERE cNum = ?";
	public static final String FIND_BY_PRIMARYKEY_STRING = "SELECT cNum, cName, acctBal from Cust WHERE cNum = ?";
	public static final String UPDATE_STRING = "UPDATE Cust SET cName = ?, acctBal = ? WHERE cNum = ?";
	public static final String INSERT_STRING = "INSERT INTO Cust(cNum, cName, acctBal) VALUES (?, ?, ?)";
	public static final String REMOVE_STRING = "DELETE from Cust where cNum = ?";
	/* Create SQL is CREATE TABLE Cust (cNum INTEGER NOT NULL, cName VARCHAR(60), acctBal INTEGER) */

	public static final String DATASOURCE_NAME = "jdbc/MyDataSource";
/**
 * This method was generated for supporting the associations.
 * @return java.util.Vector
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
protected java.util.Vector _getLinks() {
	java.util.Vector links = new java.util.Vector();
	return links;
}
/**
 * This method was generated for supporting the associations.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
protected void _initLinks() {}
/**
 * This method was generated for supporting the associations.
 * @exception java.rmi.RemoteException The exception description.
 * @exception javax.ejb.RemoveException The exception description.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
protected void _removeLinks() throws java.rmi.RemoteException, javax.ejb.RemoveException {
	java.util.Enumeration links = _getLinks().elements();
	while (links.hasMoreElements()) {
		try {
			((com.ibm.ivj.ejb.associations.interfaces.Link) (links.nextElement())).remove();
		}
		catch (javax.ejb.FinderException e) {} //Consume Finder error since I am going away
	}
}
/**
 * ejbActivate method comment
 * @exception java.rmi.RemoteException The exception description.
 */
public void ejbActivate() throws java.rmi.RemoteException {
	_initLinks();
}
/**
 * ejbCreate method for a BMP entity bean
 * @return com.wsbook.casestudy.system.CustomerEJBKey
 * @param key com.wsbook.casestudy.system.CustomerEJBKey
 * @exception javax.ejb.CreateException The exception description.
 * @exception java.rmi.RemoteException The exception description.
 */
public com.wsbook.casestudy.ejb.CustomerEJBKey ejbCreate(int cNumber, String cName) throws javax.ejb.CreateException {

		this.setCustomerNumber(cNumber);
		this.setCustomerName(cName);
		this.setAccountBalance(0);

		Connection jdbcConn = null;
		PreparedStatement sqlStatement = null;
		try {
			jdbcConn = getConnection();
			sqlStatement = jdbcConn.prepareStatement(INSERT_STRING);
			sqlStatement.setInt(1, customerNumber);
			sqlStatement.setString(2, customerName);
			sqlStatement.setInt(3, accountBalance);
			if (sqlStatement.executeUpdate() != 1) {
				throw new CreateException("Failure in ejbCreate() -- row already exists");
			}
			return new CustomerEJBKey(cNumber);
		} catch (SQLException e) {
			throw new CreateException("Failure in ejbCreate() -- " + e.getMessage());
		} finally {
			try {
				if (sqlStatement != null) sqlStatement.close();
				if (jdbcConn != null) jdbcConn.close();
			} catch (SQLException e1) {
				AppService.log(TraceCapable.ERROR_LEVEL,"Exception caught in ejbCreate() -- failure to close connection");
			}
		}
}

public void ejbPostCreate(int cNumber, String cName) {}

/**
 * The ejbFindByPrimaryKey method is executed to find an EJB.  This method verifies that
 * the key passed in is present in the database.
 *
 * @return com.wsbook.casestudy.system.CustomerEJBKey
 * @param primaryKey com.wsbook.casestudy.system.CustomerEJBKey
 * @exception java.rmi.RemoteException The exception description.
 * @exception javax.ejb.FinderException The exception description.
 */
public com.wsbook.casestudy.ejb.CustomerEJBKey ejbFindByPrimaryKey(com.wsbook.casestudy.ejb.CustomerEJBKey key) throws javax.ejb.FinderException {
	boolean wasFound = false;
	boolean foundMultiples = false;
	Connection jdbcConn = null;
	PreparedStatement sqlStatement = null;
	try {
		// SELECT from database
		jdbcConn = getConnection();
		sqlStatement = jdbcConn.prepareStatement(FIND_BY_PRIMARYKEY_STRING);
		sqlStatement.setInt(1, key.primaryKey);

		// Execute query
		ResultSet sqlResults = sqlStatement.executeQuery();
		// Advance cursor (there should be only one item)
		// wasFound will be true if there is one
		wasFound = sqlResults.next();

		// foundMultiples will be true if more than one is found.
		foundMultiples = sqlResults.next();
	} catch (SQLException e) { // DB error
		throw new FinderException("Database Exception " + e + "caught in ejbFindByPrimaryKey()");
	} finally {
		try {
			if (sqlStatement != null)
				sqlStatement.close();
			if (jdbcConn != null)
				jdbcConn.close();
		} catch (SQLException e1) {
			AppService.log(TraceCapable.ERROR_LEVEL,"Exception caught in ejbFindByPrimaryKey() -- failure to close connection");
		}
	}
	if (wasFound && !foundMultiples) {
		return new CustomerEJBKey(key.primaryKey);
	} else {
		// Report finding no key or multiple keys
		throw new FinderException("Multiple rows found for unique key in ejbFindByPrimaryKey().");
	}
}
/**
 * The ejbLoad() method is called when the EJB must refresh itself from the database.
 * @exception java.rmi.RemoteException The exception description.
 */
public void ejbLoad() throws java.rmi.RemoteException {
	boolean wasFound = false;
	boolean foundMultiples = false;
	CustomerEJBKey key = (CustomerEJBKey) getEntityContext().getPrimaryKey();
	Connection jdbcConn = null;
	PreparedStatement sqlStatement = null;
	try {
		jdbcConn = getConnection();
		// SELECT from database
		sqlStatement = jdbcConn.prepareStatement(LOAD_STRING);
		sqlStatement.setInt(1, key.primaryKey);

		// Execute query
		ResultSet sqlResults = sqlStatement.executeQuery();
		// Advance cursor (there should be only one item)
		// wasFound will be true if there is one
		wasFound = sqlResults.next();
		if (wasFound) {
			// set the internal variables
			this.setCustomerNumber(sqlResults.getInt(1));
			this.setCustomerName(sqlResults.getString(2));
			this.setAccountBalance(sqlResults.getInt(3));
		}
		// foundMultiples will be true if more than one is found.
		foundMultiples = sqlResults.next();
	} catch (SQLException e) { // DB error
		throw new RemoteException("Database Exception " + e + "caught in ejbLoad()");
	} finally {
		try {
			if (sqlStatement != null) sqlStatement.close();
			if (jdbcConn != null) jdbcConn.close();
		} catch (SQLException e1) {
			AppService.log(TraceCapable.ERROR_LEVEL,"Exception caught in ejbLoad() -- failure to close connection");
		}
	}
	if (wasFound && !foundMultiples) {
		return;
	} else {
		// Report finding no key or multiple keys
		throw new RemoteException("Multiple rows found for unique key in ejbLoad().");
	}
}
/**
 * ejbPassivate method comment
 * @exception java.rmi.RemoteException The exception description.
 */
public void ejbPassivate() throws java.rmi.RemoteException {}
/**
 * ejbRemove removes the row from the database
 * @exception java.rmi.RemoteException The exception description.
 * @exception javax.ejb.RemoveException The exception description.
 */
public void ejbRemove() throws java.rmi.RemoteException, javax.ejb.RemoveException {
	Connection jdbcConn = null;
	PreparedStatement sqlStatement = null;
	int value = 0;
	try {
		jdbcConn = getConnection();
		sqlStatement = jdbcConn.prepareStatement(REMOVE_STRING);
		sqlStatement.setInt(1, customerNumber);
		if ((value = sqlStatement.executeUpdate()) != 1)
			throw new RemoteException("Failure in ejbRemove() -- Removed " + value + " rows ");
	} catch (SQLException e) {
		throw new RemoteException("Database failure in ejbRemove() -- " + e.getMessage());
	} finally {
		try {
			if (sqlStatement != null) sqlStatement.close();
			if (jdbcConn != null) jdbcConn.close();
		} catch (SQLException e) {
			AppService.log(TraceCapable.ERROR_LEVEL,"Error in ejbRemove() -- failure to close");
		}
	}
}
/**
 * ejbStore is called when the EJB must store its state in the database.
 * @exception java.rmi.RemoteException The exception description.
 */
public void ejbStore() throws java.rmi.RemoteException {
	Connection jdbcConn = null;
	PreparedStatement sqlStatement = null;
	try {
		jdbcConn = getConnection();
		sqlStatement = jdbcConn.prepareStatement(UPDATE_STRING);
		sqlStatement.setString(1, customerName);
		sqlStatement.setInt(2, accountBalance);
		sqlStatement.setInt(3, customerNumber);
		if (sqlStatement.executeUpdate() != 1) {
			throw new RemoteException("No rows added -- failure in ejbStore()");
		}
	} catch (SQLException e) {
		throw new RemoteException(e.getMessage());
	} finally {
		try {
			if (sqlStatement != null)
				sqlStatement.close();
			if (jdbcConn != null)
				jdbcConn.close();
		} catch (SQLException e) {
			AppService.log(TraceCapable.ERROR_LEVEL,"Error in ejbStore() -- failure to close");
		}
	}
}
/**
 * getAccountBalance returns the account balance
 * Creation date: (7/15/2000 3:45:55 PM)
 * @return int
 */
public int getAccountBalance() {
	return accountBalance;
}
/**
 * GetConnection returns a JDBC connection from the datasource
 * Creation date: (7/15/2000 3:53:52 PM)
 * @return java.sql.Connection
 */
public Connection getConnection() throws SQLException {
	if (ds == null) {
		try {
			Properties props = new Properties();
			props.put(Context.INITIAL_CONTEXT_FACTORY, "com.ibm.ejs.ns.jndi.CNInitialContextFactory");
			props.put(Context.PROVIDER_URL, "iiop:///"); 
			// fill in the properties
			InitialContext initContext = new InitialContext(props);
			ds = (DataSource) initContext.lookup(DATASOURCE_NAME);
			if (ds == null)
				throw new SQLException("Could not initialize DataSource in getConnection()");
		} catch (NamingException e) {
			throw new SQLException("Could not initialize DataSource in getConnection() --" + e);
		}
	}
	return ds.getConnection();
}
/**
 * Return the customer name
 * Creation date: (7/15/2000 3:45:44 PM)
 * @return java.lang.String
 */
public java.lang.String getCustomerName() {
	return customerName;
}
/**
 * Return the customer number
 * Creation date: (7/15/2000 3:45:26 PM)
 * @return int
 */
public int getCustomerNumber() {
	return customerNumber;
}
/**
 * getEntityContext method comment
 * @return javax.ejb.EntityContext
 */
public javax.ejb.EntityContext getEntityContext() {
	return entityContext;
}
/**
 * Set the account balance
 * Creation date: (7/15/2000 3:45:55 PM)
 * @param newAccountBalance int
 */
public void setAccountBalance(int newAccountBalance) {
	accountBalance = newAccountBalance;
}
/**
 * Set the customer name
 * Creation date: (7/15/2000 3:45:44 PM)
 * @param newCustomerName java.lang.String
 */
public void setCustomerName(java.lang.String newCustomerName) {
	customerName = newCustomerName;
}
/**
 * Set the customer number (private only)
 * Creation date: (7/15/2000 3:45:26 PM)
 * @param newCustomerNumber int
 */
public void setCustomerNumber(int newCustomerNumber) {
	customerNumber = newCustomerNumber;
}
/**
 * setEntityContext method comment
 * @param ctx javax.ejb.EntityContext
 * @exception java.rmi.RemoteException The exception description.
 */
public void setEntityContext(javax.ejb.EntityContext ctx) throws java.rmi.RemoteException {
	entityContext = ctx;
}
/**
 * unsetEntityContext method comment
 * @exception java.rmi.RemoteException The exception description.
 */
public void unsetEntityContext() throws java.rmi.RemoteException {
	entityContext = null;
}
}

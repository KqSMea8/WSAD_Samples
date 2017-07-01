package com.wsbook.mapping.jdbc;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import javax.sql.DataSource;

import javax.naming.Context;
import javax.naming.InitialContext;

import com.wsbook.mapping.ApplicationProperties;
import com.wsbook.mapping.DomainObject;
import com.wsbook.mapping.Mapper;
import com.wsbook.mapping.MappingException;
import com.wsbook.mapping.NoSuchObjectException;
import com.wsbook.mapping.UnitOfWork;
/**
 * JDBCMapper is an abstract Mapper implementation for accessing JDBC 
 * stores. JDBCMapper provides common behavior for managing stores for
 * JDBC. Concrete subclass provide domain specific implementations of 
 * create, delete, update and find that do the object-to-relational 
 * mapping for a specific element from the domain layer. This class
 * implements the Data Mapper (165) pattern for JDBC data stores. 
 * 
 * @see com.wsbook.mapping.Mapper
 *
 * Creation date: (2/26/00 3:48:50 PM)
 * @author:ILSUser
 */
public abstract class JDBCMapper implements Mapper {

	/**
	 * Constructor.
	 */
	public JDBCMapper() {
		super();
	}

	/**
	 * Create a new object into the persistent store. Throws 
	 * DuplicateKeyException if the domainObject is already 
	 * in the database.
	 * 
	 * @param domainObject the object to add to the store.
	 */
	public void create(DomainObject domainObject) throws MappingException {
		Connection conn = null;
		try {
			// get a connection
			conn = getConnection();
			// delegate to concrete implementation
			createImpl(conn, domainObject);	
		} catch (Exception e) {
			System.out.println("Exception " + e + " caught in create()");
			throw new MappingException("Wrapped Exception " + e + " caught in create()");
		} finally {
			close(conn);
		}

	}

	/**
	 * Create a new object into the persistent store. Throws 
	 * DuplicateKeyException if the domainObject is already 
	 * in the database.
	 * 
	 * @param conn use an existing connection to the database
	 * @param domainObject the object to add to the store.
	 * @return the object created
	 */
	protected void create(Connection conn, DomainObject domainObject) 
		throws SQLException, MappingException {
		createImpl(conn, domainObject);
	}

	/**
	 * Create a new object into the data source layer. Throws 
	 * DuplicateKeyException if the domainObject is already 
	 * in the database.
	 * 
	 * Provides the domain specific implementation.
	 * 
	 * @param domainObject the object to add to the data source.
	 */
	protected abstract void createImpl(Connection conn, DomainObject domainObject) 
		throws SQLException, MappingException;

	/**
	 * Return a List of all Objects in the data source of a
	 * particular type. Subclasses provide a useful implementation. (use carefully 
	 * in practice!). We use this extensively in our example, but in 
	 * fact more "wise" enumerators would directly query the 
	 * datasource (e.g. through more specific finders).
	 *
	 * @return List of DomainObjects
	 */
	public java.util.List findAllObjects() throws MappingException {
		throw new MappingException("Create not valid for this type");
	}

	/**
	 * Retrieve a single object identified object in the database.
	 * Throws NoSuchObjectException if the identified object doesn't 
	 * exist in the database.
	 *
	 * @param id the identifier or key of the domain object to find
	 * @return the identified object in the database.
	 */
	public DomainObject findByPrimaryKey(Object id) 
		throws NoSuchObjectException {
		UnitOfWork current = UnitOfWork.getCurrent();
		if (current.containsID(id)) return current.getLoaded(id);
		Connection conn = null;
		DomainObject object = null;
		try {
			// get a connection
			conn = getConnection();
			object = findByPrimaryKeyImpl(conn, id);
		} catch (Exception e) {
			System.out.println("Exception " + e + " caught in findByPrimaryKey()");
			throw new NoSuchObjectException("Wrapped Exception " + e + " caught in findByPrimaryKey()");
		} finally {
			close(conn);
		}
		if (object == null)
			throw new NoSuchObjectException("No object found with id: "+id);
		return object;

	}

	/**
	 * Retrieve a single object identified object in the database. 
	 * Throws NoSuchObjectException if the identified object doesn't
	 * exist in the database.
	 *
	 * @param conn use an existing connection to the database
	 * @param id the identifier or key of the domain object to find
	 * @return the identified domain object in the data source.
	 */
	protected DomainObject findByPrimaryKey(Connection conn, Object id) 
		throws SQLException, MappingException {
		UnitOfWork current = UnitOfWork.getCurrent();
		if (current.containsID(id)) return current.getLoaded(id);
		return findByPrimaryKeyImpl(conn, id);
	}

	/**
	 * Retrieve a single object identified object in the data source.
	 * Throws NoSuchObjectException if the identified object doesn't
	 * exist in the data source.
	 *
	 * Provides the domain specific implementation.
	 * 
	 * @param conn use an existing connection to the database
	 * @param id the identifier or key of the domain object to find
	 * @return the identified object in the database.
	 */
	protected abstract DomainObject findByPrimaryKeyImpl(Connection conn, Object id) 
		throws SQLException, MappingException;

	/**
	 * Update an anObject (e.g. change its state in the data source)
	 * 
	 * @param anObject the domain object to update
	 */
	public void update(DomainObject domainObject) throws NoSuchObjectException {
		Connection conn = null;
		try {
			// get a connection
			conn = getConnection();
			updateImpl(conn, domainObject);
		} catch (Exception e) {
			System.out.println("Exception " + e + " caught in update()");
			throw new NoSuchObjectException("Wrapped Exception " + e + " caught in update()");
		} finally {
			close(conn);
		}
	}

	/**
	 * Update an anObject (e.g. change its state in the data source)
	 * 
	 * @param conn use an existing connection to the database
	 * @param anObject the object to update
	 */
	protected void update(Connection conn, DomainObject anObject) throws SQLException, MappingException {
		updateImpl(conn, anObject);
	}

	/**
	 * Update an anObject (e.g. change its state in the data source)
	 * 
	 * Provides the domain specific implementation.
	 * 
	 * @param conn use an existing connection to the database
	 * @param anObject the domain object to update
	 */
	protected abstract void updateImpl(Connection conn, DomainObject anObject) 
		throws SQLException, MappingException;

	/**
	 * Remove a domain object from the data source.
	 *
	 * @param domainObject the domain object to remove.
	 */
	public void delete(DomainObject domainObject) throws NoSuchObjectException {
		Connection conn = null;
		try {
			// get a connection
			conn = getConnection();
			deleteImpl(conn, domainObject);
		} catch (Exception e) {
			System.out.println("Exception " + e + " caught in remove()");
			throw new NoSuchObjectException("Wrapped Exception " + e + " caught in remove()");
		} finally {
			close(conn);
		}

	}

	/**
	 * Remove a domain object from the data source.
	 *
	 * @param conn use an existing connection to the database
	 * @param domainObject the domain object to remove.
	 */
	public void delete(Connection conn, DomainObject domainObject) 
		throws SQLException, MappingException {
		deleteImpl(conn, domainObject);
	}

	/**
	 * Remove a domain object from the data source.
	 *
	 * Provides the domain specific implementation.
	 * 
	 * @param conn use an existing connection to the database
	 * @param domainObject the domain object to remove.
	 */
	protected abstract void deleteImpl(Connection conn, DomainObject domainObject) 
		throws SQLException, MappingException;

	/** Activates a domain object by setting its values from
	 * the data source and marking it as unchanged in the
	 * unit of work.
	 */
	abstract protected DomainObject activate(ResultSet rs);
		
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

	public static void commitConnection() throws SQLException {
		// in XA transaction 
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
			Properties env = new Properties();
			//env.put(Context.PROVIDER_URL, "iiop://localhost:900");
			env.put(Context.PROVIDER_URL, "iiop:///");
			env.put(Context.INITIAL_CONTEXT_FACTORY, "com.ibm.websphere.naming.WsnInitialContextFactory");

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
	protected void close(Connection conn) {
		try {
			if (conn != null) conn.close();
		} catch (SQLException e) {
		}
	}
}


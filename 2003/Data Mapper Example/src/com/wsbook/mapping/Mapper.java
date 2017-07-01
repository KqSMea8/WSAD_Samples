package com.wsbook.mapping;
import java.util.ArrayList;

/**
 * Mapping API implemented by data source access mechanisms that access specific
 * data sources, such as JDBC or EJB, and "maps" results to objects. This  
 * Interface specifies a set of persistent operations in order to retrieve 
 * and store Objects to and from specific data sources. Mapper provides 
 * typical CRUD operations on a store.
 */
public interface Mapper {
	/**
	 * Insert a new DomainObject into the data source
	 */
	public void create(DomainObject anObject) throws MappingException;

	/**
	 * Return a ArrayList of all Objects (use carefully in practice!)
	 * We use this extensively in our example, but in fact more "wise" enumerators
	 * That would directly query the datasource (e.g. through more specific finders)
	 *
	 * @return ArrayList of DomainObjects
	 */
	public ArrayList findAll();

	/**
	 * Retrieve a single object identified by anObject. Throws NoSuchObjectException
	 * if there is no object in the data source identified by anObject.
	 *
	 * @param anObject an identifier or key for an instance in the data source
	 * @return the domain object identified by anObject 
	 */
	public DomainObject findByPrimaryKey(Object anObject) throws NoSuchObjectException;

	/**
	 * Update an anObject (e.g. change its state in the data source)
	 * 
	 * @param anObject the domain object to update
	 *
	 */
	public void update(DomainObject anObject) throws NoSuchObjectException;

	/**
	 * Delete an domain object from its data source
	 * 
	 * @param anObject the object to delete
	 */
	public void delete(DomainObject anObject) throws NoSuchObjectException;
}

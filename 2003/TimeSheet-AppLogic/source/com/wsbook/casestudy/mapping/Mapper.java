package com.wsbook.casestudy.mapping;

import java.util.ArrayList;

import com.wsbook.casestudy.domain.TsObject;
import com.wsbook.casestudy.exception.DuplicateKeyException;
import com.wsbook.casestudy.exception.MappingException;
import com.wsbook.casestudy.exception.NoSuchObjectException;
/**
 * Mapping API implemented by data source access mechanisms that access specific
 * data sources, such as JDBC or EJB, and "maps" results to objects. This interface specifies
 * a set of persistent operations in order to retrieve and store Objects to and
 * from specific data sources.
 * @return Vector
 */
public interface Mapper {
	/**
	 * Delete a TsObject from its store
	 */
	public void remove(TsObject anObject) throws NoSuchObjectException, MappingException;
	/**
	 * Insert a new TsObject into the store
	 */
	public void insert(TsObject anObject) throws DuplicateKeyException, MappingException;
	/**
	 * Return a ArrayList of all TsObjects (use carefully in practice!)
	 * We use this extensively in our example, but in fact more "wise" enumerators
	 * That would directly query the datasource (e.g. through EJB finders)
	 *
	 * @return ArrayList
	 */
	public ArrayList findAll() throws MappingException;
	/**
	 * Retrieve a single object matching this object.
	 *
	 * @return Vector
	 */
	public TsObject findByPrimaryKey(TsObject anObject) throws NoSuchObjectException, MappingException;
	/**
	 * Update this object (e.g. change its state in the store)
	 *
	 */
	public void update(TsObject anObject) throws NoSuchObjectException, MappingException;
}
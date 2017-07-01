package com.wsbook.mapping;

import java.util.ArrayList;

/** Implements Mapper interface that does nothing. Useful for testing purposes.
 * 
 * @author jamsden
 *
 */
public class TransientObjectMapper implements Mapper {

	/**
	 * @see com.wsbook.mapping.Mapper#create(DomainObject)
	 */
	public void create(DomainObject anObject) throws MappingException {
	}

	/**
	 * @see com.wsbook.mapping.Mapper#findAll()
	 */
	public ArrayList findAll() {
		return null;
	}

	/**
	 * @see com.wsbook.mapping.Mapper#findByPrimaryKey(Object)
	 */
	public DomainObject findByPrimaryKey(Object anObject)
		throws NoSuchObjectException {
		return null;
	}

	/**
	 * @see com.wsbook.mapping.Mapper#update(DomainObject)
	 */
	public void update(DomainObject anObject) throws NoSuchObjectException {
	}

	/**
	 * @see com.wsbook.mapping.Mapper#remove(DomainObject)
	 */
	public void delete(DomainObject anObject) throws NoSuchObjectException {
	}

}

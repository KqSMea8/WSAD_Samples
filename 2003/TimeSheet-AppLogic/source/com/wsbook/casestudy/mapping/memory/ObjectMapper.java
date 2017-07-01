package com.wsbook.casestudy.mapping.memory;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.ListIterator;

import com.wsbook.casestudy.domain.TsObject;
import com.wsbook.casestudy.exception.NoSuchObjectException;
import com.wsbook.casestudy.mapping.Mapper;
/**
 * This class represents a simple, "in-memory" mapper for TsObjects.
 * It stores the objects in a ArrayList.
 *
 * Creation date: (2/3/00 8:59:24 AM)
 * @author: Administrator
 */
public abstract class ObjectMapper implements Mapper, Serializable {
	//protected ArrayList cache = null;
	/**
	 * ObjectMapper constructor.
	 */
	public ObjectMapper() {
		super();
	}
	
	protected abstract ArrayList getCache();
	
	/**
	 * Remove all entries from the cache.
	 * Required for the JUnit Test Cases.
	 */
	public abstract void clearCache();
	
	/**
	 * Remove this TsObject from the cache.
	 */
	public void remove(TsObject anObject) {
		ArrayList cache = getCache();
		synchronized(this.getClass()) {
			cache.remove(anObject);
		}
	}
	/**
	 * Return a ArrayList of TsObjects for a Mapper.
	 * This should be overriden for each Mapper that requires
	 * an initial population of objects
	 *
	 * Creation date: (2/3/00 9:15:42 AM)
	 * @return java.util.ArrayList
	 */
	abstract ArrayList initialLoad();

	/**
	 * Insert TsObject into cache, and toggle persistent flag.
	 */
	public void insert(TsObject anObject) {
		synchronized(this.getClass()) {
			ArrayList cache = getCache();
			cache.add(anObject);
		}
	}

	/**
	 * Retrieve all objects in this mapper.
	 * if first access, load cache first.
	 */
	public java.util.ArrayList findAll() {
			ArrayList cache = getCache();
		return (ArrayList) cache.clone();
	}

	/**
	 * Default retrieveSingleObjectMatching() returns null
	 */
	public abstract TsObject findByPrimaryKey(TsObject anObject) throws NoSuchObjectException;
	
	/**
	 * The default update() method does a remove and an insert
	 */
	public void update(TsObject anObject) {
		remove(anObject);
		insert(anObject);
	}
}
package com.wsbook.mapping;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/** Implements the Unit of Work (184) pattern to maintain a list of objects affected by a
 * business transaction and coordinate the writing of changes and the rsolution of
 * concurrency problems.
 * <p>
 * Client application creates a UnitOfWork by calling UnitOfWork.begin().
 * Applicaiton then creates, reads, updates, and deletes domain model objects
 * inside the context of that unit of work. When completed, the client app
 * calls UnitOfWork.getCurrent().commit() to write changes to the database. Client applications
 * should not reuse references to domain objects across units of work as they will
 * not be written to the data sources. Instead, use finder methods to re-read the
 * data sources between units of work to avoid stale reads.
 * 
 * @author jamsden
 *
 */
public class UnitOfWork {

	private static ThreadLocal current = new ThreadLocal();
	
	/** Create a new unity of work and set it as the current
	 * unit of work for the session.
	 */
	public static void begin() {
		setCurrent(new UnitOfWork());
	}
	
	/** Set the unit of work to uow.
	 */
	public static void setCurrent(UnitOfWork uow) {
		current.set(uow);
	}
	
	/** Get the current unit of work
	 */
	public static UnitOfWork getCurrent() {
		return (UnitOfWork)current.get();
	}
	
	private List createdObjects = new ArrayList();
	private List updatedObjects = new ArrayList();
	private List deletedObjects = new ArrayList();
	private HashMap readCache = new HashMap();	// an Identity Map (195)

	/** Register an object as newly created.
	 */	
	public void registerCreated(DomainObject object) throws MappingException {
		if (object.getID() == null) throw new MappingException("object must have an id");
		if (createdObjects.contains(object)) throw new MappingException("object is already created");
		if (updatedObjects.contains(object)) throw new MappingException("object was not updated");
		if (deletedObjects.contains(object)) throw new MappingException("object was removed");
		readCache.put(object.getID(), object) ;
		createdObjects.add(object);
	}
	
	/** Register an object as having been updated.
	 */
	public void registerUpdated(DomainObject object) throws MappingException {
		if (object.getID() == null) throw new MappingException("object must have an id");
		if (deletedObjects.contains(object)) throw new MappingException("object was removed");
		if (!readCache.containsKey(object.getID())) throw new MappingException("object was never read"); 
		if (!createdObjects.contains(object) &&
			!updatedObjects.contains(object)) { 
			updatedObjects.add(object);
		}
	}
	
	/** Register an object as deleted.
	 */
	public void registerDeleted(DomainObject object) throws MappingException {
		if (object.getID() == null) throw new MappingException("object must have an id");
		if (!readCache.containsKey(object.getID())) throw new MappingException("object was never read"); 
		if (createdObjects.remove(object)) return;
		updatedObjects.remove(object);
		if (!deletedObjects.contains(object)) {
			deletedObjects.add(object);
			readCache.remove(object.getID());
		}
	}
	
	/** Register an object as unchanged.
	 */
	public void registerUnchanged(DomainObject object) throws MappingException {
		if (object.getID() == null) throw new MappingException("object must have an id");
		createdObjects.remove(object);
		updatedObjects.remove(object);
		deletedObjects.remove(object);
		readCache.put(object.getID(), object);
	}
	
	/** See if a domain object has been loaded from the
	 * data source in this unit of work
	 * @param id the identifier of the domain object to check
	 * @return true if the identified domain object is in this unit of work
	 */
	public boolean containsID(Object id) {
		DomainObject o = null;
		if (readCache.containsKey(id)) {
			o = (DomainObject)readCache.get(id);
		}
		return o != null && !o.isGhost();
	}
	
	/** Get a domain object already loaded from the data source in this
	 * unit of work.
	 * @param id the identifier of the domain object to get
	 * @return the identified DomainObject
	 */
	public DomainObject getLoaded(Object id) {
		return (DomainObject)readCache.get(id);
	}
	
	/** Commit the current unit of work updating the data source layer as
	 * appropriate.
	 */
	public void commit() throws MappingException {
		insertCreated();
		updateUpdated();
		deleteDeleted();
		current.set(null);
	}
	
	private void insertCreated() throws MappingException {
		for (Iterator objects = createdObjects.iterator(); objects.hasNext();) {
			DomainObject object = (DomainObject)objects.next();
			MapperRegistry.getMapper(object.getClass()).create(object);
		}
	}
	
	private void updateUpdated() throws MappingException {
		for (Iterator objects = updatedObjects.iterator(); objects.hasNext();) {
			DomainObject object = (DomainObject)objects.next();
			MapperRegistry.getMapper(object.getClass()).update(object);
		}
	}
	
	private void deleteDeleted() throws MappingException {
		for (Iterator objects = deletedObjects.iterator(); objects.hasNext();) {
			DomainObject object = (DomainObject)objects.next();
			MapperRegistry.getMapper(object.getClass()).delete(object);
		}
	}
}

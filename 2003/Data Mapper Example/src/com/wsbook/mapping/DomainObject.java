package com.wsbook.mapping;

/** Implements the Layer Supertype (475) pattern to provide behavior that
 * is common to all elements of the Domain Model (116) Layer.
 * 
 * @author jamsden
 *
 */
public abstract class DomainObject {
	private boolean isGhost = false;
	
	/** Return the object that can be used to uniquely identify
	 * this domain object. Provides support for the Identity Field (216).
	 * pattern.
	 */
	public abstract Object getID();
	
	/**
	 * Return true if anObject is equivalent to 
	 * this DomainObject (i.e., has the same ID).
	 */
	public boolean equals(DomainObject anObject) {
		return anObject != null && 
				anObject.getClass().equals(getClass()) && 
				anObject.getID().equals(getID());
	}

	/** This method must be called when an object is no longer
	 * needed so that it will get deleted from the corresponding
	 * data source layer.
	 */
	public void delete() throws MappingException  {
		markDeleted();
	}
	
	/** Answer if this domain object is a ghost or not. A ghost
	 * represents a domain object that has not yet been populated
	 * from a data source. It will be populated the first time
	 * it is accessed.
	 */
	public boolean isGhost() {
		return isGhost;
	}
	
	/** Indicate if this domain object is a ghost or not. If
	 * it is a ghost, then it is considered unchanged in the
	 * unit of work.
	 */
	public void setIsGhost(boolean value) {
		isGhost = value;
		try {
			if (isGhost) markUnchanged();
		} catch (MappingException e) {
		}
	}
	
	/** Marks this domain object as created in the 
	 * current unit of work
	 */
	protected void markCreated() throws MappingException {
		UnitOfWork.getCurrent().registerCreated(this);
	}
	
	/** Marks this domain object as read and unchanged in the 
	 * current unit of work. This is public because the
	 * Mapper activate method needs to call it.
	 */
	public void markUnchanged() throws MappingException {
		UnitOfWork.getCurrent().registerUnchanged(this);
	}
	
	/** Marks this domain object as updated in the 
	 * current unit of work. Public so Embedded Value (268)
	 * objects can mark their containing object as changed.
	 */
	public void markUpdated() throws MappingException {
		UnitOfWork.getCurrent().registerUpdated(this);
	}
	
	/** Marks this domain object as deleted in the 
	 * current unit of work
	 */
	protected void markDeleted() throws MappingException {
		UnitOfWork.getCurrent().registerDeleted(this);
	}
}

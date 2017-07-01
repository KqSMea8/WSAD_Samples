package com.wsbook.casestudy.ejb;
/**
 * Key class for Entity Bean: TimeSheetEntryEJB
 */
public class TimeSheetEntryEJBKey implements java.io.Serializable {
	static final long serialVersionUID = 3206093459760846163L;
	/**
	 * Implementation field for persistent attribute: entryId
	 */
	public int entryId;
	/**
	 * Creates an empty key for Entity Bean: TimeSheetEntryEJB
	 */
	public TimeSheetEntryEJBKey() {
	}
	/**
	 * Creates a key for Entity Bean: TimeSheetEntryEJB
	 */
	public TimeSheetEntryEJBKey(int entryId) {
		this.entryId = entryId;
	}
	/**
	 * Returns true if both keys are equal.
	 */
	public boolean equals(java.lang.Object otherKey) {
		if (otherKey
			instanceof com.wsbook.casestudy.ejb.TimeSheetEntryEJBKey) {
			com.wsbook.casestudy.ejb.TimeSheetEntryEJBKey o =
				(com.wsbook.casestudy.ejb.TimeSheetEntryEJBKey) otherKey;
			return ((this.entryId == o.entryId));
		}
		return false;
	}
	/**
	 * Returns the hash code for the key.
	 */
	public int hashCode() {
		return ((new java.lang.Integer(entryId).hashCode()));
	}
	/**
	 * Get accessor for persistent attribute: entryId
	 */
	public int getEntryId() {
		return entryId;
	}
	/**
	 * Set accessor for persistent attribute: entryId
	 */
	public void setEntryId(int newEntryId) {
		entryId = newEntryId;
	}
}

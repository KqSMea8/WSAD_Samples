package com.wsbook.casestudy.ejb;
/**
 * Key class for Entity Bean: TimeSheetEJB
 */
public class TimeSheetEJBKey implements java.io.Serializable {
	static final long serialVersionUID = 3206093459760846163L;
	/**
	 * Implementation field for persistent attribute: timeSheetId
	 */
	public int timeSheetId;
	/**
	 * Creates an empty key for Entity Bean: TimeSheetEJB
	 */
	public TimeSheetEJBKey() {
	}
	/**
	 * Creates a key for Entity Bean: TimeSheetEJB
	 */
	public TimeSheetEJBKey(int timeSheetId) {
		this.timeSheetId = timeSheetId;
	}
	/**
	 * Returns true if both keys are equal.
	 */
	public boolean equals(java.lang.Object otherKey) {
		if (otherKey instanceof com.wsbook.casestudy.ejb.TimeSheetEJBKey) {
			com.wsbook.casestudy.ejb.TimeSheetEJBKey o = (com.wsbook.casestudy.ejb.TimeSheetEJBKey)otherKey;
			return ((this.timeSheetId == o.timeSheetId));
		}
		return false;
	}
	/**
	 * Returns the hash code for the key.
	 */
	public int hashCode() {
		return ((new java.lang.Integer(timeSheetId).hashCode()));
	}
	/**
	 * Get accessor for persistent attribute: timeSheetId
	 */
	public int getTimeSheetId() {
		return timeSheetId;
	}
	/**
	 * Set accessor for persistent attribute: timeSheetId
	 */
	public void setTimeSheetId(int newTimeSheetId) {
		timeSheetId = newTimeSheetId;
	}
}

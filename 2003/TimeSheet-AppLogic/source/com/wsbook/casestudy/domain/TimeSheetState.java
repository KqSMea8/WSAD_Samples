package com.wsbook.casestudy.domain;

/**
 * This is the abstract superclass of TimeSheet states.
 * Every Timesheet always has some state (Currently pending or approved).
 *
 */
abstract public class TimeSheetState extends TsObject {
	
	static final ApprovedState approvedSingleton = new ApprovedState();
	static final PendingState  pendingSingleton  = new PendingState();
	/**
	 * TimeSheetState constructor.
	 */
	public TimeSheetState() {
		super();
	}
	/**
	 * Return the name of this state.  Each subclass will override this method.
	 * Creation date: (2/18/00 10:08:23 PM)
	 * @return java.lang.String
	 */
	abstract public String getStatename();
	/**
	 * Return false since by default timesheets are not approved.
	 */
	public boolean isApproved() {
		return false;
	}
	/**
	 * Return false since by default all timesheets are not pending.
	 */
	public boolean isPending() {
		return false;
	}
	
	/** 
	 * Display the state name
	 */
	public String toString() {
		return getStatename();
	}
	
	public static TimeSheetState getApprovedState() {
		return approvedSingleton;
	}
	
	public static TimeSheetState getPendingState() {
		return pendingSingleton;
	}
}
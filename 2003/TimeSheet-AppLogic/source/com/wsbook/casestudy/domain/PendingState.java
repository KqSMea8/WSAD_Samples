package com.wsbook.casestudy.domain;

/**
 * This class is a State class (e.g. Gamma's State pattern)
 * That indicates that a Timesheet is in the "Pending" state.
 *
 */
public class PendingState extends TimeSheetState {
	/**
	 * PendingState constructor.
	 */
	public PendingState() {
		super();
	}
	/**
	 * Return the name of this state.
	 * Creation date: (2/18/00 10:09:06 PM)
	 * @return java.lang.String
	 */
	public String getStatename() {
		return "PENDING";
	}
	/**
	 * Return true since all timesheets having this state are pending.
	 */
	public boolean isPending() {
		return true;
	}
}
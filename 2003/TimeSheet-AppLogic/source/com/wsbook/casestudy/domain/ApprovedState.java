package com.wsbook.casestudy.domain;

/**
 * This class is a state class (e.g. Gamma's State pattern)
 * that is used to show that a Timesheet is in approved state.
 *
 */
public class ApprovedState extends TimeSheetState {
	/**
	 * ApprovedState constructor.
	 */
	public ApprovedState() {
		super();

	}
	/**
	 * Return the name of this state (used to determine if a Timesheet is approved)
	 * Creation date: (2/18/00 10:09:06 PM)
	 * @return java.lang.String
	 */
	public String getStatename() {
		return "APPROVED";
	}
	/**
	 * Return true since all timesheets having this state are approved.
	 */
	public boolean isApproved() {
		return true;
	}
}
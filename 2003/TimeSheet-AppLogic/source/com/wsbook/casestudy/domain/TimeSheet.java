package com.wsbook.casestudy.domain;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.ListIterator;

import com.wsbook.casestudy.exception.NoSuchEmployeeException;
import com.wsbook.casestudy.mapping.EmployeeMapper;
import com.wsbook.casestudy.mapping.MapperFactory;
import com.wsbook.casestudy.util.Formatter;

/**
 * This class represents a Timesheet domain object; the heart of our example.
 * Timesheets are created and approved by Employees.  They contain TimeSheet Entries.
 * Timesheets are for a particular week in time, represented by a weekend.
 *
 */
public class TimeSheet extends TsObject {
	private java.util.Calendar fieldWeekend = null;
	private Employee fieldApprovedBy = null;
	private java.util.ArrayList fieldEntries = new java.util.ArrayList();
	private TimeSheetState fieldState = null;
	private Employee fieldEmployee = null;
	private int fieldTimesheetID = -1;

	/**
	 * TimeSheet constructor
	 */
	public TimeSheet() {
		super();
		// New timesheets are created in pending state
		setState(TimeSheetState.getPendingState());
	}
	/** TimeSheet constructor used by finders
	 */
	public TimeSheet(int id) {
		super();
		fieldTimesheetID = id;
	}

	public TimeSheet(String empId, String weekEnding)
		throws NoSuchEmployeeException {
		this();
		EmployeeMapper mapper =
			(EmployeeMapper) MapperFactory.getSystemMapperFactory().getMapper(
				com.wsbook.casestudy.domain.Employee.class);
		fieldEmployee = mapper.findById(empId);
		fieldWeekend = Formatter.convertToDate(weekEnding);
	}

	public TimeSheet(String weekEnding, Employee employee) {
		this();
		fieldWeekend = Formatter.convertToDate(weekEnding);
		fieldEmployee = employee;
	}

	public TimeSheet(int id, String weekEnding, Employee employee) {
		this(weekEnding, employee);
		fieldTimesheetID = id;
	}
	/**
	 * Approve this timesheet (e.g. set the state to approved)
	 * Creation date: (3/7/00 7:34:46 PM)
	 */
	public void approve() {
		setState(TimeSheetState.getApprovedState());
	}
	/**
	 * Gets the approvedBy property (com.wsbook.casestudy.domain.Employee) value.
	 * @return The approvedBy property value.
	 * @see #setApprovedBy
	 */
	public Employee getApprovedBy() {
		return fieldApprovedBy;
	}
	/**
	 * Gets the employee property (com.wsbook.casestudy.domain.Employee) value.
	 * @return The employee property value.
	 * @see #setEmployee
	 */
	public Employee getEmployee() {
		return fieldEmployee;
	}
	/**
	 * Gets the entries property (java.util.Vector) value.
	 * @return The entries property value.
	 * @see #setEntries
	 */
	public java.util.ArrayList getEntries() {
		return fieldEntries;
	}

	public TimeSheetEntry[] getEntry() {
		if (fieldEntries == null)
			return null;
		int numToCopy = fieldEntries.size();
		TimeSheetEntry[] entries = new TimeSheetEntry[numToCopy];
		for (int i = 0; i < numToCopy; i++) {
			entries[i] = (TimeSheetEntry) fieldEntries.get(i);
		}
		return entries;
	}
	/**
	 * Retrieve the Timesheet Entry at the integer index.
	 * Creation date: (3/24/2000 9:54:27 AM)
	 * @return com.wsbook.casestudy.domain.TimeSheetEntry
	 * @param index int
	 * @exception java.lang.ArrayIndexOutOfBoundsException The exception description.
	 */
	public TimeSheetEntry getEntry(int index)
		throws java.lang.ArrayIndexOutOfBoundsException {
		try {
			return (TimeSheetEntry) getEntries().get(index);
		} catch (IndexOutOfBoundsException e) {
			throw new ArrayIndexOutOfBoundsException(e.getMessage());
		}
	}
	/**
	 * Return the formatted weekend String
	 * Creation date: (5/11/2000 9:59:45 PM)
	 * @return java.lang.String
	 */
	public String getFormattedWeekend() {
		return Formatter.dateFormat(getWeekend());
	}
	/**
	 * Return an integer giving the number of Timesheet Entries contained in this Timesheet
	 * Creation date: (3/24/2000 10:42:22 AM)
	 * @return int
	 */
	public int getNumEntries() {
		return getEntries().size();
	}
	/**
	 * Gets the state property (com.wsbook.casestudy.domain.TimeSheetState) value.
	 * @return The state property value.
	 * @see #setState
	 */
	public TimeSheetState getState() {
		if (fieldState == null)
			fieldState = TimeSheetState.getPendingState();
		return fieldState;
	}
	/**
	 * Gets the timesheetID property (java.lang.String) value.
	 * @return The timesheetID property value.
	 * @see #setTimesheetID
	 */
	public int getTimesheetID() {
		return fieldTimesheetID;
	}
	/**
	 * Iterate over all entries and return the total of hours in this Timesheet
	 */
	public double getTotalHours() {
		double total = 0.0;
		ListIterator iter = getEntries().listIterator();
		while (iter.hasNext()) {
			TimeSheetEntry anEntry = (TimeSheetEntry) iter.next();
			total += anEntry.getHours();
		}
		return total;
	}
	/**
	 * Gets the weekend property (java.util.Calendar) value.
	 * @return The weekend property value.
	 * @see #setWeekend
	 */
	public java.util.Calendar getWeekend() {
		return fieldWeekend;
	}
	/**
	 * Sets the approvedBy property (com.wsbook.casestudy.domain.Employee) value.
	 * @param approvedBy The new value for the property.
	 * @see #getApprovedBy
	 */
	public void setApprovedBy(Employee approvedBy) {
		fieldApprovedBy = approvedBy;
	}
	/**
	 * Sets the employee property (com.wsbook.casestudy.domain.Employee) value.
	 * @param employee The new value for the property.
	 * @see #getEmployee
	 */
	public void setEmployee(Employee employee) {
		fieldEmployee = employee;
	}
	/**
	 * Sets the entries property (java.util.Vector) value.
	 * @param entries The new value for the property.
	 * @see #getEntries
	 */
	public void setEntries(java.util.ArrayList entries) {
		fieldEntries = entries;
		// now validate entries
		if (entries != null) {
			ListIterator itor = entries.listIterator();
			while (itor.hasNext()) {
				TimeSheetEntry entry = (TimeSheetEntry)itor.next();
				entry.setTimeSheet(this);
			}
		}
	}
	
	public void addEntry(TimeSheetEntry entry) {
		if (entry != null) {
			entry.setTimeSheet(this);
			fieldEntries.add(entry);
		}
	}
	/**
	 * Sets the state property (com.wsbook.casestudy.domain.TimeSheetState) value.
	 * @param state The new value for the property.
	 * @see #getState
	 */
	public void setState(TimeSheetState state) {
		fieldState = state;
	}
	/**
	 * Sets the timesheetID property (java.lang.String) value.
	 * @param timesheetID The new value for the property.
	 * @see #getTimesheetID
	 */
	public void setTimesheetID(int timesheetID) {
		fieldTimesheetID = timesheetID;
	}
	/**
	 * Sets the weekend property (java.util.Calendar) value.
	 * @param weekend The new value for the property.
	 * @see #getWeekend
	 */
	public void setWeekend(java.util.Calendar weekend) {
		fieldWeekend = weekend;
	}
	/**
	 * Return an output String representing the values of this TimeSheet
	 * @return java.lang.String
	 */
	public String toString() {
		StringBuffer sb = new StringBuffer();
		sb.append("Time Sheet for: ");
		sb.append(getEmployee().getName());
		sb.append('\n');
		sb.append("Week ending: ");
		sb.append(Formatter.dateFormat(getWeekend()));
		sb.append('\n');
		TimeSheetEntry anEntry = null;
		java.util.ListIterator elements = getEntries().listIterator();
		while (elements.hasNext()) {
			anEntry = (TimeSheetEntry) elements.next();
			sb.append("Project:");
			sb.append(anEntry.getProject().getName());
			sb.append(" Date: ");
			sb.append(Formatter.dateFormat(anEntry.getDate()));
			sb.append(" Hours: ");
			sb.append(anEntry.getHours());
			sb.append('\n');
		}
		sb.append("Total Hours = ");
		sb.append(getTotalHours());
		return sb.toString();
	}
	/**
	 * Change the state of this TimeSheet to be unapproved (e.g. pending)
	 * Creation date: (3/7/00 7:34:46 PM)
	 */
	public void unApprove() {
		setState(TimeSheetState.getPendingState());
	}

	public boolean isApproved() {
		return getState().isApproved();
	}

	public boolean isPending() {
		return getState().isPending();
	}
	
	/**
	 * Set the date from formatted date string MM/DD/YYYY
	 */
	public void setWeekendFromFormattedString(String weekEnding) {
		fieldWeekend = Formatter.convertToDate(weekEnding);
	}
}
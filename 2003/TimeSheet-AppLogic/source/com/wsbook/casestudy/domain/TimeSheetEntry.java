package com.wsbook.casestudy.domain;

import java.util.Calendar;

import com.wsbook.casestudy.exception.MappingException;
import com.wsbook.casestudy.mapping.MapperFactory;
import com.wsbook.casestudy.mapping.ProjectMapper;
import com.wsbook.casestudy.util.Formatter;

/**
 * This class represents a single "Entry" in a Timesheet.  This is a standard implementation
 * of the "Master/Detail" design pattern as described in both Coad and Fowler.
 * Each TimeSheet Entry represents hours logged against a Project, for a Date.
 */
public class TimeSheetEntry extends TsObject {
	private java.util.Calendar fieldDate = null;
	private double fieldHours = 0;
	private Project fieldProject;
	private int fieldTimeSheetEntryID;
	private TimeSheet timeSheet = null;
	/**
	 * TimeSheetEntry constructor.
	 */
	public TimeSheetEntry() {
		super();
	}
	
	public TimeSheetEntry(int id) {
		fieldTimeSheetEntryID = id;
	}
	/**
	 * TimeSheetEntry constructor
	 * @param date the date for the entry
	 * @param projectId the id for the project the time is charged against
	 * @param hours logged for the date
	 */
	public TimeSheetEntry(String date, String projectId, String hours) {
		setDate(Formatter.convertToDate(date));
		ProjectMapper mapper = (ProjectMapper)MapperFactory.getSystemMapperFactory().getMapper(Project.class);
		Project proj  = null;
		try {
		proj = mapper.findById(projectId);
		} catch (MappingException e) {
			// Should throw something here.  Don't eat it.
		}
		setProject(proj);
		setHours(Float.parseFloat(hours));
	}
	
	/**
	 * Gets the date property (java.util.Calendar) value.
	 * @return The date property value.
	 * @see #setDate
	 */
	public java.util.Calendar getDate() {
		return fieldDate;
	}
	/**
	 * Return the formatted date for this TimeSheetEntry
	 * Creation date: (5/15/2000 9:30:58 PM)
	 * @return java.lang.String
	 */
	public String getFormattedDate() {
		return Formatter.dateFormat(getDate());
	}
	/**
	 * Gets the hours property (double) value.
	 * @return The hours property value.
	 * @see #setHours
	 */
	public double getHours() {
		return fieldHours;
	}
	/**
	 * Gets the project property (com.wsbook.casestudy.domain.Project) value.
	 * @return The project property value.
	 * @see #setProject
	 */
	public Project getProject() {
		return fieldProject;
	}
	/**
	 * Gets the timeSheetEntryID property (java.lang.String) value.
	 * @return The timeSheetEntryID property value.
	 * @see #setTimeSheetEntryID
	 */
	public int getTimeSheetEntryID() {
		return fieldTimeSheetEntryID;
	}
	/**
	 * Sets the date property (java.util.Calendar) value.
	 * @param date The new value for the property.
	 * @see #getDate
	 */
	public void setDate(java.util.Calendar date) {
		fieldDate = date;
	}
	/**
	 * Sets the hours property (double) value.
	 * @param hours The new value for the property.
	 * @see #getHours
	 */
	public void setHours(double hours) {
		fieldHours = hours;
	}
	/**
	 * Sets the project property (com.wsbook.casestudy.domain.Project) value.
	 * @param project The new value for the property.
	 * @see #getProject
	 */
	public void setProject(Project project) {
		fieldProject = project;
	}
	/**
	 * Sets the timeSheetEntryID property (java.lang.String) value.
	 * @param timeSheetEntryID The new value for the property.
	 * @see #getTimeSheetEntryID
	 */
	public void setTimeSheetEntryID(int timeSheetEntryID) {
		fieldTimeSheetEntryID = timeSheetEntryID;
	}
	/**
	 * Gets the timeSheet
	 * @return Returns a TimeSheet
	 */
	public TimeSheet getTimeSheet() {
		return timeSheet;
	}
	/**
	 * Sets the timeSheet
	 * @param timeSheet The timeSheet to set
	 */
	public void setTimeSheet(TimeSheet timeSheet) {
		this.timeSheet = timeSheet;
	}

}
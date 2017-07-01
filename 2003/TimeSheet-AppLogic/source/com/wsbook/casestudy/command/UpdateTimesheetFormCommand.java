package com.wsbook.casestudy.command;

import java.io.Serializable;

import com.wsbook.casestudy.domain.TimeSheet;
import com.wsbook.casestudy.domain.TimeSheetEntry;
import com.wsbook.casestudy.exception.ModelException;
import com.wsbook.casestudy.mapping.MapperFactory;
import com.wsbook.casestudy.mapping.TimeSheetEntryMapper;
import com.wsbook.casestudy.mapping.TimeSheetMapper;

public class UpdateTimesheetFormCommand implements Serializable {

	/**
	 * Constructor for TimesheetForm
	 */
	public UpdateTimesheetFormCommand() {
		super();
	}

	// ------------------ Instance Variables
	private String employeeId;
	private String weekending;
	private int[] removeEntryId;
	private String addDate;
	private String addProjectId;
	private String addHours;
	// ------------------- Public Methods

	/**
	 * Gets the employeeId
	 * @return Returns a String
	 */
	public String getEmployeeId() {
		return employeeId;
	}
	/**
	 * Sets the employeeId
	 * @param employeeId The employeeId to set
	 */
	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}

	/**
	 * Gets the weekending
	 * @return Returns a String
	 */
	public String getWeekending() {
		return weekending;
	}
	/**
	 * Sets the weekending
	 * @param weekending The weekending to set
	 */
	public void setWeekending(String weekending) {
		this.weekending = weekending;
	}

	/**
	 * Gets the addDate
	 * @return Returns a String
	 */
	public String getAddDate() {
		return addDate;
	}
	/**
	 * Sets the addDate
	 * @param addDate The addDate to set
	 */
	public void setAddDate(String addDate) {
		this.addDate = addDate;
	}

	/**
	 * Gets the addProjectId
	 * @return Returns a String
	 */
	public String getAddProjectId() {
		return addProjectId;
	}
	/**
	 * Sets the addProjectId
	 * @param addProjectId The addProjectId to set
	 */
	public void setAddProjectId(String addProjectId) {
		this.addProjectId = addProjectId;
	}

	/**
	 * Gets the addHours
	 * @return Returns a String
	 */
	public String getAddHours() {
		return addHours;
	}
	/**
	 * Sets the addHours
	 * @param addHours The addHours to set
	 */
	public void setAddHours(String addHours) {
		this.addHours = addHours;
	}

	private boolean validateAddEntryData() {
		String date = getAddDate();
		if (date == null
			|| date.equals("")
			|| date.charAt(2) != '/'
			|| date.charAt(5) != '/')
			return false;
		String project = getAddProjectId();
		if (project == null || project.equals(""))
			return false;
		String hours = getAddHours();
		if (hours == null || hours.equals(""))
			return false;
		try {
			Float.parseFloat(hours);
			return true;
		} catch (NumberFormatException nfe) {
			return false;
		}
	}

	/**
	 * Create a new TimeSheetEntry from add properties
	 * @return a new TimeSheetEntry
	 */
	public TimeSheetEntry getEntry() {
		if (validateAddEntryData())
			return new TimeSheetEntry(getAddDate(), getAddProjectId(), getAddHours());
		else
			return null;
	}

	/**
	 * Command execution
	 * Given the encoded add and remove TimeSheetEntry commands, update the 
	 * corresponding TimeSheet.
	 */
	public TimeSheet updateTimesheet() throws ModelException {
		TimeSheet tsheet = null;
		TimeSheetMapper tsMapper =
			(TimeSheetMapper) MapperFactory.getSystemMapperFactory().getMapper(
				TimeSheet.class);

		TimeSheetEntryMapper entryMapper =
			(TimeSheetEntryMapper) MapperFactory.getSystemMapperFactory().getMapper(
				TimeSheetEntry.class);
		try {
			// get the controlling TimeSheet
			tsheet = tsMapper.findByKey(getEmployeeId(), getWeekending());

			// process command
			// check if there are any Entries to be removed
			int[] removeIds = getRemoveEntryId();
			if (removeIds != null) {
				for (int i = 0; i < removeIds.length; i++) {
					tsheet = entryMapper.removeByKey(tsheet.getTimesheetID(), removeIds[i]);
				}
			}

			TimeSheetEntry entry = getEntry();
			// check if there is an Entry to be added
			if (entry != null) {
				// Persist 
				tsheet = tsMapper.addEntry(tsheet.getTimesheetID(), entry);
			}
			return tsheet;
		} catch (Exception e) {
			throw new ModelException(e, "Exception caught in updateTimesheet");
		}
	}

	/**
	 * Gets the removeEntryId
	 * @return Returns a String[]
	 */
	public int[] getRemoveEntryId() {
		return removeEntryId;
	}
	/**
	 * Sets the removeEntryId
	 * @param removeEntryId The removeEntryId to set
	 */
	public void setRemoveEntryId(String[] removeEntryId) {
		if (removeEntryId != null) {
			int removeItems = removeEntryId.length;
			this.removeEntryId = new int[removeItems];
			for (int i=0; i<removeItems; i++) {
				this.removeEntryId[i] = Integer.parseInt(removeEntryId[i]);
			}
		}
	}

}
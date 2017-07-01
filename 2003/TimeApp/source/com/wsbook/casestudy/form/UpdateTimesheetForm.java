package com.wsbook.casestudy.form;

import javax.servlet.http.HttpServletRequest;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;

import com.wsbook.casestudy.domain.TimeSheet;
import com.wsbook.casestudy.domain.TimeSheetEntry;
import com.wsbook.casestudy.mapping.MapperFactory;
import com.wsbook.casestudy.mapping.TimeSheetEntryMapper;
import com.wsbook.casestudy.mapping.TimeSheetMapper;

public class UpdateTimesheetForm extends ActionForm {

	/**
	 * Constructor for TimesheetForm
	 */
	public UpdateTimesheetForm() {
		super();
	}

    // ------------------ Instance Variables
	private String submitterId;
	private String weekending;
	private String[] removeEntryId;
	private String addDate;
	private String addProjectId;
	private String addHours;
    // ------------------- Public Methods
    /**
     * Reset all properties to their default values.
     *
     * @param mapping The mapping used to select this instance
     * @param request The servlet request we are processing
     */
    public void reset(ActionMapping mapping, HttpServletRequest request) {
        this.submitterId = null;
        this.weekending = null;
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
	
	/**
	 * Gets the removeEntryId
	 * @return Returns a String[]
	 */
	public String[] getRemoveEntryId() {
		return removeEntryId;
	}
	/**
	 * Sets the removeEntryId
	 * @param removeEntryId The removeEntryId to set
	 */
	public void setRemoveEntryId(String[] removeEntryId) {
		this.removeEntryId = removeEntryId;
	}

	/**
	 * Returns the submitterId.
	 * @return String
	 */
	public String getSubmitterId() {
		return submitterId;
	}

	/**
	 * Sets the submitterId.
	 * @param submitterId The submitterId to set
	 */
	public void setSubmitterId(String submitterId) {
		this.submitterId = submitterId;
	}

}


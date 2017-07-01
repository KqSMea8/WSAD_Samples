package com.wsbook.casestudy.form;

import javax.servlet.http.HttpServletRequest;
import org.apache.struts.action.ActionError;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;

public class DateFormatForm extends ActionForm {

	/**
	 * Constructor for TimesheetForm
	 */
	public DateFormatForm() {
		super();
	}

    // ------------------ Instance Variables
    /**
     * The format string.
     */
    private String dateString = null;

    // ------------------- Public Methods
    /**
     * Reset all properties to their default values.
     *
     * @param mapping The mapping used to select this instance
     * @param request The servlet request we are processing
     */
    public void reset(ActionMapping mapping, HttpServletRequest request) {
        this.dateString = null;
    }
   /**
     * Validate the properties that have been set from this HTTP request,
     * and return an <code>ActionErrors</code> object that encapsulates any
     * validation errors that have been found.  If no errors are found, return
     * <code>null</code> or an <code>ActionErrors</code> object with no
     * recorded error messages.
     *
     * @param mapping The mapping used to select this instance
     * @param request The servlet request we are processing
     */
    public String validateInput() {
        return null;
    }


	/**
	 * Gets the dateString
	 * @return Returns a String
	 */
	public String getDateString() {
		return dateString;
	}
	/**
	 * Sets the dateString
	 * @param dateString The dateString to set
	 */
	public void setDateString(String dateString) {
		this.dateString = dateString;
	}

}


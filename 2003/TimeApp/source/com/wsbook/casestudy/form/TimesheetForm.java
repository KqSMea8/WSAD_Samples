package com.wsbook.casestudy.form;

import java.util.Calendar;
import javax.servlet.http.HttpServletRequest;
import org.apache.struts.action.ActionError;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;

import com.wsbook.casestudy.util.Formatter;

public class TimesheetForm extends ActionForm {

	/**
	 * Constructor for TimesheetForm
	 */
	public TimesheetForm() {
		super();
	}

	/**
	 * The submitter Id.
	 */

	private String submitterId = null;

	/**
	 * The week end
	 */

	private String weekending = null;

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
	  * Validate the properties that have been set from this HTTP request,
	  * and return an <code>ActionErrors</code> object that encapsulates any
	  * validation errors that have been found.  If no errors are found, return
	  * <code>null</code> or an <code>ActionErrors</code> object with no
	  * recorded error messages.
	  *
	  * @param mapping The mapping used to select this instance
	  * @param request The servlet request we are processing
	  */
public ActionErrors validate(ActionMapping mapping, HttpServletRequest req) {
	ActionErrors errors = new ActionErrors();

		if ((submitterId == null) || (submitterId.length() < 1))
			errors.add("submitter",new ActionError("errors.missing.submitter"));
		if ((weekending == null) || (weekending.length() < 1))
			errors.add("weekending", new ActionError("errors.missing.weekending"));

		Formatter fmt = Formatter.getDefaultFormatter();
		Calendar dt = fmt.convertToDate(weekending);
		if (dt == null)
			errors.add("weekendingformat", new ActionError("errors.weekending.format"));

		return errors;
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

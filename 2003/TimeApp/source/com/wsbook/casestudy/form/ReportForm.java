package com.wsbook.casestudy.form;

import javax.servlet.http.HttpServletRequest;
import org.apache.struts.action.ActionError;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;

public class ReportForm extends ActionForm {
	private String primary;
	private String secondary;
	/**
	 * Constructor for TimesheetForm
	 */
	public ReportForm() {
		super();
	}

    // ------------------- Public Methods
    /**
     * Reset all properties to their default values.
     *
     * @param mapping The mapping used to select this instance
     * @param request The servlet request we are processing
     */
    public void reset(ActionMapping mapping, HttpServletRequest request) {

        this.primary = null;
        this.secondary = null;

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
	 * Gets the primary
	 * @return Returns a String
	 */
	public String getPrimary() {
		return primary;
	}
	/**
	 * Sets the primary
	 * @param primary The primary to set
	 */
	public void setPrimary(String primary) {
		this.primary = primary;
	}

	/**
	 * Gets the secondary
	 * @return Returns a String
	 */
	public String getSecondary() {
		return secondary;
	}
	/**
	 * Sets the secondary
	 * @param secondary The secondary to set
	 */
	public void setSecondary(String secondary) {
		this.secondary = secondary;
	}
	
	public boolean isByEmployeeFirst() {
		return "employee".equals(primary);
	}
	
	public boolean isByProjectFirst() {
		return "project".equals(primary);
	}

	public boolean isByEmployeeSecond() {
		return "employee".equals(secondary);
	}

	public boolean isByMonthSecond() {
		return "month".equals(secondary);
	}

	public boolean isByProjectSecond() {
		return "project".equals(secondary);
	}

}


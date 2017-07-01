package com.wsbook.casestudy.form;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionError;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;

/**
 * @author kbrown
 *
 * To change this generated comment edit the template variable "typecomment":
 * Window>Preferences>Java>Templates.
 * To enable and disable the creation of type comments go to
 * Window>Preferences>Java>Code Generation.
 */
public class ApprovingTimesheetForm extends TimesheetForm {
	
	private String approverId;
	/**
	 * Constructor for ApprovingTimesheetForm.
	 */
	public ApprovingTimesheetForm() {
		super();
	}

	/**
	 * Returns the approverId.
	 * @return String
	 */
	public String getApproverId() {
		return approverId;
	}

	/**
	 * Sets the approverId.
	 * @param approverId The approverId to set
	 */
	public void setApproverId(String approverId) {
		this.approverId = approverId;
	}
	
	public ActionErrors validate(ActionMapping mapping, HttpServletRequest req) {

		ActionErrors errors = super.validate(mapping,req);
		
		if ((approverId == null) || (approverId.length() < 1))
			errors.add("approver",new ActionError("errors.missing.approver"));
			
		return errors;
	}

}

package com.wsbook.casestudy.action;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionError;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.wsbook.casestudy.domain.Employee;
import com.wsbook.casestudy.domain.TimeSheet;
import com.wsbook.casestudy.exception.MappingException;
import com.wsbook.casestudy.exception.NoSuchEmployeeException;
import com.wsbook.casestudy.form.TimesheetForm;
import com.wsbook.casestudy.model.ActionProcessorFactory;
import com.wsbook.casestudy.model.TimeSheetActionProcessor;
import com.wsbook.casestudy.system.AppService;
import com.wsbook.casestudy.system.TraceCapable;
import com.wsbook.casestudy.util.Formatter;
import com.wsbook.casestudy.value.BeanKeys;
import com.wsbook.casestudy.value.WeekEndings;

public class DisplayTimeSheetForApprovalAction extends TimeAppAction {

	/**
	 * Constructor for ListPendingTimeSheetsAction
	 */
	public DisplayTimeSheetForApprovalAction() {
		super();
	}

	/**
	 * @see Action#perform(ActionMapping, ActionForm, HttpServletRequest, HttpServletResponse)
	 */
	public ActionForward perform(
		ActionMapping mapping,
		ActionForm form,
		HttpServletRequest request,
		HttpServletResponse response)
		throws IOException, ServletException {

		// Look at the ActionForm object
		TimesheetForm tsForm = (TimesheetForm) form;
		ActionForward forward = null;
		String msg = null;
		if (tsForm != null) {

			// See if corresponding Timesheet exists
			TimeSheet timeSheet = null;
			try {
				TimeSheetActionProcessor processor =
					(
						TimeSheetActionProcessor) ActionProcessorFactory
							.getActionProcessor(
						"TimeSheet");
				timeSheet =
					processor.findTimeSheetByKey(
						tsForm.getSubmitterId(),
						tsForm.getWeekending());
				if (timeSheet != null) {
					request.setAttribute("timesheet", timeSheet);
					addEmployeesBean(request);
					forward = mapping.findForward("displayForApproval");
				} else { // setup to list weekend dates for employee
					forward = mapping.findForward("error");
				}
			} catch (MappingException e) {
				// Handle this as an unrecoverable error
				AppService.log(TraceCapable.ERROR_LEVEL,"Exception caught in EmployeeTimeSheetAction.perform:" + e);
				forward = mapping.findForward("error");
			}

		}
		return forward;
	}
}
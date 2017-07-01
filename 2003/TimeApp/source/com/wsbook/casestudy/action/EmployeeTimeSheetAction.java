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

public class EmployeeTimeSheetAction extends TimeAppAction {

	/**
	 * Constructor for ListPendingTimeSheetsAction
	 */
	public EmployeeTimeSheetAction() {
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
					addProjectsBean(request);
					if (timeSheet.isPending())
						forward = mapping.findForward("pending");
					else
						forward = mapping.findForward("approved");
				} else { // setup to list weekend dates for employee
					WeekEndings weekendings =
						processor.getWeekEndings(tsForm.getSubmitterId());
					request.setAttribute("weekendings", weekendings);
					Employee employee =
						processor.findEmployeeByKey(tsForm.getSubmitterId());
					request.setAttribute("employee", employee);
					request.setAttribute("create", tsForm.getWeekending());
					forward = mapping.findForward("select");
				}
			} catch (NoSuchEmployeeException e) {
				// Handle this as a recoverable error (even though the display shouldn't allow this)
				ActionErrors errors = new ActionErrors();
				ActionError err= new ActionError("errors.no.such.employee");
				errors.add("no such employee", err);
				saveErrors(request,errors);
				forward = mapping.findForward("tryagain");
			} catch (MappingException e) {
				// Handle this as an unrecoverable error
				AppService.log(TraceCapable.ERROR_LEVEL,"Exception caught in EmployeeTimeSheetAction.perform:" + e);
				forward = mapping.findForward("error");
			}

		}
		return forward;
	}
}
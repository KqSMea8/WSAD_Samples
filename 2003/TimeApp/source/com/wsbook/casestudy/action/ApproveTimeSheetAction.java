package com.wsbook.casestudy.action;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.wsbook.casestudy.domain.TimeSheet;
import com.wsbook.casestudy.exception.ModelException;
import com.wsbook.casestudy.exception.NoSuchEmployeeException;
import com.wsbook.casestudy.form.ApprovingTimesheetForm;
import com.wsbook.casestudy.form.TimesheetForm;
import com.wsbook.casestudy.model.ActionProcessorFactory;
import com.wsbook.casestudy.model.TimeSheetActionProcessor;
import com.wsbook.casestudy.system.AppService;
import com.wsbook.casestudy.system.TraceCapable;
import com.wsbook.casestudy.value.BeanKeys;
import com.wsbook.casestudy.value.Projects;

public class ApproveTimeSheetAction extends TimeAppAction {

	/**
	 * Constructor for ListPendingTimeSheetsAction
	 */
	public ApproveTimeSheetAction() {
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

		ApprovingTimesheetForm tsForm = (ApprovingTimesheetForm) form;
		TimeSheet timeSheet = null;
		
		// invoke approve behavior on Model
		TimeSheetActionProcessor processor =
			(TimeSheetActionProcessor) ActionProcessorFactory.getActionProcessor(
				"TimeSheet");
				
		try {
		timeSheet =
			processor.approveTimeSheetByKey(tsForm.getSubmitterId(), tsForm.getWeekending(), tsForm.getApproverId());
		} catch (Exception e) {
			AppService.log(TraceCapable.ERROR_LEVEL,"Exception caught in ApproveTimeSheetAction.perform:" + e);
			ActionForward forward = mapping.findForward("error");
			return forward;
		}

		request.setAttribute("timesheet", timeSheet);
		ActionForward forward = mapping.findForward("approved");
		return forward;

	}

}
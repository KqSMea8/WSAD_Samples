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

import com.wsbook.casestudy.command.UpdateTimesheetFormCommand;
import com.wsbook.casestudy.domain.TimeSheet;
import com.wsbook.casestudy.exception.NoSuchEmployeeException;
import com.wsbook.casestudy.form.UpdateTimesheetForm;
import com.wsbook.casestudy.model.ActionProcessorFactory;
import com.wsbook.casestudy.model.TimeSheetActionProcessor;
import com.wsbook.casestudy.system.AppService;
import com.wsbook.casestudy.system.TraceCapable;
import com.wsbook.casestudy.value.BeanKeys;
import com.wsbook.casestudy.value.Projects;

public class UpdateTimeSheetAction extends TimeAppAction {

	/**
	 * Constructor for ListPendingTimeSheetsAction
	 */
	public UpdateTimeSheetAction() {
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
		UpdateTimesheetForm tsForm = (UpdateTimesheetForm) form;
		
		// Build the command object
		UpdateTimesheetFormCommand updateCommand = buildCommand(tsForm);

		TimeSheet timeSheet = null;
		try {
			TimeSheetActionProcessor processor =
				(TimeSheetActionProcessor) ActionProcessorFactory.getActionProcessor(
					"TimeSheet");
			timeSheet =
				processor.updateTimesheet(updateCommand);
		} catch (Exception e) {
			AppService.log(TraceCapable.ERROR_LEVEL,"Exception caught in TimeSheetSelectAction.perform:" + e);
			ActionForward forward = mapping.findForward("error");
			return forward;
		}

		addProjectsBean(request);
		request.setAttribute("timesheet", timeSheet);
		ActionForward forward = mapping.findForward("pending");
		return forward;

	}

	protected UpdateTimesheetFormCommand buildCommand(UpdateTimesheetForm tsForm) {
		UpdateTimesheetFormCommand updateCommand = new UpdateTimesheetFormCommand();
		updateCommand.setAddDate(tsForm.getAddDate());
		updateCommand.setAddHours(tsForm.getAddHours());
		updateCommand.setAddProjectId(tsForm.getAddProjectId());
		updateCommand.setEmployeeId(tsForm.getSubmitterId());
		updateCommand.setWeekending(tsForm.getWeekending());
		updateCommand.setRemoveEntryId(tsForm.getRemoveEntryId());
		return updateCommand;
	}

}
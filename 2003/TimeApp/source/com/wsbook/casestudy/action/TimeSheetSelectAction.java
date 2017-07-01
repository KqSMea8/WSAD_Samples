package com.wsbook.casestudy.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.wsbook.casestudy.domain.Employee;
import com.wsbook.casestudy.domain.TimeSheet;
import com.wsbook.casestudy.exception.MappingException;
import com.wsbook.casestudy.exception.ModelException;
import com.wsbook.casestudy.exception.NoSuchEmployeeException;
import com.wsbook.casestudy.form.TimesheetForm;
import com.wsbook.casestudy.model.ActionProcessorFactory;
import com.wsbook.casestudy.model.TimeSheetActionProcessor;
import com.wsbook.casestudy.system.AppService;
import com.wsbook.casestudy.system.TraceCapable;
import com.wsbook.casestudy.value.BeanKeys;
import com.wsbook.casestudy.value.WeekEndings;

public class TimeSheetSelectAction extends TimeAppAction {

	/**
	 * Constructor for ListPendingTimeSheetsAction
	 */
	public TimeSheetSelectAction() {
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
		TimeSheet timeSheet = null;
		if (tsForm != null) {
				TimeSheetActionProcessor processor =
					(
						TimeSheetActionProcessor) ActionProcessorFactory
							.getActionProcessor(
						"TimeSheet");
				try {
					timeSheet =
						processor.findOrCreateTimeSheetByKey(
							tsForm.getSubmitterId(),
							tsForm.getWeekending());
				} catch (MappingException e) {
					AppService.log(TraceCapable.ERROR_LEVEL,"Exception caught in TimeSheetSelectAction.perform:" + e);
					forward = mapping.findForward("error");
					return forward;
				} catch (ModelException me) {
					AppService.log(TraceCapable.ERROR_LEVEL,"Exception caught in TimeSheetSelectAction.perform:" + me);
					forward = mapping.findForward("error");
					return forward;
				}
				if (timeSheet != null) {
					request.setAttribute("timesheet", timeSheet);
					addProjectsBean(request);
					if (timeSheet.isPending())
						forward = mapping.findForward("pending");
					else
						forward = mapping.findForward("approved");
				}

		}
		if (timeSheet == null) {
			//  Under what situation could this possibly occur?
			addEmployeesBean(request);
			request.setAttribute(BeanKeys.MSG, msg);
			forward = mapping.findForward("tryagain");
		}
		return forward;

	}

}
package com.wsbook.casestudy.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.wsbook.casestudy.exception.MappingException;
import com.wsbook.casestudy.model.ActionProcessorFactory;
import com.wsbook.casestudy.model.TimeSheetActionProcessor;
import com.wsbook.casestudy.value.BeanKeys;
import com.wsbook.casestudy.value.TimeSheets;

public class ListPendingTimeSheetsAction extends Action {

	/**
	 * Constructor for ListPendingTimeSheetsAction
	 */
	public ListPendingTimeSheetsAction() {
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

		// There is no precondition
		// Get actionprocess (model) and delegate
		ActionForward forward = null;
		try {
			TimeSheetActionProcessor processor =
				(
					TimeSheetActionProcessor) ActionProcessorFactory
						.getActionProcessor(
					"TimeSheet");
			TimeSheets sheets = processor.getPendingTimeSheets();
			if (sheets != null) {
				// Add ValueBean to request context and forward response
				request.setAttribute(BeanKeys.PENDING, sheets);
				forward = mapping.findForward("success");
				if (forward == null) {
					forward = mapping.findForward("error");
				}
			} else
				forward = mapping.findForward("error");
		} catch (MappingException e) {
			forward = mapping.findForward("error");
		}

		return forward;
	}

}
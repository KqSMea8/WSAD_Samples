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

public class ListApprovedTimeSheetsAction extends Action {

	/**
	 * Constructor for ListApprovedTimeSheetsAction
	 */
	public ListApprovedTimeSheetsAction() {
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
		ActionForward forward = null;
		try {
			// There is no precondition
			// Get actionprocess (model) and delegate
			TimeSheetActionProcessor processor =
				(
					TimeSheetActionProcessor) ActionProcessorFactory
						.getActionProcessor(
					"TimeSheet");
			TimeSheets sheets = processor.getApprovedTimeSheets();

			// Add ValueBean to request context and forward response
			request.setAttribute(BeanKeys.APPROVED, sheets);
			forward = mapping.findForward("success");
		} catch (MappingException e) {
		}
		if (forward == null) {
			forward = mapping.findForward("error");
		}
		return forward;

	}

}

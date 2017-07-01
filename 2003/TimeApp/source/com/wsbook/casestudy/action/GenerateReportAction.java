package com.wsbook.casestudy.action;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.wsbook.casestudy.exception.ModelException;
import com.wsbook.casestudy.form.ReportForm;
import com.wsbook.casestudy.model.ActionProcessorFactory;
import com.wsbook.casestudy.model.ReportActionProcessor;
import com.wsbook.casestudy.value.BeanKeys;
import com.wsbook.casestudy.value.Report;

public class GenerateReportAction extends Action {

	/**
	 * Constructor for ListPendingTimeSheetsAction
	 */
	public GenerateReportAction() {
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
		ReportForm dForm = (ReportForm) form;
		Report report = null;

		// Get actionprocess (model) and delegate
		ReportActionProcessor processor =
			(ReportActionProcessor) ActionProcessorFactory.getActionProcessor(
				"Report");

		try {
			if (dForm.isByEmployeeFirst() && dForm.isByMonthSecond())
				report = processor.generateEmployeeByMonthReport();
		} catch (ModelException e) {
			ActionForward forward = mapping.findForward("error");
			return forward;
		}

		request.setAttribute(BeanKeys.REPORT, report);

		ActionForward forward = mapping.findForward("success");
		if (forward == null) {
			forward = mapping.findForward("error");
		}
		return forward;

	}

}
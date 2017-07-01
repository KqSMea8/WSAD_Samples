package com.wsbook.casestudy.action;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.wsbook.casestudy.form.DateFormatForm;
import com.wsbook.casestudy.util.Formatter;
import com.wsbook.casestudy.value.BeanKeys;

public class SetDateFormatAction extends TimeAppAction {

	/**
	 * Constructor for ListPendingTimeSheetsAction
	 */
	public SetDateFormatAction() {
		super();
	}

	/**
	 * @see Action#perform(ActionMapping, ActionForm, HttpServletRequest, HttpServletResponse)
	 */
	public ActionForward perform(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
		throws IOException, ServletException {

		// Look at the ActionForm object
		DateFormatForm dForm = (DateFormatForm) form;
		// There is no precondition just update Session date format and forward
		request.getSession().setAttribute(BeanKeys.DATEFORMAT, Formatter.findFormatter(dForm.getDateString()));

		ActionForward forward = mapping.findForward("success");
		if (forward == null) {
			forward = mapping.findForward("error");
		}
		return forward;

	}

}
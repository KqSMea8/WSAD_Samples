package com.wsbook.casestudy.action;

import java.util.ArrayList;
import java.util.Vector;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.Action;

import com.wsbook.casestudy.exception.MappingException;
import com.wsbook.casestudy.exception.ModelException;
import com.wsbook.casestudy.model.ActionProcessorFactory;
import com.wsbook.casestudy.model.TimeSheetActionProcessor;
import com.wsbook.casestudy.value.BeanKeys;
import com.wsbook.casestudy.value.Employees;
import com.wsbook.casestudy.value.Projects;

public class TimeAppAction extends Action {

	/**
	 * Constructor for ListPendingTimeSheetsAction
	 */
	public TimeAppAction() {
		super();
	}

	protected void addEmployeesBean(HttpServletRequest request) {
		
		HttpSession session = request.getSession();
		if (session.getAttribute(BeanKeys.EMPLOYEES) != null)
			return;
		TimeSheetActionProcessor processor =
			(
				TimeSheetActionProcessor) ActionProcessorFactory
					.getActionProcessor(
				"TimeSheet");
		ArrayList employees = null;
		try {
			employees = processor.findAllEmployees();
		} catch (MappingException mme) {
			// Should not eat exception
		} catch (ModelException me) {
		}

		// Add ValueBean to request context and forward response
		// request.setAttribute(BeanKeys.EMPLOYEES, employees);

		session.setAttribute(BeanKeys.EMPLOYEES, employees);
	}

	protected void addProjectsBean(HttpServletRequest request) {
		TimeSheetActionProcessor processor =
			(
				TimeSheetActionProcessor) ActionProcessorFactory
					.getActionProcessor(
				"TimeSheet");
		ArrayList projs = null;
		try {
			projs = processor.findAllProjects();
		} catch (ModelException me) {
			// Should not eat exception
		}
		Projects projects = new Projects(projs);
		request.setAttribute(BeanKeys.PROJECTS, projects);
	}
}

package com.wsbook.casestudy.model;

import java.io.Serializable;

import com.wsbook.casestudy.exception.ModelException;
import com.wsbook.casestudy.value.Report;

/**
 * Application Model interface for Report generation services.
 */
public interface ReportActionProcessor extends Serializable {
	
	/**
	 * Build a Report that collects timesheet summary for each employee broken 
	 * down by month of the year.
	 * @returns appropriate populated Report object.
	 */
	public Report generateEmployeeByMonthReport() throws ModelException;
}


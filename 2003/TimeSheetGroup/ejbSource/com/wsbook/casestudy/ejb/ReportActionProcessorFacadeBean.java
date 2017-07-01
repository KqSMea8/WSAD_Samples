package com.wsbook.casestudy.ejb;

import javax.ejb.CreateException;
import javax.ejb.SessionBean;
import javax.ejb.SessionContext;

import com.wsbook.casestudy.exception.ModelException;
import com.wsbook.casestudy.model.helper.ReporterModelHelper;
import com.wsbook.casestudy.value.Report;

/**
 * Bean implementation class for Enterprise Bean: ReportActionProcessorFacade
 */
public class ReportActionProcessorFacadeBean implements javax.ejb.SessionBean {
	private javax.ejb.SessionContext mySessionCtx;
	/**
	 * getSessionContext
	 */
	public javax.ejb.SessionContext getSessionContext() {
		return mySessionCtx;
	}
	/**
	 * setSessionContext
	 */
	public void setSessionContext(javax.ejb.SessionContext ctx) {
		mySessionCtx = ctx;
	}
	/**
	 * ejbActivate
	 */
	public void ejbActivate() {
	}
	/**
	 * ejbCreate
	 */
	public void ejbCreate() throws javax.ejb.CreateException {
	}
	/**
	 * ejbPassivate
	 */
	public void ejbPassivate() {
	}
	/**
	 * ejbRemove
	 */
	public void ejbRemove() {
	}
	
	public Report generateEmployeeByMonthReport() throws ModelException {
		return (new ReporterModelHelper()).generateEmployeeReportByMonth();
	}
	
}

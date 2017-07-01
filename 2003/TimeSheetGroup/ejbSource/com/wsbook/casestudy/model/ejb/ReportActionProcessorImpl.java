package com.wsbook.casestudy.model.ejb;

import java.rmi.RemoteException;

import com.wsbook.casestudy.ejb.ReportActionProcessorFacade;
import com.wsbook.casestudy.ejb.ReportActionProcessorFacadeHome;
import com.wsbook.casestudy.exception.ModelException;
import com.wsbook.casestudy.model.ReportActionProcessor;
import com.wsbook.casestudy.system.AppService;
import com.wsbook.casestudy.system.TraceCapable;
import com.wsbook.casestudy.util.EJBClientHelper;
import com.wsbook.casestudy.value.Report;

public class ReportActionProcessorImpl implements ReportActionProcessor {

	/**
	 * Access (create) an instance of the TimeSheetActionProcessorFacade
	 */
	protected ReportActionProcessorFacade getRAPFacade() {
		try {
			return (
				(ReportActionProcessorFacadeHome) EJBClientHelper.getHome("ReportActionProcessor", ReportActionProcessorFacadeHome.class))
				.create();
		} catch (Exception e) {
			AppService.log(TraceCapable.ERROR_LEVEL,"Error generating Report Facade, Exception:" + e);
			return null;
		}
	}

	/**
	* @see ReportActionProcessor#generateEmployeeByMonthReport()
	*/
	public Report generateEmployeeByMonthReport() {
		ReportActionProcessorFacade modelFacade = null;
		try {
			modelFacade = getRAPFacade();
			if (modelFacade != null)
				return modelFacade.generateEmployeeByMonthReport();
			return null;
		} catch (RemoteException re) {
			return null;
		} catch (ModelException me) {
			return null;
		} finally {
			try {
				modelFacade.remove();
			} catch (Exception e) {
			}
		}
	}

}

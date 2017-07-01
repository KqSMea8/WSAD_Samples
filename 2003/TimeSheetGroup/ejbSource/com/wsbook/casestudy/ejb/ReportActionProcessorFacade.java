package com.wsbook.casestudy.ejb;

import java.rmi.RemoteException;
import javax.ejb.EJBObject;
import com.wsbook.casestudy.exception.ModelException;
import com.wsbook.casestudy.value.Report;

/**
 * Remote interface for Enterprise Bean: ReportActionProcessorFacade
 */
public interface ReportActionProcessorFacade extends javax.ejb.EJBObject {
	public Report generateEmployeeByMonthReport()
		throws ModelException, java.rmi.RemoteException;
}

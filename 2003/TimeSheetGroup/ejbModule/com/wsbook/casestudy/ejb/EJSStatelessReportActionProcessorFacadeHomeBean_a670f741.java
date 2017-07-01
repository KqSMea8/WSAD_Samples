package com.wsbook.casestudy.ejb;

import com.ibm.ejs.container.*;

/**
 * EJSStatelessReportActionProcessorFacadeHomeBean_a670f741
 */
public class EJSStatelessReportActionProcessorFacadeHomeBean_a670f741 extends EJSHome {
	/**
	 * EJSStatelessReportActionProcessorFacadeHomeBean_a670f741
	 */
	public EJSStatelessReportActionProcessorFacadeHomeBean_a670f741() throws java.rmi.RemoteException {
		super();	}
	/**
	 * create
	 */
	public com.wsbook.casestudy.ejb.ReportActionProcessorFacade create() throws javax.ejb.CreateException, java.rmi.RemoteException {
BeanO beanO = null;
com.wsbook.casestudy.ejb.ReportActionProcessorFacade result = null;
boolean createFailed = false;
try {
	result = (com.wsbook.casestudy.ejb.ReportActionProcessorFacade) super.createWrapper(new BeanId(this, null));
}
catch (javax.ejb.CreateException ex) {
	createFailed = true;
	throw ex;
} catch (java.rmi.RemoteException ex) {
	createFailed = true;
	throw ex;
} catch (Throwable ex) {
	createFailed = true;
	throw new CreateFailureException(ex);
} finally {
	if (createFailed) {
		super.createFailure(beanO);
	}
}
return result;	}
}

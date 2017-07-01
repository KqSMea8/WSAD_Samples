package com.wsbook.casestudy.ejb;

import com.ibm.ejs.container.*;

/**
 * EJSStatelessTimeSheetActionProcessorFacadeHomeBean_7ee0ab51
 */
public class EJSStatelessTimeSheetActionProcessorFacadeHomeBean_7ee0ab51 extends EJSHome {
	/**
	 * EJSStatelessTimeSheetActionProcessorFacadeHomeBean_7ee0ab51
	 */
	public EJSStatelessTimeSheetActionProcessorFacadeHomeBean_7ee0ab51() throws java.rmi.RemoteException {
		super();	}
	/**
	 * create
	 */
	public com.wsbook.casestudy.ejb.TimeSheetActionProcessorFacade create() throws javax.ejb.CreateException, java.rmi.RemoteException {
BeanO beanO = null;
com.wsbook.casestudy.ejb.TimeSheetActionProcessorFacade result = null;
boolean createFailed = false;
try {
	result = (com.wsbook.casestudy.ejb.TimeSheetActionProcessorFacade) super.createWrapper(new BeanId(this, null));
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

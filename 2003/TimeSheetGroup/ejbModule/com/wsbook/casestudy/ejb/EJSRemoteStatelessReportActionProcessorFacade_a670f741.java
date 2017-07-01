package com.wsbook.casestudy.ejb;

import com.ibm.ejs.container.*;

/**
 * EJSRemoteStatelessReportActionProcessorFacade_a670f741
 */
public class EJSRemoteStatelessReportActionProcessorFacade_a670f741 extends EJSWrapper implements ReportActionProcessorFacade {
	/**
	 * EJSRemoteStatelessReportActionProcessorFacade_a670f741
	 */
	public EJSRemoteStatelessReportActionProcessorFacade_a670f741() throws java.rmi.RemoteException {
		super();	}
	/**
	 * getDeployedSupport
	 */
	public com.ibm.ejs.container.EJSDeployedSupport getDeployedSupport() {
		return container.getEJSDeployedSupport(this);
	}
	/**
	 * putDeployedSupport
	 */
	public void putDeployedSupport(com.ibm.ejs.container.EJSDeployedSupport support) {
		container.putEJSDeployedSupport(support);
		return;
	}
	/**
	 * generateEmployeeByMonthReport
	 */
	public com.wsbook.casestudy.value.Report generateEmployeeByMonthReport() throws com.wsbook.casestudy.exception.ModelException, java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		com.wsbook.casestudy.value.Report _EJS_result = null;
		try {
			com.wsbook.casestudy.ejb.ReportActionProcessorFacadeBean beanRef = (com.wsbook.casestudy.ejb.ReportActionProcessorFacadeBean)container.preInvoke(this, 0, _EJS_s);
			_EJS_result = beanRef.generateEmployeeByMonthReport();
		}
		catch (com.wsbook.casestudy.exception.ModelException ex) {
			_EJS_s.setCheckedException(ex);
			throw ex;
		}
		catch (java.rmi.RemoteException ex) {
			_EJS_s.setUncheckedException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedException(ex);
			throw new java.rmi.RemoteException("bean method raised unchecked exception", ex);
		}

		finally {
			try{
				container.postInvoke(this, 0, _EJS_s);
			} finally {
				putDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
}

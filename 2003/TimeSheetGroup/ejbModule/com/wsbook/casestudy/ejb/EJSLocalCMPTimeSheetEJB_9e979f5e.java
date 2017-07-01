package com.wsbook.casestudy.ejb;

import com.ibm.ejs.container.*;
import java.rmi.RemoteException;

/**
 * EJSLocalCMPTimeSheetEJB_9e979f5e
 */
public class EJSLocalCMPTimeSheetEJB_9e979f5e extends EJSLocalWrapper implements com.wsbook.casestudy.ejb.TimeSheetEJB {
	/**
	 * EJSLocalCMPTimeSheetEJB_9e979f5e
	 */
	public EJSLocalCMPTimeSheetEJB_9e979f5e() {
		super();	}
	/**
	 * getApprover
	 */
	public com.wsbook.casestudy.ejb.EmployeeEJB getApprover() {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		com.wsbook.casestudy.ejb.EmployeeEJB _EJS_result = null;
		try {
			com.wsbook.casestudy.ejb.TimeSheetEJBBean beanRef = (com.wsbook.casestudy.ejb.TimeSheetEJBBean)container.preInvoke(this, 0, _EJS_s);
			_EJS_result = beanRef.getApprover();
		}
		catch (java.rmi.RemoteException ex) {
		 	_EJS_s.setUncheckedLocalException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedLocalException(ex);
		}

		finally {
			try {
				container.postInvoke(this, 0, _EJS_s);
			} catch ( RemoteException ex ) {
				_EJS_s.setUncheckedLocalException(ex);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * getSubmitter
	 */
	public com.wsbook.casestudy.ejb.EmployeeEJB getSubmitter() {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		com.wsbook.casestudy.ejb.EmployeeEJB _EJS_result = null;
		try {
			com.wsbook.casestudy.ejb.TimeSheetEJBBean beanRef = (com.wsbook.casestudy.ejb.TimeSheetEJBBean)container.preInvoke(this, 1, _EJS_s);
			_EJS_result = beanRef.getSubmitter();
		}
		catch (java.rmi.RemoteException ex) {
		 	_EJS_s.setUncheckedLocalException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedLocalException(ex);
		}

		finally {
			try {
				container.postInvoke(this, 1, _EJS_s);
			} catch ( RemoteException ex ) {
				_EJS_s.setUncheckedLocalException(ex);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * getState
	 */
	public java.lang.String getState() {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		java.lang.String _EJS_result = null;
		try {
			com.wsbook.casestudy.ejb.TimeSheetEJBBean beanRef = (com.wsbook.casestudy.ejb.TimeSheetEJBBean)container.preInvoke(this, 2, _EJS_s);
			_EJS_result = beanRef.getState();
		}
		catch (java.rmi.RemoteException ex) {
		 	_EJS_s.setUncheckedLocalException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedLocalException(ex);
		}

		finally {
			try {
				container.postInvoke(this, 2, _EJS_s);
			} catch ( RemoteException ex ) {
				_EJS_s.setUncheckedLocalException(ex);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * getWeekend
	 */
	public java.lang.String getWeekend() {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		java.lang.String _EJS_result = null;
		try {
			com.wsbook.casestudy.ejb.TimeSheetEJBBean beanRef = (com.wsbook.casestudy.ejb.TimeSheetEJBBean)container.preInvoke(this, 3, _EJS_s);
			_EJS_result = beanRef.getWeekend();
		}
		catch (java.rmi.RemoteException ex) {
		 	_EJS_s.setUncheckedLocalException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedLocalException(ex);
		}

		finally {
			try {
				container.postInvoke(this, 3, _EJS_s);
			} catch ( RemoteException ex ) {
				_EJS_s.setUncheckedLocalException(ex);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * getEntries
	 */
	public java.util.Collection getEntries() {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		java.util.Collection _EJS_result = null;
		try {
			com.wsbook.casestudy.ejb.TimeSheetEJBBean beanRef = (com.wsbook.casestudy.ejb.TimeSheetEJBBean)container.preInvoke(this, 4, _EJS_s);
			_EJS_result = beanRef.getEntries();
		}
		catch (java.rmi.RemoteException ex) {
		 	_EJS_s.setUncheckedLocalException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedLocalException(ex);
		}

		finally {
			try {
				container.postInvoke(this, 4, _EJS_s);
			} catch ( RemoteException ex ) {
				_EJS_s.setUncheckedLocalException(ex);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * setApprover
	 */
	public void setApprover(com.wsbook.casestudy.ejb.EmployeeEJB anApprover) {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		
		try {
			com.wsbook.casestudy.ejb.TimeSheetEJBBean beanRef = (com.wsbook.casestudy.ejb.TimeSheetEJBBean)container.preInvoke(this, 5, _EJS_s);
			beanRef.setApprover(anApprover);
		}
		catch (java.rmi.RemoteException ex) {
		 	_EJS_s.setUncheckedLocalException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedLocalException(ex);
		}

		finally {
			try {
				container.postInvoke(this, 5, _EJS_s);
			} catch ( RemoteException ex ) {
				_EJS_s.setUncheckedLocalException(ex);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return ;
	}
	/**
	 * setEntries
	 */
	public void setEntries(java.util.Collection anEntries) {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		
		try {
			com.wsbook.casestudy.ejb.TimeSheetEJBBean beanRef = (com.wsbook.casestudy.ejb.TimeSheetEJBBean)container.preInvoke(this, 6, _EJS_s);
			beanRef.setEntries(anEntries);
		}
		catch (java.rmi.RemoteException ex) {
		 	_EJS_s.setUncheckedLocalException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedLocalException(ex);
		}

		finally {
			try {
				container.postInvoke(this, 6, _EJS_s);
			} catch ( RemoteException ex ) {
				_EJS_s.setUncheckedLocalException(ex);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return ;
	}
	/**
	 * setState
	 */
	public void setState(java.lang.String newState) {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		
		try {
			com.wsbook.casestudy.ejb.TimeSheetEJBBean beanRef = (com.wsbook.casestudy.ejb.TimeSheetEJBBean)container.preInvoke(this, 7, _EJS_s);
			beanRef.setState(newState);
		}
		catch (java.rmi.RemoteException ex) {
		 	_EJS_s.setUncheckedLocalException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedLocalException(ex);
		}

		finally {
			try {
				container.postInvoke(this, 7, _EJS_s);
			} catch ( RemoteException ex ) {
				_EJS_s.setUncheckedLocalException(ex);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return ;
	}
	/**
	 * setSubmitter
	 */
	public void setSubmitter(com.wsbook.casestudy.ejb.EmployeeEJB aSubmitter) {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		
		try {
			com.wsbook.casestudy.ejb.TimeSheetEJBBean beanRef = (com.wsbook.casestudy.ejb.TimeSheetEJBBean)container.preInvoke(this, 8, _EJS_s);
			beanRef.setSubmitter(aSubmitter);
		}
		catch (java.rmi.RemoteException ex) {
		 	_EJS_s.setUncheckedLocalException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedLocalException(ex);
		}

		finally {
			try {
				container.postInvoke(this, 8, _EJS_s);
			} catch ( RemoteException ex ) {
				_EJS_s.setUncheckedLocalException(ex);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return ;
	}
	/**
	 * setWeekend
	 */
	public void setWeekend(java.lang.String newWeekend) {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		
		try {
			com.wsbook.casestudy.ejb.TimeSheetEJBBean beanRef = (com.wsbook.casestudy.ejb.TimeSheetEJBBean)container.preInvoke(this, 9, _EJS_s);
			beanRef.setWeekend(newWeekend);
		}
		catch (java.rmi.RemoteException ex) {
		 	_EJS_s.setUncheckedLocalException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedLocalException(ex);
		}

		finally {
			try {
				container.postInvoke(this, 9, _EJS_s);
			} catch ( RemoteException ex ) {
				_EJS_s.setUncheckedLocalException(ex);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return ;
	}
}

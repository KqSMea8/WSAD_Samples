package com.wsbook.casestudy.ejb;

import com.ibm.ejs.container.*;
import java.rmi.RemoteException;

/**
 * EJSLocalCMPTimeSheetEntryEJB_f7c19b5d
 */
public class EJSLocalCMPTimeSheetEntryEJB_f7c19b5d extends EJSLocalWrapper implements com.wsbook.casestudy.ejb.TimeSheetEntryEJB {
	/**
	 * EJSLocalCMPTimeSheetEntryEJB_f7c19b5d
	 */
	public EJSLocalCMPTimeSheetEntryEJB_f7c19b5d() {
		super();	}
	/**
	 * getProject
	 */
	public com.wsbook.casestudy.ejb.ProjectEJB getProject() {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		com.wsbook.casestudy.ejb.ProjectEJB _EJS_result = null;
		try {
			com.wsbook.casestudy.ejb.TimeSheetEntryEJBBean beanRef = (com.wsbook.casestudy.ejb.TimeSheetEntryEJBBean)container.preInvoke(this, 0, _EJS_s);
			_EJS_result = beanRef.getProject();
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
	 * getTimesheet
	 */
	public com.wsbook.casestudy.ejb.TimeSheetEJB getTimesheet() {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		com.wsbook.casestudy.ejb.TimeSheetEJB _EJS_result = null;
		try {
			com.wsbook.casestudy.ejb.TimeSheetEntryEJBBean beanRef = (com.wsbook.casestudy.ejb.TimeSheetEntryEJBBean)container.preInvoke(this, 1, _EJS_s);
			_EJS_result = beanRef.getTimesheet();
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
	 * getHours
	 */
	public double getHours() {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		double _EJS_result = 0;
		try {
			com.wsbook.casestudy.ejb.TimeSheetEntryEJBBean beanRef = (com.wsbook.casestudy.ejb.TimeSheetEntryEJBBean)container.preInvoke(this, 2, _EJS_s);
			_EJS_result = beanRef.getHours();
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
	 * getDate
	 */
	public java.lang.String getDate() {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		java.lang.String _EJS_result = null;
		try {
			com.wsbook.casestudy.ejb.TimeSheetEntryEJBBean beanRef = (com.wsbook.casestudy.ejb.TimeSheetEntryEJBBean)container.preInvoke(this, 3, _EJS_s);
			_EJS_result = beanRef.getDate();
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
	 * setDate
	 */
	public void setDate(java.lang.String newDate) {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		
		try {
			com.wsbook.casestudy.ejb.TimeSheetEntryEJBBean beanRef = (com.wsbook.casestudy.ejb.TimeSheetEntryEJBBean)container.preInvoke(this, 4, _EJS_s);
			beanRef.setDate(newDate);
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
		return ;
	}
	/**
	 * setHours
	 */
	public void setHours(double newHours) {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		
		try {
			com.wsbook.casestudy.ejb.TimeSheetEntryEJBBean beanRef = (com.wsbook.casestudy.ejb.TimeSheetEntryEJBBean)container.preInvoke(this, 5, _EJS_s);
			beanRef.setHours(newHours);
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
	 * setProject
	 */
	public void setProject(com.wsbook.casestudy.ejb.ProjectEJB aProject) {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		
		try {
			com.wsbook.casestudy.ejb.TimeSheetEntryEJBBean beanRef = (com.wsbook.casestudy.ejb.TimeSheetEntryEJBBean)container.preInvoke(this, 6, _EJS_s);
			beanRef.setProject(aProject);
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
	 * setTimesheet
	 */
	public void setTimesheet(com.wsbook.casestudy.ejb.TimeSheetEJB aTimesheet) {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		
		try {
			com.wsbook.casestudy.ejb.TimeSheetEntryEJBBean beanRef = (com.wsbook.casestudy.ejb.TimeSheetEntryEJBBean)container.preInvoke(this, 7, _EJS_s);
			beanRef.setTimesheet(aTimesheet);
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
}

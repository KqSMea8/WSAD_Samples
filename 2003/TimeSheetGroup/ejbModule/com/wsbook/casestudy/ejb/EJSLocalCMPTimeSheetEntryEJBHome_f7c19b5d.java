package com.wsbook.casestudy.ejb;

import com.ibm.ejs.container.*;
import java.rmi.RemoteException;

/**
 * EJSLocalCMPTimeSheetEntryEJBHome_f7c19b5d
 */
public class EJSLocalCMPTimeSheetEntryEJBHome_f7c19b5d extends EJSLocalWrapper implements com.wsbook.casestudy.ejb.TimeSheetEntryEJBHome, com.wsbook.casestudy.ejb.websphere_deploy.TimeSheetEntryEJBBeanInternalLocalHome_f7c19b5d {
	/**
	 * EJSLocalCMPTimeSheetEntryEJBHome_f7c19b5d
	 */
	public EJSLocalCMPTimeSheetEntryEJBHome_f7c19b5d() {
		super();	}
	/**
	 * create
	 */
	public com.wsbook.casestudy.ejb.TimeSheetEntryEJB create(double hours, java.lang.String date, com.wsbook.casestudy.ejb.ProjectEJB project, com.wsbook.casestudy.ejb.TimeSheetEJB timesheet) throws javax.ejb.CreateException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		com.wsbook.casestudy.ejb.TimeSheetEntryEJB _EJS_result = null;
		try {
			com.wsbook.casestudy.ejb.EJSCMPTimeSheetEntryEJBHomeBean_f7c19b5d _EJS_beanRef = (com.wsbook.casestudy.ejb.EJSCMPTimeSheetEntryEJBHomeBean_f7c19b5d)container.preInvoke(this, 0, _EJS_s);
			_EJS_result = _EJS_beanRef.create_Local(hours, date, project, timesheet);
		}
		catch (javax.ejb.CreateException ex) {
			_EJS_s.setCheckedException(ex);
			throw ex;
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
	 * create
	 */
	public com.wsbook.casestudy.ejb.TimeSheetEntryEJB create(int entryId) throws javax.ejb.CreateException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		com.wsbook.casestudy.ejb.TimeSheetEntryEJB _EJS_result = null;
		try {
			com.wsbook.casestudy.ejb.EJSCMPTimeSheetEntryEJBHomeBean_f7c19b5d _EJS_beanRef = (com.wsbook.casestudy.ejb.EJSCMPTimeSheetEntryEJBHomeBean_f7c19b5d)container.preInvoke(this, 1, _EJS_s);
			_EJS_result = _EJS_beanRef.create_Local(entryId);
		}
		catch (javax.ejb.CreateException ex) {
			_EJS_s.setCheckedException(ex);
			throw ex;
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
	 * findByPrimaryKey
	 */
	public com.wsbook.casestudy.ejb.TimeSheetEntryEJB findByPrimaryKey(com.wsbook.casestudy.ejb.TimeSheetEntryEJBKey primaryKey) throws javax.ejb.FinderException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		com.wsbook.casestudy.ejb.TimeSheetEntryEJB _EJS_result = null;
		try {
			com.wsbook.casestudy.ejb.EJSCMPTimeSheetEntryEJBHomeBean_f7c19b5d _EJS_beanRef = (com.wsbook.casestudy.ejb.EJSCMPTimeSheetEntryEJBHomeBean_f7c19b5d)container.preInvoke(this, 2, _EJS_s);
			_EJS_result = _EJS_beanRef.findByPrimaryKey_Local(primaryKey);
		}
		catch (javax.ejb.FinderException ex) {
			_EJS_s.setCheckedException(ex);
			throw ex;
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
	 * findAll
	 */
	public java.util.Collection findAll() throws javax.ejb.FinderException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		java.util.Collection _EJS_result = null;
		try {
			com.wsbook.casestudy.ejb.EJSCMPTimeSheetEntryEJBHomeBean_f7c19b5d _EJS_beanRef = (com.wsbook.casestudy.ejb.EJSCMPTimeSheetEntryEJBHomeBean_f7c19b5d)container.preInvoke(this, 3, _EJS_s);
			_EJS_result = _EJS_beanRef.findAll_Local();
		}
		catch (javax.ejb.FinderException ex) {
			_EJS_s.setCheckedException(ex);
			throw ex;
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
	 * remove
	 */
	public void remove(java.lang.Object arg0) throws javax.ejb.RemoveException, javax.ejb.EJBException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		
		try {
			com.wsbook.casestudy.ejb.EJSCMPTimeSheetEntryEJBHomeBean_f7c19b5d _EJS_beanRef = (com.wsbook.casestudy.ejb.EJSCMPTimeSheetEntryEJBHomeBean_f7c19b5d)container.preInvoke(this, 4, _EJS_s);
			_EJS_beanRef.remove(arg0);
		}
		catch (javax.ejb.RemoveException ex) {
			_EJS_s.setCheckedException(ex);
			throw ex;
		}
		catch (javax.ejb.EJBException ex) {
		 	_EJS_s.setUncheckedLocalException(ex);
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
	 * findEntriesByTimesheetKey_Local
	 */
	public java.util.Collection findEntriesByTimesheetKey_Local(com.wsbook.casestudy.ejb.TimeSheetEJBKey key) throws javax.ejb.FinderException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		java.util.Collection _EJS_result = null;
		try {
			com.wsbook.casestudy.ejb.EJSCMPTimeSheetEntryEJBHomeBean_f7c19b5d _EJS_beanRef = (com.wsbook.casestudy.ejb.EJSCMPTimeSheetEntryEJBHomeBean_f7c19b5d)container.preInvoke(this, -2, _EJS_s);
			_EJS_result = _EJS_beanRef.findEntriesByTimesheetKey_Local(key);
		}
		catch (javax.ejb.FinderException ex) {
			_EJS_s.setCheckedException(ex);
			throw ex;
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedLocalException(ex);
		}

		finally {
			try {
				container.postInvoke(this, -2, _EJS_s);
			} catch ( RemoteException ex ) {
				_EJS_s.setUncheckedLocalException(ex);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * findTimesheetentryByProjectKey_Local
	 */
	public java.util.Collection findTimesheetentryByProjectKey_Local(java.lang.String key) throws javax.ejb.FinderException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		java.util.Collection _EJS_result = null;
		try {
			com.wsbook.casestudy.ejb.EJSCMPTimeSheetEntryEJBHomeBean_f7c19b5d _EJS_beanRef = (com.wsbook.casestudy.ejb.EJSCMPTimeSheetEntryEJBHomeBean_f7c19b5d)container.preInvoke(this, -2, _EJS_s);
			_EJS_result = _EJS_beanRef.findTimesheetentryByProjectKey_Local(key);
		}
		catch (javax.ejb.FinderException ex) {
			_EJS_s.setCheckedException(ex);
			throw ex;
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedLocalException(ex);
		}

		finally {
			try {
				container.postInvoke(this, -2, _EJS_s);
			} catch ( RemoteException ex ) {
				_EJS_s.setUncheckedLocalException(ex);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
}

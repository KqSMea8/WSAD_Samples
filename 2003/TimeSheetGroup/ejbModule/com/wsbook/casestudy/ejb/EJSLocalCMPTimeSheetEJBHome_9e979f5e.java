package com.wsbook.casestudy.ejb;

import com.ibm.ejs.container.*;
import java.rmi.RemoteException;

/**
 * EJSLocalCMPTimeSheetEJBHome_9e979f5e
 */
public class EJSLocalCMPTimeSheetEJBHome_9e979f5e extends EJSLocalWrapper implements com.wsbook.casestudy.ejb.TimeSheetEJBHome, com.wsbook.casestudy.ejb.websphere_deploy.TimeSheetEJBBeanInternalLocalHome_9e979f5e {
	/**
	 * EJSLocalCMPTimeSheetEJBHome_9e979f5e
	 */
	public EJSLocalCMPTimeSheetEJBHome_9e979f5e() {
		super();	}
	/**
	 * create
	 */
	public com.wsbook.casestudy.ejb.TimeSheetEJB create(int timeSheetId) throws javax.ejb.CreateException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		com.wsbook.casestudy.ejb.TimeSheetEJB _EJS_result = null;
		try {
			com.wsbook.casestudy.ejb.EJSCMPTimeSheetEJBHomeBean_9e979f5e _EJS_beanRef = (com.wsbook.casestudy.ejb.EJSCMPTimeSheetEJBHomeBean_9e979f5e)container.preInvoke(this, 0, _EJS_s);
			_EJS_result = _EJS_beanRef.create_Local(timeSheetId);
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
	public com.wsbook.casestudy.ejb.TimeSheetEJB create(int timeSheetId, com.wsbook.casestudy.ejb.EmployeeEJB argSubmitter) throws javax.ejb.CreateException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		com.wsbook.casestudy.ejb.TimeSheetEJB _EJS_result = null;
		try {
			com.wsbook.casestudy.ejb.EJSCMPTimeSheetEJBHomeBean_9e979f5e _EJS_beanRef = (com.wsbook.casestudy.ejb.EJSCMPTimeSheetEJBHomeBean_9e979f5e)container.preInvoke(this, 1, _EJS_s);
			_EJS_result = _EJS_beanRef.create_Local(timeSheetId, argSubmitter);
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
	 * create
	 */
	public com.wsbook.casestudy.ejb.TimeSheetEJB create(java.lang.String weekend, java.lang.String state, com.wsbook.casestudy.ejb.EmployeeEJB submitter) throws javax.ejb.CreateException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		com.wsbook.casestudy.ejb.TimeSheetEJB _EJS_result = null;
		try {
			com.wsbook.casestudy.ejb.EJSCMPTimeSheetEJBHomeBean_9e979f5e _EJS_beanRef = (com.wsbook.casestudy.ejb.EJSCMPTimeSheetEJBHomeBean_9e979f5e)container.preInvoke(this, 2, _EJS_s);
			_EJS_result = _EJS_beanRef.create_Local(weekend, state, submitter);
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
	 * findByPrimaryKey
	 */
	public com.wsbook.casestudy.ejb.TimeSheetEJB findByPrimaryKey(com.wsbook.casestudy.ejb.TimeSheetEJBKey primaryKey) throws javax.ejb.FinderException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		com.wsbook.casestudy.ejb.TimeSheetEJB _EJS_result = null;
		try {
			com.wsbook.casestudy.ejb.EJSCMPTimeSheetEJBHomeBean_9e979f5e _EJS_beanRef = (com.wsbook.casestudy.ejb.EJSCMPTimeSheetEJBHomeBean_9e979f5e)container.preInvoke(this, 3, _EJS_s);
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
	 * findAll
	 */
	public java.util.Collection findAll() throws javax.ejb.FinderException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		java.util.Collection _EJS_result = null;
		try {
			com.wsbook.casestudy.ejb.EJSCMPTimeSheetEJBHomeBean_9e979f5e _EJS_beanRef = (com.wsbook.casestudy.ejb.EJSCMPTimeSheetEJBHomeBean_9e979f5e)container.preInvoke(this, 4, _EJS_s);
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
	 * findApprovedTimesheetsByApprover
	 */
	public java.util.Collection findApprovedTimesheetsByApprover(java.lang.String inKey) throws javax.ejb.FinderException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		java.util.Collection _EJS_result = null;
		try {
			com.wsbook.casestudy.ejb.EJSCMPTimeSheetEJBHomeBean_9e979f5e _EJS_beanRef = (com.wsbook.casestudy.ejb.EJSCMPTimeSheetEJBHomeBean_9e979f5e)container.preInvoke(this, 5, _EJS_s);
			_EJS_result = _EJS_beanRef.findApprovedTimesheetsByApprover_Local(inKey);
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
				container.postInvoke(this, 5, _EJS_s);
			} catch ( RemoteException ex ) {
				_EJS_s.setUncheckedLocalException(ex);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * findPendingByEmployee
	 */
	public java.util.Collection findPendingByEmployee(java.lang.String empId) throws javax.ejb.FinderException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		java.util.Collection _EJS_result = null;
		try {
			com.wsbook.casestudy.ejb.EJSCMPTimeSheetEJBHomeBean_9e979f5e _EJS_beanRef = (com.wsbook.casestudy.ejb.EJSCMPTimeSheetEJBHomeBean_9e979f5e)container.preInvoke(this, 6, _EJS_s);
			_EJS_result = _EJS_beanRef.findPendingByEmployee_Local(empId);
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
				container.postInvoke(this, 6, _EJS_s);
			} catch ( RemoteException ex ) {
				_EJS_s.setUncheckedLocalException(ex);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * findTimesheetsBySubmitter
	 */
	public java.util.Collection findTimesheetsBySubmitter(java.lang.String inKey) throws javax.ejb.FinderException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		java.util.Collection _EJS_result = null;
		try {
			com.wsbook.casestudy.ejb.EJSCMPTimeSheetEJBHomeBean_9e979f5e _EJS_beanRef = (com.wsbook.casestudy.ejb.EJSCMPTimeSheetEJBHomeBean_9e979f5e)container.preInvoke(this, 7, _EJS_s);
			_EJS_result = _EJS_beanRef.findTimesheetsBySubmitter_Local(inKey);
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
				container.postInvoke(this, 7, _EJS_s);
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
			com.wsbook.casestudy.ejb.EJSCMPTimeSheetEJBHomeBean_9e979f5e _EJS_beanRef = (com.wsbook.casestudy.ejb.EJSCMPTimeSheetEJBHomeBean_9e979f5e)container.preInvoke(this, 8, _EJS_s);
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
	 * findTimesheetByEntriesKey_Local
	 */
	public com.wsbook.casestudy.ejb.TimeSheetEJB findTimesheetByEntriesKey_Local(com.wsbook.casestudy.ejb.TimeSheetEntryEJBKey key) throws javax.ejb.FinderException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		com.wsbook.casestudy.ejb.TimeSheetEJB _EJS_result = null;
		try {
			com.wsbook.casestudy.ejb.EJSCMPTimeSheetEJBHomeBean_9e979f5e _EJS_beanRef = (com.wsbook.casestudy.ejb.EJSCMPTimeSheetEJBHomeBean_9e979f5e)container.preInvoke(this, -2, _EJS_s);
			_EJS_result = _EJS_beanRef.findTimesheetByEntriesKey_Local(key);
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
	 * findTimesheetsBySubmitterKey_Local
	 */
	public java.util.Collection findTimesheetsBySubmitterKey_Local(java.lang.String key) throws javax.ejb.FinderException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		java.util.Collection _EJS_result = null;
		try {
			com.wsbook.casestudy.ejb.EJSCMPTimeSheetEJBHomeBean_9e979f5e _EJS_beanRef = (com.wsbook.casestudy.ejb.EJSCMPTimeSheetEJBHomeBean_9e979f5e)container.preInvoke(this, -2, _EJS_s);
			_EJS_result = _EJS_beanRef.findTimesheetsBySubmitterKey_Local(key);
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
	 * findApprovedTimesheetsByApproverKey_Local
	 */
	public java.util.Collection findApprovedTimesheetsByApproverKey_Local(java.lang.String key) throws javax.ejb.FinderException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		java.util.Collection _EJS_result = null;
		try {
			com.wsbook.casestudy.ejb.EJSCMPTimeSheetEJBHomeBean_9e979f5e _EJS_beanRef = (com.wsbook.casestudy.ejb.EJSCMPTimeSheetEJBHomeBean_9e979f5e)container.preInvoke(this, -2, _EJS_s);
			_EJS_result = _EJS_beanRef.findApprovedTimesheetsByApproverKey_Local(key);
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
	 * findByPrimaryKeyForCMR
	 */
	public com.wsbook.casestudy.ejb.TimeSheetEJB findByPrimaryKeyForCMR(com.wsbook.casestudy.ejb.TimeSheetEJBKey key) throws javax.ejb.FinderException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		com.wsbook.casestudy.ejb.TimeSheetEJB _EJS_result = null;
		try {
			com.wsbook.casestudy.ejb.EJSCMPTimeSheetEJBHomeBean_9e979f5e _EJS_beanRef = (com.wsbook.casestudy.ejb.EJSCMPTimeSheetEJBHomeBean_9e979f5e)container.preInvoke(this, -2, _EJS_s);
			_EJS_result = _EJS_beanRef.findByPrimaryKeyForCMR_Local(key);
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

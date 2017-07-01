package com.wsbook.casestudy.ejb;

import com.ibm.ejs.container.*;
import java.rmi.RemoteException;

/**
 * EJSLocalCMPProjectEJBHome_8ce694f3
 */
public class EJSLocalCMPProjectEJBHome_8ce694f3 extends EJSLocalWrapper implements com.wsbook.casestudy.ejb.ProjectEJBHome, com.wsbook.casestudy.ejb.websphere_deploy.ProjectEJBBeanInternalLocalHome_8ce694f3 {
	/**
	 * EJSLocalCMPProjectEJBHome_8ce694f3
	 */
	public EJSLocalCMPProjectEJBHome_8ce694f3() {
		super();	}
	/**
	 * create
	 */
	public com.wsbook.casestudy.ejb.ProjectEJB create(java.lang.String projNumber) throws javax.ejb.CreateException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		com.wsbook.casestudy.ejb.ProjectEJB _EJS_result = null;
		try {
			com.wsbook.casestudy.ejb.EJSCMPProjectEJBHomeBean_8ce694f3 _EJS_beanRef = (com.wsbook.casestudy.ejb.EJSCMPProjectEJBHomeBean_8ce694f3)container.preInvoke(this, 0, _EJS_s);
			_EJS_result = _EJS_beanRef.create_Local(projNumber);
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
	public com.wsbook.casestudy.ejb.ProjectEJB create(java.lang.String projNumber, java.lang.String name) throws javax.ejb.CreateException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		com.wsbook.casestudy.ejb.ProjectEJB _EJS_result = null;
		try {
			com.wsbook.casestudy.ejb.EJSCMPProjectEJBHomeBean_8ce694f3 _EJS_beanRef = (com.wsbook.casestudy.ejb.EJSCMPProjectEJBHomeBean_8ce694f3)container.preInvoke(this, 1, _EJS_s);
			_EJS_result = _EJS_beanRef.create_Local(projNumber, name);
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
	 * findByName
	 */
	public com.wsbook.casestudy.ejb.ProjectEJB findByName(java.lang.String name) throws javax.ejb.FinderException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		com.wsbook.casestudy.ejb.ProjectEJB _EJS_result = null;
		try {
			com.wsbook.casestudy.ejb.EJSCMPProjectEJBHomeBean_8ce694f3 _EJS_beanRef = (com.wsbook.casestudy.ejb.EJSCMPProjectEJBHomeBean_8ce694f3)container.preInvoke(this, 2, _EJS_s);
			_EJS_result = _EJS_beanRef.findByName_Local(name);
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
	 * findByPrimaryKey
	 */
	public com.wsbook.casestudy.ejb.ProjectEJB findByPrimaryKey(java.lang.String primaryKey) throws javax.ejb.FinderException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		com.wsbook.casestudy.ejb.ProjectEJB _EJS_result = null;
		try {
			com.wsbook.casestudy.ejb.EJSCMPProjectEJBHomeBean_8ce694f3 _EJS_beanRef = (com.wsbook.casestudy.ejb.EJSCMPProjectEJBHomeBean_8ce694f3)container.preInvoke(this, 3, _EJS_s);
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
			com.wsbook.casestudy.ejb.EJSCMPProjectEJBHomeBean_8ce694f3 _EJS_beanRef = (com.wsbook.casestudy.ejb.EJSCMPProjectEJBHomeBean_8ce694f3)container.preInvoke(this, 4, _EJS_s);
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
	 * remove
	 */
	public void remove(java.lang.Object arg0) throws javax.ejb.RemoveException, javax.ejb.EJBException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		
		try {
			com.wsbook.casestudy.ejb.EJSCMPProjectEJBHomeBean_8ce694f3 _EJS_beanRef = (com.wsbook.casestudy.ejb.EJSCMPProjectEJBHomeBean_8ce694f3)container.preInvoke(this, 5, _EJS_s);
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
	 * findProjectByTimesheetentryKey_Local
	 */
	public com.wsbook.casestudy.ejb.ProjectEJB findProjectByTimesheetentryKey_Local(com.wsbook.casestudy.ejb.TimeSheetEntryEJBKey key) throws javax.ejb.FinderException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		com.wsbook.casestudy.ejb.ProjectEJB _EJS_result = null;
		try {
			com.wsbook.casestudy.ejb.EJSCMPProjectEJBHomeBean_8ce694f3 _EJS_beanRef = (com.wsbook.casestudy.ejb.EJSCMPProjectEJBHomeBean_8ce694f3)container.preInvoke(this, -2, _EJS_s);
			_EJS_result = _EJS_beanRef.findProjectByTimesheetentryKey_Local(key);
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
	public com.wsbook.casestudy.ejb.ProjectEJB findByPrimaryKeyForCMR(java.lang.String key) throws javax.ejb.FinderException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		com.wsbook.casestudy.ejb.ProjectEJB _EJS_result = null;
		try {
			com.wsbook.casestudy.ejb.EJSCMPProjectEJBHomeBean_8ce694f3 _EJS_beanRef = (com.wsbook.casestudy.ejb.EJSCMPProjectEJBHomeBean_8ce694f3)container.preInvoke(this, -2, _EJS_s);
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

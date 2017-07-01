package com.wsbook.casestudy.ejb;

import com.ibm.ejs.container.*;
import java.rmi.RemoteException;

/**
 * EJSLocalCMPEmployeeEJBHome_96c219b7
 */
public class EJSLocalCMPEmployeeEJBHome_96c219b7 extends EJSLocalWrapper implements com.wsbook.casestudy.ejb.EmployeeEJBHome, com.wsbook.casestudy.ejb.websphere_deploy.EmployeeEJBBeanInternalLocalHome_96c219b7 {
	/**
	 * EJSLocalCMPEmployeeEJBHome_96c219b7
	 */
	public EJSLocalCMPEmployeeEJBHome_96c219b7() {
		super();	}
	/**
	 * create
	 */
	public com.wsbook.casestudy.ejb.EmployeeEJB create(java.lang.String empId) throws javax.ejb.CreateException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		com.wsbook.casestudy.ejb.EmployeeEJB _EJS_result = null;
		try {
			com.wsbook.casestudy.ejb.EJSCMPEmployeeEJBHomeBean_96c219b7 _EJS_beanRef = (com.wsbook.casestudy.ejb.EJSCMPEmployeeEJBHomeBean_96c219b7)container.preInvoke(this, 0, _EJS_s);
			_EJS_result = _EJS_beanRef.create_Local(empId);
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
	public com.wsbook.casestudy.ejb.EmployeeEJB create(java.lang.String empId, java.lang.String name) throws javax.ejb.CreateException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		com.wsbook.casestudy.ejb.EmployeeEJB _EJS_result = null;
		try {
			com.wsbook.casestudy.ejb.EJSCMPEmployeeEJBHomeBean_96c219b7 _EJS_beanRef = (com.wsbook.casestudy.ejb.EJSCMPEmployeeEJBHomeBean_96c219b7)container.preInvoke(this, 1, _EJS_s);
			_EJS_result = _EJS_beanRef.create_Local(empId, name);
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
	public com.wsbook.casestudy.ejb.EmployeeEJB findByPrimaryKey(java.lang.String primaryKey) throws javax.ejb.FinderException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		com.wsbook.casestudy.ejb.EmployeeEJB _EJS_result = null;
		try {
			com.wsbook.casestudy.ejb.EJSCMPEmployeeEJBHomeBean_96c219b7 _EJS_beanRef = (com.wsbook.casestudy.ejb.EJSCMPEmployeeEJBHomeBean_96c219b7)container.preInvoke(this, 2, _EJS_s);
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
			com.wsbook.casestudy.ejb.EJSCMPEmployeeEJBHomeBean_96c219b7 _EJS_beanRef = (com.wsbook.casestudy.ejb.EJSCMPEmployeeEJBHomeBean_96c219b7)container.preInvoke(this, 3, _EJS_s);
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
			com.wsbook.casestudy.ejb.EJSCMPEmployeeEJBHomeBean_96c219b7 _EJS_beanRef = (com.wsbook.casestudy.ejb.EJSCMPEmployeeEJBHomeBean_96c219b7)container.preInvoke(this, 4, _EJS_s);
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
	 * findEmployeeByHomeAddressKey_Local
	 */
	public com.wsbook.casestudy.ejb.EmployeeEJB findEmployeeByHomeAddressKey_Local(com.wsbook.casestudy.ejb.AddressEJBKey key) throws javax.ejb.FinderException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		com.wsbook.casestudy.ejb.EmployeeEJB _EJS_result = null;
		try {
			com.wsbook.casestudy.ejb.EJSCMPEmployeeEJBHomeBean_96c219b7 _EJS_beanRef = (com.wsbook.casestudy.ejb.EJSCMPEmployeeEJBHomeBean_96c219b7)container.preInvoke(this, -2, _EJS_s);
			_EJS_result = _EJS_beanRef.findEmployeeByHomeAddressKey_Local(key);
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
	 * findSubmitterByTimesheetsKey_Local
	 */
	public com.wsbook.casestudy.ejb.EmployeeEJB findSubmitterByTimesheetsKey_Local(com.wsbook.casestudy.ejb.TimeSheetEJBKey key) throws javax.ejb.FinderException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		com.wsbook.casestudy.ejb.EmployeeEJB _EJS_result = null;
		try {
			com.wsbook.casestudy.ejb.EJSCMPEmployeeEJBHomeBean_96c219b7 _EJS_beanRef = (com.wsbook.casestudy.ejb.EJSCMPEmployeeEJBHomeBean_96c219b7)container.preInvoke(this, -2, _EJS_s);
			_EJS_result = _EJS_beanRef.findSubmitterByTimesheetsKey_Local(key);
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
	 * findApproverByApprovedTimesheetsKey_Local
	 */
	public com.wsbook.casestudy.ejb.EmployeeEJB findApproverByApprovedTimesheetsKey_Local(com.wsbook.casestudy.ejb.TimeSheetEJBKey key) throws javax.ejb.FinderException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		com.wsbook.casestudy.ejb.EmployeeEJB _EJS_result = null;
		try {
			com.wsbook.casestudy.ejb.EJSCMPEmployeeEJBHomeBean_96c219b7 _EJS_beanRef = (com.wsbook.casestudy.ejb.EJSCMPEmployeeEJBHomeBean_96c219b7)container.preInvoke(this, -2, _EJS_s);
			_EJS_result = _EJS_beanRef.findApproverByApprovedTimesheetsKey_Local(key);
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
	public com.wsbook.casestudy.ejb.EmployeeEJB findByPrimaryKeyForCMR(java.lang.String key) throws javax.ejb.FinderException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		com.wsbook.casestudy.ejb.EmployeeEJB _EJS_result = null;
		try {
			com.wsbook.casestudy.ejb.EJSCMPEmployeeEJBHomeBean_96c219b7 _EJS_beanRef = (com.wsbook.casestudy.ejb.EJSCMPEmployeeEJBHomeBean_96c219b7)container.preInvoke(this, -2, _EJS_s);
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

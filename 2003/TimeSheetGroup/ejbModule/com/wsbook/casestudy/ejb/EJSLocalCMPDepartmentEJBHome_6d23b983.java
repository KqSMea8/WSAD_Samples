package com.wsbook.casestudy.ejb;

import com.ibm.ejs.container.*;
import java.rmi.RemoteException;

/**
 * EJSLocalCMPDepartmentEJBHome_6d23b983
 */
public class EJSLocalCMPDepartmentEJBHome_6d23b983 extends EJSLocalWrapper implements com.wsbook.casestudy.ejb.DepartmentEJBHome, com.wsbook.casestudy.ejb.websphere_deploy.DepartmentEJBBeanInternalLocalHome_6d23b983 {
	/**
	 * EJSLocalCMPDepartmentEJBHome_6d23b983
	 */
	public EJSLocalCMPDepartmentEJBHome_6d23b983() {
		super();	}
	/**
	 * create
	 */
	public com.wsbook.casestudy.ejb.DepartmentEJB create(int deptNumber) throws javax.ejb.CreateException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		com.wsbook.casestudy.ejb.DepartmentEJB _EJS_result = null;
		try {
			com.wsbook.casestudy.ejb.EJSCMPDepartmentEJBHomeBean_6d23b983 _EJS_beanRef = (com.wsbook.casestudy.ejb.EJSCMPDepartmentEJBHomeBean_6d23b983)container.preInvoke(this, 0, _EJS_s);
			_EJS_result = _EJS_beanRef.create_Local(deptNumber);
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
	public com.wsbook.casestudy.ejb.DepartmentEJB create(int deptNumber, java.lang.String name) throws javax.ejb.CreateException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		com.wsbook.casestudy.ejb.DepartmentEJB _EJS_result = null;
		try {
			com.wsbook.casestudy.ejb.EJSCMPDepartmentEJBHomeBean_6d23b983 _EJS_beanRef = (com.wsbook.casestudy.ejb.EJSCMPDepartmentEJBHomeBean_6d23b983)container.preInvoke(this, 1, _EJS_s);
			_EJS_result = _EJS_beanRef.create_Local(deptNumber, name);
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
	public com.wsbook.casestudy.ejb.DepartmentEJB findByPrimaryKey(com.wsbook.casestudy.ejb.DepartmentEJBKey primaryKey) throws javax.ejb.FinderException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		com.wsbook.casestudy.ejb.DepartmentEJB _EJS_result = null;
		try {
			com.wsbook.casestudy.ejb.EJSCMPDepartmentEJBHomeBean_6d23b983 _EJS_beanRef = (com.wsbook.casestudy.ejb.EJSCMPDepartmentEJBHomeBean_6d23b983)container.preInvoke(this, 2, _EJS_s);
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
			com.wsbook.casestudy.ejb.EJSCMPDepartmentEJBHomeBean_6d23b983 _EJS_beanRef = (com.wsbook.casestudy.ejb.EJSCMPDepartmentEJBHomeBean_6d23b983)container.preInvoke(this, 3, _EJS_s);
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
			com.wsbook.casestudy.ejb.EJSCMPDepartmentEJBHomeBean_6d23b983 _EJS_beanRef = (com.wsbook.casestudy.ejb.EJSCMPDepartmentEJBHomeBean_6d23b983)container.preInvoke(this, 4, _EJS_s);
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
}

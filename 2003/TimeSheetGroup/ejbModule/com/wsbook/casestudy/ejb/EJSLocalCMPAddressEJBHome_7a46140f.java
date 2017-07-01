package com.wsbook.casestudy.ejb;

import com.ibm.ejs.container.*;
import java.rmi.RemoteException;

/**
 * EJSLocalCMPAddressEJBHome_7a46140f
 */
public class EJSLocalCMPAddressEJBHome_7a46140f extends EJSLocalWrapper implements com.wsbook.casestudy.ejb.AddressEJBHome, com.wsbook.casestudy.ejb.websphere_deploy.AddressEJBBeanInternalLocalHome_7a46140f {
	/**
	 * EJSLocalCMPAddressEJBHome_7a46140f
	 */
	public EJSLocalCMPAddressEJBHome_7a46140f() {
		super();	}
	/**
	 * create
	 */
	public com.wsbook.casestudy.ejb.AddressEJB create(int addressKey) throws javax.ejb.CreateException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		com.wsbook.casestudy.ejb.AddressEJB _EJS_result = null;
		try {
			com.wsbook.casestudy.ejb.EJSCMPAddressEJBHomeBean_7a46140f _EJS_beanRef = (com.wsbook.casestudy.ejb.EJSCMPAddressEJBHomeBean_7a46140f)container.preInvoke(this, 0, _EJS_s);
			_EJS_result = _EJS_beanRef.create_Local(addressKey);
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
	 * findByPrimaryKey
	 */
	public com.wsbook.casestudy.ejb.AddressEJB findByPrimaryKey(com.wsbook.casestudy.ejb.AddressEJBKey primaryKey) throws javax.ejb.FinderException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		com.wsbook.casestudy.ejb.AddressEJB _EJS_result = null;
		try {
			com.wsbook.casestudy.ejb.EJSCMPAddressEJBHomeBean_7a46140f _EJS_beanRef = (com.wsbook.casestudy.ejb.EJSCMPAddressEJBHomeBean_7a46140f)container.preInvoke(this, 1, _EJS_s);
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
	 * remove
	 */
	public void remove(java.lang.Object arg0) throws javax.ejb.RemoveException, javax.ejb.EJBException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		
		try {
			com.wsbook.casestudy.ejb.EJSCMPAddressEJBHomeBean_7a46140f _EJS_beanRef = (com.wsbook.casestudy.ejb.EJSCMPAddressEJBHomeBean_7a46140f)container.preInvoke(this, 2, _EJS_s);
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
				container.postInvoke(this, 2, _EJS_s);
			} catch ( RemoteException ex ) {
				_EJS_s.setUncheckedLocalException(ex);
			} finally {
				container.putEJSDeployedSupport(_EJS_s);
			}
		}
		return ;
	}
	/**
	 * findHomeAddressByEmployeeKey_Local
	 */
	public com.wsbook.casestudy.ejb.AddressEJB findHomeAddressByEmployeeKey_Local(java.lang.String key) throws javax.ejb.FinderException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		com.wsbook.casestudy.ejb.AddressEJB _EJS_result = null;
		try {
			com.wsbook.casestudy.ejb.EJSCMPAddressEJBHomeBean_7a46140f _EJS_beanRef = (com.wsbook.casestudy.ejb.EJSCMPAddressEJBHomeBean_7a46140f)container.preInvoke(this, -2, _EJS_s);
			_EJS_result = _EJS_beanRef.findHomeAddressByEmployeeKey_Local(key);
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
	public com.wsbook.casestudy.ejb.AddressEJB findByPrimaryKeyForCMR(com.wsbook.casestudy.ejb.AddressEJBKey key) throws javax.ejb.FinderException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		com.wsbook.casestudy.ejb.AddressEJB _EJS_result = null;
		try {
			com.wsbook.casestudy.ejb.EJSCMPAddressEJBHomeBean_7a46140f _EJS_beanRef = (com.wsbook.casestudy.ejb.EJSCMPAddressEJBHomeBean_7a46140f)container.preInvoke(this, -2, _EJS_s);
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

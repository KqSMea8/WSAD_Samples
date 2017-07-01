package com.wsbook.casestudy.ejb;

import com.ibm.ejs.container.*;
import java.rmi.RemoteException;

/**
 * EJSLocalBMPCustomerEJBHome_2939ee61
 */
public class EJSLocalBMPCustomerEJBHome_2939ee61 extends EJSLocalWrapper implements com.wsbook.casestudy.ejb.CustomerEJBHome {
	/**
	 * EJSLocalBMPCustomerEJBHome_2939ee61
	 */
	public EJSLocalBMPCustomerEJBHome_2939ee61() {
		super();	}
	/**
	 * create
	 */
	public com.wsbook.casestudy.ejb.CustomerEJB create(int arg1, java.lang.String arg2) throws javax.ejb.CreateException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		com.wsbook.casestudy.ejb.CustomerEJB _EJS_result = null;
		try {
			com.wsbook.casestudy.ejb.EJSBMPCustomerEJBHomeBean_2939ee61 _EJS_beanRef = (com.wsbook.casestudy.ejb.EJSBMPCustomerEJBHomeBean_2939ee61)container.preInvoke(this, 0, _EJS_s);
			_EJS_result = _EJS_beanRef.create_Local(arg1, arg2);
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
	public com.wsbook.casestudy.ejb.CustomerEJB findByPrimaryKey(com.wsbook.casestudy.ejb.CustomerEJBKey primaryKey) throws javax.ejb.FinderException {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		com.wsbook.casestudy.ejb.CustomerEJB _EJS_result = null;
		try {
			com.wsbook.casestudy.ejb.EJSBMPCustomerEJBHomeBean_2939ee61 _EJS_beanRef = (com.wsbook.casestudy.ejb.EJSBMPCustomerEJBHomeBean_2939ee61)container.preInvoke(this, 1, _EJS_s);
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
			com.wsbook.casestudy.ejb.EJSBMPCustomerEJBHomeBean_2939ee61 _EJS_beanRef = (com.wsbook.casestudy.ejb.EJSBMPCustomerEJBHomeBean_2939ee61)container.preInvoke(this, 2, _EJS_s);
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
}

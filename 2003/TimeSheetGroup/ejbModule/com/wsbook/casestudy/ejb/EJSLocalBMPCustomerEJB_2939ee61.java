package com.wsbook.casestudy.ejb;

import com.ibm.ejs.container.*;
import java.rmi.RemoteException;

/**
 * EJSLocalBMPCustomerEJB_2939ee61
 */
public class EJSLocalBMPCustomerEJB_2939ee61 extends EJSLocalWrapper implements com.wsbook.casestudy.ejb.CustomerEJB {
	/**
	 * EJSLocalBMPCustomerEJB_2939ee61
	 */
	public EJSLocalBMPCustomerEJB_2939ee61() {
		super();	}
	/**
	 * getAccountBalance
	 */
	public int getAccountBalance() {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		int _EJS_result = 0;
		try {
			com.wsbook.casestudy.ejb.CustomerEJBBean beanRef = (com.wsbook.casestudy.ejb.CustomerEJBBean)container.preInvoke(this, 0, _EJS_s);
			_EJS_result = beanRef.getAccountBalance();
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
	 * getCustomerNumber
	 */
	public int getCustomerNumber() {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		int _EJS_result = 0;
		try {
			com.wsbook.casestudy.ejb.CustomerEJBBean beanRef = (com.wsbook.casestudy.ejb.CustomerEJBBean)container.preInvoke(this, 1, _EJS_s);
			_EJS_result = beanRef.getCustomerNumber();
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
	 * getCustomerName
	 */
	public java.lang.String getCustomerName() {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		java.lang.String _EJS_result = null;
		try {
			com.wsbook.casestudy.ejb.CustomerEJBBean beanRef = (com.wsbook.casestudy.ejb.CustomerEJBBean)container.preInvoke(this, 2, _EJS_s);
			_EJS_result = beanRef.getCustomerName();
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
	 * setAccountBalance
	 */
	public void setAccountBalance(int arg1) {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		
		try {
			com.wsbook.casestudy.ejb.CustomerEJBBean beanRef = (com.wsbook.casestudy.ejb.CustomerEJBBean)container.preInvoke(this, 3, _EJS_s);
			beanRef.setAccountBalance(arg1);
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
		return ;
	}
	/**
	 * setCustomerName
	 */
	public void setCustomerName(java.lang.String arg1) {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		
		try {
			com.wsbook.casestudy.ejb.CustomerEJBBean beanRef = (com.wsbook.casestudy.ejb.CustomerEJBBean)container.preInvoke(this, 4, _EJS_s);
			beanRef.setCustomerName(arg1);
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

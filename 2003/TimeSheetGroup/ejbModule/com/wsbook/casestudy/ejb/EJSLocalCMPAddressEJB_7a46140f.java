package com.wsbook.casestudy.ejb;

import com.ibm.ejs.container.*;
import java.rmi.RemoteException;

/**
 * EJSLocalCMPAddressEJB_7a46140f
 */
public class EJSLocalCMPAddressEJB_7a46140f extends EJSLocalWrapper implements com.wsbook.casestudy.ejb.AddressEJB {
	/**
	 * EJSLocalCMPAddressEJB_7a46140f
	 */
	public EJSLocalCMPAddressEJB_7a46140f() {
		super();	}
	/**
	 * getEmployee
	 */
	public com.wsbook.casestudy.ejb.EmployeeEJB getEmployee() {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		com.wsbook.casestudy.ejb.EmployeeEJB _EJS_result = null;
		try {
			com.wsbook.casestudy.ejb.AddressEJBBean beanRef = (com.wsbook.casestudy.ejb.AddressEJBBean)container.preInvoke(this, 0, _EJS_s);
			_EJS_result = beanRef.getEmployee();
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
	 * getCity
	 */
	public java.lang.String getCity() {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		java.lang.String _EJS_result = null;
		try {
			com.wsbook.casestudy.ejb.AddressEJBBean beanRef = (com.wsbook.casestudy.ejb.AddressEJBBean)container.preInvoke(this, 1, _EJS_s);
			_EJS_result = beanRef.getCity();
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
			com.wsbook.casestudy.ejb.AddressEJBBean beanRef = (com.wsbook.casestudy.ejb.AddressEJBBean)container.preInvoke(this, 2, _EJS_s);
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
	 * getStreetAddress
	 */
	public java.lang.String getStreetAddress() {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		java.lang.String _EJS_result = null;
		try {
			com.wsbook.casestudy.ejb.AddressEJBBean beanRef = (com.wsbook.casestudy.ejb.AddressEJBBean)container.preInvoke(this, 3, _EJS_s);
			_EJS_result = beanRef.getStreetAddress();
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
	 * getZipCode
	 */
	public java.lang.String getZipCode() {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		java.lang.String _EJS_result = null;
		try {
			com.wsbook.casestudy.ejb.AddressEJBBean beanRef = (com.wsbook.casestudy.ejb.AddressEJBBean)container.preInvoke(this, 4, _EJS_s);
			_EJS_result = beanRef.getZipCode();
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
	 * setCity
	 */
	public void setCity(java.lang.String newCity) {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		
		try {
			com.wsbook.casestudy.ejb.AddressEJBBean beanRef = (com.wsbook.casestudy.ejb.AddressEJBBean)container.preInvoke(this, 5, _EJS_s);
			beanRef.setCity(newCity);
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
	 * setEmployee
	 */
	public void setEmployee(com.wsbook.casestudy.ejb.EmployeeEJB anEmployee) {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		
		try {
			com.wsbook.casestudy.ejb.AddressEJBBean beanRef = (com.wsbook.casestudy.ejb.AddressEJBBean)container.preInvoke(this, 6, _EJS_s);
			beanRef.setEmployee(anEmployee);
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
			com.wsbook.casestudy.ejb.AddressEJBBean beanRef = (com.wsbook.casestudy.ejb.AddressEJBBean)container.preInvoke(this, 7, _EJS_s);
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
	 * setStreetAddress
	 */
	public void setStreetAddress(java.lang.String newStreetAddress) {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		
		try {
			com.wsbook.casestudy.ejb.AddressEJBBean beanRef = (com.wsbook.casestudy.ejb.AddressEJBBean)container.preInvoke(this, 8, _EJS_s);
			beanRef.setStreetAddress(newStreetAddress);
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
	 * setZipCode
	 */
	public void setZipCode(java.lang.String newZipCode) {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		
		try {
			com.wsbook.casestudy.ejb.AddressEJBBean beanRef = (com.wsbook.casestudy.ejb.AddressEJBBean)container.preInvoke(this, 9, _EJS_s);
			beanRef.setZipCode(newZipCode);
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

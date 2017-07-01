package com.wsbook.casestudy.ejb;

import com.ibm.ejs.container.*;
import java.rmi.RemoteException;

/**
 * EJSLocalCMPEmployeeEJB_96c219b7
 */
public class EJSLocalCMPEmployeeEJB_96c219b7 extends EJSLocalWrapper implements com.wsbook.casestudy.ejb.EmployeeEJB {
	/**
	 * EJSLocalCMPEmployeeEJB_96c219b7
	 */
	public EJSLocalCMPEmployeeEJB_96c219b7() {
		super();	}
	/**
	 * getHomeAddress
	 */
	public com.wsbook.casestudy.ejb.AddressEJB getHomeAddress() {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		com.wsbook.casestudy.ejb.AddressEJB _EJS_result = null;
		try {
			com.wsbook.casestudy.ejb.EmployeeEJBBean beanRef = (com.wsbook.casestudy.ejb.EmployeeEJBBean)container.preInvoke(this, 0, _EJS_s);
			_EJS_result = beanRef.getHomeAddress();
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
	 * getOffice
	 */
	public com.wsbook.casestudy.ejb.OfficeLocation getOffice() {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		com.wsbook.casestudy.ejb.OfficeLocation _EJS_result = null;
		try {
			com.wsbook.casestudy.ejb.EmployeeEJBBean beanRef = (com.wsbook.casestudy.ejb.EmployeeEJBBean)container.preInvoke(this, 1, _EJS_s);
			_EJS_result = beanRef.getOffice();
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
	 * getName
	 */
	public java.lang.String getName() {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		java.lang.String _EJS_result = null;
		try {
			com.wsbook.casestudy.ejb.EmployeeEJBBean beanRef = (com.wsbook.casestudy.ejb.EmployeeEJBBean)container.preInvoke(this, 2, _EJS_s);
			_EJS_result = beanRef.getName();
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
	 * getApprovedTimesheets
	 */
	public java.util.Collection getApprovedTimesheets() {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		java.util.Collection _EJS_result = null;
		try {
			com.wsbook.casestudy.ejb.EmployeeEJBBean beanRef = (com.wsbook.casestudy.ejb.EmployeeEJBBean)container.preInvoke(this, 3, _EJS_s);
			_EJS_result = beanRef.getApprovedTimesheets();
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
	 * getTimesheets
	 */
	public java.util.Collection getTimesheets() {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		java.util.Collection _EJS_result = null;
		try {
			com.wsbook.casestudy.ejb.EmployeeEJBBean beanRef = (com.wsbook.casestudy.ejb.EmployeeEJBBean)container.preInvoke(this, 4, _EJS_s);
			_EJS_result = beanRef.getTimesheets();
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
	 * setApprovedTimesheets
	 */
	public void setApprovedTimesheets(java.util.Collection anApprovedTimesheets) {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		
		try {
			com.wsbook.casestudy.ejb.EmployeeEJBBean beanRef = (com.wsbook.casestudy.ejb.EmployeeEJBBean)container.preInvoke(this, 5, _EJS_s);
			beanRef.setApprovedTimesheets(anApprovedTimesheets);
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
	 * setHomeAddress
	 */
	public void setHomeAddress(com.wsbook.casestudy.ejb.AddressEJB aHomeAddress) {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		
		try {
			com.wsbook.casestudy.ejb.EmployeeEJBBean beanRef = (com.wsbook.casestudy.ejb.EmployeeEJBBean)container.preInvoke(this, 6, _EJS_s);
			beanRef.setHomeAddress(aHomeAddress);
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
	 * setName
	 */
	public void setName(java.lang.String newName) {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		
		try {
			com.wsbook.casestudy.ejb.EmployeeEJBBean beanRef = (com.wsbook.casestudy.ejb.EmployeeEJBBean)container.preInvoke(this, 7, _EJS_s);
			beanRef.setName(newName);
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
	 * setOffice
	 */
	public void setOffice(com.wsbook.casestudy.ejb.OfficeLocation newOffice) {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		
		try {
			com.wsbook.casestudy.ejb.EmployeeEJBBean beanRef = (com.wsbook.casestudy.ejb.EmployeeEJBBean)container.preInvoke(this, 8, _EJS_s);
			beanRef.setOffice(newOffice);
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
	 * setTimesheets
	 */
	public void setTimesheets(java.util.Collection aTimesheets) {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		
		try {
			com.wsbook.casestudy.ejb.EmployeeEJBBean beanRef = (com.wsbook.casestudy.ejb.EmployeeEJBBean)container.preInvoke(this, 9, _EJS_s);
			beanRef.setTimesheets(aTimesheets);
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

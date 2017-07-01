package com.wsbook.casestudy.ejb;

import com.ibm.ejs.container.*;
import java.rmi.RemoteException;

/**
 * EJSLocalCMPProjectEJB_8ce694f3
 */
public class EJSLocalCMPProjectEJB_8ce694f3 extends EJSLocalWrapper implements com.wsbook.casestudy.ejb.ProjectEJB {
	/**
	 * EJSLocalCMPProjectEJB_8ce694f3
	 */
	public EJSLocalCMPProjectEJB_8ce694f3() {
		super();	}
	/**
	 * getName
	 */
	public java.lang.String getName() {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		java.lang.String _EJS_result = null;
		try {
			com.wsbook.casestudy.ejb.ProjectEJBBean beanRef = (com.wsbook.casestudy.ejb.ProjectEJBBean)container.preInvoke(this, 0, _EJS_s);
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
	 * getTimesheetentry
	 */
	public java.util.Collection getTimesheetentry() {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		java.util.Collection _EJS_result = null;
		try {
			com.wsbook.casestudy.ejb.ProjectEJBBean beanRef = (com.wsbook.casestudy.ejb.ProjectEJBBean)container.preInvoke(this, 1, _EJS_s);
			_EJS_result = beanRef.getTimesheetentry();
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
	 * setName
	 */
	public void setName(java.lang.String newName) {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		
		try {
			com.wsbook.casestudy.ejb.ProjectEJBBean beanRef = (com.wsbook.casestudy.ejb.ProjectEJBBean)container.preInvoke(this, 2, _EJS_s);
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
	 * setTimesheetentry
	 */
	public void setTimesheetentry(java.util.Collection aTimesheetentry) {
		EJSDeployedSupport _EJS_s = container.getEJSDeployedSupport(this);
		
		try {
			com.wsbook.casestudy.ejb.ProjectEJBBean beanRef = (com.wsbook.casestudy.ejb.ProjectEJBBean)container.preInvoke(this, 3, _EJS_s);
			beanRef.setTimesheetentry(aTimesheetentry);
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
}

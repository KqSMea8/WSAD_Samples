package com.wsbook.casestudy.ejb;

import com.ibm.ejs.container.*;

/**
 * EJSCMPEmployeeEJBHomeBean_96c219b7
 */
public class EJSCMPEmployeeEJBHomeBean_96c219b7 extends EJSHome {
	/**
	 * EJSCMPEmployeeEJBHomeBean_96c219b7
	 */
	public EJSCMPEmployeeEJBHomeBean_96c219b7() throws java.rmi.RemoteException {
		super();	}
	/**
	 * findByPrimaryKey_Local
	 */
	public com.wsbook.casestudy.ejb.EmployeeEJB findByPrimaryKey_Local(java.lang.String primaryKey) throws javax.ejb.FinderException, java.rmi.RemoteException {
		return (com.wsbook.casestudy.ejb.EmployeeEJB)super.activateBean_Local(primaryKey);
	}
	/**
	 * create_Local
	 */
	public com.wsbook.casestudy.ejb.EmployeeEJB create_Local(java.lang.String empId, java.lang.String name) throws javax.ejb.CreateException, java.rmi.RemoteException {
		BeanO beanO = null;
		com.wsbook.casestudy.ejb.EmployeeEJB result = null;
		boolean createFailed = false;
		boolean preCreateFlag = false;
		try {
			beanO = super.createBeanO();
			com.wsbook.casestudy.ejb.EmployeeEJBBean bean = (com.wsbook.casestudy.ejb.EmployeeEJBBean) beanO.getEnterpriseBean();
			preCreateFlag = super.preEjbCreate(beanO);
			bean.ejbCreate(empId, name);
			Object ejsKey = keyFromBean(bean);
			result = (com.wsbook.casestudy.ejb.EmployeeEJB) super.postCreate_Local(beanO, ejsKey, true);
			bean.ejbPostCreate(empId, name);
			super.afterPostCreate(beanO, ejsKey);
		}
		catch (javax.ejb.CreateException ex) {
			createFailed = true;
			throw ex;
		} catch (java.rmi.RemoteException ex) {
			createFailed = true;
			throw ex;
		} catch (Throwable ex) {
			createFailed = true;
			throw new CreateFailureException(ex);
		} finally {
			if(preCreateFlag && !createFailed)
				super.afterPostCreateCompletion(beanO);
			if (createFailed) {
				super.createFailure(beanO);
			}
		}
		return result;
	}
	/**
	 * findAll_Local
	 */
	public java.util.Collection findAll_Local() throws javax.ejb.FinderException, java.rmi.RemoteException {
		java.util.Collection result = null;
		EntityBeanO beanO = null;

		try {
			beanO = super.getFinderEntityBeanO();
			com.wsbook.casestudy.ejb.ConcreteEmployeeEJB_96c219b7 bean = (com.wsbook.casestudy.ejb.ConcreteEmployeeEJB_96c219b7) beanO.getEnterpriseBean();
			java.util.Collection pKeys = bean.ejbFindAll_Local();
			result = super.getCMP20Collection_Local(pKeys);
			super.releaseFinderEntityBeanO(beanO);
			beanO = null;
		}
		catch (javax.ejb.FinderException finderEx) {
			super.releaseFinderEntityBeanO(beanO);
			beanO = null;
			throw finderEx;
		}
		finally {
			if (beanO != null )
				super.discardFinderEntityBeanO(beanO);
		}
		return result;
	}
	/**
	 * create_Local
	 */
	public com.wsbook.casestudy.ejb.EmployeeEJB create_Local(java.lang.String empId) throws javax.ejb.CreateException, java.rmi.RemoteException {
		BeanO beanO = null;
		com.wsbook.casestudy.ejb.EmployeeEJB result = null;
		boolean createFailed = false;
		boolean preCreateFlag = false;
		try {
			beanO = super.createBeanO();
			com.wsbook.casestudy.ejb.EmployeeEJBBean bean = (com.wsbook.casestudy.ejb.EmployeeEJBBean) beanO.getEnterpriseBean();
			preCreateFlag = super.preEjbCreate(beanO);
			bean.ejbCreate(empId);
			Object ejsKey = keyFromBean(bean);
			result = (com.wsbook.casestudy.ejb.EmployeeEJB) super.postCreate_Local(beanO, ejsKey, true);
			bean.ejbPostCreate(empId);
			super.afterPostCreate(beanO, ejsKey);
		}
		catch (javax.ejb.CreateException ex) {
			createFailed = true;
			throw ex;
		} catch (java.rmi.RemoteException ex) {
			createFailed = true;
			throw ex;
		} catch (Throwable ex) {
			createFailed = true;
			throw new CreateFailureException(ex);
		} finally {
			if(preCreateFlag && !createFailed)
				super.afterPostCreateCompletion(beanO);
			if (createFailed) {
				super.createFailure(beanO);
			}
		}
		return result;
	}
	/**
	 * findEmployeeByHomeAddressKey_Local
	 */
	public com.wsbook.casestudy.ejb.EmployeeEJB findEmployeeByHomeAddressKey_Local(com.wsbook.casestudy.ejb.AddressEJBKey key) throws javax.ejb.FinderException, java.rmi.RemoteException {
		com.wsbook.casestudy.ejb.EmployeeEJB result = null;
		EntityBeanO beanO = null;

		java.lang.String pKey = null;
		try {
			beanO = super.getFinderEntityBeanO();
			com.wsbook.casestudy.ejb.ConcreteEmployeeEJB_96c219b7 bean = (com.wsbook.casestudy.ejb.ConcreteEmployeeEJB_96c219b7) beanO.getEnterpriseBean();
			pKey = bean.ejbFindEmployeeByHomeAddressKey_Local(key);
			result = (com.wsbook.casestudy.ejb.EmployeeEJB)activateBean_Local(pKey);
			super.releaseFinderEntityBeanO(beanO);
			beanO = null;
		}
		catch (javax.ejb.FinderException finderEx) {
			super.releaseFinderEntityBeanO(beanO);
			beanO = null;
			throw finderEx;
		}
		finally {
			if (beanO != null )
				super.discardFinderEntityBeanO(beanO);
		}
		return result;
	}
	/**
	 * findSubmitterByTimesheetsKey_Local
	 */
	public com.wsbook.casestudy.ejb.EmployeeEJB findSubmitterByTimesheetsKey_Local(com.wsbook.casestudy.ejb.TimeSheetEJBKey key) throws javax.ejb.FinderException, java.rmi.RemoteException {
		com.wsbook.casestudy.ejb.EmployeeEJB result = null;
		EntityBeanO beanO = null;

		java.lang.String pKey = null;
		try {
			beanO = super.getFinderEntityBeanO();
			com.wsbook.casestudy.ejb.ConcreteEmployeeEJB_96c219b7 bean = (com.wsbook.casestudy.ejb.ConcreteEmployeeEJB_96c219b7) beanO.getEnterpriseBean();
			pKey = bean.ejbFindSubmitterByTimesheetsKey_Local(key);
			result = (com.wsbook.casestudy.ejb.EmployeeEJB)activateBean_Local(pKey);
			super.releaseFinderEntityBeanO(beanO);
			beanO = null;
		}
		catch (javax.ejb.FinderException finderEx) {
			super.releaseFinderEntityBeanO(beanO);
			beanO = null;
			throw finderEx;
		}
		finally {
			if (beanO != null )
				super.discardFinderEntityBeanO(beanO);
		}
		return result;
	}
	/**
	 * findApproverByApprovedTimesheetsKey_Local
	 */
	public com.wsbook.casestudy.ejb.EmployeeEJB findApproverByApprovedTimesheetsKey_Local(com.wsbook.casestudy.ejb.TimeSheetEJBKey key) throws javax.ejb.FinderException, java.rmi.RemoteException {
		com.wsbook.casestudy.ejb.EmployeeEJB result = null;
		EntityBeanO beanO = null;

		java.lang.String pKey = null;
		try {
			beanO = super.getFinderEntityBeanO();
			com.wsbook.casestudy.ejb.ConcreteEmployeeEJB_96c219b7 bean = (com.wsbook.casestudy.ejb.ConcreteEmployeeEJB_96c219b7) beanO.getEnterpriseBean();
			pKey = bean.ejbFindApproverByApprovedTimesheetsKey_Local(key);
			result = (com.wsbook.casestudy.ejb.EmployeeEJB)activateBean_Local(pKey);
			super.releaseFinderEntityBeanO(beanO);
			beanO = null;
		}
		catch (javax.ejb.FinderException finderEx) {
			super.releaseFinderEntityBeanO(beanO);
			beanO = null;
			throw finderEx;
		}
		finally {
			if (beanO != null )
				super.discardFinderEntityBeanO(beanO);
		}
		return result;
	}
	/**
	 * findByPrimaryKeyForCMR_Local
	 */
	public com.wsbook.casestudy.ejb.EmployeeEJB findByPrimaryKeyForCMR_Local(java.lang.String key) throws javax.ejb.FinderException, java.rmi.RemoteException {
		return (com.wsbook.casestudy.ejb.EmployeeEJB)super.activateBean_Local(key);
	}
	/**
	 * keyFromBean
	 */
	public Object keyFromBean(javax.ejb.EntityBean generalEJB) {
		com.wsbook.casestudy.ejb.ConcreteEmployeeEJB_96c219b7 tmpEJB = (com.wsbook.casestudy.ejb.ConcreteEmployeeEJB_96c219b7) generalEJB;
		return tmpEJB.getEmpId();
	}
	/**
	 * keyFromFields
	 */
	public java.lang.String keyFromFields(java.lang.String f0) {
		return f0;
	}
}

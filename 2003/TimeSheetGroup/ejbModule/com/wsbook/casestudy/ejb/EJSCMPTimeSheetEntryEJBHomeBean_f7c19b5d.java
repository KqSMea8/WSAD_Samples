package com.wsbook.casestudy.ejb;

import com.ibm.ejs.container.*;

/**
 * EJSCMPTimeSheetEntryEJBHomeBean_f7c19b5d
 */
public class EJSCMPTimeSheetEntryEJBHomeBean_f7c19b5d extends EJSHome {
	/**
	 * EJSCMPTimeSheetEntryEJBHomeBean_f7c19b5d
	 */
	public EJSCMPTimeSheetEntryEJBHomeBean_f7c19b5d() throws java.rmi.RemoteException {
		super();	}
	/**
	 * create_Local
	 */
	public com.wsbook.casestudy.ejb.TimeSheetEntryEJB create_Local(int entryId) throws javax.ejb.CreateException, java.rmi.RemoteException {
		BeanO beanO = null;
		com.wsbook.casestudy.ejb.TimeSheetEntryEJB result = null;
		boolean createFailed = false;
		boolean preCreateFlag = false;
		try {
			beanO = super.createBeanO();
			com.wsbook.casestudy.ejb.TimeSheetEntryEJBBean bean = (com.wsbook.casestudy.ejb.TimeSheetEntryEJBBean) beanO.getEnterpriseBean();
			preCreateFlag = super.preEjbCreate(beanO);
			bean.ejbCreate(entryId);
			Object ejsKey = keyFromBean(bean);
			result = (com.wsbook.casestudy.ejb.TimeSheetEntryEJB) super.postCreate_Local(beanO, ejsKey, true);
			bean.ejbPostCreate(entryId);
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
	 * findByPrimaryKey_Local
	 */
	public com.wsbook.casestudy.ejb.TimeSheetEntryEJB findByPrimaryKey_Local(com.wsbook.casestudy.ejb.TimeSheetEntryEJBKey primaryKey) throws javax.ejb.FinderException, java.rmi.RemoteException {
		return (com.wsbook.casestudy.ejb.TimeSheetEntryEJB)super.activateBean_Local(primaryKey);
	}
	/**
	 * create_Local
	 */
	public com.wsbook.casestudy.ejb.TimeSheetEntryEJB create_Local(double hours, java.lang.String date, com.wsbook.casestudy.ejb.ProjectEJB project, com.wsbook.casestudy.ejb.TimeSheetEJB timesheet) throws javax.ejb.CreateException, java.rmi.RemoteException {
		BeanO beanO = null;
		com.wsbook.casestudy.ejb.TimeSheetEntryEJB result = null;
		boolean createFailed = false;
		boolean preCreateFlag = false;
		try {
			beanO = super.createBeanO();
			com.wsbook.casestudy.ejb.TimeSheetEntryEJBBean bean = (com.wsbook.casestudy.ejb.TimeSheetEntryEJBBean) beanO.getEnterpriseBean();
			preCreateFlag = super.preEjbCreate(beanO);
			bean.ejbCreate(hours, date, project, timesheet);
			Object ejsKey = keyFromBean(bean);
			result = (com.wsbook.casestudy.ejb.TimeSheetEntryEJB) super.postCreate_Local(beanO, ejsKey, true);
			bean.ejbPostCreate(hours, date, project, timesheet);
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
			com.wsbook.casestudy.ejb.ConcreteTimeSheetEntryEJB_f7c19b5d bean = (com.wsbook.casestudy.ejb.ConcreteTimeSheetEntryEJB_f7c19b5d) beanO.getEnterpriseBean();
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
	 * findEntriesByTimesheetKey_Local
	 */
	public java.util.Collection findEntriesByTimesheetKey_Local(com.wsbook.casestudy.ejb.TimeSheetEJBKey key) throws javax.ejb.FinderException, java.rmi.RemoteException {
		java.util.Collection result = null;
		EntityBeanO beanO = null;

		try {
			beanO = super.getFinderEntityBeanO();
			com.wsbook.casestudy.ejb.ConcreteTimeSheetEntryEJB_f7c19b5d bean = (com.wsbook.casestudy.ejb.ConcreteTimeSheetEntryEJB_f7c19b5d) beanO.getEnterpriseBean();
			java.util.Collection pKeys = bean.ejbFindEntriesByTimesheetKey_Local(key);
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
	 * findTimesheetentryByProjectKey_Local
	 */
	public java.util.Collection findTimesheetentryByProjectKey_Local(java.lang.String key) throws javax.ejb.FinderException, java.rmi.RemoteException {
		java.util.Collection result = null;
		EntityBeanO beanO = null;

		try {
			beanO = super.getFinderEntityBeanO();
			com.wsbook.casestudy.ejb.ConcreteTimeSheetEntryEJB_f7c19b5d bean = (com.wsbook.casestudy.ejb.ConcreteTimeSheetEntryEJB_f7c19b5d) beanO.getEnterpriseBean();
			java.util.Collection pKeys = bean.ejbFindTimesheetentryByProjectKey_Local(key);
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
	 * keyFromBean
	 */
	public Object keyFromBean(javax.ejb.EntityBean generalEJB) {
		com.wsbook.casestudy.ejb.ConcreteTimeSheetEntryEJB_f7c19b5d tmpEJB = (com.wsbook.casestudy.ejb.ConcreteTimeSheetEntryEJB_f7c19b5d) generalEJB;
		com.wsbook.casestudy.ejb.TimeSheetEntryEJBKey keyClass = new com.wsbook.casestudy.ejb.TimeSheetEntryEJBKey();
		keyClass.entryId = tmpEJB.getEntryId();
		return keyClass;
	}
	/**
	 * keyFromFields
	 */
	public com.wsbook.casestudy.ejb.TimeSheetEntryEJBKey keyFromFields(int f0) {
		com.wsbook.casestudy.ejb.TimeSheetEntryEJBKey keyClass = new com.wsbook.casestudy.ejb.TimeSheetEntryEJBKey();
		keyClass.entryId = f0;
		return keyClass;
	}
}

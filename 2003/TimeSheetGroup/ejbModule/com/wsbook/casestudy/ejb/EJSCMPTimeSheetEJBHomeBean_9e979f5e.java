package com.wsbook.casestudy.ejb;

import com.ibm.ejs.container.*;

/**
 * EJSCMPTimeSheetEJBHomeBean_9e979f5e
 */
public class EJSCMPTimeSheetEJBHomeBean_9e979f5e extends EJSHome {
	/**
	 * EJSCMPTimeSheetEJBHomeBean_9e979f5e
	 */
	public EJSCMPTimeSheetEJBHomeBean_9e979f5e() throws java.rmi.RemoteException {
		super();	}
	/**
	 * findPendingByEmployee_Local
	 */
	public java.util.Collection findPendingByEmployee_Local(java.lang.String empId) throws javax.ejb.FinderException, java.rmi.RemoteException {
		java.util.Collection result = null;
		EntityBeanO beanO = null;

		try {
			beanO = super.getFinderEntityBeanO();
			com.wsbook.casestudy.ejb.ConcreteTimeSheetEJB_9e979f5e bean = (com.wsbook.casestudy.ejb.ConcreteTimeSheetEJB_9e979f5e) beanO.getEnterpriseBean();
			java.util.Collection pKeys = bean.ejbFindPendingByEmployee_Local(empId);
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
	 * findTimesheetsBySubmitter_Local
	 */
	public java.util.Collection findTimesheetsBySubmitter_Local(java.lang.String inKey) throws javax.ejb.FinderException, java.rmi.RemoteException {
		java.util.Collection result = null;
		EntityBeanO beanO = null;

		try {
			beanO = super.getFinderEntityBeanO();
			com.wsbook.casestudy.ejb.ConcreteTimeSheetEJB_9e979f5e bean = (com.wsbook.casestudy.ejb.ConcreteTimeSheetEJB_9e979f5e) beanO.getEnterpriseBean();
			java.util.Collection pKeys = bean.ejbFindTimesheetsBySubmitter_Local(inKey);
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
	public com.wsbook.casestudy.ejb.TimeSheetEJB create_Local(int timeSheetId, com.wsbook.casestudy.ejb.EmployeeEJB argSubmitter) throws javax.ejb.CreateException, java.rmi.RemoteException {
		BeanO beanO = null;
		com.wsbook.casestudy.ejb.TimeSheetEJB result = null;
		boolean createFailed = false;
		boolean preCreateFlag = false;
		try {
			beanO = super.createBeanO();
			com.wsbook.casestudy.ejb.TimeSheetEJBBean bean = (com.wsbook.casestudy.ejb.TimeSheetEJBBean) beanO.getEnterpriseBean();
			preCreateFlag = super.preEjbCreate(beanO);
			bean.ejbCreate(timeSheetId, argSubmitter);
			Object ejsKey = keyFromBean(bean);
			result = (com.wsbook.casestudy.ejb.TimeSheetEJB) super.postCreate_Local(beanO, ejsKey, true);
			bean.ejbPostCreate(timeSheetId, argSubmitter);
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
	public com.wsbook.casestudy.ejb.TimeSheetEJB findByPrimaryKey_Local(com.wsbook.casestudy.ejb.TimeSheetEJBKey primaryKey) throws javax.ejb.FinderException, java.rmi.RemoteException {
		return (com.wsbook.casestudy.ejb.TimeSheetEJB)super.activateBean_Local(primaryKey);
	}
	/**
	 * findApprovedTimesheetsByApprover_Local
	 */
	public java.util.Collection findApprovedTimesheetsByApprover_Local(java.lang.String inKey) throws javax.ejb.FinderException, java.rmi.RemoteException {
		java.util.Collection result = null;
		EntityBeanO beanO = null;

		try {
			beanO = super.getFinderEntityBeanO();
			com.wsbook.casestudy.ejb.ConcreteTimeSheetEJB_9e979f5e bean = (com.wsbook.casestudy.ejb.ConcreteTimeSheetEJB_9e979f5e) beanO.getEnterpriseBean();
			java.util.Collection pKeys = bean.ejbFindApprovedTimesheetsByApprover_Local(inKey);
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
	public com.wsbook.casestudy.ejb.TimeSheetEJB create_Local(java.lang.String weekend, java.lang.String state, com.wsbook.casestudy.ejb.EmployeeEJB submitter) throws javax.ejb.CreateException, java.rmi.RemoteException {
		BeanO beanO = null;
		com.wsbook.casestudy.ejb.TimeSheetEJB result = null;
		boolean createFailed = false;
		boolean preCreateFlag = false;
		try {
			beanO = super.createBeanO();
			com.wsbook.casestudy.ejb.TimeSheetEJBBean bean = (com.wsbook.casestudy.ejb.TimeSheetEJBBean) beanO.getEnterpriseBean();
			preCreateFlag = super.preEjbCreate(beanO);
			bean.ejbCreate(weekend, state, submitter);
			Object ejsKey = keyFromBean(bean);
			result = (com.wsbook.casestudy.ejb.TimeSheetEJB) super.postCreate_Local(beanO, ejsKey, true);
			bean.ejbPostCreate(weekend, state, submitter);
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
			com.wsbook.casestudy.ejb.ConcreteTimeSheetEJB_9e979f5e bean = (com.wsbook.casestudy.ejb.ConcreteTimeSheetEJB_9e979f5e) beanO.getEnterpriseBean();
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
	public com.wsbook.casestudy.ejb.TimeSheetEJB create_Local(int timeSheetId) throws javax.ejb.CreateException, java.rmi.RemoteException {
		BeanO beanO = null;
		com.wsbook.casestudy.ejb.TimeSheetEJB result = null;
		boolean createFailed = false;
		boolean preCreateFlag = false;
		try {
			beanO = super.createBeanO();
			com.wsbook.casestudy.ejb.TimeSheetEJBBean bean = (com.wsbook.casestudy.ejb.TimeSheetEJBBean) beanO.getEnterpriseBean();
			preCreateFlag = super.preEjbCreate(beanO);
			bean.ejbCreate(timeSheetId);
			Object ejsKey = keyFromBean(bean);
			result = (com.wsbook.casestudy.ejb.TimeSheetEJB) super.postCreate_Local(beanO, ejsKey, true);
			bean.ejbPostCreate(timeSheetId);
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
	 * findTimesheetByEntriesKey_Local
	 */
	public com.wsbook.casestudy.ejb.TimeSheetEJB findTimesheetByEntriesKey_Local(com.wsbook.casestudy.ejb.TimeSheetEntryEJBKey key) throws javax.ejb.FinderException, java.rmi.RemoteException {
		com.wsbook.casestudy.ejb.TimeSheetEJB result = null;
		EntityBeanO beanO = null;

		com.wsbook.casestudy.ejb.TimeSheetEJBKey pKey = null;
		try {
			beanO = super.getFinderEntityBeanO();
			com.wsbook.casestudy.ejb.ConcreteTimeSheetEJB_9e979f5e bean = (com.wsbook.casestudy.ejb.ConcreteTimeSheetEJB_9e979f5e) beanO.getEnterpriseBean();
			pKey = bean.ejbFindTimesheetByEntriesKey_Local(key);
			result = (com.wsbook.casestudy.ejb.TimeSheetEJB)activateBean_Local(pKey);
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
	 * findTimesheetsBySubmitterKey_Local
	 */
	public java.util.Collection findTimesheetsBySubmitterKey_Local(java.lang.String key) throws javax.ejb.FinderException, java.rmi.RemoteException {
		java.util.Collection result = null;
		EntityBeanO beanO = null;

		try {
			beanO = super.getFinderEntityBeanO();
			com.wsbook.casestudy.ejb.ConcreteTimeSheetEJB_9e979f5e bean = (com.wsbook.casestudy.ejb.ConcreteTimeSheetEJB_9e979f5e) beanO.getEnterpriseBean();
			java.util.Collection pKeys = bean.ejbFindTimesheetsBySubmitterKey_Local(key);
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
	 * findApprovedTimesheetsByApproverKey_Local
	 */
	public java.util.Collection findApprovedTimesheetsByApproverKey_Local(java.lang.String key) throws javax.ejb.FinderException, java.rmi.RemoteException {
		java.util.Collection result = null;
		EntityBeanO beanO = null;

		try {
			beanO = super.getFinderEntityBeanO();
			com.wsbook.casestudy.ejb.ConcreteTimeSheetEJB_9e979f5e bean = (com.wsbook.casestudy.ejb.ConcreteTimeSheetEJB_9e979f5e) beanO.getEnterpriseBean();
			java.util.Collection pKeys = bean.ejbFindApprovedTimesheetsByApproverKey_Local(key);
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
	 * findByPrimaryKeyForCMR_Local
	 */
	public com.wsbook.casestudy.ejb.TimeSheetEJB findByPrimaryKeyForCMR_Local(com.wsbook.casestudy.ejb.TimeSheetEJBKey key) throws javax.ejb.FinderException, java.rmi.RemoteException {
		return (com.wsbook.casestudy.ejb.TimeSheetEJB)super.activateBean_Local(key);
	}
	/**
	 * keyFromBean
	 */
	public Object keyFromBean(javax.ejb.EntityBean generalEJB) {
		com.wsbook.casestudy.ejb.ConcreteTimeSheetEJB_9e979f5e tmpEJB = (com.wsbook.casestudy.ejb.ConcreteTimeSheetEJB_9e979f5e) generalEJB;
		com.wsbook.casestudy.ejb.TimeSheetEJBKey keyClass = new com.wsbook.casestudy.ejb.TimeSheetEJBKey();
		keyClass.timeSheetId = tmpEJB.getTimeSheetId();
		return keyClass;
	}
	/**
	 * keyFromFields
	 */
	public com.wsbook.casestudy.ejb.TimeSheetEJBKey keyFromFields(int f0) {
		com.wsbook.casestudy.ejb.TimeSheetEJBKey keyClass = new com.wsbook.casestudy.ejb.TimeSheetEJBKey();
		keyClass.timeSheetId = f0;
		return keyClass;
	}
}

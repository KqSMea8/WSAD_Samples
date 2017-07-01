package com.wsbook.casestudy.ejb;

import com.ibm.ejs.container.*;

/**
 * EJSCMPProjectEJBHomeBean_8ce694f3
 */
public class EJSCMPProjectEJBHomeBean_8ce694f3 extends EJSHome {
	/**
	 * EJSCMPProjectEJBHomeBean_8ce694f3
	 */
	public EJSCMPProjectEJBHomeBean_8ce694f3() throws java.rmi.RemoteException {
		super();	}
	/**
	 * findByName_Local
	 */
	public com.wsbook.casestudy.ejb.ProjectEJB findByName_Local(java.lang.String name) throws javax.ejb.FinderException, java.rmi.RemoteException {
		com.wsbook.casestudy.ejb.ProjectEJB result = null;
		EntityBeanO beanO = null;

		java.lang.String pKey = null;
		try {
			beanO = super.getFinderEntityBeanO();
			com.wsbook.casestudy.ejb.ConcreteProjectEJB_8ce694f3 bean = (com.wsbook.casestudy.ejb.ConcreteProjectEJB_8ce694f3) beanO.getEnterpriseBean();
			pKey = bean.ejbFindByName_Local(name);
			result = (com.wsbook.casestudy.ejb.ProjectEJB)activateBean_Local(pKey);
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
	 * findByPrimaryKey_Local
	 */
	public com.wsbook.casestudy.ejb.ProjectEJB findByPrimaryKey_Local(java.lang.String primaryKey) throws javax.ejb.FinderException, java.rmi.RemoteException {
		return (com.wsbook.casestudy.ejb.ProjectEJB)super.activateBean_Local(primaryKey);
	}
	/**
	 * create_Local
	 */
	public com.wsbook.casestudy.ejb.ProjectEJB create_Local(java.lang.String projNumber, java.lang.String name) throws javax.ejb.CreateException, java.rmi.RemoteException {
		BeanO beanO = null;
		com.wsbook.casestudy.ejb.ProjectEJB result = null;
		boolean createFailed = false;
		boolean preCreateFlag = false;
		try {
			beanO = super.createBeanO();
			com.wsbook.casestudy.ejb.ProjectEJBBean bean = (com.wsbook.casestudy.ejb.ProjectEJBBean) beanO.getEnterpriseBean();
			preCreateFlag = super.preEjbCreate(beanO);
			bean.ejbCreate(projNumber, name);
			Object ejsKey = keyFromBean(bean);
			result = (com.wsbook.casestudy.ejb.ProjectEJB) super.postCreate_Local(beanO, ejsKey, true);
			bean.ejbPostCreate(projNumber, name);
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
			com.wsbook.casestudy.ejb.ConcreteProjectEJB_8ce694f3 bean = (com.wsbook.casestudy.ejb.ConcreteProjectEJB_8ce694f3) beanO.getEnterpriseBean();
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
	public com.wsbook.casestudy.ejb.ProjectEJB create_Local(java.lang.String projNumber) throws javax.ejb.CreateException, java.rmi.RemoteException {
		BeanO beanO = null;
		com.wsbook.casestudy.ejb.ProjectEJB result = null;
		boolean createFailed = false;
		boolean preCreateFlag = false;
		try {
			beanO = super.createBeanO();
			com.wsbook.casestudy.ejb.ProjectEJBBean bean = (com.wsbook.casestudy.ejb.ProjectEJBBean) beanO.getEnterpriseBean();
			preCreateFlag = super.preEjbCreate(beanO);
			bean.ejbCreate(projNumber);
			Object ejsKey = keyFromBean(bean);
			result = (com.wsbook.casestudy.ejb.ProjectEJB) super.postCreate_Local(beanO, ejsKey, true);
			bean.ejbPostCreate(projNumber);
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
	 * findProjectByTimesheetentryKey_Local
	 */
	public com.wsbook.casestudy.ejb.ProjectEJB findProjectByTimesheetentryKey_Local(com.wsbook.casestudy.ejb.TimeSheetEntryEJBKey key) throws javax.ejb.FinderException, java.rmi.RemoteException {
		com.wsbook.casestudy.ejb.ProjectEJB result = null;
		EntityBeanO beanO = null;

		java.lang.String pKey = null;
		try {
			beanO = super.getFinderEntityBeanO();
			com.wsbook.casestudy.ejb.ConcreteProjectEJB_8ce694f3 bean = (com.wsbook.casestudy.ejb.ConcreteProjectEJB_8ce694f3) beanO.getEnterpriseBean();
			pKey = bean.ejbFindProjectByTimesheetentryKey_Local(key);
			result = (com.wsbook.casestudy.ejb.ProjectEJB)activateBean_Local(pKey);
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
	public com.wsbook.casestudy.ejb.ProjectEJB findByPrimaryKeyForCMR_Local(java.lang.String key) throws javax.ejb.FinderException, java.rmi.RemoteException {
		return (com.wsbook.casestudy.ejb.ProjectEJB)super.activateBean_Local(key);
	}
	/**
	 * keyFromBean
	 */
	public Object keyFromBean(javax.ejb.EntityBean generalEJB) {
		com.wsbook.casestudy.ejb.ConcreteProjectEJB_8ce694f3 tmpEJB = (com.wsbook.casestudy.ejb.ConcreteProjectEJB_8ce694f3) generalEJB;
		return tmpEJB.getProjNumber();
	}
	/**
	 * keyFromFields
	 */
	public java.lang.String keyFromFields(java.lang.String f0) {
		return f0;
	}
}

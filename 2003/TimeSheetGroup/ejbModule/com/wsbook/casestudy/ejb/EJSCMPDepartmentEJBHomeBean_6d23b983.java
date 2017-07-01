package com.wsbook.casestudy.ejb;

import com.ibm.ejs.container.*;

/**
 * EJSCMPDepartmentEJBHomeBean_6d23b983
 */
public class EJSCMPDepartmentEJBHomeBean_6d23b983 extends EJSHome {
	/**
	 * EJSCMPDepartmentEJBHomeBean_6d23b983
	 */
	public EJSCMPDepartmentEJBHomeBean_6d23b983() throws java.rmi.RemoteException {
		super();	}
	/**
	 * create_Local
	 */
	public com.wsbook.casestudy.ejb.DepartmentEJB create_Local(int deptNumber) throws javax.ejb.CreateException, java.rmi.RemoteException {
		BeanO beanO = null;
		com.wsbook.casestudy.ejb.DepartmentEJB result = null;
		boolean createFailed = false;
		boolean preCreateFlag = false;
		try {
			beanO = super.createBeanO();
			com.wsbook.casestudy.ejb.DepartmentEJBBean bean = (com.wsbook.casestudy.ejb.DepartmentEJBBean) beanO.getEnterpriseBean();
			preCreateFlag = super.preEjbCreate(beanO);
			bean.ejbCreate(deptNumber);
			Object ejsKey = keyFromBean(bean);
			result = (com.wsbook.casestudy.ejb.DepartmentEJB) super.postCreate_Local(beanO, ejsKey, true);
			bean.ejbPostCreate(deptNumber);
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
	 * create_Local
	 */
	public com.wsbook.casestudy.ejb.DepartmentEJB create_Local(int deptNumber, java.lang.String name) throws javax.ejb.CreateException, java.rmi.RemoteException {
		BeanO beanO = null;
		com.wsbook.casestudy.ejb.DepartmentEJB result = null;
		boolean createFailed = false;
		boolean preCreateFlag = false;
		try {
			beanO = super.createBeanO();
			com.wsbook.casestudy.ejb.DepartmentEJBBean bean = (com.wsbook.casestudy.ejb.DepartmentEJBBean) beanO.getEnterpriseBean();
			preCreateFlag = super.preEjbCreate(beanO);
			bean.ejbCreate(deptNumber, name);
			Object ejsKey = keyFromBean(bean);
			result = (com.wsbook.casestudy.ejb.DepartmentEJB) super.postCreate_Local(beanO, ejsKey, true);
			bean.ejbPostCreate(deptNumber, name);
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
			com.wsbook.casestudy.ejb.ConcreteDepartmentEJB_6d23b983 bean = (com.wsbook.casestudy.ejb.ConcreteDepartmentEJB_6d23b983) beanO.getEnterpriseBean();
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
	 * findByPrimaryKey_Local
	 */
	public com.wsbook.casestudy.ejb.DepartmentEJB findByPrimaryKey_Local(com.wsbook.casestudy.ejb.DepartmentEJBKey primaryKey) throws javax.ejb.FinderException, java.rmi.RemoteException {
		return (com.wsbook.casestudy.ejb.DepartmentEJB)super.activateBean_Local(primaryKey);
	}
	/**
	 * keyFromBean
	 */
	public Object keyFromBean(javax.ejb.EntityBean generalEJB) {
		com.wsbook.casestudy.ejb.ConcreteDepartmentEJB_6d23b983 tmpEJB = (com.wsbook.casestudy.ejb.ConcreteDepartmentEJB_6d23b983) generalEJB;
		com.wsbook.casestudy.ejb.DepartmentEJBKey keyClass = new com.wsbook.casestudy.ejb.DepartmentEJBKey();
		keyClass.deptNumber = tmpEJB.getDeptNumber();
		return keyClass;
	}
	/**
	 * keyFromFields
	 */
	public com.wsbook.casestudy.ejb.DepartmentEJBKey keyFromFields(int f0) {
		com.wsbook.casestudy.ejb.DepartmentEJBKey keyClass = new com.wsbook.casestudy.ejb.DepartmentEJBKey();
		keyClass.deptNumber = f0;
		return keyClass;
	}
}

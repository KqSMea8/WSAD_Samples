package com.wsbook.casestudy.ejb;

import com.ibm.ejs.container.*;

/**
 * EJSBMPCustomerEJBHomeBean_2939ee61
 */
public class EJSBMPCustomerEJBHomeBean_2939ee61 extends EJSHome {
	/**
	 * EJSBMPCustomerEJBHomeBean_2939ee61
	 */
	public EJSBMPCustomerEJBHomeBean_2939ee61() throws java.rmi.RemoteException {
		super();	}
	/**
	 * create_Local
	 */
	public com.wsbook.casestudy.ejb.CustomerEJB create_Local(int arg1, java.lang.String arg2) throws javax.ejb.CreateException, java.rmi.RemoteException {
		BeanO beanO = null;
		com.wsbook.casestudy.ejb.CustomerEJB result = null;
		boolean createFailed = false;
		boolean preCreateFlag = false;
		try {
			beanO = super.createBeanO();
			com.wsbook.casestudy.ejb.CustomerEJBBean bean = (com.wsbook.casestudy.ejb.CustomerEJBBean) beanO.getEnterpriseBean();
			preCreateFlag = super.preEjbCreate(beanO);
			com.wsbook.casestudy.ejb.CustomerEJBKey _primaryKey = bean.ejbCreate(arg1, arg2);
			result = (com.wsbook.casestudy.ejb.CustomerEJB) super.postCreate_Local(beanO, _primaryKey, true);
			bean.ejbPostCreate(arg1, arg2);
			super.afterPostCreate(beanO, _primaryKey);
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
	public com.wsbook.casestudy.ejb.CustomerEJB findByPrimaryKey_Local(com.wsbook.casestudy.ejb.CustomerEJBKey primaryKey) throws javax.ejb.FinderException, java.rmi.RemoteException {
		com.wsbook.casestudy.ejb.CustomerEJB _EJS_bmp = (com.wsbook.casestudy.ejb.CustomerEJB)super.getBean_Local(primaryKey);
		if (_EJS_bmp==null) {
			EntityBeanO _EJS_beanO = null;
			com.wsbook.casestudy.ejb.CustomerEJBKey _EJS_key = null;
			try {
				_EJS_beanO = super.getFindByPrimaryKeyEntityBeanO();
				com.wsbook.casestudy.ejb.CustomerEJBBean _EJS_bean = (com.wsbook.casestudy.ejb.CustomerEJBBean)_EJS_beanO.getEnterpriseBean();
				_EJS_key = (com.wsbook.casestudy.ejb.CustomerEJBKey)_EJS_bean.ejbFindByPrimaryKey(primaryKey);
				super.releaseFinderEntityBeanO(_EJS_beanO);
				_EJS_beanO = null;
			}
			catch (javax.ejb.FinderException finderEx) {
				super.releaseFinderEntityBeanO(_EJS_beanO);
				_EJS_beanO = null;
				throw finderEx;
			}
			finally {
				if (_EJS_beanO != null)
					super.discardFinderEntityBeanO(_EJS_beanO);
			}
			_EJS_bmp = (com.wsbook.casestudy.ejb.CustomerEJB)super.activateBean_Local((java.lang.Object)_EJS_key);
		}
		return _EJS_bmp;
	}
}

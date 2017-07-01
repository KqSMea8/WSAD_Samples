package com.wsbook.casestudy.ejb;

import com.ibm.ejs.container.*;

/**
 * EJSCMPAddressEJBHomeBean_7a46140f
 */
public class EJSCMPAddressEJBHomeBean_7a46140f extends EJSHome {
	/**
	 * EJSCMPAddressEJBHomeBean_7a46140f
	 */
	public EJSCMPAddressEJBHomeBean_7a46140f() throws java.rmi.RemoteException {
		super();	}
	/**
	 * create_Local
	 */
	public com.wsbook.casestudy.ejb.AddressEJB create_Local(int addressKey) throws javax.ejb.CreateException, java.rmi.RemoteException {
		BeanO beanO = null;
		com.wsbook.casestudy.ejb.AddressEJB result = null;
		boolean createFailed = false;
		boolean preCreateFlag = false;
		try {
			beanO = super.createBeanO();
			com.wsbook.casestudy.ejb.AddressEJBBean bean = (com.wsbook.casestudy.ejb.AddressEJBBean) beanO.getEnterpriseBean();
			preCreateFlag = super.preEjbCreate(beanO);
			bean.ejbCreate(addressKey);
			Object ejsKey = keyFromBean(bean);
			result = (com.wsbook.casestudy.ejb.AddressEJB) super.postCreate_Local(beanO, ejsKey, true);
			bean.ejbPostCreate(addressKey);
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
	public com.wsbook.casestudy.ejb.AddressEJB findByPrimaryKey_Local(com.wsbook.casestudy.ejb.AddressEJBKey primaryKey) throws javax.ejb.FinderException, java.rmi.RemoteException {
		return (com.wsbook.casestudy.ejb.AddressEJB)super.activateBean_Local(primaryKey);
	}
	/**
	 * findHomeAddressByEmployeeKey_Local
	 */
	public com.wsbook.casestudy.ejb.AddressEJB findHomeAddressByEmployeeKey_Local(java.lang.String key) throws javax.ejb.FinderException, java.rmi.RemoteException {
		com.wsbook.casestudy.ejb.AddressEJB result = null;
		EntityBeanO beanO = null;

		com.wsbook.casestudy.ejb.AddressEJBKey pKey = null;
		try {
			beanO = super.getFinderEntityBeanO();
			com.wsbook.casestudy.ejb.ConcreteAddressEJB_7a46140f bean = (com.wsbook.casestudy.ejb.ConcreteAddressEJB_7a46140f) beanO.getEnterpriseBean();
			pKey = bean.ejbFindHomeAddressByEmployeeKey_Local(key);
			result = (com.wsbook.casestudy.ejb.AddressEJB)activateBean_Local(pKey);
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
	public com.wsbook.casestudy.ejb.AddressEJB findByPrimaryKeyForCMR_Local(com.wsbook.casestudy.ejb.AddressEJBKey key) throws javax.ejb.FinderException, java.rmi.RemoteException {
		return (com.wsbook.casestudy.ejb.AddressEJB)super.activateBean_Local(key);
	}
	/**
	 * keyFromBean
	 */
	public Object keyFromBean(javax.ejb.EntityBean generalEJB) {
		com.wsbook.casestudy.ejb.ConcreteAddressEJB_7a46140f tmpEJB = (com.wsbook.casestudy.ejb.ConcreteAddressEJB_7a46140f) generalEJB;
		com.wsbook.casestudy.ejb.AddressEJBKey keyClass = new com.wsbook.casestudy.ejb.AddressEJBKey();
		keyClass.addressKey = tmpEJB.getAddressKey();
		return keyClass;
	}
	/**
	 * keyFromFields
	 */
	public com.wsbook.casestudy.ejb.AddressEJBKey keyFromFields(int f0) {
		com.wsbook.casestudy.ejb.AddressEJBKey keyClass = new com.wsbook.casestudy.ejb.AddressEJBKey();
		keyClass.addressKey = f0;
		return keyClass;
	}
}

package com.wsbook.casestudy.ejb.websphere_deploy;

/**
 * Internal Local Home interface for Enterprise Bean: AddressEJB
 */
public interface AddressEJBBeanInternalLocalHome_7a46140f {
	/**
	 * findHomeAddressByEmployeeKey_Local
	 */
	public com.wsbook.casestudy.ejb.AddressEJB findHomeAddressByEmployeeKey_Local(java.lang.String key) throws javax.ejb.FinderException;
	/**
	 * findByPrimaryKeyForCMR
	 */
	public com.wsbook.casestudy.ejb.AddressEJB findByPrimaryKeyForCMR(com.wsbook.casestudy.ejb.AddressEJBKey key) throws javax.ejb.FinderException;
}

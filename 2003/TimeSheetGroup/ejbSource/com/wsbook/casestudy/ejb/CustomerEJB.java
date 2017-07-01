package com.wsbook.casestudy.ejb;
/**
 * Local interface for Enterprise Bean: CustomerEJB
 */
public interface CustomerEJB extends javax.ejb.EJBLocalObject {
	/**
	 * getAccountBalance
	 */
	public int getAccountBalance();
	/**
	 * getCustomerName
	 */
	public java.lang.String getCustomerName();
	/**
	 * getCustomerNumber
	 */
	public int getCustomerNumber();
	/**
	 * setAccountBalance
	 */
	public void setAccountBalance(int arg1);
	/**
	 * setCustomerName
	 */
	public void setCustomerName(java.lang.String arg1);
}

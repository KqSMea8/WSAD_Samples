package com.ibm.ejb.tests;

/**
 * @author kbrown
 *
 * To change this generated comment edit the template variable "typecomment":
 * Window>Preferences>Java>Templates.
 * To enable and disable the creation of type comments go to
 * Window>Preferences>Java>Code Generation.
 */
public class Order implements java.io.Serializable {
	
	public String orderNumber;
	public String customerNumber;
	public java.sql.Date placementDate;
	public String status;

	/**
	 * Returns the customerNumber.
	 * @return String
	 */
	public String getCustomerNumber() {
		return customerNumber;
	}

	/**
	 * Returns the orderNumber.
	 * @return String
	 */
	public String getOrderNumber() {
		return orderNumber;
	}

	/**
	 * Returns the placementDate.
	 * @return java.sql.Date
	 */
	public java.sql.Date getPlacementDate() {
		return placementDate;
	}

	/**
	 * Sets the customerNumber.
	 * @param customerNumber The customerNumber to set
	 */
	public void setCustomerNumber(String customerNumber) {
		this.customerNumber = customerNumber;
	}

	/**
	 * Sets the orderNumber.
	 * @param orderNumber The orderNumber to set
	 */
	public void setOrderNumber(String orderNumber) {
		this.orderNumber = orderNumber;
	}

	/**
	 * Sets the placementDate.
	 * @param placementDate The placementDate to set
	 */
	public void setPlacementDate(java.sql.Date placementDate) {
		this.placementDate = placementDate;
	}

	/**
	 * Returns the status.
	 * @return String
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * Sets the status.
	 * @param status The status to set
	 */
	public void setStatus(String status) {
		this.status = status;
	}

}

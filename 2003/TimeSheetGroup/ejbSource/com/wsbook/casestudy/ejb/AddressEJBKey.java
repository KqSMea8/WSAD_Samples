package com.wsbook.casestudy.ejb;
/**
 * Key class for Entity Bean: AddressEJB
 */
public class AddressEJBKey implements java.io.Serializable {
	static final long serialVersionUID = 3206093459760846163L;
	/**
	 * Implementation field for persistent attribute: addressKey
	 */
	public int addressKey;
	/**
	 * Creates an empty key for Entity Bean: AddressEJB
	 */
	public AddressEJBKey() {
	}
	/**
	 * Creates a key for Entity Bean: AddressEJB
	 */
	public AddressEJBKey(int addressKey) {
		this.addressKey = addressKey;
	}
	/**
	 * Returns true if both keys are equal.
	 */
	public boolean equals(java.lang.Object otherKey) {
		if (otherKey instanceof com.wsbook.casestudy.ejb.AddressEJBKey) {
			com.wsbook.casestudy.ejb.AddressEJBKey o = (com.wsbook.casestudy.ejb.AddressEJBKey)otherKey;
			return ((this.addressKey == o.addressKey));
		}
		return false;
	}
	/**
	 * Returns the hash code for the key.
	 */
	public int hashCode() {
		return ((new java.lang.Integer(addressKey).hashCode()));
	}
	/**
	 * Get accessor for persistent attribute: addressKey
	 */
	public int getAddressKey() {
		return addressKey;
	}
	/**
	 * Set accessor for persistent attribute: addressKey
	 */
	public void setAddressKey(int newAddressKey) {
		addressKey = newAddressKey;
	}
}

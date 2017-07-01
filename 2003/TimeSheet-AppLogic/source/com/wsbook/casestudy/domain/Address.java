package com.wsbook.casestudy.domain;

/**
 * This is an Address domain object.  It is used in the BMP example
 * to show obtaining a dependent object from a BMP.
 *
 * Creation date: (7/16/2000 4:48:58 PM)
 * @author: Administrator
 */
public class Address implements java.io.Serializable {
	private String streetAddress = new String();
	private String city = new String();
	private String state = new String();
	private String zip = new String();
	private int key = 0;
	
/**
 * Address constructor comment.
 */
public Address() {
	super();
}
/**
 * Return the city
 * Creation date: (7/16/2000 4:50:04 PM)
 * @return java.lang.String
 */
public java.lang.String getCity() {
	return city;
}
/**
 * Return the state
 * Creation date: (7/16/2000 4:50:17 PM)
 * @return java.lang.String
 */
public java.lang.String getState() {
	return state;
}
/**
 * Return the street address
 * Creation date: (7/16/2000 4:49:48 PM)
 * @return java.lang.String
 */
public java.lang.String getStreetAddress() {
	return streetAddress;
}
/**
 * Return the zip code
 * Creation date: (7/16/2000 4:50:30 PM)
 * @return java.lang.String
 */
public java.lang.String getZip() {
	return zip;
}
/**
 * Set the city
 * Creation date: (7/16/2000 4:50:04 PM)
 * @param newCity java.lang.String
 */
public void setCity(java.lang.String newCity) {
	city = newCity;
}
/**
 * Set the State
 * Creation date: (7/16/2000 4:50:17 PM)
 * @param newState java.lang.String
 */
public void setState(java.lang.String newState) {
	state = newState;
}
/**
 * Set the street address
 * Creation date: (7/16/2000 4:49:48 PM)
 * @param newStreetAddress java.lang.String
 */
public void setStreetAddress(java.lang.String newStreetAddress) {
	streetAddress = newStreetAddress;
}
/**
 * Set the zip code
 * Creation date: (7/16/2000 4:50:30 PM)
 * @param newZip java.lang.String
 */
public void setZip(java.lang.String newZip) {
	zip = newZip;
}
	/**
	 * Gets the key
	 * @return Returns a int
	 */
	public int getKey() {
		return key;
	}
	/**
	 * Sets the key
	 * @param key The key to set
	 */
	public void setKey(int key) {
		this.key = key;
	}

}

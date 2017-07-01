package com.wsbook.casestudy.ejb;
/**
 * OfficeLocationComposer
 * @generated
 */
public class OfficeLocationComposer
	extends com.ibm.vap.composers.VapAttributeComposer {
	static OfficeLocationComposer singleton = null;
	/**
	 * Return the target class name. This should return the name of the class for the instance instanciated 
	 * as a result of the objectFrom: message sent to the composer. 
	 */
	public static String getTargetClassName() {
		return "com.wsbook.casestudy.ejb.OfficeLocation";
	}
	/**
	 * Answer the appropriate collection of objects that are to go TO a datastore fields. 
	 * Note that this is an object to object collection conversion. The conversion to persistent 
	 * format (strings in the case of SQL) occurs elsewhere. The default is to do nothing. 
	 */
	public Object[] dataFrom(Object anObject) {
	    Object[] anArray = new Object[4];
	    if (anObject != null) {
	    	OfficeLocation location = (OfficeLocation) anObject;
	        anArray[0] = location.getState();
	        anArray[1] = location.getCity();
	        anArray[2] = location.getBuilding();
	        anArray[3] = location.getOffice();
	    }
	    return anArray;
	}
	/** 
	 * Answer the list of attribute names for my target class. 
	 * @return java.lang.String[] 
	 */
	public static String[] getAttributeNames() {
		String[] attributes = { "state", "city", "building", "office" };
		return attributes;
	}
	/** 
	 * Return the data elements class name. This should return the name of the class for the data element 
	 * passed as a parameter to the objectFrom: message sent to the composer. 
	 */
	public static String[] getSourceDatatype() {
		String[] types =
			{
				"java.lang.String",
				"java.lang.String",
				"java.lang.String",
				"java.lang.String" };
		return types;
	}
	/** 
	 * Use the collection of data values to instantiate an Object. The default 
	 * does nothing but return the collection. 
	 */
	public Object objectFrom(Object[] anArray) {
		OfficeLocation location = new OfficeLocation();
		location.setState((String) anArray[0]);
	    location.setCity((String) anArray[1]);
	    location.setBuilding((String) anArray[2]);
	    location.setOffice((String) anArray[3]);
	    return location;
	}
	/** 
	 * Set the singleton variable to null. 
	 * This is required by each subclass. 
	 */
	public static void reset() {
		singleton = null;
	}
	/** 
	 * Singleton method to return instance of the composer 
	 */
	public static OfficeLocationComposer singleton() {
		if (singleton == null)
			singleton = new OfficeLocationComposer();
		return singleton;
	}
}

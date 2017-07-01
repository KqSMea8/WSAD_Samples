package com.wsbook.casestudy.ejb;

import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 * DateToStringConverter
 * @generated
 */
public class DateToStringConverter
	extends com.ibm.vap.converters.VapAbstractConverter {
	static DateToStringConverter singleton = null;
	/**
	 * Return the target class name. This should return the name of the class for the instance instanciated 
	 * as a result of the objectFrom: message sent to the converter. 
	 */
	public static String getTargetClassName() {
		return "java.lang.String";
	}
	/**
	 * Answer the appropriate object that is to go TO a datastore field. 
	 * Note that this is an object to object conversion. The conversion to persistent 
	 * format (strings in the case of SQL) occurs elsewhere. The default is to do nothing. 
	 */
	public Object dataFrom(Object anObject) {
		//date in format "yyyy-mm-dd"
		// below is Dan's old code
		//String dateString = (String) anObject;
		//return java.sql.Date.valueOf(dateString);
		Date date = null;
		try {
			String dateString = (String) anObject;
			DateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
			java.util.Date parsed = formatter.parse(dateString);
			return new java.sql.Date(parsed.getTime());
		} catch (ParseException e) {
			// can't do anything, so eat the exception 
		}
		return date;
	}
	/**
	 * Answer the appropriate object from a field object FROM a datastore. 
	 * Note that this is an object to object conversion.  The conversion to persistent 
	 * format (strings in the case of SQL) occurs elsewhere. 
	 * The default is to do nothing. 
	 */
	public Object objectFrom(Object aField) {
		//return a String in format "yyyy-mm-dd"
		// Below is Dan's old code
		//java.sql.Date date = (java.sql.Date) aField;
		//return date.toString();
		java.sql.Date date = (java.sql.Date) aField;
		String value = null;
		DateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
		value = formatter.format(date);
		return value;
	}
	/** 
	 * Set the singleton variable to null. 
	 * This is required by each subclass. 
	 */
	public static void reset() {
		singleton = null;
	}
	/** 
	 * Singleton method to return instance of the converter 
	 */
	public static DateToStringConverter singleton() {
		if (singleton == null)
			singleton = new DateToStringConverter();
		return singleton;
	}
}

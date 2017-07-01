package com.wsbook.casestudy.exception;

public class NoSuchTimeSheetException extends NoSuchObjectException {

	/**
	 * Constructor for NoSuchTimeSheetException
	 */
	public NoSuchTimeSheetException() {
		super();
	}

	/**
	 * Constructor for NoSuchTimeSheetException
	 */
	public NoSuchTimeSheetException(String arg0) {
		super(arg0);
	}
	
	public NoSuchTimeSheetException(Exception arg0, String desc) {
		super(arg0, desc);
	}

}


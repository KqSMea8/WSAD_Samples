package com.wsbook.casestudy.exception;

public class NoSuchProjectException extends NoSuchObjectException {

	/**
	 * Constructor for NoSuchProjectException
	 */
	public NoSuchProjectException() {
		super();
	}

	/**
	 * Constructor for NoSuchProjectException
	 */
	public NoSuchProjectException(String arg0) {
		super(arg0);
	}

	/**
	 * Constructor NoSuchProjectException.
	 * @param arg0
	 * @param string
	 */
	public NoSuchProjectException(Exception arg0, String string) {
		super(arg0, string);
	}


}


package com.wsbook.casestudy.exception;

import java.rmi.RemoteException;


public class NoSuchEmployeeException extends NoSuchObjectException {

	/**
	 * Constructor for NoSuchEmployeeException
	 */
	public NoSuchEmployeeException() {
		super();
	}

	/**
	 * Constructor for NoSuchEmployeeException
	 */
	public NoSuchEmployeeException(String arg0) {
		super(arg0);
	}

	/**
	 * Constructor NoSuchEmployeeException.
	 * @param re
	 * @param string
	 */
	public NoSuchEmployeeException(Exception e, String string) {
		super(e,string);
	}


}


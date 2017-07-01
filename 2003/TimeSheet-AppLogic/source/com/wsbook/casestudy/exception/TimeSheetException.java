package com.wsbook.casestudy.exception;

import java.io.Serializable;

public class TimeSheetException extends WrappedException implements Serializable {

	/**
	 * Constructor for TimeSheetException
	 */
	public TimeSheetException() {
		super();
	}

	/**
	 * Constructor for TimeSheetException
	 */
	public TimeSheetException(String arg0) {
		super(arg0);
	}

	/**
	 * Constructor TimeSheetException.
	 * @param arg0
	 */
	public TimeSheetException(Exception arg0, String desc) {
		super(arg0, desc);
	}


}


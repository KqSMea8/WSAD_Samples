package com.wsbook.casestudy.system;

/**
 * Time Sheet Startup Class.
 */
public class TimeSheetStartup implements StartupCapable {
/**
 * TimeSheetStartup constructor comment.
 */
public TimeSheetStartup() {
	super();
}

public void end() {

	
}
/**
 * perform startup sequence.
 */
public void start() {

	// Initiliaze StrataSystem class 
	AppService.startup = this;
	
	// Initialize Properties Object
	AppService.property = new TimeSheetProperties();

	
}
}

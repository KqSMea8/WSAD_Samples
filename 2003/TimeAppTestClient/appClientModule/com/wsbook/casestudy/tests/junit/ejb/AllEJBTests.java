package com.wsbook.casestudy.tests.junit.ejb;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 *
 * This is an AllTests class that runs all of the tests in the 
 * com.wsbook.casestudy.tests.junit.ejb package.  The use of an AllTests
 * class in each package is a common practice for regression testing.
 *  
 */
public class AllEJBTests extends TestCase {

	/**
	 * Constructor for AllEJBTests.
	 * @param arg0
	 */
	public AllEJBTests(String arg0) {
		super(arg0);
	}
	
	public static Test suite() {
		
		TestSuite suite =  new TestSuite();
		suite.addTest(new TestSuite(TimesheetActionProcessorTests.class));
		suite.addTest(new TestSuite(ReportActionProcessorTests.class));
		return suite;
		
	}

}

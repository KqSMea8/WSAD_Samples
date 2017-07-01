package com.wsbook.casestudy.mapper.jdbc.test;
import junit.framework.*;
/**
 * Insert the type's description here.
 * Creation date: (3/30/2001 9:35:20 AM)
 * @author: ILS User
 */
public class JDBCMapperTestSuite extends TestSuite {
/**
 * ControllerTestSuite constructor comment.
 */
public JDBCMapperTestSuite() {
	super();
}

/**
 * ControllerTestSuite constructor comment.
 * @param theClass java.lang.Class
 */
public JDBCMapperTestSuite(Class theClass) {
	super(theClass);
}

/**
 * ControllerTestSuite constructor comment.
 * @param name java.lang.String
 */
public JDBCMapperTestSuite(String name) {
	super(name);
}

static public TestSuite suite() {
	TestSuite suite = new TestSuite();
	suite.addTest(new TestSuite(ProjectMapperTest.class));
	suite.addTest(new TestSuite(EmployeeMapperTest.class));
	suite.addTest(new TestSuite(TimeSheetEntryMapperTest.class));
	suite.addTest(new TestSuite(TimeSheetMapperTest.class));
	return suite;
}
}
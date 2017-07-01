package com.wsbook.casestudy.test;

import junit.htmlui.TestServletBase;

public class TestServlet extends TestServletBase {

	/**
	 * Constructor for TestServlet
	 */
	public TestServlet() {
		super();
	}

	/**
	 * @see TestServletBase#getDynamicClassLoader()
	 */
	protected ClassLoader getDynamicClassLoader() {
		return this.getClass().getClassLoader();
	}

}


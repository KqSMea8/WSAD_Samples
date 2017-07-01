package com.wsbook.acme;

import com.wsbook.mapping.MappingException;

/**
 * @author jamsden
 *
 * To change this generated comment edit the template variable "typecomment":
 * Window>Preferences>Java>Templates.
 * To enable and disable the creation of type comments go to
 * Window>Preferences>Java>Code Generation.
 */
public class Personnel extends Department {
	
	private String code;
	
	/**
	 * Constructor for Personnel.
	 */
	public Personnel() {
		super();
	}

	/**
	 * Constructor for Personnel.
	 * @param id
	 */
	public Personnel(int id) throws MappingException {
		super(id);
	}
	
	

	/**
	 * Returns the code.
	 * @return String
	 */
	public String getCode() {
		return code;
	}

	/**
	 * Sets the code.
	 * @param code The code to set
	 */
	public void setCode(String code) throws MappingException {
		this.code = code;
		markUpdated();
	}

}

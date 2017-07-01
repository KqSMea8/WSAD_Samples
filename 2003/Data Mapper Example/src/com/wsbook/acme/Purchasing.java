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
public class Purchasing extends Department {

	private float externalBudget;
	/**
	 * Constructor for Purchasing.
	 */
	public Purchasing() {
		super();
	}

	/**
	 * Constructor for Purchasing.
	 * @param id
	 */
	public Purchasing(int id) throws MappingException {
		super(id);
	}

	/**
	 * Returns the externalBudget.
	 * @return float
	 */
	public float getExternalBudget() {
		return externalBudget;
	}

	/**
	 * Sets the externalBudget.
	 * @param externalBudget The externalBudget to set
	 */
	public void setExternalBudget(float externalBudget) throws MappingException {
		this.externalBudget = externalBudget;
		markUpdated();
	}

}

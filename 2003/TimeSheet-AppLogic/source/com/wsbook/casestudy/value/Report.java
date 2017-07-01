package com.wsbook.casestudy.value;

import java.io.Serializable;

public class Report implements Serializable {
	private ReportCollection[] collections;
	

	/**
	 * Gets the collections
	 * @return Returns a ReportCollection[]
	 */
	public ReportCollection[] getCollections() {
		return collections;
	}
	/**
	 * Sets the collections
	 * @param collections The collections to set
	 */
	public void setCollections(ReportCollection[] collections) {
		this.collections = collections;
	}

}


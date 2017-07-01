package com.wsbook.casestudy.value;

import java.io.Serializable;

public class ReportCollection implements Serializable {
	private String category;
	private double totalHours;
	private ReportRecord[] records;
	
	public ReportCollection() { super(); }
	public ReportCollection(String category, double totalHours, ReportRecord[] records) {
		super();
		this.category = category;
		this.totalHours = totalHours;
		this.records = records;
	}

	/**
	 * Gets the category
	 * @return Returns a String
	 */
	public String getCategory() {
		return category;
	}
	/**
	 * Sets the category
	 * @param category The category to set
	 */
	public void setCategory(String category) {
		this.category = category;
	}

	/**
	 * Gets the totalHours
	 * @return Returns a double
	 */
	public double getTotalHours() {
		return totalHours;
	}
	/**
	 * Sets the totalHours
	 * @param totalHours The totalHours to set
	 */
	public void setTotalHours(double totalHours) {
		this.totalHours = totalHours;
	}

	/**
	 * Gets the records
	 * @return Returns a ReportRecord[]
	 */
	public ReportRecord[] getRecords() {
		return records;
	}
	/**
	 * Sets the records
	 * @param records The records to set
	 */
	public void setRecords(ReportRecord[] records) {
		this.records = records;
	}

}


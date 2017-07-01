package com.wsbook.casestudy.value;

import java.io.Serializable;

public class ReportRecord implements Serializable {
	private String label;
	private double hours;
	
	public ReportRecord() { super(); }
	
	public ReportRecord(String label, double hours) {
		super();
		this.label = label;
		this.hours = hours;
	}
	/**
	 * Gets the label
	 * @return Returns a String
	 */
	public String getLabel() {
		return label;
	}
	/**
	 * Sets the label
	 * @param label The label to set
	 */
	public void setLabel(String label) {
		this.label = label;
	}

	/**
	 * Gets the hours
	 * @return Returns a double
	 */
	public double getHours() {
		return hours;
	}
	/**
	 * Sets the hours
	 * @param hours The hours to set
	 */
	public void setHours(double hours) {
		this.hours = hours;
	}

}


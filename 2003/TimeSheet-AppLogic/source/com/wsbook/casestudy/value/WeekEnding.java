package com.wsbook.casestudy.value;

import java.util.Calendar;

import com.wsbook.casestudy.util.Formatter;

public class WeekEnding implements java.io.Serializable {
	private Calendar date;
	private Formatter formatter;

	public WeekEnding() {
	}
	public WeekEnding(Calendar cal) {
		date = cal;
	}
	public WeekEnding(Calendar cal, Formatter format) {
		date = cal;
		formatter = format;
	}

	/**
	 * Gets the date
	 * @return Returns a Calendar
	 */
	public Calendar getDate() {
		return date;
	}

	public String getFormattedDate() {
		if (formatter == null)
			return Formatter.dateFormat(date);
		else
			return formatter.format(date);
	}
	
	public String getIdString() {
		Formatter defaultFormatter = Formatter.getDefaultFormatter();
		return defaultFormatter.format(date);
	}
		
	/**
	 * Sets the date
	 * @param date The date to set
	 */
	public void setDate(Calendar date) {
		this.date = date;
	}

	/**
	 * Gets the formatter
	 * @return Returns a Formatter
	 */
	public Formatter getFormatter() {
		return formatter;
	}
	/**
	 * Sets the formatter
	 * @param formatter The formatter to set
	 */
	public void setFormatter(Formatter formatter) {
		this.formatter = formatter;
	}

}
package com.wsbook.casestudy.tags;

import java.io.IOException;
import java.util.Calendar;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;

import com.wsbook.casestudy.util.Formatter;
/** 
 *  Handler for a JSP Custom Tag
 *  It is used to display a date (calendar attribute), using the current
 *  Format (represented by a Formatter object stored in the HttpSession).
 * 
 *  It has two required Attributes, <i>formatId</i> and <i>calendar</i>
 *  formatId is assumed to be the key of a Formatter object stored on the session
 *  calendar is the date to be formatted by the Formatter object.
 * 
 *  Results in a single date String being placed on the current output stream.
 */
public class FormatDate extends TagSupport {

	/** the URI of the file */
	private String formatId;
	private Calendar calendar;

	/**
	 * Performs the processing of this tag.
	 */
	public int doStartTag() throws JspException {
		String dateString = null;

		// locate the formatter
		Formatter formatter = (Formatter)pageContext.getSession().getAttribute(formatId);
		
		if (formatter == null)
			formatter = Formatter.getDefaultFormatter();

		if (calendar != null) {
			dateString = formatter.format(calendar);
		// ... and write it
		try {
			pageContext.getOut().write(dateString);
		} catch (IOException ioe) {
			throw new JspException(ioe.getMessage());
		}
		}
		return EVAL_BODY_INCLUDE;
	}

	/**
	 * Sets the calendar
	 * @param calendar The calendar to set
	 */
	public void setCalendar(Calendar calendar) {
		this.calendar = calendar;
	}

	/**
	 * Sets the formatId
	 * @param formatId The formatId to set
	 */
	public void setFormatId(String formatId) {
		this.formatId = formatId;
	}

}


package com.wsbook.casestudy.domain;

import java.util.*;
/**
 * This defines the abstract superclass of all filters.
 */
public abstract class Filter extends TsObject {
	/**
	 * Filter constructor.
	 */
	public Filter() {
		super();
	}
	/**
	 * Enumerate over time sheets and 
	 * apply concrete class match() method. 
	 * Successfully matched timesheets are returned in a
	 * Vector.
	 */
	public ArrayList apply(ListIterator iterator) {
		ArrayList answer = new ArrayList();
		while (iterator.hasNext()) {
			TimeSheet aTimeSheet = (TimeSheet) iterator.next();
			if (match(aTimeSheet)) {
				answer.add(aTimeSheet);
			}
		}
		return answer;
	}
	/**
	 * Concrete implementations will implement matching 
	 * logic against TimeSheet passed in as an argument.
	 * If a match occurs, return true. 
	 */
	public abstract boolean match(TimeSheet aTimeSheet);
}
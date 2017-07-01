package com.wsbook.casestudy.domain;

import java.util.*;
/**
 * This class filters TimeSheets by Project.
 */
public class ProjectFilter extends Filter {
	Project project = null;
	/**
	 * ProjectFilter constructor.
	 */
	public ProjectFilter(Project aProject) {
		super();
		project = aProject;
	}
	/**
	 * Return true if one of the supplied Timesheet entries project matches 
	 * filter project.
	 */
	public boolean match(TimeSheet aTimeSheet) {
		ArrayList entries = aTimeSheet.getEntries();
		for (int i = 0; i < entries.size(); i++) {
			TimeSheetEntry anEntry = (TimeSheetEntry) entries.get(i);
			if (project.getNumber().equalsIgnoreCase(anEntry.getProject().getNumber())) {
				return true;
			}
		}
		return false;
	}
}
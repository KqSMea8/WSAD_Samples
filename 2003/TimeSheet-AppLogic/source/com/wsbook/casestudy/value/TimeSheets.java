package com.wsbook.casestudy.value;

import java.io.Serializable;
import java.util.ArrayList;

import com.wsbook.casestudy.domain.TimeSheet;

public class TimeSheets implements Serializable {
	private ArrayList timeSheets = null;

	public TimeSheets() {
	}

	public TimeSheets(ArrayList sheets) {
		timeSheets = sheets;
	}

	public TimeSheet[] getTimeSheet() {
		if (timeSheets == null) return null;
		int numToCopy = timeSheets.size();
		TimeSheet[] sheets = new TimeSheet[numToCopy];
		for (int i = 0; i < numToCopy; i++) {
			sheets[i] = (TimeSheet) timeSheets.get(i);
		}
		return sheets;
	}

	public TimeSheet getTimeSheet(int index) {
		if (timeSheets == null) return null;
		return (TimeSheet) timeSheets.get(index);
	}

}
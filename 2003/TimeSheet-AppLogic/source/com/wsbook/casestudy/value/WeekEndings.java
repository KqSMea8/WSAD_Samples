package com.wsbook.casestudy.value;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.ListIterator;

import com.wsbook.casestudy.util.Formatter;

public class WeekEndings implements Serializable {
	
	private ArrayList weekEndings = null;
	
	public WeekEndings() {}
	
	public WeekEndings(ArrayList calendars) {
		ListIterator iter = calendars.listIterator();
		weekEndings = new ArrayList(calendars.size());
		while(iter.hasNext()) {
			weekEndings.add(new WeekEnding((Calendar)iter.next()));
		}
	}
	
	
	public WeekEnding[] getWeekEnding() {
		if (weekEndings == null) return null;
		int numToCopy = weekEndings.size();
		WeekEnding[] endings = new WeekEnding[numToCopy];
		for (int i = 0; i < numToCopy; i++) {
			endings[i] = (WeekEnding) weekEndings.get(i);
		}
		return endings;
	}
		
	
	public WeekEnding getWeekEnding(int index) {
		return (WeekEnding)weekEndings.get(index);
	}
	
	
}


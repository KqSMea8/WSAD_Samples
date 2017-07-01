package com.wsbook.casestudy.mapping.memory;

import java.util.ArrayList;
import java.util.ListIterator;

import com.wsbook.casestudy.domain.TimeSheet;
import com.wsbook.casestudy.domain.TimeSheetEntry;
import com.wsbook.casestudy.domain.TsObject;
import com.wsbook.casestudy.exception.NoSuchTimeSheetException;
import com.wsbook.casestudy.mapping.MapperFactory;

public class TimeSheetEntryMapper
	extends ObjectMapper
	implements com.wsbook.casestudy.mapping.TimeSheetEntryMapper {

	protected transient TimeSheetMapper tsMapper = null;

	/**
	 * Constructor for TimeSheetEntryMapper
	 */
	public TimeSheetEntryMapper() {
		super();
	}

	/**
	 * @see ObjectMapper#initialLoad()
	 */
	ArrayList initialLoad() {
		return null;
	}

	protected TimeSheetMapper getTimeSheetMapper() {
		if (tsMapper == null) {
			tsMapper =
				(TimeSheetMapper) MapperFactory.getSystemMapperFactory().getMapper(
					TimeSheet.class);
		}
		return tsMapper;
	}

	/**
	 * @see ObjectMapper#getCache()
	 */
	protected ArrayList getCache() {
		return null;
	}

	/**
	 * Return a ArrayList of all Domain objects of the type created by this factory.
	 * Creation date: (3/19/00 7:59:51 PM)
	 * @return java.util.ArrayList
	 */
	public ArrayList findAll()  {
		ArrayList byTimeSheet = getTimeSheetMapper().findAll();
		ArrayList list = new ArrayList();
		ListIterator iter = byTimeSheet.listIterator();
		while (iter.hasNext()) {
			TimeSheet ts = (TimeSheet)iter.next();
			TimeSheetEntry[] entries = ts.getEntry();
			for (int i=0; i<entries.length; i++) {
				list.add(entries[i]);
			}
		}
		return list;
	}
	
	public TsObject findByPrimaryKey(TsObject input) {
		TimeSheetEntry match = (TimeSheetEntry) input;
		ArrayList list = findAll();
		ListIterator iter = list.listIterator();
		while (iter.hasNext()) {
			TimeSheetEntry entry = (TimeSheetEntry) iter.next();
			if (entry.getTimeSheetEntryID() == match.getTimeSheetEntryID())
				return entry;
		}
		return null;
		
	}
	
	public TimeSheet removeByKey(int timesheetId, int entryId)
		throws NoSuchTimeSheetException {
		TimeSheet key = new TimeSheet();
		key.setTimesheetID(timesheetId);
		TimeSheet ts = (TimeSheet) getTimeSheetMapper().findByPrimaryKey(key);
		if (ts != null) {
			ListIterator iter = ts.getEntries().listIterator();
			while (iter.hasNext()) {
				TimeSheetEntry entry = (TimeSheetEntry) iter.next();
				if (entry.getTimeSheetEntryID() == entryId) {
					iter.remove();
					break;
				}
			}
			return ts;
		} else {
			throw new NoSuchTimeSheetException("No timesheet found");
		}
	}

	public TimeSheet addEntry(int timesheetId, TimeSheetEntry entry)
		throws NoSuchTimeSheetException {
		TimeSheet key = new TimeSheet();
		key.setTimesheetID(timesheetId);
		TimeSheet ts = (TimeSheet) getTimeSheetMapper().findByPrimaryKey(key);
		if (ts == null)
			throw new NoSuchTimeSheetException();
		
		// Fill in the persistent id and back link
		entry.setTimeSheet(ts);
		entry.setTimeSheetEntryID(getTimeSheetMapper().generateEntryId());
		
		// update the collection
		ts.getEntries().add(entry);
		
		return ts;
	}
	
	public void clearCache() {
		// do nothing -- your cache is held by the TimeSheetMapper
	}

}
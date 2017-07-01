package com.wsbook.casestudy.mapping.memory;

import java.util.*;
import java.text.*;
import com.wsbook.casestudy.domain.*;
import com.wsbook.casestudy.exception.NoSuchTimeSheetException;
import com.wsbook.casestudy.system.AppService;
import com.wsbook.casestudy.system.TraceCapable;
/**
 * This represents the default "in-memory" collection of TimeSheets.
 *
 * Creation date: (2/3/00 5:25:18 PM)
 * @author: Administrator
 */
public class TimeSheetMapper
	extends ObjectMapper
	implements com.wsbook.casestudy.mapping.TimeSheetMapper {
	protected static ArrayList cache = null;
	protected static int timeSheetId = 0;
	protected static int entryId = 0;
	
	public synchronized int generateTimeSheetId() {
		return timeSheetId++;
	}
	
	public synchronized int generateEntryId() {
		return entryId++;
	}

	protected ArrayList getCache() {
		if (cache == null) {
			cache = initialLoad();
		}
		return cache;
	}
	/**
	 * DepartmentMapper constructor comment.
	 */
	public TimeSheetMapper() {
		super();
	}
	
	public TimeSheet addEntry(int id, TimeSheetEntry entry) throws NoSuchTimeSheetException {
		TimeSheetEntryMapper mapper = new TimeSheetEntryMapper();
		return mapper.addEntry(id, entry);
		
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (2/29/00 12:26:22 PM)
	 * Test: Administrator
	 * @return java.util.Calendar
	 */
	private Calendar getCalendar() {
		SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
		Calendar cal = Calendar.getInstance();
		try {
			cal.setTime(formatter.parse("12/15/2001"));
		} catch (ParseException e) {
		};
		return cal;
	}
	/**
	 * Create and return a ArrayList of Department Objects.
	 * 
	 */
	ArrayList initialLoad() {
		
				
		ArrayList v = new ArrayList();
		
		try {
		Employee e = (Employee) new Employee().getMapper().findAll().get(0);
		TimeSheet t = new TimeSheet();
		t.setEmployee(e);
		t.setWeekend(getCalendar());
		t.setTimesheetID(generateTimeSheetId());

		// Create pending time sheet entries for a project and employee
		Project p = (Project) new Project().getMapper().findAll().get(0);
		TimeSheetEntry entry = new TimeSheetEntry();
		Calendar c = getCalendar();
		c.add(Calendar.DATE, -5);
		entry.setDate(c);
		entry.setHours(8.00);
		entry.setProject(p);
		entry.setTimeSheet(t);
		entry.setTimeSheetEntryID(generateEntryId());
		// add entry to timesheet
		t.getEntries().add(entry);
		
		c = getCalendar();
		c.add(Calendar.DATE, -4);
		entry = new TimeSheetEntry();
		entry.setDate(c);
		entry.setHours(8.00);
		entry.setProject(p);
		entry.setTimeSheet(t);
		entry.setTimeSheetEntryID(generateEntryId());
		// add entry to timesheet
		t.getEntries().add(entry);
		c = getCalendar();
		c.add(Calendar.DATE, -3);
		entry = new TimeSheetEntry();
		entry.setDate(c);
		entry.setHours(8.00);
		entry.setProject(p);
		entry.setTimeSheet(t);
		entry.setTimeSheetEntryID(generateEntryId());
		// add entry to timesheet
		t.getEntries().add(entry);
		c = getCalendar();
		c.add(Calendar.DATE, -2);
		entry = new TimeSheetEntry();
		entry.setDate(c);
		entry.setHours(8.00);
		entry.setProject(p);
		entry.setTimeSheet(t);
		entry.setTimeSheetEntryID(generateEntryId());
		// add entry to timesheet
		t.getEntries().add(entry);
		c = getCalendar();
		c.add(Calendar.DATE, -1);
		entry = new TimeSheetEntry();
		entry.setDate(c);
		entry.setHours(8.00);
		entry.setProject(p);
		entry.setTimeSheet(t);
		entry.setTimeSheetEntryID(generateEntryId());
		// add entry to timesheet
		t.getEntries().add(entry);
		v.add(t); // add timesheet...

		// Create another pending TimeSheet

		t = new TimeSheet();
		e = (Employee) new Employee().getMapper().findAll().get(1);
		t.setEmployee(e);
		t.setWeekend(getCalendar());
		t.setTimesheetID(generateTimeSheetId());

		// Create Another time sheet entries for a project
		p = (Project) new Project().getMapper().findAll().get(1);
		entry = new TimeSheetEntry();
		c = getCalendar();
		c.add(Calendar.DATE, -5);
		entry.setDate(c);
		entry.setHours(10.50);
		entry.setProject(p);
		entry.setTimeSheet(t);
		entry.setTimeSheetEntryID(generateEntryId());
		// add entry to timesheet
		t.getEntries().add(entry);
		c = getCalendar();
		c.add(Calendar.DATE, -4);
		entry = new TimeSheetEntry();
		entry.setDate(c);
		entry.setHours(8.00);
		entry.setProject(p);
		entry.setTimeSheet(t);
		entry.setTimeSheetEntryID(generateEntryId());
		// add entry to timesheet
		t.getEntries().add(entry);
		c = getCalendar();
		c.add(Calendar.DATE, -3);
		entry = new TimeSheetEntry();
		entry.setDate(c);
		entry.setHours(9.00);
		entry.setProject(p);
		entry.setTimeSheet(t);
		entry.setTimeSheetEntryID(generateEntryId());
		// add entry to timesheet
		t.getEntries().add(entry);
		c = getCalendar();
		c.add(Calendar.DATE, -2);
		entry = new TimeSheetEntry();
		entry.setDate(c);
		entry.setHours(8.00);
		entry.setProject(p);
		entry.setTimeSheet(t);
		entry.setTimeSheetEntryID(generateEntryId());
		// add entry to timesheet
		t.getEntries().add(entry);
		c = getCalendar();
		c.add(Calendar.DATE, -1);
		entry = new TimeSheetEntry();
		entry.setDate(c);
		entry.setHours(8.00);
		entry.setProject(p);
		entry.setTimeSheet(t);
		entry.setTimeSheetEntryID(generateEntryId());
		// add entry to timesheet
		t.getEntries().add(entry);
		v.add(t); // add timesheet...

		// Create APPROVED Timesheets

		t = new TimeSheet();
		t.approve();
		t.setEmployee(e);
		t.setWeekend(getCalendar());
		t.setTimesheetID(generateTimeSheetId());

		// Create approved time sheet entries for a project and employee
		p = (Project) new Project().getMapper().findAll().get(0);
		entry = new TimeSheetEntry();
		c = getCalendar();
		c.add(Calendar.DATE, -5);
		entry.setDate(c);
		entry.setHours(8.00);
		entry.setProject(p);
		entry.setTimeSheet(t);
		entry.setTimeSheetEntryID(generateEntryId());
		// add entry to timesheet
		t.getEntries().add(entry);
		c = getCalendar();
		c.add(Calendar.DATE, -4);
		entry = new TimeSheetEntry();
		entry.setDate(c);
		entry.setHours(8.00);
		entry.setProject(p);
		entry.setTimeSheet(t);
		entry.setTimeSheetEntryID(generateEntryId());
		// add entry to timesheet
		t.getEntries().add(entry);
		c = getCalendar();
		c.add(Calendar.DATE, -3);
		entry = new TimeSheetEntry();
		entry.setDate(c);
		entry.setHours(8.00);
		entry.setProject(p);
		entry.setTimeSheet(t);
		entry.setTimeSheetEntryID(generateEntryId());
		// add entry to timesheet
		t.getEntries().add(entry);
		c = getCalendar();
		c.add(Calendar.DATE, -2);
		entry = new TimeSheetEntry();
		entry.setDate(c);
		entry.setHours(8.00);
		entry.setProject(p);
		entry.setTimeSheet(t);
		entry.setTimeSheetEntryID(generateEntryId());
		// add entry to timesheet
		t.getEntries().add(entry);
		c = getCalendar();
		c.add(Calendar.DATE, -1);
		entry = new TimeSheetEntry();
		entry.setDate(c);
		entry.setHours(8.00);
		entry.setProject(p);
		entry.setTimeSheet(t);
		entry.setTimeSheetEntryID(generateEntryId());
		// add entry to timesheet
		t.getEntries().add(entry);
		v.add(t); // add timesheet...
		
		} catch (Exception e) {
			AppService.log(TraceCapable.ERROR_LEVEL,"Exception caught in initialLoad " + e);
		}
		return v;
	}

	public ArrayList findForEmployee(String empId) {
		EmployeeFilter filter = new EmployeeFilter(new Employee(empId));
		return filter.apply(getCache().listIterator());
	}

	public ArrayList findPendingForEmployee(String empId) {
		ArrayList allSheets = findForEmployee(empId);
		// remove Approved timesheets
		ListIterator iterator = allSheets.listIterator();
		while (iterator.hasNext()) {
			TimeSheet currentTS = (TimeSheet) iterator.next();
			if (currentTS.isApproved())
				iterator.remove();
		}
		return allSheets;
	}

	public ArrayList findApprovedForEmployee(String empId) {
		ArrayList allSheets = findForEmployee(empId);
		// remove Pending timesheets
		ListIterator iterator = allSheets.listIterator();
		while (iterator.hasNext()) {
			TimeSheet currentTS = (TimeSheet) iterator.next();
			if (currentTS.isPending())
				iterator.remove();
		}
		return allSheets;
	}

	public ArrayList findAllPending() {
		ArrayList allSheets = findAll();
		// remove Approved timesheets
		ListIterator iterator = allSheets.listIterator();
		while (iterator.hasNext()) {
			TimeSheet currentTS = (TimeSheet) iterator.next();
			if (currentTS.isApproved())
				iterator.remove();
		}
		return allSheets;
	}

	public ArrayList findAllApproved() {
		ArrayList allSheets = findAll();
		// remove Pending timesheets
		ListIterator iterator = allSheets.listIterator();
		while (iterator.hasNext()) {
			TimeSheet currentTS = (TimeSheet) iterator.next();
			if (currentTS.isPending())
				iterator.remove();
		}
		return allSheets;
	}

	public TsObject findByPrimaryKey(TsObject key) throws NoSuchTimeSheetException{
		TimeSheet keySheet = (TimeSheet) key;
		int id = keySheet.getTimesheetID();
		// now iterate and look for match on date
		ListIterator iter = getCache().listIterator();
		while (iter.hasNext()) {
			TimeSheet currentSheet = (TimeSheet) iter.next();
			if (currentSheet.getTimesheetID() == id)
				return currentSheet;
		}
		throw new NoSuchTimeSheetException("No timesheet matching found");
	}

	public TimeSheet findByKey(String empId, String weekEnding) throws NoSuchTimeSheetException {
		ArrayList employeeSheets = findForEmployee(empId);
		// now iterate and look for match on date
		ListIterator iter = employeeSheets.listIterator();
		while (iter.hasNext()) {
			TimeSheet currentSheet = (TimeSheet) iter.next();
			if (currentSheet.getFormattedWeekend().equals(weekEnding))
				return currentSheet;
		}
		throw new NoSuchTimeSheetException("No matching timesheet found");

	}
	
	public void clearCache() {
		cache = new ArrayList();
	}
}
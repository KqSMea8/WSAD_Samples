package com.wsbook.casestudy.mapping.ejb;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.ListIterator;

import javax.ejb.EJBLocalObject;
import javax.ejb.EJBObject;
import javax.ejb.FinderException;
import javax.ejb.RemoveException;
import javax.rmi.PortableRemoteObject;

import com.wsbook.casestudy.domain.Employee;
import com.wsbook.casestudy.domain.Project;
import com.wsbook.casestudy.domain.TimeSheet;
import com.wsbook.casestudy.domain.TimeSheetEntry;
import com.wsbook.casestudy.domain.TimeSheetState;
import com.wsbook.casestudy.domain.TsObject;
import com.wsbook.casestudy.ejb.EmployeeEJB;
import com.wsbook.casestudy.ejb.ProjectEJB;
import com.wsbook.casestudy.ejb.TimeSheetEJB;
import com.wsbook.casestudy.ejb.TimeSheetEJBHome;
import com.wsbook.casestudy.ejb.TimeSheetEJBKey;
import com.wsbook.casestudy.ejb.TimeSheetEntryEJB;
import com.wsbook.casestudy.exception.MappingException;
import com.wsbook.casestudy.system.AppService;
import com.wsbook.casestudy.system.TraceCapable;
import com.wsbook.casestudy.util.Formatter;
/**
 * This class creates/reads/updates Timesheets.  It uses an EmployeeFactory and a TimesheetEntryFactory
 *
 * Creation date: (2/26/00 3:48:17 PM)
 * @author: Administrator
 */
public class TimeSheetMapper extends DomainEJBMapper implements com.wsbook.casestudy.mapping.TimeSheetMapper {
	TimeSheetEJBHome timesheetHome;
	EmployeeMapper employeeMapper = new EmployeeMapper();
	TimeSheetEntryMapper entryMapper = new TimeSheetEntryMapper();
	ProjectMapper projectMapper = new ProjectMapper();
	/**
	 * TimeSheetMapper constructor.
	 */
	public TimeSheetMapper() {
		super();
		createInitialContext();
		createTimeSheetHome();
	}
	/**
	 * This method creates a new TimeSheet EJB from the supplied TimeSheet domain object
	 * Creation date: (2/27/00 2:44:43 PM)
	 * @param timesheet com.wsbook.casestudy.domain.TimeSheet
	 */
	public void insert(TsObject obj) throws MappingException {
		int timeSheetId = 0;
		TimeSheet timesheet = (TimeSheet)obj;
		try {
			TimeSheetEJB timeSheetEJB = null;
			Employee emp = timesheet.getEmployee();
			EmployeeEJB submitter = (EmployeeEJB) employeeMapper.findEJBObjectMatching(emp);
			String state = timesheet.getState().getStatename();
			String weekend = timesheet.getFormattedWeekend();
			timeSheetEJB = timesheetHome.create(weekend,state,submitter);

				// Now cycle through the TimeSheetEntries
			ListIterator enum = timesheet.getEntries().listIterator();
			while (enum.hasNext()) {
				TimeSheetEntry entry = (TimeSheetEntry) enum.next();
				entryMapper.addEntry(entry, timeSheetEJB);
			}
			Employee approver = timesheet.getApprovedBy();
			if (approver != null) {
				EmployeeEJB approverEjb = (EmployeeEJB) employeeMapper.findEJBObjectMatching(approver);
				timeSheetEJB.setApprover(approverEjb);
			}
		} catch (Exception e) {
			AppService.log(TraceCapable.ERROR_LEVEL,"Exception " + e + " caught in insert()");
			throw new MappingException(e, ("Wrapped Exception " + e + " caught in TimeSheetMapper.insert()"));
		}
	}
	/**
	 * This method retrieves an instance of EmployeeEJBHome from the JNDI initial context.
	 * Creation date: (2/19/00 3:02:08 PM)
	 */
	protected void createTimeSheetHome() {
		try {
			timesheetHome = (TimeSheetEJBHome) initContext.lookup("java:comp/env/ejb/TimeSheetEJB");
		} catch (Exception e) { // Error getting the home interface
			AppService.log(TraceCapable.ERROR_LEVEL,"Exception " + e + " in createTimeSheetHome()");
		}
	}
	/**
	 * This method retrieves all EJB's of this type
	 * Creation date: (2/19/00 3:02:08 PM)
	 */
	protected Collection findAllEJBs() throws MappingException {
		try {
			return timesheetHome.findAll();
		} catch (Exception e) {
			AppService.log(TraceCapable.ERROR_LEVEL,"Exception " + e + " in createTimeSheetHome()");
			throw new MappingException(e, "Wrapped exception caught in findAllEJBs ");
		}
	}
	/**
	 * This method retrieves back the EJBObject matching this domain object
	 * Creation date: (2/27/00 2:44:43 PM)
	 * @param timesheet com.wsbook.casestudy.domain.TimeSheet
	 */
	protected EJBLocalObject findEJBObjectMatching(TsObject domainObject) throws MappingException {
		TimeSheetEJB ejb = null;
		try {
			TimeSheet timesheet = (TimeSheet) domainObject;
			int timeSheetId = timesheet.getTimesheetID();
			ejb = timesheetHome.findByPrimaryKey(new TimeSheetEJBKey(timeSheetId));
		} catch (Exception e) {
			AppService.log(TraceCapable.ERROR_LEVEL,"Exception " + e + " caught in findEJBObjectMatching()");
			throw new MappingException(e, ("Wrapped Exception " + e + " caught in findEJBObjectMatching()"));
		}
		return ejb;
	}
	/**
	 * Return the EmployeeMapper
	 * Creation date: (2/26/00 4:01:06 PM)
	 * @return com.wsbook.casestudy.mapping.ejb.EmployeeFactory
	 */
	public EmployeeMapper getEmployeeMapper() {
		return employeeMapper;
	}
	/**
	 * Return the TimesheetEntryMapper
	 * Creation date: (2/26/00 4:28:04 PM)
	 * @return com.wsbook.casestudy.mapping.ejb.TimeSheetEntryFactory
	 */
	public TimeSheetEntryMapper getEntryMapper() {
		return entryMapper;
	}
	/**
	 * Return the domain object this EJB object maps to.
	 * Creation date: (2/26/00 3:53:49 PM)
	 * @return com.wsbook.casestudy.domain.TimeSheet
	 * @param ejb com.wsbook.casestudy.ejb.TimeSheetEJB
	 */
	public TsObject map(EJBLocalObject input) throws MappingException {
		TimeSheetEJB ejb;
		TimeSheet timeSheet;
		try {
			ejb = (TimeSheetEJB) input;
		} catch (ClassCastException e) {
			throw new MappingException(e, "Attempt to map a non TimeSheetEJB in TimeSheetMapper");
		}
		try {
			timeSheet = new TimeSheet();
			shallowMap(timeSheet, ejb);
			Iterator entries = ejb.getEntries().iterator();
			TimeSheetEntryEJB entryEJB;
			ArrayList newEntries = new ArrayList();
			while (entries.hasNext()) {
				entryEJB = (TimeSheetEntryEJB) entries.next();
				TimeSheetEntry entry = (TimeSheetEntry)getEntryMapper().map(entryEJB);
				entry.setTimeSheet(timeSheet);
				newEntries.add(entry);
			}
			timeSheet.setEntries(newEntries);
		} catch (Exception e) {
			AppService.log(TraceCapable.ERROR_LEVEL,"Exception " + e + " caught in TimeSheetMapper.map()");
			throw new MappingException(e, "Wrapped Exception caught in TimeSheetMapper.map()");
		}
		return timeSheet;
	}
	
	private void shallowMap(TimeSheet timeSheet, TimeSheetEJB ejb) throws java.rmi.RemoteException, javax.ejb.FinderException, MappingException {
		timeSheet.setTimesheetID(((TimeSheetEJBKey) ejb.getPrimaryKey()).timeSheetId);
		EmployeeEJB employee = ejb.getApprover();
		if (employee != null) {
			Employee approver = (Employee) getEmployeeMapper().map(employee);
			timeSheet.setApprovedBy(approver);
		}
		employee = ejb.getSubmitter();
		if (employee != null) {
			Employee submitter = (Employee) getEmployeeMapper().map(ejb.getSubmitter());
			timeSheet.setEmployee(submitter);
		}
		timeSheet.setWeekendFromFormattedString(ejb.getWeekend());
		String stateName = ejb.getState();
		TimeSheetState state = null;
		if (stateName.equals("APPROVED"))
			state = TimeSheetState.getApprovedState();
		else
			state = TimeSheetState.getPendingState();
		timeSheet.setState(state);
	}
	/**
	 * This method updates the EJB's that are related to the TimeSheet passed in.
	 * Creation date: (2/27/00 2:44:43 PM)
	 * @param timesheet com.wsbook.casestudy.domain.TimeSheet
	 */
	public void update(TsObject object) throws MappingException {

		try {
			TimeSheet timesheet = (TimeSheet) object;
			int timeSheetId = timesheet.getTimesheetID();
			TimeSheetEJBKey newKey = new TimeSheetEJBKey(timeSheetId);
			TimeSheetEJB ejb = timesheetHome.findByPrimaryKey(newKey);

			String stateName = timesheet.getState().getStatename();
			ejb.setState(stateName);

			// This date code updates the ejb's weekend field with a String
			Calendar calendar = timesheet.getWeekend();
			ejb.setWeekend(Formatter.dateFormat(calendar));

			// Next handle the submitter and approver
			EmployeeEJB submitter = (EmployeeEJB) employeeMapper.findEJBObjectMatching(timesheet.getEmployee());
			ejb.setSubmitter(submitter);

			EmployeeEJB approver = (EmployeeEJB) employeeMapper.findEJBObjectMatching(timesheet.getApprovedBy());
			ejb.setApprover(approver);

			// adding and removing entries should be explicit -- as well as changing info.
			// This is a shallow update!
		} catch (Exception e) {
			AppService.log(TraceCapable.ERROR_LEVEL,"Exception " + e + " caught in update()");
			throw new MappingException(e, ("Wrapped Exception " + e + " caught in update()"));
		}
	}

	/* This code must be modified -- it is copied from the in-memory mapper
	*/
	public ArrayList findForEmployee(String empId) throws MappingException {
		Collection selectedTS = null;
		try {
			selectedTS = timesheetHome.findTimesheetsBySubmitter(empId);
		} catch (FinderException fe) {
			throw new MappingException(fe, ("Wrapped Exception " + fe + " caught in findForEmployee()"));
		}

		ArrayList list = new ArrayList();
		Iterator it = selectedTS.iterator();
		EJBLocalObject local;
		while (it.hasNext()) {
			local = (EJBLocalObject) it.next();
			Object mapped = map(local);
			list.add(mapped);
		}
		return list;

	}

	public ArrayList findPendingForEmployee(String empId) throws MappingException {
		Collection selectedTS = null;
		try {
			selectedTS = timesheetHome.findPendingByEmployee(empId);
		} catch (FinderException fe) {
			throw new MappingException(fe, "Wrapped Exception caught in findForEmployee()");
		}

		ArrayList list = new ArrayList();
		Iterator it = selectedTS.iterator();
		EJBLocalObject local;
		while (it.hasNext()) {
			local = (EJBLocalObject) it.next();
			Object mapped = map(local);
			list.add(mapped);
		}
		return list;
	}

	public ArrayList findApprovedForEmployee(String empId) throws MappingException {
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

	public ArrayList findAllPending() throws MappingException {
		ArrayList allSheets = findAll();
		// remove Approved timesheets
		if (allSheets != null) {
			ListIterator iterator = allSheets.listIterator();
			while (iterator.hasNext()) {
				TimeSheet currentTS = (TimeSheet) iterator.next();
				if (currentTS.isApproved())
					iterator.remove();
			}
		}
		return allSheets;
	}

	public ArrayList findAllApproved() throws MappingException {
		ArrayList allSheets = findAll();
		// remove Pending timesheets
		if (allSheets != null) {
			ListIterator iterator = allSheets.listIterator();
			while (iterator.hasNext()) {
				TimeSheet currentTS = (TimeSheet) iterator.next();
				if (currentTS.isPending())
					iterator.remove();
			}
		}
		return allSheets;
	}

	public TsObject findByPrimaryKey(TsObject key) throws MappingException {
		EJBLocalObject ejb = findEJBObjectMatching(key);
		if (ejb != null)
			return (TsObject) map(ejb);
		else
			return null;
	}

	public TimeSheet findByKey(String empId, String weekEnding) throws MappingException {
		ArrayList employeeSheets = findForEmployee(empId);
		// now iterate and look for match on date
		ListIterator iter = employeeSheets.listIterator();
		while (iter.hasNext()) {
			TimeSheet currentSheet = (TimeSheet) iter.next();
			String comparison = currentSheet.getFormattedWeekend();
			if (comparison.equals(weekEnding))
				return currentSheet;
		}
		return null;

	}

	public TimeSheet addEntry(int tsId, TimeSheetEntry entry) throws MappingException {
		TimeSheetEJB ejb = (TimeSheetEJB) findEJBObjectMatching(new TimeSheet(tsId));
		if (ejb == null) {
			throw new MappingException("No TimeSheet with id = " + tsId);
		}
		// create new Entry
		entryMapper.addEntry(entry, ejb);
		return (TimeSheet) map(ejb);
	}

	public TimeSheet removeEntry(int tsId, int entryId) throws MappingException {
		TimeSheetEJB ejb = (TimeSheetEJB) findEJBObjectMatching(new TimeSheet(tsId));
		if (ejb == null) {
			throw new MappingException("No TimeSheet with id = " + tsId);
		}
		try {
			// locate EntryEJB
			TimeSheetEntryEJB entryEJB = (TimeSheetEntryEJB) entryMapper.findEJBObjectMatching(new TimeSheetEntry(entryId));
			ejb.getEntries().remove(entryEJB);
			entryEJB.remove();
			return (TimeSheet) map(ejb);
		} catch (RemoveException re) {
			throw new MappingException(re, ("Wrapped Exception " + re + " caught in removeEntry()"));
		}
	}
}
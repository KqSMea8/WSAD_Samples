package com.wsbook.casestudy.mapping.ejb;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Enumeration;
import java.util.ListIterator;

import javax.ejb.EJBLocalObject;
import javax.ejb.EJBObject;
import javax.rmi.PortableRemoteObject;

import com.wsbook.casestudy.domain.Project;
import com.wsbook.casestudy.domain.TimeSheet;
import com.wsbook.casestudy.domain.TimeSheetEntry;
import com.wsbook.casestudy.domain.TsObject;
import com.wsbook.casestudy.ejb.ProjectEJB;
import com.wsbook.casestudy.ejb.TimeSheetEJB;
import com.wsbook.casestudy.ejb.TimeSheetEJBKey;
import com.wsbook.casestudy.ejb.TimeSheetEntryEJB;
import com.wsbook.casestudy.ejb.TimeSheetEntryEJBHome;
import com.wsbook.casestudy.ejb.TimeSheetEntryEJBKey;
import com.wsbook.casestudy.exception.MappingException;
import com.wsbook.casestudy.exception.NoSuchTimeSheetException;
import com.wsbook.casestudy.system.AppService;
import com.wsbook.casestudy.system.TraceCapable;
import com.wsbook.casestudy.util.Formatter;
/**
 * This is the Factory for TimeSheetEntries.  It is used by the TimeSheetFactory.
 * It uses a ProjectFactory.
 *
 * Creation date: (2/26/00 4:02:49 PM)
 * @author: Administrator
 */
public class TimeSheetEntryMapper
	extends DomainEJBMapper
	implements com.wsbook.casestudy.mapping.TimeSheetEntryMapper {
	TimeSheetEntryEJBHome timesheetEntryHome;
	ProjectMapper projectFactory = new ProjectMapper();
	/**
	 * TimeSheetEntryFactory constructor.
	 */
	public TimeSheetEntryMapper() {
		super();
		createInitialContext();
		createTimeSheetEntryHome();
	} 

	protected TimeSheetMapper getTimeSheetFactory() {
		return new TimeSheetMapper();
	}
	
	
	/**
	 * Return a ArrayList of all Domain objects of the type created by this factory.
	 * Creation date: (3/19/00 7:59:51 PM)
	 * @return java.util.ArrayList
	 */
	public ArrayList findAll() throws MappingException {
		ArrayList byTimeSheet = getTimeSheetFactory().findAll();
		ArrayList list = new ArrayList();
		ListIterator iter = byTimeSheet.listIterator();
		while (iter.hasNext()) {
			TimeSheet ts = (TimeSheet) iter.next();
			TimeSheetEntry[] entries = ts.getEntry();
			for (int i = 0; i < entries.length; i++) {
				list.add(entries[i]);
			}
		}
		return list;
	}
	/**
	 * Return an Enumeration that returns all of the EJB's for this type
	 * Creation date: (3/19/00 7:59:31 PM)
	 * @return java.util.Enumeration
	 */
	protected Collection findAllEJBs() throws MappingException {
		try {
			return timesheetEntryHome.findAll();
		} catch (Exception e) {
			throw new MappingException(e, ("Wrapped exception caught in findAllEJBs: " + e));
		}
	}

	public void insert(TsObject obj) throws MappingException {
		throw new MappingException("Cannot insert aTimeSheet alone -- dependent object");
	}

	public void addEntry(TimeSheetEntry entry, TimeSheetEJB parent)
		throws MappingException {
		// This is the official way to add a TimeSheetEntry
		ProjectEJB projEJB = (ProjectEJB)projectFactory.findEJBObjectMatching(entry.getProject());
		try {
			timesheetEntryHome.create(entry.getHours(), entry.getFormattedDate(), projEJB, parent);
		} catch (Exception e) {
			throw new MappingException(e, "Exception caught in addEntry");

		}

	}

	/**
	 * This method retrieves an instance of EmployeeEJBHome from the JNDI initial context.
	 * Creation date: (2/19/00 3:02:08 PM)
	 */
	protected void createTimeSheetEntryHome() {
		try {
			timesheetEntryHome =
				(TimeSheetEntryEJBHome) initContext.lookup(
					"java:comp/env/ejb/TimeSheetEntryEJB");
		} catch (Exception e) { // Error getting the home interface
			AppService.log(TraceCapable.ERROR_LEVEL,
				"Exception " + e + " in createTimeSheetEntryHome()");
		}
	}
	/**
	 * Return the EJBObject matching this domain object.
	 * Creation date: (2/27/00 3:09:30 PM)
	 * @param entry com.wsbook.casestudy.domain.TimeSheetEntry
	 */
	protected EJBLocalObject findEJBObjectMatching(TsObject domainObject)
		throws MappingException {
		TimeSheetEntryEJB ejb = null;
		try {
			TimeSheetEntry entry = (TimeSheetEntry) domainObject;
			int timeSheetEntryID = entry.getTimeSheetEntryID();
			ejb =
				timesheetEntryHome.findByPrimaryKey(
					new TimeSheetEntryEJBKey(timeSheetEntryID));
		} catch (Exception e) {
			AppService.log(TraceCapable.ERROR_LEVEL,
				"Exception " + e + " caught in findEJBObjectMatching()");
			throw new MappingException(
				"Wrapped Exception "
					+ e
					+ " caught in findEJBObjectMatching()");
		}
		return ejb;
	}
	/**
	 * Return the ProjectFactory
	 * Creation date: (2/26/00 4:26:55 PM)
	 * @return com.wsbook.casestudy.mapping.ejb.ProjectFactory
	 */
	public ProjectMapper getProjectFactory() {
		return projectFactory;
	}
	/**
	 * Map this EJBObject to a TimeSheetEntry domain object.
	 * Creation date: (2/26/00 3:53:49 PM)
	 * @return com.wsbook.casestudy.domain.TimeSheet
	 * @param ejb com.wsbook.casestudy.ejb.TimeSheetEJB
	 */
	public TsObject map(EJBLocalObject input) throws MappingException {
		TimeSheetEntryEJB ejb;
		try {
			ejb = (TimeSheetEntryEJB) input;
		} catch (ClassCastException e) {
			throw new MappingException(e,
				"Attempt to map a non TimeSheetEntryEJB in TimeSheetEntryFactory");
		}
		TimeSheetEntry timeSheetEntry = null;
		try {
			timeSheetEntry = new TimeSheetEntry();
			timeSheetEntry.setTimeSheetEntryID(
				((TimeSheetEntryEJBKey) ejb.getPrimaryKey()).entryId);
			timeSheetEntry.setHours(ejb.getHours());
			timeSheetEntry.setProject(
				(Project) getProjectFactory().map(ejb.getProject()));
			timeSheetEntry.setDate(Formatter.convertToDate(ejb.getDate()));
		} catch (Exception e) {
			AppService.log(TraceCapable.ERROR_LEVEL,
				"Exception " + e + " caught in TimeSheetEntryFactory.map()");
			throw new MappingException(e, (
				"Wrapped Exception "
					+ e
					+ " caught in TimeSheetEntryFactory.map()"));
		}
		return timeSheetEntry;
	}
	/**
	 * Update the EJB corresponding to this domain object in the persistent store.
	 * Creation date: (2/27/00 3:09:30 PM)
	 * @param entry com.wsbook.casestudy.domain.TimeSheetEntry
	 */
	public void update(TsObject obj) throws MappingException {
		try {
			TimeSheetEntry entry = (TimeSheetEntry) obj;
			int timeSheetEntryID = entry.getTimeSheetEntryID();
			TimeSheetEntryEJB ejb =
				timesheetEntryHome.findByPrimaryKey(
					new TimeSheetEntryEJBKey(timeSheetEntryID));
			double hours = entry.getHours();
			ejb.setHours(hours);

			// This date logic belongs in a private method
			Calendar calendar = entry.getDate();
			String dateString = Formatter.dateFormat(calendar);
			ejb.setDate(dateString);
			ProjectEJB project =
				(ProjectEJB) getProjectFactory().findEJBObjectMatching(
					entry.getProject());
			ejb.setProject(project);
		} catch (Exception e) {
			AppService.log(TraceCapable.ERROR_LEVEL,"Exception " + e + " caught in update()");
			throw new MappingException(e, 
				("Wrapped Exception " + e + " caught in update()"));
		}
	}

	public TimeSheet removeByKey(int parentKey, int entryKey)
		throws MappingException {

		TimeSheetMapper mapper = new TimeSheetMapper();
		TimeSheet timesheet = mapper.removeEntry(parentKey, entryKey);
		return timesheet;
	}
}
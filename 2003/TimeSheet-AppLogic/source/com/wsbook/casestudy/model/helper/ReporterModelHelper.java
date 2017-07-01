package com.wsbook.casestudy.model.helper;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.TreeSet;

import com.wsbook.casestudy.domain.Employee;
import com.wsbook.casestudy.domain.TimeSheetEntry;
import com.wsbook.casestudy.exception.MappingException;
import com.wsbook.casestudy.exception.ModelException;
import com.wsbook.casestudy.mapping.EmployeeMapper;
import com.wsbook.casestudy.mapping.MapperFactory;
import com.wsbook.casestudy.mapping.TimeSheetEntryMapper;
import com.wsbook.casestudy.util.Formatter;
import com.wsbook.casestudy.util.MonthlyHour;
import com.wsbook.casestudy.value.Report;
import com.wsbook.casestudy.value.ReportCollection;
import com.wsbook.casestudy.value.ReportRecord;

public class ReporterModelHelper implements Serializable {
	
	static String[] months = {
		"January", "February", "March", "April", "May", "June", "July", 
		"August", "September", "October", "November", "December"};

	public Report generateProjectReportByEmployee() {
		return null;
	}

	public Report generateEmployeeReportByMonth() throws ModelException {
		
		ArrayList allEntries =  null;
		ArrayList employees = null;
		
		try {
			allEntries = getAllEntries();
			employees = getAllEmployees();
		
		} catch (MappingException e) {
			throw new ModelException("MappingException caught in generateEmployeeRemportByMonth" + e.toString());
		}

		// ReportCollection object per Employee
		ReportCollection[] wrapper = new ReportCollection[employees.size()];
		int employeeIndex = 0;
		// Process entries for each employee
		ListIterator empIter = employees.listIterator();
		while (empIter.hasNext()) {
			Employee curEmployee = (Employee) empIter.next();

			ListIterator entryIter = allEntries.listIterator();
			// initialize per Employee report collection
			//TreeSet reportRaw = new TreeSet();
			Hashtable reportTable = new Hashtable();
			String curEmployeeId = curEmployee.getId();
			while (entryIter.hasNext()) {
				TimeSheetEntry curEntry = (TimeSheetEntry) entryIter.next();
				String curEntryEmpId = curEntry.getTimeSheet().getEmployee().getId();
				if (!curEmployeeId.equals(curEntryEmpId)) {
					continue;
				}

				// Entry is part of current collection
				MonthlyHour newMH = new MonthlyHour(curEntry.getDate(), curEntry.getHours());
				MonthlyHour existing = (MonthlyHour) reportTable.get(newMH.getHashString());
				if (existing != null) {
					existing.setHours(existing.getHours() + curEntry.getHours());
				} else { // add new month entry
					reportTable.put(newMH.getHashString(), newMH);
				}
			}

			// now we have an unsorted set sort by inserting in a TreeSet
			TreeSet reportSorted = new TreeSet();
			Enumeration elements = reportTable.elements();
			while (elements.hasMoreElements()) {
				reportSorted.add(elements.nextElement());
			}
			
			// now we have a sorted set -- build a displayable ReportCollection
			// also sum up the hours
			ReportRecord[] employeeRecords = new ReportRecord[reportSorted.size()];
			int i=0;
			double employeeHours = 0.0;
			Iterator orderedIter = reportSorted.iterator();
			while (orderedIter.hasNext()) {
				MonthlyHour curMH = (MonthlyHour)orderedIter.next();
				ReportRecord record = new ReportRecord(displayMonthYear(curMH.getMonth()), curMH.getHours());
				employeeHours += curMH.getHours();
				employeeRecords[i++] = record;
			}
			
			// now construct the ReportCollection object
			ReportCollection collection = new ReportCollection(curEmployee.getName(), employeeHours, employeeRecords);
			wrapper[employeeIndex++] = collection;
			
				

		}
		
		Report report = new Report();
		report.setCollections(wrapper);
		return report;
	}
	
	private String displayMonthYear(Calendar month) {
		StringBuffer buf = new StringBuffer();
		int monthIdx = month.get(Calendar.MONTH);
		buf.append(months[monthIdx]);
		buf.append(" ");
		buf.append((new Integer(month.get(Calendar.YEAR))).toString());
		return buf.toString();
	}

	private ArrayList getAllEmployees() throws MappingException {
		EmployeeMapper empMapper = (EmployeeMapper) MapperFactory.getSystemMapperFactory().getMapper(Employee.class);
		return empMapper.findAll();
	}

	private ArrayList getAllEntries() throws MappingException {
		TimeSheetEntryMapper tseMapper = (TimeSheetEntryMapper) MapperFactory.getSystemMapperFactory().getMapper(TimeSheetEntry.class);
		return tseMapper.findAll();
	}

}
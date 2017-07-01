package com.wsbook.casestudy.mapping;

import java.util.ArrayList;

import com.wsbook.casestudy.domain.TimeSheet;
import com.wsbook.casestudy.domain.TimeSheetEntry;
import com.wsbook.casestudy.exception.MappingException;

public interface TimeSheetMapper extends Mapper {
	
	
	public TimeSheet addEntry(int tsId, TimeSheetEntry entry) throws MappingException;
	public ArrayList findForEmployee(String empId) throws MappingException;
	public ArrayList findPendingForEmployee(String empId) throws MappingException;
	public ArrayList findApprovedForEmployee(String empId) throws MappingException;
	public ArrayList findAllPending() throws MappingException;
	public ArrayList findAllApproved() throws MappingException;
	public TimeSheet findByKey(String empId, String weekEnding) throws MappingException;

}


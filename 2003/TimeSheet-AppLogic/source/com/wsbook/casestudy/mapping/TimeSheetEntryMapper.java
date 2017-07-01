package com.wsbook.casestudy.mapping;

import java.sql.Connection;
import java.util.ArrayList;

import com.wsbook.casestudy.domain.TimeSheet;
import com.wsbook.casestudy.domain.TimeSheetEntry;
import com.wsbook.casestudy.exception.MappingException;
import com.wsbook.casestudy.exception.NoSuchTimeSheetException;

public interface TimeSheetEntryMapper extends Mapper {

	public TimeSheet removeByKey(int timesheetId, int entryId) throws NoSuchTimeSheetException, MappingException;
}


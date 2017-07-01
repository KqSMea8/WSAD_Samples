package com.wsbook.casestudy.model.helper;

import com.wsbook.casestudy.domain.Employee;
import com.wsbook.casestudy.domain.TimeSheet;
import com.wsbook.casestudy.exception.MappingException;
import com.wsbook.casestudy.exception.ModelException;
import com.wsbook.casestudy.mapping.EmployeeMapper;
import com.wsbook.casestudy.mapping.MapperFactory;
import com.wsbook.casestudy.mapping.TimeSheetMapper;

/**
 * @author kbrown
 *
 * To change this generated comment edit the template variable "typecomment":
 * Window>Preferences>Java>Templates.
 * To enable and disable the creation of type comments go to
 * Window>Preferences>Java>Code Generation.
 */
public class TimeSheetApprover {

	/**
	 * Constructor for TimeSheetApprover.
	 */
	public TimeSheetApprover() {
		super();
	}

	public TimeSheet approveTimeSheetByKey(String submitterId, String weekEnding, String approverId) throws ModelException, MappingException{
		TimeSheetMapper mapper =
			(TimeSheetMapper) MapperFactory.getSystemMapperFactory().getMapper(
				TimeSheet.class);
		EmployeeMapper empMapper =
		(EmployeeMapper) MapperFactory.getSystemMapperFactory().getMapper(
				Employee.class);
		TimeSheet ts =  (TimeSheet)mapper.findByKey(submitterId, weekEnding);
		if (ts != null) {
			try {
				Employee approvedBy = (Employee)empMapper.findById(approverId);
				ts.approve();
				ts.setApprovedBy(approvedBy);
				mapper.update(ts);
				return ts;
			} catch (Exception e) {
				throw new ModelException (e, ("Exception caught in approveTimeSheetByKey " + e.toString()));
			}
		}
		return null;
	}
}

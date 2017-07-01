package com.wsbook.casestudy.ejb;

import java.util.ArrayList;

import javax.ejb.CreateException;
import javax.ejb.SessionBean;
import javax.ejb.SessionContext;

import com.wsbook.casestudy.command.UpdateTimesheetFormCommand;
import com.wsbook.casestudy.domain.Employee;
import com.wsbook.casestudy.domain.Project;
import com.wsbook.casestudy.domain.TimeSheet;
import com.wsbook.casestudy.exception.DuplicateKeyException;
import com.wsbook.casestudy.exception.MappingException;
import com.wsbook.casestudy.exception.ModelException;
import com.wsbook.casestudy.exception.NoSuchEmployeeException;
import com.wsbook.casestudy.exception.NoSuchProjectException;
import com.wsbook.casestudy.exception.NoSuchTimeSheetException;
import com.wsbook.casestudy.mapping.EmployeeMapper;
import com.wsbook.casestudy.mapping.Mapper;
import com.wsbook.casestudy.mapping.MapperFactory;
import com.wsbook.casestudy.mapping.ProjectMapper;
import com.wsbook.casestudy.mapping.TimeSheetMapper;
import com.wsbook.casestudy.model.TimeSheetActionProcessor;
import com.wsbook.casestudy.model.helper.TimeSheetApprover;
import com.wsbook.casestudy.value.TimeSheets;
import com.wsbook.casestudy.value.WeekEndings;

/**
 * Bean implementation class for Enterprise Bean: TimeSheetActionProcessorFacade
 */
public class TimeSheetActionProcessorFacadeBean implements javax.ejb.SessionBean {
	private javax.ejb.SessionContext mySessionCtx;
	/**
	 * getSessionContext
	 */
	public javax.ejb.SessionContext getSessionContext() {
		return mySessionCtx;
	}
	/**
	 * setSessionContext
	 */
	public void setSessionContext(javax.ejb.SessionContext ctx) {
		mySessionCtx = ctx;
	}
	/**
	 * ejbActivate
	 */
	public void ejbActivate() {
	}
	/**
	 * ejbCreate
	 */
	public void ejbCreate() throws javax.ejb.CreateException {
	}
	/**
	 * ejbPassivate
	 */
	public void ejbPassivate() {
	}
	/**
	 * ejbRemove
	 */
	public void ejbRemove() {
	}
	
	/**
	 * @see TimeSheetActionProcessor#addProject(Project)
	 */
	public void addProject(Project newProject) throws MappingException {
		newProject.getMapper().insert(newProject);
	}

	/**
	 * @see TimeSheetActionProcessor#findProjectByName(String)
	 */
	public Project findProjectByName(String projectName)
		throws NoSuchProjectException, MappingException {
		ProjectMapper mapper =
			(ProjectMapper) MapperFactory.getSystemMapperFactory().getMapper(
				Project.class);
		return mapper.findByName(projectName);
	}

	/**
	 * @see TimeSheetActionProcessor#findProjectByKey(String)
	 */
	public Project findProjectByKey(String projectId)
		throws NoSuchProjectException {
		Mapper mapper =
			MapperFactory.getSystemMapperFactory().getMapper(Project.class);
		try {
			return (Project) mapper.findByPrimaryKey(new Project(projectId));
		} catch (Exception nsoe) {
			if (nsoe instanceof NoSuchProjectException)
				throw (NoSuchProjectException) nsoe;
			else
				throw new NoSuchProjectException(nsoe.getMessage());
		}
	}

	/**
	 * @see TimeSheetActionProcessor#findAllProjects()
	 */
	public ArrayList findAllProjects() throws ModelException {
		ArrayList list = null;
		try {
			Mapper mapper =
				MapperFactory.getSystemMapperFactory().getMapper(Project.class);
			list = mapper.findAll();
		} catch (MappingException e) {
			throw new ModelException(e, 
				"Mapping Exception caught in findAllProjects() ");
		}
		return list;
	}

	/**
	 * @see TimeSheetActionProcessor#removeProject(String)
	 */
	public void removeProject(String projectId) throws NoSuchProjectException {
		Mapper mapper =
			MapperFactory.getSystemMapperFactory().getMapper(Project.class);
		try {
			mapper.remove(new Project(projectId));
		} catch (Exception nsoe) {
			if (nsoe instanceof NoSuchProjectException)
				throw (NoSuchProjectException) nsoe;
			else
				throw new NoSuchProjectException(nsoe, ("Exception caught in removeProject:" + nsoe.getMessage()));
		}
	}

	/**
	 * @see TimeSheetActionProcessor#findOrCreateTimeSheetByKey(String, String)
	 */
	public TimeSheet findOrCreateTimeSheetByKey(String empId, String weekEnding)
		throws NoSuchEmployeeException, ModelException, MappingException {
		TimeSheet sheet = null;
		sheet = findTimeSheetByKey(empId, weekEnding);
		if (sheet == null) { // create a new empty TimeSheet
			sheet = createTimeSheet(empId, weekEnding);
		}
		return sheet;
	}

	/**
	 * @see TimeSheetActionProcessor#findTimeSheetByKey(String, String)
	 */
	public TimeSheet findTimeSheetByKey(String empId, String weekEnding)
		throws NoSuchEmployeeException, MappingException {
		TimeSheetMapper mapper =
			(TimeSheetMapper) MapperFactory.getSystemMapperFactory().getMapper(
				TimeSheet.class);
		return (TimeSheet) mapper.findByKey(empId, weekEnding);
	}
	/**
	 * @see TimeSheetActionProcessor#createTimeSheet(String, String)
	 */
	public TimeSheet createTimeSheet(String empId, String weekEnding)
		throws NoSuchEmployeeException, MappingException, ModelException {
		TimeSheet ts = new TimeSheet(empId, weekEnding);
		// now add to persistence framework
		Mapper mapper =
			MapperFactory.getSystemMapperFactory().getMapper(TimeSheet.class);
		try {
			mapper.insert(ts);
		} catch (DuplicateKeyException e) {
			throw new ModelException(e, "Duplicate Key");
		} catch (MappingException me) {
			throw new ModelException(me, "Mapping exception caught in createTimeSheet" + me.toString());
		}
		return ts;
	}

	/**
	 * @see TimeSheetActionProcessor#findPendingForEmployee(String)
	 */
	public ArrayList findPendingForEmployee(String empId)
		throws NoSuchEmployeeException, MappingException {
		TimeSheetMapper mapper =
			(TimeSheetMapper) MapperFactory.getSystemMapperFactory().getMapper(
				TimeSheet.class);
		return mapper.findPendingForEmployee(empId);
	}

	/**
	 * @see TimeSheetActionProcessor#findApprovedForEmployee(String)
	 */
	public ArrayList findApprovedForEmployee(String empId)
		throws NoSuchEmployeeException, MappingException {
		TimeSheetMapper mapper =
			(TimeSheetMapper) MapperFactory.getSystemMapperFactory().getMapper(
				TimeSheet.class);
		return mapper.findApprovedForEmployee(empId);
	}

	/**
	 * @see TimeSheetActionProcessor#getPendingTimeSheets(String)
	 */
	public TimeSheets getPendingTimeSheets() throws MappingException {
		TimeSheetMapper mapper =
			(TimeSheetMapper) MapperFactory.getSystemMapperFactory().getMapper(
				TimeSheet.class);
		return new TimeSheets(mapper.findAllPending());
	}

	/**
	 * @see TimeSheetActionProcessor#getApprovedTimeSheets(String)
	 */
	public TimeSheets getApprovedTimeSheets() throws MappingException {
		TimeSheetMapper mapper =
			(TimeSheetMapper) MapperFactory.getSystemMapperFactory().getMapper(
				TimeSheet.class);
		return new TimeSheets(mapper.findAllApproved());
	}

	/**
	 * @see TimeSheetActionProcessor#getWeekEndings(String)
	 */
	public WeekEndings getWeekEndings(String empId)
		throws NoSuchEmployeeException, MappingException {
		ArrayList calendars = new ArrayList();
		TimeSheetMapper mapper =
			(TimeSheetMapper) MapperFactory.getSystemMapperFactory().getMapper(
				TimeSheet.class);
		ArrayList timeSheets =  mapper.findForEmployee(empId);
		java.util.ListIterator iter = timeSheets.listIterator();
		while (iter.hasNext()) {
			TimeSheet ts = (TimeSheet) iter.next();
			calendars.add(ts.getWeekend());
		}
		return new WeekEndings(calendars);
	}

	/**
	 * @see TimeSheetActionProcessor#approveTimeSheetByKey(String, String)
	 */
	public TimeSheet approveTimeSheetByKey(String submitterId, String weekEnding, String approverId) throws ModelException, MappingException  {
		return (new TimeSheetApprover()).approveTimeSheetByKey(submitterId, weekEnding, approverId);
	}	

	/**
	 * @see TimeSheetActionProcessor#updateTimeSheetEntries(TimeSheet, UpdateTSEntryCommand[])
	 */
	public TimeSheet updateTimesheet(UpdateTimesheetFormCommand command)
		throws NoSuchTimeSheetException, ModelException {
		return command.updateTimesheet();
	}

	/**
	 * @see TimeSheetActionProcessor#findEmployeeByKey(String)
	 */
	public Employee findEmployeeByKey(String empId)
		throws NoSuchEmployeeException {
		Mapper mapper = MapperFactory.getSystemMapperFactory().getMapper(Employee.class);
		try {
			return (Employee) mapper.findByPrimaryKey(new Employee(empId));
		} catch (Exception nsoe) {
			if (nsoe instanceof NoSuchEmployeeException)
				throw (NoSuchEmployeeException) nsoe;
			else
				throw new NoSuchEmployeeException(nsoe, ("Exception caught in findEmployeebykey:" + nsoe.getMessage()));
		}
	}

	/**
	 * @see TimeSheetActionProcessor#findAllEmployees()
	 */
	public ArrayList findAllEmployees() throws ModelException {
		ArrayList list = null;
		try {
		Mapper mapper = MapperFactory.getSystemMapperFactory().getMapper(Employee.class);
		list = mapper.findAll();
		} catch (MappingException e) {
			throw new ModelException(e, ("MappingException caught in findAllEmployees " + e));
		}
		return list;
	}

	/**
	 * @see TimeSheetActionProcessor#removeEmployee(String)
	 */
	public void removeEmployee(String empId) throws NoSuchEmployeeException {
		Mapper mapper = MapperFactory.getSystemMapperFactory().getMapper(Employee.class);
		try {
			Employee emp = (Employee) mapper.findByPrimaryKey(new Employee(empId));
			mapper.remove(emp);
		} catch (Exception nsoe) {
			if (nsoe instanceof NoSuchEmployeeException)
				throw (NoSuchEmployeeException) nsoe;
			else
				throw new NoSuchEmployeeException(nsoe, ("Exception caught in removeEmployee" + nsoe.getMessage()));
		}

	}

	/**
	 * @see TimeSheetActionProcessor#addEmployee(Employee)
	 */
	public void addEmployee(Employee newEmployee) throws MappingException {
		Mapper mapper = MapperFactory.getSystemMapperFactory().getMapper(Employee.class);
		mapper.insert(newEmployee);
	}
	
	/**
	 * @see TimeSheetActionProcessor#clearInMemoryCaches()
	 */
	public void clearInMemoryCaches() {
		// This could/should be done in a helper object but this is fine since it's a test method.
		com.wsbook.casestudy.mapping.memory.EmployeeMapper empMap = (com.wsbook.casestudy.mapping.memory.EmployeeMapper) (new Employee()).getMapper();
		empMap.clearCache();
		com.wsbook.casestudy.mapping.memory.ProjectMapper projMap = (com.wsbook.casestudy.mapping.memory.ProjectMapper) (new Project()).getMapper();
		projMap.clearCache();
		com.wsbook.casestudy.mapping.memory.TimeSheetMapper tsMap = (com.wsbook.casestudy.mapping.memory.TimeSheetMapper) (new TimeSheet()).getMapper();
		tsMap.clearCache();
	}

}

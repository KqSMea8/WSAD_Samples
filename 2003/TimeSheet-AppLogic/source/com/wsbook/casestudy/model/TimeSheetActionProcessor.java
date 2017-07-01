package com.wsbook.casestudy.model;

import java.io.Serializable;
import java.util.ArrayList;

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
import com.wsbook.casestudy.value.TimeSheets;
import com.wsbook.casestudy.value.WeekEndings;

/**
 * Application Model interface for Timesheet manipulation services.
 * These include manipulation of Projects, Employees, and Timesheets
 */
public interface TimeSheetActionProcessor extends Serializable {

	/**
	 * Insert a new Project into the Timesheet system
	 * @param newProject the Project to be added.
	 */
	public void addProject(Project newProject) throws MappingException;

	/**
	 * Locate a Project by its name.
	 * @returns the requested Project
	 * @param projectName the String identifying the Project to be returned.
	 */
	public Project findProjectByName(String projectName) throws NoSuchProjectException, MappingException;

	/**
	 * Locate Project by is Id.
	 * @returns the requested Project
	 * @param projectId the String identifying the Project to be returned.
	 */
	public Project findProjectByKey(String projectId) throws NoSuchProjectException;

	/**
	 * Locate all Projects known by the TimeSheet system.
	 * @returns a List of all Projects
	 */
	public ArrayList findAllProjects() throws ModelException;

	/** 
	 * Delete a Project from system
	 * @param projectId the id of the Project to be removed.
	 */
	public void removeProject(String projectId) throws NoSuchProjectException;

	/**
	 * Return the timesheet for employee id, and weekending.  If no such TimeSheet exists
	 * create a new empty TimeSheet for the named employee for the specific weekEnding date.
	 * @returns the selected TimeSheet
	 * @param empId EmployeeId owning the TimeSheet to be returned
	 * @param weekEnding the specific weekEnding String for the TimeSheet to be returned
	 */
	public TimeSheet findOrCreateTimeSheetByKey(String empId, String weekEnding) throws NoSuchEmployeeException, ModelException, MappingException;

	/**
	 * Return the timesheet for employee id, and weekending. 
	 * @returns the selected TimeSheet. Returns null if no such TimeSheet can be found.
	 * @param empId EmployeeId owning the TimeSheet to be returned
	 * @param weekEnding the specific weekEnding String for the TimeSheet to be returned
	 */
	public TimeSheet findTimeSheetByKey(String empId, String weekEnding) throws NoSuchEmployeeException, MappingException;

	/** 
	 * Create a new persistent TimeSheet
	 * @param empId String representing the Employee Id for the TimeSheet
	 * @param weekEnding String in mm/dd/yyyy format representing the 
	 *     weekending date of the TimeSheet
	 * @return a com.wsbook.casestudy.domain.TimeSheet
	 */
	public TimeSheet createTimeSheet(String empId, String weekEnding) throws NoSuchEmployeeException, DuplicateKeyException, ModelException, MappingException;

	/**
	 * Retrieve all Pending TimeSheets for Employee.
	 * @returns List of TimeSheets
	 * @param empId id for Employee whose TimeSheets are to be retrieved.
	 */
	public ArrayList findPendingForEmployee(String empId) throws NoSuchEmployeeException, MappingException;

	/**
	 * Retrieve all Approved TimeSheets for Employee.
	 * @returns List of TimeSheets
	 * @param empId id for Employee whose TimeSheets are to be retrieved.
	 */
	public ArrayList findApprovedForEmployee(String empId) throws NoSuchEmployeeException, MappingException;

	/**
	 * Retrieve all Pending TimeSheets in the system.
	 * @returns TimeSheets value Bean (collection of TimeSheets)
	 */
	public TimeSheets getPendingTimeSheets() throws MappingException;

	/**
	 * Retrieve all Approved TimeSheets in the system.
	 * @returns TimeSheets value Bean (collection of TimeSheets)
	 */
	public TimeSheets getApprovedTimeSheets() throws MappingException;
	
	/**
	 * Retrieve the WeekEnding dates associated with TimeSheets that exist for
	 * specified Employee.
	 * @returns Collection of Dates as a Value Bean of type WeekEndings
	 * @param empId identifies Employee for which TimeSheet weekending dates are to be retrieved.
	 */
	public WeekEndings getWeekEndings(String empId) throws NoSuchEmployeeException, MappingException;
	
	/**
	 * Update a TimeSheet (add, remove or change TimeSheetEntry).
	 * The update operations are encoded in an UpdateTimesheetFormCommand bean.
	 * @returns A reference to the updated TimeSheet
	 * @param tsForm the command bean that encodes the update requests
	 */
	public TimeSheet updateTimesheet(UpdateTimesheetFormCommand tsForm) throws NoSuchTimeSheetException, ModelException;

	/**
	 * Change the state of a given TimeSheet (changed to Approved), specified by its unique key elements.
	 * @returns the newly Approved TimeSheet
	 * @param empId Employee Id
	 * @param weekEnding the selected week (TimeSheet)
	 */
	public TimeSheet approveTimeSheetByKey(String submitterId, String weekEnding, String approverId) throws ModelException, MappingException;

	/**
	 * Retrieve the Employee object with supplied employee Id.
	 * @param empId the String Employee Id
	 * @return the located Employee, or null if no such employee exists
	 */
	public Employee findEmployeeByKey(String empId) throws NoSuchEmployeeException;

	/**
	 * Return all Employees
	 * @return java.util.ArrayList
	 */
	public ArrayList findAllEmployees() throws ModelException, MappingException;

	/** 
	 * Removes an employee from the system. Operation cascades to remove all
	 * associated TimeSheets.
	 * @param empId Employee to be removed.
	 */
	public void removeEmployee(String empId) throws NoSuchEmployeeException;
	
	/**
	 * Add a new persistent Employee to the system.
	 * @param Employee to add to the persistent store.
	 */
	public void addEmployee(Employee newEmployee) throws MappingException;
	
	/**
	 * This is a testing method designed to allow you to clear the caches for the
	 * In-Memory Simulated Data Access Objects when neecessary.
	 */
	public void clearInMemoryCaches();

}
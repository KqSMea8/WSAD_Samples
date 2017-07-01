package com.wsbook.casestudy.ejb;

import java.rmi.RemoteException;
import java.util.ArrayList;

import javax.ejb.EJBObject;

import com.wsbook.casestudy.command.UpdateTimesheetFormCommand;
import com.wsbook.casestudy.domain.Employee;
import com.wsbook.casestudy.domain.Project;
import com.wsbook.casestudy.domain.TimeSheet;
import com.wsbook.casestudy.exception.MappingException;
import com.wsbook.casestudy.exception.ModelException;
import com.wsbook.casestudy.exception.NoSuchEmployeeException;
import com.wsbook.casestudy.exception.NoSuchProjectException;
import com.wsbook.casestudy.exception.NoSuchTimeSheetException;
import com.wsbook.casestudy.value.TimeSheets;
import com.wsbook.casestudy.value.WeekEndings;

/**
 * Remote interface for Enterprise Bean: TimeSheetActionProcessorFacade
 */
public interface TimeSheetActionProcessorFacade extends javax.ejb.EJBObject {
	/**
	 * @see TimeSheetActionProcessor#addProject(Project)
	 */
	public void addProject(Project newProject) throws MappingException, java.rmi.RemoteException;
	/**
	 * @see TimeSheetActionProcessor#findProjectByName(String)
	 */
	public Project findProjectByName(String projectName)
		throws NoSuchProjectException, MappingException, java.rmi.RemoteException;
	/**
	 * @see TimeSheetActionProcessor#findProjectByKey(String)
	 */
	public Project findProjectByKey(String projectId)
		throws NoSuchProjectException, java.rmi.RemoteException;
	/**
	 * @see TimeSheetActionProcessor#findAllProjects()
	 */
	public ArrayList findAllProjects() throws ModelException, java.rmi.RemoteException;
	/**
	 * @see TimeSheetActionProcessor#removeProject(String)
	 */
	public void removeProject(String projectId) throws NoSuchProjectException, java.rmi.RemoteException;
	/**
	 * @see TimeSheetActionProcessor#findTimeSheetByKey(String, String)
	 */
	public TimeSheet findOrCreateTimeSheetByKey(String empId, String weekEnding)
		throws NoSuchEmployeeException, MappingException, ModelException, java.rmi.RemoteException;
	/**
	 * @see TimeSheetActionProcessor#createTimeSheet(String, String)
	 */
	public TimeSheet createTimeSheet(String empId, String weekEnding)
		throws NoSuchEmployeeException, MappingException, ModelException, java.rmi.RemoteException;
	/**
	 * @see TimeSheetActionProcessor#findPendingForEmployee(String)
	 */
	public ArrayList findPendingForEmployee(String empId)
		throws NoSuchEmployeeException, MappingException, java.rmi.RemoteException;
	/**
	 * @see TimeSheetActionProcessor#findApprovedForEmployee(String)
	 */
	public ArrayList findApprovedForEmployee(String empId)
		throws NoSuchEmployeeException, MappingException, java.rmi.RemoteException;
	/**
	 * @see TimeSheetActionProcessor#getPendingTimeSheets(String)
	 */
	public TimeSheets getPendingTimeSheets() throws MappingException, java.rmi.RemoteException;
	/**
	 * @see TimeSheetActionProcessor#getApprovedTimeSheets(String)
	 */
	public TimeSheets getApprovedTimeSheets() throws MappingException, java.rmi.RemoteException;
	/**
	 * @see TimeSheetActionProcessor#getWeekEndings(String)
	 */
	public WeekEndings getWeekEndings(String empId)
		throws NoSuchEmployeeException, MappingException, java.rmi.RemoteException;
	/**
	 * @see TimeSheetActionProcessor#approveTimeSheetByKey(String, String)
	 */
	public TimeSheet approveTimeSheetByKey(String submitterId, String weekEnding, String approverId) throws MappingException, ModelException, java.rmi.RemoteException;
	/**
	 * @see TimeSheetActionProcessor#updateTimeSheetEntries(TimeSheet, UpdateTSEntryCommand[])
	 */
	public TimeSheet updateTimesheet(UpdateTimesheetFormCommand command)
		throws ModelException, NoSuchTimeSheetException, java.rmi.RemoteException;
	/**
	 * @see TimeSheetActionProcessor#findEmployeeByKey(String)
	 */
	public Employee findEmployeeByKey(String empId)
		throws NoSuchEmployeeException, java.rmi.RemoteException;
	/**
	 * @see TimeSheetActionProcessor#findAllEmployees()
	 */
	public ArrayList findAllEmployees() throws ModelException, java.rmi.RemoteException;
	/**
	 * @see TimeSheetActionProcessor#removeEmployee(String)
	 */
	public void removeEmployee(String empId) throws NoSuchEmployeeException, java.rmi.RemoteException;
	/**
	 * @see TimeSheetActionProcessor#addEmployee(Employee)
	 */
	public void addEmployee(Employee newEmployee) throws MappingException, java.rmi.RemoteException;
	/**
	 * @see TimeSheetActionProcessor#findTimeSheetByKey(String, String)
	 */
	public TimeSheet findTimeSheetByKey(String empId, String weekEnding)
		throws NoSuchEmployeeException, MappingException, java.rmi.RemoteException;
	/**
	 * @see TimeSheetActionProcessor#clearInMemoryCaches()
	 */
	public void clearInMemoryCaches() throws java.rmi.RemoteException;
}

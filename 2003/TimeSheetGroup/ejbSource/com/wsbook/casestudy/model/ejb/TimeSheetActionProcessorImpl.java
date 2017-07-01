package com.wsbook.casestudy.model.ejb;

import java.rmi.RemoteException;
import java.util.ArrayList;

import com.wsbook.casestudy.command.UpdateTimesheetFormCommand;
import com.wsbook.casestudy.domain.Employee;
import com.wsbook.casestudy.domain.Project;
import com.wsbook.casestudy.domain.TimeSheet;
import com.wsbook.casestudy.ejb.TimeSheetActionProcessorFacade;
import com.wsbook.casestudy.ejb.TimeSheetActionProcessorFacadeHome;
import com.wsbook.casestudy.exception.DuplicateKeyException;
import com.wsbook.casestudy.exception.MappingException;
import com.wsbook.casestudy.exception.ModelException;
import com.wsbook.casestudy.exception.NoSuchEmployeeException;
import com.wsbook.casestudy.exception.NoSuchProjectException;
import com.wsbook.casestudy.exception.NoSuchTimeSheetException;
import com.wsbook.casestudy.model.TimeSheetActionProcessor;
import com.wsbook.casestudy.system.TraceCapable;
import com.wsbook.casestudy.system.AppService;
import com.wsbook.casestudy.util.EJBClientHelper;
import com.wsbook.casestudy.value.TimeSheets;
import com.wsbook.casestudy.value.WeekEndings;

/**
 * Adapter to connect to the Session Bean "Facade" implementation of the TimeSheetActionProcessor, i.e.
 * application model services exposed via the TimeSheetActionProcess Interface.
 */
public class TimeSheetActionProcessorImpl implements TimeSheetActionProcessor {

	/**
	 * Access (create) an instance of the TimeSheetActionProcessorFacade
	 * @returns a new TimeSheet session facade bean
	 */
	protected TimeSheetActionProcessorFacade getTSFacade() {
		try {
			return (
				(TimeSheetActionProcessorFacadeHome) EJBClientHelper.getHome(
				"TimeSheetActionProcessor",	TimeSheetActionProcessorFacadeHome.class))
				.create();
		} catch (Exception e) {
			AppService.log(TraceCapable.ERROR_LEVEL,"Exception caught " + e);
			return null;
		}
	}

	/**
	* @see TimeSheetActionProcessor#addProject(Project)
	*/
	public void addProject(Project newProject) throws MappingException {
		TimeSheetActionProcessorFacade modelFacade = null;
		try {
			modelFacade = getTSFacade();
			if (modelFacade != null)
				modelFacade.addProject(newProject);
		} catch (RemoteException re) {
			throw new MappingException(re, "Remote Exception caught in addProject");
		} finally {
			try {
				modelFacade.remove();
			} catch (Exception e) {
			}
		}
	}

	/**
	 * @see TimeSheetActionProcessor#findTimeSheetByKey(String, String)
	 */
	public TimeSheet findOrCreateTimeSheetByKey(String empId, String weekEnding)
		throws NoSuchEmployeeException, MappingException, ModelException {
		TimeSheetActionProcessorFacade modelFacade = null;
		try {
			modelFacade = getTSFacade();
			if (modelFacade != null)
				return modelFacade.findOrCreateTimeSheetByKey(empId, weekEnding);
			throw new NoSuchEmployeeException("No Facade Found");
		} catch (RemoteException re) {
			throw new NoSuchEmployeeException(re, "Remote Exception caught");
		} finally {
			try {
				modelFacade.remove();
			} catch (Exception e) {
			}
		}
	}

	/**
	 * @see TimeSheetActionProcessor#findTimeSheetByKey(String, String)
	 */
	public TimeSheet findTimeSheetByKey(String empId, String weekEnding)
		throws NoSuchEmployeeException, MappingException {
		TimeSheetActionProcessorFacade modelFacade = null;
		try {
			modelFacade = getTSFacade();
			if (modelFacade != null)
				return modelFacade.findTimeSheetByKey(empId, weekEnding);
			throw new NoSuchEmployeeException("No Facade Found");
		} catch (RemoteException re) {
			throw new NoSuchEmployeeException(re, "Remote Exception caught in findtimeSheetByKey");
		} finally {
			try {
				modelFacade.remove();
			} catch (Exception e) {
			}
		}
	}
	/**
	 * @see TimeSheetActionProcessor#findProjectByName(String)
	 */
	public Project findProjectByName(String projectName)
		throws NoSuchProjectException, MappingException {
		TimeSheetActionProcessorFacade modelFacade = null;
		try {
			modelFacade = getTSFacade();
			if (modelFacade != null)
				return modelFacade.findProjectByName(projectName);
			throw new NoSuchProjectException("No Facade Found");
		} catch (RemoteException re) {
			throw new NoSuchProjectException(re, "Remote Exception caught in findProjectByName");
		} finally {
			try {
				modelFacade.remove();
			} catch (Exception e) {
			}
		}
	}

	/**
	 * @see TimeSheetActionProcessor#findProjectByKey(String)
	 */
	public Project findProjectByKey(String projectId)
		throws NoSuchProjectException {
		TimeSheetActionProcessorFacade modelFacade = null;
		try {
			modelFacade = getTSFacade();
			if (modelFacade != null)
				return modelFacade.findProjectByKey(projectId);
			throw new NoSuchProjectException("No Facade Found");
		} catch (RemoteException re) {
			throw new NoSuchProjectException(re, "Remote Exception caught in findProjectByKey");
		} finally {
			try {
				modelFacade.remove();
			} catch (Exception e) {
			}
		}
	}

	/**
	 * @see TimeSheetActionProcessor#findAllProjects()
	 */
	public ArrayList findAllProjects() throws ModelException {
		TimeSheetActionProcessorFacade modelFacade = null;
		try {
			modelFacade = getTSFacade();
			if (modelFacade != null)
				return modelFacade.findAllProjects();
			else
				throw new ModelException("Could not create Facade");
		} catch (RemoteException re) {
			throw new ModelException(re, "Remote Exception caught");
		} finally {
			try {
				modelFacade.remove();
			} catch (Exception e) {
				AppService.log(TraceCapable.ERROR_LEVEL,"Exception caught trying to remove facade" + e);
			}
		}
	}

	/**
	 * @see TimeSheetActionProcessor#removeProject(String)
	 */
	public void removeProject(String projectId) throws NoSuchProjectException {
		TimeSheetActionProcessorFacade modelFacade = null;
		try {
			modelFacade = getTSFacade();
			if (modelFacade != null)
				modelFacade.removeProject(projectId);
			else
				throw new NoSuchProjectException("No Facade Found");
			// Not really right.  Should throw a ModelException here instead.
		} catch (RemoteException re) {
			throw new NoSuchProjectException(re, "Remote Exception caught in removeProject");
		} finally {
			try {
				modelFacade.remove();
			} catch (Exception e) {
			}
		}
	}

	/**
	 * @see TimeSheetActionProcessor#createTimeSheet(String, String)
	 */
	public TimeSheet createTimeSheet(String empId, String weekEnding)
		throws NoSuchEmployeeException, MappingException, ModelException, DuplicateKeyException {
		TimeSheetActionProcessorFacade modelFacade = null;
		try {
			modelFacade = getTSFacade();
			if (modelFacade != null)
				return modelFacade.createTimeSheet(empId, weekEnding);
			else
				throw new NoSuchEmployeeException("No Facade Found");
		} catch (RemoteException re) {
			throw new NoSuchEmployeeException(re, "Remote Exception caught in createTimeSheet");
		} finally {
			try {
				modelFacade.remove();
			} catch (Exception e) {
			}
		}
	}

	/**
	 * @see TimeSheetActionProcessor#findPendingForEmployee(String)
	 */
	public ArrayList findPendingForEmployee(String empId)
		throws NoSuchEmployeeException, MappingException {
		TimeSheetActionProcessorFacade modelFacade = null;
		try {
			modelFacade = getTSFacade();
			if (modelFacade != null)
				return modelFacade.findPendingForEmployee(empId);
			else
				throw new NoSuchEmployeeException("No Facade Found");
		} catch (RemoteException re) {
			throw new NoSuchEmployeeException(re, "Remote Exception caught in findPendingForEmployee");
		} finally {
			try {
				modelFacade.remove();
			} catch (Exception e) {
			}
		}
	}

	/**
	 * @see TimeSheetActionProcessor#findApprovedForEmployee(String)
	 */
	public ArrayList findApprovedForEmployee(String empId)
		throws NoSuchEmployeeException, MappingException {
		TimeSheetActionProcessorFacade modelFacade = null;
		try {
			modelFacade = getTSFacade();
			if (modelFacade != null)
				return modelFacade.findApprovedForEmployee(empId);
			else
				throw new NoSuchEmployeeException("No Facade found");
		} catch (RemoteException re) {
			throw new NoSuchEmployeeException(re, "Remote Exception caught in findApprovedForEmployee");
		} finally {
			try {
				modelFacade.remove();
			} catch (Exception e) {
			}
		}
	}

	/**
	 * @see TimeSheetActionProcessor#getWeekEndings(String)
	 */
	public WeekEndings getWeekEndings(String empId)
		throws NoSuchEmployeeException, MappingException {
		TimeSheetActionProcessorFacade modelFacade = null;
		try {
			modelFacade = getTSFacade();
			if (modelFacade != null)
				return modelFacade.getWeekEndings(empId);
			throw new NoSuchEmployeeException("No Facade found");
		} catch (RemoteException re) {
			throw new NoSuchEmployeeException(re, "Remote Exception caught in getWeekEndings");
		} finally {
			try {
				modelFacade.remove();
			} catch (Exception e) {
			}
		}
	}

	/**
	 * @see TimeSheetActionProcessor#findEmployeeByKey(String)
	 */
	public Employee findEmployeeByKey(String empId)
		throws NoSuchEmployeeException {
		TimeSheetActionProcessorFacade modelFacade = null;
		try {
			modelFacade = getTSFacade();
			if (modelFacade != null)
				return modelFacade.findEmployeeByKey(empId);
			else
				throw new NoSuchEmployeeException("No Facade Found");
		} catch (RemoteException re) {
			throw new NoSuchEmployeeException(re, "Remote Exception caught in findEmployeeByKey");
		} finally {
			try {
				modelFacade.remove();
			} catch (Exception e) {
				AppService.log(TraceCapable.ERROR_LEVEL,"Exception is " + e);
			}
		}
	}

	/**
	 * @see TimeSheetActionProcessor#findAllEmployees()
	 */
	public ArrayList findAllEmployees() throws ModelException {
		TimeSheetActionProcessorFacade modelFacade = null;
		try {
			modelFacade = getTSFacade();
			if (modelFacade != null)
				return modelFacade.findAllEmployees();
			throw new ModelException("No Facade found");
		} catch (RemoteException re) {
			throw new ModelException(re, "Remote Exception caught in findAllEmployees");
		} finally {
			try {
				modelFacade.remove();
			} catch (Exception e) {
			}
		}
	}

	/**
	 * @see TimeSheetActionProcessor#removeEmployee(String)
	 */
	public void removeEmployee(String empId) throws NoSuchEmployeeException {
		TimeSheetActionProcessorFacade modelFacade = null;
		try {
			modelFacade = getTSFacade();
			if (modelFacade != null)
				modelFacade.removeEmployee(empId);
			else
				throw new NoSuchEmployeeException("No Facade found");
		} catch (RemoteException re) {
			throw new NoSuchEmployeeException(re, "Remote Exception caught in removeEmployee");
		} finally {
			try {
				modelFacade.remove();
			} catch (Exception e) {
			}
		}
	}

	/**
	 * @see TimeSheetActionProcessor#addEmployee(Employee)
	 */
	public void addEmployee(Employee newEmployee) throws MappingException {
		TimeSheetActionProcessorFacade modelFacade = null;
		try {
			modelFacade = getTSFacade();
			if (modelFacade != null)
				modelFacade.addEmployee(newEmployee);
			else
				throw new MappingException("No Facade found");
		} catch (RemoteException re) {
			throw new MappingException(re, "Remote Exception caught");
		} finally {
			try {
				modelFacade.remove();
			} catch (Exception e) {
				AppService.log(TraceCapable.ERROR_LEVEL,"Exception caught in addEmployee:" + e);
			}
		}
	}

	/**
	 * @see TimeSheetActionProcessor#getPendingTimeSheets(String)
	 */
	public TimeSheets getPendingTimeSheets() throws MappingException {
		TimeSheetActionProcessorFacade modelFacade = null;
		try {
			modelFacade = getTSFacade();
			if (modelFacade != null)
				return modelFacade.getPendingTimeSheets();
			throw new MappingException("No Facade Found");
		} catch (RemoteException re) {
			throw new MappingException(re, "Remote Exception caught in getPendingTimeSheets");
		} finally {
			try {
				modelFacade.remove();
			} catch (Exception e) {
			}
		}
	}

	/**
	 * @see TimeSheetActionProcessor#getApprovedTimeSheets(String)
	 */
	public TimeSheets getApprovedTimeSheets() throws MappingException {
		TimeSheetActionProcessorFacade modelFacade = null;
		try {
			modelFacade = getTSFacade();
			if (modelFacade != null)
				return modelFacade.getApprovedTimeSheets();
			throw new MappingException("No Facade Found");
		} catch (RemoteException re) {
			throw new MappingException(re, "Remote Exception caught in getApprovedTimeSheets");
		} finally {
			try {
				modelFacade.remove();
			} catch (Exception e) {
			}
		}
	}

	/**
	 * @see TimeSheetActionProcessor#approveTimeSheetByKey(String, String)
	 */
	public TimeSheet approveTimeSheetByKey(String submitterId, String weekEnding, String approverId) throws ModelException, MappingException {
		TimeSheetActionProcessorFacade modelFacade = null;
		try {
			modelFacade = getTSFacade();
			if (modelFacade != null)
				return modelFacade.approveTimeSheetByKey(submitterId, weekEnding, approverId);
			throw new ModelException("No Facade found");
		} catch (RemoteException re) {
			throw new ModelException(re, "Remote Exception caught");
		} finally {
			try {
				modelFacade.remove();
			} catch (Exception e) {
			}
		}
	}

	/**
	 * @see TimeSheetActionProcessor#updateTimeSheetEntries(TimeSheet, UpdateTSEntryCommand[])
	 */
	public TimeSheet updateTimesheet(UpdateTimesheetFormCommand command)
		throws NoSuchTimeSheetException, ModelException {
		TimeSheetActionProcessorFacade modelFacade = null;
		try {
			modelFacade = getTSFacade();
			if (modelFacade != null)
				return modelFacade.updateTimesheet(command);
			else
				throw new NoSuchTimeSheetException("No Facade Found");
		} catch (RemoteException e) {
			throw new ModelException(e, "Remote Exception caught in updateTimesheet");
		} finally {
			try {
				modelFacade.remove();
			} catch (Exception e) {
			}
		}
	}
	
		
	/**
	 * Method clearInMemoryCaches.
	 */
	public void clearInMemoryCaches() {
		
		TimeSheetActionProcessorFacade modelFacade = null;
		try {
			modelFacade = getTSFacade();
			if (modelFacade != null)
				modelFacade.clearInMemoryCaches();
		} catch (RemoteException re) {
			// Do something here besides logging
			AppService.log(TraceCapable.ERROR_LEVEL,"Remote exception caught in clearInMemoryCaches: " + re);
		} finally {
			try {
				modelFacade.remove();
			} catch (Exception e) {
			}
		}

	}
		

}
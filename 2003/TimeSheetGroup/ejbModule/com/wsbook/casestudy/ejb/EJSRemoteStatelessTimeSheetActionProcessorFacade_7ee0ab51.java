package com.wsbook.casestudy.ejb;

import com.ibm.ejs.container.*;

/**
 * EJSRemoteStatelessTimeSheetActionProcessorFacade_7ee0ab51
 */
public class EJSRemoteStatelessTimeSheetActionProcessorFacade_7ee0ab51 extends EJSWrapper implements TimeSheetActionProcessorFacade {
	/**
	 * EJSRemoteStatelessTimeSheetActionProcessorFacade_7ee0ab51
	 */
	public EJSRemoteStatelessTimeSheetActionProcessorFacade_7ee0ab51() throws java.rmi.RemoteException {
		super();	}
	/**
	 * getDeployedSupport
	 */
	public com.ibm.ejs.container.EJSDeployedSupport getDeployedSupport() {
		return container.getEJSDeployedSupport(this);
	}
	/**
	 * putDeployedSupport
	 */
	public void putDeployedSupport(com.ibm.ejs.container.EJSDeployedSupport support) {
		container.putEJSDeployedSupport(support);
		return;
	}
	/**
	 * findEmployeeByKey
	 */
	public com.wsbook.casestudy.domain.Employee findEmployeeByKey(java.lang.String empId) throws com.wsbook.casestudy.exception.NoSuchEmployeeException, java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		com.wsbook.casestudy.domain.Employee _EJS_result = null;
		try {
			com.wsbook.casestudy.ejb.TimeSheetActionProcessorFacadeBean beanRef = (com.wsbook.casestudy.ejb.TimeSheetActionProcessorFacadeBean)container.preInvoke(this, 0, _EJS_s);
			_EJS_result = beanRef.findEmployeeByKey(empId);
		}
		catch (com.wsbook.casestudy.exception.NoSuchEmployeeException ex) {
			_EJS_s.setCheckedException(ex);
			throw ex;
		}
		catch (java.rmi.RemoteException ex) {
			_EJS_s.setUncheckedException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedException(ex);
			throw new java.rmi.RemoteException("bean method raised unchecked exception", ex);
		}

		finally {
			try{
				container.postInvoke(this, 0, _EJS_s);
			} finally {
				putDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * findProjectByKey
	 */
	public com.wsbook.casestudy.domain.Project findProjectByKey(java.lang.String projectId) throws com.wsbook.casestudy.exception.NoSuchProjectException, java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		com.wsbook.casestudy.domain.Project _EJS_result = null;
		try {
			com.wsbook.casestudy.ejb.TimeSheetActionProcessorFacadeBean beanRef = (com.wsbook.casestudy.ejb.TimeSheetActionProcessorFacadeBean)container.preInvoke(this, 1, _EJS_s);
			_EJS_result = beanRef.findProjectByKey(projectId);
		}
		catch (com.wsbook.casestudy.exception.NoSuchProjectException ex) {
			_EJS_s.setCheckedException(ex);
			throw ex;
		}
		catch (java.rmi.RemoteException ex) {
			_EJS_s.setUncheckedException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedException(ex);
			throw new java.rmi.RemoteException("bean method raised unchecked exception", ex);
		}

		finally {
			try{
				container.postInvoke(this, 1, _EJS_s);
			} finally {
				putDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * findProjectByName
	 */
	public com.wsbook.casestudy.domain.Project findProjectByName(java.lang.String projectName) throws com.wsbook.casestudy.exception.NoSuchProjectException, com.wsbook.casestudy.exception.MappingException, java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		com.wsbook.casestudy.domain.Project _EJS_result = null;
		try {
			com.wsbook.casestudy.ejb.TimeSheetActionProcessorFacadeBean beanRef = (com.wsbook.casestudy.ejb.TimeSheetActionProcessorFacadeBean)container.preInvoke(this, 2, _EJS_s);
			_EJS_result = beanRef.findProjectByName(projectName);
		}
		catch (com.wsbook.casestudy.exception.NoSuchProjectException ex) {
			_EJS_s.setCheckedException(ex);
			throw ex;
		}
		catch (com.wsbook.casestudy.exception.MappingException ex) {
			_EJS_s.setCheckedException(ex);
			throw ex;
		}
		catch (java.rmi.RemoteException ex) {
			_EJS_s.setUncheckedException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedException(ex);
			throw new java.rmi.RemoteException("bean method raised unchecked exception", ex);
		}

		finally {
			try{
				container.postInvoke(this, 2, _EJS_s);
			} finally {
				putDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * approveTimeSheetByKey
	 */
	public com.wsbook.casestudy.domain.TimeSheet approveTimeSheetByKey(java.lang.String submitterId, java.lang.String weekEnding, java.lang.String approverId) throws com.wsbook.casestudy.exception.MappingException, com.wsbook.casestudy.exception.ModelException, java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		com.wsbook.casestudy.domain.TimeSheet _EJS_result = null;
		try {
			com.wsbook.casestudy.ejb.TimeSheetActionProcessorFacadeBean beanRef = (com.wsbook.casestudy.ejb.TimeSheetActionProcessorFacadeBean)container.preInvoke(this, 3, _EJS_s);
			_EJS_result = beanRef.approveTimeSheetByKey(submitterId, weekEnding, approverId);
		}
		catch (com.wsbook.casestudy.exception.MappingException ex) {
			_EJS_s.setCheckedException(ex);
			throw ex;
		}
		catch (com.wsbook.casestudy.exception.ModelException ex) {
			_EJS_s.setCheckedException(ex);
			throw ex;
		}
		catch (java.rmi.RemoteException ex) {
			_EJS_s.setUncheckedException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedException(ex);
			throw new java.rmi.RemoteException("bean method raised unchecked exception", ex);
		}

		finally {
			try{
				container.postInvoke(this, 3, _EJS_s);
			} finally {
				putDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * createTimeSheet
	 */
	public com.wsbook.casestudy.domain.TimeSheet createTimeSheet(java.lang.String empId, java.lang.String weekEnding) throws com.wsbook.casestudy.exception.NoSuchEmployeeException, com.wsbook.casestudy.exception.MappingException, com.wsbook.casestudy.exception.ModelException, java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		com.wsbook.casestudy.domain.TimeSheet _EJS_result = null;
		try {
			com.wsbook.casestudy.ejb.TimeSheetActionProcessorFacadeBean beanRef = (com.wsbook.casestudy.ejb.TimeSheetActionProcessorFacadeBean)container.preInvoke(this, 4, _EJS_s);
			_EJS_result = beanRef.createTimeSheet(empId, weekEnding);
		}
		catch (com.wsbook.casestudy.exception.NoSuchEmployeeException ex) {
			_EJS_s.setCheckedException(ex);
			throw ex;
		}
		catch (com.wsbook.casestudy.exception.MappingException ex) {
			_EJS_s.setCheckedException(ex);
			throw ex;
		}
		catch (com.wsbook.casestudy.exception.ModelException ex) {
			_EJS_s.setCheckedException(ex);
			throw ex;
		}
		catch (java.rmi.RemoteException ex) {
			_EJS_s.setUncheckedException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedException(ex);
			throw new java.rmi.RemoteException("bean method raised unchecked exception", ex);
		}

		finally {
			try{
				container.postInvoke(this, 4, _EJS_s);
			} finally {
				putDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * findOrCreateTimeSheetByKey
	 */
	public com.wsbook.casestudy.domain.TimeSheet findOrCreateTimeSheetByKey(java.lang.String empId, java.lang.String weekEnding) throws com.wsbook.casestudy.exception.NoSuchEmployeeException, com.wsbook.casestudy.exception.MappingException, com.wsbook.casestudy.exception.ModelException, java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		com.wsbook.casestudy.domain.TimeSheet _EJS_result = null;
		try {
			com.wsbook.casestudy.ejb.TimeSheetActionProcessorFacadeBean beanRef = (com.wsbook.casestudy.ejb.TimeSheetActionProcessorFacadeBean)container.preInvoke(this, 5, _EJS_s);
			_EJS_result = beanRef.findOrCreateTimeSheetByKey(empId, weekEnding);
		}
		catch (com.wsbook.casestudy.exception.NoSuchEmployeeException ex) {
			_EJS_s.setCheckedException(ex);
			throw ex;
		}
		catch (com.wsbook.casestudy.exception.MappingException ex) {
			_EJS_s.setCheckedException(ex);
			throw ex;
		}
		catch (com.wsbook.casestudy.exception.ModelException ex) {
			_EJS_s.setCheckedException(ex);
			throw ex;
		}
		catch (java.rmi.RemoteException ex) {
			_EJS_s.setUncheckedException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedException(ex);
			throw new java.rmi.RemoteException("bean method raised unchecked exception", ex);
		}

		finally {
			try{
				container.postInvoke(this, 5, _EJS_s);
			} finally {
				putDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * findTimeSheetByKey
	 */
	public com.wsbook.casestudy.domain.TimeSheet findTimeSheetByKey(java.lang.String empId, java.lang.String weekEnding) throws com.wsbook.casestudy.exception.NoSuchEmployeeException, com.wsbook.casestudy.exception.MappingException, java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		com.wsbook.casestudy.domain.TimeSheet _EJS_result = null;
		try {
			com.wsbook.casestudy.ejb.TimeSheetActionProcessorFacadeBean beanRef = (com.wsbook.casestudy.ejb.TimeSheetActionProcessorFacadeBean)container.preInvoke(this, 6, _EJS_s);
			_EJS_result = beanRef.findTimeSheetByKey(empId, weekEnding);
		}
		catch (com.wsbook.casestudy.exception.NoSuchEmployeeException ex) {
			_EJS_s.setCheckedException(ex);
			throw ex;
		}
		catch (com.wsbook.casestudy.exception.MappingException ex) {
			_EJS_s.setCheckedException(ex);
			throw ex;
		}
		catch (java.rmi.RemoteException ex) {
			_EJS_s.setUncheckedException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedException(ex);
			throw new java.rmi.RemoteException("bean method raised unchecked exception", ex);
		}

		finally {
			try{
				container.postInvoke(this, 6, _EJS_s);
			} finally {
				putDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * updateTimesheet
	 */
	public com.wsbook.casestudy.domain.TimeSheet updateTimesheet(com.wsbook.casestudy.command.UpdateTimesheetFormCommand command) throws com.wsbook.casestudy.exception.ModelException, com.wsbook.casestudy.exception.NoSuchTimeSheetException, java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		com.wsbook.casestudy.domain.TimeSheet _EJS_result = null;
		try {
			com.wsbook.casestudy.ejb.TimeSheetActionProcessorFacadeBean beanRef = (com.wsbook.casestudy.ejb.TimeSheetActionProcessorFacadeBean)container.preInvoke(this, 7, _EJS_s);
			_EJS_result = beanRef.updateTimesheet(command);
		}
		catch (com.wsbook.casestudy.exception.ModelException ex) {
			_EJS_s.setCheckedException(ex);
			throw ex;
		}
		catch (com.wsbook.casestudy.exception.NoSuchTimeSheetException ex) {
			_EJS_s.setCheckedException(ex);
			throw ex;
		}
		catch (java.rmi.RemoteException ex) {
			_EJS_s.setUncheckedException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedException(ex);
			throw new java.rmi.RemoteException("bean method raised unchecked exception", ex);
		}

		finally {
			try{
				container.postInvoke(this, 7, _EJS_s);
			} finally {
				putDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * getApprovedTimeSheets
	 */
	public com.wsbook.casestudy.value.TimeSheets getApprovedTimeSheets() throws com.wsbook.casestudy.exception.MappingException, java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		com.wsbook.casestudy.value.TimeSheets _EJS_result = null;
		try {
			com.wsbook.casestudy.ejb.TimeSheetActionProcessorFacadeBean beanRef = (com.wsbook.casestudy.ejb.TimeSheetActionProcessorFacadeBean)container.preInvoke(this, 8, _EJS_s);
			_EJS_result = beanRef.getApprovedTimeSheets();
		}
		catch (com.wsbook.casestudy.exception.MappingException ex) {
			_EJS_s.setCheckedException(ex);
			throw ex;
		}
		catch (java.rmi.RemoteException ex) {
			_EJS_s.setUncheckedException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedException(ex);
			throw new java.rmi.RemoteException("bean method raised unchecked exception", ex);
		}

		finally {
			try{
				container.postInvoke(this, 8, _EJS_s);
			} finally {
				putDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * getPendingTimeSheets
	 */
	public com.wsbook.casestudy.value.TimeSheets getPendingTimeSheets() throws com.wsbook.casestudy.exception.MappingException, java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		com.wsbook.casestudy.value.TimeSheets _EJS_result = null;
		try {
			com.wsbook.casestudy.ejb.TimeSheetActionProcessorFacadeBean beanRef = (com.wsbook.casestudy.ejb.TimeSheetActionProcessorFacadeBean)container.preInvoke(this, 9, _EJS_s);
			_EJS_result = beanRef.getPendingTimeSheets();
		}
		catch (com.wsbook.casestudy.exception.MappingException ex) {
			_EJS_s.setCheckedException(ex);
			throw ex;
		}
		catch (java.rmi.RemoteException ex) {
			_EJS_s.setUncheckedException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedException(ex);
			throw new java.rmi.RemoteException("bean method raised unchecked exception", ex);
		}

		finally {
			try{
				container.postInvoke(this, 9, _EJS_s);
			} finally {
				putDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * getWeekEndings
	 */
	public com.wsbook.casestudy.value.WeekEndings getWeekEndings(java.lang.String empId) throws com.wsbook.casestudy.exception.NoSuchEmployeeException, com.wsbook.casestudy.exception.MappingException, java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		com.wsbook.casestudy.value.WeekEndings _EJS_result = null;
		try {
			com.wsbook.casestudy.ejb.TimeSheetActionProcessorFacadeBean beanRef = (com.wsbook.casestudy.ejb.TimeSheetActionProcessorFacadeBean)container.preInvoke(this, 10, _EJS_s);
			_EJS_result = beanRef.getWeekEndings(empId);
		}
		catch (com.wsbook.casestudy.exception.NoSuchEmployeeException ex) {
			_EJS_s.setCheckedException(ex);
			throw ex;
		}
		catch (com.wsbook.casestudy.exception.MappingException ex) {
			_EJS_s.setCheckedException(ex);
			throw ex;
		}
		catch (java.rmi.RemoteException ex) {
			_EJS_s.setUncheckedException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedException(ex);
			throw new java.rmi.RemoteException("bean method raised unchecked exception", ex);
		}

		finally {
			try{
				container.postInvoke(this, 10, _EJS_s);
			} finally {
				putDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * findAllEmployees
	 */
	public java.util.ArrayList findAllEmployees() throws com.wsbook.casestudy.exception.ModelException, java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		java.util.ArrayList _EJS_result = null;
		try {
			com.wsbook.casestudy.ejb.TimeSheetActionProcessorFacadeBean beanRef = (com.wsbook.casestudy.ejb.TimeSheetActionProcessorFacadeBean)container.preInvoke(this, 11, _EJS_s);
			_EJS_result = beanRef.findAllEmployees();
		}
		catch (com.wsbook.casestudy.exception.ModelException ex) {
			_EJS_s.setCheckedException(ex);
			throw ex;
		}
		catch (java.rmi.RemoteException ex) {
			_EJS_s.setUncheckedException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedException(ex);
			throw new java.rmi.RemoteException("bean method raised unchecked exception", ex);
		}

		finally {
			try{
				container.postInvoke(this, 11, _EJS_s);
			} finally {
				putDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * findAllProjects
	 */
	public java.util.ArrayList findAllProjects() throws com.wsbook.casestudy.exception.ModelException, java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		java.util.ArrayList _EJS_result = null;
		try {
			com.wsbook.casestudy.ejb.TimeSheetActionProcessorFacadeBean beanRef = (com.wsbook.casestudy.ejb.TimeSheetActionProcessorFacadeBean)container.preInvoke(this, 12, _EJS_s);
			_EJS_result = beanRef.findAllProjects();
		}
		catch (com.wsbook.casestudy.exception.ModelException ex) {
			_EJS_s.setCheckedException(ex);
			throw ex;
		}
		catch (java.rmi.RemoteException ex) {
			_EJS_s.setUncheckedException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedException(ex);
			throw new java.rmi.RemoteException("bean method raised unchecked exception", ex);
		}

		finally {
			try{
				container.postInvoke(this, 12, _EJS_s);
			} finally {
				putDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * findApprovedForEmployee
	 */
	public java.util.ArrayList findApprovedForEmployee(java.lang.String empId) throws com.wsbook.casestudy.exception.NoSuchEmployeeException, com.wsbook.casestudy.exception.MappingException, java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		java.util.ArrayList _EJS_result = null;
		try {
			com.wsbook.casestudy.ejb.TimeSheetActionProcessorFacadeBean beanRef = (com.wsbook.casestudy.ejb.TimeSheetActionProcessorFacadeBean)container.preInvoke(this, 13, _EJS_s);
			_EJS_result = beanRef.findApprovedForEmployee(empId);
		}
		catch (com.wsbook.casestudy.exception.NoSuchEmployeeException ex) {
			_EJS_s.setCheckedException(ex);
			throw ex;
		}
		catch (com.wsbook.casestudy.exception.MappingException ex) {
			_EJS_s.setCheckedException(ex);
			throw ex;
		}
		catch (java.rmi.RemoteException ex) {
			_EJS_s.setUncheckedException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedException(ex);
			throw new java.rmi.RemoteException("bean method raised unchecked exception", ex);
		}

		finally {
			try{
				container.postInvoke(this, 13, _EJS_s);
			} finally {
				putDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * findPendingForEmployee
	 */
	public java.util.ArrayList findPendingForEmployee(java.lang.String empId) throws com.wsbook.casestudy.exception.NoSuchEmployeeException, com.wsbook.casestudy.exception.MappingException, java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		java.util.ArrayList _EJS_result = null;
		try {
			com.wsbook.casestudy.ejb.TimeSheetActionProcessorFacadeBean beanRef = (com.wsbook.casestudy.ejb.TimeSheetActionProcessorFacadeBean)container.preInvoke(this, 14, _EJS_s);
			_EJS_result = beanRef.findPendingForEmployee(empId);
		}
		catch (com.wsbook.casestudy.exception.NoSuchEmployeeException ex) {
			_EJS_s.setCheckedException(ex);
			throw ex;
		}
		catch (com.wsbook.casestudy.exception.MappingException ex) {
			_EJS_s.setCheckedException(ex);
			throw ex;
		}
		catch (java.rmi.RemoteException ex) {
			_EJS_s.setUncheckedException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedException(ex);
			throw new java.rmi.RemoteException("bean method raised unchecked exception", ex);
		}

		finally {
			try{
				container.postInvoke(this, 14, _EJS_s);
			} finally {
				putDeployedSupport(_EJS_s);
			}
		}
		return _EJS_result;
	}
	/**
	 * addEmployee
	 */
	public void addEmployee(com.wsbook.casestudy.domain.Employee newEmployee) throws com.wsbook.casestudy.exception.MappingException, java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		
		try {
			com.wsbook.casestudy.ejb.TimeSheetActionProcessorFacadeBean beanRef = (com.wsbook.casestudy.ejb.TimeSheetActionProcessorFacadeBean)container.preInvoke(this, 15, _EJS_s);
			beanRef.addEmployee(newEmployee);
		}
		catch (com.wsbook.casestudy.exception.MappingException ex) {
			_EJS_s.setCheckedException(ex);
			throw ex;
		}
		catch (java.rmi.RemoteException ex) {
			_EJS_s.setUncheckedException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedException(ex);
			throw new java.rmi.RemoteException("bean method raised unchecked exception", ex);
		}

		finally {
			try{
				container.postInvoke(this, 15, _EJS_s);
			} finally {
				putDeployedSupport(_EJS_s);
			}
		}
		return ;
	}
	/**
	 * addProject
	 */
	public void addProject(com.wsbook.casestudy.domain.Project newProject) throws com.wsbook.casestudy.exception.MappingException, java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		
		try {
			com.wsbook.casestudy.ejb.TimeSheetActionProcessorFacadeBean beanRef = (com.wsbook.casestudy.ejb.TimeSheetActionProcessorFacadeBean)container.preInvoke(this, 16, _EJS_s);
			beanRef.addProject(newProject);
		}
		catch (com.wsbook.casestudy.exception.MappingException ex) {
			_EJS_s.setCheckedException(ex);
			throw ex;
		}
		catch (java.rmi.RemoteException ex) {
			_EJS_s.setUncheckedException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedException(ex);
			throw new java.rmi.RemoteException("bean method raised unchecked exception", ex);
		}

		finally {
			try{
				container.postInvoke(this, 16, _EJS_s);
			} finally {
				putDeployedSupport(_EJS_s);
			}
		}
		return ;
	}
	/**
	 * clearInMemoryCaches
	 */
	public void clearInMemoryCaches() throws java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		
		try {
			com.wsbook.casestudy.ejb.TimeSheetActionProcessorFacadeBean beanRef = (com.wsbook.casestudy.ejb.TimeSheetActionProcessorFacadeBean)container.preInvoke(this, 17, _EJS_s);
			beanRef.clearInMemoryCaches();
		}
		catch (java.rmi.RemoteException ex) {
			_EJS_s.setUncheckedException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedException(ex);
			throw new java.rmi.RemoteException("bean method raised unchecked exception", ex);
		}

		finally {
			try{
				container.postInvoke(this, 17, _EJS_s);
			} finally {
				putDeployedSupport(_EJS_s);
			}
		}
		return ;
	}
	/**
	 * removeEmployee
	 */
	public void removeEmployee(java.lang.String empId) throws com.wsbook.casestudy.exception.NoSuchEmployeeException, java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		
		try {
			com.wsbook.casestudy.ejb.TimeSheetActionProcessorFacadeBean beanRef = (com.wsbook.casestudy.ejb.TimeSheetActionProcessorFacadeBean)container.preInvoke(this, 18, _EJS_s);
			beanRef.removeEmployee(empId);
		}
		catch (com.wsbook.casestudy.exception.NoSuchEmployeeException ex) {
			_EJS_s.setCheckedException(ex);
			throw ex;
		}
		catch (java.rmi.RemoteException ex) {
			_EJS_s.setUncheckedException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedException(ex);
			throw new java.rmi.RemoteException("bean method raised unchecked exception", ex);
		}

		finally {
			try{
				container.postInvoke(this, 18, _EJS_s);
			} finally {
				putDeployedSupport(_EJS_s);
			}
		}
		return ;
	}
	/**
	 * removeProject
	 */
	public void removeProject(java.lang.String projectId) throws com.wsbook.casestudy.exception.NoSuchProjectException, java.rmi.RemoteException {
		EJSDeployedSupport _EJS_s = getDeployedSupport();
		
		try {
			com.wsbook.casestudy.ejb.TimeSheetActionProcessorFacadeBean beanRef = (com.wsbook.casestudy.ejb.TimeSheetActionProcessorFacadeBean)container.preInvoke(this, 19, _EJS_s);
			beanRef.removeProject(projectId);
		}
		catch (com.wsbook.casestudy.exception.NoSuchProjectException ex) {
			_EJS_s.setCheckedException(ex);
			throw ex;
		}
		catch (java.rmi.RemoteException ex) {
			_EJS_s.setUncheckedException(ex);
		}
		catch (Throwable ex) {
			_EJS_s.setUncheckedException(ex);
			throw new java.rmi.RemoteException("bean method raised unchecked exception", ex);
		}

		finally {
			try{
				container.postInvoke(this, 19, _EJS_s);
			} finally {
				putDeployedSupport(_EJS_s);
			}
		}
		return ;
	}
}

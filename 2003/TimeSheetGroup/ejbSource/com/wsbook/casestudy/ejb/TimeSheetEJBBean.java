package com.wsbook.casestudy.ejb;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.ejb.EJBException;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import com.wsbook.casestudy.ejb.helper.OIDGeneratorHelper;

/**
 * Bean implementation class for Enterprise Bean: TimeSheetEJB
 */
public abstract class TimeSheetEJBBean implements javax.ejb.EntityBean {

	private javax.ejb.EntityContext myEntityCtx;
	private static final String OID_TYPE_NAME = "TimeSheetEJB";
	/**
	 * getEntityContext
	 */
	public javax.ejb.EntityContext getEntityContext() {
		return myEntityCtx;
	}
	/**
	 * setEntityContext
	 */
	public void setEntityContext(javax.ejb.EntityContext ctx) {
		myEntityCtx = ctx;
	}
	/**
	 * unsetEntityContext
	 */
	public void unsetEntityContext() {
		myEntityCtx = null;
	}
	/**
	 * ejbActivate
	 */
	public void ejbActivate() {
	}
	/**
	 * ejbCreate method for a CMP entity bean.
	 */
	public com.wsbook.casestudy.ejb.TimeSheetEJBKey ejbCreate(String weekend, String state, EmployeeEJB submitter) throws javax.ejb.CreateException {
		//get next ID
		int tsId = OIDGeneratorHelper.getNextId(OID_TYPE_NAME);
		setTimeSheetId(tsId);
		setWeekend(weekend);
		setState(state);

		return null;
	}
	
	/**
	 * ejbLoad
	 */
	public void ejbLoad() {
	}
	/**
	 * ejbPassivate
	 */
	public void ejbPassivate() {
	}
	/**
	 * ejbPostCreate
	 */
	public void ejbPostCreate(String weekend, String state, EmployeeEJB submitter) throws javax.ejb.CreateException {
		setSubmitter(submitter);
	}
	/**
	 * ejbRemove
	 */
	public void ejbRemove() throws javax.ejb.RemoveException {
	}
	/**
	 * ejbStore
	 */
	public void ejbStore() {
	}
	/**
	 * ejbCreate method for a CMP entity bean.
	 */
	public com.wsbook.casestudy.ejb.TimeSheetEJBKey ejbCreate(
		int timeSheetId,
		EmployeeEJB argSubmitter)
		throws javax.ejb.CreateException {
		setTimeSheetId(timeSheetId);
		return null;
	}
	/**
	 * ejbPostCreate
	 */
	public void ejbPostCreate(
		int timeSheetId,
		EmployeeEJB argSubmitter)
		throws javax.ejb.CreateException {
		setSubmitter(argSubmitter);
	}
	/**
	 * ejbCreate
	 */
	public com.wsbook.casestudy.ejb.TimeSheetEJBKey ejbCreate(int timeSheetId)
		throws javax.ejb.CreateException {
		setTimeSheetId(timeSheetId);
		return null;
	}
	/**
	 * ejbPostCreate
	 */
	public void ejbPostCreate(int timeSheetId)
		throws javax.ejb.CreateException {
	}
	/**
	 * Get accessor for persistent attribute: weekend
	 */
	public abstract java.lang.String getWeekend();
	/**
	 * Set accessor for persistent attribute: weekend
	 */
	public abstract void setWeekend(java.lang.String newWeekend);
	/**
	 * Get accessor for persistent attribute: state
	 */
	public abstract java.lang.String getState();
	/**
	 * Set accessor for persistent attribute: state
	 */
	public abstract void setState(java.lang.String newState);
	/**
	 * Get accessor for persistent attribute: timeSheetId
	 */
	public abstract int getTimeSheetId();
	/**
	 * Set accessor for persistent attribute: timeSheetId
	 */
	public abstract void setTimeSheetId(int newTimeSheetId);
	/**
	 * This method was generated for supporting the relationship role named entries.
	 * It will be deleted/edited when the relationship is deleted/edited.
	 */
	public abstract java.util.Collection getEntries();
	/**
	 * This method was generated for supporting the relationship role named entries.
	 * It will be deleted/edited when the relationship is deleted/edited.
	 */
	public abstract void setEntries(java.util.Collection anEntries);
	/**
	 * This method was generated for supporting the relationship role named submitter.
	 * It will be deleted/edited when the relationship is deleted/edited.
	 */
	public abstract com.wsbook.casestudy.ejb.EmployeeEJB getSubmitter();
	/**
	 * This method was generated for supporting the relationship role named submitter.
	 * It will be deleted/edited when the relationship is deleted/edited.
	 */
	public abstract void setSubmitter(
		com.wsbook.casestudy.ejb.EmployeeEJB aSubmitter);
	/**
	 * This method was generated for supporting the relationship role named approver.
	 * It will be deleted/edited when the relationship is deleted/edited.
	 */
	public abstract com.wsbook.casestudy.ejb.EmployeeEJB getApprover();
	/**
	 * This method was generated for supporting the relationship role named approver.
	 * It will be deleted/edited when the relationship is deleted/edited.
	 */
	public abstract void setApprover(
		com.wsbook.casestudy.ejb.EmployeeEJB anApprover);
	/**
	 * Get accessor for persistent attribute: submitter_empId
	 */
	public abstract java.lang.String getSubmitter_empId();
	/**
	 * Set accessor for persistent attribute: submitter_empId
	 */
	public abstract void setSubmitter_empId(
		java.lang.String newSubmitter_empId);
	/**
	 * Get accessor for persistent attribute: approver_empId
	 */
	public abstract java.lang.String getApprover_empId();
	/**
	 * Set accessor for persistent attribute: approver_empId
	 */
	public abstract void setApprover_empId(java.lang.String newApprover_empId);
}

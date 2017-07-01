package com.wsbook.casestudy.ejb;

import com.wsbook.casestudy.ejb.helper.OIDGeneratorHelper;

/**
 * Bean implementation class for Enterprise Bean: TimeSheetEntryEJB
 */
public abstract class TimeSheetEntryEJBBean implements javax.ejb.EntityBean {

	private javax.ejb.EntityContext myEntityCtx;
	private static final String OID_TYPE_NAME = "TimeSheetEntryEJB";
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
	public TimeSheetEntryEJBKey ejbCreate(
		double hours,
		java.lang.String date,
		ProjectEJB project,
		TimeSheetEJB timesheet)
		throws javax.ejb.CreateException {

		int nextId = OIDGeneratorHelper.getNextId(OID_TYPE_NAME);
		setEntryId(nextId);
		setHours(hours);
		setDate(date);
		return null;
	};
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
	public void ejbPostCreate(
		double hours,
		java.lang.String date,
		ProjectEJB project,
		TimeSheetEJB timesheet) {
		setProject(project);
		setTimesheet(timesheet);

	};
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
	 * ejbCreate
	 */
	public com.wsbook.casestudy.ejb.TimeSheetEntryEJBKey ejbCreate(int entryId)
		throws javax.ejb.CreateException {
		setEntryId(entryId);
		return null;
	}
	/**
	 * ejbPostCreate
	 */
	public void ejbPostCreate(int entryId) throws javax.ejb.CreateException {
	}
	/**
	 * Get accessor for persistent attribute: date
	 */
	public abstract java.lang.String getDate();
	/**
	 * Set accessor for persistent attribute: date
	 */
	public abstract void setDate(java.lang.String newDate);
	/**
	 * Get accessor for persistent attribute: hours
	 */
	public abstract double getHours();
	/**
	 * Set accessor for persistent attribute: hours
	 */
	public abstract void setHours(double newHours);
	/**
	 * Get accessor for persistent attribute: entryId
	 */
	public abstract int getEntryId();
	/**
	 * Set accessor for persistent attribute: entryId
	 */
	public abstract void setEntryId(int newEntryId);
	/**
	 * This method was generated for supporting the relationship role named timesheet.
	 * It will be deleted/edited when the relationship is deleted/edited.
	 */
	public abstract com.wsbook.casestudy.ejb.TimeSheetEJB getTimesheet();
	/**
	 * This method was generated for supporting the relationship role named timesheet.
	 * It will be deleted/edited when the relationship is deleted/edited.
	 */
	public abstract void setTimesheet(
		com.wsbook.casestudy.ejb.TimeSheetEJB aTimesheet);
	/**
	 * This method was generated for supporting the relationship role named project.
	 * It will be deleted/edited when the relationship is deleted/edited.
	 */
	public abstract com.wsbook.casestudy.ejb.ProjectEJB getProject();
	/**
	 * This method was generated for supporting the relationship role named project.
	 * It will be deleted/edited when the relationship is deleted/edited.
	 */
	public abstract void setProject(
		com.wsbook.casestudy.ejb.ProjectEJB aProject);
}

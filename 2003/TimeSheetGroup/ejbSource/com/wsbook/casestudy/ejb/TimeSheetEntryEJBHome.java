package com.wsbook.casestudy.ejb;
/**
 * Local Home interface for Enterprise Bean: TimeSheetEntryEJB
 */
public interface TimeSheetEntryEJBHome extends javax.ejb.EJBLocalHome {
	/**
	 * Creates an instance from a key for Entity Bean: TimeSheetEntryEJB
	 */
	public com.wsbook.casestudy.ejb.TimeSheetEntryEJB create(int entryId)
		throws javax.ejb.CreateException;
	/**
	 * Finds an instance using a key for Entity Bean: TimeSheetEntryEJB
	 */
	public com.wsbook.casestudy.ejb.TimeSheetEntryEJB findByPrimaryKey(
		com.wsbook.casestudy.ejb.TimeSheetEntryEJBKey primaryKey)
		throws javax.ejb.FinderException;
	/**
	* findAll
	*/
	public java.util.Collection findAll() throws javax.ejb.FinderException;
	/**
	 * create
	 */
	public com.wsbook.casestudy.ejb.TimeSheetEntryEJB create(
		double hours,
		java.lang.String date,
		ProjectEJB project,
		TimeSheetEJB timesheet)
		throws javax.ejb.CreateException;
}

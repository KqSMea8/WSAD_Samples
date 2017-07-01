package com.wsbook.casestudy.ejb;
/**
 * Local Home interface for Enterprise Bean: TimeSheetEJB
 */
public interface TimeSheetEJBHome extends javax.ejb.EJBLocalHome {
	/**
	 * Creates an instance from a key for Entity Bean: TimeSheetEJB
	 */
	public com.wsbook.casestudy.ejb.TimeSheetEJB create(int timeSheetId)
		throws javax.ejb.CreateException;
	/**
	 * Finds an instance using a key for Entity Bean: TimeSheetEJB
	 */
	public com.wsbook.casestudy.ejb.TimeSheetEJB findByPrimaryKey(
		com.wsbook.casestudy.ejb.TimeSheetEJBKey primaryKey)
		throws javax.ejb.FinderException;
	/**
				 * findAll
				 */
	public java.util.Collection findAll() throws javax.ejb.FinderException;
	/**
	 * create
	 */
	public com.wsbook.casestudy.ejb.TimeSheetEJB create(
		int timeSheetId,
		EmployeeEJB argSubmitter)
		throws javax.ejb.CreateException;
		
	/**
		 * This method was generated for supporting the association named submitter.
		 * It will be deleted/edited when the association is deleted/edited.
		 */
	public java.util.Collection findTimesheetsBySubmitter(java.lang.String inKey) throws javax.ejb.FinderException;
/**
	 * create
	 */
	public com.wsbook.casestudy.ejb.TimeSheetEJB create(
		java.lang.String weekend,
		java.lang.String state,
		EmployeeEJB submitter)
		throws javax.ejb.CreateException;
	/**
	 * This method was generated for supporting the association named approver.
	 * It will be deleted/edited when the association is deleted/edited.
	 */
	public java.util.Collection findApprovedTimesheetsByApprover(String inKey) throws javax.ejb.FinderException;	public java.util.Collection findPendingByEmployee(java.lang.String empId) throws javax.ejb.FinderException;
}

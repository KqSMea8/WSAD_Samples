package com.wsbook.casestudy.ejb;

import com.ibm.ws.ejbpersistence.beanextensions.*;
import com.ibm.websphere.cpmi.*;
import com.wsbook.casestudy.ejb.websphere_deploy.TimeSheetEntryEJBBeanCacheEntry_f7c19b5d;
import com.wsbook.casestudy.ejb.websphere_deploy.DB2UDBNT_V8_1.TimeSheetEntryEJBBeanCacheEntryImpl_f7c19b5d;

/**
 * Bean implementation class for Enterprise Bean: TimeSheetEntryEJB
 */
public class ConcreteTimeSheetEntryEJB_f7c19b5d extends com.wsbook.casestudy.ejb.TimeSheetEntryEJBBean implements javax.ejb.EntityBean, ConcreteBeanWithLink {
	/**
	 * setEntityContext
	 */
	public void setEntityContext(javax.ejb.EntityContext ctx) {
		super.setEntityContext(ctx);
		instanceExtension.setEntityContext(ctx);
	}
	/**
	 * unsetEntityContext
	 */
	public void unsetEntityContext() {
		super.unsetEntityContext();
		instanceExtension.unsetEntityContext();
	}
	/**
	 * ejbActivate
	 */
	public void ejbActivate() {
			super.ejbActivate();
			instanceExtension.ejbActivate();
	}
	/**
	 * ejbLoad
	 */
	public void ejbLoad() {
		instanceExtension.ejbLoad();
	}
	/**
	 * ejbPassivate
	 */
	public void ejbPassivate() {
		super.ejbPassivate();
		instanceExtension.ejbPassivate();
	}
	/**
	 * ejbRemove
	 */
	public void ejbRemove() throws javax.ejb.RemoveException {
		super.ejbRemove();
		instanceExtension.ejbRemove();
	}
	/**
	 * ejbStore
	 */
	public void ejbStore() {
		super.ejbStore();
		instanceExtension.ejbStore();
	}
	private ConcreteBeanInstanceExtension instanceExtension;
	private TimeSheetEntryEJBBeanCacheEntry_f7c19b5d dataCacheEntry;
	/**
	 * _WSCB_getInstanceInfo
	 */
	public PMConcreteBeanInstanceInfo _WSCB_getInstanceInfo() {
			return instanceExtension;
	}
	/**
	 * ConcreteTimeSheetEntryEJB_f7c19b5d
	 */
	public ConcreteTimeSheetEntryEJB_f7c19b5d() {
		super();
		instanceExtension = ConcreteBeanInstanceExtensionFactory.getInstance(this);
	}
	/**
	 * getInjector
	 */
	private com.wsbook.casestudy.ejb.websphere_deploy.TimeSheetEntryEJBBeanInjector_f7c19b5d getInjector() {
		return (com.wsbook.casestudy.ejb.websphere_deploy.TimeSheetEntryEJBBeanInjector_f7c19b5d)instanceExtension.getInjector();
	}
	/**
	 * hydrate
	 */
	public void hydrate(Object inRecord) {
		dataCacheEntry = (com.wsbook.casestudy.ejb.websphere_deploy.TimeSheetEntryEJBBeanCacheEntry_f7c19b5d) inRecord;;
		timesheetKey = dataCacheEntry.getTimesheetKey();
		projectKey = dataCacheEntry.getProjectKey();
		super.ejbLoad();
	}
	/**
	 * resetCMP
	 */
	public void resetCMP() {
			dataCacheEntry = null;
			timesheetKey = null;
			projectKey = null;
	}
	/**
	 * resetCMR
	 */
	public void resetCMR() {
			timesheetLink = null;
			projectLink = null;
	}
	/**
	 * ejbFindByPrimaryKey
	 */
	public com.wsbook.casestudy.ejb.TimeSheetEntryEJBKey ejbFindByPrimaryKey(com.wsbook.casestudy.ejb.TimeSheetEntryEJBKey primaryKey) throws javax.ejb.FinderException {
		return (com.wsbook.casestudy.ejb.TimeSheetEntryEJBKey)instanceExtension.ejbFindByPrimaryKey(primaryKey);
	}
	/**
	 * ejbFindAll_Local
	 */
	public java.util.Collection ejbFindAll_Local() throws javax.ejb.FinderException {
		return (java.util.Collection) instanceExtension.executeFind("FindAll", null);
	}
	/**
	 * ejbFindByPrimaryKey
	 */
	public Object ejbFindByPrimaryKey(java.lang.Object pk) throws javax.ejb.FinderException {
		return ejbFindByPrimaryKey((com.wsbook.casestudy.ejb.TimeSheetEntryEJBKey)pk);
	}
	/**
	 * ejbFindByPrimaryKeyForCMR_Local
	 */
	public com.wsbook.casestudy.ejb.TimeSheetEntryEJBKey ejbFindByPrimaryKeyForCMR_Local(com.wsbook.casestudy.ejb.TimeSheetEntryEJBKey pk) throws javax.ejb.FinderException {
		return (com.wsbook.casestudy.ejb.TimeSheetEntryEJBKey)instanceExtension.ejbFindByPrimaryKey(pk);
	}
	/**
	 * ejbCreate
	 */
	public com.wsbook.casestudy.ejb.TimeSheetEntryEJBKey ejbCreate(double hours, java.lang.String date, com.wsbook.casestudy.ejb.ProjectEJB project, com.wsbook.casestudy.ejb.TimeSheetEJB timesheet) throws javax.ejb.CreateException {
		dataCacheEntry = new TimeSheetEntryEJBBeanCacheEntryImpl_f7c19b5d();
		 super.ejbCreate(hours, date, project, timesheet);
		return (com.wsbook.casestudy.ejb.TimeSheetEntryEJBKey)instanceExtension.ejbCreate();
	}
	/**
	 * ejbPostCreate
	 */
	public void ejbPostCreate(double hours, java.lang.String date, com.wsbook.casestudy.ejb.ProjectEJB project, com.wsbook.casestudy.ejb.TimeSheetEJB timesheet) {
		super.ejbPostCreate(hours, date, project, timesheet);
		try {
			instanceExtension.ejbPostCreate();
		}
		catch (javax.ejb.CreateException ex) {
			throw new javax.ejb.EJBException(ex);
		}
	}
	/**
	 * ejbCreate
	 */
	public com.wsbook.casestudy.ejb.TimeSheetEntryEJBKey ejbCreate(int entryId) throws javax.ejb.CreateException {
		dataCacheEntry = new TimeSheetEntryEJBBeanCacheEntryImpl_f7c19b5d();
		 super.ejbCreate(entryId);
		return (com.wsbook.casestudy.ejb.TimeSheetEntryEJBKey)instanceExtension.ejbCreate();
	}
	/**
	 * ejbPostCreate
	 */
	public void ejbPostCreate(int entryId) throws javax.ejb.CreateException {
		super.ejbPostCreate(entryId);
		instanceExtension.ejbPostCreate();
	}
	/**
	 * createPrimaryKey
	 */
	public Object createPrimaryKey() {
		com.wsbook.casestudy.ejb.TimeSheetEntryEJBKey pk = new com.wsbook.casestudy.ejb.TimeSheetEntryEJBKey();
		pk.entryId = getEntryId();
		return pk;
	}
	/**
	 * getNumberOfFields
	 */
	public int getNumberOfFields() {
		return 7;
	}
	/**
	 * getLink
	 */
	public com.ibm.ws.ejbpersistence.associations.AssociationLink getLink(java.lang.String name) {
		if (name.equals("timesheet")) return getTimesheetLink();
		if (name.equals("project")) return getProjectLink();
		return null;
	}
	/**
	 * executeFinderForLink
	 */
	public java.lang.Object executeFinderForLink(java.lang.String name, java.lang.Object key) throws javax.ejb.FinderException {
		if (name.equals("timesheet")){
			com.wsbook.casestudy.ejb.websphere_deploy.TimeSheetEJBBeanInternalLocalHome_9e979f5e home = (com.wsbook.casestudy.ejb.websphere_deploy.TimeSheetEJBBeanInternalLocalHome_9e979f5e)instanceExtension.getHomeForLink("timesheet");
		  return home.findByPrimaryKeyForCMR((com.wsbook.casestudy.ejb.TimeSheetEJBKey)key);
		}
		if (name.equals("project")){
			com.wsbook.casestudy.ejb.websphere_deploy.ProjectEJBBeanInternalLocalHome_8ce694f3 home = (com.wsbook.casestudy.ejb.websphere_deploy.ProjectEJBBeanInternalLocalHome_8ce694f3)instanceExtension.getHomeForLink("project");
		  return home.findByPrimaryKeyForCMR((java.lang.String)key);
		}
		return null;
	}
	/**
	 * getTimesheet
	 */
	public com.wsbook.casestudy.ejb.TimeSheetEJB getTimesheet() {
		return (com.wsbook.casestudy.ejb.TimeSheetEJB)getTimesheetLink().getValue();
	}
	/**
	 * setTimesheet
	 */
	public void setTimesheet(com.wsbook.casestudy.ejb.TimeSheetEJB value) {
		getTimesheetLink().setValue(value);
	}
	private com.wsbook.casestudy.ejb.TimeSheetEJBKey timesheetKey;
	/**
	 * getTimesheetKey
	 */
	public com.wsbook.casestudy.ejb.TimeSheetEJBKey getTimesheetKey() {
		if (timesheetLink == null) return timesheetKey;
		return (com.wsbook.casestudy.ejb.TimeSheetEJBKey) timesheetLink.getKey();
	}
	/**
	 * getTimesheetLink
	 */
	private com.ibm.ws.ejbpersistence.associations.AssociationLink getTimesheetLink() {
		if (timesheetLink == null) 
		timesheetLink = instanceExtension.createLink("timesheet",timesheetKey,5);
		return timesheetLink;
	}
	private com.ibm.ws.ejbpersistence.associations.AssociationLink timesheetLink;
	/**
	 * ejbFindEntriesByTimesheetKey_Local
	 */
	public java.util.Collection ejbFindEntriesByTimesheetKey_Local(com.wsbook.casestudy.ejb.TimeSheetEJBKey key) throws javax.ejb.FinderException {
		Object[] result = instanceExtension.getAssociatedKeys("timesheet",key);
		if (result!=null )  return (java.util.Collection) result[0];
		javax.resource.cci.IndexedRecord record = instanceExtension.getInputRecord("findEntriesByTimesheetKey_Local");
		getInjector().findEntriesByTimesheetKey_Local(key, record);
		return (java.util.Collection) instanceExtension.executeFind("findEntriesByTimesheetKey_Local", record);
	}
	/**
	 * getProject
	 */
	public com.wsbook.casestudy.ejb.ProjectEJB getProject() {
		return (com.wsbook.casestudy.ejb.ProjectEJB)getProjectLink().getValue();
	}
	/**
	 * setProject
	 */
	public void setProject(com.wsbook.casestudy.ejb.ProjectEJB value) {
		getProjectLink().setValue(value);
	}
	private java.lang.String projectKey;
	/**
	 * getProjectKey
	 */
	public java.lang.String getProjectKey() {
		if (projectLink == null) return projectKey;
		return (java.lang.String) projectLink.getKey();
	}
	/**
	 * getProjectLink
	 */
	private com.ibm.ws.ejbpersistence.associations.AssociationLink getProjectLink() {
		if (projectLink == null) 
		projectLink = instanceExtension.createLink("project",projectKey,6);
		return projectLink;
	}
	private com.ibm.ws.ejbpersistence.associations.AssociationLink projectLink;
	/**
	 * ejbFindTimesheetentryByProjectKey_Local
	 */
	public java.util.Collection ejbFindTimesheetentryByProjectKey_Local(java.lang.String key) throws javax.ejb.FinderException {
		Object[] result = instanceExtension.getAssociatedKeys("project",key);
		if (result!=null )  return (java.util.Collection) result[0];
		javax.resource.cci.IndexedRecord record = instanceExtension.getInputRecord("findTimesheetentryByProjectKey_Local");
		getInjector().findTimesheetentryByProjectKey_Local(key, record);
		return (java.util.Collection) instanceExtension.executeFind("findTimesheetentryByProjectKey_Local", record);
	}
	/**
	 * Get accessor for persistent attribute: date
	 */
	public java.lang.String getDate() {
		return dataCacheEntry.getDate();
	}
	/**
	 * Set accessor for persistent attribute: date
	 */
	public void setDate(java.lang.String newDate) {
		instanceExtension.markDirty(0,getDate(),newDate);
		dataCacheEntry.setDate(newDate);
	}
	/**
	 * Get accessor for persistent attribute: hours
	 */
	public double getHours() {
		return dataCacheEntry.getHours();
	}
	/**
	 * Set accessor for persistent attribute: hours
	 */
	public void setHours(double newHours) {
		instanceExtension.markDirty(1,getHours(),newHours);
		dataCacheEntry.setHours(newHours);
	}
	/**
	 * Get accessor for persistent attribute: entryId
	 */
	public int getEntryId() {
		return dataCacheEntry.getEntryId();
	}
	/**
	 * Set accessor for persistent attribute: entryId
	 */
	public void setEntryId(int newEntryId) {
		instanceExtension.markDirty(2,getEntryId(),newEntryId);
		dataCacheEntry.setEntryId(newEntryId);
	}
	/**
	 * Get accessor for persistent attribute: timesheet_timeSheetId
	 */
	public java.lang.Integer getTimesheet_timeSheetId() {
		return new java.lang.Integer (dataCacheEntry.getTimesheet_timeSheetId());
	}
	/**
	 * Set accessor for persistent attribute: timesheet_timeSheetId
	 */
	public void setTimesheet_timeSheetId(java.lang.Integer newTimesheet_timeSheetId) {
		instanceExtension.markDirty(3,getTimesheet_timeSheetId(),newTimesheet_timeSheetId);
		dataCacheEntry.setTimesheet_timeSheetId(newTimesheet_timeSheetId.intValue());
	}
	/**
	 * Get accessor for persistent attribute: project_projNumber
	 */
	public java.lang.String getProject_projNumber() {
		return dataCacheEntry.getProject_projNumber();
	}
	/**
	 * Set accessor for persistent attribute: project_projNumber
	 */
	public void setProject_projNumber(java.lang.String newProject_projNumber) {
		instanceExtension.markDirty(4,getProject_projNumber(),newProject_projNumber);
		dataCacheEntry.setProject_projNumber(newProject_projNumber);
	}
}

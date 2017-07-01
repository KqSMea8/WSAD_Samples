package com.wsbook.casestudy.ejb;

import com.ibm.ws.ejbpersistence.beanextensions.*;
import com.ibm.websphere.cpmi.*;
import com.wsbook.casestudy.ejb.websphere_deploy.TimeSheetEJBBeanCacheEntry_9e979f5e;
import com.wsbook.casestudy.ejb.websphere_deploy.DB2UDBNT_V8_1.TimeSheetEJBBeanCacheEntryImpl_9e979f5e;

/**
 * Bean implementation class for Enterprise Bean: TimeSheetEJB
 */
public class ConcreteTimeSheetEJB_9e979f5e extends com.wsbook.casestudy.ejb.TimeSheetEJBBean implements javax.ejb.EntityBean, ConcreteBeanWithLink {
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
	private TimeSheetEJBBeanCacheEntry_9e979f5e dataCacheEntry;
	/**
	 * _WSCB_getInstanceInfo
	 */
	public PMConcreteBeanInstanceInfo _WSCB_getInstanceInfo() {
			return instanceExtension;
	}
	/**
	 * ConcreteTimeSheetEJB_9e979f5e
	 */
	public ConcreteTimeSheetEJB_9e979f5e() {
		super();
		instanceExtension = ConcreteBeanInstanceExtensionFactory.getInstance(this);
	}
	/**
	 * getInjector
	 */
	private com.wsbook.casestudy.ejb.websphere_deploy.TimeSheetEJBBeanInjector_9e979f5e getInjector() {
		return (com.wsbook.casestudy.ejb.websphere_deploy.TimeSheetEJBBeanInjector_9e979f5e)instanceExtension.getInjector();
	}
	/**
	 * hydrate
	 */
	public void hydrate(Object inRecord) {
		dataCacheEntry = (com.wsbook.casestudy.ejb.websphere_deploy.TimeSheetEJBBeanCacheEntry_9e979f5e) inRecord;;
		submitterKey = dataCacheEntry.getSubmitterKey();
		approverKey = dataCacheEntry.getApproverKey();
		super.ejbLoad();
	}
	/**
	 * resetCMP
	 */
	public void resetCMP() {
			dataCacheEntry = null;
			submitterKey = null;
			approverKey = null;
	}
	/**
	 * resetCMR
	 */
	public void resetCMR() {
			entriesLink = null;
			submitterLink = null;
			approverLink = null;
	}
	/**
	 * ejbFindByPrimaryKey
	 */
	public com.wsbook.casestudy.ejb.TimeSheetEJBKey ejbFindByPrimaryKey(com.wsbook.casestudy.ejb.TimeSheetEJBKey primaryKey) throws javax.ejb.FinderException {
		return (com.wsbook.casestudy.ejb.TimeSheetEJBKey)instanceExtension.ejbFindByPrimaryKey(primaryKey);
	}
	/**
	 * ejbFindAll_Local
	 */
	public java.util.Collection ejbFindAll_Local() throws javax.ejb.FinderException {
		return (java.util.Collection) instanceExtension.executeFind("FindAll", null);
	}
	/**
	 * ejbFindApprovedTimesheetsByApprover_Local
	 */
	public java.util.Collection ejbFindApprovedTimesheetsByApprover_Local(java.lang.String inKey) throws javax.ejb.FinderException {
		javax.resource.cci.IndexedRecord record = instanceExtension.getInputRecord("FindApprovedTimesheetsByApprover");
		getInjector().ejbFindApprovedTimesheetsByApprover(inKey, record);
		return (java.util.Collection) instanceExtension.executeFind("FindApprovedTimesheetsByApprover", record);
	}
	/**
	 * ejbFindPendingByEmployee_Local
	 */
	public java.util.Collection ejbFindPendingByEmployee_Local(java.lang.String empId) throws javax.ejb.FinderException {
		javax.resource.cci.IndexedRecord record = instanceExtension.getInputRecord("FindPendingByEmployee");
		getInjector().ejbFindPendingByEmployee(empId, record);
		return (java.util.Collection) instanceExtension.executeFind("FindPendingByEmployee", record);
	}
	/**
	 * ejbFindTimesheetsBySubmitter_Local
	 */
	public java.util.Collection ejbFindTimesheetsBySubmitter_Local(java.lang.String inKey) throws javax.ejb.FinderException {
		javax.resource.cci.IndexedRecord record = instanceExtension.getInputRecord("FindTimesheetsBySubmitter");
		getInjector().ejbFindTimesheetsBySubmitter(inKey, record);
		return (java.util.Collection) instanceExtension.executeFind("FindTimesheetsBySubmitter", record);
	}
	/**
	 * ejbFindByPrimaryKey
	 */
	public Object ejbFindByPrimaryKey(java.lang.Object pk) throws javax.ejb.FinderException {
		return ejbFindByPrimaryKey((com.wsbook.casestudy.ejb.TimeSheetEJBKey)pk);
	}
	/**
	 * ejbFindByPrimaryKeyForCMR_Local
	 */
	public com.wsbook.casestudy.ejb.TimeSheetEJBKey ejbFindByPrimaryKeyForCMR_Local(com.wsbook.casestudy.ejb.TimeSheetEJBKey pk) throws javax.ejb.FinderException {
		return (com.wsbook.casestudy.ejb.TimeSheetEJBKey)instanceExtension.ejbFindByPrimaryKey(pk);
	}
	/**
	 * ejbCreate
	 */
	public com.wsbook.casestudy.ejb.TimeSheetEJBKey ejbCreate(int timeSheetId) throws javax.ejb.CreateException {
		dataCacheEntry = new TimeSheetEJBBeanCacheEntryImpl_9e979f5e();
		 super.ejbCreate(timeSheetId);
		return (com.wsbook.casestudy.ejb.TimeSheetEJBKey)instanceExtension.ejbCreate();
	}
	/**
	 * ejbPostCreate
	 */
	public void ejbPostCreate(int timeSheetId) throws javax.ejb.CreateException {
		super.ejbPostCreate(timeSheetId);
		instanceExtension.ejbPostCreate();
	}
	/**
	 * ejbCreate
	 */
	public com.wsbook.casestudy.ejb.TimeSheetEJBKey ejbCreate(int timeSheetId, com.wsbook.casestudy.ejb.EmployeeEJB argSubmitter) throws javax.ejb.CreateException {
		dataCacheEntry = new TimeSheetEJBBeanCacheEntryImpl_9e979f5e();
		 super.ejbCreate(timeSheetId, argSubmitter);
		return (com.wsbook.casestudy.ejb.TimeSheetEJBKey)instanceExtension.ejbCreate();
	}
	/**
	 * ejbPostCreate
	 */
	public void ejbPostCreate(int timeSheetId, com.wsbook.casestudy.ejb.EmployeeEJB argSubmitter) throws javax.ejb.CreateException {
		super.ejbPostCreate(timeSheetId, argSubmitter);
		instanceExtension.ejbPostCreate();
	}
	/**
	 * ejbCreate
	 */
	public com.wsbook.casestudy.ejb.TimeSheetEJBKey ejbCreate(java.lang.String weekend, java.lang.String state, com.wsbook.casestudy.ejb.EmployeeEJB submitter) throws javax.ejb.CreateException {
		dataCacheEntry = new TimeSheetEJBBeanCacheEntryImpl_9e979f5e();
		 super.ejbCreate(weekend, state, submitter);
		return (com.wsbook.casestudy.ejb.TimeSheetEJBKey)instanceExtension.ejbCreate();
	}
	/**
	 * ejbPostCreate
	 */
	public void ejbPostCreate(java.lang.String weekend, java.lang.String state, com.wsbook.casestudy.ejb.EmployeeEJB submitter) throws javax.ejb.CreateException {
		super.ejbPostCreate(weekend, state, submitter);
		instanceExtension.ejbPostCreate();
	}
	/**
	 * createPrimaryKey
	 */
	public Object createPrimaryKey() {
		com.wsbook.casestudy.ejb.TimeSheetEJBKey pk = new com.wsbook.casestudy.ejb.TimeSheetEJBKey();
		pk.timeSheetId = getTimeSheetId();
		return pk;
	}
	/**
	 * getNumberOfFields
	 */
	public int getNumberOfFields() {
		return 8;
	}
	/**
	 * getLink
	 */
	public com.ibm.ws.ejbpersistence.associations.AssociationLink getLink(java.lang.String name) {
		if (name.equals("entries")) return getEntriesLink();
		if (name.equals("submitter")) return getSubmitterLink();
		if (name.equals("approver")) return getApproverLink();
		return null;
	}
	/**
	 * executeFinderForLink
	 */
	public java.lang.Object executeFinderForLink(java.lang.String name, java.lang.Object key) throws javax.ejb.FinderException {
		if (name.equals("entries")){
			com.wsbook.casestudy.ejb.websphere_deploy.TimeSheetEntryEJBBeanInternalLocalHome_f7c19b5d home = (com.wsbook.casestudy.ejb.websphere_deploy.TimeSheetEntryEJBBeanInternalLocalHome_f7c19b5d)instanceExtension.getHomeForLink("entries");
		  return home.findEntriesByTimesheetKey_Local((com.wsbook.casestudy.ejb.TimeSheetEJBKey)key);
		}
		if (name.equals("submitter")){
			com.wsbook.casestudy.ejb.websphere_deploy.EmployeeEJBBeanInternalLocalHome_96c219b7 home = (com.wsbook.casestudy.ejb.websphere_deploy.EmployeeEJBBeanInternalLocalHome_96c219b7)instanceExtension.getHomeForLink("submitter");
		  return home.findByPrimaryKeyForCMR((java.lang.String)key);
		}
		if (name.equals("approver")){
			com.wsbook.casestudy.ejb.websphere_deploy.EmployeeEJBBeanInternalLocalHome_96c219b7 home = (com.wsbook.casestudy.ejb.websphere_deploy.EmployeeEJBBeanInternalLocalHome_96c219b7)instanceExtension.getHomeForLink("approver");
		  return home.findByPrimaryKeyForCMR((java.lang.String)key);
		}
		return null;
	}
	/**
	 * getEntries
	 */
	public java.util.Collection getEntries() {
		return (java.util.Collection)getEntriesLink().getValue();
	}
	/**
	 * setEntries
	 */
	public void setEntries(java.util.Collection value) {
		getEntriesLink().setValue(value);
	}
	/**
	 * getEntriesLink
	 */
	private com.ibm.ws.ejbpersistence.associations.AssociationLink getEntriesLink() {
		if (entriesLink == null) 
		entriesLink = instanceExtension.createLink("entries",null,5);
		return entriesLink;
	}
	private com.ibm.ws.ejbpersistence.associations.AssociationLink entriesLink;
	/**
	 * ejbFindTimesheetByEntriesKey_Local
	 */
	public com.wsbook.casestudy.ejb.TimeSheetEJBKey ejbFindTimesheetByEntriesKey_Local(com.wsbook.casestudy.ejb.TimeSheetEntryEJBKey key) throws javax.ejb.FinderException {
		Object[] result = instanceExtension.getAssociatedKeys("entries",key);
		if (result!=null )  return (com.wsbook.casestudy.ejb.TimeSheetEJBKey) result[0];
		javax.resource.cci.IndexedRecord record = instanceExtension.getInputRecord("findTimesheetByEntriesKey_Local");
		getInjector().findTimesheetByEntriesKey_Local(key, record);
		return (com.wsbook.casestudy.ejb.TimeSheetEJBKey) instanceExtension.executeFind("findTimesheetByEntriesKey_Local", record);
	}
	/**
	 * getSubmitter
	 */
	public com.wsbook.casestudy.ejb.EmployeeEJB getSubmitter() {
		return (com.wsbook.casestudy.ejb.EmployeeEJB)getSubmitterLink().getValue();
	}
	/**
	 * setSubmitter
	 */
	public void setSubmitter(com.wsbook.casestudy.ejb.EmployeeEJB value) {
		getSubmitterLink().setValue(value);
	}
	private java.lang.String submitterKey;
	/**
	 * getSubmitterKey
	 */
	public java.lang.String getSubmitterKey() {
		if (submitterLink == null) return submitterKey;
		return (java.lang.String) submitterLink.getKey();
	}
	/**
	 * getSubmitterLink
	 */
	private com.ibm.ws.ejbpersistence.associations.AssociationLink getSubmitterLink() {
		if (submitterLink == null) 
		submitterLink = instanceExtension.createLink("submitter",submitterKey,6);
		return submitterLink;
	}
	private com.ibm.ws.ejbpersistence.associations.AssociationLink submitterLink;
	/**
	 * ejbFindTimesheetsBySubmitterKey_Local
	 */
	public java.util.Collection ejbFindTimesheetsBySubmitterKey_Local(java.lang.String key) throws javax.ejb.FinderException {
		Object[] result = instanceExtension.getAssociatedKeys("submitter",key);
		if (result!=null )  return (java.util.Collection) result[0];
		javax.resource.cci.IndexedRecord record = instanceExtension.getInputRecord("findTimesheetsBySubmitterKey_Local");
		getInjector().findTimesheetsBySubmitterKey_Local(key, record);
		return (java.util.Collection) instanceExtension.executeFind("findTimesheetsBySubmitterKey_Local", record);
	}
	/**
	 * getApprover
	 */
	public com.wsbook.casestudy.ejb.EmployeeEJB getApprover() {
		return (com.wsbook.casestudy.ejb.EmployeeEJB)getApproverLink().getValue();
	}
	/**
	 * setApprover
	 */
	public void setApprover(com.wsbook.casestudy.ejb.EmployeeEJB value) {
		getApproverLink().setValue(value);
	}
	private java.lang.String approverKey;
	/**
	 * getApproverKey
	 */
	public java.lang.String getApproverKey() {
		if (approverLink == null) return approverKey;
		return (java.lang.String) approverLink.getKey();
	}
	/**
	 * getApproverLink
	 */
	private com.ibm.ws.ejbpersistence.associations.AssociationLink getApproverLink() {
		if (approverLink == null) 
		approverLink = instanceExtension.createLink("approver",approverKey,7);
		return approverLink;
	}
	private com.ibm.ws.ejbpersistence.associations.AssociationLink approverLink;
	/**
	 * ejbFindApprovedTimesheetsByApproverKey_Local
	 */
	public java.util.Collection ejbFindApprovedTimesheetsByApproverKey_Local(java.lang.String key) throws javax.ejb.FinderException {
		Object[] result = instanceExtension.getAssociatedKeys("approver",key);
		if (result!=null )  return (java.util.Collection) result[0];
		javax.resource.cci.IndexedRecord record = instanceExtension.getInputRecord("findApprovedTimesheetsByApproverKey_Local");
		getInjector().findApprovedTimesheetsByApproverKey_Local(key, record);
		return (java.util.Collection) instanceExtension.executeFind("findApprovedTimesheetsByApproverKey_Local", record);
	}
	/**
	 * Get accessor for persistent attribute: weekend
	 */
	public java.lang.String getWeekend() {
		return dataCacheEntry.getWeekend();
	}
	/**
	 * Set accessor for persistent attribute: weekend
	 */
	public void setWeekend(java.lang.String newWeekend) {
		instanceExtension.markDirty(0,getWeekend(),newWeekend);
		dataCacheEntry.setWeekend(newWeekend);
	}
	/**
	 * Get accessor for persistent attribute: state
	 */
	public java.lang.String getState() {
		return dataCacheEntry.getState();
	}
	/**
	 * Set accessor for persistent attribute: state
	 */
	public void setState(java.lang.String newState) {
		instanceExtension.markDirty(1,getState(),newState);
		dataCacheEntry.setState(newState);
	}
	/**
	 * Get accessor for persistent attribute: timeSheetId
	 */
	public int getTimeSheetId() {
		return dataCacheEntry.getTimeSheetId();
	}
	/**
	 * Set accessor for persistent attribute: timeSheetId
	 */
	public void setTimeSheetId(int newTimeSheetId) {
		instanceExtension.markDirty(2,getTimeSheetId(),newTimeSheetId);
		dataCacheEntry.setTimeSheetId(newTimeSheetId);
	}
	/**
	 * Get accessor for persistent attribute: submitter_empId
	 */
	public java.lang.String getSubmitter_empId() {
		return dataCacheEntry.getSubmitter_empId();
	}
	/**
	 * Set accessor for persistent attribute: submitter_empId
	 */
	public void setSubmitter_empId(java.lang.String newSubmitter_empId) {
		instanceExtension.markDirty(3,getSubmitter_empId(),newSubmitter_empId);
		dataCacheEntry.setSubmitter_empId(newSubmitter_empId);
	}
	/**
	 * Get accessor for persistent attribute: approver_empId
	 */
	public java.lang.String getApprover_empId() {
		return dataCacheEntry.getApprover_empId();
	}
	/**
	 * Set accessor for persistent attribute: approver_empId
	 */
	public void setApprover_empId(java.lang.String newApprover_empId) {
		instanceExtension.markDirty(4,getApprover_empId(),newApprover_empId);
		dataCacheEntry.setApprover_empId(newApprover_empId);
	}
}

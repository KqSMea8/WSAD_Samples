package com.wsbook.casestudy.ejb;

import com.ibm.ws.ejbpersistence.beanextensions.*;
import com.ibm.websphere.cpmi.*;
import com.wsbook.casestudy.ejb.websphere_deploy.ProjectEJBBeanCacheEntry_8ce694f3;
import com.wsbook.casestudy.ejb.websphere_deploy.DB2UDBNT_V8_1.ProjectEJBBeanCacheEntryImpl_8ce694f3;

/**
 * Bean implementation class for Enterprise Bean: ProjectEJB
 */
public class ConcreteProjectEJB_8ce694f3 extends com.wsbook.casestudy.ejb.ProjectEJBBean implements javax.ejb.EntityBean, ConcreteBeanWithLink {
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
	private ProjectEJBBeanCacheEntry_8ce694f3 dataCacheEntry;
	/**
	 * _WSCB_getInstanceInfo
	 */
	public PMConcreteBeanInstanceInfo _WSCB_getInstanceInfo() {
			return instanceExtension;
	}
	/**
	 * ConcreteProjectEJB_8ce694f3
	 */
	public ConcreteProjectEJB_8ce694f3() {
		super();
		instanceExtension = ConcreteBeanInstanceExtensionFactory.getInstance(this);
	}
	/**
	 * getInjector
	 */
	private com.wsbook.casestudy.ejb.websphere_deploy.ProjectEJBBeanInjector_8ce694f3 getInjector() {
		return (com.wsbook.casestudy.ejb.websphere_deploy.ProjectEJBBeanInjector_8ce694f3)instanceExtension.getInjector();
	}
	/**
	 * hydrate
	 */
	public void hydrate(Object inRecord) {
		dataCacheEntry = (com.wsbook.casestudy.ejb.websphere_deploy.ProjectEJBBeanCacheEntry_8ce694f3) inRecord;;
		super.ejbLoad();
	}
	/**
	 * resetCMP
	 */
	public void resetCMP() {
			dataCacheEntry = null;
	}
	/**
	 * resetCMR
	 */
	public void resetCMR() {
			timesheetentryLink = null;
	}
	/**
	 * ejbFindByName_Local
	 */
	public java.lang.String ejbFindByName_Local(java.lang.String name) throws javax.ejb.FinderException {
		javax.resource.cci.IndexedRecord record = instanceExtension.getInputRecord("FindByName");
		getInjector().ejbFindByName(name, record);
		return (java.lang.String) instanceExtension.executeFind("FindByName", record);
	}
	/**
	 * ejbFindByPrimaryKey
	 */
	public java.lang.String ejbFindByPrimaryKey(java.lang.String primaryKey) throws javax.ejb.FinderException {
		return (java.lang.String)instanceExtension.ejbFindByPrimaryKey(primaryKey);
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
		return ejbFindByPrimaryKey((java.lang.String)pk);
	}
	/**
	 * ejbFindByPrimaryKeyForCMR_Local
	 */
	public java.lang.String ejbFindByPrimaryKeyForCMR_Local(java.lang.String pk) throws javax.ejb.FinderException {
		return (java.lang.String)instanceExtension.ejbFindByPrimaryKey(pk);
	}
	/**
	 * ejbCreate
	 */
	public java.lang.String ejbCreate(java.lang.String projNumber) throws javax.ejb.CreateException {
		dataCacheEntry = new ProjectEJBBeanCacheEntryImpl_8ce694f3();
		 super.ejbCreate(projNumber);
		return (java.lang.String)instanceExtension.ejbCreate();
	}
	/**
	 * ejbPostCreate
	 */
	public void ejbPostCreate(java.lang.String projNumber) throws javax.ejb.CreateException {
		super.ejbPostCreate(projNumber);
		instanceExtension.ejbPostCreate();
	}
	/**
	 * ejbCreate
	 */
	public java.lang.String ejbCreate(java.lang.String projNumber, java.lang.String name) throws javax.ejb.CreateException {
		dataCacheEntry = new ProjectEJBBeanCacheEntryImpl_8ce694f3();
		 super.ejbCreate(projNumber, name);
		return (java.lang.String)instanceExtension.ejbCreate();
	}
	/**
	 * ejbPostCreate
	 */
	public void ejbPostCreate(java.lang.String projNumber, java.lang.String name) throws javax.ejb.CreateException {
		super.ejbPostCreate(projNumber, name);
		instanceExtension.ejbPostCreate();
	}
	/**
	 * createPrimaryKey
	 */
	public Object createPrimaryKey() {
		return getProjNumber();
	}
	/**
	 * getNumberOfFields
	 */
	public int getNumberOfFields() {
		return 3;
	}
	/**
	 * getLink
	 */
	public com.ibm.ws.ejbpersistence.associations.AssociationLink getLink(java.lang.String name) {
		if (name.equals("timesheetentry")) return getTimesheetentryLink();
		return null;
	}
	/**
	 * executeFinderForLink
	 */
	public java.lang.Object executeFinderForLink(java.lang.String name, java.lang.Object key) throws javax.ejb.FinderException {
		if (name.equals("timesheetentry")){
			com.wsbook.casestudy.ejb.websphere_deploy.TimeSheetEntryEJBBeanInternalLocalHome_f7c19b5d home = (com.wsbook.casestudy.ejb.websphere_deploy.TimeSheetEntryEJBBeanInternalLocalHome_f7c19b5d)instanceExtension.getHomeForLink("timesheetentry");
		  return home.findTimesheetentryByProjectKey_Local((java.lang.String)key);
		}
		return null;
	}
	/**
	 * getTimesheetentry
	 */
	public java.util.Collection getTimesheetentry() {
		return (java.util.Collection)getTimesheetentryLink().getValue();
	}
	/**
	 * setTimesheetentry
	 */
	public void setTimesheetentry(java.util.Collection value) {
		getTimesheetentryLink().setValue(value);
	}
	/**
	 * getTimesheetentryLink
	 */
	private com.ibm.ws.ejbpersistence.associations.AssociationLink getTimesheetentryLink() {
		if (timesheetentryLink == null) 
		timesheetentryLink = instanceExtension.createLink("timesheetentry",null,2);
		return timesheetentryLink;
	}
	private com.ibm.ws.ejbpersistence.associations.AssociationLink timesheetentryLink;
	/**
	 * ejbFindProjectByTimesheetentryKey_Local
	 */
	public java.lang.String ejbFindProjectByTimesheetentryKey_Local(com.wsbook.casestudy.ejb.TimeSheetEntryEJBKey key) throws javax.ejb.FinderException {
		Object[] result = instanceExtension.getAssociatedKeys("timesheetentry",key);
		if (result!=null )  return (java.lang.String) result[0];
		javax.resource.cci.IndexedRecord record = instanceExtension.getInputRecord("findProjectByTimesheetentryKey_Local");
		getInjector().findProjectByTimesheetentryKey_Local(key, record);
		return (java.lang.String) instanceExtension.executeFind("findProjectByTimesheetentryKey_Local", record);
	}
	/**
	 * Get accessor for persistent attribute: name
	 */
	public java.lang.String getName() {
		return dataCacheEntry.getName();
	}
	/**
	 * Set accessor for persistent attribute: name
	 */
	public void setName(java.lang.String newName) {
		instanceExtension.markDirty(0,getName(),newName);
		dataCacheEntry.setName(newName);
	}
	/**
	 * Get accessor for persistent attribute: projNumber
	 */
	public java.lang.String getProjNumber() {
		return dataCacheEntry.getProjNumber();
	}
	/**
	 * Set accessor for persistent attribute: projNumber
	 */
	public void setProjNumber(java.lang.String newProjNumber) {
		instanceExtension.markDirty(1,getProjNumber(),newProjNumber);
		dataCacheEntry.setProjNumber(newProjNumber);
	}
}

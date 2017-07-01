package com.wsbook.casestudy.ejb;

import com.ibm.ws.ejbpersistence.beanextensions.*;
import com.ibm.websphere.cpmi.*;
import com.wsbook.casestudy.ejb.websphere_deploy.EmployeeEJBBeanCacheEntry_96c219b7;
import com.wsbook.casestudy.ejb.websphere_deploy.DB2UDBNT_V8_1.EmployeeEJBBeanCacheEntryImpl_96c219b7;

/**
 * Bean implementation class for Enterprise Bean: EmployeeEJB
 */
public class ConcreteEmployeeEJB_96c219b7 extends com.wsbook.casestudy.ejb.EmployeeEJBBean implements javax.ejb.EntityBean, ConcreteBeanWithLink {
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
	private EmployeeEJBBeanCacheEntry_96c219b7 dataCacheEntry;
	/**
	 * _WSCB_getInstanceInfo
	 */
	public PMConcreteBeanInstanceInfo _WSCB_getInstanceInfo() {
			return instanceExtension;
	}
	/**
	 * ConcreteEmployeeEJB_96c219b7
	 */
	public ConcreteEmployeeEJB_96c219b7() {
		super();
		instanceExtension = ConcreteBeanInstanceExtensionFactory.getInstance(this);
	}
	/**
	 * getInjector
	 */
	private com.wsbook.casestudy.ejb.websphere_deploy.EmployeeEJBBeanInjector_96c219b7 getInjector() {
		return (com.wsbook.casestudy.ejb.websphere_deploy.EmployeeEJBBeanInjector_96c219b7)instanceExtension.getInjector();
	}
	/**
	 * hydrate
	 */
	public void hydrate(Object inRecord) {
		dataCacheEntry = (com.wsbook.casestudy.ejb.websphere_deploy.EmployeeEJBBeanCacheEntry_96c219b7) inRecord;;
		homeAddressKey = dataCacheEntry.getHomeAddressKey();
		super.ejbLoad();
	}
	/**
	 * resetCMP
	 */
	public void resetCMP() {
			dataCacheEntry = null;
			homeAddressKey = null;
	}
	/**
	 * resetCMR
	 */
	public void resetCMR() {
			homeAddressLink = null;
			timesheetsLink = null;
			approvedTimesheetsLink = null;
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
	public java.lang.String ejbCreate(java.lang.String empId) throws javax.ejb.CreateException {
		dataCacheEntry = new EmployeeEJBBeanCacheEntryImpl_96c219b7();
		 super.ejbCreate(empId);
		return (java.lang.String)instanceExtension.ejbCreate();
	}
	/**
	 * ejbPostCreate
	 */
	public void ejbPostCreate(java.lang.String empId) throws javax.ejb.CreateException {
		super.ejbPostCreate(empId);
		instanceExtension.ejbPostCreate();
	}
	/**
	 * ejbCreate
	 */
	public java.lang.String ejbCreate(java.lang.String empId, java.lang.String name) throws javax.ejb.CreateException {
		dataCacheEntry = new EmployeeEJBBeanCacheEntryImpl_96c219b7();
		 super.ejbCreate(empId, name);
		return (java.lang.String)instanceExtension.ejbCreate();
	}
	/**
	 * ejbPostCreate
	 */
	public void ejbPostCreate(java.lang.String empId, java.lang.String name) throws javax.ejb.CreateException {
		super.ejbPostCreate(empId, name);
		instanceExtension.ejbPostCreate();
	}
	/**
	 * createPrimaryKey
	 */
	public Object createPrimaryKey() {
		return getEmpId();
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
		if (name.equals("homeAddress")) return getHomeAddressLink();
		if (name.equals("timesheets")) return getTimesheetsLink();
		if (name.equals("approvedTimesheets")) return getApprovedTimesheetsLink();
		return null;
	}
	/**
	 * executeFinderForLink
	 */
	public java.lang.Object executeFinderForLink(java.lang.String name, java.lang.Object key) throws javax.ejb.FinderException {
		if (name.equals("homeAddress")){
			com.wsbook.casestudy.ejb.websphere_deploy.AddressEJBBeanInternalLocalHome_7a46140f home = (com.wsbook.casestudy.ejb.websphere_deploy.AddressEJBBeanInternalLocalHome_7a46140f)instanceExtension.getHomeForLink("homeAddress");
		  return home.findByPrimaryKeyForCMR((com.wsbook.casestudy.ejb.AddressEJBKey)key);
		}
		if (name.equals("timesheets")){
			com.wsbook.casestudy.ejb.websphere_deploy.TimeSheetEJBBeanInternalLocalHome_9e979f5e home = (com.wsbook.casestudy.ejb.websphere_deploy.TimeSheetEJBBeanInternalLocalHome_9e979f5e)instanceExtension.getHomeForLink("timesheets");
		  return home.findTimesheetsBySubmitterKey_Local((java.lang.String)key);
		}
		if (name.equals("approvedTimesheets")){
			com.wsbook.casestudy.ejb.websphere_deploy.TimeSheetEJBBeanInternalLocalHome_9e979f5e home = (com.wsbook.casestudy.ejb.websphere_deploy.TimeSheetEJBBeanInternalLocalHome_9e979f5e)instanceExtension.getHomeForLink("approvedTimesheets");
		  return home.findApprovedTimesheetsByApproverKey_Local((java.lang.String)key);
		}
		return null;
	}
	/**
	 * getHomeAddress
	 */
	public com.wsbook.casestudy.ejb.AddressEJB getHomeAddress() {
		return (com.wsbook.casestudy.ejb.AddressEJB)getHomeAddressLink().getValue();
	}
	/**
	 * setHomeAddress
	 */
	public void setHomeAddress(com.wsbook.casestudy.ejb.AddressEJB value) {
		getHomeAddressLink().setValue(value);
	}
	private com.wsbook.casestudy.ejb.AddressEJBKey homeAddressKey;
	/**
	 * getHomeAddressKey
	 */
	public com.wsbook.casestudy.ejb.AddressEJBKey getHomeAddressKey() {
		if (homeAddressLink == null) return homeAddressKey;
		return (com.wsbook.casestudy.ejb.AddressEJBKey) homeAddressLink.getKey();
	}
	/**
	 * getHomeAddressLink
	 */
	private com.ibm.ws.ejbpersistence.associations.AssociationLink getHomeAddressLink() {
		if (homeAddressLink == null) 
		homeAddressLink = instanceExtension.createLink("homeAddress",homeAddressKey,4);
		return homeAddressLink;
	}
	private com.ibm.ws.ejbpersistence.associations.AssociationLink homeAddressLink;
	/**
	 * ejbFindEmployeeByHomeAddressKey_Local
	 */
	public java.lang.String ejbFindEmployeeByHomeAddressKey_Local(com.wsbook.casestudy.ejb.AddressEJBKey key) throws javax.ejb.FinderException {
		Object[] result = instanceExtension.getAssociatedKeys("homeAddress",key);
		if (result!=null )  return (java.lang.String) result[0];
		javax.resource.cci.IndexedRecord record = instanceExtension.getInputRecord("findEmployeeByHomeAddressKey_Local");
		getInjector().findEmployeeByHomeAddressKey_Local(key, record);
		return (java.lang.String) instanceExtension.executeFind("findEmployeeByHomeAddressKey_Local", record);
	}
	/**
	 * getTimesheets
	 */
	public java.util.Collection getTimesheets() {
		return (java.util.Collection)getTimesheetsLink().getValue();
	}
	/**
	 * setTimesheets
	 */
	public void setTimesheets(java.util.Collection value) {
		getTimesheetsLink().setValue(value);
	}
	/**
	 * getTimesheetsLink
	 */
	private com.ibm.ws.ejbpersistence.associations.AssociationLink getTimesheetsLink() {
		if (timesheetsLink == null) 
		timesheetsLink = instanceExtension.createLink("timesheets",null,5);
		return timesheetsLink;
	}
	private com.ibm.ws.ejbpersistence.associations.AssociationLink timesheetsLink;
	/**
	 * ejbFindSubmitterByTimesheetsKey_Local
	 */
	public java.lang.String ejbFindSubmitterByTimesheetsKey_Local(com.wsbook.casestudy.ejb.TimeSheetEJBKey key) throws javax.ejb.FinderException {
		Object[] result = instanceExtension.getAssociatedKeys("timesheets",key);
		if (result!=null )  return (java.lang.String) result[0];
		javax.resource.cci.IndexedRecord record = instanceExtension.getInputRecord("findSubmitterByTimesheetsKey_Local");
		getInjector().findSubmitterByTimesheetsKey_Local(key, record);
		return (java.lang.String) instanceExtension.executeFind("findSubmitterByTimesheetsKey_Local", record);
	}
	/**
	 * getApprovedTimesheets
	 */
	public java.util.Collection getApprovedTimesheets() {
		return (java.util.Collection)getApprovedTimesheetsLink().getValue();
	}
	/**
	 * setApprovedTimesheets
	 */
	public void setApprovedTimesheets(java.util.Collection value) {
		getApprovedTimesheetsLink().setValue(value);
	}
	/**
	 * getApprovedTimesheetsLink
	 */
	private com.ibm.ws.ejbpersistence.associations.AssociationLink getApprovedTimesheetsLink() {
		if (approvedTimesheetsLink == null) 
		approvedTimesheetsLink = instanceExtension.createLink("approvedTimesheets",null,6);
		return approvedTimesheetsLink;
	}
	private com.ibm.ws.ejbpersistence.associations.AssociationLink approvedTimesheetsLink;
	/**
	 * ejbFindApproverByApprovedTimesheetsKey_Local
	 */
	public java.lang.String ejbFindApproverByApprovedTimesheetsKey_Local(com.wsbook.casestudy.ejb.TimeSheetEJBKey key) throws javax.ejb.FinderException {
		Object[] result = instanceExtension.getAssociatedKeys("approvedTimesheets",key);
		if (result!=null )  return (java.lang.String) result[0];
		javax.resource.cci.IndexedRecord record = instanceExtension.getInputRecord("findApproverByApprovedTimesheetsKey_Local");
		getInjector().findApproverByApprovedTimesheetsKey_Local(key, record);
		return (java.lang.String) instanceExtension.executeFind("findApproverByApprovedTimesheetsKey_Local", record);
	}
	/**
	 * Get accessor for persistent attribute: empId
	 */
	public java.lang.String getEmpId() {
		return dataCacheEntry.getEmpId();
	}
	/**
	 * Set accessor for persistent attribute: empId
	 */
	public void setEmpId(java.lang.String newEmpId) {
		instanceExtension.markDirty(0,getEmpId(),newEmpId);
		dataCacheEntry.setEmpId(newEmpId);
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
		instanceExtension.markDirty(1,getName(),newName);
		dataCacheEntry.setName(newName);
	}
	/**
	 * Get accessor for persistent attribute: office
	 */
	public com.wsbook.casestudy.ejb.OfficeLocation getOffice() {
		return dataCacheEntry.getOffice();
	}
	/**
	 * Set accessor for persistent attribute: office
	 */
	public void setOffice(com.wsbook.casestudy.ejb.OfficeLocation newOffice) {
		instanceExtension.markDirty(2,getOffice(),newOffice);
		dataCacheEntry.setOffice(newOffice);
	}
	/**
	 * Get accessor for persistent attribute: homeAddress_addressKey
	 */
	public java.lang.Integer getHomeAddress_addressKey() {
		return new java.lang.Integer (dataCacheEntry.getHomeAddress_addressKey());
	}
	/**
	 * Set accessor for persistent attribute: homeAddress_addressKey
	 */
	public void setHomeAddress_addressKey(java.lang.Integer newHomeAddress_addressKey) {
		instanceExtension.markDirty(3,getHomeAddress_addressKey(),newHomeAddress_addressKey);
		dataCacheEntry.setHomeAddress_addressKey(newHomeAddress_addressKey.intValue());
	}
}

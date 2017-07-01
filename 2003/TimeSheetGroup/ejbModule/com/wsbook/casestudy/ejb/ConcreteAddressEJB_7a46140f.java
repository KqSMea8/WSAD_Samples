package com.wsbook.casestudy.ejb;

import com.ibm.ws.ejbpersistence.beanextensions.*;
import com.ibm.websphere.cpmi.*;
import com.wsbook.casestudy.ejb.websphere_deploy.AddressEJBBeanCacheEntry_7a46140f;
import com.wsbook.casestudy.ejb.websphere_deploy.DB2UDBNT_V8_1.AddressEJBBeanCacheEntryImpl_7a46140f;

/**
 * Bean implementation class for Enterprise Bean: AddressEJB
 */
public class ConcreteAddressEJB_7a46140f extends com.wsbook.casestudy.ejb.AddressEJBBean implements javax.ejb.EntityBean, ConcreteBeanWithLink {
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
	private AddressEJBBeanCacheEntry_7a46140f dataCacheEntry;
	/**
	 * _WSCB_getInstanceInfo
	 */
	public PMConcreteBeanInstanceInfo _WSCB_getInstanceInfo() {
			return instanceExtension;
	}
	/**
	 * ConcreteAddressEJB_7a46140f
	 */
	public ConcreteAddressEJB_7a46140f() {
		super();
		instanceExtension = ConcreteBeanInstanceExtensionFactory.getInstance(this);
	}
	/**
	 * getInjector
	 */
	private com.wsbook.casestudy.ejb.websphere_deploy.AddressEJBBeanInjector_7a46140f getInjector() {
		return (com.wsbook.casestudy.ejb.websphere_deploy.AddressEJBBeanInjector_7a46140f)instanceExtension.getInjector();
	}
	/**
	 * hydrate
	 */
	public void hydrate(Object inRecord) {
		dataCacheEntry = (com.wsbook.casestudy.ejb.websphere_deploy.AddressEJBBeanCacheEntry_7a46140f) inRecord;;
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
			employeeLink = null;
	}
	/**
	 * ejbFindByPrimaryKey
	 */
	public com.wsbook.casestudy.ejb.AddressEJBKey ejbFindByPrimaryKey(com.wsbook.casestudy.ejb.AddressEJBKey primaryKey) throws javax.ejb.FinderException {
		return (com.wsbook.casestudy.ejb.AddressEJBKey)instanceExtension.ejbFindByPrimaryKey(primaryKey);
	}
	/**
	 * ejbFindByPrimaryKey
	 */
	public Object ejbFindByPrimaryKey(java.lang.Object pk) throws javax.ejb.FinderException {
		return ejbFindByPrimaryKey((com.wsbook.casestudy.ejb.AddressEJBKey)pk);
	}
	/**
	 * ejbFindByPrimaryKeyForCMR_Local
	 */
	public com.wsbook.casestudy.ejb.AddressEJBKey ejbFindByPrimaryKeyForCMR_Local(com.wsbook.casestudy.ejb.AddressEJBKey pk) throws javax.ejb.FinderException {
		return (com.wsbook.casestudy.ejb.AddressEJBKey)instanceExtension.ejbFindByPrimaryKey(pk);
	}
	/**
	 * ejbCreate
	 */
	public com.wsbook.casestudy.ejb.AddressEJBKey ejbCreate(int addressKey) throws javax.ejb.CreateException {
		dataCacheEntry = new AddressEJBBeanCacheEntryImpl_7a46140f();
		 super.ejbCreate(addressKey);
		return (com.wsbook.casestudy.ejb.AddressEJBKey)instanceExtension.ejbCreate();
	}
	/**
	 * ejbPostCreate
	 */
	public void ejbPostCreate(int addressKey) throws javax.ejb.CreateException {
		super.ejbPostCreate(addressKey);
		instanceExtension.ejbPostCreate();
	}
	/**
	 * createPrimaryKey
	 */
	public Object createPrimaryKey() {
		com.wsbook.casestudy.ejb.AddressEJBKey pk = new com.wsbook.casestudy.ejb.AddressEJBKey();
		pk.addressKey = getAddressKey();
		return pk;
	}
	/**
	 * getNumberOfFields
	 */
	public int getNumberOfFields() {
		return 6;
	}
	/**
	 * getLink
	 */
	public com.ibm.ws.ejbpersistence.associations.AssociationLink getLink(java.lang.String name) {
		if (name.equals("employee")) return getEmployeeLink();
		return null;
	}
	/**
	 * executeFinderForLink
	 */
	public java.lang.Object executeFinderForLink(java.lang.String name, java.lang.Object key) throws javax.ejb.FinderException {
		if (name.equals("employee")){
			com.wsbook.casestudy.ejb.websphere_deploy.EmployeeEJBBeanInternalLocalHome_96c219b7 home = (com.wsbook.casestudy.ejb.websphere_deploy.EmployeeEJBBeanInternalLocalHome_96c219b7)instanceExtension.getHomeForLink("employee");
		  return home.findEmployeeByHomeAddressKey_Local((com.wsbook.casestudy.ejb.AddressEJBKey)key);
		}
		return null;
	}
	/**
	 * getEmployee
	 */
	public com.wsbook.casestudy.ejb.EmployeeEJB getEmployee() {
		return (com.wsbook.casestudy.ejb.EmployeeEJB)getEmployeeLink().getValue();
	}
	/**
	 * setEmployee
	 */
	public void setEmployee(com.wsbook.casestudy.ejb.EmployeeEJB value) {
		getEmployeeLink().setValue(value);
	}
	/**
	 * getEmployeeLink
	 */
	private com.ibm.ws.ejbpersistence.associations.AssociationLink getEmployeeLink() {
		if (employeeLink == null) 
		employeeLink = instanceExtension.createLink("employee",null,5);
		return employeeLink;
	}
	private com.ibm.ws.ejbpersistence.associations.AssociationLink employeeLink;
	/**
	 * ejbFindHomeAddressByEmployeeKey_Local
	 */
	public com.wsbook.casestudy.ejb.AddressEJBKey ejbFindHomeAddressByEmployeeKey_Local(java.lang.String key) throws javax.ejb.FinderException {
		Object[] result = instanceExtension.getAssociatedKeys("employee",key);
		if (result!=null )  return (com.wsbook.casestudy.ejb.AddressEJBKey) result[0];
		javax.resource.cci.IndexedRecord record = instanceExtension.getInputRecord("findHomeAddressByEmployeeKey_Local");
		getInjector().findHomeAddressByEmployeeKey_Local(key, record);
		return (com.wsbook.casestudy.ejb.AddressEJBKey) instanceExtension.executeFind("findHomeAddressByEmployeeKey_Local", record);
	}
	/**
	 * Get accessor for persistent attribute: city
	 */
	public java.lang.String getCity() {
		return dataCacheEntry.getCity();
	}
	/**
	 * Set accessor for persistent attribute: city
	 */
	public void setCity(java.lang.String newCity) {
		instanceExtension.markDirty(0,getCity(),newCity);
		dataCacheEntry.setCity(newCity);
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
	 * Get accessor for persistent attribute: streetAddress
	 */
	public java.lang.String getStreetAddress() {
		return dataCacheEntry.getStreetAddress();
	}
	/**
	 * Set accessor for persistent attribute: streetAddress
	 */
	public void setStreetAddress(java.lang.String newStreetAddress) {
		instanceExtension.markDirty(2,getStreetAddress(),newStreetAddress);
		dataCacheEntry.setStreetAddress(newStreetAddress);
	}
	/**
	 * Get accessor for persistent attribute: zipCode
	 */
	public java.lang.String getZipCode() {
		return dataCacheEntry.getZipCode();
	}
	/**
	 * Set accessor for persistent attribute: zipCode
	 */
	public void setZipCode(java.lang.String newZipCode) {
		instanceExtension.markDirty(3,getZipCode(),newZipCode);
		dataCacheEntry.setZipCode(newZipCode);
	}
	/**
	 * Get accessor for persistent attribute: addressKey
	 */
	public int getAddressKey() {
		return dataCacheEntry.getAddressKey();
	}
	/**
	 * Set accessor for persistent attribute: addressKey
	 */
	public void setAddressKey(int newAddressKey) {
		instanceExtension.markDirty(4,getAddressKey(),newAddressKey);
		dataCacheEntry.setAddressKey(newAddressKey);
	}
}

package com.wsbook.casestudy.ejb;

import com.ibm.ws.ejbpersistence.beanextensions.*;
import com.ibm.websphere.cpmi.*;
import com.wsbook.casestudy.ejb.websphere_deploy.DepartmentEJBBeanCacheEntry_6d23b983;
import com.wsbook.casestudy.ejb.websphere_deploy.DB2UDBNT_V8_1.DepartmentEJBBeanCacheEntryImpl_6d23b983;

/**
 * Bean implementation class for Enterprise Bean: DepartmentEJB
 */
public class ConcreteDepartmentEJB_6d23b983 extends com.wsbook.casestudy.ejb.DepartmentEJBBean implements javax.ejb.EntityBean, ConcreteBean {
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
	private DepartmentEJBBeanCacheEntry_6d23b983 dataCacheEntry;
	/**
	 * _WSCB_getInstanceInfo
	 */
	public PMConcreteBeanInstanceInfo _WSCB_getInstanceInfo() {
			return instanceExtension;
	}
	/**
	 * ConcreteDepartmentEJB_6d23b983
	 */
	public ConcreteDepartmentEJB_6d23b983() {
		super();
		instanceExtension = ConcreteBeanInstanceExtensionFactory.getInstance(this);
	}
	/**
	 * getInjector
	 */
	private com.wsbook.casestudy.ejb.websphere_deploy.DepartmentEJBBeanInjector_6d23b983 getInjector() {
		return (com.wsbook.casestudy.ejb.websphere_deploy.DepartmentEJBBeanInjector_6d23b983)instanceExtension.getInjector();
	}
	/**
	 * hydrate
	 */
	public void hydrate(Object inRecord) {
		dataCacheEntry = (com.wsbook.casestudy.ejb.websphere_deploy.DepartmentEJBBeanCacheEntry_6d23b983) inRecord;;
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
	}
	/**
	 * ejbFindByPrimaryKey
	 */
	public com.wsbook.casestudy.ejb.DepartmentEJBKey ejbFindByPrimaryKey(com.wsbook.casestudy.ejb.DepartmentEJBKey primaryKey) throws javax.ejb.FinderException {
		return (com.wsbook.casestudy.ejb.DepartmentEJBKey)instanceExtension.ejbFindByPrimaryKey(primaryKey);
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
		return ejbFindByPrimaryKey((com.wsbook.casestudy.ejb.DepartmentEJBKey)pk);
	}
	/**
	 * ejbFindByPrimaryKeyForCMR_Local
	 */
	public com.wsbook.casestudy.ejb.DepartmentEJBKey ejbFindByPrimaryKeyForCMR_Local(com.wsbook.casestudy.ejb.DepartmentEJBKey pk) throws javax.ejb.FinderException {
		return (com.wsbook.casestudy.ejb.DepartmentEJBKey)instanceExtension.ejbFindByPrimaryKey(pk);
	}
	/**
	 * ejbCreate
	 */
	public com.wsbook.casestudy.ejb.DepartmentEJBKey ejbCreate(int deptNumber) throws javax.ejb.CreateException {
		dataCacheEntry = new DepartmentEJBBeanCacheEntryImpl_6d23b983();
		 super.ejbCreate(deptNumber);
		return (com.wsbook.casestudy.ejb.DepartmentEJBKey)instanceExtension.ejbCreate();
	}
	/**
	 * ejbPostCreate
	 */
	public void ejbPostCreate(int deptNumber) throws javax.ejb.CreateException {
		super.ejbPostCreate(deptNumber);
		instanceExtension.ejbPostCreate();
	}
	/**
	 * ejbCreate
	 */
	public com.wsbook.casestudy.ejb.DepartmentEJBKey ejbCreate(int deptNumber, java.lang.String name) throws javax.ejb.CreateException {
		dataCacheEntry = new DepartmentEJBBeanCacheEntryImpl_6d23b983();
		 super.ejbCreate(deptNumber, name);
		return (com.wsbook.casestudy.ejb.DepartmentEJBKey)instanceExtension.ejbCreate();
	}
	/**
	 * ejbPostCreate
	 */
	public void ejbPostCreate(int deptNumber, java.lang.String name) throws javax.ejb.CreateException {
		super.ejbPostCreate(deptNumber, name);
		instanceExtension.ejbPostCreate();
	}
	/**
	 * createPrimaryKey
	 */
	public Object createPrimaryKey() {
		com.wsbook.casestudy.ejb.DepartmentEJBKey pk = new com.wsbook.casestudy.ejb.DepartmentEJBKey();
		pk.deptNumber = getDeptNumber();
		return pk;
	}
	/**
	 * getNumberOfFields
	 */
	public int getNumberOfFields() {
		return 2;
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
	 * Get accessor for persistent attribute: deptNumber
	 */
	public int getDeptNumber() {
		return dataCacheEntry.getDeptNumber();
	}
	/**
	 * Set accessor for persistent attribute: deptNumber
	 */
	public void setDeptNumber(int newDeptNumber) {
		instanceExtension.markDirty(1,getDeptNumber(),newDeptNumber);
		dataCacheEntry.setDeptNumber(newDeptNumber);
	}
}

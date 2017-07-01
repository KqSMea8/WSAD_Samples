package com.wsbook.casestudy.ejb.websphere_deploy.DB2UDBNT_V8_1;

/**
 * EmployeeEJBBeanCacheEntryImpl_96c219b7
 */
public class EmployeeEJBBeanCacheEntryImpl_96c219b7 extends com.ibm.ws.ejbpersistence.cache.DataCacheEntry implements com.wsbook.casestudy.ejb.websphere_deploy.EmployeeEJBBeanCacheEntry_96c219b7 {
	/**
	 * getOffice
	 */
	public com.wsbook.casestudy.ejb.OfficeLocation getOffice() {
		Object[] tempComposerObjArray = new Object[4];
		tempComposerObjArray[0] = STATE_Data;
		tempComposerObjArray[1] = CITY_Data;
		tempComposerObjArray[2] = BUILDING_Data;
		tempComposerObjArray[3] = OFFICE_Data;
		Object tempComposerObj = com.wsbook.casestudy.ejb.OfficeLocationComposer.singleton().objectFrom(tempComposerObjArray);
		return  tempComposerObj == null ? null : (com.wsbook.casestudy.ejb.OfficeLocation) tempComposerObj;
	}
	/**
	 * setOffice
	 */
	public void setOffice(com.wsbook.casestudy.ejb.OfficeLocation data) {
		Object[] tempComposerArray_office;
		tempComposerArray_office = com.wsbook.casestudy.ejb.OfficeLocationComposer.singleton().dataFrom(data);
		this.STATE_Data=(String)(tempComposerArray_office[0]);
		this.CITY_Data=(String)(tempComposerArray_office[1]);
		this.BUILDING_Data=(String)(tempComposerArray_office[2]);
		this.OFFICE_Data=(String)(tempComposerArray_office[3]);
	}
	/**
	 * getEmpId
	 */
	public java.lang.String getEmpId() {
		return EMPID_Data;
	}
	/**
	 * setEmpId
	 */
	public void setEmpId(String data) {
		this.EMPID_Data=data;
	}
	/**
	 * setDataForEMPID
	 */
	public void setDataForEMPID(String data) {
		this.EMPID_Data=data;
	}
	private String EMPID_Data;
	/**
	 * getName
	 */
	public java.lang.String getName() {
		return NAME_Data;
	}
	/**
	 * setName
	 */
	public void setName(String data) {
		this.NAME_Data=data;
	}
	/**
	 * setDataForNAME
	 */
	public void setDataForNAME(String data) {
		this.NAME_Data=data;
	}
	private String NAME_Data;
	/**
	 * setDataForSTATE
	 */
	public void setDataForSTATE(String data) {
		this.STATE_Data=data;
	}
	private String STATE_Data;
	/**
	 * setDataForCITY
	 */
	public void setDataForCITY(String data) {
		this.CITY_Data=data;
	}
	private String CITY_Data;
	/**
	 * setDataForBUILDING
	 */
	public void setDataForBUILDING(String data) {
		this.BUILDING_Data=data;
	}
	private String BUILDING_Data;
	/**
	 * setDataForOFFICE
	 */
	public void setDataForOFFICE(String data) {
		this.OFFICE_Data=data;
	}
	private String OFFICE_Data;
	/**
	 * getHomeAddress_addressKey
	 */
	public int getHomeAddress_addressKey() {
		return HOMEADDRESS_ADDRESSKEY_Data;
	}
	/**
	 * setHomeAddress_addressKey
	 */
	public void setHomeAddress_addressKey(int data) {
		this.HOMEADDRESS_ADDRESSKEY_Data=data;
	}
	/**
	 * setDataForHOMEADDRESS_ADDRESSKEY
	 */
	public void setDataForHOMEADDRESS_ADDRESSKEY(int data, boolean isNull) {
		this.HOMEADDRESS_ADDRESSKEY_Data=data;
		this.HOMEADDRESS_ADDRESSKEY_IsNull=isNull;
	}
	private int HOMEADDRESS_ADDRESSKEY_Data;
	private boolean HOMEADDRESS_ADDRESSKEY_IsNull = true;
	/**
	 * getHomeAddressKey
	 */
	public com.wsbook.casestudy.ejb.AddressEJBKey getHomeAddressKey() {
		if(HOMEADDRESS_ADDRESSKEY_IsNull)
			return null;
		com.wsbook.casestudy.ejb.AddressEJBKey key=new com.wsbook.casestudy.ejb.AddressEJBKey();
		key.addressKey=HOMEADDRESS_ADDRESSKEY_Data;
		return key;
	}
	/**
	 * getForeignKey
	 */
	public Object getForeignKey(String role) {
		if(role.equals("homeAddress"))
			return getHomeAddressKey();
		else
			return null;
	}
}

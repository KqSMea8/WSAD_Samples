package com.wsbook.casestudy.ejb.websphere_deploy.DB2UDBNT_V8_1;

/**
 * AddressEJBBeanExtractor_7a46140f
 */
public class AddressEJBBeanExtractor_7a46140f extends com.ibm.ws.ejbpersistence.dataaccess.AbstractEJBExtractor {
	/**
	 * AddressEJBBeanExtractor_7a46140f
	 */
	public AddressEJBBeanExtractor_7a46140f() {
		int[] pkCols={5};
		setPrimaryKeyColumns(pkCols);

		int[] dataCols={1,2,3,4,5};
		setDataColumns(dataCols);
	}
	/**
	 * extractData
	 */
	public com.ibm.ws.ejbpersistence.cache.DataCacheEntry extractData(com.ibm.ws.ejbpersistence.dataaccess.RawBeanData dataRow) throws com.ibm.ws.ejbpersistence.utilpm.ErrorProcessingResultCollectionRow, com.ibm.ws.ejbpersistence.utilpm.PersistenceManagerInternalError {
		int[] dataColumns = getDataColumns();

		com.wsbook.casestudy.ejb.websphere_deploy.DB2UDBNT_V8_1.AddressEJBBeanCacheEntryImpl_7a46140f entry=
			new com.wsbook.casestudy.ejb.websphere_deploy.DB2UDBNT_V8_1.AddressEJBBeanCacheEntryImpl_7a46140f();

		entry.setDataForCITY(dataRow.getString(dataColumns[0]));
		entry.setDataForSTATE1(dataRow.getString(dataColumns[1]));
		entry.setDataForSTREETADDRESS(dataRow.getString(dataColumns[2]));
		entry.setDataForZIPCODE(dataRow.getString(dataColumns[3]));
		entry.setDataForADDRESSKEY(dataRow.getInt(dataColumns[4]));

		return entry;
	}
	/**
	 * extractPrimaryKey
	 */
	public Object extractPrimaryKey(com.ibm.ws.ejbpersistence.dataaccess.RawBeanData dataRow) throws com.ibm.ws.ejbpersistence.utilpm.ErrorProcessingResultCollectionRow, com.ibm.ws.ejbpersistence.utilpm.PersistenceManagerInternalError {
		int[] primaryKeyColumns = getPrimaryKeyColumns();

		com.wsbook.casestudy.ejb.AddressEJBKey key=
			new com.wsbook.casestudy.ejb.AddressEJBKey();

		key.addressKey=dataRow.getInt(primaryKeyColumns[0]);

		return key;
	}
	/**
	 * getHomeName
	 */
	public String getHomeName() {
		return "AddressEJB";
	}
	/**
	 * getChunkLength
	 */
	public int getChunkLength() {
		return 5;
	}
}

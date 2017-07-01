package com.wsbook.casestudy.ejb.websphere_deploy.DB2UDBNT_V8_1;

/**
 * EmployeeEJBBeanExtractor_96c219b7
 */
public class EmployeeEJBBeanExtractor_96c219b7 extends com.ibm.ws.ejbpersistence.dataaccess.AbstractEJBExtractor {
	/**
	 * EmployeeEJBBeanExtractor_96c219b7
	 */
	public EmployeeEJBBeanExtractor_96c219b7() {
		int[] pkCols={1};
		setPrimaryKeyColumns(pkCols);

		int[] dataCols={1,2,3,4,5,6,7};
		setDataColumns(dataCols);
	}
	/**
	 * extractData
	 */
	public com.ibm.ws.ejbpersistence.cache.DataCacheEntry extractData(com.ibm.ws.ejbpersistence.dataaccess.RawBeanData dataRow) throws com.ibm.ws.ejbpersistence.utilpm.ErrorProcessingResultCollectionRow, com.ibm.ws.ejbpersistence.utilpm.PersistenceManagerInternalError {
		int[] dataColumns = getDataColumns();

		com.wsbook.casestudy.ejb.websphere_deploy.DB2UDBNT_V8_1.EmployeeEJBBeanCacheEntryImpl_96c219b7 entry=
			new com.wsbook.casestudy.ejb.websphere_deploy.DB2UDBNT_V8_1.EmployeeEJBBeanCacheEntryImpl_96c219b7();

		entry.setDataForEMPID(dataRow.getString(dataColumns[0]));
		entry.setDataForNAME(dataRow.getString(dataColumns[1]));
		entry.setDataForSTATE(dataRow.getString(dataColumns[2]));
		entry.setDataForCITY(dataRow.getString(dataColumns[3]));
		entry.setDataForBUILDING(dataRow.getString(dataColumns[4]));
		entry.setDataForOFFICE(dataRow.getString(dataColumns[5]));
		entry.setDataForHOMEADDRESS_ADDRESSKEY(dataRow.getInt(dataColumns[6]), dataRow.wasNull());

		return entry;
	}
	/**
	 * extractPrimaryKey
	 */
	public Object extractPrimaryKey(com.ibm.ws.ejbpersistence.dataaccess.RawBeanData dataRow) throws com.ibm.ws.ejbpersistence.utilpm.ErrorProcessingResultCollectionRow, com.ibm.ws.ejbpersistence.utilpm.PersistenceManagerInternalError {
		int[] primaryKeyColumns = getPrimaryKeyColumns();

		java.lang.String key;
		key=dataRow.getString(primaryKeyColumns[0]);

		return key;
	}
	/**
	 * getHomeName
	 */
	public String getHomeName() {
		return "EmployeeEJB";
	}
	/**
	 * getChunkLength
	 */
	public int getChunkLength() {
		return 4;
	}
}

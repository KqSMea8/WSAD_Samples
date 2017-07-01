package com.wsbook.casestudy.ejb.websphere_deploy.DB2UDBNT_V8_1;

/**
 * TimeSheetEJBBeanExtractor_9e979f5e
 */
public class TimeSheetEJBBeanExtractor_9e979f5e extends com.ibm.ws.ejbpersistence.dataaccess.AbstractEJBExtractor {
	/**
	 * TimeSheetEJBBeanExtractor_9e979f5e
	 */
	public TimeSheetEJBBeanExtractor_9e979f5e() {
		int[] pkCols={3};
		setPrimaryKeyColumns(pkCols);

		int[] dataCols={1,2,3,4,5};
		setDataColumns(dataCols);
	}
	/**
	 * extractData
	 */
	public com.ibm.ws.ejbpersistence.cache.DataCacheEntry extractData(com.ibm.ws.ejbpersistence.dataaccess.RawBeanData dataRow) throws com.ibm.ws.ejbpersistence.utilpm.ErrorProcessingResultCollectionRow, com.ibm.ws.ejbpersistence.utilpm.PersistenceManagerInternalError {
		int[] dataColumns = getDataColumns();

		com.wsbook.casestudy.ejb.websphere_deploy.DB2UDBNT_V8_1.TimeSheetEJBBeanCacheEntryImpl_9e979f5e entry=
			new com.wsbook.casestudy.ejb.websphere_deploy.DB2UDBNT_V8_1.TimeSheetEJBBeanCacheEntryImpl_9e979f5e();

		entry.setDataForWEEKEND(dataRow.getString(dataColumns[0]));
		entry.setDataForSTATE1(dataRow.getString(dataColumns[1]));
		entry.setDataForTIMESHEETID(dataRow.getInt(dataColumns[2]));
		entry.setDataForSUBMITTER_EMPID(dataRow.getString(dataColumns[3]));
		entry.setDataForAPPROVER_EMPID(dataRow.getString(dataColumns[4]));

		return entry;
	}
	/**
	 * extractPrimaryKey
	 */
	public Object extractPrimaryKey(com.ibm.ws.ejbpersistence.dataaccess.RawBeanData dataRow) throws com.ibm.ws.ejbpersistence.utilpm.ErrorProcessingResultCollectionRow, com.ibm.ws.ejbpersistence.utilpm.PersistenceManagerInternalError {
		int[] primaryKeyColumns = getPrimaryKeyColumns();

		com.wsbook.casestudy.ejb.TimeSheetEJBKey key=
			new com.wsbook.casestudy.ejb.TimeSheetEJBKey();

		key.timeSheetId=dataRow.getInt(primaryKeyColumns[0]);

		return key;
	}
	/**
	 * getHomeName
	 */
	public String getHomeName() {
		return "TimeSheetEJB";
	}
	/**
	 * getChunkLength
	 */
	public int getChunkLength() {
		return 5;
	}
}

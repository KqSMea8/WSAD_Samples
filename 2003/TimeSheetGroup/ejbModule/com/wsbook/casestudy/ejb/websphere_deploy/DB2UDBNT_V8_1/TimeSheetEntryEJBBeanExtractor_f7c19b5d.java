package com.wsbook.casestudy.ejb.websphere_deploy.DB2UDBNT_V8_1;

/**
 * TimeSheetEntryEJBBeanExtractor_f7c19b5d
 */
public class TimeSheetEntryEJBBeanExtractor_f7c19b5d extends com.ibm.ws.ejbpersistence.dataaccess.AbstractEJBExtractor {
	/**
	 * TimeSheetEntryEJBBeanExtractor_f7c19b5d
	 */
	public TimeSheetEntryEJBBeanExtractor_f7c19b5d() {
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

		com.wsbook.casestudy.ejb.websphere_deploy.DB2UDBNT_V8_1.TimeSheetEntryEJBBeanCacheEntryImpl_f7c19b5d entry=
			new com.wsbook.casestudy.ejb.websphere_deploy.DB2UDBNT_V8_1.TimeSheetEntryEJBBeanCacheEntryImpl_f7c19b5d();

		entry.setDataForDATE1(dataRow.getString(dataColumns[0]));
		entry.setDataForHOURS1(dataRow.getDouble(dataColumns[1]));
		entry.setDataForENTRYID(dataRow.getInt(dataColumns[2]));
		entry.setDataForTIMESHEET_TIMESHEETID(dataRow.getInt(dataColumns[3]), dataRow.wasNull());
		entry.setDataForPROJECT_PROJNUMBER(dataRow.getString(dataColumns[4]));

		return entry;
	}
	/**
	 * extractPrimaryKey
	 */
	public Object extractPrimaryKey(com.ibm.ws.ejbpersistence.dataaccess.RawBeanData dataRow) throws com.ibm.ws.ejbpersistence.utilpm.ErrorProcessingResultCollectionRow, com.ibm.ws.ejbpersistence.utilpm.PersistenceManagerInternalError {
		int[] primaryKeyColumns = getPrimaryKeyColumns();

		com.wsbook.casestudy.ejb.TimeSheetEntryEJBKey key=
			new com.wsbook.casestudy.ejb.TimeSheetEntryEJBKey();

		key.entryId=dataRow.getInt(primaryKeyColumns[0]);

		return key;
	}
	/**
	 * getHomeName
	 */
	public String getHomeName() {
		return "TimeSheetEntryEJB";
	}
	/**
	 * getChunkLength
	 */
	public int getChunkLength() {
		return 5;
	}
}

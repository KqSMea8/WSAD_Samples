package com.wsbook.casestudy.ejb.websphere_deploy.DB2UDBNT_V8_1;

/**
 * ProjectEJBBeanExtractor_8ce694f3
 */
public class ProjectEJBBeanExtractor_8ce694f3 extends com.ibm.ws.ejbpersistence.dataaccess.AbstractEJBExtractor {
	/**
	 * ProjectEJBBeanExtractor_8ce694f3
	 */
	public ProjectEJBBeanExtractor_8ce694f3() {
		int[] pkCols={2};
		setPrimaryKeyColumns(pkCols);

		int[] dataCols={1,2};
		setDataColumns(dataCols);
	}
	/**
	 * extractData
	 */
	public com.ibm.ws.ejbpersistence.cache.DataCacheEntry extractData(com.ibm.ws.ejbpersistence.dataaccess.RawBeanData dataRow) throws com.ibm.ws.ejbpersistence.utilpm.ErrorProcessingResultCollectionRow, com.ibm.ws.ejbpersistence.utilpm.PersistenceManagerInternalError {
		int[] dataColumns = getDataColumns();

		com.wsbook.casestudy.ejb.websphere_deploy.DB2UDBNT_V8_1.ProjectEJBBeanCacheEntryImpl_8ce694f3 entry=
			new com.wsbook.casestudy.ejb.websphere_deploy.DB2UDBNT_V8_1.ProjectEJBBeanCacheEntryImpl_8ce694f3();

		entry.setDataForNAME(dataRow.getString(dataColumns[0]));
		entry.setDataForPROJNUMBER(dataRow.getString(dataColumns[1]));

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
		return "ProjectEJB";
	}
	/**
	 * getChunkLength
	 */
	public int getChunkLength() {
		return 2;
	}
}

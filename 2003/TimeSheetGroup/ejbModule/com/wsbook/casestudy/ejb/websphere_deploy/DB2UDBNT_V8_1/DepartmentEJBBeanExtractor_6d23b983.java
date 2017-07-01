package com.wsbook.casestudy.ejb.websphere_deploy.DB2UDBNT_V8_1;

/**
 * DepartmentEJBBeanExtractor_6d23b983
 */
public class DepartmentEJBBeanExtractor_6d23b983 extends com.ibm.ws.ejbpersistence.dataaccess.AbstractEJBExtractor {
	/**
	 * DepartmentEJBBeanExtractor_6d23b983
	 */
	public DepartmentEJBBeanExtractor_6d23b983() {
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

		com.wsbook.casestudy.ejb.websphere_deploy.DB2UDBNT_V8_1.DepartmentEJBBeanCacheEntryImpl_6d23b983 entry=
			new com.wsbook.casestudy.ejb.websphere_deploy.DB2UDBNT_V8_1.DepartmentEJBBeanCacheEntryImpl_6d23b983();

		entry.setDataForNAME(dataRow.getString(dataColumns[0]));
		entry.setDataForDEPTNUMBER(dataRow.getInt(dataColumns[1]));

		return entry;
	}
	/**
	 * extractPrimaryKey
	 */
	public Object extractPrimaryKey(com.ibm.ws.ejbpersistence.dataaccess.RawBeanData dataRow) throws com.ibm.ws.ejbpersistence.utilpm.ErrorProcessingResultCollectionRow, com.ibm.ws.ejbpersistence.utilpm.PersistenceManagerInternalError {
		int[] primaryKeyColumns = getPrimaryKeyColumns();

		com.wsbook.casestudy.ejb.DepartmentEJBKey key=
			new com.wsbook.casestudy.ejb.DepartmentEJBKey();

		key.deptNumber=dataRow.getInt(primaryKeyColumns[0]);

		return key;
	}
	/**
	 * getHomeName
	 */
	public String getHomeName() {
		return "DepartmentEJB";
	}
	/**
	 * getChunkLength
	 */
	public int getChunkLength() {
		return 2;
	}
}

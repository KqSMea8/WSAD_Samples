package com.wsbook.casestudy.ejb.websphere_deploy.DB2UDBNT_V8_1;

/**
 * TimeSheetEntryEJBBeanAdaptorBinding_f7c19b5d
 */
public class TimeSheetEntryEJBBeanAdaptorBinding_f7c19b5d implements com.ibm.ws.ejbpersistence.beanextensions.BeanAdaptorBinding {
	/**
	 * getExtractor
	 */
	public com.ibm.ws.ejbpersistence.dataaccess.EJBExtractor getExtractor() {
		// extractor for com.wsbook.casestudy.ejb.websphere_deploy.DB2UDBNT_V8_1.TimeSheetEntryEJBBeanExtractor_f7c19b5d
		com.ibm.ws.ejbpersistence.dataaccess.AbstractEJBExtractor extractor =  new com.wsbook.casestudy.ejb.websphere_deploy.DB2UDBNT_V8_1.TimeSheetEntryEJBBeanExtractor_f7c19b5d();
		extractor.setPrimaryKeyColumns(new int[] {3});
		extractor.setDataColumns(new int[] {1,2,3,4,5});
		return extractor;
	}
	/**
	 * getInjector
	 */
	public com.ibm.ws.ejbpersistence.beanextensions.EJBInjector getInjector() {
		return new com.wsbook.casestudy.ejb.websphere_deploy.DB2UDBNT_V8_1.TimeSheetEntryEJBBeanInjectorImpl_f7c19b5d();
	}
	/**
	 * getAdapter
	 */
	public com.ibm.websphere.ejbpersistence.EJBToRAAdapter getAdapter() {
		return com.ibm.ws.rsadapter.cci.WSRelationalRAAdapter.createAdapter();
	}
	/**
	 * getMetadata
	 */
	public Object[] getMetadata() {
		
		java.lang.String[] primarykey, subhomes, composedObjs, composedObjImpls;
		com.ibm.ObjectQuery.metadata.OSQLExternalCatalogEntry[] cat;
		com.ibm.ObjectQuery.metadata.OSQLExternalColumnDef[] fields;
		cat = new com.ibm.ObjectQuery.metadata.OSQLExternalCatalogEntry[4];
		//-------------------------------------------------------------------------
		cat[0] = new com.ibm.ObjectQuery.metadata.OSQLExternalCatalogRDBAlias("TimeSheetEntryEJB", "TimeSheetEntryEJB1_Alias", "DB2NT", "TIMESHEETENTRYEJB", "TimeSheetEntryEJB_TimeSheetEntryEJB1_Table");

		//-------------------------------------------------------------------------
		fields = new com.ibm.ObjectQuery.metadata.OSQLExternalColumnDef[5];

		fields[0] = new com.ibm.ObjectQuery.metadata.OSQLExternalColumnDef("DATE1", new String(), com.ibm.ObjectQuery.engine.OSQLSymbols._CHARACTER, 250, com.ibm.ObjectQuery.engine.OSQLConstants.NO_TYPE, false, 0, -1, 0);
		fields[1] = new com.ibm.ObjectQuery.metadata.OSQLExternalColumnDef("HOURS1", new String(), com.ibm.ObjectQuery.engine.OSQLSymbols.OOSQL_DOUBLE, 0, com.ibm.ObjectQuery.engine.OSQLConstants.NO_TYPE, true, 0, -1, 0);
		fields[2] = new com.ibm.ObjectQuery.metadata.OSQLExternalColumnDef("ENTRYID", new String(), com.ibm.ObjectQuery.engine.OSQLSymbols._INTEGER, 0, com.ibm.ObjectQuery.engine.OSQLConstants.NO_TYPE, true, 0, -1, 0);
		fields[3] = new com.ibm.ObjectQuery.metadata.OSQLExternalColumnDef("TIMESHEET_TIMESHEETID", new String(), com.ibm.ObjectQuery.engine.OSQLSymbols._INTEGER, 0, com.ibm.ObjectQuery.engine.OSQLConstants.NO_TYPE, false, 0, -1, 0);
		fields[4] = new com.ibm.ObjectQuery.metadata.OSQLExternalColumnDef("PROJECT_PROJNUMBER", new String(), com.ibm.ObjectQuery.engine.OSQLSymbols._CHARACTER, 250, com.ibm.ObjectQuery.engine.OSQLConstants.NO_TYPE, false, 0, -1, 0);
		primarykey = new String[1];
		primarykey[0] = "ENTRYID";
		cat[1] = new com.ibm.ObjectQuery.metadata.OSQLExternalCatalogType("TimeSheetEntryEJB", "TimeSheetEntryEJB1_Table", null, fields, primarykey);

		//-------------------------------------------------------------------------
		fields = new com.ibm.ObjectQuery.metadata.OSQLExternalColumnDef[5];

		fields[0] = new com.ibm.ObjectQuery.metadata.OSQLExternalColumnDef("date", new String(), com.ibm.ObjectQuery.engine.OSQLSymbols._CHARACTER, 0, com.ibm.ObjectQuery.engine.OSQLConstants.NO_TYPE, false, 0, -1, 0);
		fields[1] = new com.ibm.ObjectQuery.metadata.OSQLExternalColumnDef("hours", new String(), com.ibm.ObjectQuery.engine.OSQLSymbols.OOSQL_DOUBLE, 0, com.ibm.ObjectQuery.engine.OSQLConstants.NO_TYPE, false, 0, -1, 0);
		fields[2] = new com.ibm.ObjectQuery.metadata.OSQLExternalColumnDef("entryId", new String(), com.ibm.ObjectQuery.engine.OSQLSymbols._INTEGER, 0, com.ibm.ObjectQuery.engine.OSQLConstants.NO_TYPE, false, 0, -1, 0);
		fields[3] = new com.ibm.ObjectQuery.metadata.OSQLExternalColumnDef("timesheet", "TimeSheetEJB", com.ibm.ObjectQuery.engine.OSQLSymbols.OOSQL_TABLE, 0, com.ibm.ObjectQuery.engine.OSQLConstants.NO_TYPE, false, 0, -1, com.ibm.ObjectQuery.engine.OSQLSymbols.SQL_BO);
		fields[4] = new com.ibm.ObjectQuery.metadata.OSQLExternalColumnDef("project", "ProjectEJB", com.ibm.ObjectQuery.engine.OSQLSymbols.OOSQL_TABLE, 0, com.ibm.ObjectQuery.engine.OSQLConstants.NO_TYPE, false, 0, -1, com.ibm.ObjectQuery.engine.OSQLSymbols.SQL_BO);
		primarykey = new String[1];
		primarykey[0] = "entryId";
		cat[2] = new com.ibm.ObjectQuery.metadata.OSQLExternalCatalogType("TimeSheetEntryEJB", "TimeSheetEntryEJB_BO", "com.wsbook.casestudy.ejb.TimeSheetEntryEJBBean", fields, primarykey);

		//-------------------------------------------------------------------------
		composedObjs = null;
		composedObjImpls = null;
		subhomes = null;
		cat[3] = new com.ibm.ObjectQuery.metadata.OSQLExternalCatalogView("TimeSheetEntryEJB", "TimeSheetEntryEJB_TimeSheetEntryEJB_BO", "TimeSheetEntryEJB_TimeSheetEntryEJB1_Alias", composedObjs, composedObjImpls, 
		"select t1.DATE1,t1.HOURS1,t1.ENTRYID,(select t2 from TimeSheetEJB_TimeSheetEJB1_Alias t2 where t2.TIMESHEETID = t1.TIMESHEET_TIMESHEETID),(select t3 from ProjectEJB_ProjectEJB1_Alias t3 where t3.PROJNUMBER = t1.PROJECT_PROJNUMBER) from _this t1", 
		null, subhomes, 
		0, null);



		return cat;
	}
	/**
	 * createDataAccessSpecs
	 */
	public java.util.Collection createDataAccessSpecs() throws javax.resource.ResourceException {
		com.ibm.ws.ejbpersistence.beanextensions.EJBDataAccessSpec daSpec;
		com.ibm.ws.rsadapter.cci.WSInteractionSpecImpl iSpec;
		java.util.Collection result = new java.util.ArrayList(12);

		daSpec=com.ibm.ws.ejbpersistence.beanextensions.DataAccessSpecFactory.getDataAccessSpec();
		iSpec=new com.ibm.ws.rsadapter.cci.WSInteractionSpecImpl();
		iSpec.setFunctionSetName("com.wsbook.casestudy.ejb.websphere_deploy.DB2UDBNT_V8_1.TimeSheetEntryEJBBeanFunctionSet_f7c19b5d");
		iSpec.setFunctionName("Create");
		daSpec.setInteractionSpec(iSpec);
		daSpec.setSpecName("Create");
		daSpec.setInputRecordName("Create");
		daSpec.setOptimistic(false);
		daSpec.setType(com.ibm.ws.ejbpersistence.beanextensions.EJBDataAccessSpec.CREATE_BEAN);
		daSpec.setQueryScope(new String[]{"TimeSheetEntryEJB"});
		result.add(daSpec);

		daSpec=com.ibm.ws.ejbpersistence.beanextensions.DataAccessSpecFactory.getDataAccessSpec();
		iSpec=new com.ibm.ws.rsadapter.cci.WSInteractionSpecImpl();
		iSpec.setFunctionSetName("com.wsbook.casestudy.ejb.websphere_deploy.DB2UDBNT_V8_1.TimeSheetEntryEJBBeanFunctionSet_f7c19b5d");
		iSpec.setFunctionName("Remove");
		daSpec.setInteractionSpec(iSpec);
		daSpec.setSpecName("Remove");
		daSpec.setInputRecordName("Remove");
		daSpec.setOptimistic(false);
		daSpec.setType(com.ibm.ws.ejbpersistence.beanextensions.EJBDataAccessSpec.REMOVE_BEAN);
		daSpec.setQueryScope(new String[]{"TimeSheetEntryEJB"});
		result.add(daSpec);

		daSpec=com.ibm.ws.ejbpersistence.beanextensions.DataAccessSpecFactory.getDataAccessSpec();
		iSpec=new com.ibm.ws.rsadapter.cci.WSInteractionSpecImpl();
		iSpec.setFunctionSetName("com.wsbook.casestudy.ejb.websphere_deploy.DB2UDBNT_V8_1.TimeSheetEntryEJBBeanFunctionSet_f7c19b5d");
		iSpec.setFunctionName("Store");
		daSpec.setInteractionSpec(iSpec);
		daSpec.setSpecName("Store");
		daSpec.setInputRecordName("Store");
		daSpec.setOptimistic(false);
		daSpec.setType(com.ibm.ws.ejbpersistence.beanextensions.EJBDataAccessSpec.STORE_BEAN);
		daSpec.setQueryScope(new String[]{"TimeSheetEntryEJB"});
		result.add(daSpec);

		daSpec=com.ibm.ws.ejbpersistence.beanextensions.DataAccessSpecFactory.getDataAccessSpec();
		iSpec=new com.ibm.ws.rsadapter.cci.WSInteractionSpecImpl();
		iSpec.setFunctionSetName("com.wsbook.casestudy.ejb.websphere_deploy.DB2UDBNT_V8_1.TimeSheetEntryEJBBeanFunctionSet_f7c19b5d");
		iSpec.setFunctionName("StoreUsingOCC");
		daSpec.setInteractionSpec(iSpec);
		daSpec.setSpecName("Store");
		daSpec.setInputRecordName("Store");
		daSpec.setOptimistic(true);
		daSpec.setType(com.ibm.ws.ejbpersistence.beanextensions.EJBDataAccessSpec.STORE_BEAN);
		daSpec.setQueryScope(new String[]{"TimeSheetEntryEJB"});
		result.add(daSpec);

		daSpec=com.ibm.ws.ejbpersistence.beanextensions.DataAccessSpecFactory.getDataAccessSpec();
		iSpec=new com.ibm.ws.rsadapter.cci.WSInteractionSpecImpl();
		iSpec.setFunctionSetName("com.wsbook.casestudy.ejb.websphere_deploy.DB2UDBNT_V8_1.TimeSheetEntryEJBBeanFunctionSet_f7c19b5d");
		iSpec.setFunctionName("FindAll");
		daSpec.setInteractionSpec(iSpec);
		daSpec.setSpecName("FindAll");
		daSpec.setInputRecordName("FindAll");
		daSpec.setOptimistic(false);
		daSpec.setType(com.ibm.ws.ejbpersistence.beanextensions.EJBDataAccessSpec.FIND_BEAN);
		daSpec.setQueryScope(new String[]{"TimeSheetEntryEJB"});
		daSpec.setReadAccess(true);
		daSpec.setAllowDuplicates(true);
		daSpec.setContainsDuplicates(true);
		daSpec.setSingleResult(false);
		daSpec.setExtractor(new com.ibm.ws.ejbpersistence.dataaccess.WholeRowExtractor(getExtractor()));
		result.add(daSpec);

		daSpec=com.ibm.ws.ejbpersistence.beanextensions.DataAccessSpecFactory.getDataAccessSpec();
		iSpec=new com.ibm.ws.rsadapter.cci.WSInteractionSpecImpl();
		iSpec.setFunctionSetName("com.wsbook.casestudy.ejb.websphere_deploy.DB2UDBNT_V8_1.TimeSheetEntryEJBBeanFunctionSet_f7c19b5d");
		iSpec.setFunctionName("FindAllForUpdate");
		daSpec.setInteractionSpec(iSpec);
		daSpec.setSpecName("FindAll");
		daSpec.setInputRecordName("FindAll");
		daSpec.setOptimistic(false);
		daSpec.setType(com.ibm.ws.ejbpersistence.beanextensions.EJBDataAccessSpec.FIND_BEAN);
		daSpec.setQueryScope(new String[]{"TimeSheetEntryEJB"});
		daSpec.setReadAccess(false);
		daSpec.setAllowDuplicates(true);
		daSpec.setContainsDuplicates(true);
		daSpec.setSingleResult(false);
		daSpec.setExtractor(new com.ibm.ws.ejbpersistence.dataaccess.WholeRowExtractor(getExtractor()));
		result.add(daSpec);

		daSpec=com.ibm.ws.ejbpersistence.beanextensions.DataAccessSpecFactory.getDataAccessSpec();
		iSpec=new com.ibm.ws.rsadapter.cci.WSInteractionSpecImpl();
		iSpec.setFunctionSetName("com.wsbook.casestudy.ejb.websphere_deploy.DB2UDBNT_V8_1.TimeSheetEntryEJBBeanFunctionSet_f7c19b5d");
		iSpec.setFunctionName("FindByPrimaryKey");
		daSpec.setInteractionSpec(iSpec);
		daSpec.setSpecName("FindByPrimaryKey");
		daSpec.setInputRecordName("FindByPrimaryKey");
		daSpec.setOptimistic(false);
		daSpec.setType(com.ibm.ws.ejbpersistence.beanextensions.EJBDataAccessSpec.FIND_PK);
		daSpec.setQueryScope(new String[]{"TimeSheetEntryEJB"});
		daSpec.setReadAccess(true);
		daSpec.setAllowDuplicates(false);
		daSpec.setContainsDuplicates(false);
		daSpec.setSingleResult(true);
		daSpec.setExtractor(new com.ibm.ws.ejbpersistence.dataaccess.WholeRowExtractor(getExtractor()));
		result.add(daSpec);

		daSpec=com.ibm.ws.ejbpersistence.beanextensions.DataAccessSpecFactory.getDataAccessSpec();
		iSpec=new com.ibm.ws.rsadapter.cci.WSInteractionSpecImpl();
		iSpec.setFunctionSetName("com.wsbook.casestudy.ejb.websphere_deploy.DB2UDBNT_V8_1.TimeSheetEntryEJBBeanFunctionSet_f7c19b5d");
		iSpec.setFunctionName("FindByPrimaryKey444Update");
		daSpec.setInteractionSpec(iSpec);
		daSpec.setSpecName("FindByPrimaryKey");
		daSpec.setInputRecordName("FindByPrimaryKey");
		daSpec.setOptimistic(false);
		daSpec.setType(com.ibm.ws.ejbpersistence.beanextensions.EJBDataAccessSpec.FIND_PK);
		daSpec.setQueryScope(new String[]{"TimeSheetEntryEJB"});
		daSpec.setReadAccess(false);
		daSpec.setAllowDuplicates(false);
		daSpec.setContainsDuplicates(false);
		daSpec.setSingleResult(true);
		daSpec.setExtractor(new com.ibm.ws.ejbpersistence.dataaccess.WholeRowExtractor(getExtractor()));
		result.add(daSpec);

		daSpec=com.ibm.ws.ejbpersistence.beanextensions.DataAccessSpecFactory.getDataAccessSpec();
		iSpec=new com.ibm.ws.rsadapter.cci.WSInteractionSpecImpl();
		iSpec.setFunctionSetName("com.wsbook.casestudy.ejb.websphere_deploy.DB2UDBNT_V8_1.TimeSheetEntryEJBBeanFunctionSet_f7c19b5d");
		iSpec.setFunctionName("findEntriesByTimesheetKey_Local");
		daSpec.setInteractionSpec(iSpec);
		daSpec.setSpecName("findEntriesByTimesheetKey_Local");
		daSpec.setInputRecordName("findEntriesByTimesheetKey_Local");
		daSpec.setOptimistic(false);
		daSpec.setType(com.ibm.ws.ejbpersistence.beanextensions.EJBDataAccessSpec.FIND_BEAN);
		{
		com.ibm.ws.ejbpersistence.dataaccess.CompleteAssociationList cal=new com.ibm.ws.ejbpersistence.dataaccess.CompleteAssociationList(1);
		cal.add(new String[]{"timesheet"});daSpec.setCompleteAssociationList(cal);
		}daSpec.setQueryScope(new String[]{"TimeSheetEntryEJB"});
		daSpec.setReadAccess(true);
		daSpec.setAllowDuplicates(true);
		daSpec.setContainsDuplicates(true);
		daSpec.setSingleResult(false);
		daSpec.setExtractor(new com.ibm.ws.ejbpersistence.dataaccess.WholeRowExtractor(getExtractor()));
		result.add(daSpec);

		daSpec=com.ibm.ws.ejbpersistence.beanextensions.DataAccessSpecFactory.getDataAccessSpec();
		iSpec=new com.ibm.ws.rsadapter.cci.WSInteractionSpecImpl();
		iSpec.setFunctionSetName("com.wsbook.casestudy.ejb.websphere_deploy.DB2UDBNT_V8_1.TimeSheetEntryEJBBeanFunctionSet_f7c19b5d");
		iSpec.setFunctionName("findEntriesByTimesheetKey_LocalForUpdate");
		daSpec.setInteractionSpec(iSpec);
		daSpec.setSpecName("findEntriesByTimesheetKey_Local");
		daSpec.setInputRecordName("findEntriesByTimesheetKey_Local");
		daSpec.setOptimistic(false);
		daSpec.setType(com.ibm.ws.ejbpersistence.beanextensions.EJBDataAccessSpec.FIND_BEAN);
		{
		com.ibm.ws.ejbpersistence.dataaccess.CompleteAssociationList cal=new com.ibm.ws.ejbpersistence.dataaccess.CompleteAssociationList(1);
		cal.add(new String[]{"timesheet"});daSpec.setCompleteAssociationList(cal);
		}daSpec.setQueryScope(new String[]{"TimeSheetEntryEJB"});
		daSpec.setReadAccess(false);
		daSpec.setAllowDuplicates(true);
		daSpec.setContainsDuplicates(true);
		daSpec.setSingleResult(false);
		daSpec.setExtractor(new com.ibm.ws.ejbpersistence.dataaccess.WholeRowExtractor(getExtractor()));
		result.add(daSpec);

		daSpec=com.ibm.ws.ejbpersistence.beanextensions.DataAccessSpecFactory.getDataAccessSpec();
		iSpec=new com.ibm.ws.rsadapter.cci.WSInteractionSpecImpl();
		iSpec.setFunctionSetName("com.wsbook.casestudy.ejb.websphere_deploy.DB2UDBNT_V8_1.TimeSheetEntryEJBBeanFunctionSet_f7c19b5d");
		iSpec.setFunctionName("findTimesheetentryByProjectKey_Local");
		daSpec.setInteractionSpec(iSpec);
		daSpec.setSpecName("findTimesheetentryByProjectKey_Local");
		daSpec.setInputRecordName("findTimesheetentryByProjectKey_Local");
		daSpec.setOptimistic(false);
		daSpec.setType(com.ibm.ws.ejbpersistence.beanextensions.EJBDataAccessSpec.FIND_BEAN);
		{
		com.ibm.ws.ejbpersistence.dataaccess.CompleteAssociationList cal=new com.ibm.ws.ejbpersistence.dataaccess.CompleteAssociationList(1);
		cal.add(new String[]{"project"});daSpec.setCompleteAssociationList(cal);
		}daSpec.setQueryScope(new String[]{"TimeSheetEntryEJB"});
		daSpec.setReadAccess(true);
		daSpec.setAllowDuplicates(true);
		daSpec.setContainsDuplicates(true);
		daSpec.setSingleResult(false);
		daSpec.setExtractor(new com.ibm.ws.ejbpersistence.dataaccess.WholeRowExtractor(getExtractor()));
		result.add(daSpec);

		daSpec=com.ibm.ws.ejbpersistence.beanextensions.DataAccessSpecFactory.getDataAccessSpec();
		iSpec=new com.ibm.ws.rsadapter.cci.WSInteractionSpecImpl();
		iSpec.setFunctionSetName("com.wsbook.casestudy.ejb.websphere_deploy.DB2UDBNT_V8_1.TimeSheetEntryEJBBeanFunctionSet_f7c19b5d");
		iSpec.setFunctionName("findTimesheetentryByProjectKey_LocalForUpdate");
		daSpec.setInteractionSpec(iSpec);
		daSpec.setSpecName("findTimesheetentryByProjectKey_Local");
		daSpec.setInputRecordName("findTimesheetentryByProjectKey_Local");
		daSpec.setOptimistic(false);
		daSpec.setType(com.ibm.ws.ejbpersistence.beanextensions.EJBDataAccessSpec.FIND_BEAN);
		{
		com.ibm.ws.ejbpersistence.dataaccess.CompleteAssociationList cal=new com.ibm.ws.ejbpersistence.dataaccess.CompleteAssociationList(1);
		cal.add(new String[]{"project"});daSpec.setCompleteAssociationList(cal);
		}daSpec.setQueryScope(new String[]{"TimeSheetEntryEJB"});
		daSpec.setReadAccess(false);
		daSpec.setAllowDuplicates(true);
		daSpec.setContainsDuplicates(true);
		daSpec.setSingleResult(false);
		daSpec.setExtractor(new com.ibm.ws.ejbpersistence.dataaccess.WholeRowExtractor(getExtractor()));
		result.add(daSpec);

		return result;

	}
}

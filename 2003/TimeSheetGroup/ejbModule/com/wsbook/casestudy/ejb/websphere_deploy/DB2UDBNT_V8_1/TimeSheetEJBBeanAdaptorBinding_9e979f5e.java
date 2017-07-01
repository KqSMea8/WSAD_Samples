package com.wsbook.casestudy.ejb.websphere_deploy.DB2UDBNT_V8_1;

/**
 * TimeSheetEJBBeanAdaptorBinding_9e979f5e
 */
public class TimeSheetEJBBeanAdaptorBinding_9e979f5e implements com.ibm.ws.ejbpersistence.beanextensions.BeanAdaptorBinding {
	/**
	 * getExtractor
	 */
	public com.ibm.ws.ejbpersistence.dataaccess.EJBExtractor getExtractor() {
		// extractor for com.wsbook.casestudy.ejb.websphere_deploy.DB2UDBNT_V8_1.TimeSheetEJBBeanExtractor_9e979f5e
		com.ibm.ws.ejbpersistence.dataaccess.AbstractEJBExtractor extractor =  new com.wsbook.casestudy.ejb.websphere_deploy.DB2UDBNT_V8_1.TimeSheetEJBBeanExtractor_9e979f5e();
		extractor.setPrimaryKeyColumns(new int[] {3});
		extractor.setDataColumns(new int[] {1,2,3,4,5});
		return extractor;
	}
	/**
	 * getRAExtractor0
	 */
	public com.ibm.ws.ejbpersistence.dataaccess.WholeRowExtractor getRAExtractor0() {
		com.ibm.ws.ejbpersistence.dataaccess.WholeRowExtractor rowExtractor = new com.ibm.ws.ejbpersistence.dataaccess.WholeRowExtractor();
		// extractor for com.wsbook.casestudy.ejb.websphere_deploy.DB2UDBNT_V8_1.TimeSheetEJBBeanExtractor_9e979f5e
		com.ibm.ws.ejbpersistence.dataaccess.AbstractEJBExtractor extractor0 =  new com.wsbook.casestudy.ejb.websphere_deploy.DB2UDBNT_V8_1.TimeSheetEJBBeanExtractor_9e979f5e();
		extractor0.setPrimaryKeyColumns(new int[] {3});
		extractor0.setDataColumns(new int[] {1,2,3,4,5});
		extractor0.setChunkLength(5);
		rowExtractor.add(extractor0);
		// extractor for com.wsbook.casestudy.ejb.websphere_deploy.DB2UDBNT_V8_1.TimeSheetEntryEJBBeanExtractor_f7c19b5d
		com.ibm.ws.ejbpersistence.dataaccess.AbstractEJBExtractor extractor1 =  new com.wsbook.casestudy.ejb.websphere_deploy.DB2UDBNT_V8_1.TimeSheetEntryEJBBeanExtractor_f7c19b5d();
		extractor1.setPrimaryKeyColumns(new int[] {3});
		extractor1.setDataColumns(new int[] {1,2,3,4,5});
		extractor1.setChunkLength(5);
		rowExtractor.add(extractor1);
		return rowExtractor;
	}
	/**
	 * getInjector
	 */
	public com.ibm.ws.ejbpersistence.beanextensions.EJBInjector getInjector() {
		return new com.wsbook.casestudy.ejb.websphere_deploy.DB2UDBNT_V8_1.TimeSheetEJBBeanInjectorImpl_9e979f5e();
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
		cat[0] = new com.ibm.ObjectQuery.metadata.OSQLExternalCatalogRDBAlias("TimeSheetEJB", "TimeSheetEJB1_Alias", "DB2NT", "TIMESHEETEJB", "TimeSheetEJB_TimeSheetEJB1_Table");

		//-------------------------------------------------------------------------
		fields = new com.ibm.ObjectQuery.metadata.OSQLExternalColumnDef[5];

		fields[0] = new com.ibm.ObjectQuery.metadata.OSQLExternalColumnDef("WEEKEND", new String(), com.ibm.ObjectQuery.engine.OSQLSymbols._CHARACTER, 250, com.ibm.ObjectQuery.engine.OSQLConstants.NO_TYPE, false, 0, -1, 0);
		fields[1] = new com.ibm.ObjectQuery.metadata.OSQLExternalColumnDef("STATE1", new String(), com.ibm.ObjectQuery.engine.OSQLSymbols._CHARACTER, 250, com.ibm.ObjectQuery.engine.OSQLConstants.NO_TYPE, false, 0, -1, 0);
		fields[2] = new com.ibm.ObjectQuery.metadata.OSQLExternalColumnDef("TIMESHEETID", new String(), com.ibm.ObjectQuery.engine.OSQLSymbols._INTEGER, 0, com.ibm.ObjectQuery.engine.OSQLConstants.NO_TYPE, true, 0, -1, 0);
		fields[3] = new com.ibm.ObjectQuery.metadata.OSQLExternalColumnDef("SUBMITTER_EMPID", new String(), com.ibm.ObjectQuery.engine.OSQLSymbols._CHARACTER, 250, com.ibm.ObjectQuery.engine.OSQLConstants.NO_TYPE, false, 0, -1, 0);
		fields[4] = new com.ibm.ObjectQuery.metadata.OSQLExternalColumnDef("APPROVER_EMPID", new String(), com.ibm.ObjectQuery.engine.OSQLSymbols._CHARACTER, 250, com.ibm.ObjectQuery.engine.OSQLConstants.NO_TYPE, false, 0, -1, 0);
		primarykey = new String[1];
		primarykey[0] = "TIMESHEETID";
		cat[1] = new com.ibm.ObjectQuery.metadata.OSQLExternalCatalogType("TimeSheetEJB", "TimeSheetEJB1_Table", null, fields, primarykey);

		//-------------------------------------------------------------------------
		fields = new com.ibm.ObjectQuery.metadata.OSQLExternalColumnDef[6];

		fields[0] = new com.ibm.ObjectQuery.metadata.OSQLExternalColumnDef("weekend", new String(), com.ibm.ObjectQuery.engine.OSQLSymbols._CHARACTER, 0, com.ibm.ObjectQuery.engine.OSQLConstants.NO_TYPE, false, 0, -1, 0);
		fields[1] = new com.ibm.ObjectQuery.metadata.OSQLExternalColumnDef("state", new String(), com.ibm.ObjectQuery.engine.OSQLSymbols._CHARACTER, 0, com.ibm.ObjectQuery.engine.OSQLConstants.NO_TYPE, false, 0, -1, 0);
		fields[2] = new com.ibm.ObjectQuery.metadata.OSQLExternalColumnDef("timeSheetId", new String(), com.ibm.ObjectQuery.engine.OSQLSymbols._INTEGER, 0, com.ibm.ObjectQuery.engine.OSQLConstants.NO_TYPE, false, 0, -1, 0);
		fields[3] = new com.ibm.ObjectQuery.metadata.OSQLExternalColumnDef("submitter", "EmployeeEJB", com.ibm.ObjectQuery.engine.OSQLSymbols.OOSQL_TABLE, 0, com.ibm.ObjectQuery.engine.OSQLConstants.NO_TYPE, false, 0, -1, com.ibm.ObjectQuery.engine.OSQLSymbols.SQL_BO);
		fields[4] = new com.ibm.ObjectQuery.metadata.OSQLExternalColumnDef("approver", "EmployeeEJB", com.ibm.ObjectQuery.engine.OSQLSymbols.OOSQL_TABLE, 0, com.ibm.ObjectQuery.engine.OSQLConstants.NO_TYPE, false, 0, -1, com.ibm.ObjectQuery.engine.OSQLSymbols.SQL_BO);
		fields[5] = new com.ibm.ObjectQuery.metadata.OSQLExternalColumnDef("entries", "TimeSheetEntryEJB", com.ibm.ObjectQuery.engine.OSQLSymbols.OOSQL_TABLE, 0, com.ibm.ObjectQuery.engine.OSQLSymbols.LISTOF, false, 0, -1, com.ibm.ObjectQuery.engine.OSQLSymbols.SQL_BO);
		primarykey = new String[1];
		primarykey[0] = "timeSheetId";
		cat[2] = new com.ibm.ObjectQuery.metadata.OSQLExternalCatalogType("TimeSheetEJB", "TimeSheetEJB_BO", "com.wsbook.casestudy.ejb.TimeSheetEJBBean", fields, primarykey);

		//-------------------------------------------------------------------------
		composedObjs = null;
		composedObjImpls = null;
		subhomes = null;
		cat[3] = new com.ibm.ObjectQuery.metadata.OSQLExternalCatalogView("TimeSheetEJB", "TimeSheetEJB_TimeSheetEJB_BO", "TimeSheetEJB_TimeSheetEJB1_Alias", composedObjs, composedObjImpls, 
		"select t1.WEEKEND,t1.STATE1,t1.TIMESHEETID,(select t2 from EmployeeEJB_EmployeeEJB1_Alias t2 where t2.EMPID = t1.SUBMITTER_EMPID),(select t2 from EmployeeEJB_EmployeeEJB1_Alias t2 where t2.EMPID = t1.APPROVER_EMPID),(select  nest  (t3) from TimeSheetEntryEJB_TimeSheetEntryEJB1_Alias t3 where t3.TIMESHEET_TIMESHEETID = t1.TIMESHEETID) from _this t1", 
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
		java.util.Collection result = new java.util.ArrayList(16);

		daSpec=com.ibm.ws.ejbpersistence.beanextensions.DataAccessSpecFactory.getDataAccessSpec();
		iSpec=new com.ibm.ws.rsadapter.cci.WSInteractionSpecImpl();
		iSpec.setFunctionSetName("com.wsbook.casestudy.ejb.websphere_deploy.DB2UDBNT_V8_1.TimeSheetEJBBeanFunctionSet_9e979f5e");
		iSpec.setFunctionName("Create");
		daSpec.setInteractionSpec(iSpec);
		daSpec.setSpecName("Create");
		daSpec.setInputRecordName("Create");
		daSpec.setOptimistic(false);
		daSpec.setType(com.ibm.ws.ejbpersistence.beanextensions.EJBDataAccessSpec.CREATE_BEAN);
		daSpec.setQueryScope(new String[]{"TimeSheetEJB"});
		result.add(daSpec);

		daSpec=com.ibm.ws.ejbpersistence.beanextensions.DataAccessSpecFactory.getDataAccessSpec();
		iSpec=new com.ibm.ws.rsadapter.cci.WSInteractionSpecImpl();
		iSpec.setFunctionSetName("com.wsbook.casestudy.ejb.websphere_deploy.DB2UDBNT_V8_1.TimeSheetEJBBeanFunctionSet_9e979f5e");
		iSpec.setFunctionName("Remove");
		daSpec.setInteractionSpec(iSpec);
		daSpec.setSpecName("Remove");
		daSpec.setInputRecordName("Remove");
		daSpec.setOptimistic(false);
		daSpec.setType(com.ibm.ws.ejbpersistence.beanextensions.EJBDataAccessSpec.REMOVE_BEAN);
		daSpec.setQueryScope(new String[]{"TimeSheetEJB"});
		result.add(daSpec);

		daSpec=com.ibm.ws.ejbpersistence.beanextensions.DataAccessSpecFactory.getDataAccessSpec();
		iSpec=new com.ibm.ws.rsadapter.cci.WSInteractionSpecImpl();
		iSpec.setFunctionSetName("com.wsbook.casestudy.ejb.websphere_deploy.DB2UDBNT_V8_1.TimeSheetEJBBeanFunctionSet_9e979f5e");
		iSpec.setFunctionName("Store");
		daSpec.setInteractionSpec(iSpec);
		daSpec.setSpecName("Store");
		daSpec.setInputRecordName("Store");
		daSpec.setOptimistic(false);
		daSpec.setType(com.ibm.ws.ejbpersistence.beanextensions.EJBDataAccessSpec.STORE_BEAN);
		daSpec.setQueryScope(new String[]{"TimeSheetEJB"});
		result.add(daSpec);

		daSpec=com.ibm.ws.ejbpersistence.beanextensions.DataAccessSpecFactory.getDataAccessSpec();
		iSpec=new com.ibm.ws.rsadapter.cci.WSInteractionSpecImpl();
		iSpec.setFunctionSetName("com.wsbook.casestudy.ejb.websphere_deploy.DB2UDBNT_V8_1.TimeSheetEJBBeanFunctionSet_9e979f5e");
		iSpec.setFunctionName("StoreUsingOCC");
		daSpec.setInteractionSpec(iSpec);
		daSpec.setSpecName("Store");
		daSpec.setInputRecordName("Store");
		daSpec.setOptimistic(true);
		daSpec.setType(com.ibm.ws.ejbpersistence.beanextensions.EJBDataAccessSpec.STORE_BEAN);
		daSpec.setQueryScope(new String[]{"TimeSheetEJB"});
		result.add(daSpec);

		daSpec=com.ibm.ws.ejbpersistence.beanextensions.DataAccessSpecFactory.getDataAccessSpec();
		iSpec=new com.ibm.ws.rsadapter.cci.WSInteractionSpecImpl();
		iSpec.setFunctionSetName("com.wsbook.casestudy.ejb.websphere_deploy.DB2UDBNT_V8_1.TimeSheetEJBBeanFunctionSet_9e979f5e");
		iSpec.setFunctionName("FindPendingByEmployee");
		daSpec.setInteractionSpec(iSpec);
		daSpec.setSpecName("FindPendingByEmployee");
		daSpec.setInputRecordName("FindPendingByEmployee");
		daSpec.setOptimistic(false);
		daSpec.setType(com.ibm.ws.ejbpersistence.beanextensions.EJBDataAccessSpec.FIND_BEAN);
		daSpec.setQueryScope(new String[]{"TimeSheetEJB","EmployeeEJB"});
		daSpec.setReadAccess(true);
		daSpec.setAllowDuplicates(true);
		daSpec.setContainsDuplicates(true);
		daSpec.setSingleResult(false);
		daSpec.setExtractor(new com.ibm.ws.ejbpersistence.dataaccess.WholeRowExtractor(getExtractor()));
		result.add(daSpec);

		daSpec=com.ibm.ws.ejbpersistence.beanextensions.DataAccessSpecFactory.getDataAccessSpec();
		iSpec=new com.ibm.ws.rsadapter.cci.WSInteractionSpecImpl();
		iSpec.setFunctionSetName("com.wsbook.casestudy.ejb.websphere_deploy.DB2UDBNT_V8_1.TimeSheetEJBBeanFunctionSet_9e979f5e");
		iSpec.setFunctionName("FindApprovedTimesheetsByApprover");
		daSpec.setInteractionSpec(iSpec);
		daSpec.setSpecName("FindApprovedTimesheetsByApprover");
		daSpec.setInputRecordName("FindApprovedTimesheetsByApprover");
		daSpec.setOptimistic(false);
		daSpec.setType(com.ibm.ws.ejbpersistence.beanextensions.EJBDataAccessSpec.FIND_BEAN);
		daSpec.setQueryScope(new String[]{"TimeSheetEJB","EmployeeEJB"});
		daSpec.setReadAccess(true);
		daSpec.setAllowDuplicates(true);
		daSpec.setContainsDuplicates(true);
		daSpec.setSingleResult(false);
		daSpec.setExtractor(new com.ibm.ws.ejbpersistence.dataaccess.WholeRowExtractor(getExtractor()));
		result.add(daSpec);

		daSpec=com.ibm.ws.ejbpersistence.beanextensions.DataAccessSpecFactory.getDataAccessSpec();
		iSpec=new com.ibm.ws.rsadapter.cci.WSInteractionSpecImpl();
		iSpec.setFunctionSetName("com.wsbook.casestudy.ejb.websphere_deploy.DB2UDBNT_V8_1.TimeSheetEJBBeanFunctionSet_9e979f5e");
		iSpec.setFunctionName("FindByPrimaryKey");
		daSpec.setInteractionSpec(iSpec);
		daSpec.setSpecName("FindByPrimaryKey");
		daSpec.setInputRecordName("FindByPrimaryKey");
		daSpec.setOptimistic(false);
		daSpec.setType(com.ibm.ws.ejbpersistence.beanextensions.EJBDataAccessSpec.FIND_PK);
		daSpec.setQueryScope(new String[]{"TimeSheetEJB"});
		daSpec.setReadAccess(true);
		daSpec.setAllowDuplicates(false);
		daSpec.setContainsDuplicates(false);
		daSpec.setSingleResult(true);
		daSpec.setExtractor(new com.ibm.ws.ejbpersistence.dataaccess.WholeRowExtractor(getExtractor()));
		result.add(daSpec);

		daSpec=com.ibm.ws.ejbpersistence.beanextensions.DataAccessSpecFactory.getDataAccessSpec();
		iSpec=new com.ibm.ws.rsadapter.cci.WSInteractionSpecImpl();
		iSpec.setFunctionSetName("com.wsbook.casestudy.ejb.websphere_deploy.DB2UDBNT_V8_1.TimeSheetEJBBeanFunctionSet_9e979f5e");
		iSpec.setFunctionName("FindByPrimaryKey444Update");
		daSpec.setInteractionSpec(iSpec);
		daSpec.setSpecName("FindByPrimaryKey");
		daSpec.setInputRecordName("FindByPrimaryKey");
		daSpec.setOptimistic(false);
		daSpec.setType(com.ibm.ws.ejbpersistence.beanextensions.EJBDataAccessSpec.FIND_PK);
		daSpec.setQueryScope(new String[]{"TimeSheetEJB"});
		daSpec.setReadAccess(false);
		daSpec.setAllowDuplicates(false);
		daSpec.setContainsDuplicates(false);
		daSpec.setSingleResult(true);
		daSpec.setExtractor(new com.ibm.ws.ejbpersistence.dataaccess.WholeRowExtractor(getExtractor()));
		result.add(daSpec);

		daSpec=com.ibm.ws.ejbpersistence.beanextensions.DataAccessSpecFactory.getDataAccessSpec();
		iSpec=new com.ibm.ws.rsadapter.cci.WSInteractionSpecImpl();
		iSpec.setFunctionSetName("com.wsbook.casestudy.ejb.websphere_deploy.DB2UDBNT_V8_1.TimeSheetEJBBeanFunctionSet_9e979f5e");
		iSpec.setFunctionName("FindByPrimaryKeyWithReadAhead");
		daSpec.setInteractionSpec(iSpec);
		daSpec.setSpecName("FindByPrimaryKey");
		daSpec.setInputRecordName("FindByPrimaryKey");
		daSpec.setOptimistic(true);
		daSpec.setType(com.ibm.ws.ejbpersistence.beanextensions.EJBDataAccessSpec.FIND_PK);
		daSpec.setReadAhead(com.ibm.ws.appprofile.accessintent.ReadAheadHintImpl.getReadAheadHint("entries"));
		{
		com.ibm.ws.ejbpersistence.dataaccess.CompleteAssociationList cal=new com.ibm.ws.ejbpersistence.dataaccess.CompleteAssociationList(2);
		cal.add(null);
		cal.add(new String[]{"entries.0"});
		daSpec.setCompleteAssociationList(cal);
		}daSpec.setQueryScope(new String[]{"TimeSheetEJB","TimeSheetEntryEJB"});
		daSpec.setReadAccess(true);
		daSpec.setAllowDuplicates(false);
		daSpec.setContainsDuplicates(false);
		daSpec.setSingleResult(true);
		daSpec.setExtractor(getRAExtractor0());
		result.add(daSpec);

		daSpec=com.ibm.ws.ejbpersistence.beanextensions.DataAccessSpecFactory.getDataAccessSpec();
		iSpec=new com.ibm.ws.rsadapter.cci.WSInteractionSpecImpl();
		iSpec.setFunctionSetName("com.wsbook.casestudy.ejb.websphere_deploy.DB2UDBNT_V8_1.TimeSheetEJBBeanFunctionSet_9e979f5e");
		iSpec.setFunctionName("FindAll");
		daSpec.setInteractionSpec(iSpec);
		daSpec.setSpecName("FindAll");
		daSpec.setInputRecordName("FindAll");
		daSpec.setOptimistic(false);
		daSpec.setType(com.ibm.ws.ejbpersistence.beanextensions.EJBDataAccessSpec.FIND_BEAN);
		daSpec.setQueryScope(new String[]{"TimeSheetEJB"});
		daSpec.setReadAccess(true);
		daSpec.setAllowDuplicates(true);
		daSpec.setContainsDuplicates(true);
		daSpec.setSingleResult(false);
		daSpec.setExtractor(new com.ibm.ws.ejbpersistence.dataaccess.WholeRowExtractor(getExtractor()));
		result.add(daSpec);

		daSpec=com.ibm.ws.ejbpersistence.beanextensions.DataAccessSpecFactory.getDataAccessSpec();
		iSpec=new com.ibm.ws.rsadapter.cci.WSInteractionSpecImpl();
		iSpec.setFunctionSetName("com.wsbook.casestudy.ejb.websphere_deploy.DB2UDBNT_V8_1.TimeSheetEJBBeanFunctionSet_9e979f5e");
		iSpec.setFunctionName("FindAllForUpdate");
		daSpec.setInteractionSpec(iSpec);
		daSpec.setSpecName("FindAll");
		daSpec.setInputRecordName("FindAll");
		daSpec.setOptimistic(false);
		daSpec.setType(com.ibm.ws.ejbpersistence.beanextensions.EJBDataAccessSpec.FIND_BEAN);
		daSpec.setQueryScope(new String[]{"TimeSheetEJB"});
		daSpec.setReadAccess(false);
		daSpec.setAllowDuplicates(true);
		daSpec.setContainsDuplicates(true);
		daSpec.setSingleResult(false);
		daSpec.setExtractor(new com.ibm.ws.ejbpersistence.dataaccess.WholeRowExtractor(getExtractor()));
		result.add(daSpec);

		daSpec=com.ibm.ws.ejbpersistence.beanextensions.DataAccessSpecFactory.getDataAccessSpec();
		iSpec=new com.ibm.ws.rsadapter.cci.WSInteractionSpecImpl();
		iSpec.setFunctionSetName("com.wsbook.casestudy.ejb.websphere_deploy.DB2UDBNT_V8_1.TimeSheetEJBBeanFunctionSet_9e979f5e");
		iSpec.setFunctionName("FindTimesheetsBySubmitter");
		daSpec.setInteractionSpec(iSpec);
		daSpec.setSpecName("FindTimesheetsBySubmitter");
		daSpec.setInputRecordName("FindTimesheetsBySubmitter");
		daSpec.setOptimistic(false);
		daSpec.setType(com.ibm.ws.ejbpersistence.beanextensions.EJBDataAccessSpec.FIND_BEAN);
		daSpec.setQueryScope(new String[]{"TimeSheetEJB","EmployeeEJB"});
		daSpec.setReadAccess(true);
		daSpec.setAllowDuplicates(true);
		daSpec.setContainsDuplicates(true);
		daSpec.setSingleResult(false);
		daSpec.setExtractor(new com.ibm.ws.ejbpersistence.dataaccess.WholeRowExtractor(getExtractor()));
		result.add(daSpec);

		daSpec=com.ibm.ws.ejbpersistence.beanextensions.DataAccessSpecFactory.getDataAccessSpec();
		iSpec=new com.ibm.ws.rsadapter.cci.WSInteractionSpecImpl();
		iSpec.setFunctionSetName("com.wsbook.casestudy.ejb.websphere_deploy.DB2UDBNT_V8_1.TimeSheetEJBBeanFunctionSet_9e979f5e");
		iSpec.setFunctionName("findTimesheetsBySubmitterKey_Local");
		daSpec.setInteractionSpec(iSpec);
		daSpec.setSpecName("findTimesheetsBySubmitterKey_Local");
		daSpec.setInputRecordName("findTimesheetsBySubmitterKey_Local");
		daSpec.setOptimistic(false);
		daSpec.setType(com.ibm.ws.ejbpersistence.beanextensions.EJBDataAccessSpec.FIND_BEAN);
		{
		com.ibm.ws.ejbpersistence.dataaccess.CompleteAssociationList cal=new com.ibm.ws.ejbpersistence.dataaccess.CompleteAssociationList(1);
		cal.add(new String[]{"submitter"});daSpec.setCompleteAssociationList(cal);
		}daSpec.setQueryScope(new String[]{"TimeSheetEJB"});
		daSpec.setReadAccess(true);
		daSpec.setAllowDuplicates(true);
		daSpec.setContainsDuplicates(true);
		daSpec.setSingleResult(false);
		daSpec.setExtractor(new com.ibm.ws.ejbpersistence.dataaccess.WholeRowExtractor(getExtractor()));
		result.add(daSpec);

		daSpec=com.ibm.ws.ejbpersistence.beanextensions.DataAccessSpecFactory.getDataAccessSpec();
		iSpec=new com.ibm.ws.rsadapter.cci.WSInteractionSpecImpl();
		iSpec.setFunctionSetName("com.wsbook.casestudy.ejb.websphere_deploy.DB2UDBNT_V8_1.TimeSheetEJBBeanFunctionSet_9e979f5e");
		iSpec.setFunctionName("findTimesheetsBySubmitterKey_LocalForUpdate");
		daSpec.setInteractionSpec(iSpec);
		daSpec.setSpecName("findTimesheetsBySubmitterKey_Local");
		daSpec.setInputRecordName("findTimesheetsBySubmitterKey_Local");
		daSpec.setOptimistic(false);
		daSpec.setType(com.ibm.ws.ejbpersistence.beanextensions.EJBDataAccessSpec.FIND_BEAN);
		{
		com.ibm.ws.ejbpersistence.dataaccess.CompleteAssociationList cal=new com.ibm.ws.ejbpersistence.dataaccess.CompleteAssociationList(1);
		cal.add(new String[]{"submitter"});daSpec.setCompleteAssociationList(cal);
		}daSpec.setQueryScope(new String[]{"TimeSheetEJB"});
		daSpec.setReadAccess(false);
		daSpec.setAllowDuplicates(true);
		daSpec.setContainsDuplicates(true);
		daSpec.setSingleResult(false);
		daSpec.setExtractor(new com.ibm.ws.ejbpersistence.dataaccess.WholeRowExtractor(getExtractor()));
		result.add(daSpec);

		daSpec=com.ibm.ws.ejbpersistence.beanextensions.DataAccessSpecFactory.getDataAccessSpec();
		iSpec=new com.ibm.ws.rsadapter.cci.WSInteractionSpecImpl();
		iSpec.setFunctionSetName("com.wsbook.casestudy.ejb.websphere_deploy.DB2UDBNT_V8_1.TimeSheetEJBBeanFunctionSet_9e979f5e");
		iSpec.setFunctionName("findApprovedTimesheetsByApproverKey_Local");
		daSpec.setInteractionSpec(iSpec);
		daSpec.setSpecName("findApprovedTimesheetsByApproverKey_Local");
		daSpec.setInputRecordName("findApprovedTimesheetsByApproverKey_Local");
		daSpec.setOptimistic(false);
		daSpec.setType(com.ibm.ws.ejbpersistence.beanextensions.EJBDataAccessSpec.FIND_BEAN);
		{
		com.ibm.ws.ejbpersistence.dataaccess.CompleteAssociationList cal=new com.ibm.ws.ejbpersistence.dataaccess.CompleteAssociationList(1);
		cal.add(new String[]{"approver"});daSpec.setCompleteAssociationList(cal);
		}daSpec.setQueryScope(new String[]{"TimeSheetEJB"});
		daSpec.setReadAccess(true);
		daSpec.setAllowDuplicates(true);
		daSpec.setContainsDuplicates(true);
		daSpec.setSingleResult(false);
		daSpec.setExtractor(new com.ibm.ws.ejbpersistence.dataaccess.WholeRowExtractor(getExtractor()));
		result.add(daSpec);

		daSpec=com.ibm.ws.ejbpersistence.beanextensions.DataAccessSpecFactory.getDataAccessSpec();
		iSpec=new com.ibm.ws.rsadapter.cci.WSInteractionSpecImpl();
		iSpec.setFunctionSetName("com.wsbook.casestudy.ejb.websphere_deploy.DB2UDBNT_V8_1.TimeSheetEJBBeanFunctionSet_9e979f5e");
		iSpec.setFunctionName("findApprovedTimesheetsByApproverKey_LocalForUpdate");
		daSpec.setInteractionSpec(iSpec);
		daSpec.setSpecName("findApprovedTimesheetsByApproverKey_Local");
		daSpec.setInputRecordName("findApprovedTimesheetsByApproverKey_Local");
		daSpec.setOptimistic(false);
		daSpec.setType(com.ibm.ws.ejbpersistence.beanextensions.EJBDataAccessSpec.FIND_BEAN);
		{
		com.ibm.ws.ejbpersistence.dataaccess.CompleteAssociationList cal=new com.ibm.ws.ejbpersistence.dataaccess.CompleteAssociationList(1);
		cal.add(new String[]{"approver"});daSpec.setCompleteAssociationList(cal);
		}daSpec.setQueryScope(new String[]{"TimeSheetEJB"});
		daSpec.setReadAccess(false);
		daSpec.setAllowDuplicates(true);
		daSpec.setContainsDuplicates(true);
		daSpec.setSingleResult(false);
		daSpec.setExtractor(new com.ibm.ws.ejbpersistence.dataaccess.WholeRowExtractor(getExtractor()));
		result.add(daSpec);

		return result;

	}
}

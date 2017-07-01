package com.wsbook.casestudy.ejb.websphere_deploy.DB2UDBNT_V8_1;

/**
 * EmployeeEJBBeanAdaptorBinding_96c219b7
 */
public class EmployeeEJBBeanAdaptorBinding_96c219b7 implements com.ibm.ws.ejbpersistence.beanextensions.BeanAdaptorBinding {
	/**
	 * getExtractor
	 */
	public com.ibm.ws.ejbpersistence.dataaccess.EJBExtractor getExtractor() {
		// extractor for com.wsbook.casestudy.ejb.websphere_deploy.DB2UDBNT_V8_1.EmployeeEJBBeanExtractor_96c219b7
		com.ibm.ws.ejbpersistence.dataaccess.AbstractEJBExtractor extractor =  new com.wsbook.casestudy.ejb.websphere_deploy.DB2UDBNT_V8_1.EmployeeEJBBeanExtractor_96c219b7();
		extractor.setPrimaryKeyColumns(new int[] {1});
		extractor.setDataColumns(new int[] {1,2,3,4,5,6,7});
		return extractor;
	}
	/**
	 * getInjector
	 */
	public com.ibm.ws.ejbpersistence.beanextensions.EJBInjector getInjector() {
		return new com.wsbook.casestudy.ejb.websphere_deploy.DB2UDBNT_V8_1.EmployeeEJBBeanInjectorImpl_96c219b7();
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
		cat = new com.ibm.ObjectQuery.metadata.OSQLExternalCatalogEntry[5];
		//-------------------------------------------------------------------------
		cat[0] = new com.ibm.ObjectQuery.metadata.OSQLExternalCatalogRDBAlias("EmployeeEJB", "EmployeeEJB1_Alias", "DB2NT", "EMPLOYEEEJB", "EmployeeEJB_EmployeeEJB1_Table");

		//-------------------------------------------------------------------------
		fields = new com.ibm.ObjectQuery.metadata.OSQLExternalColumnDef[7];

		fields[0] = new com.ibm.ObjectQuery.metadata.OSQLExternalColumnDef("EMPID", new String(), com.ibm.ObjectQuery.engine.OSQLSymbols._CHARACTER, 250, com.ibm.ObjectQuery.engine.OSQLConstants.NO_TYPE, true, 0, -1, 0);
		fields[1] = new com.ibm.ObjectQuery.metadata.OSQLExternalColumnDef("NAME", new String(), com.ibm.ObjectQuery.engine.OSQLSymbols._CHARACTER, 250, com.ibm.ObjectQuery.engine.OSQLConstants.NO_TYPE, false, 0, -1, 0);
		fields[2] = new com.ibm.ObjectQuery.metadata.OSQLExternalColumnDef("STATE", new String(), com.ibm.ObjectQuery.engine.OSQLSymbols._CHARACTER, 2, com.ibm.ObjectQuery.engine.OSQLConstants.NO_TYPE, false, 0, -1, 0);
		fields[3] = new com.ibm.ObjectQuery.metadata.OSQLExternalColumnDef("CITY", new String(), com.ibm.ObjectQuery.engine.OSQLSymbols._CHARACTER, 30, com.ibm.ObjectQuery.engine.OSQLConstants.NO_TYPE, false, 0, -1, 0);
		fields[4] = new com.ibm.ObjectQuery.metadata.OSQLExternalColumnDef("BUILDING", new String(), com.ibm.ObjectQuery.engine.OSQLSymbols._CHARACTER, 20, com.ibm.ObjectQuery.engine.OSQLConstants.NO_TYPE, false, 0, -1, 0);
		fields[5] = new com.ibm.ObjectQuery.metadata.OSQLExternalColumnDef("OFFICE", new String(), com.ibm.ObjectQuery.engine.OSQLSymbols._CHARACTER, 10, com.ibm.ObjectQuery.engine.OSQLConstants.NO_TYPE, false, 0, -1, 0);
		fields[6] = new com.ibm.ObjectQuery.metadata.OSQLExternalColumnDef("HOMEADDRESS_ADDRESSKEY", new String(), com.ibm.ObjectQuery.engine.OSQLSymbols._INTEGER, 0, com.ibm.ObjectQuery.engine.OSQLConstants.NO_TYPE, false, 0, -1, 0);
		primarykey = new String[1];
		primarykey[0] = "EMPID";
		cat[1] = new com.ibm.ObjectQuery.metadata.OSQLExternalCatalogType("EmployeeEJB", "EmployeeEJB1_Table", null, fields, primarykey);

		//-------------------------------------------------------------------------
		fields = new com.ibm.ObjectQuery.metadata.OSQLExternalColumnDef[4];

		fields[0] = new com.ibm.ObjectQuery.metadata.OSQLExternalColumnDef("state", new String(), com.ibm.ObjectQuery.engine.OSQLSymbols._CHARACTER, 0, com.ibm.ObjectQuery.engine.OSQLConstants.NO_TYPE, false, 0, -1, 0);
		fields[1] = new com.ibm.ObjectQuery.metadata.OSQLExternalColumnDef("city", new String(), com.ibm.ObjectQuery.engine.OSQLSymbols._CHARACTER, 0, com.ibm.ObjectQuery.engine.OSQLConstants.NO_TYPE, false, 0, -1, 0);
		fields[2] = new com.ibm.ObjectQuery.metadata.OSQLExternalColumnDef("building", new String(), com.ibm.ObjectQuery.engine.OSQLSymbols._CHARACTER, 0, com.ibm.ObjectQuery.engine.OSQLConstants.NO_TYPE, false, 0, -1, 0);
		fields[3] = new com.ibm.ObjectQuery.metadata.OSQLExternalColumnDef("office", new String(), com.ibm.ObjectQuery.engine.OSQLSymbols._CHARACTER, 0, com.ibm.ObjectQuery.engine.OSQLConstants.NO_TYPE, false, 0, -1, 0);
		primarykey = null;
		cat[2] = new com.ibm.ObjectQuery.metadata.OSQLExternalCatalogType("EmployeeEJB", "udt1", "com.wsbook.casestudy.ejb.OfficeLocation", fields, primarykey);

		//-------------------------------------------------------------------------
		fields = new com.ibm.ObjectQuery.metadata.OSQLExternalColumnDef[6];

		fields[0] = new com.ibm.ObjectQuery.metadata.OSQLExternalColumnDef("empId", new String(), com.ibm.ObjectQuery.engine.OSQLSymbols._CHARACTER, 0, com.ibm.ObjectQuery.engine.OSQLConstants.NO_TYPE, false, 0, -1, 0);
		fields[1] = new com.ibm.ObjectQuery.metadata.OSQLExternalColumnDef("name", new String(), com.ibm.ObjectQuery.engine.OSQLSymbols._CHARACTER, 0, com.ibm.ObjectQuery.engine.OSQLConstants.NO_TYPE, false, 0, -1, 0);
		fields[2] = new com.ibm.ObjectQuery.metadata.OSQLExternalColumnDef("office", "EmployeeEJB_udt1", com.ibm.ObjectQuery.engine.OSQLSymbols.OOSQL_TABLE, 0, com.ibm.ObjectQuery.engine.OSQLConstants.NO_TYPE, false, -1, 0, com.ibm.ObjectQuery.engine.OSQLSymbols.OSQL_UDT);
		fields[3] = new com.ibm.ObjectQuery.metadata.OSQLExternalColumnDef("homeAddress", "AddressEJB", com.ibm.ObjectQuery.engine.OSQLSymbols.OOSQL_TABLE, 0, com.ibm.ObjectQuery.engine.OSQLConstants.NO_TYPE, false, 0, -1, com.ibm.ObjectQuery.engine.OSQLSymbols.SQL_BO);
		fields[4] = new com.ibm.ObjectQuery.metadata.OSQLExternalColumnDef("timesheets", "TimeSheetEJB", com.ibm.ObjectQuery.engine.OSQLSymbols.OOSQL_TABLE, 0, com.ibm.ObjectQuery.engine.OSQLSymbols.LISTOF, false, 0, -1, com.ibm.ObjectQuery.engine.OSQLSymbols.SQL_BO);
		fields[5] = new com.ibm.ObjectQuery.metadata.OSQLExternalColumnDef("approvedTimesheets", "TimeSheetEJB", com.ibm.ObjectQuery.engine.OSQLSymbols.OOSQL_TABLE, 0, com.ibm.ObjectQuery.engine.OSQLSymbols.LISTOF, false, 0, -1, com.ibm.ObjectQuery.engine.OSQLSymbols.SQL_BO);
		primarykey = new String[1];
		primarykey[0] = "empId";
		cat[3] = new com.ibm.ObjectQuery.metadata.OSQLExternalCatalogType("EmployeeEJB", "EmployeeEJB_BO", "com.wsbook.casestudy.ejb.EmployeeEJBBean", fields, primarykey);

		//-------------------------------------------------------------------------
		composedObjs = new String[1];
		composedObjs[0] = "office";
		composedObjImpls = new String[1];
		composedObjImpls[0] = "select q1.STATE, q1.CITY, q1.BUILDING, q1.OFFICE from _this q1";
		subhomes = null;
		cat[4] = new com.ibm.ObjectQuery.metadata.OSQLExternalCatalogView("EmployeeEJB", "EmployeeEJB_EmployeeEJB_BO", "EmployeeEJB_EmployeeEJB1_Alias", composedObjs, composedObjImpls, 
		"select t1.EMPID,t1.NAME,_converter(\"com.wsbook.casestudy.ejb.OfficeLocationComposer\",t1.STATE, t1.CITY, t1.BUILDING, t1.OFFICE),(select t2 from AddressEJB_AddressEJB1_Alias t2 where t2.ADDRESSKEY = t1.HOMEADDRESS_ADDRESSKEY),(select  nest  (t3) from TimeSheetEJB_TimeSheetEJB1_Alias t3 where t3.SUBMITTER_EMPID = t1.EMPID),(select  nest  (t3) from TimeSheetEJB_TimeSheetEJB1_Alias t3 where t3.APPROVER_EMPID = t1.EMPID) from _this t1", 
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
		java.util.Collection result = new java.util.ArrayList(10);

		daSpec=com.ibm.ws.ejbpersistence.beanextensions.DataAccessSpecFactory.getDataAccessSpec();
		iSpec=new com.ibm.ws.rsadapter.cci.WSInteractionSpecImpl();
		iSpec.setFunctionSetName("com.wsbook.casestudy.ejb.websphere_deploy.DB2UDBNT_V8_1.EmployeeEJBBeanFunctionSet_96c219b7");
		iSpec.setFunctionName("Create");
		daSpec.setInteractionSpec(iSpec);
		daSpec.setSpecName("Create");
		daSpec.setInputRecordName("Create");
		daSpec.setOptimistic(false);
		daSpec.setType(com.ibm.ws.ejbpersistence.beanextensions.EJBDataAccessSpec.CREATE_BEAN);
		daSpec.setQueryScope(new String[]{"EmployeeEJB"});
		result.add(daSpec);

		daSpec=com.ibm.ws.ejbpersistence.beanextensions.DataAccessSpecFactory.getDataAccessSpec();
		iSpec=new com.ibm.ws.rsadapter.cci.WSInteractionSpecImpl();
		iSpec.setFunctionSetName("com.wsbook.casestudy.ejb.websphere_deploy.DB2UDBNT_V8_1.EmployeeEJBBeanFunctionSet_96c219b7");
		iSpec.setFunctionName("Remove");
		daSpec.setInteractionSpec(iSpec);
		daSpec.setSpecName("Remove");
		daSpec.setInputRecordName("Remove");
		daSpec.setOptimistic(false);
		daSpec.setType(com.ibm.ws.ejbpersistence.beanextensions.EJBDataAccessSpec.REMOVE_BEAN);
		daSpec.setQueryScope(new String[]{"EmployeeEJB"});
		result.add(daSpec);

		daSpec=com.ibm.ws.ejbpersistence.beanextensions.DataAccessSpecFactory.getDataAccessSpec();
		iSpec=new com.ibm.ws.rsadapter.cci.WSInteractionSpecImpl();
		iSpec.setFunctionSetName("com.wsbook.casestudy.ejb.websphere_deploy.DB2UDBNT_V8_1.EmployeeEJBBeanFunctionSet_96c219b7");
		iSpec.setFunctionName("Store");
		daSpec.setInteractionSpec(iSpec);
		daSpec.setSpecName("Store");
		daSpec.setInputRecordName("Store");
		daSpec.setOptimistic(false);
		daSpec.setType(com.ibm.ws.ejbpersistence.beanextensions.EJBDataAccessSpec.STORE_BEAN);
		daSpec.setQueryScope(new String[]{"EmployeeEJB"});
		result.add(daSpec);

		daSpec=com.ibm.ws.ejbpersistence.beanextensions.DataAccessSpecFactory.getDataAccessSpec();
		iSpec=new com.ibm.ws.rsadapter.cci.WSInteractionSpecImpl();
		iSpec.setFunctionSetName("com.wsbook.casestudy.ejb.websphere_deploy.DB2UDBNT_V8_1.EmployeeEJBBeanFunctionSet_96c219b7");
		iSpec.setFunctionName("StoreUsingOCC");
		daSpec.setInteractionSpec(iSpec);
		daSpec.setSpecName("Store");
		daSpec.setInputRecordName("Store");
		daSpec.setOptimistic(true);
		daSpec.setType(com.ibm.ws.ejbpersistence.beanextensions.EJBDataAccessSpec.STORE_BEAN);
		daSpec.setQueryScope(new String[]{"EmployeeEJB"});
		result.add(daSpec);

		daSpec=com.ibm.ws.ejbpersistence.beanextensions.DataAccessSpecFactory.getDataAccessSpec();
		iSpec=new com.ibm.ws.rsadapter.cci.WSInteractionSpecImpl();
		iSpec.setFunctionSetName("com.wsbook.casestudy.ejb.websphere_deploy.DB2UDBNT_V8_1.EmployeeEJBBeanFunctionSet_96c219b7");
		iSpec.setFunctionName("FindAll");
		daSpec.setInteractionSpec(iSpec);
		daSpec.setSpecName("FindAll");
		daSpec.setInputRecordName("FindAll");
		daSpec.setOptimistic(false);
		daSpec.setType(com.ibm.ws.ejbpersistence.beanextensions.EJBDataAccessSpec.FIND_BEAN);
		daSpec.setQueryScope(new String[]{"EmployeeEJB"});
		daSpec.setReadAccess(true);
		daSpec.setAllowDuplicates(true);
		daSpec.setContainsDuplicates(true);
		daSpec.setSingleResult(false);
		daSpec.setExtractor(new com.ibm.ws.ejbpersistence.dataaccess.WholeRowExtractor(getExtractor()));
		result.add(daSpec);

		daSpec=com.ibm.ws.ejbpersistence.beanextensions.DataAccessSpecFactory.getDataAccessSpec();
		iSpec=new com.ibm.ws.rsadapter.cci.WSInteractionSpecImpl();
		iSpec.setFunctionSetName("com.wsbook.casestudy.ejb.websphere_deploy.DB2UDBNT_V8_1.EmployeeEJBBeanFunctionSet_96c219b7");
		iSpec.setFunctionName("FindAllForUpdate");
		daSpec.setInteractionSpec(iSpec);
		daSpec.setSpecName("FindAll");
		daSpec.setInputRecordName("FindAll");
		daSpec.setOptimistic(false);
		daSpec.setType(com.ibm.ws.ejbpersistence.beanextensions.EJBDataAccessSpec.FIND_BEAN);
		daSpec.setQueryScope(new String[]{"EmployeeEJB"});
		daSpec.setReadAccess(false);
		daSpec.setAllowDuplicates(true);
		daSpec.setContainsDuplicates(true);
		daSpec.setSingleResult(false);
		daSpec.setExtractor(new com.ibm.ws.ejbpersistence.dataaccess.WholeRowExtractor(getExtractor()));
		result.add(daSpec);

		daSpec=com.ibm.ws.ejbpersistence.beanextensions.DataAccessSpecFactory.getDataAccessSpec();
		iSpec=new com.ibm.ws.rsadapter.cci.WSInteractionSpecImpl();
		iSpec.setFunctionSetName("com.wsbook.casestudy.ejb.websphere_deploy.DB2UDBNT_V8_1.EmployeeEJBBeanFunctionSet_96c219b7");
		iSpec.setFunctionName("FindByPrimaryKey");
		daSpec.setInteractionSpec(iSpec);
		daSpec.setSpecName("FindByPrimaryKey");
		daSpec.setInputRecordName("FindByPrimaryKey");
		daSpec.setOptimistic(false);
		daSpec.setType(com.ibm.ws.ejbpersistence.beanextensions.EJBDataAccessSpec.FIND_PK);
		daSpec.setQueryScope(new String[]{"EmployeeEJB"});
		daSpec.setReadAccess(true);
		daSpec.setAllowDuplicates(false);
		daSpec.setContainsDuplicates(false);
		daSpec.setSingleResult(true);
		daSpec.setExtractor(new com.ibm.ws.ejbpersistence.dataaccess.WholeRowExtractor(getExtractor()));
		result.add(daSpec);

		daSpec=com.ibm.ws.ejbpersistence.beanextensions.DataAccessSpecFactory.getDataAccessSpec();
		iSpec=new com.ibm.ws.rsadapter.cci.WSInteractionSpecImpl();
		iSpec.setFunctionSetName("com.wsbook.casestudy.ejb.websphere_deploy.DB2UDBNT_V8_1.EmployeeEJBBeanFunctionSet_96c219b7");
		iSpec.setFunctionName("FindByPrimaryKey444Update");
		daSpec.setInteractionSpec(iSpec);
		daSpec.setSpecName("FindByPrimaryKey");
		daSpec.setInputRecordName("FindByPrimaryKey");
		daSpec.setOptimistic(false);
		daSpec.setType(com.ibm.ws.ejbpersistence.beanextensions.EJBDataAccessSpec.FIND_PK);
		daSpec.setQueryScope(new String[]{"EmployeeEJB"});
		daSpec.setReadAccess(false);
		daSpec.setAllowDuplicates(false);
		daSpec.setContainsDuplicates(false);
		daSpec.setSingleResult(true);
		daSpec.setExtractor(new com.ibm.ws.ejbpersistence.dataaccess.WholeRowExtractor(getExtractor()));
		result.add(daSpec);

		daSpec=com.ibm.ws.ejbpersistence.beanextensions.DataAccessSpecFactory.getDataAccessSpec();
		iSpec=new com.ibm.ws.rsadapter.cci.WSInteractionSpecImpl();
		iSpec.setFunctionSetName("com.wsbook.casestudy.ejb.websphere_deploy.DB2UDBNT_V8_1.EmployeeEJBBeanFunctionSet_96c219b7");
		iSpec.setFunctionName("findEmployeeByHomeAddressKey_Local");
		daSpec.setInteractionSpec(iSpec);
		daSpec.setSpecName("findEmployeeByHomeAddressKey_Local");
		daSpec.setInputRecordName("findEmployeeByHomeAddressKey_Local");
		daSpec.setOptimistic(false);
		daSpec.setType(com.ibm.ws.ejbpersistence.beanextensions.EJBDataAccessSpec.FIND_BEAN);
		{
		com.ibm.ws.ejbpersistence.dataaccess.CompleteAssociationList cal=new com.ibm.ws.ejbpersistence.dataaccess.CompleteAssociationList(1);
		cal.add(new String[]{"homeAddress"});daSpec.setCompleteAssociationList(cal);
		}daSpec.setQueryScope(new String[]{"EmployeeEJB"});
		daSpec.setReadAccess(true);
		daSpec.setAllowDuplicates(false);
		daSpec.setContainsDuplicates(false);
		daSpec.setSingleResult(true);
		daSpec.setExtractor(new com.ibm.ws.ejbpersistence.dataaccess.WholeRowExtractor(getExtractor()));
		result.add(daSpec);

		daSpec=com.ibm.ws.ejbpersistence.beanextensions.DataAccessSpecFactory.getDataAccessSpec();
		iSpec=new com.ibm.ws.rsadapter.cci.WSInteractionSpecImpl();
		iSpec.setFunctionSetName("com.wsbook.casestudy.ejb.websphere_deploy.DB2UDBNT_V8_1.EmployeeEJBBeanFunctionSet_96c219b7");
		iSpec.setFunctionName("findEmployeeByHomeAddressKey_LocalForUpdate");
		daSpec.setInteractionSpec(iSpec);
		daSpec.setSpecName("findEmployeeByHomeAddressKey_Local");
		daSpec.setInputRecordName("findEmployeeByHomeAddressKey_Local");
		daSpec.setOptimistic(false);
		daSpec.setType(com.ibm.ws.ejbpersistence.beanextensions.EJBDataAccessSpec.FIND_BEAN);
		{
		com.ibm.ws.ejbpersistence.dataaccess.CompleteAssociationList cal=new com.ibm.ws.ejbpersistence.dataaccess.CompleteAssociationList(1);
		cal.add(new String[]{"homeAddress"});daSpec.setCompleteAssociationList(cal);
		}daSpec.setQueryScope(new String[]{"EmployeeEJB"});
		daSpec.setReadAccess(false);
		daSpec.setAllowDuplicates(false);
		daSpec.setContainsDuplicates(false);
		daSpec.setSingleResult(true);
		daSpec.setExtractor(new com.ibm.ws.ejbpersistence.dataaccess.WholeRowExtractor(getExtractor()));
		result.add(daSpec);

		return result;

	}
}

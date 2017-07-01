package com.wsbook.casestudy.util;

import java.util.PropertyResourceBundle;

public class ApplProperties {

	public static final String EJB_MODEL = "EJB";
	public static final String LOCAL_MODEL = "WEB";
	public static final String PACKAGE_PREFIX =	"com.wsbook.casestudy.model.";

	public static final String EJB_MAPPER = "EJB";
	public static final String JDBC_MAPPER = "JDBC";
	public static final String MEMORY_MAPPER = "MEMORY";

	// Configuration file
    private static final String CONFIG_PROP_FILE = "wasbookConfig";
    private static PropertyResourceBundle properties = (PropertyResourceBundle) PropertyResourceBundle.getBundle(CONFIG_PROP_FILE);
    
    public static String currentMapperName = properties.getString("wasbook.persistence.name");
    public static String modelType = properties.getString("wasbook.model.impl.name");
    public static String datasourceJndiName = properties.getString("wasbook.datasource.name");
    public static String datasourceSchema = properties.getString("wasbook.datasource.schema");

    

	/**
	 * Gets the currentMapperName
	 * @return Returns a String
	 */
	public static String getCurrentMapperName() {
		return currentMapperName;
	}
	
	/**
	 * Gets the modelType
	 * @return Returns a String
	 */
	public static String getModelType() {
		return modelType;
	}

	/**
	 * Gets the datasourceJndiName
	 * @return Returns a String
	 */
	public static String getDatasourceJndiName() {
		return datasourceJndiName;
	}

	/**
	 * Gets the datasourceSchema
	 * @return Returns a String
	 */
	public static String getDatasourceSchema() {
		return datasourceSchema;
	}

}


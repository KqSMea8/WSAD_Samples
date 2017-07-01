package com.wsbook.mapping;

import java.util.PropertyResourceBundle;

/** Provides access to external application configuration information 
 * stored in a Java .properties file. This file should be placed at the
 * top of the source folder.
 */
public class ApplicationProperties {


	// Configuration file
    private static PropertyResourceBundle properties = (PropertyResourceBundle) PropertyResourceBundle.getBundle("application");
    
    public static String datasourceJndiName = properties.getString("com.wsbook.mapping.datasource.jdbc.name");
    public static String datasourceSchemaName = properties.getString("com.wsbook.mapping.datasource.jdbc.schemaname");
    public static String datasourceUserId = properties.getString("com.wsbook.mapping.datasource.jdbc.userid");
    public static String datasourcePassword = properties.getString("com.wsbook.mapping.datasource.jdbc.password");

    
    /** Gets the named property from the Java .properties file for the
     * application. 
     */
	public static String getProperty(String name) {
		return properties.getString(name);
	}
	
	/**
	 * Gets the datasource java:comp name for JNDI access. There must be a resource-ref
	 * in the web application deployment descriptor that maps the datasource reference to
	 * the actual JNDI name specified for the data source in the server configuration.
	 * 
	 * @return Returns the java:comp name of the application's data source
	 */
	public static String getDatasourceJndiName() {
		return datasourceJndiName;
	}

	/** Get the data source schema name as is may be different that
	 * the default.
	 * 
	 * @return the data source schema name
	 */	public static String getDatasourceSchemaName() {
		return datasourceSchemaName;
	}
	
	/**
	 * Gets a userid that can access the data source. Generally  this
	 * would be obtained from the client through some login mechanis.
	 * 
	 * @return Returns a userid that can access the data source.
	 */
	public static String getDatasourceUserId() {
		return datasourceUserId;
	}

	/** Gets the password for the authorization id to access the data source.
	 * @return datasource password
	 */	public static String getDatasourcePassword() {
		return datasourcePassword;
	}
}


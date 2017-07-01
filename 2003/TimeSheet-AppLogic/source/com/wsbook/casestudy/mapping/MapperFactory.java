package com.wsbook.casestudy.mapping;

import java.util.HashMap;
import java.util.Map;

import com.wsbook.casestudy.system.AppService;
import com.wsbook.casestudy.system.ClassUtility;
import com.wsbook.casestudy.system.TraceCapable;
import com.wsbook.casestudy.util.ApplProperties;

/**
 * Master mapper factory wsbook casestudy.
 */
public abstract class MapperFactory {
	private static MapperFactory systemMapperFactory = null;
	protected Map mapperCache = new HashMap();

	/**
	 * MapperFactory constructor comment.
	 */
	public MapperFactory() {
		super();
	}

	/**
	 *  Select appropriate classname depending on installed
	 *  SystemMapperFactory.
	 */
	public String computeMapperClassName(Class target) {
		String packageName =
			ClassUtility.computePackageName(target, "domain", "mapping");
		// get specific package qualifier from installed Factory
		packageName = packageName + "." + getBackendQualifier();
		String className = ClassUtility.unqualifiedClassName(target) + "Mapper";
		return packageName + "." + className;
	}

	protected abstract String getBackendQualifier();


	/**
	 * Create and return a Mapper instance for the class
	 * This is accomplished by suffixing a class with "Mapper"
	 */
	public Mapper getMapper(Class target) {
		String aMapperName = computeMapperClassName(target);

		// check registry cache for broker...
		Mapper aMapper = (Mapper) getMapperCache().get(aMapperName);
		if (aMapper != null)
			return aMapper;

		// create the mapper and save
		Class aClass = null;
		try {
			aClass = Class.forName(aMapperName);
		} catch (ClassNotFoundException e) {
			AppService.log(TraceCapable.ERROR_LEVEL,"Mapper, " + aMapperName + ", not defined...");
		}
		try {
			aMapper = (Mapper) aClass.newInstance();
			getMapperCache().put(aMapperName, aMapper);
		} catch (InstantiationException e) {
			AppService.log(TraceCapable.ERROR_LEVEL,e.toString());
		} catch (IllegalAccessException e) {
			AppService.log(TraceCapable.ERROR_LEVEL,e.toString());
		}
		return aMapper;
	}

	public Map getMapperCache() {
		return mapperCache;
	}

	private static Map getMapperFactoryNameMap() {
		Map map = new HashMap();
		map.put(ApplProperties.EJB_MAPPER, "com.wsbook.casestudy.mapping.EjbMapperFactory");
		map.put(ApplProperties.JDBC_MAPPER, "com.wsbook.casestudy.mapping.JdbcMapperFactory");
		map.put(ApplProperties.MEMORY_MAPPER, "com.wsbook.casestudy.mapping.MemoryMapperFactory");
		return map;
	}

	public static MapperFactory getSystemMapperFactory() {
		if (systemMapperFactory == null) {
			String className =
				(String) getMapperFactoryNameMap().get(ApplProperties.getCurrentMapperName());
			Class aClass = null;
			try {
				aClass = Class.forName(className);
			} catch (ClassNotFoundException e) {
				AppService.log(TraceCapable.ERROR_LEVEL,"Mapper Factory, " + className + ", not defined...");
			}
			try {
				setSystemMapperFactory((MapperFactory) aClass.newInstance());
			} catch (InstantiationException e) {
				AppService.log(TraceCapable.ERROR_LEVEL,e.toString());
			} catch (IllegalAccessException e) {
				AppService.log(TraceCapable.ERROR_LEVEL,e.toString());
			}

		}
		return systemMapperFactory;

	}

	private void setMapperCache(java.util.Map newMapperCache) {
		mapperCache = newMapperCache;
	}

	private static void setSystemMapperFactory(MapperFactory factory) {
		systemMapperFactory = factory;
	}

/*	public static void setSystemMapperFactory(String id) {
		setCurrentMapperName(id);
		systemMapperFactory = null;
		getSystemMapperFactory();
	}
	*/
}
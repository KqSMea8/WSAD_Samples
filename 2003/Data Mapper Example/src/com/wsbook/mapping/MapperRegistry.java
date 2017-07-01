package com.wsbook.mapping;

import java.util.HashMap;
import java.util.Map;

import com.wsbook.acme.Department;
import com.wsbook.acme.Employee;
import com.wsbook.acme.Personnel;
import com.wsbook.acme.Purchasing;
import com.wsbook.acme.mappers.DepartmentMapper;
import com.wsbook.acme.mappers.EmployeeMapper;
import com.wsbook.acme.mappers.PersonnelMapper;
import com.wsbook.acme.mappers.PurchasingMapper;

/** Implements the Registry (480) pattern to return Mappers for domain
 * model classes. 
 * 
 * @author jamsden
 *
 */
public class MapperRegistry {
	
	static protected Map registry = new HashMap();

	/** Get the Mapper to use to map domainClass to the data source layer.
	 * 
	 * @param domainClass the Class of the domain model element to map
	 * @return the Mapper class to use to map it to the data source layer
	 */
	public static Mapper getMapper(Class domainClass) {
		if (registry.containsKey(domainClass)) {
			return (Mapper)registry.get(domainClass);
		} else {
			return null;
		}
	}

	// load the default Mapper's for the domain model
	// uses application properties to figure out what data source to use
	static {
		String dataSource = ApplicationProperties.getProperty("com.wsbook.mapping.datasource");
		if (dataSource.equals("jdbc")) {
			registry.put(Employee.class, new EmployeeMapper());
			registry.put(Department.class, new DepartmentMapper());
			registry.put(Personnel.class, new PersonnelMapper());
			registry.put(Purchasing.class, new PurchasingMapper());
		} else if (dataSource.equals("ejb")) {
		} else { // assume "memory"
			registry.put(Employee.class, new TransientObjectMapper());
			registry.put(Department.class, new TransientObjectMapper());
			registry.put(Personnel.class, new TransientObjectMapper());
			registry.put(Purchasing.class, new TransientObjectMapper());
		}
	}
}

package com.wsbook.casestudy.mapping.ejb;

import java.util.Collection;

import javax.ejb.EJBLocalObject;

import com.wsbook.casestudy.domain.Project;
import com.wsbook.casestudy.domain.TsObject;
import com.wsbook.casestudy.ejb.ProjectEJB;
import com.wsbook.casestudy.ejb.ProjectEJBHome;
import com.wsbook.casestudy.exception.MappingException;
import com.wsbook.casestudy.system.AppService;
import com.wsbook.casestudy.system.TraceCapable;

/**
 * This class defines a ProjectFactory for creating/retrieving Projects
 *
 * Creation date: (2/20/00 9:36:28 PM)
 * @author: Administrator
 */
public class ProjectMapper extends DomainEJBMapper implements com.wsbook.casestudy.mapping.ProjectMapper {
	ProjectEJBHome projectHome;
/**
 * EmployeeFactory constructor.
 */
public ProjectMapper() {
	super();
	createInitialContext();
	createProjectHome();
}
/**
 * Create a ProjectEJB corresponding to this Project domain object.
 * Creation date: (2/20/00 9:41:44 PM)
 */
public void insert(TsObject obj) throws MappingException {
	try {
		Project proj = (Project) obj;
		ProjectEJB projectEJB = projectHome.create(proj.getNumber(), proj.getName());
	} catch (Exception e) {
		AppService.log(TraceCapable.ERROR_LEVEL,"Exception " + e + " caught in ProjectFactory.insert()");
		throw new MappingException(e, ("Wrapped Exception " + e + " caught in ProjectFactory.insert()"));
	}
}
/**
 * This method retrieves an instance of ProjectEJBHome from the JNDI initial context.
 * Creation date: (2/19/00 3:02:08 PM)
 */
protected void createProjectHome() {

	 try {
		  projectHome = (ProjectEJBHome)initContext.lookup("java:comp/env/ejb/ProjectEJB");
	 } catch (Exception e)  { // Error getting the home interface
		 AppService.log(TraceCapable.ERROR_LEVEL,"Exception " + e + " in createProjectHome()");
	 } 
	 	
}
/**
 * This method retrieves all ProjectEJB's from the store
 * Creation date: (2/19/00 3:02:08 PM)
 */
protected Collection findAllEJBs() throws MappingException {
	try {
		return projectHome.findAll();
	} catch (Exception e) {
		throw new MappingException(e, ("Wrapped exception caught in findAllEJBs : " + e));
	}
}


/**
 * This method retrieves all ProjectEJB's from the store
 * Creation date: (2/19/00 3:02:08 PM)
 */
public Project findById(String id) throws MappingException {
	try {
		ProjectEJB ejb = projectHome.findByPrimaryKey(id);
		return (Project) map(ejb);
	} catch (Exception e) {
		throw new MappingException(e, ("Wrapped exception caught in findById: " + e));
	}
}


/**
 * This method retrieves all ProjectEJB's from the store
 * Creation date: (2/19/00 3:02:08 PM)
 */
public Project findByName(String name) throws MappingException {
	try {
		ProjectEJB ejb = projectHome.findByName(name);
		return (Project) map(ejb);
	} catch (Exception e) {
		throw new MappingException(e, ("Wrapped exception caught in findByName : " + e));
	}
}

/**
 * Retreive the EJBObject matching this domain object.
 * Creation date: (2/20/00 9:41:44 PM)
 */
protected EJBLocalObject findEJBObjectMatching(TsObject domainObject) throws MappingException{
	ProjectEJB projectEJB = null;
	try {
		Project proj = (Project) domainObject;
		projectEJB = projectHome.findByPrimaryKey(proj.getNumber());
	} catch (Exception e) {
		AppService.log(TraceCapable.ERROR_LEVEL,"Exception " + e + " caught in ProjectFactory.findEJBObjectMatching()");
		throw new MappingException(e, ("Wrapped Exception " + e + " caught in in ProjectFactory.findEJBObjectMatching()"));
	}
	return projectEJB;
}
/**
 * Return an instance of Project created from the ProjectEJB passed in as an argument
 * Creation date: (2/20/00 9:41:44 PM)
 */
public TsObject map(EJBLocalObject input) throws MappingException {
	ProjectEJB ejb;
	try {
		ejb = (ProjectEJB) input;
	} catch (ClassCastException e) {
		throw new MappingException(e, "Attempt to map a non ProjectEJB in ProjectFactory");
	}
	Project proj = null;
	try {
		proj = new Project();
		proj.setNumber((String) ejb.getPrimaryKey());
		proj.setName(ejb.getName());
	} catch (Exception e) {
		AppService.log(TraceCapable.ERROR_LEVEL,"Exception " + e + " caught in ProjectFactory.map()");
		throw new MappingException(e, "Wrapped Exception caught in ProjectFactory.map()");
	}
	return proj;
}
/**
 * Update the EJB corresponding to this domain object. 
 * Creation date: (2/20/00 9:41:44 PM)
 */
public void update(TsObject obj) throws MappingException{
	try {
		Project proj = (Project) obj;
		ProjectEJB projectEJB = projectHome.findByPrimaryKey(proj.getNumber());
		projectEJB.setName(proj.getName());
	} catch (Exception e) {
		AppService.log(TraceCapable.ERROR_LEVEL,"Exception " + e + " caught in ProjectFactory.update()");
		throw new MappingException(e, "Wrapped Exception caught in ProjectFactory.update()");
	}
}
}

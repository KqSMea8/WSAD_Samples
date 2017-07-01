package com.wsbook.casestudy.mapper.jdbc.test;
import junit.framework.TestCase;

import com.wsbook.casestudy.domain.Project;
import com.wsbook.casestudy.exception.MappingException;
import com.wsbook.casestudy.mapping.Mapper;

/**
 * Insert the type's description here.
 * Creation date: (3/16/2001 2:06:58 PM)
 * @author: ILS User
 */
public class ProjectMapperTest extends JDBCMapperTest {
/**
 * CustomerMapperTest constructor comment.
 * @param name java.lang.String
 */
public ProjectMapperTest(String name) {
	super(name);
}

private void shallowVerify(Project refProj, Project compProj) {
	assertNotNull("Mapper failed to retrieve Project ", compProj);
	// Check for name
	String name = compProj.getName();
	assertNotNull("Null name for Project ", name);
	assertEquals("Different retrieved Project name", name, refProj.getName());
	// Check for Number
	assertEquals("Different retrieved Project number", refProj.getNumber(), compProj.getNumber().trim());
}

private Project buildTestProject() {
	Project newProject = new Project();
	newProject.setNumber("P9999");
	newProject.setName("Test Project");
	return newProject;
}

private void changeData(Project projToUpdate) {
	projToUpdate.setName("Changed Project Name");
}

/**
 * Insert the method's description here.
 * Creation date: (3/19/2001 8:32:42 AM)
 */
public void testCreateUpdateRemove() throws MappingException {
	Project newProject = buildTestProject();
	Mapper mapper1 = newProject.getMapper();
	// create object in pStore
	mapper1.insert(newProject);
	Project checkProject = new Project();
	checkProject.setNumber(newProject.getNumber());
	Mapper mapper2 = checkProject.getMapper();
	
	// retrieve newly created object
	Project returnedProject = (Project)mapper2.findByPrimaryKey(checkProject);
	
	// compare that retrieve (populated) data is correct
	shallowVerify(newProject, returnedProject);
	
	// now update data
	changeData(newProject);
	mapper1.update(newProject);
	
	// retrieve updated object
	returnedProject = (Project)mapper2.findByPrimaryKey(checkProject);
	
	// compare that retrieve (populated) data is correct
	shallowVerify(newProject, returnedProject);

	// now remove object from pStore	
	mapper2.remove(checkProject);
	returnedProject = null;
	try {
		returnedProject = (Project)mapper2.findByPrimaryKey(checkProject);
	}
	catch (MappingException me) {}
	assertNull("Failed to remove Project", returnedProject);
}

}
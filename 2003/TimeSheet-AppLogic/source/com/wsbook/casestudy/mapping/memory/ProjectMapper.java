package com.wsbook.casestudy.mapping.memory;

import java.util.*;
import com.wsbook.casestudy.domain.*;
import com.wsbook.casestudy.exception.NoSuchProjectException;
/**
 * This class is the "in-memory" Mapper for Projects.
 * It creates the default collection of Projects.
 *
 * Creation date: (2/3/00 5:25:18 PM)
 * @author: Administrator
 */
public class ProjectMapper extends ObjectMapper implements com.wsbook.casestudy.mapping.ProjectMapper {
	protected static ArrayList cache = null;
	/**
	 * DepartmentMapper constructor comment.
	 */
	public ProjectMapper() {
		super();
	}

	protected ArrayList getCache() {
		if (cache == null) {
			cache = initialLoad();
		}

		return cache;
	}
	/**
	 * Create and return a ArrayList of Project Objects.
	 * Creation date: (2/7/00 7:06:58 PM)
	 */
	ArrayList initialLoad() {
		ArrayList v = new ArrayList();
		Project p = new Project();
		p.setNumber("P1");
		p.setName("Development at ABC Corp.");
		v.add(p);
		p = new Project();
		p.setNumber("P2");
		p.setName("Project work at XYZ Corp.");
		v.add(p);
		return v;
	}
	
	public Project findByName(String name) throws NoSuchProjectException{
		ArrayList projects = getCache();
		ListIterator iter = projects.listIterator();
		Project currentProj = null;
		while (iter.hasNext()) {
			currentProj = (Project)iter.next();
			if (currentProj.getName().equals(name))
				return currentProj;
		}
		throw new NoSuchProjectException("No project matching " + name + " found");
	}
	
	public Project findById(String id) throws NoSuchProjectException{
		ArrayList projects = getCache();
		ListIterator iter = projects.listIterator();
		Project currentProj = null;
		while (iter.hasNext()) {
			currentProj = (Project)iter.next();
			if (currentProj.getNumber().equals(id))
				return currentProj;
		}
		throw new NoSuchProjectException("No project matching " + id + " found");
	}
	
	public TsObject findByPrimaryKey(TsObject input) throws NoSuchProjectException {
		Project proj = (Project) input;
		return findById(proj.getNumber());
	}
	
	public void clearCache() {
		cache = new ArrayList();
	}
}
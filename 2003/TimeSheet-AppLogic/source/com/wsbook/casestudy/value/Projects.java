package com.wsbook.casestudy.value;

import java.io.Serializable;
import java.util.ArrayList;

import com.wsbook.casestudy.domain.Project;



public class Projects implements Serializable {
	private ArrayList projects = null;

	public Projects() {
	}

	public Projects(ArrayList projects) {
		this.projects = projects;
	}

	public Project[] getProject() {
		if (projects == null) return null;
		int numToCopy = projects.size();
		Project[] projs = new Project[numToCopy];
		for (int i = 0; i < numToCopy; i++) {
			projs[i] = (Project) projects.get(i);
		}
		return projs;
	}

	public Project getProject(int index) {
		if (projects == null) return null;
		return (Project) projects.get(index);
	}

}
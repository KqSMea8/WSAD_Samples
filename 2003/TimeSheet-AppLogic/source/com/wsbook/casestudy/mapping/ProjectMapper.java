package com.wsbook.casestudy.mapping;

import com.wsbook.casestudy.domain.Project;
import com.wsbook.casestudy.exception.MappingException;

public interface ProjectMapper extends Mapper {
	public Project findByName(String projectName) throws MappingException;
	public Project findById(String projectId) throws MappingException;

}
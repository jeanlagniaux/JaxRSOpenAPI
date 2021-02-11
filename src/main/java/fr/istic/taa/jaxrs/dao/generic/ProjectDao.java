package fr.istic.taa.jaxrs.dao.generic;

import fr.istic.taa.jaxrs.domain.Project;

public class ProjectDao extends AbstractJpaDao<Long, Project>{

	public ProjectDao() {
		super(Project.class);
	}

}
package fr.istic.taa.jaxrs.dao.generic;

import java.util.List;

import fr.istic.taa.jaxrs.domain.Board;
import fr.istic.taa.jaxrs.domain.Project;
import fr.istic.taa.jaxrs.jpa.EntityManagerHelper;

public class ProjectDao extends AbstractJpaDao<Long, Project> {

	public ProjectDao() {
		super(Project.class);
	}

	public List<Long> getProjects() {
		String query = "select p.id from Project as p";
		return this.entityManager.createQuery(query).getResultList();
	}

	public List<Board> getBoardsByProjectName(String name) {
		String query = "select p.boards from Project as p where p.name = :name";
		return EntityManagerHelper.getEntityManager().createQuery(query).setParameter("name", name).getResultList();
	}

	public List<Board> getBoardsByProjectID(Long id) {
		String query = "select p.boards from Project as p where p.id = :id";
		return EntityManagerHelper.getEntityManager().createQuery(query).setParameter("id", id).getResultList();
	}

}
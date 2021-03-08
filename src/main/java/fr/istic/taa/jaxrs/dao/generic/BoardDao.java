package fr.istic.taa.jaxrs.dao.generic;

import java.util.List;

import fr.istic.taa.jaxrs.domain.Board;
import fr.istic.taa.jaxrs.domain.Card;
import fr.istic.taa.jaxrs.domain.User;
import fr.istic.taa.jaxrs.jpa.EntityManagerHelper;

public class BoardDao extends AbstractJpaDao<Long, Board>{

	public BoardDao() {
		super(Board.class);
	}

	public List<String> getBoards() {
		String query = "select b.name from Board as b";
		return this.entityManager.createQuery(query).getResultList();
	}

	public Board getBoardById(long id) {
		String query = "select b from Board as b where b.id = :id";
		return EntityManagerHelper.getEntityManager().createQuery(query, Board.class).setParameter("id", id)
				.getSingleResult();
	}

	public List<Card> getBoardCardsByName(String name) {
		String query = "select b.cards from Board as b where b.name = :name";
		return EntityManagerHelper.getEntityManager().createQuery(query).setParameter("name", name).getResultList();
	}

	public List<User> getBoardUsersByName(String name) {
		String query = "select b.users from Board as b where b.name = :name";
		return EntityManagerHelper.getEntityManager().createQuery(query).setParameter("name", name).getResultList();
	}
	
	public List<User> getBoardUsersById(Long id) {
		String query = "select b.users from Board as b where b.id = :id";
		return EntityManagerHelper.getEntityManager().createQuery(query).setParameter("id", id).getResultList();
	}

	
}

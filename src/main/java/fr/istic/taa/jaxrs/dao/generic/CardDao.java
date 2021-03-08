package fr.istic.taa.jaxrs.dao.generic;

import java.util.List;

import fr.istic.taa.jaxrs.domain.Card;
import fr.istic.taa.jaxrs.domain.User;
import fr.istic.taa.jaxrs.jpa.EntityManagerHelper;

public class CardDao extends AbstractJpaDao<Long, Card> {

	public CardDao() {
		super(Card.class);
	}

	public List<User> getAffectedUser() {
		String query = "select u.affectedUser from Card as u";
		return this.entityManager.createQuery(query).getResultList();
	}

	public Card getCardById(Long id) {
		String query = "select c.name from Card as c where c.id = :id";
		return EntityManagerHelper.getEntityManager().createQuery(query, Card.class).setParameter("id", id)
				.getSingleResult();
	}

	public Card getCardByName(String name) {
		String query = "select c from Card as c where c.name = :name";
		return EntityManagerHelper.getEntityManager().createQuery(query, Card.class).setParameter("name", name)
				.getSingleResult();
	}

	public List<String> getBoardsByProjectID(Long id) {
		String query = "select c.tags from Card as c where c.id = :id";
		return EntityManagerHelper.getEntityManager().createQuery(query).setParameter("id", id).getResultList();
	}

}

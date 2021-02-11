package fr.istic.taa.jaxrs.dao.generic;

import java.util.List;

import fr.istic.taa.jaxrs.business.Card;
import fr.istic.taa.jaxrs.business.User;

public class CardDao extends AbstractJpaDao<Long, Card>{

	public CardDao() {
		super(Card.class);
	}

	
	public List<User> getAffectedUser(){
		String query = "select u.affectedUser from Card as u";
		return this.entityManager.createQuery(query).getResultList();
	}
	
}

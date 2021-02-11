package fr.istic.taa.jaxrs.dao.generic;

import java.util.List;

import fr.istic.taa.jaxrs.business.Card;
import fr.istic.taa.jaxrs.business.User;

public class UserDao extends AbstractJpaDao<Long, User>{

	public UserDao() {
		super(User.class);
	}

	
	public List<String> getUsers(){
		
		String query = "select u.mail from User as u";
		return this.entityManager.createQuery(query).getResultList();
		
	}

}

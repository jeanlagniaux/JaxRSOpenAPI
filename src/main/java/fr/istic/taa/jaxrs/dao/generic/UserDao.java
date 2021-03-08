package fr.istic.taa.jaxrs.dao.generic;

import java.util.List;

import fr.istic.taa.jaxrs.domain.Board;
import fr.istic.taa.jaxrs.domain.Card;
import fr.istic.taa.jaxrs.domain.User;
import fr.istic.taa.jaxrs.jpa.EntityManagerHelper;

public class UserDao extends AbstractJpaDao<Long, User> {

	public UserDao() {
		super(User.class);
	}

	public List<String> getUsers() {
		String query = "select u.mail from User as u";
		return this.entityManager.createQuery(query).getResultList();
	}

	public User getUserByMail(String mail) {
		String query = "select u from User as u where u.mail = :mail";
		return EntityManagerHelper.getEntityManager().createQuery(query, User.class).setParameter("mail", mail)
				.getSingleResult();
	}

	public List<Board> getUserBoardByMail(String mail) {
		String query = "select u.myBoards from User as u where u.mail = :mail";
		return EntityManagerHelper.getEntityManager().createQuery(query).setParameter("mail", mail).getResultList();
	}

	public List<Card> getUserCardsByMail(String mail) {
		String query = "select u.cards from User as u where u.mail = :mail";
		return EntityManagerHelper.getEntityManager().createQuery(query).setParameter("mail", mail).getResultList();
	}

}

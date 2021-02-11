package fr.istic.taa.jaxrs.jpa;

import javax.persistence.EntityManager;

import fr.istic.taa.jaxrs.dao.generic.CardDao;
import fr.istic.taa.jaxrs.dao.generic.UserDao;
import fr.istic.taa.jaxrs.domain.Card;
import fr.istic.taa.jaxrs.domain.User;

public class JpaTest {

	private EntityManager manager;

	public JpaTest(EntityManager manager) {
		this.manager = manager;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		/**
		 * Lien pour montrer les valeurs jdbc:hsqldb:hsql://localhost/
		 */


		UserDao daoU = new UserDao();
		
		System.out.println(daoU.getUserByMail("pablo@mail.con"));
		
		CardDao dao = new CardDao();
//		Card card = new Card();
//		card.setName("tache4");
//		card.setStatus("DOING");
//		card.setAffectedUser(user);
//		dao.save(card);
		
		// System.out.println("user : "+ dao.getAffectedUser().get(0).getName());
		

		// test
		try {

			// catch
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}

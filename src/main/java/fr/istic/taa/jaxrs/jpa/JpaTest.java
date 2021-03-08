package fr.istic.taa.jaxrs.jpa;

import java.util.ArrayList;

import javax.persistence.EntityManager;

import fr.istic.taa.jaxrs.dao.generic.BoardDao;
import fr.istic.taa.jaxrs.dao.generic.CardDao;
import fr.istic.taa.jaxrs.dao.generic.ProjectDao;
import fr.istic.taa.jaxrs.dao.generic.UserDao;
import fr.istic.taa.jaxrs.domain.Board;
import fr.istic.taa.jaxrs.domain.Card;
import fr.istic.taa.jaxrs.domain.Project;
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
		
		init();
		
		try {

			// catch
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	private static void init() {
		// PROJECT
				ProjectDao daoP = new ProjectDao();
				Project project = new Project();
				project.setName("le project");
				daoP.save(project);
				// BOARD
				BoardDao daoB = new BoardDao();
				Board board = new Board();
				ArrayList<Board> boards = new ArrayList<Board>();
				board.setName("mon tableau");
				board.setDescription("le premier tableau de notre projet");
				boards.add(board);
				daoB.save(board);
				
				project.setBoards(boards);
				daoP.save(project);
				
				board.setMyProject(project);
				daoB.save(board);
				// CARD
				CardDao daoC = new CardDao();
				Card card = new Card();
				ArrayList<Card> cards = new ArrayList<Card>();
				card.setName("Implémenter les querry");
				card.setNote("il faut finir toute les querry pour passer a l'étape suivante");
				card.setTimeToDO(2);
				card.setStatus("TODO"); // faire une classe status
				// card.setEndDate();
				cards.add(card);
				daoC.save(card);

				board.setCards(cards);
				daoB.save(board);
				
				card.setMyBoard(board);
				daoC.save(card);

				// USER
				UserDao daoU = new UserDao();
				User user = new User();
				ArrayList<User> users = new ArrayList<User>();
				ArrayList<Board> myBoards = new ArrayList<Board>();
				myBoards.add(board);
				
				user.setMail("aaaaaaa@mail.com");
				user.setName("aaaa");
				user.setCards(cards);
				user.setMyBoards(myBoards);
				
				users.add(user);
				daoU.save(user);
				
				board.setUsers(users);
				daoB.save(board);
				
				card.setAffectedUser(user);
				daoC.save(card);		
	}

}

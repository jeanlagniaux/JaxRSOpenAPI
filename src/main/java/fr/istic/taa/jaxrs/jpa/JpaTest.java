package fr.istic.taa.jaxrs.jpa;

import java.util.ArrayList;
import java.util.List;

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
		
		//init();
		
		/*
		UserDao daoU = new UserDao();
		Board b = new Board();
		List<Board> bds = new ArrayList<Board>();
		bds = daoU.getUserBoardByMail("aaaaaaa@mail.com");
		for (Board board : bds) {
			//System.out.println(board.getId());
		}
		
		Card c = new Card();
		List<Card> cs = new ArrayList<Card>();
		cs = daoU.getUserCardsByMail("aaaaaaa@mail.com");
		for (Card card : cs) {
			//System.out.println(card.getId());
		}
		
		ProjectDao daoP = new ProjectDao();
		List<Long> s = new ArrayList<Long>();
		s = daoP.getProject();
		for (Long long1 : s) {
			System.out.println(long1);
		}
		
		List<Board> b = new ArrayList<Board>();
		b = daoP.getBoardsByProjectName("le project");
		for (Board board : b) {
			System.out.println(board.getId());
		}
		
		List<Board> bs = new ArrayList<Board>();
		bs = daoP.getBoardsByProjectID((long) 9);
		for (Board board : bs) {
			System.out.println(board.getId());
		}
		
		*/
		
		BoardDao daoB = new BoardDao();
		List<Card> cs = new ArrayList<Card>();
		cs = daoB.getBoardCardsByName("mon tableau");
		for (Card card : cs) {
			//System.out.println(card.getId());
		}
		
		List<User> us = new ArrayList<User>();
		us = daoB.getBoardUsersByName("mon tableau");
		for (User user : us) {
			System.out.println(user.getName());
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

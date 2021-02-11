package fr.istic.taa.jaxrs.business;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

@Entity
public class User implements Serializable{
	
	private String mail;
	private String name;
	
	private List<Board> myBoards = new ArrayList<Board>();
	private List<Card> cards = new ArrayList<Card>();
	
	
	

	public User() {
	}

	@Id
	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@OneToMany(mappedBy = "affectedUser")
	public List<Card> getCards() {
		return cards;
	}

	public void setCards(List<Card> cards) {
		this.cards = cards;
	}

	@ManyToMany
	public List<Board> getMyBoards() {
		return myBoards;
	}

	public void setMyBoards(List<Board> myBoards) {
		this.myBoards = myBoards;
	}
	
	
	
	

}

package fr.istic.taa.jaxrs.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@XmlRootElement(name = "User")
public class User implements Serializable {

	private String mail;
	private String name;

	private List<Board> myBoards = new ArrayList<Board>();
	private List<Card> cards = new ArrayList<Card>();

	public User() {
	}

	@Id
	@XmlElement(name = "mail")
	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	@XmlElement(name = "name")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@OneToMany(mappedBy = "affectedUser")
	@XmlElementWrapper(name = "cards")
	@XmlElement(name = "card")
	public List<Card> getCards() {
		return cards;
	}

	public void setCards(List<Card> cards) {
		this.cards = cards;
	}

	@ManyToMany
	@XmlElementWrapper(name = "boards")
	@XmlElement(name = "board")
	public List<Board> getMyBoards() {
		return myBoards;
	}

	public void setMyBoards(List<Board> myBoards) {
		this.myBoards = myBoards;
	}

}

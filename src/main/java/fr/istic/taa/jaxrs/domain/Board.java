package fr.istic.taa.jaxrs.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;

@Entity
public class Board implements Serializable {
	private Long id;
	private String name;
	private String description;
	private Project myProject;
	private List<Card> cards = new ArrayList<Card>();
	private List<User> users = new ArrayList<User>();
	// private User Owner;

	public Board() {
	}

	@Id
	@GeneratedValue
	@XmlElement(name = "BoardID")
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@XmlElement(name = "BoardName")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@XmlElement(name = "BoardDesc")
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@OneToMany(mappedBy = "myBoard")
	@XmlElementWrapper(name = "cards")
	@XmlElement(name = "card")
	public List<Card> getCards() {
		return cards;
	}

	public void setCards(List<Card> cards) {
		this.cards = cards;
	}

	@ManyToMany(mappedBy = "myBoards")
	@XmlElementWrapper(name = "Users")
	@XmlElement(name = "user")
	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

	@ManyToOne
	@XmlElementWrapper(name = "Projects")
	@XmlElement(name = "BoardProject")
	public Project getMyProject() {
		return myProject;
	}

	public void setMyProject(Project myProject) {
		this.myProject = myProject;
	}

}

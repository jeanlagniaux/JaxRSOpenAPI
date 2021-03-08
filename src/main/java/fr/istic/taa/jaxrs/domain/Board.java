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

@Entity
public class Board implements Serializable {
	private Long id;
	private String Name;
	private String Description;
	private Project myProject;
	private List<Card> cards = new ArrayList<Card>();
	private List<User> users = new ArrayList<User>();
	// private User Owner;

	public Board() {
	}

	@Id
	@GeneratedValue
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public String getDescription() {
		return Description;
	}

	public void setDescription(String description) {
		Description = description;
	}

	@OneToMany(mappedBy = "myBoard")
	public List<Card> getCards() {
		return cards;
	}

	public void setCards(List<Card> cards) {
		this.cards = cards;
	}

	@ManyToMany(mappedBy = "myBoards")
	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

	@ManyToOne
	public Project getMyProject() {
		return myProject;
	}

	public void setMyProject(Project myProject) {
		this.myProject = myProject;
	}

}

package fr.istic.taa.jaxrs.domain;

import java.io.Serializable;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@XmlRootElement(name = "Card")
public class Card implements Serializable {

	private Long id;
	private String name;
	private String note;
	private int timeToDO;
	private String status;
	private Date endDate;
	private User affectedUser;
	private List<String> tags = new ArrayList<String>();
	private String url;
	private Board myBoard;

	public Card() {
	}

	@Id
	@GeneratedValue
	@XmlElement(name = "CardID")
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	@XmlElement(name = "CardName")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	@XmlElement(name = "CardNote")
	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}
	
	@XmlElement(name = "CardTODO")
	public int getTimeToDO() {
		return timeToDO;
	}

	public void setTimeToDO(int timeToDO) {
		this.timeToDO = timeToDO;
	}
	@XmlElement(name = "CardStatus")
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	@XmlElement(name = "CardEndDate")
	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	@ManyToOne
	@XmlElementWrapper(name = "Users")
	@XmlElement(name = "User")
	@JsonIgnore
	public User getAffectedUser() {
		return affectedUser;
	}

	public void setAffectedUser(User affectedUser) {
		this.affectedUser = affectedUser;
	}

	@Column
	@ElementCollection
	@XmlElementWrapper(name = "Tags")
	@XmlElement(name = "tag")
	public List<String> getTags() {
		return tags;
	}

	public void setTags(List<String> tags) {
		this.tags = tags;
	}
	
	@XmlElement(name = "CardUrl")
	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	@ManyToOne
	@XmlElement(name = "CardBoard")
	public Board getMyBoard() {
		return myBoard;
	}

	public void setMyBoard(Board myBoard) {
		this.myBoard = myBoard;
	}

	@Override
	public String toString() {
		return "Card [id=" + id + ", name=" + name + ", note=" + note + ", timeToDO=" + timeToDO + ", status=" + status
				+ ", endDate=" + endDate + ", affectedUser=" + affectedUser + ", tags=" + tags + ", url=" + url + "]";
	}

}

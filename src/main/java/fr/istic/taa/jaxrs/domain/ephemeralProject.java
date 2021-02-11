package fr.istic.taa.jaxrs.domain;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Entity;

@Entity
public class ephemeralProject extends Project implements Serializable{

	private Date beginDate;
	private Date endDate;
	
	
	public Date getBeginDate() {
		return beginDate;
	}
	public void setBeginDate(Date beginDate) {
		this.beginDate = beginDate;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	
	
	
}

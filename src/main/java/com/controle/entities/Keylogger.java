package com.controle.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Keylogger implements Serializable {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private String chaine;
	@Column(columnDefinition="TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
	private Date date;
	@ManyToOne
	@JoinColumn(name="ID_USER")
	private User user;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	
	public String getChaine() {
		return chaine;
	}
	public void setChaine(String chaine) {
		this.chaine = chaine;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Keylogger(String chaine, Date date) {
		super();
		this.chaine = chaine;
		this.date = date;
	}
	public Keylogger() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}

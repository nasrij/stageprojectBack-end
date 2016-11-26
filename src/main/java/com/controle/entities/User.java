package com.controle.entities;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;


@Entity
@Table(name="users")
public class User implements Serializable {
	
	@Id
	private String machineName;
	private String nom;
	private String prenom;
	private String email;
	private String password;
	@Column(columnDefinition="TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
	private Date date;
	@ManyToOne
	@JoinColumn(name="code_config")
	private Configuration configuration;
	private String username;
	private boolean activated;
	private String passforget; 
	private boolean passforgetActived;
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public Collection<Role> getRoles() {
		return roles;
	}
	public void setRoles(Collection<Role> roles) {
		this.roles = roles;
	}
	@ManyToMany
	@JoinTable(name="USERS_ROLES",joinColumns=@JoinColumn(name="USER_ID", referencedColumnName="machineName"),
		      inverseJoinColumns=@JoinColumn(name="ROLE_ID", referencedColumnName="role"))
	private Collection<Role> roles;
	
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public Configuration getConfiguration() {
		return configuration;
	}
	public void setConfiguration(Configuration configuration) {
		this.configuration = configuration;
	}
	public String getMachineName() {
		return machineName;
	}
	public void setMachineName(String machineName) {
		this.machineName = machineName;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@JsonIgnore
	public String getPassword() {
		return password;
	}
	@JsonProperty
	public void setPassword(String password) {
		this.password = password;
	}
	
	public boolean isActivated() {
		return activated;
	}
	public void setActivated(boolean activated) {
		this.activated = activated;
	}
	
	@JsonIgnore
	public String getPassforget() {
		return passforget;
	}
	@JsonProperty
	public void setPassforget(String passforget) {
		this.passforget = passforget;
	}
	
	
	public boolean isPassforgetActived() {
		return passforgetActived;
	}
	public void setPassforgetActived(boolean passforgetActived) {
		this.passforgetActived = passforgetActived;
	}
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	public User(String machineName, String nom, String prenom, String email, String password, Date date,
			Configuration configuration, String username, boolean activated) {
		super();
		this.machineName = machineName;
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.password = password;
		this.date = date;
		this.configuration = configuration;
		this.username = username;
		this.activated = activated;
	}
	
	public User(String machineName, String nom, String prenom, String email, String password, Date date,
			Configuration configuration, String username, boolean activated,String passforget,boolean passforgetActived) {
		super();
		this.machineName = machineName;
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.password = password;
		this.date = date;
		this.configuration = configuration;
		this.username = username;
		this.activated = activated;
		this.passforget = passforget;
		this.passforgetActived = passforgetActived;
	}
	
	
	
	
	
	

}

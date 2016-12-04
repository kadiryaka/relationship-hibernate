package com.kadiryaka.entity;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "T_USER_PARENT")
public class UserParent implements Serializable {

	private static final long serialVersionUID = 431513511184317425L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "PARENT_ID")
	private Long id;
	
	@Column(name = "MOTHER")
	private String mother;
	
	@Column(name = "FATHER")
	private String father;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="USER_ID")
	public User user;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getMother() {
		return mother;
	}

	public void setMother(String mother) {
		this.mother = mother;
	}

	public String getFather() {
		return father;
	}

	public void setFather(String father) {
		this.father = father;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	
}

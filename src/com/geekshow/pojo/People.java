package com.geekshow.pojo;

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
@Table(name="t_people")
public class People implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)//strategy=GenerationType.IDENTITY 自增长
	@Column(name="peopleid")
	private Integer peopleid;
	
	@Column(name="peoplename")
	private String peoplename;
	
	@Column(name="peopleage")
	private Integer peopleage;
	
	@OneToOne(cascade=CascadeType.PERSIST)
	//@JoinColumn：就是维护一个外键
	@JoinColumn(name="card_id")
	private Card card;

	public Integer getPeopleid() {
		return peopleid;
	}

	public void setPeopleid(Integer peopleid) {
		this.peopleid = peopleid;
	}

	public String getPeoplename() {
		return peoplename;
	}

	public void setPeoplename(String peoplename) {
		this.peoplename = peoplename;
	}

	public Integer getPeopleage() {
		return peopleage;
	}

	public void setPeopleage(Integer peopleage) {
		this.peopleage = peopleage;
	}

	public Card getCard() {
		return card;
	}

	public void setCard(Card card) {
		this.card = card;
	}

	@Override
	public String toString() {
		return "People [peopleid=" + peopleid + ", peoplename=" + peoplename + ", peopleage=" + peopleage + ", card="
				+ card + "]";
	}

}

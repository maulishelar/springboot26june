package org.com.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Employee")
public class Employee {

	@Id
	@Column(name="NBR")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int nbr;
	@Column(name="NAME")
	private String name;
	@Column(name="EID")
	private String eid;
	@Column(name="EMAIL")
	private String email;
	
	public Employee(String name, String eid, String email) {
		super();
		this.name = name;
		this.eid = eid;
		this.email = email;
	}
	
	public Employee() {
	super();
	}
	public int getNbr() {
		return nbr;
	}
	public void setNbr(int nbr) {
		this.nbr = nbr;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEid() {
		return eid;
	}
	public void setEid(String eid) {
		this.eid = eid;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
}

package com.example.demo;
import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;
@Getter
@Setter


@JsonIgnoreProperties("hibernateLazyInitializer")
@Entity
@Table(name="Developer")
public class Developer implements Serializable{
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)

	private int id;
	
	private String firstname;

	private String lastname;

	private String email;
	
	private int exp;
	public Developer() {
		super();
	}
	public Developer(int id, String firstname, String lastname, String email, int exp) {
		super();
		this.id = id;
		this.firstname = firstname;
		this.lastname = lastname;
		this.email = email;
		this.exp = exp;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getExp() {
		return exp;
	}
	public void setExp(int exp2) {
		this.exp = exp2;
	}
	@Override
	public String toString() {
		return "Developer [id=" + id + ", firstname=" + firstname + ", lastname=" + lastname + ", email=" + email
				+ ", exp=" + exp + "]";
	}
	
	
	
	


	//public boolean hasSkill(Skill skill) {
		//for(Skill containedSkill:getSkills()) {
		//	if(containedSkill.getId()==skill.getId()) {
			//	return true;
			//}
			
		//}
		//return false;
	//}
	

}

package com.example.demo;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Getter;
import lombok.Setter;
@JsonIgnoreProperties("hibernateLazyInitializer")
@Setter
@Getter


@Entity
@Table(name="Skill")
public class Skill {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	@Column(name="label")
	private String label;
	@Column(name="description")
	private String description;


	public Skill() {
		super();
	}
	
	public Skill(int id, String label, String description) {
		super();
		this.id = id;
		this.label = label;
		this.description = description;
	
	}

	public Skill(String label, String description) {
		super();
		this.label = label;
		this.description = description;
		
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getLabel() {
		return label;
	}
	public void setLabel(String label) {
		this.label = label;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}

	
}

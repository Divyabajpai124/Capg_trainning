package com.example.demo;

import java.sql.Date;
import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.boot.autoconfigure.domain.EntityScan;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;
@JsonIgnoreProperties("hibernateLazyInitializer")
@Setter
@Getter
@Entity

public class Project2  implements Serializable{
	@Id
	int proid;
	String pname;
	Date Strtdate;
	Date endate;
	public Project2() {
		super();
	}
	public Project2(int proid, String pname, Date strtdate, Date endate) {
		super();
		this.proid = proid;
		this.pname = pname;
		Strtdate = strtdate;
		this.endate = endate;
	}
	public int getProid() {
		return proid;
	}
	public void setProId(int proid) {
		this.proid = proid;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public Date getStrtdate() {
		return Strtdate;
	}
	public void setStrtdate(Date strtdate) {
		Strtdate = strtdate;
	}
	public Date getEndate() {
		return endate;
	}
	public void setEndate(Date endate) {
		this.endate = endate;
	}
	@Override
	public String toString() {
		return "Project [proId=" + proid + ", pname=" + pname + ", Strtdate=" + Strtdate + ", endate=" + endate + "]";
	}
	

}

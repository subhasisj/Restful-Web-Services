package com.rest.webservices.restfulwebservices.user;

import java.util.Date;

import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

public class User {
	
	private Integer id;
	
	@Size(min = 2, message = "Name must have atleast 2 chararcters" )
	private String name;
	
	@Past
	private Date birthDate;

	protected User() {
	}

	public User(Integer id, String name, Date birthDate) {
		super();
		this.id = id;
		this.name = name;
		this.birthDate = birthDate;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public Integer getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}
	

	public void setId(Integer id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", birthDate=" + birthDate + "]";
	}
	
	

}

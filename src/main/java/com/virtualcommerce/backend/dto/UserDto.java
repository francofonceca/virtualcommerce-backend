package com.virtualcommerce.backend.dto;

import javax.persistence.*;

@Entity
@Table(name = "users")
public class UserDto {
	
	@Id
	private Integer id;
	
	@Column(name = "name")
	private String name;

	@Column(name = "secondname")
	private String secondName;
	
	@Column(name = "email")
	private String email;

	@Column(name = "password")
	private String password;
	
	public UserDto() {}

	public UserDto(Integer id, String name, String secondName, String email, String password) {
		super();
		this.id = id;
		this.name = name;
		this.secondName = secondName;
		this.email = email;
		this.password = password;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSecondName() {
		return secondName;
	}

	public void setSecondName(String secondName) {
		this.secondName = secondName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}

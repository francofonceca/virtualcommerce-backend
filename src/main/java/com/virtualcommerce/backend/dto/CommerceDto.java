package com.virtualcommerce.backend.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "commerce")
public class CommerceDto {

	@Id
	private Integer id;
	
	@Column(name = "iduser")
	private Integer idUser;

	@Column(name = "name")
	private String name;

	@Column(name = "description")
	private String description;

	@Column(name = "location")
	private String location;

	@Column(name = "phone")
	private Integer phone;

	@Column(name = "schedules")
	private String schedules;

	@Column(name = "score")
	private Integer score;

	
	
	public CommerceDto() {}

	public CommerceDto(Integer id, Integer idUser, String name, String description, String location, Integer phone,
			String schedules, Integer score) {
		super();
		this.id = id;
		this.idUser = idUser;
		this.name = name;
		this.description = description;
		this.location = location;
		this.phone = phone;
		this.schedules = schedules;
		this.score = score;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getIdUser() {
		return idUser;
	}

	public void setIdUser(Integer idUser) {
		this.idUser = idUser;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public Integer getPhone() {
		return phone;
	}

	public void setPhone(Integer phone) {
		this.phone = phone;
	}

	public String getSchedules() {
		return schedules;
	}

	public void setSchedules(String schedules) {
		this.schedules = schedules;
	}

	public Integer getScore() {
		return score;
	}

	public void setScore(Integer score) {
		this.score = score;
	}
	
}
package com.app.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "hospitals")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Hospital extends BaseEntity{

	@Column(name = "name")
	private String name;
	@Column(name = "city")
	private String city;
	@OneToOne
	@JoinColumn(name = "adminId")
	private User admin;
}
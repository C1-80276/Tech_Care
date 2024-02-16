package com.app.entities;

import java.time.LocalDate;
import java.time.LocalTime;

import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "donations")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Donations extends BaseEntity{

	
	private LocalDate donationDate;
	
	private User donor;
	
	private PatientsRequest patient;
}

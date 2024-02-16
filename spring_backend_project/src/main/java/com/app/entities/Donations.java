package com.app.entities;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
	
	@JoinColumn(name = "userId")
	@ManyToOne
	private User donor;

	@JoinColumn(name = "hospitalId")
	@ManyToOne
	private Hospital hospital;
	
}

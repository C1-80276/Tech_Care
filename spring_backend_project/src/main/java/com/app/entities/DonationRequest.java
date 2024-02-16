package com.app.entities;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "patient_donations")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DonationRequest extends BaseEntity{
	
	@JoinColumn(name = "patientRequestId")
	@OneToOne
	private PatientsRequest patientRequest;
	
	@JoinColumn(name = "userId")
	@ManyToOne
	private User donor;
}

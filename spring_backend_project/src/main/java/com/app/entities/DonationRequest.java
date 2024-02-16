package com.app.entities;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

public class DonationRequest extends BaseEntity{
	
	@JoinColumn(name = "patientRequestId")
	@OneToOne
	private PatientsRequest patientRequest;
	
	@JoinColumn(name = "userId")
	@ManyToOne
	private User donor;
}

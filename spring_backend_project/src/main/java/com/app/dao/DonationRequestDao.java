package com.app.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.entities.DonationRequest;
import com.app.entities.PatientsRequest;

public interface DonationRequestDao extends JpaRepository<DonationRequest, Long>{

	List<DonationRequest> findByPatientRequest(PatientsRequest patreq);

}

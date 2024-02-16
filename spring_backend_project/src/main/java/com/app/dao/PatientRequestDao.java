package com.app.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.entities.PatientsRequest;
import com.app.enums.PatientStatus;

public interface PatientRequestDao extends JpaRepository<PatientsRequest, Long>{

	List<PatientsRequest> findByStatus(PatientStatus pending);

}

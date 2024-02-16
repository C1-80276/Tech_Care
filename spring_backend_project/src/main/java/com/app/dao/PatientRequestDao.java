package com.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.entities.PatientsRequest;

public interface PatientRequestDao extends JpaRepository<PatientsRequest, Long>{

}

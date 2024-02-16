package com.app.service;

import java.util.List;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.custom_exceptions.ResourceNotFoundException;
import com.app.dao.HospitalDao;
import com.app.dao.PatientRequestDao;
import com.app.dto.PatientRequestAddDto;
import com.app.entities.Hospital;
import com.app.entities.PatientsRequest;
import com.app.enums.PatientStatus;

@Service
@Transactional
public class PatientRequestImpl implements PatientRequestService{

	@Autowired
	private PatientRequestDao patDao;
	
	@Autowired
	private HospitalDao hospitalDao;
	
	@Autowired
	private ModelMapper mapper;
	
	@Override
	public String addPatientRequest(PatientRequestAddDto patientReq) {
		
		PatientsRequest pat = mapper.map(patientReq, PatientsRequest.class);
		Hospital hospital = hospitalDao.findById(patientReq.getHospitalId())
				.orElseThrow(() -> new ResourceNotFoundException("No hospital found!"));
		
		pat.setHospital(hospital);
		PatientsRequest savedPat = patDao.save(pat);
		if(savedPat == null) return "Something went wrong...";
		return "Patient Added Succesfully!";
	}

	@Override
	public String changeStatus(Long patientId, PatientStatus status) {
		PatientsRequest pat = patDao.findById(patientId)
				.orElseThrow(() -> new ResourceNotFoundException("Patient not found"));
		pat.setStatus(status);
		patDao.save(pat);
		return "Successfully changed status!";
	}

	@Override
	public List<PatientsRequest> findAllByStatus(PatientStatus pending) {
		return patDao.findByStatus(pending);
	}

	
	
	

}

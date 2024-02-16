package com.app.service;

import java.util.List;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import com.app.custom_exceptions.ResourceNotFoundException;
import com.app.dao.HospitalDao;
import com.app.dao.PatientRequestDao;
import com.app.dao.UserDao;
import com.app.dto.PatientRequestAddDto;
import com.app.entities.Hospital;
import com.app.entities.PatientsRequest;
import com.app.entities.User;
import com.app.enums.PatientStatus;
import com.app.enums.UserRole;

@Service
@Transactional
public class PatientRequestImpl implements PatientRequestService{

	@Autowired
	private PatientRequestDao patDao;
	
	@Autowired
	private HospitalDao hospitalDao;
	
	@Autowired
	private ModelMapper mapper;
	
	@Autowired
	private UserDao userDao;
	
	@Autowired
	private TesingEmailService emailSender;
	
	@Override
	public String addPatientRequest(PatientRequestAddDto patientReq) {
		
		PatientsRequest pat = mapper.map(patientReq, PatientsRequest.class);
		Hospital hospital = hospitalDao.findById(patientReq.getHospitalId())
				.orElseThrow(() -> new ResourceNotFoundException("No hospital found!"));
		
		pat.setHospital(hospital);
		PatientsRequest savedPat = patDao.save(pat);
		if(savedPat == null) return "Something went wrong...";
		List<User> users = userDao.findAll();
		String message = "Urgent Blood Need for " + pat.getName() + " in hospital " + 
						hospital.getName() +" in "+ hospital.getCity() +
						" for Blood Group " + pat.getBloodGroup().toString();
		sendEmailsToUser(users, message);
		return "Patient Added Succesfully!";
	}
	
	@Async
	public void sendEmailsToUser(List<User> users,String message) {
		for(User user : users) {
			emailSender.sendEmail(user.getEmail(), "Urgent Blood Needed", message);
		}
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

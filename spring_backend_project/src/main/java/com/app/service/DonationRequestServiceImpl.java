package com.app.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.custom_exceptions.ResourceNotFoundException;
import com.app.dao.DonationRequestDao;
import com.app.dao.PatientRequestDao;
import com.app.dao.UserDao;
import com.app.entities.DonationRequest;
import com.app.entities.PatientsRequest;
import com.app.entities.User;

@Service
@Transactional
public class DonationRequestServiceImpl implements DonationRequestService{

	@Autowired
	private UserDao userDao;
	
	@Autowired
	private PatientRequestDao patDao;
	
	@Autowired
	private DonationRequestDao donReqDao;

	@Autowired
	private ModelMapper mapper;
	
	@Override
	public String insertToDonReq(Long patientId, Long donarId) {
		
		User user = userDao.findById(donarId)
				.orElseThrow(() -> new ResourceNotFoundException("No donor with given id found!"));
		
		PatientsRequest patreq = patDao.findById(patientId)
		.orElseThrow(() -> new ResourceNotFoundException("No patient request with given id found!"));;
		
		DonationRequest donReq = new DonationRequest(patreq, user);
		DonationRequest savedDonreq = donReqDao.save(donReq);
		if(savedDonreq == null) return "Something went wrong...";
		return "Succesfully informed bank";
	}

	@Override
	public List<User> findUserByPatientId(Long patientId) {
		
		List<User> users = new ArrayList<User>();
		
		PatientsRequest patreq = patDao.findById(patientId)
				.orElseThrow(() -> new ResourceNotFoundException("No patient request with given id found!"));
		List<DonationRequest> donors = donReqDao.findByPatientRequest(patreq);
		for(DonationRequest don : donors) {
			users.add(don.getDonor());
		}
 		return users;
	}

}

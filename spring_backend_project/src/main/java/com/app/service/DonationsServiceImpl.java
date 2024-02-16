package com.app.service;

import java.time.LocalDate;
import java.util.Date;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.custom_exceptions.ResourceNotFoundException;
import com.app.dao.DonationsDao;
import com.app.dao.HospitalDao;
import com.app.dao.UserDao;
import com.app.entities.Donations;
import com.app.entities.Hospital;
import com.app.entities.User;

@Service
@Transactional
public class DonationsServiceImpl implements DonationsService{

	@Autowired
	private DonationsDao donsDao;
	
	@Autowired
	private UserDao userDao;
	
	@Autowired
	private HospitalDao hospitalDao;
	
	
	
	@Override
	public String insertInDonationsTable(Long donorId, Long hospitalId) {
		
		User user = userDao.findById(donorId).orElseThrow(() -> new ResourceNotFoundException("User not found!"));
		Hospital hospital = hospitalDao.findById(hospitalId).orElseThrow(() -> new ResourceNotFoundException("User not found!"));
		Donations dons = new Donations(LocalDate.now(), user, hospital);
		Donations savedDons = donsDao.save(dons);
		if(savedDons == null) return "Something went wrong...";
		
		return "Succesfully saved in Donations table";
	}

}

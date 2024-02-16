package com.app.service;

import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.HospitalDao;
import com.app.dao.UserDao;
import com.app.dto.UserSignUp;
import com.app.entities.Hospital;
import com.app.entities.User;
import com.app.enums.UserRole;

@Service
@Transactional
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;
	@Autowired
	private ModelMapper mapper;
	@Autowired
	private HospitalDao hospitalDao;
	

	@Override
	public User addUser(UserSignUp user) {
		
		User user1 = mapper.map(user, User.class);
		if (user.getRole() == UserRole.ROLE_ADMIN) { 
			User user2 = userDao.save(user1);
			Hospital hospital = new Hospital();
			hospital.setAdmin(user1);
			hospital.setCity(user.getCity());
			hospital.setName(user.getHospitalName());
			hospitalDao.save(hospital);
			return user2;
		}
		else {
			user.setRole(UserRole.ROLE_USER);
			return userDao.save(user1);
		}
	}

	@Override
	public User findByEmailAndPasswordAndRole(User user, UserRole userRole) {
		return userDao.findByEmailAndPasswordAndRole(user.getEmail(), user.getPassword(), userRole);
	}

	@Override
	public User findByEmail(User user) {
		return userDao.findByEmailAndRole(user.getEmail(), UserRole.ROLE_USER);
	}

// Method to generate a random OTP
	private String generateOTP() {

// For simplicity, using a static OTP
		return "123456";
	}

	@Override
	public Optional<User> findByEmail(String email) {
		return userDao.findByEmail(email);
	}

}

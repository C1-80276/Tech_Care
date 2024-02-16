package com.app.service;

import java.util.Optional;

import com.app.dto.UserSignUp;
import com.app.entities.User;
import com.app.enums.UserRole;

public interface UserService {
	
	User addUser(UserSignUp user);

	User findByEmailAndPasswordAndRole(User user, UserRole userRole);

	User findByEmail(User user);

	Optional<User> findByEmail(String email);

}

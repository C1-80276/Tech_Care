package com.app.service;

import java.util.List;

import com.app.entities.User;

public interface DonationRequestService {

	String insertToDonReq(Long patientId, Long donarId);

	List<User> findUserByPatientId(Long patientId);

}

package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.CustomResponse;
import com.app.entities.User;
import com.app.service.DonationRequestService;

@RestController
@RequestMapping("/emergencyDonation")
public class DonationRequestController {
	
	@Autowired
	private DonationRequestService donService;

	@PostMapping("/readyToCome")
	public ResponseEntity<?> insertToDonationRequest(@RequestParam Long patientId,@RequestParam Long donorId ){
		String msg = donService.insertToDonReq(patientId, donorId);
		return ResponseEntity.status(HttpStatus.CREATED).body(new CustomResponse<>(false, msg, null));
	}
	
	@GetMapping("/getReadyDonors")
	public ResponseEntity<?> getDonationRequestByPatientReqId(@RequestParam Long patientId){
		
		List<User> donors = donService.findUserByPatientId(patientId);
		return ResponseEntity.status(HttpStatus.OK).body(new CustomResponse<>(false, "Success", donors));
	}
}

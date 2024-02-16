package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.CustomResponse;
import com.app.dto.PatientRequestAddDto;
import com.app.service.PatientRequestService;

@RestController
@RequestMapping("/patientRequest")
public class PatientRequestController {

	@Autowired
	private PatientRequestService patService;
	
	//for admin
	@PostMapping("/add")
	public ResponseEntity<?> addPatientRequest(@RequestBody PatientRequestAddDto patientReq){
		
		String msg = patService.addPatientRequest(patientReq);
		return ResponseEntity.status(HttpStatus.CREATED).body(new CustomResponse<>(false, msg, null));
		
	}
}

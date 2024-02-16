package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.CustomResponse;
import com.app.service.DonationsService;

@RestController
@RequestMapping("/Donations")
public class DonationsController {
	
	@Autowired
	private DonationsService donsService;

	@GetMapping("/updateDonationsTable")
	public ResponseEntity<?> insertDonationsTable(@RequestParam Long donorId , @RequestParam Long hospitalId){
		String msg = donsService.insertInDonationsTable(donorId, hospitalId);
		return ResponseEntity.status(HttpStatus.OK).body(new CustomResponse<>(false, msg, null));
	}
}

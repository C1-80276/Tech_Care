package com.app.service;

import java.util.List;

import com.app.dto.PatientRequestAddDto;
import com.app.entities.PatientsRequest;
import com.app.enums.PatientStatus;

public interface PatientRequestService {

	String addPatientRequest(PatientRequestAddDto patientReq);

	String changeStatus(Long patientId, PatientStatus status);

	List<PatientsRequest> findAllByStatus(PatientStatus pending);

}

package com.app.service;

import com.app.dto.PatientRequestAddDto;
import com.app.enums.PatientStatus;

public interface PatientRequestService {

	String addPatientRequest(PatientRequestAddDto patientReq);

	String changeStatus(Long patientId, PatientStatus status);

}

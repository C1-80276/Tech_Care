package com.app.dto;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.app.entities.Hospital;
import com.app.enums.BloodGroup;
import com.app.enums.PatientStatus;
import com.app.enums.UserRole;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PatientRequestAddDto {
	@NotBlank
	private String name;
	
	private PatientStatus status = PatientStatus.PENDING;
	
	@NotNull
	private Long hospitalId;
	
	@Enumerated(EnumType.STRING)
	private BloodGroup bloodGroup;
}

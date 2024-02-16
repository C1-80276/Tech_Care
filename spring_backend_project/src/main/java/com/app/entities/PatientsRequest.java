package com.app.entities;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.app.enums.BloodGroup;
import com.app.enums.Gender;
import com.app.enums.PatientStatus;
import com.app.enums.UserRole;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "patients_request")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PatientsRequest extends BaseEntity{

	@NotBlank
	@Column(name = "name")
	private String name;
	
	@Column(name = "status")
	private PatientStatus status;
	
	@JoinColumn(name = "hospital")
	private Hospital hospital;
	
	@Enumerated(EnumType.STRING)
    @Column(name = "blood_group")
	private BloodGroup bloodGroup;
	
}

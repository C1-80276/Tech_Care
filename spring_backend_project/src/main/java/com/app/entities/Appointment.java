package com.app.entities;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

import com.app.enums.BloodGroup;
import com.app.enums.Gender;
import com.app.enums.UserRole;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "appointments")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Appointment extends BaseEntity{

	@JoinColumn(name = "hospital")
	private Hospital hospital;
	@JoinColumn(name = "donar")
	private User donar;

	private Boolean status;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate appointmentDate;
	@DateTimeFormat(pattern = "HH:mm:ss")
	private LocalTime appointmentTime;
}

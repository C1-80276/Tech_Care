package com.app.entities;

import java.time.LocalDate;
import java.time.LocalTime;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

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

	@JoinColumn(name = "hospitalId")
	@ManyToOne
	private Hospital hospital;
	
	@JoinColumn(name = "userId")
	@ManyToOne
	private User donar;

	private Boolean status;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate appointmentDate;
	@DateTimeFormat(pattern = "HH:mm:ss")
	private LocalTime appointmentTime;
}

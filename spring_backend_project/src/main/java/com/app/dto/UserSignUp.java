package com.app.dto;

import java.time.LocalDate;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;
import org.springframework.format.annotation.DateTimeFormat;

import com.app.enums.Gender;
import com.app.enums.UserRole;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserSignUp {
 
   @NotBlank
   @Length(min = 5, max = 12)
   private String username;
 
   @NotBlank
 
   private String firstName;
 
   @NotBlank
   
   private String lastName;

   @Enumerated(EnumType.STRING)
   @NotBlank
   private Gender gender;
 
   private Integer height;
 
   private Double weight;
 
   @NotBlank
   @Email
 
   private String email;
 
   @NotBlank
   
   private String mobileNo;
 
   @NotBlank
 
   private String city;
   
   @NotBlank
 
   private String password;
 
   @DateTimeFormat(pattern = "yyyy-MM-dd")
 
   private LocalDate dob;
 
   @Enumerated(EnumType.STRING)
 
   private UserRole role;
   
   private String hospitalName;
   
 
}
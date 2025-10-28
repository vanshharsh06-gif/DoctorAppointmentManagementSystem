package com.appointmentservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PatientDTO{
	
    private Long patientId;
    private String patientName;
    private String patientEmail;
    private String contactNumber;
}

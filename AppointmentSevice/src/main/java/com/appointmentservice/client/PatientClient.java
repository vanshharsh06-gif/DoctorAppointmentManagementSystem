package com.appointmentservice.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.appointmentservice.dto.PatientDTO;

@FeignClient(name="PatientService", url="http://localhost:1001/patient/pId/")
public interface PatientClient {
	
	@GetMapping("/{id}")
	PatientDTO getByPatientId(@PathVariable("id") long patientId);
}

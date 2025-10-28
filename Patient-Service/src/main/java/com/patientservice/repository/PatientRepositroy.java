package com.patientservice.repository;


import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.patientservice.entities.PatientEntity;

public interface PatientRepositroy extends JpaRepository<PatientEntity, Long> {
	
	Optional<List<PatientEntity>> findByPatientNameContainingIgnoreCase(String patientName);
	
	Optional<PatientEntity> findByPatientEmail(String patientEmail);


}

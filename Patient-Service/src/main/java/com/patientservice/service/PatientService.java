package com.patientservice.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.patientservice.entities.PatientEntity;
import com.patientservice.exception.PatientIdNotFound;
import com.patientservice.repository.PatientRepositroy;

@Service
public class PatientService {

	private PatientRepositroy patientRepositroy;

	public PatientService(PatientRepositroy patientRepositroy) {

		this.patientRepositroy = patientRepositroy;
	}

	public String save(PatientEntity entity) {
		PatientEntity entity2 = patientRepositroy.save(entity);
		return "Patient Id = " + entity2.getPatientId() + " Patient Registered";
	}

	public List<PatientEntity> findAll() {
		return patientRepositroy.findAll();
	}

	public PatientEntity findById(long patientId) {
		return patientRepositroy.findById(patientId)
				.orElseThrow(() -> new PatientIdNotFound("Please enter the valid Id"));
	}

	public Optional<List<PatientEntity>> findByName(String patientName) {
		Optional<List<PatientEntity>> patients = patientRepositroy.findByPatientNameContainingIgnoreCase(patientName);
		return patients;
	}

	public String update(PatientEntity entity, long patientId) {
		PatientEntity entity2 = patientRepositroy.findById(patientId)
				.orElseThrow(() -> new PatientIdNotFound("Please enter the valid Id"));
		entity2.setPatientName(entity.getPatientName());
		entity2.setPatientAge(entity.getPatientAge());
		entity2.setPatientEmail(entity.getPatientEmail());
		entity2.setMedicalHistory(entity.getMedicalHistory());
		patientRepositroy.save(entity2);
		return "Modified Patient";

	}

	public String delete(long patientId) {
		patientRepositroy.deleteById(patientId);
		return "Patient Data Deleted";
	}

	public PatientEntity getPatientByEmail(String patientEmail) {
		PatientEntity entity = patientRepositroy.findByPatientEmail(patientEmail)
				.orElseThrow(() -> new IllegalArgumentException("Patient not found with email: " + patientEmail));
		return entity;
	}
}

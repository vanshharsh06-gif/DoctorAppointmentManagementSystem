package com.patientservice.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.patientservice.entities.PatientEntity;
import com.patientservice.service.PatientService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("patient")
public class PatientController {
	
	private PatientService patientService;

	public PatientController(PatientService patientService) {
		this.patientService = patientService;
	}
	
	@PostMapping("/save")
	public ResponseEntity<String> savePatient(@Valid @RequestBody PatientEntity entity){
		String entity1=patientService.save(entity);
		return ResponseEntity.status(HttpStatus.OK).body(entity1);
	}
	
	@GetMapping("/getAll")
	public ResponseEntity<List<PatientEntity>> getAllPatients(){
		List<PatientEntity> entity=patientService.findAll();
		return ResponseEntity.status(HttpStatus.OK).body(entity);
	}
	
	@GetMapping("/pId/{patientId}")
	public ResponseEntity<PatientEntity> findById(@PathVariable long patientId){
		PatientEntity entity=patientService.findById(patientId);
		return ResponseEntity.status(HttpStatus.FOUND).body(entity);
	}
	
	@GetMapping("/name/{patientName}")
	public ResponseEntity<Optional<List<PatientEntity>>> findByName(@PathVariable String patientName){
		Optional<List<PatientEntity>> entity=patientService.findByName(patientName);
		return ResponseEntity.status(HttpStatus.FOUND).body(entity);
	}
	
	@PutMapping("/modify/{patientId}")
	public ResponseEntity<String> update(@RequestBody PatientEntity entity, @PathVariable long patientId){
		String entity2=patientService.update(entity,patientId);
		return ResponseEntity.status(HttpStatus.UPGRADE_REQUIRED).body(entity2);
	}
	
	@DeleteMapping("/delete/{patientId}")
	public ResponseEntity<String> delete(@PathVariable long patientId){
		String entity=patientService.delete(patientId);
		return ResponseEntity.status(HttpStatus.FORBIDDEN).body(entity);
	}
	
	@GetMapping("/email/{patientEmail}")
	public ResponseEntity<PatientEntity> findByEmail(@PathVariable String patientEmail){
		PatientEntity entity=patientService.getPatientByEmail(patientEmail);
		return ResponseEntity.status(HttpStatus.FOUND).body(entity);
		
	}

}

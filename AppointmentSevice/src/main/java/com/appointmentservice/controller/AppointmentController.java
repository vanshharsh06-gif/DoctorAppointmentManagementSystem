package com.appointmentservice.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.appointmentservice.entities.AppointmentEntities;
import com.appointmentservice.service.AppointmentService;

@RestController
@RequestMapping("/appoint")
public class AppointmentController {
	
	private AppointmentService appointmentService;

	public AppointmentController(AppointmentService appointmentService) {
		this.appointmentService = appointmentService;
	}
	
	@PostMapping("/save")
	public ResponseEntity<String> appointsave(@RequestBody AppointmentEntities appointmentEntities){
		String appoint= appointmentService.save(appointmentEntities);
		return ResponseEntity.status(HttpStatus.OK).body(appoint);
	}
	
	@GetMapping("/appointmentId/{appointmentId}")
	public ResponseEntity<AppointmentEntities> findByAppointmentId(@PathVariable Long appointmentId){
		AppointmentEntities entities=appointmentService.findById(appointmentId);
		return ResponseEntity.status(HttpStatus.OK).body(entities);
	}

	@GetMapping("/patient/{patientId}")
	public ResponseEntity<List<AppointmentEntities>> findPatientId(@PathVariable long patientId){
		List<AppointmentEntities> list=appointmentService.getByPatientId(patientId);
		return ResponseEntity.status(HttpStatus.OK).body(list);
	}
	
	@PutMapping("/update/{appointmentId}")
	public ResponseEntity<AppointmentEntities> updateAppointment(@RequestBody AppointmentEntities entities,@PathVariable long appointmentId ){
		AppointmentEntities entities2=appointmentService.updateAppointment(entities,appointmentId);
		return ResponseEntity.status(HttpStatus.OK).body(entities2);
	}
	
}

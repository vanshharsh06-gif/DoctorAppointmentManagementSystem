package com.doctorservice.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.doctorservice.entities.DoctorEntity;
import com.doctorservice.entities.Schedule;
import com.doctorservice.service.DoctorService;

import jakarta.validation.Valid;
import lombok.Delegate;

@RestController
@RequestMapping("/doctor")
public class DoctorController {

	private DoctorService doctorService;
	

	public DoctorController(DoctorService doctorService) {
		this.doctorService = doctorService;
	}
	
	
	@PostMapping("/save")
	public ResponseEntity<String> save(@Valid @RequestBody DoctorEntity doctorEntity){
		String doctorEntity2=doctorService.save(doctorEntity);
		return ResponseEntity.status(HttpStatus.OK).body(doctorEntity2);
	}
	
	
	@GetMapping("/Id/{doctorId}")
	public ResponseEntity<Optional<DoctorEntity>> findById(@PathVariable long doctorId ){
		Optional<DoctorEntity> doctorEntity=doctorService.findById(doctorId);
		return ResponseEntity.status(HttpStatus.OK).body(doctorEntity);
	}
	
	 	
	@PostMapping("/{doctorId}/schedule")
	public ResponseEntity<Schedule> saveSchedule(@Valid @PathVariable long doctorId, @RequestBody Schedule schedule){
		Schedule schedule2=doctorService.saveSchedule(doctorId,schedule);
		return ResponseEntity.status(HttpStatus.OK).body(schedule2);
	}
	
	@GetMapping("/{doctorId}/getSchedule")
	public ResponseEntity<List<Schedule>> findAll(@PathVariable long doctorId){
		List<Schedule> schedule=doctorService.findByIdSchedule(doctorId);
		return ResponseEntity.status(HttpStatus.OK).body(schedule);
	}
	
	@DeleteMapping("/delete/{scheduleId}")
	public ResponseEntity<String> deleteById(@PathVariable long scheduleId){
		String  schedule=doctorService.deleteById(scheduleId);
		return ResponseEntity.status(HttpStatus.OK).body(schedule);
	}
}

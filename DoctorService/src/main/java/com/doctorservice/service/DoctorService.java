package com.doctorservice.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.doctorservice.entities.DoctorEntity;
import com.doctorservice.entities.Schedule;
import com.doctorservice.repository.DoctorRepository;
import com.doctorservice.repository.ScheduleRepository;



@Service
public class DoctorService {
	
	private DoctorRepository doctorRepository;
	
	private ScheduleRepository scheduleRepository;
	

	public DoctorService(DoctorRepository doctorRepository,ScheduleRepository scheduleRepository) {
		this.scheduleRepository=scheduleRepository;
		this.doctorRepository = doctorRepository;
	}
	
	
	public String save( DoctorEntity doctorEntity) {
		DoctorEntity doctorEntity2= doctorRepository.save(doctorEntity);
		return  "Doctor Id = " + doctorEntity2.getDoctorId()+" Doctors Saved";
	}



	public Optional<DoctorEntity> findById(long doctorId) {
		return doctorRepository.findById(doctorId);
	}



	 public Schedule saveSchedule(long doctorId, Schedule schedule) {
			DoctorEntity doctorEntity=doctorRepository.findById(doctorId).orElseThrow(() -> new RuntimeException("Doctor not found with ID: " + doctorId));
			schedule.setDoctor(doctorEntity);
		return  scheduleRepository.save(schedule);
	}


	public List<Schedule> findByIdSchedule(long doctorId) {
		return scheduleRepository.findByDoctorDoctorId(doctorId);
	}


	public String deleteById(long scheduleId) {
		scheduleRepository.deleteById(scheduleId);
		return "Deleted Data ="+ scheduleId;
	}
	
		
	

}

package com.appointmentservice.service;

import java.util.List;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.appointmentservice.entities.AppointmentEntities;
import com.appointmentservice.repository.AppointmentRepository;

@Service
public class AppointmentService {
	
	private final KafkaTemplate<String , AppointmentEntities > kafkaTemplate;
	
	private AppointmentRepository appointmentRepository;
	
	public AppointmentService(AppointmentRepository appointmentRepository,KafkaTemplate<String , AppointmentEntities > kafkaTemplate) {
		this.kafkaTemplate = kafkaTemplate;
		this.appointmentRepository = appointmentRepository;
	}
	
	
	public String save(AppointmentEntities appointmentEntities) {
		AppointmentEntities entities= appointmentRepository.save(appointmentEntities);
		kafkaTemplate.send("appointment-event",entities);
		return "Appointment Registered :"+entities.getAppointmentId()+".";
	}

	public AppointmentEntities findById(Long appointmentId) {
		return appointmentRepository.findById(appointmentId).get();
	}

	public List<AppointmentEntities> getByPatientId(long patientId) {
		return appointmentRepository.findByPatientId(patientId);
	}

	public AppointmentEntities updateAppointment(AppointmentEntities entities, long appointmentId) {
		AppointmentEntities entities2=appointmentRepository.findById(appointmentId).get();
		
		String statuscheck=entities.getStatus();
		
		switch(statuscheck) {
			
		case("cancelled") :
			entities2.setStatus("CANCALLED");
			break;
		case("rescheduled") :
			entities2.setDate(entities.getDate());
			entities2.setTime(entities.getTime());
			entities2.setStatus("RESCHEDULED");
			break;
		
		}
		return appointmentRepository.save(entities2);
		
	}

}

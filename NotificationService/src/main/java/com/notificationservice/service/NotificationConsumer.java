package com.notificationservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;

import com.notificationservice.entities.Notification;
import com.notificationservice.repository.NotificationRepository;

public class NotificationConsumer {

	@Autowired
	private NotificationRepository notificationRepository;
	
	@Autowired
	private EmailService emailService;
	
	@KafkaListener(topics = "appointment-topic", groupId = "notification-group")
    public void consume(String patientEmail) {
        System.out.println("Received from Kafka: " + patientEmail);
        
        Notification notify=new Notification();
        notify.setPatientEmail(patientEmail);
        notify.setSubject("Appointment Confirmation");
        notify.setMessage("Your appointment has been successfully booked!");
        notify.setStatus("SENT");
        
        emailService.sendEmail(notify.getPatientEmail(), notify.getSubject(), notify.getMessage());
        notificationRepository.save(notify);
	}
}

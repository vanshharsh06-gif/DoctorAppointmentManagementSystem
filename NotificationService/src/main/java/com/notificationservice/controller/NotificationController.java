package com.notificationservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.notificationservice.entities.Notification;
import com.notificationservice.repository.NotificationRepository;
import com.notificationservice.service.EmailService;

@RestController
@RequestMapping("/api/notifications")
public class NotificationController {
	
	
	@Autowired
	private NotificationRepository notificationRepository;
	
	@Autowired
	private EmailService emailService;
	
	@GetMapping("/get")
    public List<Notification> getAll() {
        return notificationRepository.findAll();
    }
	
	
	@PostMapping("/send")
	public String sendEmail(@RequestBody Notification notification) {
		emailService.sendEmail(notification.getPatientEmail(), notification.getSubject(), notification.getMessage());
		notification.setStatus("SENt");
		notificationRepository.save(notification);
		return "Email Sent";
	}
}

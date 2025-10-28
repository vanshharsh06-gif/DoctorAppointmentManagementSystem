package com.appointmentservice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.appointmentservice.entities.AppointmentEntities;

@Repository
public interface AppointmentRepository extends JpaRepository<AppointmentEntities, Long>{

	List<AppointmentEntities> findByPatientId(long patientId);
}

package com.doctorservice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.doctorservice.entities.DoctorEntity;

@Repository
public interface DoctorRepository extends JpaRepository<DoctorEntity, Long>{

	List<DoctorEntity> findByDoctorNameContainingIgnoreCase(String doctorName);
	List<DoctorEntity> findBySpecializationContainingIgnoreCase(String specialization);
	
}

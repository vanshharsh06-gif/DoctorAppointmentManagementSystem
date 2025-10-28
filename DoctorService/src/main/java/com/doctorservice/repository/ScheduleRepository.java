package com.doctorservice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.doctorservice.entities.Schedule;

@Repository
public interface ScheduleRepository extends JpaRepository<Schedule, Long>{

	 List<Schedule> findByDoctorDoctorId(Long doctorId);
}

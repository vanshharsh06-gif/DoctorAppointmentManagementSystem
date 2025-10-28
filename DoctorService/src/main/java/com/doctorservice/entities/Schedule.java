
package com.doctorservice.entities;

import java.time.LocalDate;
import java.time.LocalTime;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class Schedule {

	  	@Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long scheduleId;

	    private LocalDate date;
	    private LocalTime startTime;
	    private LocalTime endTime;
	    private int slotDuration; 
	   

	    @ManyToOne
	    @JoinColumn(name = "doctor_id")
	    @JsonBackReference
	    private DoctorEntity doctor;
}

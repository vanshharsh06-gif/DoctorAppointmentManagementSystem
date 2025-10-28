
package com.patientservice.entities;



import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PatientEntity {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="Id")
	private long patientId;
	
	@Column(name = "Name")
	@NotBlank(message = "Enter Name")
	private String patientName;
	
	@Column(name = "Age")
	private long patientAge;
	
	@Column(name = "Email")
	@NotBlank(message = "Enter Email")
	private String patientEmail;
	
	@Column(name = "History")
	@NotBlank(message = "Enter MedicalHistory")
	private String medicalHistory;
	
	@Column(name = "Gender")
	@NotBlank(message="Enter Gender")
	private String gender;
	
	@Column(name = "Phone No")
	@Digits(integer = 10, fraction = 0)
    private long contactNumber;
	
	@Column(name = "Address")
	@NotBlank(message = "Enter Address")
	private String patientsAddress;
	
	
	
	

	
	
	
	
	

}

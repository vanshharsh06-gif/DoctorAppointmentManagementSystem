package com.patientservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.patientservice.model.ErrorResponse;

import jakarta.servlet.http.HttpServletRequest;

@ControllerAdvice
public class ExceptionHandlerOfPatient {

	@ExceptionHandler(PatientIdNotFound.class)
	public ResponseEntity<ErrorResponse> patientIdNotFound(PatientIdNotFound patientIdNotFound,HttpServletRequest httpServletRequest){
		ErrorResponse errorResponse=new ErrorResponse(patientIdNotFound.getMessage(), httpServletRequest.getRequestURI());
		return new ResponseEntity<>(errorResponse,HttpStatus.BAD_REQUEST);
	}
	
}

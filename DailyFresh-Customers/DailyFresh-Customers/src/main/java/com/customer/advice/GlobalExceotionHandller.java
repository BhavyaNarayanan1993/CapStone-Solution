package com.customer.advice;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.customer.dto.customer.response.ErrorResponse;
import com.customer.exception.CustomerNotFoundException;

@ControllerAdvice
public class GlobalExceotionHandller {

	@ExceptionHandler(exception = CustomerNotFoundException.class)
	public ResponseEntity<ErrorResponse> handleException(Exception e) {
		System.out.println(e.getMessage());
		ErrorResponse response= new ErrorResponse();
		response.setStatusCode(404);
		response.setErrorMessage(e.getMessage());
		return new ResponseEntity<>(response , HttpStatus.NOT_FOUND);
	}
}

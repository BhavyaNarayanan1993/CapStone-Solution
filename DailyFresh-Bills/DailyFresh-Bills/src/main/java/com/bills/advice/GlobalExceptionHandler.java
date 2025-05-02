package com.bills.advice;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.bills.dto.response.ErrorResponse;
import com.bills.exception.BillsNotFoundException;


@ControllerAdvice
public class GlobalExceptionHandler {
		
		@ExceptionHandler(exception= {BillsNotFoundException.class})
		public ResponseEntity<ErrorResponse> handleException(Exception e)
		{
			System.out.println(e.getMessage());
			ErrorResponse response=new ErrorResponse();
			response.setStatus(404);
			response.setErrorMessage(e.getMessage());
			return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
			
		}
		
}

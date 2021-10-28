package com.uxpsystems.assignement.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class UserExceptionHandleer {
	
	
	  @ExceptionHandler(value = org.hibernate.exception.ConstraintViolationException.class) 
	  public ResponseEntity<Object> ExceptionPostMethode() { return new
	  ResponseEntity<Object>("username is already present",HttpStatus.BAD_REQUEST);
	  }
	  
	  
	  @ExceptionHandler(value = {org.springframework.dao.EmptyResultDataAccessException.class,java.util.NoSuchElementException.class}) 
	  public ResponseEntity<Object> ExceptionDeleteMethode() { return new
	  ResponseEntity<Object>("user is not availabe for given id",HttpStatus.NOT_FOUND);
	  }
	  
	 
	 
	

}

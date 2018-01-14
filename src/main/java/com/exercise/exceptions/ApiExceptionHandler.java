package com.exercise.exceptions;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@Order(Ordered.HIGHEST_PRECEDENCE)
@ControllerAdvice
public class ApiExceptionHandler extends ResponseEntityExceptionHandler {
	
	public ResponseEntity<Object> buildResponseEntity(Error error) {
	       return new ResponseEntity<>(error, error.getStatus());
	   }
	
	@ExceptionHandler(ItemNotFoundException.class)
	protected ResponseEntity<Object> handleItemNotFound(ItemNotFoundException ex) {
		Error error = new Error(HttpStatus.NOT_FOUND, ex.getMessage(), ex);
		error.setMessage(ex.getMessage());
	       return buildResponseEntity(error);
	   }
}

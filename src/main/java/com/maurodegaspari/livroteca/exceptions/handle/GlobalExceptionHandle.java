package com.maurodegaspari.livroteca.exceptions.handle;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.maurodegaspari.livroteca.exceptions.NoSuchElementException;
import com.maurodegaspari.livroteca.exceptions.NotFoundException;

import jakarta.servlet.ServletRequest;

@ControllerAdvice
public class GlobalExceptionHandle {

	private ResponseEntity<ErrosResponseHandle> response(final String message, final int status, final ServletRequest request) {
		return ResponseEntity.status(status).body(new ErrosResponseHandle(System.currentTimeMillis(), status, message));
	}
	
	@ExceptionHandler(NotFoundException.class)
	public ResponseEntity<ErrosResponseHandle> handleResponseEntity(NotFoundException e, ServletRequest request) {
		return response(e.getMessage(), HttpStatus.NOT_FOUND.value(), request);
	}

	@ExceptionHandler(DataIntegrityViolationException.class)
	public ResponseEntity<ErrosResponseHandle> dataIntegrityViolationException(DataIntegrityViolationException e, ServletRequest request) {
		return response(e.getMessage(), HttpStatus.BAD_REQUEST.value(), request);
	}
	
	@ExceptionHandler(NoSuchElementException.class)
	public ResponseEntity<ErrosResponseHandle> noSuchElementException(NoSuchElementException e, ServletRequest request) {
		return response(e.getMessage(), HttpStatus.BAD_REQUEST.value(), request);
	}
	
	
}

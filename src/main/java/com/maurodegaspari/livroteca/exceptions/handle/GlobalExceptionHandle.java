package com.maurodegaspari.livroteca.exceptions.handle;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.maurodegaspari.livroteca.exceptions.NotFoundException;

import jakarta.servlet.ServletRequest;

@ControllerAdvice
public class GlobalExceptionHandle {

	@ExceptionHandler(NotFoundException.class)
	public ResponseEntity<ErrosResponseHandle> handleResponseEntity(NotFoundException e, ServletRequest request) {
		return response(e.getMessage(), HttpStatus.NOT_FOUND.value(), request);
	}

	private ResponseEntity<ErrosResponseHandle> response(final String message, final int status, final ServletRequest request) {
		return ResponseEntity.status(status).body(new ErrosResponseHandle(System.currentTimeMillis(), status, message));
	}
}

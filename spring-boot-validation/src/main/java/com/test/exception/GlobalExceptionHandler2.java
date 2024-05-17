package com.test.exception;

import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class GlobalExceptionHandler2 extends ResponseEntityExceptionHandler {

	@ExceptionHandler(Exception.class)
	public ResponseEntity<Object> handleAllExceptions(Exception ex,	WebRequest request) {
		Map<String, Object> errorResponse = new LinkedHashMap<>();

		errorResponse.put("TimeStamp", new Date());
		errorResponse.put("message", ex.getMessage());

		return new ResponseEntity<Object>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatusCode status, WebRequest request) {
		Map<String, Object> errorResponse = new HashMap<>();

		errorResponse.put("TimeStamp", new Date());
		errorResponse.put("Status", status);
		errorResponse.put("Status Code", status.value());
		
		List<FieldError> fieldErrors = ex.getBindingResult().getFieldErrors();
		
		
		Map<String,Object> errorList = new LinkedHashMap<>();
		
		for (FieldError fieldError : fieldErrors) {
			errorList.put(fieldError.getField(), fieldError.getDefaultMessage());
		}
		errorResponse.put("errors",errorList);
		return  new ResponseEntity<Object>(errorResponse, HttpStatus.BAD_REQUEST);
	}

}

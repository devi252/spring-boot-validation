//package com.test.exception;
//
//import java.util.Date;
//import java.util.HashMap;
//import java.util.LinkedHashMap;
//import java.util.List;
//import java.util.Map;
//
//import org.springframework.http.HttpHeaders;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.HttpStatusCode;
//import org.springframework.http.ResponseEntity;
//import org.springframework.validation.BindingResult;
//import org.springframework.validation.FieldError;
//import org.springframework.web.bind.MethodArgumentNotValidException;
//import org.springframework.web.bind.annotation.ExceptionHandler;
//import org.springframework.web.bind.annotation.RestControllerAdvice;
//import org.springframework.web.context.request.WebRequest;
//import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
//
//@RestControllerAdvice
//public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {
//
//	@ExceptionHandler(Exception.class)
//	public ResponseEntity<Object> handlaException(Exception e) {
//		return new ResponseEntity<Object>("exception..........", HttpStatus.OK);
//	}
//
//	@Override
//	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
//			HttpHeaders header, HttpStatusCode status, WebRequest request) {
//
//		Map<String, Object> errorResponse = new LinkedHashMap<>();
//		errorResponse.put("TimeStam", new Date());
//		errorResponse.put("Status", status.value());
//
////		 Get All Errors
////		List<String> exceptionalErrors = ex.getBindingResult().getFieldErrors()
//
//		BindingResult bindingResult = ex.getBindingResult();
//		List<FieldError> fieldErrors = bindingResult.getFieldErrors();
//
////		for (FieldError fieldError : fieldErrors) {
////			System.out.println("------------------------------");
////			System.out.println("fieldError.getCode() : " +fieldError.getCode());
////			System.out.println("fieldError.getDefaultMessage() : " +fieldError.getDefaultMessage());
////			System.out.println("fieldError.getField() : " +fieldError.getField());
////			System.out.println("fieldError.getObjectName()" +fieldError.getObjectName());
////			System.out.println("fieldError.getRejectedValue() : " +fieldError.getRejectedValue());
////			System.out.println("fieldError.getArguments() : " +Arrays.toString(fieldError.getArguments()));
////			System.out.println("fieldError.getCodes() : " +Arrays.toString(fieldError.getCodes()));
////		}
//
////		List<String> errorMessages = fieldErrors.stream().map( x-> x.getDefaultMessage()).collect(Collectors.toList());
//
//		Map<String, Object> errorMessages = new HashMap<String, Object>();
//
//		for (FieldError fieldError : fieldErrors) {
//			errorMessages.put(fieldError.getField(), fieldError.getDefaultMessage());
//		}
//		errorResponse.put("Errors", errorMessages);
//
//		return new ResponseEntity<Object>(errorResponse, HttpStatus.OK);
//	}
//
//}

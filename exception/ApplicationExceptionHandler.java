package com.ty.springboot_hospitalproject.exception;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.ty.springboot_hospitalproject.util.ResponseStructure;

@ControllerAdvice
public class ApplicationExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(IdNotFoundException.class)
	public ResponseEntity<ResponseStructure<String>> idNotFoundException(IdNotFoundException exp) {
		ResponseStructure<String> responseStructure = new ResponseStructure<>();
		responseStructure.setMessage(exp.getMessage());
		responseStructure.setStatus(HttpStatus.NOT_FOUND.value());
		responseStructure.setData("No Element Found for the Given id");

		return new ResponseEntity<ResponseStructure<String>>(responseStructure, HttpStatus.NOT_FOUND);
	}

	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {

		List<ObjectError> error = ex.getAllErrors();

		Map<String, String> map = new HashMap<String, String>();

		for (ObjectError er : error) {

			
			String fieldName = ((FieldError) er).getField();
			String message = ((FieldError) er).getDefaultMessage();

			map.put(fieldName, message);
		}

		return new ResponseEntity<Object>(map, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(ConstraintViolationException.class)
	public ResponseEntity<Object> constrainVoilationException(ConstraintViolationException con) {
		List<String> list = new ArrayList<>();
		Set<ConstraintViolation<?>> set = con.getConstraintViolations();
		for (ConstraintViolation<?> violation : set) {

			String name = violation.getMessage();
			list.add(name);
		}
		return new ResponseEntity<Object>(list, HttpStatus.BAD_REQUEST);

	}

}

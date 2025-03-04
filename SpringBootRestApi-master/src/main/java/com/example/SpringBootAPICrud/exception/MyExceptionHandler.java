package com.example.SpringBootAPICrud.exception;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.example.SpringBootAPICrud.helper.ResponseStructure;

@RestControllerAdvice
public class MyExceptionHandler {

	@Autowired
	ResponseStructure<String> structure;

	@ExceptionHandler(DataNotFoundException.class)
	public ResponseEntity<ResponseStructure<String>> handle(DataNotFoundException exception) {
		structure.setMessage("Data Not Found");
		structure.setData(exception.getMessage());
		return new ResponseEntity<ResponseStructure<String>>(structure, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(DataExistsException.class)
	public ResponseEntity<ResponseStructure<String>> handle(DataExistsException exception) {
		structure.setMessage("Data Already Exists");
		structure.setData(exception.getMessage());
		return new ResponseEntity<ResponseStructure<String>>(structure, HttpStatus.BAD_REQUEST);
	}
}

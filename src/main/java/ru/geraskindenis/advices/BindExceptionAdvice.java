package ru.geraskindenis.advices;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class BindExceptionAdvice {

	@ExceptionHandler(BindException.class)
	public ResponseEntity<String> bindExceptionAdvice(BindException e) {
		return ResponseEntity.badRequest().body(e.getMessage());
	}
}

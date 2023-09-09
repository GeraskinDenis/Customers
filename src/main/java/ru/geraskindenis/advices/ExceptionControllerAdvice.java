package ru.geraskindenis.advices;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionControllerAdvice {

	@ExceptionHandler(RuntimeException.class)
	public ResponseEntity<String> webControllerAdvice(RuntimeException e) {
		return ResponseEntity.badRequest().body(e.getMessage());
	}
}

package ru.geraskindenis.advices;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class RuntimeExceptionAdvice {

	@ExceptionHandler(RuntimeException.class)
	public ResponseEntity<String> runtimeExceptionAdvice(RuntimeException e) {
		return ResponseEntity.badRequest().body(e.getMessage());
	}
}

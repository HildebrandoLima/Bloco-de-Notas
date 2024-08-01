package com.service.exception;

import java.util.Collections;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalHandleResponse {

	public ResponseEntity<Response> createResponse(String message, List<Object> data, HttpStatus status) {
		Response response = new Response(message, data, status.value());
		return new ResponseEntity<>(response, status);
	}

	@ExceptionHandler(HttpBadRequest.class)
    public ResponseEntity<Response> handleHttpBadRequest(HttpBadRequest e) {
        return createResponse(e.getMessage(), Collections.emptyList(), HttpStatus.BAD_REQUEST);
    }

	@ExceptionHandler(HttpNotFound.class)
    public ResponseEntity<Response> handleHttpNotFound(HttpNotFound e) {
        return createResponse(e.getMessage(), Collections.emptyList(), HttpStatus.NOT_FOUND);
    }

	@ExceptionHandler(HttpConflict.class)
    public ResponseEntity<Response> handleHttpConflict(HttpConflict e) {
        return createResponse(e.getMessage(), Collections.emptyList(), HttpStatus.CONFLICT);
    }

}

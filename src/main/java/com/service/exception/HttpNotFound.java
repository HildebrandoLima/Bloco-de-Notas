package com.service.exception;

public class HttpNotFound extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public HttpNotFound() {
		super("Registro não encontrado.");
	}

}

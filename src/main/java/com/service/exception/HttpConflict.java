package com.service.exception;

public class HttpConflict extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public HttpConflict() {
		super("Registro já existente.");
	}

}

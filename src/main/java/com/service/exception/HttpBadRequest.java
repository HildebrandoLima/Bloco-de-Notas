package com.service.exception;

public class HttpBadRequest extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public HttpBadRequest() {
		super("Solicitação inválida.");
	}

}

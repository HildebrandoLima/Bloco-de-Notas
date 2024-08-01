package com.service.exception;

public class HttpOk extends RuntimeException {
	
	private static final long serialVersionUID = 1L;

	public HttpOk() {
		super("Solicitação registrada com sucesso.");
	}

}

package com.service.exception;

public class HttpOk extends RuntimeException {

	private static final long serialVersionUID = 1L;
	private final Object[] data;

	public HttpOk(Object[] data) {
		super("Solicitação válida.");
		this.data = data;
	}

	public Object[] getData() {
		return data;
	}

}

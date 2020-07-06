package com.br.lojavirtual.services.exceptions;

public class ObjectNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	public ObjectNotFoundException(String msg) {
		super(msg);
	}
//Execao personalizada
	public ObjectNotFoundException(String msg, Throwable cause) {
		super (msg,cause);
	}
}

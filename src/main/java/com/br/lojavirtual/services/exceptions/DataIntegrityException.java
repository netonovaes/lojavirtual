package com.br.lojavirtual.services.exceptions;

public class DataIntegrityException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	public DataIntegrityException(String msg) {
		super(msg);
	}
//Execao personalizada
	public DataIntegrityException(String msg, Throwable cause) {
		super (msg,cause);
	}
}

package com.br.lojavirtual.resources.exception;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.br.lojavirtual.services.exceptions.DataIntegrityException;
import com.br.lojavirtual.services.exceptions.ObjectNotFoundException;
	//Manipulador  de erros(boa pratica para que o controller da classe não fica muito complexo)
	@ControllerAdvice
	public class ResourseExceptionHandler {
		
		@ExceptionHandler(ObjectNotFoundException.class)
		public ResponseEntity<StandardError> objectNotFound(ObjectNotFoundException e, HttpServletRequest request){
			StandardError err = new StandardError(HttpStatus.NOT_FOUND.value(), e.getMessage(),System.currentTimeMillis());
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(err);
		}
		
		@ExceptionHandler(DataIntegrityException.class)
		public ResponseEntity<StandardError> objectNotFound(DataIntegrityException e, HttpServletRequest request){
			StandardError err = new StandardError(HttpStatus.BAD_REQUEST.value(), e.getMessage(),System.currentTimeMillis());
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(err);
		}
		

}

package br.com.dsn.pack.karoo.controller;	

import org.springframework.http.HttpStatus;	
import org.springframework.http.ResponseEntity;	
import org.springframework.web.bind.annotation.ExceptionHandler;	
import org.springframework.web.bind.annotation.RestControllerAdvice;	


import javassist.NotFoundException;	

@RestControllerAdvice	
public class ExceptionController {	

	private static final String K_KAROOERRO_CODE = "k-karooerro-code";	
	private static final String K_KAROOERRO_MSG = "k-karooerro-msg";	
	private static final String K_KAROOERRO_VALUE = "k-karooerro-value";	

	@ExceptionHandler()	
	public ResponseEntity<String> tratarDestaqueNotFound(NotFoundException exception) {	
		String msg = "Item não encontrado!";	

		return ResponseEntity.status(HttpStatus.NOT_FOUND)	
				.header(K_KAROOERRO_MSG, msg)	
				.header(K_KAROOERRO_CODE, "NOT_FOUND")	
				.header(K_KAROOERRO_VALUE, exception.getMessage())	
				.body(msg);	
	}	
} 
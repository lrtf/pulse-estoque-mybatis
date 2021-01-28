package br.com.pulse.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import br.com.pulse.model.exception.ExceptionResponse;
import br.com.pulse.model.exception.ProdutoNotFoundException;

@ControllerAdvice
public class ProdutoControllerAdvice {
	
	@ExceptionHandler(ProdutoNotFoundException.class)
	public final ResponseEntity<ExceptionResponse> notFound(ProdutoNotFoundException ex){
		
		ExceptionResponse exceptionResponse = new ExceptionResponse(ex.getMessage());
		
		return new ResponseEntity<ExceptionResponse>(exceptionResponse, HttpStatus.NOT_FOUND);
	}

}

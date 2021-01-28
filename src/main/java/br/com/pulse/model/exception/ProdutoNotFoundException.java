package br.com.pulse.model.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "Não encontrado")
public class ProdutoNotFoundException extends Exception{

	private static final long serialVersionUID = 1L;
	
	public ProdutoNotFoundException(String message) {
		super(message);
	}
}

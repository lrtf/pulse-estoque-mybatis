package br.com.pulse.model;

import lombok.Data;

@Data
public class Estoque {
	
	private Long id;
	
	private Filial filial;
	
	private Produto produto;
	
	private int quantidade;

}

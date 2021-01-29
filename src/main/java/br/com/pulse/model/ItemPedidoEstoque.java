package br.com.pulse.model;

import java.math.BigDecimal;

import lombok.Data;

@Data
public class ItemPedidoEstoque {
	
	private Long id;
	
	private Long pedidoId;
	
	private Long produtoId;
	
	private int quantidade;
	
	private BigDecimal valotUnitario;
	
	private BigDecimal valorTotal;

}

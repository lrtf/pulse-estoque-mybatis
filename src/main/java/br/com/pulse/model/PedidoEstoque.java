package br.com.pulse.model;

import java.time.LocalDateTime;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
public class PedidoEstoque {
	
	private Long id;
	
	private Long filialId;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDateTime data;
	

}

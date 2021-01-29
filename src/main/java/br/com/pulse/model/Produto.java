package br.com.pulse.model;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Produto {
	
	private Long id;
	
	private String codBarras;
	
	private String descricao;
	
	@JsonFormat(pattern="yyyy-MM-dd")
	private LocalDateTime dataCadastro;
	
	private boolean ativo;

}

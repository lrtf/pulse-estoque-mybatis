package br.com.pulse.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.pulse.model.Estoque;
import br.com.pulse.service.EstoqueService;



@RequestMapping("/estoque")
@RestController
public class EstoqueController {
	
	@Autowired
	EstoqueService estoqueService;
	
	@GetMapping("/{filialId}/{produtoId}")
	public ResponseEntity<Estoque> buscar(@PathVariable Long filialId, @PathVariable Long produtoId){
		Estoque estoque = estoqueService.buscar(filialId, produtoId);
		
		if(estoque == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(estoque);
		
	}

}

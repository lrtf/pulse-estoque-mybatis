package br.com.pulse.controller;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.pulse.model.Produto;
import br.com.pulse.service.ProdutoService;

@RequestMapping("/produto")
@RestController
public class ProdutoController {
	
	@Autowired
	ProdutoService produtoService;
	
	
	@PostMapping
	public ResponseEntity<Produto> insere(@RequestBody Produto produto, UriComponentsBuilder uriBuilder){
		
		Produto p = produtoService.insere(produto);
		
		URI uri = uriBuilder.path("/produto/{id}").buildAndExpand(p.getId()).toUri();
		
		return ResponseEntity.created(uri).body(p);
	}

}

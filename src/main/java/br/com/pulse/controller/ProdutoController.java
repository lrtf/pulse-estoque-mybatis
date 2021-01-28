package br.com.pulse.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.pulse.model.Produto;
import br.com.pulse.service.ProdutoService;

@RequestMapping("/produto")
@RestController
public class ProdutoController extends ResponseEntityExceptionHandler {
	
	@Autowired
	ProdutoService produtoService;
	
	@GetMapping
	public ResponseEntity<List<Produto>> buscarTodos(){
		return new ResponseEntity<List<Produto>>(produtoService.buscarTodos(), HttpStatus.OK);
	}
	
	@GetMapping("/{produtoId}")
	public ResponseEntity<Produto> buscar(@PathVariable Long produtoId) throws Exception {
		return ResponseEntity.ok(produtoService.buscar(produtoId));
	}
	
	
	@PostMapping
	public ResponseEntity<Produto> insere(@RequestBody Produto produto, UriComponentsBuilder uriBuilder){
		
		Produto p = produtoService.insere(produto);
		
		URI uri = uriBuilder.path("/produto/{id}").buildAndExpand(p.getId()).toUri();
		
		return ResponseEntity.created(uri).body(p);
	}
	
	@PutMapping("/{produtoId}")
	public ResponseEntity<Produto> alterar(@RequestBody Produto produto, @PathVariable Long produtoId){
		
		Produto p = produtoService.alterar(produto, produtoId);
		
		return new ResponseEntity<Produto>(p, HttpStatus.OK);
	}
	
	@DeleteMapping("/{produtoId}")
	public ResponseEntity<Object> deletar(@PathVariable Long produtoId){
		
		produtoService.deletar(produtoId);
		
		return ResponseEntity.ok().build();
	}
	
}

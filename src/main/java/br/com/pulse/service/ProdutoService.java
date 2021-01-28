package br.com.pulse.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.pulse.mapper.ProdutoMapper;
import br.com.pulse.model.Produto;
import br.com.pulse.model.exception.ProdutoNotFoundException;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ProdutoService {

	ProdutoMapper produtoMapper;
	
	public List<Produto> buscarTodos() {
		return produtoMapper.buscarTodos();
	}

	public Produto buscar(Long produtoId) throws ProdutoNotFoundException {
		Produto produto = produtoMapper.buscar(produtoId);
		
		if(produto == null) {
			throw new ProdutoNotFoundException ("Product not found.");
		}
		
		return produto;
	}

	@Transactional
	public Produto insere(Produto produto) {

		produtoMapper.inserir(produto);

		return produtoMapper.buscar(produto.getId());

	}
	
	public Produto alterar(Produto produto, Long produtoId) {
		
		produtoMapper.alterar(produto, produtoId);
		
		return produtoMapper.buscar(produtoId);
		
	}
	
	public void deletar(Long produtoId) {
		produtoMapper.deletar(produtoId);
	}

}

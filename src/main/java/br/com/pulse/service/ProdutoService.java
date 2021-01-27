package br.com.pulse.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.pulse.mapper.ProdutoMapper;
import br.com.pulse.model.Produto;

@Service
public class ProdutoService {
	
	@Autowired
	ProdutoMapper produtoMapper;
	
	@Transactional
	public Produto insere(Produto produto) {

	produtoMapper.inserir(produto);
	
	return produtoMapper.buscar(produto.getId());

	}

}

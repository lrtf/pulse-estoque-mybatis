package br.com.pulse.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.pulse.mapper.EstoqueMapper;
import br.com.pulse.model.Estoque;

@Service
public class EstoqueService {
	
	@Autowired
	EstoqueMapper estoqueMapper;
	
	public Estoque buscar(Long filialId, Long produtoId) {
		return estoqueMapper.buscarProdutoPorFilial(filialId, produtoId);
	}

}

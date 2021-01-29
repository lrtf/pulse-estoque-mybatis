package br.com.pulse.service;

import org.apache.ibatis.javassist.NotFoundException;
import org.springframework.stereotype.Service;

import br.com.pulse.mapper.PedidoEstoqueMapper;
import br.com.pulse.model.PedidoEstoque;
import lombok.AllArgsConstructor;


@Service
@AllArgsConstructor
public class PedidoEstoqueService {
	
	private final PedidoEstoqueMapper pedidoEstoque;
	
	public PedidoEstoque buscar(Long id) throws NotFoundException {
		
		PedidoEstoque pe = pedidoEstoque.buscar(id);
		
		if(pe == null) {
			throw new NotFoundException("Pedido não encontrado");
		}
		
		return pe;
	}

}

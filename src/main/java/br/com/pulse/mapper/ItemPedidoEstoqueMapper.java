package br.com.pulse.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import br.com.pulse.model.ItemPedidoEstoque;

@Mapper
@Repository
public interface ItemPedidoEstoqueMapper {
	
	public ItemPedidoEstoque buscar(@Param("pedidoId")Long pedidoId);
	

}

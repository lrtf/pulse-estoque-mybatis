package br.com.pulse.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import br.com.pulse.model.PedidoEstoque;

@Mapper
@Repository
public interface PedidoEstoqueMapper {

	public PedidoEstoque buscar(@Param("pedidoId") Long pedidoId);

}

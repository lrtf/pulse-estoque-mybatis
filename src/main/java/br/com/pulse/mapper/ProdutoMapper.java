package br.com.pulse.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import br.com.pulse.model.Produto;

@Mapper
@Repository
public interface ProdutoMapper {
	
	public void inserir (@Param("produto") Produto produto);
	
	public Produto buscar(@Param("produtoId") Long produtoId);
	 
}

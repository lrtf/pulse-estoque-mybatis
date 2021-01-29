package br.com.pulse.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import br.com.pulse.model.Produto;

@Mapper
@Repository
public interface ProdutoMapper {
	
	public List<Produto> buscarTodos();
	
	public Produto buscar(@Param("produtoId") Long produtoId);
	
	public void inserir (@Param("produto") Produto produto);
	
	public void alterar(@Param("produto") Produto produto, @Param("produtoId") Long produtoId);
	
	public void deletar (@Param("produtoId") Long produtoId);

}

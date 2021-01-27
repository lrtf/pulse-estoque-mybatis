package br.com.pulse.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import br.com.pulse.model.Estoque;

@Mapper
@Repository
public interface EstoqueMapper {

	public Estoque buscarProdutoPorFilial(Long filialId, Long produtoId);
}

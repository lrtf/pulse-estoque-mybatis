package br.com.pulse.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import br.com.pulse.model.Filial;

@Mapper
@Repository
public interface FilialMapper {

  public Filial buscar(Long filialId);

}
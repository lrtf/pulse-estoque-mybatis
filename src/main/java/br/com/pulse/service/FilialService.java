package br.com.pulse.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.pulse.mapper.FilialMapper;
import br.com.pulse.model.Filial;

@Service
public class FilialService {

    @Autowired
    FilialMapper mapper;

    public Filial buscar(Long id){
       return mapper.buscar(id);
    }
    
}

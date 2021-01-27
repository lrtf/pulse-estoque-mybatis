package br.com.pulse.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.pulse.model.Filial;
import br.com.pulse.service.FilialService;

@RestController
@RequestMapping("/filial")
public class FilialController {
    
    @Autowired
    FilialService service;

    @GetMapping("/{id}")
    public ResponseEntity<Filial> buscar(@PathVariable Long id){
       Filial retorno = service.buscar(id);
       
       if(retorno == null){
            return ResponseEntity.notFound().build();
       }

       return ResponseEntity.ok(retorno);
    }

    @PostMapping
    public void salvar(@RequestBody Filial item){



    }

}

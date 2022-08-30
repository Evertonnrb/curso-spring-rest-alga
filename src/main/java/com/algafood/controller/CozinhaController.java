package com.algafood.controller;

import com.algafood.controller.wrapper.CozinhaXMLWrapper;
import com.algafood.domain.model.Cozinha;
import com.algafood.infrastrutura.CozinhaRepositoryImpl;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("cozinhas")  //(value = "/cozinhas", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
public class CozinhaController {

    @Autowired
    private CozinhaRepositoryImpl repository;


    @ResponseStatus(HttpStatus.ACCEPTED)
    @GetMapping
    public List<Cozinha> lisarCozinhas() {
        List<Cozinha> cozinhaList = repository.listarCozinha();
        return cozinhaList;
    }

    @GetMapping(produces = MediaType.APPLICATION_XML_VALUE)
    public CozinhaXMLWrapper listarCozinhasXml() {
        return new CozinhaXMLWrapper(repository.listarCozinha());
    }

    @GetMapping("/{cozinhaId}")
    public ResponseEntity<Cozinha> buscarCozinhaPorCodigo(@PathVariable Long cozinhaId) {
        Cozinha cozinha = repository.buscarPorCodigo(cozinhaId);
        if (cozinha != null)
            return ResponseEntity.status(HttpStatus.OK).body(cozinha);
        return ResponseEntity.notFound().build();
    }

}

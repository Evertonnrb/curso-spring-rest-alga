package com.algafood.controller;

import com.algafood.domain.service.CozinhaService;
import com.algafood.domain.service.RestauranteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("restaurantes")
public class RestauranteController {
    @Autowired
    public RestauranteService service;

    @GetMapping
    public ResponseEntity<?> getCozinhas(){
        return new ResponseEntity<>(service.getRestaurantes(), HttpStatus.OK);
    }
}

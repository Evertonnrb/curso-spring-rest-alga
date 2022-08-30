package com.algafood.controller;

import com.algafood.domain.model.Cozinha;
import com.algafood.jpa.CRUDCozinha;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class TestesController {

    @Autowired
    private CRUDCozinha cozinha;

    @GetMapping("/")
    @ResponseBody
    public String teste() {
        List<Cozinha> cozinhaList = cozinha.cozinhaListCadastradas();
        return cozinhaList.toString();
    }
}

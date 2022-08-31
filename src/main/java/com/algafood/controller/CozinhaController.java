package com.algafood.controller;

import com.algafood.controller.wrapper.CozinhaXMLWrapper;
import com.algafood.domain.exceptions.EntidadeEmUsoException;
import com.algafood.domain.exceptions.EntitidadeNotFoundException;
import com.algafood.domain.model.Cozinha;
import com.algafood.domain.service.CozinhaService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("cozinhas")
//(value = "/cozinhas", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
public class CozinhaController {

    @Autowired
    private CozinhaService service;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public ResponseEntity<?> cadastrarCozinha(@RequestBody Cozinha cozinha) {
        return ResponseEntity.
                ok().
                body(service.salvar(cozinha));
    }

    @ResponseStatus(HttpStatus.ACCEPTED)
    @GetMapping
    public List<Cozinha> lisarCozinhas() {
        List<Cozinha> cozinhaList = service.listar();
        return cozinhaList;
    }
    /*TODO
     *  Resolver bug da duplicação de registro
     * */

    @PutMapping("/{cozinhaId}")
    public ResponseEntity<?> atualizarCozinha(@PathVariable Long cozinhaId, @RequestBody Cozinha cozinha) {
        Cozinha cozinhaAtual = service.buscarPorCodigo(cozinhaId);
        if (cozinhaAtual != null) {
            BeanUtils.copyProperties(cozinha, cozinhaAtual, "id");
            service.salvar(cozinha);
            return ResponseEntity.ok(cozinhaAtual);
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping(produces = MediaType.APPLICATION_XML_VALUE)
    public CozinhaXMLWrapper listarCozinhasXml() {
        return new CozinhaXMLWrapper(service.listar());
    }

    @GetMapping("/{cozinhaId}")
    public ResponseEntity<?> buscarCozinhaPorCodigo(@PathVariable Long cozinhaId) {
        Cozinha cozinha = service.buscarPorCodigo(cozinhaId);
        if (cozinha != null)
            return ResponseEntity.status(HttpStatus.OK).body(cozinha);
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{cozinhaId}")
    public ResponseEntity<?> deletarCozinha(@PathVariable Long cozinhaId) {
        try {
            service.remover(cozinhaId);
            return ResponseEntity.noContent().build();
        } catch (EntitidadeNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        } catch (EntidadeEmUsoException e) {
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }
    }


}

package com.algafood.domain.service;

import com.algafood.domain.exceptions.EntidadeEmUsoException;
import com.algafood.domain.exceptions.EntitidadeNotFoundException;
import com.algafood.domain.model.Cozinha;
import com.algafood.domain.repository.CozinhaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CozinhaService {

    @Autowired
    private CozinhaRepository repository;

    public Cozinha salvar(Cozinha cozinha) {
        return repository.cadastrarCozinha(cozinha);
    }

    public Cozinha buscarPorCodigo(Long id) {
        return repository.buscarPorCodigo(id);
    }

    public List<Cozinha> listar() {
        return repository.listarCozinha();
    }

    public Cozinha atualizar(Long id) {
        Cozinha cozinha = repository.buscarPorCodigo(id);
        return repository.atulizarCozinha(cozinha);
    }

    public void remover(Long id) {
        try {
            repository.deletarCozinha(id);
        } catch (DataIntegrityViolationException e) {
            throw new EntidadeEmUsoException(String.format("Endidade de COD %d em uso, não pode ser removida! ", id));
        } catch (EmptyResultDataAccessException e) {
            throw new EntitidadeNotFoundException(String.format("Entidade de COD %d não cadastrada na base de dados", id));
        }
    }
}

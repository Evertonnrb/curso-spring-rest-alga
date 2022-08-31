package com.algafood.domain.repository;

import com.algafood.domain.model.Cozinha;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CozinhaRepository {

    Cozinha cadastrarCozinha(Cozinha cozinha);
    List<Cozinha> listarCozinha();
    Cozinha buscarPorCodigo(Long id);
    void deletarCozinha(Long id);
    Cozinha atulizarCozinha(Cozinha cozinha);
}

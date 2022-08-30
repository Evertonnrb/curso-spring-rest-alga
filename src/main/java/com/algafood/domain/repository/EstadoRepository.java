package com.algafood.domain.repository;

import com.algafood.domain.model.Estado;

import java.util.List;

public interface EstadoRepository {

    Estado salvar(Estado estado);

    Estado atualizar(Estado estado);

    List<Estado> listar();

    void deletar(Estado estado);
}

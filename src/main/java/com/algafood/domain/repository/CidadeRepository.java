package com.algafood.domain.repository;

import com.algafood.domain.model.Cidade;

import java.util.List;

public interface CidadeRepository {

    Cidade salvar(Cidade cidade);

    Cidade atualizar(Cidade cidade);

    List<Cidade> listar();

    void deletar(Cidade cidade);
}

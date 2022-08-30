package com.algafood.domain.repository;

import com.algafood.domain.model.Permissao;

import java.util.List;

public interface PermissaoRepository {

    Permissao cadastrarPermissao(Permissao permissao);

    Permissao alterarPermissao(Long id);

    List<Permissao> listarPermissoes();

    void removerPermissao(Permissao permissao);
}

package com.algafood.domain.infrastrutura;

import com.algafood.domain.model.Permissao;
import com.algafood.domain.repository.PermissaoRepository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

public class PermissaoRepositoryImpl implements PermissaoRepository {

    @PersistenceContext
    private EntityManager manager;

    @Transactional
    @Override
    public Permissao cadastrarPermissao(Permissao permissao) {
        return manager.merge(permissao);
    }

    @Transactional
    @Override
    public Permissao alterarPermissao(Long id) {
        Permissao permissao = manager.find(Permissao.class, id);
        return manager.merge(permissao);
    }

    @Override
    public List<Permissao> listarPermissoes() {
        return manager.createQuery("from Permissao", Permissao.class).getResultList();
    }

    @Transactional
    @Override
    public void removerPermissao(Permissao permissao) {
        permissao = manager.find(Permissao.class, permissao.getId());
        manager.remove(permissao);
    }
}

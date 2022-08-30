package com.algafood.infrastrutura;

import com.algafood.domain.model.Cidade;
import com.algafood.domain.repository.CidadeRepository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

public class CidadeRepositoryImpl implements CidadeRepository {

    @PersistenceContext
    private EntityManager manager;

    @Transactional
    @Override
    public Cidade salvar(Cidade cidade) {
        return manager.merge(cidade);
    }

    @Transactional
    @Override
    public Cidade atualizar(Cidade cidade) {
        cidade = manager.find(Cidade.class, cidade.getId());
        return manager.merge(cidade);
    }

    @Override
    public List<Cidade> listar() {
        return manager.createQuery("from Cidade", Cidade.class).getResultList();
    }

    @Override
    public void deletar(Cidade cidade) {
        cidade = manager.find(Cidade.class, cidade.getId());
        manager.remove(cidade);
    }
}

package com.algafood.domain.infrastrutura;

import com.algafood.domain.model.Estado;
import com.algafood.domain.repository.EstadoRepository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

public class EstadoRepositoryImpl implements EstadoRepository {

    @PersistenceContext
    private EntityManager manager;

    @Transactional
    @Override
    public Estado salvar(Estado estado) {
        return manager.merge(estado);
    }

    @Transactional
    @Override
    public Estado atualizar(Estado estado) {
        estado = manager.find(Estado.class, estado.getId());
        return manager.merge(estado);
    }

    @Override
    public List<Estado> listar() {
        return manager.createQuery("from Estado", Estado.class).getResultList();
    }

    @Transactional
    @Override
    public void deletar(Estado estado) {
        estado = manager.find(Estado.class, estado.getId());
        manager.remove(estado);
    }
}

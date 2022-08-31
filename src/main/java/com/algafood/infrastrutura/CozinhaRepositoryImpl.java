package com.algafood.infrastrutura;

import com.algafood.domain.model.Cozinha;
import com.algafood.domain.repository.CozinhaRepository;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Component
public class CozinhaRepositoryImpl implements CozinhaRepository {

    @PersistenceContext
    private EntityManager manager;

    @Transactional
    @Override
    public Cozinha cadastrarCozinha(Cozinha cozinha) {
        return manager.merge(cozinha);
    }

    @Override
    public List<Cozinha> listarCozinha() {
        return manager.createQuery("from Cozinha",Cozinha.class).getResultList();
    }

    @Override
    public Cozinha buscarPorCodigo(Long id) {
        return manager.find(Cozinha.class, id);
    }

    @Transactional
    @Override
    public void deletarCozinha(Cozinha cozinha) {
        cozinha = buscarPorCodigo(cozinha.getId());
        manager.remove(cozinha);
    }

    @Transactional
    @Override
    public Cozinha atulizarCozinha(Cozinha cozinha) {
        return manager.merge(cozinha);
    }
}

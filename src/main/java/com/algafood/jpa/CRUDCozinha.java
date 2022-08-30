package com.algafood.jpa;

import com.algafood.domain.model.Cozinha;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Component
public class CRUDCozinha {

    @PersistenceContext
    private EntityManager manager;

    public List<Cozinha> cozinhaListCadastradas() {
        return manager.createQuery("from Cozinha", Cozinha.class).getResultList();
    }

    @Transactional
    public Cozinha cadastrarCozinha(Cozinha cozinha) {
        return manager.merge(cozinha);
    }

    @Transactional
    public void removerCozinha(Cozinha cozinha) {
        cozinha = buscarPorId(cozinha.getId());
        manager.remove(cozinha);
    }

    public Cozinha buscarPorId(Long id) {
        return manager.find(Cozinha.class, id);
    }
}

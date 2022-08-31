package com.algafood.domain.infrastrutura;

import com.algafood.domain.model.Restaurante;
import com.algafood.domain.repository.RestauranteRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Repository
public class RestauranteRepositoryImpl implements RestauranteRepository {

    @PersistenceContext
    private EntityManager manager;

    @Transactional
    @Override
    public Restaurante cadastrarRestauramte(Restaurante restaurante) {
        return manager.merge(restaurante);
    }

    @Override
    public List<Restaurante> listarRestaurantes() {
        return manager.createQuery("from Restaurante", Restaurante.class).getResultList();
    }

    @Override
    public Restaurante buscarRestaurantePorIdentificador(Long id) {
        return manager.find(Restaurante.class, id);
    }

    @Transactional
    @Override
    public Restaurante atualizarDadosRestaurante(Restaurante restaurante) {
        //restaurante = buscarRestaurantePorIdentificador(restaurante.getId());
        return cadastrarRestauramte(restaurante);
    }

    @Transactional
    @Override
    public void removerRestaurante(Restaurante restauranteASerRemovido) {
        restauranteASerRemovido = buscarRestaurantePorIdentificador(restauranteASerRemovido.getId());
        manager.remove(restauranteASerRemovido);
    }
}

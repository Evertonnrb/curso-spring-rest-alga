package com.algafood.domain.service;

import com.algafood.domain.model.Restaurante;
import com.algafood.domain.repository.RestauranteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RestauranteService {
    @Autowired
    private RestauranteRepository repository;

    public Restaurante cadastrarRestaurante(Restaurante restaurante) {
        return repository.save(restaurante);
    }

    public List<Restaurante> getRestaurantes() {
        return repository.findAll();
    }

    public Restaurante buscarPorId(Long id) {
        return repository.getReferenceById(id);
    }

    public Restaurante atualizarRestaurante(Restaurante restaurante) {
        return cadastrarRestaurante(restaurante);
    }

    public void removerRestaurante(Long id) {
        repository.delete(buscarPorId(id));
    }

}

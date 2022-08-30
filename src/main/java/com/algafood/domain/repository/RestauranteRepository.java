package com.algafood.domain.repository;

import com.algafood.domain.model.Restaurante;

import java.util.List;

public interface RestauranteRepository {

    Restaurante cadastrarRestauramte(Restaurante restaurante);

    List<Restaurante> listarRestaurantes();

    Restaurante buscarRestaurantePorIdentificador(Long id);

    void removerRestaurante(Restaurante restaurante);

    Restaurante atualizarDadosRestaurante(Restaurante restaurante);
}

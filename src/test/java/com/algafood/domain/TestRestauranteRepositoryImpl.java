package com.algafood.domain;

import com.algafood.domain.model.Restaurante;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.List;

@SpringBootTest
public class TestRestauranteRepositoryImpl {

    @Autowired
    private RestauranteRepositoryImpl repository;

    @Test
    public void deveCadastrarRestaurante(){
        Restaurante restaurante = new Restaurante();
        restaurante.setNome("Restaurante da esquina");
        restaurante.setTaxaFrete(new BigDecimal("22.90"));
        Restaurante restauranteCadastrado = repository.cadastrarRestauramte(restaurante);
        Assertions.assertNotNull(restauranteCadastrado);
    }

    @Test
    public void deveListarRestaurantesComAsCozinhas(){
        List<Restaurante> restaurantes = repository.listarRestaurantes();
        for(Restaurante e : restaurantes){
            System.out.printf("%s - R$ %.2f - %s\n", e.getNome(), e.getTaxaFrete(), e.getCozinha().getNome());
        }
    }

    @Test
    public void deveExecutarAtualizacaoRestaurante(){
        Restaurante restaurante = new Restaurante();
        restaurante.setNome("Restaurante da esquina");
        restaurante.setTaxaFrete(new BigDecimal("22.90"));
        restaurante = repository.cadastrarRestauramte(restaurante);

        String nome = restaurante.getNome().replace("da esquina","Ze mané");
        restaurante.setNome(nome);
        repository.atualizarDadosRestaurante(restaurante);

        for(Restaurante e : repository.listarRestaurantes()) {
            System.out.println(e);
        }
    }

}

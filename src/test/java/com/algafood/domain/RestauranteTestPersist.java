package com.algafood.domain;

import com.algafood.domain.model.Cozinha;
import com.algafood.domain.model.Restaurante;
import com.algafood.domain.service.CozinhaService;
import com.algafood.domain.service.RestauranteService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;

@SpringBootTest
public class RestauranteTestPersist {

    @Autowired
    CozinhaService cozinhaService;
    @Autowired
    RestauranteService restauranteService;

    @Test
    public void testCadastrarRestaurante(){
        Restaurante restaurante = new Restaurante();
        restaurante.setNome("Bsa");
        restaurante.setTaxaFrete(new BigDecimal("2.5"));
        Cozinha cozinha = cozinhaService.buscarPorCodigo(2L);
        if (cozinha!=null){
            restaurante.setCozinha(cozinha);
        }
        restauranteService.cadastrarRestaurante(restaurante);
    }
}

package com.algafood.jpa;

import com.algafood.AlgafoodApplication;
import com.algafood.domain.model.Cozinha;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;

public class BuscarAtualizarCozinhaMain {
    public static void main(String[] args) {
        ApplicationContext applicationContext =
                new SpringApplicationBuilder(AlgafoodApplication.class)
                        .web(WebApplicationType.NONE)
                        .run(args);

        CRUDCozinha CRUDCozinha = applicationContext.getBean(CRUDCozinha.class);
        Cozinha cozinha = CRUDCozinha.buscarPorId(1L);
        if (cozinha!=null)
            cozinha.setNome(cozinha.getNome().concat(" Atualizada pelo metódo"));
        CRUDCozinha.cadastrarCozinha(cozinha);
        System.out.println(CRUDCozinha.buscarPorId(1L).toString());
    }
}

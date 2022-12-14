package com.algafood.jpa;

import com.algafood.AlgafoodApplication;
import com.algafood.domain.model.Cozinha;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;

public class BuscarCozinhaMain {
    public static void main(String[] args) {
        ApplicationContext applicationContext =
                new SpringApplicationBuilder(AlgafoodApplication.class)
                        .web(WebApplicationType.NONE)
                        .run(args);

        CRUDCozinha CRUDCozinha = applicationContext.getBean(CRUDCozinha.class);
        Cozinha cozinha = CRUDCozinha.buscarPorId(11111L);
        if (cozinha!=null)
            System.out.println(cozinha.getNome());
    }
}

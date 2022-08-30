package com.algafood.jpa;

import com.algafood.AlgafoodApplication;
import com.algafood.domain.model.Cozinha;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;

public class BuscarRemoverCozinhaMain {
    public static void main(String[] args) {
        ApplicationContext applicationContext =
                new SpringApplicationBuilder(AlgafoodApplication.class)
                        .web(WebApplicationType.NONE)
                        .run(args);

        CRUDCozinha CRUDCozinha = applicationContext.getBean(CRUDCozinha.class);
        Cozinha cozinha = new Cozinha();
        cozinha.setId(1L);
        CRUDCozinha.removerCozinha(cozinha);
    }
}

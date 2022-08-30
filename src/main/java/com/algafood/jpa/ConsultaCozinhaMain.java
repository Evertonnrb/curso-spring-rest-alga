package com.algafood.jpa;

import com.algafood.AlgafoodApplication;
import com.algafood.domain.model.Cozinha;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;

import java.util.List;

public class ConsultaCozinhaMain {
    public static void main(String[] args) {
        ApplicationContext applicationContext =
                new SpringApplicationBuilder(AlgafoodApplication.class)
                        .web(WebApplicationType.NONE)
                        .run(args);

        CRUDCozinha CRUDCozinha = applicationContext.getBean(CRUDCozinha.class);

        List<Cozinha> cozinhaList = CRUDCozinha.cozinhaListCadastradas();

        for(Cozinha cozinha : cozinhaList){
            System.out.println(cozinha.getNome());
        }
    }
}

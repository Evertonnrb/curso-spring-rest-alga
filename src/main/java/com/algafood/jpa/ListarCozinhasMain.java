package com.algafood.jpa;

import com.algafood.AlgafoodApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;

public class ListarCozinhasMain {
    public static void main(String[] args) {
        ApplicationContext applicationContext =
                new SpringApplicationBuilder(AlgafoodApplication.class)
                        .web(WebApplicationType.NONE)
                        .run(args);



    }
}

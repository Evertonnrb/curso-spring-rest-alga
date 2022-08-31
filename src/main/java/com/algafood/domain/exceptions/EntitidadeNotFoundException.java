package com.algafood.domain.exceptions;

import org.springframework.dao.EmptyResultDataAccessException;

public class EntitidadeNotFoundException extends RuntimeException {
    public EntitidadeNotFoundException(String e) {
        super(e);
    }
}

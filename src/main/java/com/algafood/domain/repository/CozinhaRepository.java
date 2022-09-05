package com.algafood.domain.repository;

import com.algafood.domain.model.Cozinha;
import com.algafood.domain.model.Restaurante;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CozinhaRepository extends JpaRepository<Cozinha,Long>{
}

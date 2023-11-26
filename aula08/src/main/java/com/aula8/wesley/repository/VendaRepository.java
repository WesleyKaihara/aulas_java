package com.aula8.wesley.repository;

import com.aula8.wesley.model.Venda;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigDecimal;

public interface VendaRepository extends JpaRepository<Venda, BigDecimal> {
}

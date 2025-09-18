package com.insight.demo.repository;

import com.insight.demo.model.PaginaModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaginaRepository extends JpaRepository<PaginaModel, Long> {}
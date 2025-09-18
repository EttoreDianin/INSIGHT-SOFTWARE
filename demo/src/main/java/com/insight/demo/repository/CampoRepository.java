package com.insight.demo.repository;

import com.insight.demo.model.CampoModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CampoRepository extends JpaRepository<CampoModel, Long> {}
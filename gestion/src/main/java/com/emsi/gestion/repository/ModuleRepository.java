package com.emsi.gestion.repository;

import com.emsi.gestion.entity.Module;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ModuleRepository extends JpaRepository<Module, Long> {
}


package com.example.empresas_originadoras.infrastructure.persistence.repository;

import com.example.empresas_originadoras.infrastructure.persistence.entity.EmpresaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmpresaJpaRepository extends JpaRepository<EmpresaEntity, Long> {
    boolean existsByCnpj(String cnpj);
}
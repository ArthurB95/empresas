package com.example.empresas_originadoras.infrastructure.persistence.repository;

import com.example.empresas_originadoras.domain.model.Empresa;
import com.example.empresas_originadoras.infrastructure.persistence.entity.EmpresaEntity;
import com.example.empresas_originadoras.ports.outbound.EmpresaRepository;
import org.springframework.stereotype.Repository;

@Repository
public class EmpresaRepositoryImpl implements EmpresaRepository {

    private final EmpresaJpaRepository jpaRepository;

    public EmpresaRepositoryImpl(EmpresaJpaRepository jpaRepository) {
        this.jpaRepository = jpaRepository;
    }

    @Override
    public Empresa salvar(Empresa empresa) {
        EmpresaEntity entity = EmpresaEntity.fromDomain(empresa);
        return jpaRepository.save(entity).toDomain();
    }

    @Override
    public boolean existsByCnpj(String cnpj) {
        return jpaRepository.existsByCnpj(cnpj);
    }
}
package com.example.empresas_originadoras.ports.outbound;

import com.example.empresas_originadoras.domain.model.Empresa;

public interface EmpresaRepository {
    Empresa salvar(Empresa empresa);
    boolean existsByCnpj(String cnpj);
}
package com.example.empresas_originadoras.ports.inbound;

import com.example.empresas_originadoras.domain.model.Empresa;

public interface EmpresaUseCase {
    Empresa cadastrarEmpresa(Empresa empresa);
}

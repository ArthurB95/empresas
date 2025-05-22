package com.example.empresas_originadoras.application.service;

import com.example.empresas_originadoras.domain.model.Empresa;
import com.example.empresas_originadoras.ports.inbound.EmpresaUseCase;
import com.example.empresas_originadoras.ports.outbound.EmpresaRepository;
import org.springframework.stereotype.Service;

@Service
public class EmpresaService implements EmpresaUseCase {

    private final EmpresaRepository empresaRepository;

    public EmpresaService(EmpresaRepository empresaRepository) {
        this.empresaRepository = empresaRepository;
    }

    @Override
    public Empresa cadastrarEmpresa(Empresa empresa) {
        validar(empresa);

        if (empresaRepository.existsByCnpj(empresa.getCnpj())) {
            throw new RuntimeException();
        }

        return empresaRepository.salvar(empresa);
    }

    private void validar(Empresa empresa) {
        if (!cnpjValido(empresa.getCnpj())) throw new RuntimeException("002=CNPJ inválido.");
        if (empresa.getNome() == null) throw new RuntimeException("003=Nome da empresa não informado.");
        if (empresa.getCanal() == null) throw new RuntimeException("004=Canal não informado.");
        if (empresa.getConvenioCoobranca() == null) throw new RuntimeException("005=Convênio de cobrança não informado.");
    }

    private boolean cnpjValido(String cnpj) {
        // pode usar lib tipo: org.apache.commons.validator
        return cnpj != null && cnpj.matches("\\d{14}");
    }
}
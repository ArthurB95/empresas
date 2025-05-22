package com.example.empresas_originadoras.adapters.inbound.controller;

import com.example.empresas_originadoras.domain.model.Empresa;
import com.example.empresas_originadoras.ports.inbound.EmpresaUseCase;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/srv/empresas-originadoras")
public class EmpresaController {

    private final EmpresaUseCase empresaUseCase;

    public EmpresaController(EmpresaUseCase empresaUseCase) {
        this.empresaUseCase = empresaUseCase;
    }

    @PostMapping
    public ResponseEntity criar(@RequestBody Empresa empresa) {
        try {
            Empresa salva = empresaUseCase.cadastrarEmpresa(empresa);
            return ResponseEntity.status(HttpStatus.CREATED).body(salva);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("500=Erro desconhecido.");
        }
    }
}

package com.example.empresas_originadoras.domain.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ContaBancaria {
    private String banco;
    private String agencia;
    private String conta;
    private String digito;
}

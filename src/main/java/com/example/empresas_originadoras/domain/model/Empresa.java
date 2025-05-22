package com.example.empresas_originadoras.domain.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Empresa {
    private String cnpj;
    private Integer diasInadimplencia;
    private String nome;
    private String canal;
    private String convenioCoobranca;
    private String convenioPagFlor;
    private List<ContaBancaria> contasLiquidacao;
    private List<ContaBancaria> contasCobranca;
}

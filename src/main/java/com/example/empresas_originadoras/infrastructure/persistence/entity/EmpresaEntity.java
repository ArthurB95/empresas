package com.example.empresas_originadoras.infrastructure.persistence.entity;

import com.example.empresas_originadoras.domain.model.Empresa;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "tb_empresas")
public class EmpresaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String cnpj;
    private Integer diasInadimplencia;
    private String nome;
    private String canal;
    private String convenioCoobranca;
    private String convenioPagFlor;

    public static EmpresaEntity fromDomain(Empresa empresa) {
        EmpresaEntity entity = new EmpresaEntity();
        entity.setCnpj(empresa.getCnpj());
        entity.setDiasInadimplencia(empresa.getDiasInadimplencia());
        entity.setNome(empresa.getNome());
        entity.setCanal(empresa.getCanal());
        entity.setConvenioCoobranca(empresa.getConvenioCoobranca());
        entity.setConvenioPagFlor(empresa.getConvenioPagFlor());
        return entity;
    }

    public Empresa toDomain() {
        Empresa empresa = new Empresa();
        empresa.setCnpj(this.getCnpj());
        empresa.setDiasInadimplencia(this.getDiasInadimplencia());
        empresa.setNome(this.getNome());
        empresa.setCanal(this.getCanal());
        empresa.setConvenioCoobranca(this.getConvenioCoobranca());
        empresa.setConvenioPagFlor(this.getConvenioPagFlor());
        return empresa;
    }
}
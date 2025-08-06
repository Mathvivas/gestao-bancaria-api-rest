package com.matheus.gestao_bancaria_api_rest.conta;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name = "conta")
@Entity(name = "Conta")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "numero_conta")
public class Conta {

    @Id
    private Integer numero_conta;
    private float saldo;

    public Conta(DadosConta dados) {
        this.numero_conta = dados.numero_conta();
        this.saldo = dados.saldo();
    }
}

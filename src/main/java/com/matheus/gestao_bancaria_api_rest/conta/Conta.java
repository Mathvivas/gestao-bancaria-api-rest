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
@EqualsAndHashCode(of = "numeroConta")
public class Conta {

    @Id
    private Integer numeroConta;
    private float saldo;

    public Conta(DadosConta dados) {
        this.numeroConta = dados.numeroConta();
        this.saldo = dados.saldo();
    }
}

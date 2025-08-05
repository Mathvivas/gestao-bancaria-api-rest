package com.matheus.gestao_bancaria_api_rest.conta;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Table(name = "conta")
@Entity(name = "Conta")
public class Conta {

    @Id
    private int id;
    private float saldo;

    public Conta(DadosConta dados) {
        this.id = dados.id();
        this.saldo = dados.saldo();
    }
}

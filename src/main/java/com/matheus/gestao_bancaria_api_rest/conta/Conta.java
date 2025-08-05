package com.matheus.gestao_bancaria_api_rest.conta;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name = "conta")
@Entity(name = "Conta")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Conta {

    @Id
    private int id;
    private float saldo;

    public Conta(DadosConta dados) {
        this.id = dados.id();
        this.saldo = dados.saldo();
    }
}

package com.matheus.gestao_bancaria_api_rest.transacao;

import com.matheus.gestao_bancaria_api_rest.conta.DadosConta;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name = "transacao")
@Entity(name = "Transacao")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "numeroConta")
public class Transacao {

    private FormaPagamento formaPagamento;
    @Id
    private Integer numeroConta;
    private float valor;

    public Transacao(DadosTransacao dados) {
        this.formaPagamento = dados.formaPagamento();
        this.numeroConta = dados.numeroConta();
        this.valor = dados.valor();
    }
}

package com.matheus.gestao_bancaria_api_rest.transacao;

import jakarta.validation.constraints.NotNull;

public record DadosTransacao(
        @NotNull
        FormaPagamento formaPagamento,

        @NotNull
        Integer numeroConta,

        @NotNull
        float valor) {
}

package com.matheus.gestao_bancaria_api_rest.conta;

import jakarta.validation.constraints.NotNull;

public record DadosConta(
    @NotNull
    Integer numeroConta,

    @NotNull
    float saldo) {
}

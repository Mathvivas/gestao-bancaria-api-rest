package com.matheus.gestao_bancaria_api_rest.transacao;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum FormaPagamento {
    P(0.0f),
    C(0.05f),
    D(0.03f);

    private final float taxa;

}

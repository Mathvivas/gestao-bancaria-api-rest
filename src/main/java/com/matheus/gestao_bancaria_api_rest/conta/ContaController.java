package com.matheus.gestao_bancaria_api_rest.conta;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("conta")
public class ContaController {

    @PostMapping
    public void criar(@RequestBody DadosConta dados) {

    }
}

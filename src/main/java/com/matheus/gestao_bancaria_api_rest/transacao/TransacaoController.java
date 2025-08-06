package com.matheus.gestao_bancaria_api_rest.transacao;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("transacao")
public class TransacaoController {

    @Autowired
    private TransacaoRepository repository;

    @PostMapping
    @Transactional
    public void realizar(@RequestBody @Valid DadosTransacao dados) {
        repository.save(new Transacao(dados));
    }
}

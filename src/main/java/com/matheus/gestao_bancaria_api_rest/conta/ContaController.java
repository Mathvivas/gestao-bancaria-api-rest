package com.matheus.gestao_bancaria_api_rest.conta;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("conta")
public class ContaController {

    @Autowired
    private ContaRepository repository;

    @PostMapping
    @Transactional
    public void criar(@RequestBody @Valid DadosConta dados) {
        repository.save(new Conta(dados));
    }

    @GetMapping
    public ResponseEntity<?> listar(@RequestParam(required = false) Integer numeroConta) {
        if (numeroConta == null) {
            return ResponseEntity
                    .badRequest()
                    .body("Você deve fornecer o parâmetro 'numeroConta'.");
        }
            return repository.findById(numeroConta)
                    .map(ResponseEntity::ok)
                    .orElse(ResponseEntity.notFound().build());
    }
}

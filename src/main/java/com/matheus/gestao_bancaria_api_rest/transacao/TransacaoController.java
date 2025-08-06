package com.matheus.gestao_bancaria_api_rest.transacao;

import com.matheus.gestao_bancaria_api_rest.conta.Conta;
import com.matheus.gestao_bancaria_api_rest.conta.ContaRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("transacao")
public class TransacaoController {

    @Autowired
    private ContaRepository repository;

    @PostMapping
    @Transactional
    public ResponseEntity<?> realizar(@RequestBody @Valid DadosTransacao dados) {
        FormaPagamento forma = dados.formaPagamento();
        float valor = dados.valor();

        Optional<Conta> contaOpt = repository.findById(dados.numeroConta());
        if (contaOpt.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Conta não encontrada");
        }

        Conta conta = contaOpt.get();

        float taxa = valor * forma.getTaxa();
        float total = valor + taxa;

        if (conta.getSaldo() < total) {
            return ResponseEntity.badRequest().body("Saldo insuficiente para realizar a transação");
        }

        conta.setSaldo(conta.getSaldo() - total);
        repository.save(conta);

        return ResponseEntity.ok("Transação realizada com sucesso. Taxa aplicada: " + taxa);
    }
}

package com.matheus.gestao_bancaria_api_rest.transacao;

import com.matheus.gestao_bancaria_api_rest.conta.Conta;
import com.matheus.gestao_bancaria_api_rest.conta.ContaRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.MediaType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.transaction.annotation.Transactional;

import static org.hamcrest.Matchers.containsString;
import static org.junit.jupiter.api.Assertions.*;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@Transactional
class TransacaoControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ContaRepository repository;

    @BeforeEach
    void setup() {
        repository.deleteAll();
        repository.save(new Conta(234, 200f));
    }

    @Test
    void testTransacaoDebitoComSaldoSuficiente() throws Exception {
        String json = """
                {
                    "formaPagamento": "D",
                    "numeroConta": 234,
                    "valor": 100
                }
                """;

        mockMvc.perform(post("/transacao")
                        .contentType(String.valueOf(MediaType.APPLICATION_JSON))
                        .content(json))
                .andExpect(status().isCreated())
                .andExpect(content().string(containsString("Transação realizada com sucesso")));
    }

    @Test
    void testTransacaoContaNaoEncontrada() throws Exception {
        String json = """
                {
                    "formaPagamento": "P",
                    "numeroConta": 999,
                    "valor": 50
                }
                """;

        mockMvc.perform(post("/transacao")
                        .contentType(String.valueOf(MediaType.APPLICATION_JSON))
                        .content(json))
                .andExpect(status().isNotFound())
                .andExpect(content().string(containsString("Conta não encontrada")));
    }

    @Test
    void testTransacaoSaldoInsuficiente() throws Exception {
        String json = """
                {
                    "formaPagamento": "C",
                    "numeroConta": 234,
                    "valor": 1000
                }
                """;

        mockMvc.perform(post("/transacao")
                        .contentType(String.valueOf(MediaType.APPLICATION_JSON))
                        .content(json))
                .andExpect(status().isBadRequest())
                .andExpect(content().string(containsString("Saldo insuficiente")));
    }
}
package com.matheus.gestao_bancaria_api_rest.conta;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@ActiveProfiles("test")
class ContaRepositoryTest {

    @Autowired
    private ContaRepository repository;

    @Test
    void deveSalvarConta() {
        Conta conta = new Conta(1001, 500f);
        Conta saved = repository.save(conta);
        assertNotNull(saved);
        assertEquals(500f, saved.getSaldo());
    }

    @Test
    void deveBuscarContaPorId() {
        repository.save(new Conta(123, 300f));
        Optional<Conta> result = repository.findById(123);
        assertTrue(result.isPresent());
    }


}
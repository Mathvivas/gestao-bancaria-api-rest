package com.matheus.gestao_bancaria_api_rest.transacao;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TransacaoRepository extends JpaRepository<Transacao, Integer> {
}

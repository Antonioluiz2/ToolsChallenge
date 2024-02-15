package com.timeElite.ToolsChallenge.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.timeElite.ToolsChallenge.model.Descricao;
import com.timeElite.ToolsChallenge.model.FormaPagamento;
import com.timeElite.ToolsChallenge.model.PagamentoResponse;
import com.timeElite.ToolsChallenge.model.Transacao;
import java.util.List;


//@Repository
public interface PagamentoResponseRepository extends JpaRepository<FormaPagamento ,Long>{



}

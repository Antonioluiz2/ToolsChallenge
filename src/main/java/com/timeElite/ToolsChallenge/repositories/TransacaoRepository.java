package com.timeElite.ToolsChallenge.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.timeElite.ToolsChallenge.model.Descricao;
import com.timeElite.ToolsChallenge.model.Transacao;


@Repository
public interface TransacaoRepository extends JpaRepository<Transacao ,Long>{

	void save(Descricao des);
	Transacao getReferecyById(Long id);

}

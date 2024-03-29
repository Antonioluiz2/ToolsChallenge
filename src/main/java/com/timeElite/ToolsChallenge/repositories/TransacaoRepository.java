package com.timeElite.ToolsChallenge.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.timeElite.ToolsChallenge.model.Descricao;
import com.timeElite.ToolsChallenge.model.FormaPagamento;
import com.timeElite.ToolsChallenge.model.ResponseTransacao;
import com.timeElite.ToolsChallenge.model.Transacao;


@Repository
public interface TransacaoRepository  extends JpaRepository<Transacao ,Long>{

	void save(FormaPagamento formaPagamento);

	void save(Descricao desc);
	Transacao getReferenceById(Long id);
//	Descricao getRefDescById(Long id);
//	FormaPagamento getReforPagById(Long id);
//	@Query(value= "SELECT u FROM Transacao u WHERE u.name LIKE %?1%")
//	List<Transacao> buscarPorID(String id);
//	void save(ResponseTransacao rt);


//	Transacao save(ResponseTransacao rt);
}

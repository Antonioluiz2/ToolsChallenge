package com.timeElite.ToolsChallenge.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.timeElite.ToolsChallenge.model.Descricao;


@Repository
public interface DescricaoRepository  extends JpaRepository<Descricao ,Long>{

//	Descricao getRefDescById(Long id);
//	FormaPagamento getReforPagById(Long id);
//	@Query(value= "SELECT u FROM Transacao u WHERE u.name LIKE %?1%")
//	List<Transacao> buscarPorID(String id);
//	void save(ResponseTransacao rt);

//	Transacao save(ResponseTransacao rt);
}

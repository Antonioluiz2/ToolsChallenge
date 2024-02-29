package com.timeElite.ToolsChallenge.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.timeElite.ToolsChallenge.model.EstornoTransacao;


@Repository
public interface EstornoRepository  extends JpaRepository<EstornoTransacao ,Long>{

//	ResponseTransacao save(Transacao objDTO);

//	ResponseTransacao save(Transacao tr);

}

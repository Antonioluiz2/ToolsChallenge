package com.timeElite.ToolsChallenge.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.timeElite.ToolsChallenge.model.ResponseTransacao;
import com.timeElite.ToolsChallenge.model.Transacao;


@Repository
public interface ResponseRepository  extends JpaRepository<ResponseTransacao ,Long>{


//	ResponseTransacao save(Transacao objDTO);

//	ResponseTransacao save(Transacao tr);

}

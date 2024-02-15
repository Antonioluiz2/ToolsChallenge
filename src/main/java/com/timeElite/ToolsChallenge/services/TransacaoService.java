package com.timeElite.ToolsChallenge.services;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.apache.coyote.BadRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.timeElite.ToolsChallenge.enuns.Status;
import com.timeElite.ToolsChallenge.model.Descricao;
import com.timeElite.ToolsChallenge.model.EstornoResponse;
import com.timeElite.ToolsChallenge.model.PagamentoResponse;
import com.timeElite.ToolsChallenge.model.Transacao;
import com.timeElite.ToolsChallenge.repositories.PagamentoResponseRepository;
import com.timeElite.ToolsChallenge.repositories.TransacaoRepository;

@Service
public class TransacaoService {
	
	@Autowired
	private static TransacaoRepository repository;
	
	@Autowired
	private PagamentoResponseRepository responseRepository;

	public Transacao  realizarPagamento( Transacao tr ) {
		return repository.save(tr);
    }
	
	public PagamentoResponse getPagamento(Long id) throws Exception {
        Transacao transacao = repository.getReferenceById(id).orElse(null);

        if (transacao == null) {
            throw new Exception("Pagamento não encontrado");
        }

        PagamentoResponse response = new PagamentoResponse();
        response.setTransacao(transacao);

        return response;
    }

    public List<PagamentoResponse> getAllPagamentos() {
        List<Transacao> transacoes = repository.findAll();

        List<PagamentoResponse> responses = new ArrayList<>();
        for (Transacao transacao : transacoes) {
            PagamentoResponse response = new PagamentoResponse();
            response.setTransacao(transacao);
            responses.add(response);
        }

        return responses;
    }
    
    public static List<Transacao> consultarPagamentos() {
        return repository.findAll();
    }
    
    public Transacao realizarEstorno(Long id) {
    	Transacao pagamento = repository.findById(id).orElseThrow(() -> new RuntimeException("Pagamento não encontrado"));
        Descricao des=new Descricao();
        des.setStatus(Status.CANCELADO);
        des.setDataHora(des.getDataHora());

       repository.save(des);

        return pagamento;
    }

    public EstornoResponse estornarPagamento(Long id) throws Exception {
        Transacao transacao = repository.findById(id).orElse(null);
        Descricao desc=new Descricao(id, null, null, id, id, null);
        if (transacao == null) {
            throw new Exception("Pagamento não encontrado");
        }

        if (!desc.getStatus().equals("AUTORIZADO")) {
            throw new BadRequestException("Pagamento não pode ser estornado");
        }

        desc.setStatus(Status.CANCELADO);
        repository.save(transacao);

        EstornoResponse response = new EstornoResponse(id, null, desc, null);
        response.setTransacao(transacao);

        return response;
    }
//
//	public Transacao realizarPagamento(Transacao tr) {
//		repository.save(tr);
//		return null;
//	}	
}

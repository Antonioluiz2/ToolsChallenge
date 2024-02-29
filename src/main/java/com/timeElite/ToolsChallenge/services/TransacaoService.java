package com.timeElite.ToolsChallenge.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apiPagamento.payNow.exceptions.ParametroInvalidoException;
import com.timeElite.ToolsChallenge.enuns.Status;
import com.timeElite.ToolsChallenge.model.Descricao;
import com.timeElite.ToolsChallenge.model.FormaPagamento;
import com.timeElite.ToolsChallenge.model.ResponseTransacao;
import com.timeElite.ToolsChallenge.model.Transacao;
import com.timeElite.ToolsChallenge.repositories.DescricaoRepository;
import com.timeElite.ToolsChallenge.repositories.FormaPagamentoRepository;
import com.timeElite.ToolsChallenge.repositories.ResponseRepository;
import com.timeElite.ToolsChallenge.repositories.TransacaoRepository;

import jakarta.transaction.Transactional;


@Service
@Transactional
public class TransacaoService {

	@Autowired
	private TransacaoRepository repository;
	@Autowired
	private ResponseRepository rr;
	@Autowired
	private DescricaoRepository dr;
	@Autowired
	private FormaPagamentoRepository pr;

	public Transacao save(Transacao tr) {
		ResponseTransacao tr1= new ResponseTransacao();
		tr1.setTransacao(tr);
		tr1.getTransacao();
		FormaPagamento formaPagamento = tr.getFormaPagamento(); // Assuming getter method
		Descricao desc=tr.getDescricao();
		repository.save(desc);
		repository.save(formaPagamento); // Assuming service method for saving FormaPagamento
		repository.save(tr);
		rr.save(tr1);
		return repository.save(tr);
	}

	public List<Transacao> getAll(Transacao tr) {
		return repository.findAll();
	}
	
	public List<ResponseTransacao> buscarResponse(ResponseTransacao tr) {
		return rr.findAll();
	}

	public Transacao getById(Long id) {
		return repository.getReferenceById(id);
	}
	
	public void delete(Long id) {
		 rr.deleteById(id);
		 repository.deleteById(id);
		 dr.deleteById(id);
		 pr.deleteById(id);
	}
	public Transacao update(Long id, Transacao obj) {
		//ResponseTransacao entity = rr.getReferenceById(id);
		Transacao tr=		repository.getReferenceById(id);
		updateData(obj,tr);
		return obj= repository.save(tr);
		
	}
	private void updateData(Transacao entity, Transacao obj) {
		//entity.setTransacao(entity.getTransacao());
		obj.setCartao(obj.getCartao());
		obj.setId(obj.getId());
		obj.setDescricao(obj.getDescricao());
		obj.setFormaPagamento(obj.getFormaPagamento());
//		entity.setId(obj.getId());
//		entity.setDescricao(obj.getDescricao());
//		entity.setFormaPagamento(obj.getFormaPagamento());
	}

	// Realiza a solicitação de Extorno de processo de pagamento
		public Transacao processarSolicitarExtornoPagamento(Long id) {

			Transacao pagamento = repository.getReferenceById(id);
			ResponseTransacao rp= new ResponseTransacao(pagamento);
			if (rp.getTransacao().getDescricao().getStatus() == Status.CANCELADO) {
				throw new ParametroInvalidoException(
						"Não possivel Extornar pagamento de ID: " + id + " pois pagamento já se encontra NEGADO. "
								+ "Em caso de dúvidas por favor entre em contato com nosso Suporte");
			}else {
				rp.getTransacao().getDescricao().setStatus(Status.CANCELADO);
			}

			
			rp.getTransacao().getDescricao().setStatus(Status.CANCELADO);

			rp.setTransacao(repository.save(rp.getTransacao()));

			return pagamento;

		}

		// Retorna o extorno por ID
		public ResponseTransacao buscarEstornoPorId(Long id) {
			Transacao transacao = repository.getReferenceById(id);
//				Transacao transacao = repository.findByIdAndDescricaoStatusIn(Long.parseLong(id), List.of(Status.CANCELADO))
//						.orElseThrow(() -> null);

				// Retornado dessa maneira para seguir o exemplo enviado
				return new ResponseTransacao(transacao);

		}
		
	
}

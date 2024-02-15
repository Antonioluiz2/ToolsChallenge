package com.timeElite.ToolsChallenge.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.timeElite.ToolsChallenge.model.EstornoResponse;
import com.timeElite.ToolsChallenge.model.PagamentoResponse;
import com.timeElite.ToolsChallenge.model.Transacao;
import com.timeElite.ToolsChallenge.repositories.TransacaoRepository;
import com.timeElite.ToolsChallenge.services.TransacaoService;

@RestController
@RequestMapping(value="/api")
public class TransacaoController {

	 @Autowired
	    private TransacaoService transacaoService;
	 
	 @Autowired
		private TransacaoRepository repository;
	 
	    @PostMapping("/pagamentos")
	    public Transacao criarPagamento(@RequestBody Transacao tr) {
	        return transacaoService.realizarPagamento(tr);
//	        return repository.save(tr);
	    }

	    @GetMapping("/pagamentos/{id}")
	    public ResponseEntity<?> consultarPagamento(@PathVariable Long id) throws Exception {
	    	PagamentoResponse pagamento = transacaoService.getPagamento(id);
	        return ResponseEntity.ok(pagamento);
	    }
	    @GetMapping("/pagamentos")
	    public ResponseEntity<?> consultarPagamentos() {
	        List<Transacao> pagamentos = TransacaoService.consultarPagamentos();
	        return ResponseEntity.ok(pagamentos);
	    }

	    @PostMapping("/estornos/{id}")
	    public EstornoResponse estornarPagamento(@PathVariable("id") Long id) throws Exception {
	        return transacaoService.estornarPagamento(id);
	    }
	    @PostMapping("/pagamentos/{id}/estorno")
	    public ResponseEntity<?> realizarEstorno(@PathVariable Long id) {
	    	Transacao pagamento = transacaoService.realizarEstorno(id);
	        return ResponseEntity.ok(pagamento);
	    }
	    
}

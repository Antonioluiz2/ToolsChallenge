package com.timeElite.ToolsChallenge.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.timeElite.ToolsChallenge.model.ResponseTransacao;
import com.timeElite.ToolsChallenge.model.Transacao;
import com.timeElite.ToolsChallenge.repositories.ResponseRepository;
import com.timeElite.ToolsChallenge.services.TransacaoService;

@RestController
@RequestMapping(value="/api")
@CrossOrigin(origins = "*")
public class TransacaoController {
	
	@Autowired
	private TransacaoService service;
	
	@Autowired
	private ResponseRepository rr;
	
	@PostMapping("/pagamentos")
	@ResponseStatus(value = HttpStatus.CREATED)
    public ResponseEntity<Transacao> create(@RequestBody ResponseTransacao objDTO){
		Transacao obj = objDTO.getTransacao();
		obj=service.save(obj);
		//   return convertToTransDTO(obj);
        return ResponseEntity.ok().body(obj);
    }

	@GetMapping("/pagamentos")
	public ResponseEntity<java.util.List<Transacao>> getAll(@RequestBody Transacao tr){
		java.util.List<Transacao> lt=service.getAll(tr);
		ResponseEntity.ok().body(tr);
		//   return convertToTransDTO(obj);
        return ResponseEntity.ok(lt);
	}
	
	@GetMapping("/estorno")
	public ResponseEntity<java.util.List<ResponseTransacao>> get(@RequestBody ResponseTransacao tr){
		java.util.List<ResponseTransacao> lt=service.buscarResponse(tr);
		ResponseEntity.ok().body(tr);
		//   return convertToTransDTO(obj);
        return ResponseEntity.ok(lt);
	}
	@GetMapping("/pagamentos/{id}")
	public ResponseEntity<Transacao> getId(@PathVariable Long id,Transacao tr){
		Transacao lt=service.getById(id);
//		ResponseTransacao lt=rr.getReferenceById(id);
//		ResponseEntity.ok().body(id).status(200);
        return ResponseEntity.ok().body(lt);
	}
	@PutMapping(value = "/estornar/{id}")
	public ResponseEntity<Transacao> estornarPagamentoById(@PathVariable Long id) {
		Transacao response = service.processarSolicitarExtornoPagamento(id);
		return response == null ? ResponseEntity.unprocessableEntity().build() : ResponseEntity.ok(response);
	}

	@GetMapping(value = "/pagamento-estornado/{id}")
	public ResponseEntity<?> getEstornoById(@PathVariable(required = false) Long id) {
		ResponseTransacao response = service.buscarEstornoPorId(id);
		return response == null ? ResponseEntity.unprocessableEntity().build() : ResponseEntity.ok(response);
	}

	
	

}

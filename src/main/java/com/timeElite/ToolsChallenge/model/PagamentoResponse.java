package com.timeElite.ToolsChallenge.model;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Autowired;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

//@Entity


public class PagamentoResponse implements Serializable{
	private static final long serialVersionUID = 1L;
	
//	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
//	Long id;
	private Transacao transacao;
//	 Transacao transacao=new Transacao();
//	private Transacao transacao() {
//		transacao.setCartao(transacao.getCartao());
//		transacao.setId(transacao.getId());
//		return transacao;
//
//	}
	
	public PagamentoResponse() {
	}
	
	public PagamentoResponse( Transacao transacao) {
		this.transacao = transacao;
	}
//	
	public Transacao getTransacao() {
		
		return transacao;
	}
//	
	public void setTransacao(Transacao transacao) {
		this.transacao = transacao;
	}

//	public Transacao orElse(Object object) {
//		// TODO Auto-generated method stub
//		return null;
//	}
	
	
	    
}

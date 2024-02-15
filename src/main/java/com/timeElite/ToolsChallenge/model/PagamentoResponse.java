package com.timeElite.ToolsChallenge.model;

import java.io.Serializable;


public class PagamentoResponse implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private Transacao transacao;
	
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

	public Transacao orElse(Object object) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	    
}

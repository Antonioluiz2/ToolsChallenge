package com.timeElite.ToolsChallenge.model;

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class EstornoResponse extends Transacao{
	public EstornoResponse(Long id, String cartao, Descricao descricao, FormaPagamento formaPagamento) {
		super(id, cartao, descricao, formaPagamento);
	}
	private static final long serialVersionUID = 1L;
	
	@Id
	private Long id;
	private Transacao transacao;
	private Descricao descricao;
	

	public EstornoResponse() {
		// TODO Auto-generated constructor stub
	}

	public EstornoResponse(Descricao descricao) {
		this.descricao = descricao;
	}

	public Descricao getDescricao() {
		return descricao;
	}

	public void setDescricao(Descricao descricao) {
		this.descricao = descricao;
	}

	public Transacao getTransacao() {
		return transacao;
	}

	public void setTransacao(Transacao transacao) {
		this.transacao = transacao;
	}
	 
	 
}

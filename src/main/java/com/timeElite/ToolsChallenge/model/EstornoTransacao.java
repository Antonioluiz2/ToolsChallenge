package com.timeElite.ToolsChallenge.model;

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class EstornoTransacao implements Serializable{
	private static final long serialVersionUID = 1L;
	
	

	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private Transacao transacao;
	private Descricao descricao;
	

	public EstornoTransacao() {
		// TODO Auto-generated constructor stub
	}

	public EstornoTransacao(Descricao desc) {
		descricao.setValor(desc.getValor());
		descricao.setDataHora(desc.getDataHora());
		descricao.setEstabelecimento(desc.getEstabelecimento());
		descricao.setNsu(desc.getNsu());
		descricao.setCodigoAutorizacao(desc.getCodigoAutorizacao());
		descricao.setStatus(desc.getStatus());
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Transacao getTransacao() {
		return transacao;
	}

	public void setTransacao(Transacao transacao) {
		this.transacao = transacao;
	}

	public Descricao getDescricao() {
		return descricao;
	}

	public void setDescricao(Descricao descricao) {
		this.descricao = descricao;
	}

	 
}

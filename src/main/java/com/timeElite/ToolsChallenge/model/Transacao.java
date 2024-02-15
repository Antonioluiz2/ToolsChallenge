package com.timeElite.ToolsChallenge.model;

import org.springframework.boot.jackson.JsonComponent;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;


@Entity
public class Transacao  extends PagamentoResponse {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String cartao;
	private Descricao descricao;
	private FormaPagamento formaPagamento;

	public Transacao() {
	}
	public Transacao(Long id, String cartao,Descricao descricao,FormaPagamento formaPagamento) {
		this.id = id;
		this.cartao = cartao;
		this.descricao = descricao;
		this.formaPagamento=formaPagamento;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getCartao() {
		return cartao;
	}
	public void setCartao(String cartao) {
		this.cartao = cartao;
	}
	public Descricao getDescricao() {
		return descricao;
	}
	public void setDescricao(Descricao descricao) {
		this.descricao = descricao;
	}
	public FormaPagamento getFormaPagamento() {
		return formaPagamento;
	}
	public void setFormaPagamento(FormaPagamento formaPagamento) {
		this.formaPagamento = formaPagamento;
	}
	public Transacao orElse(Object object) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public String toString() {
		return "Transacao [id=" + id + ", cartao=" + cartao + ", descricao=" + descricao + ", formaPagamento="
				+ formaPagamento + "]";
	}

	
}

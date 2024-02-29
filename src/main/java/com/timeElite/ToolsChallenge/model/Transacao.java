package com.timeElite.ToolsChallenge.model;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

@Entity
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class Transacao implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@JsonIgnore
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public  Long i ;
	public String id;
	public  String cartao ;
	
	@OneToOne
	@JoinColumn(name = "tb_desc")
	private Descricao descricao;
	
	@OneToOne
	@JoinColumn(name = "tb_form")
	private FormaPagamento formaPagamento;
	
	@OneToOne
	@JoinColumn(name="tb_trans")
	private ResponseTransacao responseTransacao;
	
	public Transacao() {
	}
	
	public Transacao(Long i, String id,String cartao,Descricao descricao,  FormaPagamento formaPagamento) {
		super();
		this.i = i;
		this.id=id;
		this.cartao = cartao;
		this.descricao=descricao;
		this.formaPagamento = formaPagamento;
	}
	
	public Long getI() {
		return i;
	}
	public void setI(Long i) {
		this.i = i;
	}
	
	

	public String getId() {
		return id;
	}

	public void setId(String id) {
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

}

package com.timeElite.ToolsChallenge.model;

import java.io.Serializable;

import org.springframework.web.bind.annotation.RequestBody;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;

@Entity
public class ResponseTransacao implements Serializable{
	private static final long serialVersionUID = 1L;
	
	
	@OneToOne
	@JoinColumn(name="tb_trans")
	private Transacao transacao;
	
    @JsonIgnore
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	public ResponseTransacao() {
	}
	public Transacao getTransacao() {
		return transacao;
	}
	public ResponseTransacao( Transacao transacao) {
		this.transacao = transacao;
		
	}

	public void setTransacao(Transacao transacao) {
		this.transacao = transacao;
	}

}

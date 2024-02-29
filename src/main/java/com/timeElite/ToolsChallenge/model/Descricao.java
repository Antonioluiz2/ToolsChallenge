package com.timeElite.ToolsChallenge.model;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Random;

import javax.annotation.processing.Generated;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.timeElite.ToolsChallenge.enuns.Status;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
//@Table(name="tb_desc")
public class Descricao implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@OneToOne
	private Transacao transacao;
	
	private double valor;
	private String dataHora=LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss"));
	private String estabelecimento;
	Random random = new Random();
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long Id;
	private Long nsu = random.nextLong();
//	private Long nsu = 1234567890L;
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long codigoAutorizacao=147258369L;
	
	@Enumerated(EnumType.STRING)
	private Status status;

	public Descricao() {
		
	}

	public Descricao(double valor, String dataHora, String estabelecimento, Long nsu, Long codigoAutorizacao,
			Status status) {
		
		this.valor = valor;
		this.dataHora = dataHora;
		this.estabelecimento = estabelecimento;
		this.nsu = nsu;
		this.codigoAutorizacao = codigoAutorizacao;
		this.status = status;
		
	}
	public double getValor() {
		return valor;
	}


	public void setValor(double valor) {
		this.valor = valor;
	}


	public String getDataHora() {
		return dataHora;
	}


	public void setDataHora(String dataHora) {
		this.dataHora = dataHora;
	}


	public String getEstabelecimento() {
		return estabelecimento;
	}


	public void setEstabelecimento(String estabelecimento) {
		this.estabelecimento = estabelecimento;
	}


	public Long getNsu() {
		return nsu;
	}


	public void setNsu(Long nsu) {
		this.nsu = nsu;
	}


	public Long getCodigoAutorizacao() {
		return codigoAutorizacao;
	}


	public void setCodigoAutorizacao(Long codigoAutorizacao) {
		this.codigoAutorizacao = codigoAutorizacao;
	}


	public Status getStatus() {
		if(getValor()<=0.0) {
			 status=status.CANCELADO;
		}else {
			status=status.AUTORIZADO;
		}
		return status;
		
		
	}


	public void setStatus(Status status) {
		
		this.status = status;
	}
//
//
//	public Transacao orElse(Object object) {
//		// TODO Auto-generated method stub
//		return null;
//	}

//	@Override
//	public String toString() {
//		return "Descricao [valor=" + valor + ", dataHora=" + dataHora + ", estabelecimento=" + estabelecimento + ", Id="
//				+ Id + ", nsu=" + nsu + ", codigoAutorizacao=" + codigoAutorizacao + ", status=" + status + "]";
//	}


	
	
}

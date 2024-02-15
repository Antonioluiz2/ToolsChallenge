package com.timeElite.ToolsChallenge.model;

import java.io.Serializable;

import com.timeElite.ToolsChallenge.enuns.Tipo;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class FormaPagamento implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
    @Enumerated(EnumType.STRING)
    private Tipo tipo;

    //@Length(min = 1)
    private Integer parcelas;

    
	public FormaPagamento() {
	}
	
	public FormaPagamento(Tipo tipo,  Integer parcelas) {
		this.tipo = tipo;
		this.parcelas = parcelas;
	}

	public Tipo getTipo() {
		return tipo;
	}

	public void setTipo(Tipo tipo) {
		this.tipo = tipo;
	}

	public Integer getParcelas() {
		return parcelas;
	}

	public void setParcelas(Integer parcelas) {
		this.parcelas = parcelas;
	}

	@Override
	public String toString() {
		return "FormaPagamento [id=" + id + ", tipo=" + tipo + ", parcelas=" + parcelas + "]";
	}
    
   
    
    

 
}

package com.timeElite.ToolsChallenge.model;

import java.io.Serializable;

import com.timeElite.ToolsChallenge.enuns.Tipo;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.NotNull;

@Entity
public class FormaPagamento implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public  Long id ;
	
   @OneToOne
	private Transacao transacao;
   
   @Enumerated(EnumType.STRING)
	private Tipo tipo;
	
    @NotNull(message = "É obrigatorio informa a parcela da forma de pagamento")
    private Integer parcelas;
	public FormaPagamento() {
		super();
		// TODO Auto-generated constructor stub
	}
	public FormaPagamento(Tipo tipo,
			@NotNull(message = "É obrigatorio informa a parcela da forma de pagamento") Integer parcelas) {
		super();
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

 
}

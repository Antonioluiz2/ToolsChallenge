package com.timeElite.ToolsChallenge.enuns;

public enum Tipo {

	AVISTA("AVISTA"),
	PARCELADOLOJA("PARCELADO LOJA"),
	PARCELADOEMISSOR("PARCELADO EMISSOR");

	Tipo(String string) {
		
	}
	private Tipo(Tipo tipo) {
		this.tipo=tipo;
	}

	public Tipo tipo;

	public Tipo getTipo() {
		return tipo;
	}
	public void setTipo(Tipo tipo) {
		this.tipo = tipo;
	}
}
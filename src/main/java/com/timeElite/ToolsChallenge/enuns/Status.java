package com.timeElite.ToolsChallenge.enuns;


public enum Status {
	
	AUTORIZADO("AUTORIZADO"),
	CANCELADO ("CANCELADO");

	Status(String string) {
		// TODO Auto-generated constructor stub
	}

	
	private Status(Status status) {
		this.status=status;
	}

	public Status status;

	public Status getStatus() {
		return status;
	}
	public void setStatus(Status status) {
		this.status = status;
	}
	
	

}

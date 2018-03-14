package model;

public class Cliente extends Pessoa {

	private int cpf;

	public Cliente(){
		
	}
	
	public Cliente(int cpf) {
		super();
		this.cpf = cpf;
	}

	public int getCpf() {
		return cpf;
	}

	public void setCpf(int cpf) {
		this.cpf = cpf;
	}
	
	
}

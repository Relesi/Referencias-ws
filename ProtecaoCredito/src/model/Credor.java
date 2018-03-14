package model;

public class Credor extends Pessoa {

	private int cnpj;

	public Credor(){
		
	}
	
	public Credor(int cnpj) {
		super();
		this.cnpj = cnpj;
	}

	public int getCnpj() {
		return cnpj;
	}

	public void setCnpj(int cnpj) {
		this.cnpj = cnpj;
	}
	
	
}

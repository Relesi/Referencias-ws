package model;

import java.util.Date;

public class RegistroPendencias extends Pessoa {

	private Cliente cliente;

	private Credor credor;

	private NaturezaDivida naturezaDivida;

	private Date dataInsercao;

	private double valorDivida;


	private String situacao;
	
	public RegistroPendencias(){
		
	}

	public RegistroPendencias(Cliente cliente, Credor credor, NaturezaDivida naturezaDivida, Date dataInsercao,
			double valorDivida, String situacao) {
		super();
		this.cliente = cliente;
		this.credor = credor;
		this.naturezaDivida = naturezaDivida;
		this.dataInsercao = dataInsercao;
		this.valorDivida = valorDivida;
		this.situacao = situacao;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Credor getCredor() {
		return credor;
	}

	public void setCredor(Credor credor) {
		this.credor = credor;
	}

	public NaturezaDivida getNaturezaDivida() {
		return naturezaDivida;
	}

	public void setNaturezaDivida(NaturezaDivida naturezaDivida) {
		this.naturezaDivida = naturezaDivida;
	}

	public Date getDataInsercao() {
		return dataInsercao;
	}

	public void setDataInsercao(Date dataInsercao) {
		this.dataInsercao = dataInsercao;
	}

	public double getValorDivida() {
		return valorDivida;
	}

	public void setValorDivida(double valorDivida) {
		this.valorDivida = valorDivida;
	}


	public String getSituacao() {
		return situacao;
	}

	public void setSituacao(String situacao) {
		this.situacao = situacao;
	}

	
}

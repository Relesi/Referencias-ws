package model;

import java.util.Date;

public class AnaliseNegociacao {

	 private Cliente cliente;
	 private Credor credor;
	 private Date dataInsercao;
	 private FormaPagamento formaPagamento;
	 private FormaEnvioCobranca formaEnvio;
	 private int parcelamento;
	
	 public AnaliseNegociacao(){
		 
	 }
	 
	public AnaliseNegociacao(Cliente cliente, Credor credor, Date dataInsercao, FormaPagamento formaPagamento,
			FormaEnvioCobranca formaEnvio, int parcelamento) {
		super();
		this.cliente = cliente;
		this.credor = credor;
		this.dataInsercao = dataInsercao;
		this.formaPagamento = formaPagamento;
		this.formaEnvio = formaEnvio;
		this.parcelamento = parcelamento;
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
	public Date getDataInsercao() {
		return dataInsercao;
	}
	public void setDataInsercao(Date dataInsercao) {
		this.dataInsercao = dataInsercao;
	}
	public FormaPagamento getFormaPagamento() {
		return formaPagamento;
	}
	public void setFormaPagamento(FormaPagamento formaPagamento) {
		this.formaPagamento = formaPagamento;
	}
	public FormaEnvioCobranca getFormaEnvio() {
		return formaEnvio;
	}
	public void setFormaEnvio(FormaEnvioCobranca formaEnvio) {
		this.formaEnvio = formaEnvio;
	}
	public int getParcelamento() {
		return parcelamento;
	}
	public void setParcelamento(int parcelamento) {
		this.parcelamento = parcelamento;
	}

	 
}

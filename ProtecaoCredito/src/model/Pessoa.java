package model;

import java.util.Date;

public class Pessoa extends TipoPessoa{

	private int cpfCnpj;

	private TipoPessoa tipoPessoa;

	private String nome;

	private int telefone;

	private Date dataNascimento;
	
	public Pessoa(){
		
	}

	public Pessoa(int cpfCnpj, TipoPessoa tipoPessoa, String nome, int telefone, Date dataNascimento) {
		super();
		this.cpfCnpj = cpfCnpj;
		this.tipoPessoa = tipoPessoa;
		this.nome = nome;
		this.telefone = telefone;
		this.dataNascimento = dataNascimento;
	}

	public int getCpfCnpj() {
		return cpfCnpj;
	}

	public void setCpfCnpj(int cpfCnpj) {
		this.cpfCnpj = cpfCnpj;
	}

	public TipoPessoa getTipoPessoa() {
		return tipoPessoa;
	}

	public void setTipoPessoa(TipoPessoa tipoPessoa) {
		this.tipoPessoa = tipoPessoa;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getTelefone() {
		return telefone;
	}

	public void setTelefone(int telefone) {
		this.telefone = telefone;
	}

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	
	
}

package controller;

import java.util.Date;
import java.util.List;

import DAO.AnaliseNegociacaoDAO;
import DAO.RegistroPendenciasDAO;
import model.AnaliseNegociacao;
import model.Cliente;
import model.Credor;
import model.FormaEnvioCobranca;
import model.FormaPagamento;
import model.RegistroPendencias;

public class NegociacaoPendenciasController {
	AnaliseNegociacaoDAO an = new AnaliseNegociacaoDAO();
	RegistroPendenciasDAO rp = new RegistroPendenciasDAO();
	
	
	public List<RegistroPendencias> listarPendencias(){
		return rp.listarRegistros();		
}
	
	public void inserirNegociacao(Cliente cliente, Credor credor, Date dataInsercao, FormaPagamento formaPagamento, FormaEnvioCobranca formaEnvio, int parcelamento ){
		AnaliseNegociacao analiseNegociacao = new AnaliseNegociacao (cliente,credor, dataInsercao, formaPagamento, formaEnvio,parcelamento );
		an.inserir(analiseNegociacao);		
	}
	
}

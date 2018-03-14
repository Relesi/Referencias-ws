package controller;

import java.util.Date;

import DAO.RegistroPendenciasDAO;
import model.Cliente;
import model.Credor;
import model.NaturezaDivida;
import model.RegistroPendencias;
import webservice.ClienteService;

public class CadastroPendenciasController {
	
	RegistroPendenciasDAO rp = new RegistroPendenciasDAO();
	ClienteService cs = new ClienteService();
	
	public void inserirPendencia(Cliente cliente, Credor credor, NaturezaDivida natDivida, Date dataInsercao, double valor, String situacao ){
		RegistroPendencias registroPendencias = new RegistroPendencias (cliente,credor, natDivida, dataInsercao, valor,situacao );
			rp.adicionar(registroPendencias);		
	}
	
	public void alterarPendencia(Cliente cliente, Credor credor, NaturezaDivida natDivida, Date dataInsercao, double valor, String situacao ){
		RegistroPendencias registroPendencias = new RegistroPendencias (cliente,credor, natDivida, dataInsercao, valor,situacao );
			rp.alterar(registroPendencias);		
	}
	
	public Cliente localizarCliente(int cpfCnpj){
		Cliente c = new Cliente();
		cs.localizar(cpfCnpj);	
		
		return c;
	}
	
	public Credor localizarCredor(int cpfCnpj){
		Credor c = new Credor();
		cs.localizar(cpfCnpj);	
		
		return c;
	}
}

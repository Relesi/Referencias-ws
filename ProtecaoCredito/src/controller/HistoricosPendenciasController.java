package controller;

import java.util.Date;
import java.util.List;

import DAO.RegistroPendenciasDAO;
import model.Cliente;
import model.Credor;
import model.NaturezaDivida;
import model.RegistroPendencias;

public class HistoricosPendenciasController {

	RegistroPendenciasDAO rp = new RegistroPendenciasDAO();
	
	public List<RegistroPendencias> listarPendencias(){
			return rp.listarRegistros();		
	}
	
	public void alterarPendencia(Cliente cliente, Credor credor, NaturezaDivida natDivida, Date dataInsercao, double valor, String situacao ){
		RegistroPendencias registroPendencias = new RegistroPendencias (cliente,credor, natDivida, dataInsercao, valor,situacao );
			rp.alterar(registroPendencias);		
	}
}

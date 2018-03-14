package DAO;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import DAO.Connect.Factory;
import model.AnaliseNegociacao;
import model.Credor;
import model.FormaEnvioCobranca;
import model.FormaPagamento;
import model.RegistroPendencias;



public class AnaliseNegociacaoDAO{
	Connection conn = Factory.conectar();
	PreparedStatement stmt;
	
	RegistroPendencias reg = new RegistroPendencias();
	Credor cred = new Credor();
	FormaPagamento fp = new FormaPagamento();
	FormaEnvioCobranca fc = new FormaEnvioCobranca();

	public boolean inserir(AnaliseNegociacao AnaliseNegociacao) {
		
		
		String sql = "insert into AnaliseNegociacao (cliente, credor, dataInsercao, naturezaDivida, valorDivida, observacoes, situacao) values (?,?,?,?,?,?)";
		try {
		
			 stmt = conn.prepareStatement(sql);
					
			
			stmt.setInt(1, reg.getCpfCnpj());
			stmt.setInt(2, cred.getCnpj());
			stmt.setDate(3, (Date) reg.getDataInsercao());
			stmt.setInt(4, fp.getCodigo());
			stmt.setDouble(5, fc.getCodigo());
			stmt.setInt(6, AnaliseNegociacao.getParcelamento());

		
			stmt.execute();
			stmt.close();
			return true;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally{
		
		Factory.desconectar();	
		}
		return false;
	}

	
	public List<AnaliseNegociacao> listarAnalises() {

		
		List<AnaliseNegociacao> listaAnaliseNegociacao = new ArrayList<AnaliseNegociacao>();
		
		try {
			stmt = conn.prepareStatement("select * from AnaliseNegociacao");
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				AnaliseNegociacao AnaliseNegociacao = new AnaliseNegociacao();
				reg.setCpfCnpj(rs.getInt("cpfCnpj"));
				cred.setCnpj(rs.getInt("cnpj"));
				AnaliseNegociacao.setDataInsercao(rs.getDate("dataInsercao"));
				fp.setCodigo(rs.getInt("codigo"));
				fc.setCodigo(rs.getInt("codigo"));
				AnaliseNegociacao.setParcelamento(rs.getInt("parcelamento"));
				
			
				listaAnaliseNegociacao.add(AnaliseNegociacao);

			}
			
			rs.close();
			stmt.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		finally{
			Factory.desconectar();
		}
		return listaAnaliseNegociacao;
	}
	

	public AnaliseNegociacao localizar(String cpfCnpj) {
		AnaliseNegociacao c  = new AnaliseNegociacao();
		
	    try {
			stmt = conn.prepareStatement("SELECT * FROM AnaliseNegociacao WHERE cliente = ?");
			stmt.setString(1, cpfCnpj);
			
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				
				reg.setCpfCnpj(rs.getInt("cpfCnpj"));
				cred.setCnpj(rs.getInt("cnpj"));
				c.setDataInsercao(rs.getDate("dataInsercao"));
				fp.setCodigo(rs.getInt("codigo"));
				fc.setCodigo(rs.getInt("codigo"));
				c.setParcelamento(rs.getInt("parcelamento"));
			}
			
	    } catch (SQLException e) {
			// TODO Auto-generated catch block
	    	c = null;
			e.printStackTrace();
		}
   		
		
		return c;
	}

	public boolean alterar(AnaliseNegociacao AnaliseNegociacao) {
		Factory.conectar();
		try {
			stmt = conn.prepareStatement("update RegistroPendencias set cliente=?, credor=?, dataInsercao=?, naturezaDivida=?, valorDivida=?, observacoes=?, situacao=? where cliente=?");
			
			stmt.setInt(1, reg.getCpfCnpj());
			stmt.setInt(2, cred.getCnpj());
			stmt.setDate(3, (Date) reg.getDataInsercao());
			stmt.setInt(4, fp.getCodigo());
			stmt.setDouble(5, fc.getCodigo());
			stmt.setInt(6, AnaliseNegociacao.getParcelamento());

			stmt.execute();
			stmt.close();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
			
		}
		finally{
			Factory.desconectar();
		}
		
	}
	

	
}

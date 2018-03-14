package DAO;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import DAO.Connect.Factory;
import model.Cliente;
import model.Credor;
import model.NaturezaDivida;
import model.RegistroPendencias;



public class RegistroPendenciasDAO{
	Connection conn = Factory.conectar();
	PreparedStatement stmt;
	
	Cliente cliente;
	Credor credor;
	NaturezaDivida natDivida;

	public boolean adicionar(RegistroPendencias RegistroPendencias) {
		
		String sql = "insert into registroPendencias (cliente, credor, dataInsercao, naturezaDivida, valorDivida, observacoes, situacao) values (?,?,?,?,?,?,?)";
		try {
		
			 stmt = conn.prepareStatement(sql);
					
			
			stmt.setInt(1, cliente.getCpfCnpj());
			stmt.setInt(2, credor.getCnpj());
			stmt.setDate(3, (Date) RegistroPendencias.getDataInsercao());
			stmt.setInt(4, natDivida.getCodigo());
			stmt.setDouble(5, RegistroPendencias.getValorDivida());
			stmt.setString(6, RegistroPendencias.getSituacao());
		
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

	
	public List<RegistroPendencias> listarRegistros() {

		
		List<RegistroPendencias> listaRegistroPendencias = new ArrayList<RegistroPendencias>();
		
		try {
			stmt = conn.prepareStatement("select * from registroPendencias");
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				RegistroPendencias RegistroPendencias = new RegistroPendencias();
				cliente.setCpfCnpj(rs.getInt("cpfCnpj"));
				credor.setCnpj(rs.getInt("cnpj"));
				RegistroPendencias.setDataInsercao(rs.getDate("dataInsercao"));
				RegistroPendencias.setValorDivida(rs.getDouble("valorDivida"));
				RegistroPendencias.setSituacao(rs.getString("data"));
				
			
				listaRegistroPendencias.add(RegistroPendencias);

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
		return listaRegistroPendencias;
	}
	

	public RegistroPendencias localizar(String cpfCnpj) {
		RegistroPendencias c  = new RegistroPendencias();
		
	    try {
			stmt = conn.prepareStatement("SELECT * FROM RegistroPendencias WHERE cpfCnpj = ?");
			stmt.setString(1, cpfCnpj);
			
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				
				cliente.setCpfCnpj(rs.getInt("cpfCnpj"));
				credor.setCnpj(rs.getInt("cnpj"));
				c.setDataInsercao(rs.getDate("dataInsercao"));
				natDivida.setCodigo(rs.getInt("naturezaDivida"));
				c.setValorDivida(rs.getDouble("valorDivida"));
				c.setSituacao(rs.getString("situacao"));
			}
			
	    } catch (SQLException e) {
			// TODO Auto-generated catch block
	    	c = null;
			e.printStackTrace();
		}
   		
		
		return c;
	}


	public double procuraValorTotalDivida(int cpfCnpj) {
		// TODO Auto-generated method stub
			double valor = 0;
		
		    try {
				stmt = conn.prepareStatement("select sum(valorDivida) from RegistroPendencias where cpfCnpj=?;");
				stmt.setInt(1, cpfCnpj);
				
				ResultSet rs = stmt.executeQuery();

				while (rs.next()) {
					
					valor = rs.getDouble("sum(valorDivida)");			
					
				}
				return valor;
				
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					valor = 0;
					e.printStackTrace();
				}
			return valor;
		
	}
	
	public boolean alterar(RegistroPendencias RegistroPendencias) {
		Factory.conectar();
		try {
			stmt = conn.prepareStatement("update RegistroPendencias set cliente=?, credor=?, dataInsercao=?, naturezaDivida=?, valorDivida=?, observacoes=?, situacao=? where cpfCnpj=?");
			
			stmt.setInt(1, cliente.getCpfCnpj());
			stmt.setInt(2, credor.getCnpj());
			stmt.setDate(3, (Date) RegistroPendencias.getDataInsercao());
			stmt.setInt(4, natDivida.getCodigo());
			stmt.setDouble(5, RegistroPendencias.getValorDivida());
			stmt.setString(6, RegistroPendencias.getSituacao());

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

package webservice;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import DAO.Connect.Factory;
import model.Cliente;



public class ClienteService{
	Connection conn = Factory.conectar();
	PreparedStatement stmt;


	public Cliente localizar(int cpfCnpj) {
		Cliente f  = new Cliente();
		
	    try {
			stmt = conn.prepareStatement("SELECT * FROM Cliente WHERE cpfCnpj= ?");
			
			stmt.setInt(1, cpfCnpj);
			
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				f.setNome(rs.getString("nome"));
				f.setCodigo(rs.getInt("codigo"));				
				f.setCpfCnpj(rs.getInt("cpfCnpj"));
				f.setTelefone(rs.getInt("telefone"));
				f.setDataNascimento(rs.getDate("dataNascimento"));
				
			}
			return f;
			
	    } catch (SQLException e) {
			// TODO Auto-generated catch block
	    	f = null;
			e.printStackTrace();
		}
   		
		
		return f;
	}
	
	
}

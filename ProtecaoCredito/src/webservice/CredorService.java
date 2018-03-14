package webservice;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import DAO.Connect.Factory;
import model.Credor;



public class CredorService{
	Connection conn = Factory.conectar();
	PreparedStatement stmt;	

	public List<Credor> listarCredors() {

		
		List<Credor> listaCredores = new ArrayList<Credor>();
		
		try {
			stmt = conn.prepareStatement("select * from Credor");
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				Credor Credor = new Credor();
				Credor.setCnpj(rs.getInt("cnpj"));
				Credor.setCodigo(rs.getInt("codigo"));
				Credor.setNome(rs.getString("nome"));	
				Credor.setTelefone(rs.getInt("telefone"));	
			
				listaCredores.add(Credor);

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
		return listaCredores;
	}


}

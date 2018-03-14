package DAO.Connect;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Factory {
	
	private static Connection conn = null;

	public static Connection conectar() {

		try {
			//conn = DriverManager.getConnection("jdbc:mysql://localhost:3333/test?" + "user=root&password=senha");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/protecaoCredito","root", "root");			
			
		} catch (SQLException   e) {
			e.printStackTrace();
		}
		return conn;
	}

	public static  void desconectar() {
		try {
			if (conn!= null){
				conn.close();
				
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
//		Factory.conectar();
//		Factory.desconectar();
	}
}

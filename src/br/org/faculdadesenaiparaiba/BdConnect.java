package br.org.faculdadesenaiparaiba;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class BdConnect {
	
	private static BdConnect bdconecta;
	
	public static BdConnect getInstance() {
	if(bdconecta == null) {
		bdconecta = new BdConnect();
	}
		return bdconecta;
		
	}
	
	public Connection getConnection() throws ClassNotFoundException, SQLException{
		Class.forName("com.mysql.jdbc.Driver");
		String url = "jdbc:mysql://localhost:3306/agenda";
		String user = "root";
		String pass = "";
		return DriverManager.getConnection(url,user,pass);
	}
	
	public static void main(String[] args) {
		try {
			//System.out.println(getInstance().getConnection());
			System.out.println(getInstance().getConnection());
			System.out.println();
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}

}

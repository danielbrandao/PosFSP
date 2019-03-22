package br.org.faculdadesenaiparaiba;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactorySimple {
	
	public Connection getConnection() throws SQLException{
		try {
			Class.forName("org.mysql.Driver");
			String url = "jdbc:mysql://localhost:3306/agenda";
			String user = "root";
			String pass = "";
			return DriverManager.getConnection(url,user,pass);
		}catch(ClassNotFoundException ex){
			throw new SQLException(ex);
		}
	}

}

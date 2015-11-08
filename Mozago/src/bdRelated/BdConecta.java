package bdRelated;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class BdConecta 
{
	public static Connection getConnection() throws SQLException{
		try {
			 Class.forName("com.mysql.jdbc.Driver");
			 System.out.println("Conectado");
			 return DriverManager.getConnection("jdbc:mysql://localhost/ mozago_db"+ ""
			 		+ "user=root&password=root");
		} catch (Exception e) {
			throw new SQLException(e.getMessage());
		}
		
	}
}

package mozago.bdRelated;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class BdConecta 
{
	private static Connection con;
	public static Connection getConnection() throws SQLException{
		try {
			 Class.forName("com.mysql.jdbc.Driver");
			 System.out.println("Conectado");
			 return DriverManager.getConnection("jdbc:mysql://localhost/mozago_db","haider","haider");
		} catch (Exception e) {
			throw new SQLException(e.getMessage());
		}
		
	}
	
	public static void main(String[] arg) throws SQLException{
		con=(Connection) BdConecta.getConnection();
	}
}

package bdRelated;

import java.sql.ResultSet;
import java.sql.SQLException;

import mozago.bdRelated.BdConecta;


import mozago.model.User;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

public class UserDAO {
private Connection con;
	
	public UserDAO() throws SQLException{
		this.con=(Connection) BdConecta.getConnection();
	}
	
	public void adicionarUser(User user) throws SQLException{
		java.sql.PreparedStatement stmt=this.con.prepareStatement("insert into user (username,nome,apelido,categoria,email,telefone,password) values(?,?,?,?,?,?,?)");
		
		
		stmt.setString(1, user.getUsername());
		stmt.setString(2, user.getNome());
		stmt.setString(3, user.getApelido());
		stmt.setString(4, user.getCategoria());
		stmt.setString(5, user.getEmail());
		stmt.setString(6, user.getTelefone());
		stmt.setString(7, user.getPassword());
		
		stmt.execute();
		stmt.close();
	
	}
	
	public void VerificarUser(User user) throws SQLException{
		Statement selectStmt=(Statement) this.con.createStatement();
		
		 ResultSet rs = ((java.sql.Statement) selectStmt).executeQuery("select provincias.provincia,distritos.distritos,mesavoto.localidade,"
					+ "mesavoto.votos from provincias inner join mesavoto on provincias.id=mesavoto.p_id inner join distritos on distritos.id=mesavoto.d_id;");
         while(rs.next())
         {
             System.out.print(rs.getString(1)+" ");    
             System.out.print(rs.getString(2)+" ");    
             System.out.print(rs.getString(3)+" ");    
             System.out.println(rs.getString(4));    
         }
		try {
			selectStmt.close();
			con.close();
		} catch (Exception e) {
			e.getMessage();
		}
		
	
	}
	
	public void lerPronvincias() throws SQLException{
		
		Statement selectStmt=(Statement) this.con.createStatement();
		
		 ResultSet rs = ((java.sql.Statement) selectStmt).executeQuery("select id,provincia from provincias;");
         while(rs.next())
         {
             System.out.print(rs.getString(1)+" ");    
             System.out.println(rs.getString(2));    
                 
         }
		try {
			selectStmt.close();
			
		} catch (Exception e) {
			e.getMessage();
		}
		
	
	}
	
	public void lerDistritos() throws SQLException{
		Statement selectStmt=(Statement) this.con.createStatement();
		
		 ResultSet rs = ((java.sql.Statement) selectStmt).executeQuery("select id,distritos from distritos;");
         while(rs.next())
         {
             System.out.print(rs.getString(1)+" ");    
             System.out.println(rs.getString(2));    
                 
         }
		try {
			selectStmt.close();
			
		} catch (Exception e) {
			e.getMessage();
		}
		
	
	}

}

package mozago.bdRelated;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import mozago.bdRelated.BdConecta;


import mozago.model.User;

import com.mysql.jdbc.Connection;

public class UserDAO {
	private static Connection con;
				
	public UserDAO() throws SQLException{
		this.con=(Connection) BdConecta.getConnection();
	}
	//idusuario????
	public void adicionarUser(User user) throws SQLException{
		java.sql.PreparedStatement stmt=this.con.prepareStatement("insert into usuario (idusuario,nome,apelido,userrname"
				+ ",password,email,telefone,categoria) values(?,?,?,?,?,?,?,?)");
		
		
		stmt.setInt(1,UserDAO.generateId());
		stmt.setString(2, user.getNome());
		stmt.setString(3, user.getApelido());
		stmt.setString(4, user.getUsername());
		stmt.setString(5, user.getPassword());
		stmt.setString(6, user.getEmail());
		stmt.setLong(7, user.getTelefone());
		stmt.setInt(8, user.getCategoria());
		
		stmt.execute();
		stmt.close();
		
		
	}
	
	
	
	/**
	 * @param username
	 * @param password
	 * @return
	 * @throws SQLException
	 */
	public static User VerificarUser(String username, String password) throws SQLException{
		try{
			con = (Connection) BdConecta.getConnection();
				}
				catch (SQLException e){
					System.out.println(e.getMessage());
				}
		java.sql.PreparedStatement stmt1 = null;
		
			stmt1 = con.prepareStatement("select * from usuario where username=? "
					+ "and password=?");
			
			stmt1.setString(1, username);
			stmt1.setString(2, password );
		
			ResultSet rs = stmt1.executeQuery();
			
			User user=null;
		
		while (rs.next()) {
			String nome = rs.getString("nome");
			String apelido = rs.getString("apelido");
			String email = rs.getString("email");
			String password2 = rs.getString("password");
			String username2 = rs.getString("username");
			int categoria = rs.getInt("categoria");
			long telefone = rs.getLong("telefone");
			int id = rs.getInt("idusuario");
			user=new User(id,nome,apelido,email,password2,username,categoria,telefone);
//			System.out.println(nome +"\n"+apelido +"\n"+email +"\n"+password2 +"\n"+username2 +"\n"+categoria +"\n"+telefone);
			
			
			
		}
		return user;
	
	}
	
	public static int generateId(){
		
				String last_id_user;
				java.sql.PreparedStatement stmt1 = null;
				try {
					stmt1 = UserDAO.con.prepareStatement("select max(idusuario) from usuario;");
				
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				ResultSet rs = null;
				try {
					rs = stmt1.executeQuery();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				last_id_user=rs.toString();
				
				if(last_id_user=="NULL"){
					return Integer.parseInt(1+"");
				}
				
				
				else{
					return (Integer.parseInt(last_id_user)+1);
				}
	}

}

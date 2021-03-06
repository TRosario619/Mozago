package mozago.bdRelated;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

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
	public static void adicionarUser(User user) throws SQLException{
		java.sql.PreparedStatement stmt=con.prepareStatement("insert into usuario (idusuario,nome,apelido,username"
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
	
	public static User VerificarUser(String username) throws SQLException{
		try{
			con = (Connection) BdConecta.getConnection();
				}
				catch (SQLException e){
					System.out.println(e.getMessage());
				}
		java.sql.PreparedStatement stmt1 = null;
		
			stmt1 = con.prepareStatement("select * from usuario where username=? ");
			
			stmt1.setString(1, username);
			
		
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
	
public static Vector<User> retornaUsuarios() throws SQLException{
		
		Vector<User> users=new Vector<User>();
		
		try{
			con = (Connection) BdConecta.getConnection();
				}
				catch (SQLException e){
					System.out.println(e.getMessage());
				}
		java.sql.PreparedStatement stmt1 = null;
		
			stmt1 = con.prepareStatement("select * from usuario;");
			
		
		
			ResultSet rs = stmt1.executeQuery();
			
			User user=null;
		
		while (rs.next()) {
			String nome = rs.getString("nome");
			String apelido = rs.getString("apelido");
			String email = rs.getString("email");
			String password = rs.getString("password");
			String username = rs.getString("username");
			int categoria = rs.getInt("categoria");
			long telefone = rs.getLong("telefone");
			int id = rs.getInt("idusuario");
			user=new User(id,nome,apelido,email,password,username,categoria,telefone);
//			System.out.println(nome +"\n"+apelido +"\n"+email +"\n"+password +"\n"+username +"\n"+categoria +"\n"+telefone);
			users.addElement(user);
			
			
		}
		
		
		return users;
		
	}
public static Vector<User> retornaUsuariosCatgoria(int cat) throws SQLException{
		
		Vector<User> users=new Vector<User>();
		
		try{
			con = (Connection) BdConecta.getConnection();
				}
				catch (SQLException e){
					System.out.println(e.getMessage());
				}
		java.sql.PreparedStatement stmt1 = null;
		
			stmt1 = con.prepareStatement("select * from usuario where categoria=? ");
			
			stmt1.setInt(1, cat);
		
		
			ResultSet rs = stmt1.executeQuery();
			
			User user=null;
		
		while (rs.next()) {
			String nome = rs.getString("nome");
			String apelido = rs.getString("apelido");
			String email = rs.getString("email");
			String password = rs.getString("password");
			String username = rs.getString("username");
			int categoria = rs.getInt("categoria");
			long telefone = rs.getLong("telefone");
			int id = rs.getInt("idusuario");
			user=new User(id,nome,apelido,email,password,username,categoria,telefone);
//			System.out.println(nome +"\n"+apelido +"\n"+email +"\n"+password +"\n"+username +"\n"+categoria +"\n"+telefone);
			users.addElement(user);
			
			
		}
		
		
		return users;
		
	}
	
	public static int generateId(){
	
			//Calcula proximo IdDespesa
			int last_id_user = 0;
			java.sql.PreparedStatement stmt1 = null;
			try {
				stmt1 = UserDAO.con.prepareStatement("select max(idusuario) from usuario;");
			
			} 
			catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			ResultSet rs = null;
			try {
				rs = stmt1.executeQuery();
				while (rs.next()){
				last_id_user=Integer.parseInt(rs.getString("max(idusuario)"));}
				
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			if(last_id_user==0){
				return 0 ;
			}
			
			
			else{
				return (last_id_user)+1;
			}
	}

}

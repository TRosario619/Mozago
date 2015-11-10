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
		
		
		stmt.setInt(1, user.getIdUser());
		stmt.setString(2, user.getNome());
		stmt.setString(3, user.getApelido());
		stmt.setString(4, user.getUsername());
		stmt.setString(5, user.getPassword());
		stmt.setString(6, user.getEmail());
		stmt.setLong(7, user.getTelefone());
		stmt.setInt(8, user.getCategoria());
		
		stmt.execute();
		stmt.close();
		
		/*DROP TABLE IF EXISTS `usuario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
/*CREATE TABLE `usuario` (
  `idusuario` int(11) NOT NULL,
  `nome` varchar(45) DEFAULT NULL,
  `apelido` varchar(45) CHARACTER SET big5 DEFAULT NULL,
  `userrname` varchar(45) DEFAULT NULL,
  `password` varchar(45) DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  `telefone` varchar(45) DEFAULT NULL,
  `categoria` int(11) DEFAULT NULL,
  PRIMARY KEY (`idusuario`),
  UNIQUE KEY `userrname_UNIQUE` (`userrname`),
  KEY `fk_categoria_idx` (`categoria`),
  CONSTRAINT `fk_categoria` FOREIGN KEY (`categoria`) REFERENCES `categoria` (`idcategoria`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
*!40101 SET character_set_client = @saved_cs_client */
	
	}
	
	
	
	public static User VerificarUser(String username, String Password) throws SQLException{
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
			stmt1.setString(2, Password );
		
			
			User user=null;
		ResultSet rs = stmt1.executeQuery();
		while (rs.next()) {
			String nome = rs.getString("nome");
			String apelido = rs.getString("apelido");
			String email = rs.getString("email");
			String password = rs.getString("password");
			String username2 = rs.getString("username");
			int categoria = rs.getInt("categoria");
			long telefone = rs.getLong("telefone");
			int id = rs.getInt("idusuario");
			user=new User(id,nome,apelido,email,password,username,categoria,telefone);
			System.out.println(nome +"\n"+apelido +"\n"+email +"\n"+password +"\n"+username2 +"\n"+categoria +"\n"+telefone);
			
			
			
		}
		return user;
	/*			
		if(rs.wasNull()){//toString().equalsIgnoreCase("")){
//			JOptionPane.showMessageDialog(null, "User/Password incorrect");
			return null;
		}
		
		else{
//			java.sql.PreparedStatement stmt=UserDAO.con.prepareStatement("select * from usuario where username=?;");
//			ResultSet rs1 = stmt.executeQuery();
//			
////			System.out.println(rs.getString("nome").toString() +" "+ rs.getString("apelido").toString());
			return new User(rs.getInt("idusuario"), rs.getString("nome"),rs.getString("apelido"), rs.getString("email"), 
					rs.getString("password"), rs.getString("username"), rs.getInt("categoria"), rs.getLong("telefone"));
			
		}
		*/
	
	}
	
	public static String generateId(){
		
		//Calcula proximo IdDespesa
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
					return 1+"";
				}
				
				
				else{
					return (""+Integer.parseInt(last_id_user)+1);
				}
	}

}

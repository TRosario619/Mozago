package mozago.bdRelated;

import java.sql.ResultSet;
import java.sql.SQLException;

import mozago.bdRelated.BdConecta;


import mozago.model.User;

import com.mysql.jdbc.*;

public class UserDAO {
private Connection con;
	
	public UserDAO() throws SQLException{
		this.con=(Connection) BdConecta.getConnection();
	}
	
	public void adicionarUser(User user) throws SQLException{
		java.sql.PreparedStatement stmt=this.con.prepareStatement("insert into usuario (idusuario,nome,apelido,userrname"
				+ ",password,email,telefone,categoria) values(?,?,?,?,?,?,?,?)");
		
		
		stmt.setString(1, user.getIdUser());
		stmt.setString(2, user.getNome());
		stmt.setString(3, user.getApelido());
		stmt.setString(4, user.getUsername());
		stmt.setString(5, user.getPassword());
		stmt.setString(6, user.getEmail());
		stmt.setLong(7, user.getTelefone());
		stmt.setString(8, user.getCategoria());
		
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
	
	
}

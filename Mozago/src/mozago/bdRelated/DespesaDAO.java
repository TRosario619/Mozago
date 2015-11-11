package mozago.bdRelated;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.Vector;

import mozago.model.*;

import com.mysql.jdbc.Connection;

public class DespesaDAO {
	
	private static Connection con;
	
	public DespesaDAO() throws SQLException{
		
	this.con=(Connection) BdConecta.getConnection();
	}
	
	
public static void inserir(Obra obra, User admin, User gestor, User director) throws SQLException{
		
		try{
			con = (Connection) BdConecta.getConnection();
				}
				catch (SQLException e){
					System.out.println(e.getMessage());
				}
		
		
		//Criar Obra
		java.sql.PreparedStatement stmt=DespesaDAO.con.prepareStatement("insert into despesa (id_despesa, material_id,"
				+ "quantia, preco_total, data_pedido_despesa, aprovado,data_despesa_aprovada)"
				+ " values(?,?,?,?,?,?)");
		
		stmt.setInt(1, DespesaDAO.generateId());
		stmt.setInt(2, admin.getIdUser());
		stmt.setInt(3, director.getIdUser());
		stmt.setInt(4, gestor.getIdUser());
		stmt.setInt(5, obra.getId_obra());
		
		java.sql.Date date = new java.sql.Date(Calendar.getInstance().getTime().getTime());
		stmt.setDate(6, (java.sql.Date) date);
		
		
				
		stmt.execute();
		try {
			stmt.close();
			con.close();
		} catch (Exception e) {
			e.getMessage();
		}
		
		/*CREATE TABLE `despesa` (
 1 `id_despesa` int(11) NOT NULL,
 2`material_id` int(11) DEFAULT NULL,
 3 `quantia` int(11) DEFAULT NULL,
 4 `preco_total` bigint(20) DEFAULT NULL,
 5 `data_pedido_despesa` date DEFAULT NULL,
 6 `aprovado` bit(1) DEFAULT NULL,
 7 `data_despesa_aprovada` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id_despesa`),
  KEY `fk_material_idx` (`material_id`),
  CONSTRAINT `fk_material` FOREIGN KEY (`material_id`) REFERENCES `material` (`idmaterial`)*/
		
	}

public static int generateId() throws SQLException{
	
	//Calcula proximo IdDespesa
	try{
		con = (Connection) BdConecta.getConnection();
			}
			catch (SQLException e){
				System.out.println(e.getMessage());
			}
			int last_id_despesa = 0;
			java.sql.PreparedStatement stmt121 = null;
			
			

		
			
			
			ResultSet rs = stmt121.executeQuery();
				
			
			while(rs.next()){
				String string = rs.getString("max(id_despesa)");
				if(string==null){
					return 1;
				}
				last_id_despesa=Integer.parseInt(rs.getString("max(id_despesa)"));
					
								}
							
			System.out.println("Last id Despesa: "+last_id_despesa);
			if(last_id_despesa==0){
				return 1;
			}
			else{
				return (last_id_despesa+1);
			}
	
}

}


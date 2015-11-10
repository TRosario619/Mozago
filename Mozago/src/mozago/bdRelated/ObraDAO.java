package mozago.bdRelated;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;







import mozago.model.*;

import com.mysql.jdbc.Connection;

public class ObraDAO {

	private static Connection con;
		
	@SuppressWarnings("static-access")
	public ObraDAO() throws SQLException{
		
	this.con=(Connection) BdConecta.getConnection();
		
	}
	
	public static void inserir(Obra obra) throws SQLException{
		
		try{
			con = (Connection) BdConecta.getConnection();
				}
				catch (SQLException e){
					System.out.println(e.getMessage());
				}
		
		
		//Criar Obra
		java.sql.PreparedStatement stmt=ObraDAO.con.prepareStatement("insert into obra (idObra, descricao_obra,"
				+ "dono_obra, contacto_dono_obra, tipo_obra, data_inicio, data_fim, data_prazo, Valor_projectado)"
				+ " values(?,?,?,?,?,?,?,?,?)");
		
		stmt.setInt(1, obra.getId_obra());
		stmt.setString(2, obra.getDecricao());
		stmt.setString(3, obra.getDono_obra());
		stmt.setString(4, obra.getContacto_dono_obra());
		stmt.setInt(5,obra.getTipo_obra());
		stmt.setDate(6, (Date) obra.getData_inicio());
		stmt.setDate(7, (Date) obra.getData_fim());
		stmt.setDate(8, (Date) obra.getData_prazo());
		stmt.setDouble(9, obra.getValorProjectado());
		
		stmt.execute();
		System.out.println("obra adicionada");
		try {
			stmt.close();
			con.close();
		} catch (Exception e) {
			e.getMessage();
		}
		
		
	}
	
		
public static int generateId() throws SQLException{
		
		//Calcula proximo IdObra
		try{
			con = (Connection) BdConecta.getConnection();
				}
				catch (SQLException e){
					System.out.println(e.getMessage());
				}
				int last_id_obra = 0;
				java.sql.PreparedStatement stmt121;
				
				
				stmt121 = ObraDAO.con.prepareStatement("select max(idObra) from obra;");
			
				
				
				ResultSet rs = stmt121.executeQuery();
					
				
				while(rs.next()){
					String string = rs.getString("max(idObra)");
					if(string==null){
						return 1;
					}
					last_id_obra=Integer.parseInt(rs.getString("max(idObra)"));
						
									}
								
				System.out.println("Last id Obra: "+last_id_obra);
				if(last_id_obra==0){
					return 1;
				}
				else{
					return (last_id_obra+1);
				}
		
		
					
					}
	

}

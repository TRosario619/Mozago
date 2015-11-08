package mozago.bdRelated;

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
		
		
		
		
		//Criar Obra
		java.sql.PreparedStatement stmt=ObraDAO.con.prepareStatement("insert into obra (idObra, descricao_obra,"
				+ "dono_obra, contacto_dono_obra, tipo_obra, data_inicio, data_fim, data_prazo, Valor_projectado)"
				+ " values(?,?,?,?,?,?,?,?,?,?,?)");
		
		stmt.setString(1, obra.getId_obra());
		stmt.setString(2, obra.getDecricao());
		stmt.setString(3, obra.getDono_obra());
		stmt.setString(4, obra.getContacto_dono_obra());
		stmt.setString(5,obra.getTipo_obra());
		stmt.setString(6, obra.getData_inicio());
		stmt.setString(7, obra.getData_fim());
		stmt.setString(8, obra.getData_prazo());
		stmt.setDouble(9, obra.getValorProjectado());
		
		stmt.execute();
		try {
			stmt.close();
			con.close();
		} catch (Exception e) {
			e.getMessage();
		}
		
		
	}
	
	/*
	public Vector buscaPropEst(String cod_est) throws SQLException{
		java.sql.PreparedStatement stmt=this.con.prepareStatement("select * from propina where cod_est=?;");
		stmt.setString(1, cod_est);
ResultSet rs=stmt.executeQuery();
		
		Propina prop=null;
		Vector props=new Vector();
		while(rs.next()){
			prop=new Propina();
			prop.setProp_ref(rs.getString("prop_ref"));
			prop.setProp_quantia_pagar(rs.getString("prop_quantia_pagar"));
			prop.setProp_nr_prestacao(rs.getString("prop_nr_prestacao"));
			prop.setProp_data_limite(rs.getDate("prop_data_limite"));
			prop.setNum_ct(rs.getString("num_ct"));
			prop.setCod_est(rs.getString("cod_est"));
			prop.setProp_quantia_recebida(rs.getString("prop_quantia_recebida"));
			prop.setProp_meio_pagamento(rs.getString("prop_meio_pagamento"));
			prop.setProp_data_pagamento(rs.getDate("prop_data_pagamento"));
			prop.setCod_func(rs.getString("cod_func"));
			prop.setProp_estado(rs.getString("prop_estado"));
			props.add(prop);
			
		}
		
		try {
			stmt.close();
			con.close();
		} catch (Exception e) {
			e.getMessage();
		}
		return props;
	}
	
	
	*/
	
	
	public static String generateId(){
		
		//Calcula proximo IdObra
				String last_id_obra;
				java.sql.PreparedStatement stmt1 = null;
				try {
					stmt1 = ObraDAO.con.prepareStatement("select max(idObra from obra;");
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
				last_id_obra=rs.toString();
				
		
		return (""+Integer.parseInt(last_id_obra)+1);
		
	}
	

}

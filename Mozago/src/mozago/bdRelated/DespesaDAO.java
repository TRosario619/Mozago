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
	
	
public static void inserir(Despesa despesa,Material material) throws SQLException{
		
		//criar material
		
	java.sql.PreparedStatement stmt1=DespesaDAO.con.prepareStatement("insert into material (id_material, material_id,"
			+ "quantia, preco_total, data_despesa)"
			+ " values(?,?,?)");
	
	stmt1.setString(1, despesa.getId());
	stmt1.setString(2, material.getiD());
	stmt1.setString(3, despesa.getQuantia());


	
	stmt1.execute();
	try {
		stmt1.close();
		con.close();
	} catch (Exception e) {
		e.getMessage();
	}
		
		//Criar despesa
		java.sql.PreparedStatement stmt=DespesaDAO.con.prepareStatement("insert into despesa (id_despesa, material_id,"
				+ "quantia, preco_total, data_despesa)"
				+ " values(?,?,?,?,?)");
		
		stmt.setString(1, despesa.getId());
		stmt.setString(2, material.getiD());
		stmt.setString(3, despesa.getQuantia());
		stmt.setString(4, despesa.getPreco_total());
		stmt.setString(5,despesa.getData());
	
		
		stmt.execute();
		try {
			stmt.close();
			con.close();
		} catch (Exception e) {
			e.getMessage();
		}
		
		
	}

}

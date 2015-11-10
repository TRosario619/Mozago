package mozago.bdRelated;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.Vector;

import javax.swing.JOptionPane;

import mozago.model.Investimento;
import mozago.model.Obra;

import com.mysql.jdbc.Connection;

public class InvestimentoDAO {
	
	private static Connection con;
	
	public InvestimentoDAO() throws SQLException{
		
	this.con=(Connection) BdConecta.getConnection();
	}
	
	
public static void inserir(Investimento investimento, Obra obra) throws SQLException{
	
	//Criar investimento
		
	
	    java.sql.PreparedStatement stmt=InvestimentoDAO.con.prepareStatement("insert into investimento (idinvestimento,"
				+ " valor_invest, data_invest, descricao_invest)"
				+ " values(?,?,?,?,?)");
		
		stmt.setInt(1,investimento.getIdInvestimento());
		stmt.setDouble(2, investimento.getValor());
		
		java.util.Date data = investimento.getData();
		String dataString;
		dataString = investimento.getData().getDate()+""+investimento.getData().getMonth()+""+investimento.getData().getYear();
		long dataLong = Long.parseLong(dataString);
		java.sql.Date date = new java.sql.Date(dataLong);
		stmt.setDate(3, (java.sql.Date) date);
		
		stmt.setString(4, investimento.getDescricao());
		stmt.setInt(5, obra.getId_obra());
			
		try {
			stmt.execute();
			stmt.close();
			con.close();
			JOptionPane.showMessageDialog(null, "gravado com successo");
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
			
			
			stmt121 = InvestimentoDAO.con.prepareStatement("select max(idinvestimento) from investimento;");
		
			
			
			ResultSet rs = stmt121.executeQuery();
				while(rs.next()){
				last_id_obra=Integer.parseInt(rs.getString("max(idinvestimento)"));
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

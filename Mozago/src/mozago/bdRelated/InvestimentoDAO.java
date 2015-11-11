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
	System.out.println("chegou no ins invest");
	System.out.println(investimento.toString()+ "" + obra.toString());
	//Criar investimento
	
	
	try{
		con = (Connection) BdConecta.getConnection();
			}
			catch (SQLException e){
				System.out.println(e.getMessage());
			}
	
	    java.sql.PreparedStatement stmt=InvestimentoDAO.con.prepareStatement("insert into investimento (idinvestimento,"
				+ " valor_invest, data_invest, descricao_invest,obra_id)"
				+ " values(?,?,?,?,?)");
		
		stmt.setInt(1,investimento.getIdInvestimento());
		stmt.setDouble(2, investimento.getValor());
		
		java.sql.Date date = new java.sql.Date(Calendar.getInstance().getTime().getTime());
		
		stmt.setDate(3, (java.sql.Date) date);
		
		stmt.setString(4, investimento.getDescricao());
		stmt.setInt(5, obra.getId_obra());
			
		try {
			stmt.execute();
			System.out.println("invest criado");
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
					String string = rs.getString("max(idinvestimento)");
					if(string==null){
						return 1;
					}
		
				last_id_obra=Integer.parseInt(rs.getString("max(idinvestimento)"));
				//stmt121.close();
				//con.close();
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

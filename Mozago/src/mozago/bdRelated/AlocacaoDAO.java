package mozago.bdRelated;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Date;
import java.util.Calendar;

import javax.swing.JOptionPane;

import mozago.model.Obra;
import mozago.model.User;

import com.mysql.jdbc.Connection;

public class AlocacaoDAO {
	private static Connection con;
	
	@SuppressWarnings("static-access")
	public AlocacaoDAO() throws SQLException{
		
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
		java.sql.PreparedStatement stmt=AlocacaoDAO.con.prepareStatement("insert into alocacao (idalocacao, admin,"
				+ "director, gestor, obra, data)"
				+ " values(?,?,?,?,?,?)");
		
		stmt.setInt(1, AlocacaoDAO.generateId());
		stmt.setInt(2, admin.getIdUser());
		stmt.setInt(3, director.getIdUser());
		stmt.setInt(4, gestor.getIdUser());
		stmt.setInt(5, obra.getId_obra());
		
		java.sql.Date date = new java.sql.Date(Calendar.getInstance().getTime().getTime());
		
		
		
		
		
		
		stmt.setDate(6, (java.sql.Date) date);
		
		
				
		
		try {
			stmt.execute();
			stmt.close();
			con.close();
			JOptionPane.showMessageDialog(null, "alocacao gravada com successo");
		} catch (Exception e) {
			e.getMessage();
		}
		
		/*idalocacao` int(11) NOT NULL,
  `admin` int(11) DEFAULT NULL,
  `director` int(11) DEFAULT NULL,
  `gestor` int(11) DEFAULT NULL,
  `obra` int(11) DEFAULT NULL,
  `data` date DEFAULT NULL,*/
		
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
				
				
				stmt121 = AlocacaoDAO.con.prepareStatement("select max(idalocacao) from alocacao;");
			
				
				
				ResultSet rs = stmt121.executeQuery();
					while(rs.next()){
						String string = rs.getString("max(idalocacao)");
						if(string==null){
							return 1;
						}
						last_id_obra=Integer.parseInt(rs.getString("max(idalocacao)"));
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

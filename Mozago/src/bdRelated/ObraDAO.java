package bdRelated;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.Vector;

import mozago.model.*;

import com.mysql.jdbc.Connection;


public class ObraDAO {

	private Connection con;
	Vector lista= new Vector();
	int tamanhoLista;
	
	
	
	public ObraDAO() throws SQLException{
		
	this.con=(Connection) BdConecta.getConnection();
		
	}
	
	public void inserir(Obra obra) throws SQLException{
		
		java.sql.PreparedStatement stmt=this.con.prepareStatement("insert into propina (prop_ref, prop_quantia_pagar, prop_nr_prestacao, prop_data_limite, num_ct, cod_est, prop_quantia_recebida, prop_meio_pagamento, prop_data_pagamento, cod_func, prop_estado) values(?,?,?,?,?,?,?,?,?,?,?)");
		
		stmt.setString(1, obra.getId_obra());
		/*stmt.setString(2, propina.getProp_quantia_pagar());
		stmt.setString(3, propina.getProp_nr_prestacao());
		stmt.setDate(4, (Date) propina.getProp_data_limite());
		stmt.setString(5,"C0"+ propina.getNum_ct());
		stmt.setString(6, propina.getCod_est());
		stmt.setString(7, propina.getProp_quantia_recebida());
		stmt.setString(8, propina.getProp_meio_pagamento());
		stmt.setDate(9, (Date) propina.getProp_data_pagamento());
		stmt.setString(10,propina.getCod_func());
		stmt.setString(11, propina.getProp_estado());*/
		
		stmt.execute();
		try {
			stmt.close();
			con.close();
		} catch (Exception e) {
			e.getMessage();
		}
		
		
	}
	
	public void inserirContrato(Contrato ct) throws SQLException{
		java.sql.PreparedStatement stmt=this.con.prepareStatement("insert into contrato (ct_num,ct_moeda,ct_data_emissao,ct_data_vencimento,ct_condicao_pagamento,ct_total,cod_est) values(?,?,?,?,?,?,?)");
		
		stmt.setString(1, "C0"+ct.getCt_num());
		stmt.setString(2, "MZM");
		stmt.setDate(3, (Date) ct.getCt_data_emissao());
		stmt.setDate(4, (Date)ct.getCt_data_vencimento());
		stmt.setString(5, ct.getCt_condicao_pagamento());
		stmt.setString(6, ct.getCt_total()+"");
		stmt.setString(7, ct.getCod_est());
		
		stmt.execute();
		try {
			stmt.close();
			con.close();
		} catch (Exception e) {
			e.getMessage();
		}
		
	}
	
	public Contrato buscaEstContratoNum(String est_cod) throws SQLException{ 
		java.sql.PreparedStatement stmt=this.con.prepareStatement("select * from contrato where cod_est=?;");
		stmt.setString(1,est_cod);
		
		ResultSet rs=stmt.executeQuery();
		
		Contrato ct=null;
		 while(rs.next())
         {
            ct=new Contrato();
            ct.setCt_num(rs.getNString("ct_num"));
            ct.setCt_moeda(rs.getNString("ct_moeda"));
            ct.setCt_data_emissao((Date)rs.getDate("ct_data_emissao"));
            ct.setCt_data_vencimento((Date)rs.getDate("ct_data_vencimento"));
            ct.setCt_condicao_pagamento(rs.getNString("ct_condicao_pagamento"));
            ct.setCt_total(Double.parseDouble(rs.getNString("ct_total")));
            ct.setCt_num(rs.getNString("cod_est"));
            
            
         }
		try {
			stmt.close();
			con.close();
		} catch (Exception e) {
			e.getMessage();
		}
		
		return ct;
	}
	
	public Contrato buscaEstContratoNome(String est_nome) throws SQLException{ 
		java.sql.PreparedStatement stmt=this.con.prepareStatement("select * from contrato where est_nome=?;");
		stmt.setString(1,est_nome);
		
		ResultSet rs=stmt.executeQuery();
		
		Contrato ct=null;
		 while(rs.next())
         {
            ct=new Contrato();
            ct.setCt_num(rs.getNString("ct_num"));
            ct.setCt_moeda(rs.getNString("ct_moeda"));
            ct.setCt_data_emissao((Date)rs.getDate("ct_data_emissao"));
            ct.setCt_data_vencimento((Date)rs.getDate("ct_data_vencimento"));
            ct.setCt_condicao_pagamento(rs.getNString("ct_condicao_pagamento"));
            ct.setCt_total(Double.parseDouble(rs.getNString("ct_total")));
            ct.setCt_num(rs.getNString("cod_est"));
            
            
         }
		try {
			stmt.close();
			con.close();
		} catch (Exception e) {
			e.getMessage();
		}
		
		return ct;
	}
	
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
	
	
	
	
	
	public void PagaPropEst(String PrepRef, String ValorReceb, String meioPag) throws SQLException{
		java.sql.PreparedStatement stmt=this.con.prepareStatement("udpdate propina set prop_quantia_recebida=?, prop_meio_pagamento=?, prop_data_pagamento=?, prop_estado=? where prop_ref=? ;");
		stmt.setString(1,ValorReceb );
		stmt.setString(2,meioPag );
		stmt.setString(3,"2014-10-28" );
		stmt.setString(4,"Pago" );
		stmt.setString(5,PrepRef );
		
		
ResultSet rs=stmt.executeQuery();
		
		
	
	
		
		try {
			stmt.close();
			con.close();
		} catch (Exception e) {
			e.getMessage();
		}
		
	}
	
	
	
	
	
	
	
	
	public void buscaPropEstNaoPaga(String ct_num) throws SQLException{
		java.sql.PreparedStatement stmt=this.con.prepareStatement("select * from propina where prop_estado<>'pago';");
		
		ResultSet rs=stmt.executeQuery();
		
		Propina prop=null;
		
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
		}
		
		try {
			stmt.close();
			con.close();
		} catch (Exception e) {
			e.getMessage();
		}
	}
	public Estudante buscaDadosEstudanteCod(String est_cod) throws SQLException{
		java.sql.PreparedStatement stmt=this.con.prepareStatement("select * from estudante where est_cod=?;");
		stmt.setString(1,est_cod);
		
		ResultSet rs=stmt.executeQuery();
		
		Estudante est=null;
		
		while(rs.next()){
			est=new Estudante();
			est.setEst_cod(rs.getString("est_cod"));
			est.setEst_nome(rs.getString("est_nome"));
			est.setEst_apelido(rs.getString("est_apelido"));
			est.setEst_bi(rs.getString("est_bi"));
			est.setEst_nacionalidade(rs.getString("est_nacionalidade"));
			String i =rs.getString("est_sexo");
			est.setEst_sexo(i.charAt(0));
			est.setEst_endereco_rua(rs.getString("est_endereco_rua"));
			est.setEst_endereco_bairro(rs.getString("est_endereco_bairro"));
			est.setEst_categoria_id(rs.getString("est_categoria_id"));
			
		}
		
		try {
			stmt.close();
			con.close();
		} catch (Exception e) {
			e.getMessage();
		}
		
		return est;
	}
	
	public Frequencia buscaDadosFrequenciaEstCod(String est_cod) throws SQLException{
		java.sql.PreparedStatement stmt=this.con.prepareStatement("select * from frequencia where cod_est=?;");
		stmt.setString(1,est_cod);
		
		ResultSet rs=stmt.executeQuery();
		
		Frequencia est=null;
		
		while(rs.next()){
			est=new Frequencia();
			est.setCod_curso(rs.getString("cod_curso"));
			est.setCod_est(rs.getString("cod_est"));
			est.setCod_financ(rs.getString("cod_financ"));
			est.setFreq_ano_inicio(rs.getString("freq_ano_inicio"));
			est.setFreq_ano_fim(rs.getString("freq_ano_fim"));
			
			
		}
		
		try {
			stmt.close();
			con.close();
		} catch (Exception e) {
			e.getMessage();
		}
		
		return est;
	}
	public Vector buscaDadosEstudanteNome(String est_nome) throws SQLException{
		
		java.sql.PreparedStatement stmt=this.con.prepareStatement("select * from estudante where est_nome=?;");
		stmt.setString(1,est_nome);
		
		ResultSet rs=stmt.executeQuery();
		tamanhoLista=stmt.getFetchSize();
		
		Estudante est=null;
		
		while(rs.next()){
			est=new Estudante();
			est.setEst_cod(rs.getString("est_cod"));
			est.setEst_nome(rs.getString("est_nome"));
			est.setEst_apelido(rs.getString("est_apelido"));
			est.setEst_bi(rs.getString("est_bi"));
			est.setEst_nacionalidade(rs.getString("est_nacionalidade"));
			String i =rs.getString("est_sexo");
			est.setEst_sexo(i.charAt(0));
			est.setEst_endereco_rua(rs.getString("est_endereco_rua"));
			est.setEst_endereco_bairro(rs.getString("est_endereco_bairro"));
			est.setEst_categoria_id(rs.getString("est_categoria_id"));
			lista.addElement(est);
			
		}
		
		try {
			stmt.close();
			con.close();
		} catch (Exception e) {
			e.getMessage();
		}
		return lista;
		
		
		
	}
	
public Vector buscaDadosTodosEstudanteCod() throws SQLException{
		
		java.sql.PreparedStatement stmt=this.con.prepareStatement("select * from estudante;");
	
		
		ResultSet rs=stmt.executeQuery();
		tamanhoLista=stmt.getFetchSize();
		
		Estudante est=null;
		
		while(rs.next()){
			est=new Estudante();
			est.setEst_cod(rs.getString("est_cod"));
			est.setEst_nome(rs.getString("est_nome"));
			est.setEst_apelido(rs.getString("est_apelido"));
			est.setEst_bi(rs.getString("est_bi"));
			est.setEst_nacionalidade(rs.getString("est_nacionalidade"));
			String i =rs.getString("est_sexo");
			est.setEst_sexo(i.charAt(0));
			est.setEst_endereco_rua(rs.getString("est_endereco_rua"));
			est.setEst_endereco_bairro(rs.getString("est_endereco_bairro"));
			est.setEst_categoria_id(rs.getString("est_categoria_id"));
			lista.addElement(est);
			
		}
		
		try {
			stmt.close();
			con.close();
		} catch (Exception e) {
			e.getMessage();
		}
		return lista;
		
		
		
	}
	
	public Financiador buscarFinanciador(String cod_est) throws SQLException{
		java.sql.PreparedStatement stmt=this.con.prepareStatement("select financ_cod,financ_designacao,"
				+ "financ_endereco_rua,financ_endereco_bairro from "
				+ "financiador inner join frequencia on financ_cod=cod_financ where cod_est=?;");
		stmt.setString(1,cod_est);
		
		Financiador financ=null;
		
		ResultSet rs=stmt.executeQuery();
		
		while(rs.next()){
			financ=new Financiador();
			financ.setFinanc_cod(rs.getString("financ_cod"));
			financ.setFinanc_designacao(rs.getString("financ_designacao"));
			financ.setFinanc_endereco_rua(rs.getString("financ_endereco_rua"));
			financ.setFinanc_endereco_bairro(rs.getString("financ_endereco_bairro"));
			
		}
		
		try {
			stmt.close();
			con.close();
		} catch (Exception e) {
			e.getMessage();
		}
		return financ;
		
	}
	
	public double calculaContratoTotal(String est_num,String cond_pagamento) throws SQLException{
		java.sql.PreparedStatement stmt=this.con.prepareStatement("select cat_designacao,"
				+ "curso_prop_mensal from estudante "
				+ "inner join est_categoria cat on est_categoria_id=cat_id "
				+ "inner join frequencia f on est_cod=f.cod_est inner join curso on curso_cod=cod_curso where est_cod=?;");
		
		stmt.setString(1,est_num);
		ResultSet rs=stmt.executeQuery();
		String cat=null;
		double propMensal=0;
		System.out.println("AQUI 1");
		while(rs.next()){
			
			cat=rs.getString("cat_designacao");
			System.out.println(cat);
			propMensal=Double.parseDouble(rs.getString("curso_prop_mensal"));
			System.out.println(propMensal);
			System.out.println("AQUI 2");
			
		}
		
		try {
			System.out.println("AQUI 3");
			stmt.close();
			con.close();
		} catch (Exception e) {
			e.getMessage();
		}
		int nprestMensal=10;
		
		if(cat.contains("25%")){
			if(cond_pagamento.contains("Anual")){
				return 2*nprestMensal*(propMensal-propMensal*0.25);
			}
			else{
				return nprestMensal*(propMensal-propMensal*0.25);
			}
		}
		else if(cat.contains("50%")){
			if(cond_pagamento.contains("Anual")){
				return 2*nprestMensal*(propMensal-propMensal*0.5);
			}
			else{
				return nprestMensal*(propMensal-propMensal*0.5);
			}
		}
		
		else if(cat.contains("100%")){
			return 0;
		}
		else
		{
					return nprestMensal*propMensal;
		}
		
		
	}
	public double calculaDivida(double quant){
		return -1;
	}
	public boolean verificaPropEmDia() throws SQLException{
		java.sql.PreparedStatement stmt=this.con.prepareStatement("select * from propina where prop_estado='pago';");
		
		ResultSet rs=stmt.executeQuery();
		String pago="";
		while(rs.next()){
			pago=rs.getString("prop_estado");
		}
		try {
			stmt.close();
			con.close();
		} catch (Exception e) {
			e.getMessage();
		}
		return pago.equals("pago");
	}
	public Date calcDataCtVenc(){
		java.util.Date d=new java.util.Date();
		Calendar c = Calendar.getInstance();
		c.setTime(d);

			
		c.set(Calendar.MONTH, c.get(Calendar.MONTH) + 5);
		d=(Date) c.getTime();
		return (Date) d;
	}
	public Date calcDatalimProp(Date d){

		Calendar c = Calendar.getInstance();
		c.setTime(d);

		c.set(Calendar.DAY_OF_MONTH, c.get(Calendar.DAY_OF_MONTH) + 10);
		d=(Date) c.getTime();
		return d;
	}
	
	
	

}

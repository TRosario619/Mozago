package mozago.model;

import java.sql.Date;

public class Obra {
	
	
	private String decricao,dono_obra, contacto_dono_obra,duracao;
	private int id_obra;
	private Date data_inicio;
	private Date data_fim; 
	private Date data_prazo; 
	private int tipo_obra;
	private Double valorProjectado;
	
	public Obra(){
		
	}
	public Obra(int id_obra, String decricao, String dono_obra,
			String contacto_dono_obra, int tipo_obra, java.sql.Date data_inicio2,
			java.sql.Date data_fim2, java.sql.Date data_prazo2, Double valorProjectado) {
		super();
		this.id_obra = id_obra;
		this.decricao = decricao;
		this.dono_obra = dono_obra;
		this.contacto_dono_obra = contacto_dono_obra;
		this.tipo_obra = tipo_obra;
		this.data_inicio = data_inicio2;
		this.data_fim = data_fim2;
		this.valorProjectado = valorProjectado;
		this.data_prazo= data_prazo2;
	}
	

	
	public Date getData_prazo() {
		return data_prazo;
	}



	public void setData_prazo(Date data_prazo) {
		this.data_prazo = data_prazo;
	}



	public int getId_obra() {
		return id_obra;
	}
	public void setId_obra(int id_obra) {
		this.id_obra = id_obra;
	}
	public String getDecricao() {
		return decricao;
	}
	public void setDecricao(String decricao) {
		this.decricao = decricao;
	}
	public String getDono_obra() {
		return dono_obra;
	}
	public void setDono_obra(String dono_obra) {
		this.dono_obra = dono_obra;
	}
	public String getContacto_dono_obra() {
		return contacto_dono_obra;
	}
	public void setContacto_dono_obra(String contacto_dono_obra) {
		this.contacto_dono_obra = contacto_dono_obra;
	}
	public int getTipo_obra() {
		return tipo_obra;
	}
	public void setTipo_obra(int tipo_obra) {
		this.tipo_obra = tipo_obra;
	}
	public Date getData_inicio() {
		return data_inicio;
	}
	public void setData_inicio(Date data_inicio) {
		this.data_inicio = data_inicio;
	}
	public Date getData_fim() {
		return data_fim;
	}
	public void setData_fim(Date data_fim) {
		this.data_fim = data_fim;
	}
	public String getDuracao() {
		return duracao;
	}
	public void setDuracao(String duracao) {
		this.duracao = duracao;
	}
	public Double getValorProjectado() {
		return valorProjectado;
	}
	public void setValorProjectado(Double valorProjectado) {
		this.valorProjectado = valorProjectado;
	}


	


}

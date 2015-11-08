package mozago.model;

public class Obra {
	
	
	String id_obra,decricao,dono_obra, contacto_dono_obra,tipo_obra, data_inicio, data_fim,duracao;
	Double valorProjectado;
	
	public Obra(String id_obra, String decricao, String dono_obra,
			String contacto_dono_obra, String tipo_obra, String data_inicio,
			String data_fim, String duracao, Double valorProjectado) {
		super();
		this.id_obra = id_obra;
		this.decricao = decricao;
		this.dono_obra = dono_obra;
		this.contacto_dono_obra = contacto_dono_obra;
		this.tipo_obra = tipo_obra;
		this.data_inicio = data_inicio;
		this.data_fim = data_fim;
		this.duracao = duracao;
		this.valorProjectado = valorProjectado;
	}
	

	
	public String getId_obra() {
		return id_obra;
	}
	public void setId_obra(String id_obra) {
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
	public String getTipo_obra() {
		return tipo_obra;
	}
	public void setTipo_obra(String tipo_obra) {
		this.tipo_obra = tipo_obra;
	}
	public String getData_inicio() {
		return data_inicio;
	}
	public void setData_inicio(String data_inicio) {
		this.data_inicio = data_inicio;
	}
	public String getData_fim() {
		return data_fim;
	}
	public void setData_fim(String data_fim) {
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

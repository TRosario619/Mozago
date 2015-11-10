package mozago.model;

import java.util.Date;

public class Investimento {
	private int idInvestimento,IdObra;
	private double valor;
	private Date data;
	private String descricao;
	
	
	
	public int getIdInvestimento() {
		return idInvestimento;
	}
	public void setIdInvestimento(int idInvestimento) {
		this.idInvestimento = idInvestimento;
	}
	public int getIdObra() {
		return IdObra;
	}
	public void setIdObra(int idObra) {
		IdObra = idObra;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public double getValor() {
		return valor;
	}
	public void setValor(double valor) {
		this.valor = valor;
	}
	public Date getData() {
		return data;
	}
	public void setData(Date data) {
		this.data = data;
	}
	public Investimento(double valor, Date data) {
		super();
		this.valor = valor;
		this.data = data;
	}

}

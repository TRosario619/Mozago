package mozago.model;

import java.util.Date;

public class Investimento {
	private int idInvestimento;
	private double valor;
	private static Date data = new Date();
	private String descricao;
		
	public int getIdInvestimento() {
		return idInvestimento;
	}
	public void setIdInvestimento(int idInvestimento) {
		this.idInvestimento = idInvestimento;
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
	public Investimento(int idInvestimento, double valor, String descricao) {
		super();
		this.idInvestimento = idInvestimento;
		this.valor = valor;
		this.descricao = descricao;
	}
	public void setData(Date data) {
		this.data = data;
	}
	
}

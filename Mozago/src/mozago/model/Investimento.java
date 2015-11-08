package mozago.model;

import java.util.Date;

public class Investimento {
	private double valor;
	private Date data;
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

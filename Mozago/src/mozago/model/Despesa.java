package mozago.model;

import java.sql.Date;

public class Despesa {
private Date data;
private int id,quantia;
public void setData(Date data) {
	this.data = data;
}


public void setId(int id) {
	this.id = id;
}


public void setQuantia(int quantia) {
	this.quantia = quantia;
}


public void setPreco_total(double preco_total) {
	this.preco_total = preco_total;
}
private double preco_total;
public Despesa(Date data, int id, int quantia, double preco_total) {
	super();
	this.data = data;
	this.id = id;
	this.quantia = quantia;
	this.preco_total = preco_total;
}


}

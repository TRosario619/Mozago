package mozago.model;

public class Despesa {
private String id, quantia, preco_total,data;



public Despesa(String id, String quantia, String preco_total, String data) {
	super();
	this.id = id;
	this.quantia = quantia;
	this.preco_total = preco_total;
	this.data = data;
}


public String getId() {
	return id;
}
public void setid(String id) {
	this.id = id;
}
public String getQuantia() {
	return quantia;
}
public void setQuantia(String quantia) {
	this.quantia = quantia;
}
public String getPreco_total() {
	return preco_total;
}
public void setPreco_total(String preco_total) {
	this.preco_total = preco_total;
}
public String getData() {
	return data;
}
public void setData(String data) {
	this.data = data;
}






}

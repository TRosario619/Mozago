package mozago.model;

public class Despesa {
private String iD, tipo, descricao;


public Despesa(String iD, String tipo, String descricao, double valor,
		double quantidade) {
	super();
	iD = iD;
	this.tipo = tipo;
	this.descricao = descricao;
	this.valor = valor;
	this.quantidade = quantidade;
}
public String getID() {
	return iD;
}
public void setID(String iD) {
	iD = iD;
}
public String getTipo() {
	return tipo;
}
public void setTipo(String tipo) {
	this.tipo = tipo;
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
public double getQuantidade() {
	return quantidade;
}
public void setQuantidade(double quantidade) {
	this.quantidade = quantidade;
}
double valor, quantidade;

}

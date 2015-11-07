package mozago.model;

public class Despesa {
String ID, tipo, descricao;
public String getID() {
	return ID;
}
public void setID(String iD) {
	ID = iD;
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

package mozago.model;

import java.util.Date;

public class Obra {
	private String dono, tipo, numero;
	private Date dataInicio, dataFim, dataPrazo;
	private double valorProjectado, valorInicial;

public Obra(String dono, String tipo, String numero, Date dataInicio,
		Date dataFim, Date dataPrazo, double valorProjectado, double valorInicial) {
	super();
	this.dono = dono;
	this.tipo = tipo;
	this.numero = numero;
	this.dataInicio = dataInicio;
	this.dataFim = dataFim;
	this.dataPrazo = dataPrazo;
	this.valorProjectado = valorProjectado;
	this.valorInicial = valorInicial;
}
public double getValorInicial() {
	return valorInicial;
}
public void setValorInicial(double valorInicial) {
	this.valorInicial = valorInicial;
}
public String getDono() {
	return dono;
}
public void setDono(String dono) {
	this.dono = dono;
}
public String getTipo() {
	return tipo;
}
public void setTipo(String tipo) {
	this.tipo = tipo;
}
public String getNumero() {
	return numero;
}
public void setNumero(String numero) {
	this.numero = numero;
}
public Date getDataInicio() {
	return dataInicio;
}
public void setDataInicio(Date dataInicio) {
	this.dataInicio = dataInicio;
}
public Date getDataFim() {
	return dataFim;
}
public void setDataFim(Date dataFim) {
	this.dataFim = dataFim;
}
public Date getDataPrazo() {
	return dataPrazo;
}
public void setDataPrazo(Date dataPrazo) {
	this.dataPrazo = dataPrazo;
}
public double getValorProjectado() {
	return valorProjectado;
}
public void setValorProjectado(double valorProjectado) {
	this.valorProjectado = valorProjectado;
}

}

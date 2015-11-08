package mozago.model;

import java.util.Date;

public class Notificacao {
	private String iD, emissor, destino, mensagem;
	private boolean lido;
	private Date data;
	
	public Notificacao(String iD, String emissor, String destino,
			String mensagem, boolean lido, Date data) {
		super();
		this.iD = iD;
		this.emissor = emissor;
		this.destino = destino;
		this.mensagem = mensagem;
		this.lido = lido;
		this.data = data;
	}
	
	public String getiD() {
		return iD;
	}
	public void setiD(String iD) {
		this.iD = iD;
	}
	public String getEmissor() {
		return emissor;
	}
	public void setEmissor(String emissor) {
		this.emissor = emissor;
	}
	public String getDestino() {
		return destino;
	}
	public void setDestino(String destino) {
		this.destino = destino;
	}
	public String getMensagem() {
		return mensagem;
	}
	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}
	public boolean isLido() {
		return lido;
	}
	public void setLido(boolean lido) {
		this.lido = lido;
	}
	public Date getData() {
		return data;
	}
	public void setData(Date data) {
		this.data = data;
	}

}

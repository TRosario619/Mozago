package mozago.model;

public class Material {
	private String descricao;
	private String iD;
	private double preco_unitario;

	
	public Material(String descricao, String iD, double preco_unitario) {
		super();
		this.descricao = descricao;
		this.iD = iD;
		this.preco_unitario = preco_unitario;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public String getiD() {
		return iD;
	}
	public void setiD(String iD) {
		this.iD = iD;
	}
	public double getPreco_unitario() {
		return preco_unitario;
	}
	public void setPreco_unitario(double preco_unitario) {
		this.preco_unitario = preco_unitario;
	}
	
	

}

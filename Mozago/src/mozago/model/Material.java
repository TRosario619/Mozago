package mozago.model;

public class Material {
	private String descricao;
	private String iD;
	
	public Material(String descricao, String iD) {
		super();
		this.descricao = descricao;
		this.iD = iD;
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
	
	

}

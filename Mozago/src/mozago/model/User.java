package mozago.model;

public class User {
	
	private String nome, apelido, email, password, username, tipo;
	public User(String nome, String apelido, String email, String password,
			String username, String tipo, long telefone) {
		super();
		this.nome = nome;
		this.apelido = apelido;
		this.email = email;
		this.password = password;
		this.username = username;
		this.tipo = tipo;
		this.telefone = telefone;
	}

	long telefone;

	public String getNome() {
		return nome;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public long getTelefone() {
		return telefone;
	}

	public void setTelefone(long telefone) {
		this.telefone = telefone;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getApelido() {
		return apelido;
	}

	public void setApelido(String apelido) {
		this.apelido = apelido;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
	

}

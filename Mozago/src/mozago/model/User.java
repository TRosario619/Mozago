package mozago.model;

public class User {
	
	private String nome, apelido, email, password, username;
	private int categoria, idUser;
	private long telefone;
	
	public User(){
		
	}
	

	public User(int idUser2, String nome, String apelido, String email, String password,
			String username, int categoria, long telefone) {
		super();
		this.idUser=idUser2;
		this.nome = nome;
		this.apelido = apelido;
		this.email = email;
		this.password = password;
		this.username = username;
		this.categoria = categoria;
		this.telefone = telefone;
	}

	

	public int getIdUser() {
		return idUser;
	}



	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}



	public String getNome() {
		return nome;
	}



	public int getCategoria() {
		return categoria;
	}



	public void setCategoria(int categoria) {
		this.categoria = categoria;
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

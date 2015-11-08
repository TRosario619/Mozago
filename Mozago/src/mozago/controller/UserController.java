package mozago.controller;

import mozago.model.User;

public class UserController {

	public boolean validar(String nome,String apelido,String email,String password,String username,String tipo,
	long telefone){
		
		if (nome.isEmpty() || apelido.isEmpty() || email.isEmpty() ||password.isEmpty() || username.isEmpty() ||
				tipo.isEmpty() || telefone == 0)
			return false;
		else 
			if (username.length()<7 || password.length()<7)
				return false;
			else {	
		User user;
		user = new User(nome, apelido, email, password,
				username, tipo,telefone);
		gravar(user);
		return true;
			}
	}
	
	public static void gravar(User user){

	}
}
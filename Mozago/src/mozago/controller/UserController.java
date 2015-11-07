package mozago.controller;

import mozago.model.User;

public class UserController {

	public boolean validar(String nome,String apelido,String email,String password,String username,String tipo,
	long telefone){
		
		if (nome.isEmpty() || apelido.isEmpty() || email.isEmpty() ||password.isEmpty() || username.isEmpty() ||
				tipo.isEmpty() || telefone == 0)
			return false;
		else 
			
		return true;
	}
}

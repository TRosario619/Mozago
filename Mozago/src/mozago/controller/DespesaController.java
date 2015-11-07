package mozago.controller;

import mozago.model.Despesa;

public class DespesaController {
	public boolean validar(String iD, String tipo, String descricao, double valor,
			double quantidade){
				
				if (iD.isEmpty() || tipo.isEmpty() || descricao.isEmpty() ||
						tipo.isEmpty() || valor == 0 || quantidade == 0)
					return false;
				else 
					{	
						Despesa despesa;
						despesa = new Despesa( iD,  tipo,  descricao,  valor,
								 quantidade);
						gravar(despesa);
						return true;
					}
			}
			
			public static void gravar(Despesa despesa){

			}
}

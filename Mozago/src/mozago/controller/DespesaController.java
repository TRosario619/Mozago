package mozago.controller;

import javax.swing.JOptionPane;

import mozago.model.Despesa;

public class DespesaController {
	public Despesa validar(String iD, String tipo, String descricao, double valor,
			double quantidade){
				
				
		
						Despesa despesa;
						despesa = new Despesa( iD,  tipo,  descricao,  valor,
								 quantidade);
						return despesa;
					}
			}
			
			


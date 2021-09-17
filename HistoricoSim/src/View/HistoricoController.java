package View;

import br.com.leandrocolevati.pilhastring.Pilha;

public class HistoricoController {

	public static boolean enderecoValido(String address, Pilha historico) {
		String[] validating = address.split("\\.");
		
		if (validating[0].equals("http://www")) {
			return false;
		}
		
		if (validating.length<3) {
			return false;
		}
			 
		return true;
	}

	public static boolean listaVazia(Pilha historico) {
		
		return historico.isEmpty();
	}
	
public static boolean listaQuaseVazia(Pilha historico) {
		
		return historico.size()==1;
	}

}

package View;

import java.util.Scanner;

import br.com.leandrocolevati.pilhastring.Pilha;

public class Principal {
	public static void main(String args[]) {
		Pilha historico = new Pilha();
		
		System.out.println("escolha uma das op��es:"
				+ "/n 1- adicionar um novo endere�o"
				+ "/n 2- remover �lmtimo endere�o"
				+ "/n 3- visualizar o �ltimo endere�o visitado"
				+ "/n 9- fechar programa");
		
		Scanner input = new Scanner(System.in);
		
		boolean rodando=true;
		
		while (rodando) {
			switch (input.nextInt()) {
			case 1:
				inserirEndere�o(input.next(), historico);
				break;
			case 2:
				removerEndereco(input.nextInt(), historico);
				break;
			case 3:
				visualizarUltimoEndereco(historico);
				break;
			case 9:
				rodando=false;
			default:
				System.err.println("op��o inv�lida");
			}
		}
		input.close();
		
		
		
	}

	private static void visualizarUltimoEndereco(Pilha historico) {
		try {
			System.out.println(historico.top());
			if (HistoricoController.listaQuaseVazia(historico)) {
				System.err.println("�ltimo item do hist�rico exibido!");
			}
		} catch (Exception e) {
			System.err.println("Hist�rico Vazio!");
		}
		
	}

	private static void removerEndereco(int nextInt, Pilha historico) {
		try {
			historico.pop();
			if (HistoricoController.listaVazia(historico)) {
				System.err.println("�ltimo item do hist�rico removido!");
			}
		} 
		catch (Exception e) {
			System.err.println("Hist�rico Vazio!");
		}
	}


	private static void inserirEndere�o(String address,Pilha historico) {
		if (HistoricoController.enderecoValido(address, historico)) {
			historico.push(address);
		}
		else {
			System.err.println("aprenda a escrever uma URL antes de usar este programa");
		}
		
	}

}

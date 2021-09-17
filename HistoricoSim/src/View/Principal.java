package View;

import java.util.Scanner;

import br.com.leandrocolevati.pilhastring.Pilha;

public class Principal {
	public static void main(String args[]) {
		Pilha historico = new Pilha();
		
		System.out.println("escolha uma das opções:"
				+ "/n 1- adicionar um novo endereço"
				+ "/n 2- remover úlmtimo endereço"
				+ "/n 3- visualizar o último endereço visitado"
				+ "/n 9- fechar programa");
		
		Scanner input = new Scanner(System.in);
		
		boolean rodando=true;
		
		while (rodando) {
			switch (input.nextInt()) {
			case 1:
				inserirEndereço(input.next(), historico);
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
				System.err.println("opção inválida");
			}
		}
		input.close();
		
		
		
	}

	private static void visualizarUltimoEndereco(Pilha historico) {
		try {
			System.out.println(historico.top());
			if (HistoricoController.listaQuaseVazia(historico)) {
				System.err.println("Último item do histórico exibido!");
			}
		} catch (Exception e) {
			System.err.println("Histórico Vazio!");
		}
		
	}

	private static void removerEndereco(int nextInt, Pilha historico) {
		try {
			historico.pop();
			if (HistoricoController.listaVazia(historico)) {
				System.err.println("Último item do histórico removido!");
			}
		} 
		catch (Exception e) {
			System.err.println("Histórico Vazio!");
		}
	}


	private static void inserirEndereço(String address,Pilha historico) {
		if (HistoricoController.enderecoValido(address, historico)) {
			historico.push(address);
		}
		else {
			System.err.println("aprenda a escrever uma URL antes de usar este programa");
		}
		
	}

}

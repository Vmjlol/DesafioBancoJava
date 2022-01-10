package desafioBandoDio;

import java.util.Scanner;

import javax.swing.JOptionPane;

public class Executavel {

	public static void main(String[] args) {
		
		String nomeCliente = JOptionPane.showInputDialog("Boas vindas, digite seu nome para continuar");
		
		Cliente cliente = new Cliente();
		cliente.setNome(nomeCliente);
		
				
		Conta cc = new ContaCorrente(cliente);
		cc.depositar(100);
		
		Conta poupanca = new ContaPoupanca(cliente);
	//	poupanca.imprimirExtrato();
		
//		Scanner scan = new Scanner(System.in);
		String valorTransf = JOptionPane.showInputDialog("Muito bem senhor(a) " + cliente.getNome() + ", digite o valor para transfer�ncia");
		double quantiaTransferir = Double.parseDouble(valorTransf);		
		
		System.out.println("Informe uma quantia para transfer�ncia: ");
		//double quantiaTransferir = transf.nextDouble();
		//double quantiaTransferir = 50;
		if (quantiaTransferir > cc.saldo) {
			JOptionPane.showMessageDialog(null, "Quantia indispon�vel para transfer�ncia");
			//System.out.println("Quantia indispon�vel para transfer�ncia");
		} else {
			JOptionPane.showMessageDialog(null, "Valor transferido com sucesso");
			cc.transferir(quantiaTransferir, poupanca);
		}
		
		
		
		cc.imprimirExtrato();
		poupanca.imprimirExtrato();
		
		
	}

}

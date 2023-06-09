package br.com.bytebank.banco.teste;

import br.com.bytebank.banco.modelo.Conta;
import br.com.bytebank.banco.modelo.ContaCorrente;
import br.com.bytebank.banco.modelo.ContaPoupanca;

public class TesteArreyReferencias {

	public static void main(String[] args) {

		Conta[] referencias = new Conta[5];
		
		ContaCorrente cc1 = new ContaCorrente(22, 11);
		referencias[0] = cc1;
		
		ContaPoupanca cc2 = new ContaPoupanca(22, 22);
		referencias[1] = cc2;
		
		ContaPoupanca ref = (ContaPoupanca) referencias[1];
		
		System.out.println(referencias[1].getNumero());
		System.out.println(cc2.getNumero());
		System.out.println(ref.getNumero());
		
	}

}


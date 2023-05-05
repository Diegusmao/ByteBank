package br.com.bytebank.banco.test.util;

import java.util.ArrayList;

import br.com.bytebank.banco.modelo.Conta;
import br.com.bytebank.banco.modelo.ContaCorrente;

public class testeArrayListEquals {

	public static void main(String[] args) {

		// colocar <> depois do array, significa que nesse 
		//array so pode ter contas
		
		ArrayList<Conta> lista = new ArrayList<Conta>();
		
		Conta cc = new ContaCorrente(22, 11);
		lista.add(cc);
		
		Conta cc2 = new ContaCorrente(22, 22);
		lista.add(cc2);
		
		Conta cc3 = new ContaCorrente(22, 22);
		boolean existe = lista.contains(cc3);
		
		System.out.println("ja existe?" + existe);
			  
	
		
		//sem colocar no <Conta> na declaracao do array, precisaria  
		//colocar o for, como object. como colocou o <> pode colocar
		//copmo conta.
		
		//for (Object oRef : lista) {
			//System.out.println(oRef);
			
		for (Conta conta : lista) {
				System.out.println(conta);
		}
		}
		
	}



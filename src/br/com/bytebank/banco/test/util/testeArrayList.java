package br.com.bytebank.banco.test.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import br.com.bytebank.banco.modelo.Conta;
import br.com.bytebank.banco.modelo.ContaCorrente;

public class testeArrayList {

	public static void main(String[] args) {

		// colocar <> depois do array, significa que nesse 
		//array so pode ter contas
		//List<Conta> lista = new ArrayList<Conta>();
		//List<Conta> lista = new LinkedList<Conta>();
		List<Conta> lista = new Vector<Conta>(); //thread safe
		
		Conta cc = new ContaCorrente(22, 11);
		lista.add(cc);
		
		Conta cc2 = new ContaCorrente(22, 22);
		lista.add(cc2);
		
		System.out.println(lista.size());
		
		
		//por ter colocado <Conta> (generics) no array, nao precisa fazer
		//o cast (Conta) no lista.get
		Conta ref = lista.get(0);
		
		System.out.println(ref.getNumero());
		
		lista.remove(0);
		
		System.out.println("tamanho: " + lista.size());
		
		Conta cc3 = new ContaCorrente(33, 311);
		lista.add(cc3);
		
		Conta cc4 = new ContaCorrente(33, 322);
		lista.add(cc4);
		
		for (int i = 0; i < lista.size(); i++) {
			Object oRef = lista.get(i);
			System.out.println(oRef);
		}
		
		System.out.println("__________________");
		
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



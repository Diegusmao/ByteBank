package br.com.bytebank.banco.modelo;

import java.io.Serializable;

/**
 * Classe representa a moldura de uma conta
 * 
 * @author Diego Gusmão
 *
 */

public abstract class Conta extends Object implements Comparable<Conta>, Serializable{
	
	protected double saldo;
	private int agencia;
	private int numero;
	private transient Cliente titular;
	private static int total = 0;
	
	//construtor: quando um objeto é criado, ele atribui valores aos atributos (esses valores tem que ser setado nos parenteses da criacao (new)
	public Conta(int agencia, int numero) {
		Conta.total++;
		//System.out.println("o total de contas e " + total);
		this.agencia = agencia;
		 if(agencia < 1) {
	            throw new IllegalArgumentException("Agencia inválida");
	        }
		 
		this.numero = numero;
		
		if(numero < 1) {
            throw new IllegalArgumentException("Numero da conta inválido");
        }
		
		//this.saldo = 100;
		//System.out.println("estou criando uma conta " + this.numero);
	}
	
	
	public abstract void deposita (double  valor);	
	
	public void saca (double valor) throws SaldoInsuficienteException{
		if (saldo < valor) {
			throw new SaldoInsuficienteException("Saldo: " + this.saldo + ", Valor: " + valor);
			
		}
		
		this.saldo -= valor;
		
	}
	
	public void transfere (double valor, Conta destino) throws SaldoInsuficienteException{
		this.saca (valor);
		destino.deposita(valor);

	}
	
	public double getSaldo() {
		return this.saldo;
	}
	
	public int getNumero() {
		return this.numero;
	}
	
	public void setNumero (int novoNumero) {
		if(numero <=0) {
			System.out.println("nao pode um numero menores ou igual azero");
		}
		this.numero = novoNumero;
	}
	
	public int getAgencia() {
		return this.agencia;
	}
	
	public void setAgencia(int agencia) {
		if(agencia<=0) {
			System.out.println("nao pode valor menor ou igual a 0");
			return;
		}
		this.agencia = agencia;
	}
	
	public void setTitular(Cliente titular) {
		this.titular = titular;
	}
	
	public Cliente getTitular() {
		return titular;
	}
	
	public static int getTotal() {
		return Conta.total;
	}
	
	@Override
	public boolean equals(Object ref) {
		
		Conta outra = (Conta) ref;
		
		if (this.agencia != outra.agencia) {
			return false;
		}
			
		if(this.numero != outra.numero) {
			return false;
		}
		
		return true;
		}

	@Override
	public int compareTo(Conta outra) {
		return Double.compare(this.saldo, outra.saldo);
	}
	
	@Override
	public String toString() {
		return "Numero: " + this.numero + ", Agencia: " + this.agencia + ", Saldo: " + this.saldo;
	}
	
	
}

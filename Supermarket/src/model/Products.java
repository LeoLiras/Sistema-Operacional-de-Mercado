package model;

import helper.Utils;

public class Products {
	private static int contador = 1;
	
	private int codigo;
	private String  nome;
	private Double preco;
	
	public Products(String nome, Double preco) {
		this.codigo = Products.contador;
		this.nome = nome;
		this.preco = preco;
		
		Products.contador++;
	}
	
	public int getCodigo() {
		return this.codigo;
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Double getPreco() {
		return preco;
	}
	public void setPreco(Double preco) {
		this.preco = preco;
	}
	
	public String toString() {
		return "Código: " + this.getCodigo() + "\nNome: " + this.getNome() + "\nPreço: " + Utils.numberToString(this.getPreco());
	}
}

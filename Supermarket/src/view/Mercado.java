package view;

import java.util.Scanner;

import helper.Utils;
import model.Products;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Map;

public class Mercado {
	
	private static Scanner teclado = new Scanner(System.in);
	private static ArrayList<Products> produtos;
	private static Map<Products, Integer> carrinho;
	
	private static void menu(){
		System.out.println("=============================================================================");
		System.out.println("============================ Bem Vindo(a) ===================================");
		System.out.println("================= Supermarket Operacional System ============================\n");
		
		System.out.println("1 - Cadastrar Produto.");
		System.out.println("2 - Listar Produtos.");
		System.out.println("3 - Comprar produto.");
		System.out.println("4 - Visualizar carrinho.");
		System.out.println("5 - Sair do sistema.");
		
		int opcao = 0;
		
		try {
			opcao = Integer.parseInt(teclado.nextLine());
		}catch(InputMismatchException e) {
			Mercado.menu();
		}catch(NumberFormatException e) {
			Mercado.menu();
		}
		
		switch(opcao) {
		case 1:
			Mercado.cadastrar();
			break;
		case 2:
			Mercado.listar();
			break;
		case 3:
			Mercado.comprar();
			break;
		case 4:
			Mercado.visualizar();
			break;
		case 5:
			System.out.println("Muito Obrigado. Volte sempre!");
			Utils.stop(5);
			System.exit(0);
		default:
			System.out.println("Opção inválida.");
			Utils.stop(3);
			Mercado.menu();
		}
	}
	
	private static void cadastrar() {
		System.out.println("Cadastrar Produto");
		System.out.println("=================\n");
		
		System.out.println("Informe o nome do produto: ");
		String nome = Mercado.teclado.nextLine();	
		System.out.println("Informe o preço do produto: ");
		Double preco = Mercado.teclado.nextDouble();
		
		Products produto = new Products(nome, preco);
		Mercado.produtos.add(produto);
		
		System.out.println("O produto " + produto.getNome() + " foi cadastrado com sucesso.");
		
		Utils.stop(1);
		Mercado.menu();
	}
	
	private static void listar() {
		if(Mercado.produtos.size() > 0) {
			for(Products p : produtos) {
				System.out.println(p);
				System.out.println("\n");
			}
		}else {
			System.out.println("Não há produtos cadastrados");
		}
		
		Utils.stop(2);
		Mercado.menu();
	}
	
	private static void comprar() {
		if(Mercado.produtos.size() > 0) {
			System.out.println("Produtos disponíveis: ");
			System.out.println("==============================");
			
			for(Products p: produtos) {
				System.out.println(p);
				System.out.println("____________________________\n");
			}
			
			System.out.println("Informe o código do produto desejado: ");
			int codigo = Integer.parseInt(Mercado.teclado.nextLine());
			
			boolean tem_no_carrinho = false;
			
			for(Products p : produtos) {
				
				if(p.getCodigo() == codigo) {
					int qntd = 0;
					
					try {
						qntd = Mercado.carrinho.get(p);
						Mercado.carrinho.put(p, ++qntd);
					}catch(NullPointerException e) {
						Mercado.carrinho.put(p, 1);
					}
					
					System.out.println("O produto " + p.getNome() + " foi adicionado ao carrinho");
					tem_no_carrinho = true;
				}
				if(tem_no_carrinho) {
					System.out.println("Deseja adicionar outros produtos ao carrinho?");
					System.out.println("1 - Sim.");
					System.out.println("2 - Não.\n");
					int opt = Integer.parseInt(Mercado.teclado.nextLine());
					
					if(opt == 1) {
						Mercado.comprar();
					}else {
						System.out.println("Por favor, aguarde enquanto fechamos o pedido.");
						Utils.stop(3);
						Mercado.fechar();
					}
				}
			}
			
		}else {
			System.out.println("Não há produtos cadastrados.");
			Utils.stop(2);
			Mercado.menu();
		}
	}
	
	private static void visualizar() {
		if(Mercado.carrinho.size() > 0) {
			for(Products p : Mercado.carrinho.keySet()) {
				System.out.println("Produto: " + p + " \nQuantidade: " + Mercado.carrinho.get(p) + "\n");
			}
		}else {
			System.out.println("Carrinho vazio.");
		}
		
		Utils.stop(2);
		Mercado.menu();
	}
	
	public static void fechar() {
		Double valor_total = 0.0;
		
		System.out.println("Produtos do carrinho: ");
		System.out.println("=======================");
		
		for(Products p : Mercado.carrinho.keySet()) {
			int qntd = Mercado.carrinho.get(p);
			
			valor_total += p.getPreco() * qntd;
			
			System.out.println(p);
			System.out.println("Quantidade " + qntd);
			System.out.println("=====================");
			
			System.out.println("Sua fatura é: " + Utils.numberToString(valor_total));
			Mercado.carrinho.clear();
			Utils.stop(3);
			Mercado.menu();
		}
	}
	
	public static void main(String[] args) {
		
		produtos = new ArrayList<Products>();
		carrinho = new HashMap<Products, Integer>();
		
		Mercado.menu();	
	}
}
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
		
	}
	
	private static void listar() {
		
	}
	
	private static void comprar() {
		
	}
	
	private static void visualizar() {
		
	}

	public static void main(String[] args) {
		
		produtos = new ArrayList<Products>();
		carrinho = new HashMap<Products, Integer>();
		
		Mercado.menu();
		
	}

}

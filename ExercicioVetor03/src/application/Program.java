package application;

import java.util.Locale;
import java.util.Scanner;

import entities.Pessoa;


public class Program {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

		System.out.print("Quantas pessoas serão digitadas? ");
		int num = sc.nextInt();

		String nome;
		int idade = 0;
		double altura = 0.00;
		double soma = 0.00;
		int menorDe16 = 0;

		Pessoa[] pessoas = new Pessoa[num];

		for (int i=0; i<pessoas.length; i++) {
			sc.nextLine();
			System.out.println("Dados da " + (i + 1) + "a pessoa: ");
			System.out.print("Nome: ");
			nome = sc.nextLine();
			System.out.print("Idade: ");
			idade = sc.nextInt();

			if (idade < 16)
				menorDe16++;

			System.out.print("Altura: ");
			altura = sc.nextDouble();
			soma += altura;
			pessoas[i] = new Pessoa(nome, idade, altura);
		}

		System.out.println("\nAltura média: " + String.format("%.2f", soma / num));

		double percentualMenorDe16 = menorDe16 / (double)num * 100;

		System.out.println("Pessoas com menos de 16 anos: " + String.format("%.1f", percentualMenorDe16) + "%");

		for (Pessoa element : pessoas) {
			if (element.getIdade() < 16)
				System.out.println(element.getName());
		}

		sc.close();
	}

}

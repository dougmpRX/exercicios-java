package application;

import java.util.Locale;
import java.util.Scanner;

public class Program {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

		System.out.print("Quantos números você vai digitar? ");
		int num = sc.nextInt();
		double[] numeros = new double[num];
		double soma = 0;

		for (int i = 0; i < numeros.length; i++) {
			System.out.print("Digite um número: ");
			numeros[i] = sc.nextDouble();
			soma += numeros[i];
		}

		System.out.print("\nVALORES =");

		for (double element : numeros) {
			System.out.print(" " + element);
		}

		System.out.println("\nSOMA = " + String.format("%.2f", soma));
		System.out.println("MEDIA = " + String.format("%.2f", soma / num));

		sc.close();
	}

}

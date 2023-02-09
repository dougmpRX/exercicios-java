package application;

import java.util.Locale;
import java.util.Scanner;

import entities.Account;


public class Program {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		Account acc;
		System.out.print("Enter account number: ");
		int accountNumber = sc.nextInt();
		sc.nextLine();
		System.out.print("Enter account holder: ");
		String accountHolder = sc.nextLine();
		System.out.print("Is there an initial deposit (y/n)? ");
		char response = sc.next().charAt(0);
		
		if (response == 'y') {
			System.out.print("Enter initial deposit value: $ ");
			double initialDeposit = sc.nextDouble();
			acc = new Account(accountNumber, accountHolder, initialDeposit);
		}
		else {
			acc = new Account(accountNumber, accountHolder);
		}
		
		System.out.println(acc);
				
		System.out.print("\nEnter a deposit value: ");
		acc.deposit(sc.nextDouble());
		System.out.println(acc);
		
		System.out.print("\nEnter a withdraw value: ");
		acc.withdraw(sc.nextDouble());
		System.out.println(acc);
		
		sc.close();

	}

}

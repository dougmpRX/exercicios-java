package application;

import java.util.Locale;
import java.util.Scanner;

import entities.Room;


public class Program {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

		System.out.print("How many rooms will be rented? ");
		int num = sc.nextInt();

		String nome;
		String email;
		int roomNumber = 0;
		Room[] rooms = new Room[10];

		for (int i = 0; i < num; i++) {
			nome = sc.nextLine();
			System.out.println("\nRent #" + (i+1) + ":");
			System.out.print("Name: ");
			nome = sc.nextLine();
			System.out.print("Email: ");
			email = sc.next();
			System.out.print("Room: ");
			roomNumber = sc.nextInt();
			rooms[roomNumber] = new Room(nome, email);
		}

		System.out.println("\nBusy rooms:");

		for (int i = 0; i < rooms.length; i++) {
			if (rooms[i] != null) {
				System.out.println(i + ": " + rooms[i].getName() + ", " + rooms[i].getEmail());
			}
		}

		sc.close();
	}

}

package application;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

import model.entities.User;

public class Program {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		Set<User> set = new HashSet<>();
		
		System.out.print("How many students for course A? ");
		int num = sc.nextInt();
		for (int i = 0; i < num; i++) {
			set.add(new User(sc.nextInt()));
		}
		
		System.out.print("How many students for course B? ");
		num = sc.nextInt();
		for (int i = 0; i < num; i++) {
			set.add(new User(sc.nextInt()));
		}
		
		System.out.print("How many students for course C? ");
		num = sc.nextInt();
		for (int i = 0; i < num; i++) {
			set.add(new User(sc.nextInt()));
		}
		
		System.out.print("Total students: " + set.size());
		
		sc.close();
	}

}

package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.Employee;

public class Program {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

		System.out.print("How many employees will be registered? ");
		int num = sc.nextInt();

		List<Employee> list = new ArrayList<>();

		for (int i = 0; i < num; i++) {
			System.out.println("\nEmployee #" + (i + 1) + ":");
			System.out.print("Id: ");
			Integer id = sc.nextInt();
			sc.nextLine();
			System.out.print("Name: ");
			String name = sc.nextLine();
			System.out.print("Salary: ");
			Double salary = sc.nextDouble();

			Employee emp = new Employee(id, name, salary);
			list.add(emp);
		}

		System.out.println("\nEnter the employee id that will have salary increase: ");
		Integer id = sc.nextInt();
		Employee emp = list.stream().filter(e -> e.getId() == id).findFirst().orElse(null);

		if (emp == null) {
			System.out.println("This id does not exist! ");
		}
		else {
			System.out.println("Enter the percentage");
			double percent = sc.nextDouble();
			emp.increaseSalary(percent);
		}

		System.out.println("\nList of employees: ");
		for (Employee e : list) {
			System.out.println(e);
		}

		sc.close();
	}

}

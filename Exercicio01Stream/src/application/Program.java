package application;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;
import java.util.stream.Collectors;

import model.entities.Employee;

public class Program {

	public static void main(String[] args) {

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		String path = System.getProperty("user.dir") + "\\input\\source.csv";

		List<Employee> list = new ArrayList<>();
		
		try (BufferedReader bf = new BufferedReader(new FileReader(path))) {
		
			String line = bf.readLine();
			while (line != null) {
				String[] fields = line.split(",");
				String name = fields[0];
				String email = fields[1];
				double salary = Double.parseDouble(fields[2]);
				
				list.add(new Employee(name, email, salary));
				line = bf.readLine();
			}
			
			System.out.print("Filter all Employees whose salary is greater than: ");
			double response = sc.nextDouble();
			
			List<String> filteredBySalary = list.stream()
					.filter(emp -> emp.getSalary() > response)
					.map(emp -> emp.getEmail())
					.sorted()
					.collect(Collectors.toList());
			
			filteredBySalary.forEach(System.out::println);
			
			double sum = list.stream()
					.filter(emp -> emp.getName().toUpperCase().startsWith("M"))
					.map(emp -> emp.getSalary())
					.reduce(0.0, (x , y) -> x + y);
			
			System.out.print("Sum of salary whose name starts with 'M': $" + String.format("%.2f", sum));
			
		} catch (Exception e) {
			System.out.println("Error: " + e.getLocalizedMessage());
		}
		
		sc.close();
	}

}

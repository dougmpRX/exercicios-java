package application;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import models.entities.Product;

public class Program {

	public static void main(String[] args) {

		Locale.setDefault(Locale.US);
		System.out.println("Reading 'Exercicio01Files\\src\\csv\\source.csv...'\n");
		String csvFilePath = System.getProperty("user.dir") + "\\src\\csv\\source.csv";
		
		try (BufferedReader reader = new BufferedReader(new FileReader(csvFilePath))){
			
			String line = reader.readLine();
			List<Product> products = new ArrayList<>();
			
			while (line != null) {
				System.out.println(line);
				String[] fields = line.split(";");
				String name = fields[0];
				double price = Double.parseDouble(fields[1]);
				int quantity = Integer.parseInt(fields[2]);
				
				products.add(new Product(name, price, quantity));
				line = reader.readLine();
			}
			
			boolean success = new File(System.getProperty("user.dir") + "\\out").mkdir();
			String targetPath = System.getProperty("user.dir") + "\\out\\summary.csv";
			try (BufferedWriter writer = new BufferedWriter(new FileWriter(targetPath))) {
				for (Product item : products) {
					writer.write(item.getName() + ";" + String.format("%.2f", item.total()));
					writer.newLine();
				}
				
				System.out.println("\n" + targetPath + " created");
				
			} catch (IOException e) {
				System.out.println("\nError writing file: " + e.getMessage());
			}
			
		} catch (IOException e) {
			System.out.println("\nError writing file: " + e.getMessage());
		}
		
	}

}

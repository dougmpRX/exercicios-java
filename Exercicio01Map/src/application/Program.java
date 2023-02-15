package application;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import model.entities.Candidate;

public class Program {

	public static void main(String[] args) {
		
		String path = System.getProperty("user.dir") + "\\src\\input\\source.csv";
		
		Map<String, Integer> collection = new HashMap<>();
		
		try (BufferedReader bf = new BufferedReader(new FileReader(path))) {
			
			String line = bf.readLine();
			while (line != null) {
				String[] fields = line.split(",");
				String name = fields[0];
				int score = Integer.parseInt(fields[1]);
				Candidate candidate = new Candidate(name, score);
				
				if (collection.containsKey(name)) {
					int votesSoFar = collection.get(name);
					collection.put(candidate.getName(), votesSoFar + score);
				}
				else {
					collection.put(candidate.getName(), candidate.getScore());
				}
				line = bf.readLine();
			}

			for (String key : collection.keySet()) {
				System.out.println(key + ": " + collection.get(key));
			}
			
		} catch (FileNotFoundException e) {
			System.out.println("Error: " + e.getMessage());
		} catch (IOException e) {
			System.out.println("Error: " + e.getMessage());
		}
				
	}

}

package TP1;

import java.io.*;
import java.util.Scanner;

public class exo2 {

	public static void main(String[] args) {
		File x = new File("C:\\Users\\helei\\eclipse-workspace\\PJA\\src\\TP1\\source.txt");

		try {
			double x1 = System.currentTimeMillis();
			
			Scanner s = new Scanner(x);
			while (s.hasNextLine()) {
                s.nextLine();

            }
			s.close();
			double x2 =System.currentTimeMillis() - x1;
			System.out.println(x2);
			s.close();
			double x3 = System.currentTimeMillis();
			BufferedReader bf = new BufferedReader( new FileReader("C:\\\\Users\\\\helei\\\\eclipse-workspace\\\\PJA\\\\src\\\\TP1\\\\source.txt"));
			while (bf.readLine() != null) {

            }
			bf.close();
			double x4 =System.currentTimeMillis() - x3;
			System.out.println(x4);


			
			
		} catch (Exception e) {
			System.out.println("error");
			e.printStackTrace();
		}

	}
	}

package TP1;
import java.util.Scanner;
import java.io.*;

public class exo1 {

	public static void main(String[] args) {
		File x = new File("C:\\Users\\helei\\eclipse-workspace\\PJA\\src\\TP1\\source.txt");

		try {
			Scanner s = new Scanner(x);
			int wordsnum = 0;
			int linesnum = 0;
			int charsnum = 0;
			while(s.hasNextLine()) {
				String Line = s.nextLine();
				linesnum = linesnum + 1;
				charsnum = charsnum + Line.length();
				String words[] = Line.split("\\s+");
				wordsnum = wordsnum + words.length;
				

				
			}
			System.out.println("lines number = " + linesnum);
			System.out.println("words number = " + wordsnum);
			System.out.println("chars number = " + charsnum);
			
		} catch (FileNotFoundException e) {
			System.out.println("error");
			e.printStackTrace();
		}
		
		

	}

}

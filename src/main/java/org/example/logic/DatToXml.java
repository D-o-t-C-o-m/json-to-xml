package org.example.logic;

import com.github.underscore.U;

import java.io.*;
import java.util.Scanner;

public class DatToXml {

public static void start(){

	Scanner scanner = new Scanner(System.in);

	System.out.println("____________________________");
	System.out.println("===DAT TO XML CONVERSION===");
	System.out.println("----------------------------");

	System.out.println("Warning: This will overwrite any existing xml file.");
	System.out.print("Enter Filepath of the item to convert:");

	String filePath = scanner.nextLine();

	while (!(filePath.contains(".dat"))) {

		System.out.println("\nInvalid Filepath, please make sure your file ends in '.dat'");
		System.out.print("Enter Filepath of the item to convert:");
		filePath = scanner.nextLine();
	}
		scanner.close();

	writeFile(filePath.replace(".dat",".txt"), readFile(filePath));
}
	public static String readFile(String filePath) {
		try {
			File inputFile = new File(filePath);

			BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(inputFile)));
			StringBuilder builder = new StringBuilder();

			String line;

			while ((line = reader.readLine()) != null) {
				builder.append(line);
			}
			String input = builder.toString().trim();

			reader.close();

			input = input.replace(" ", "");
			return input;
		}
		catch (Exception | Error e) {
			System.out.println(e);
			System.out.println(e.getMessage());
			return null;
		}
	}

	public static void writeFile(String filePath, String input) {
		try {
			//String outputXml = U.jsonToXml(input);
			//TODO: Make this export as multiple lines and then begin the work of Transformsing the data.
			//Currently exports as a text file with all entries on one line. Scratch.txt contains dat breakdown. - https://gist.github.com/D-o-t-C-o-m/b56c1d61931fbbc361aa9ac3cbf64967
			File targetFile = new File(filePath);
			OutputStream outStream = new FileOutputStream(targetFile);
			outStream.write(input.getBytes());
			outStream.close();

			System.out.println("\nProcessing complete. File saved to " + filePath);
		}
		catch (Exception | Error e) {
			//TODO add real logging?
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
	}
}



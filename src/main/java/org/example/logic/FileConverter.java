package org.example.logic;

import com.github.underscore.U;

import java.io.*;
import java.util.Scanner;

public class FileConverter {
public static void start(String startExtension, String endExtension, String conversion) {
	Scanner scanner = new Scanner(System.in);
	System.out.println("____________________________");
	System.out.println("===" + startExtension.toUpperCase() + " TO " + endExtension.toUpperCase() + " conversion===");
	System.out.println("----------------------------");

	System.out.println("Warning: This will overwrite any existing " + endExtension + " file.");
	System.out.print("Enter Filepath of the item to convert:");

	String filePath = scanner.nextLine();

	while (!(filePath.contains("." + startExtension))) {
		System.out.println("\nInvalid Filepath, please make sure your file ends in '.'" + endExtension);
		System.out.print("Enter Filepath of the item to convert:");
		filePath = scanner.nextLine();
	}

	scanner.close();

	writeFile(filePath.replace("." + startExtension, "." + endExtension), readFile(filePath), conversion);
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
	} catch (Exception | Error e) {
		System.out.println(e);
		System.out.println(e.getMessage());
		return null;
	}
}

public static void writeFile(String filePath, String input, String conversion) {
	try {
		String output = convert(input, conversion);

		File targetFile = new File(filePath);
		OutputStream outStream = new FileOutputStream(targetFile);
		assert output != null;
		outStream.write(output.getBytes());
		outStream.close();

		System.out.println("\nProcessing complete. File saved to " + filePath);
	} catch (Exception | Error e) {
		e.printStackTrace();
		System.out.println(e.getMessage());
	}
}

public static String convert(String input, String conversion) {
	if ("jsonToXml".equals(conversion)) {
		return U.jsonToXml(input);
	} else if ("xmlToJson".equals(conversion)) {
		return U.xmlToJson(input);
	}
	return null;
}
}





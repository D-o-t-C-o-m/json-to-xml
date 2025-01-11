package org.example.logic;
import com.github.underscore.U;
import java.io.*;
import java.util.Scanner;

public class XmlToJson {

public static void start() {
	Scanner scanner = new Scanner(System.in);
	System.out.println("____________________________");
	System.out.println("===XML TO JSON CONVERSION===");
	System.out.println("----------------------------");

	System.out.println("Warning: This will overwrite any existing JSON file.");
	System.out.print("Enter Filepath of the item to convert:");

	String filePath = scanner.nextLine();

	while (!(filePath.contains(".xml"))) {
		System.out.println("\nInvalid Filepath, please make sure your file ends in '.xml'");
		System.out.print("Enter Filepath of the item to convert:");
		filePath = scanner.nextLine();
	}
	scanner.close();

	scanner.close();

	String newFilePath = filePath.replace(".xml", ".json");

	String inputJson = readFile(filePath);

	writeFile(newFilePath, inputJson);
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
		String inputXml = builder.toString().trim();

		reader.close();

		inputXml = inputXml.replace(" ", "");
		return inputXml;
	}
	catch (Exception | Error e) {
		System.out.println(e);
		System.out.println(e.getMessage());
		return null;
	}
}

public static void writeFile(String filePath, String input) {
	try {
		String outputJson = U.xmlToJson(input);

		File targetFile = new File(filePath);
		OutputStream outStream = new FileOutputStream(targetFile);
		outStream.write(outputJson.getBytes());
		outStream.close();

		System.out.println("\nProcessing complete. File saved to " + filePath);
	}
	catch (Exception | Error e) {
		System.out.println(e);
		System.out.println(e.getMessage());
	}
}
}


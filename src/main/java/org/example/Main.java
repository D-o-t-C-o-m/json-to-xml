package org.example;
import com.github.underscore.*;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;


public class Main {
public static void main(String[] args) throws IOException {

	Scanner scanner = new Scanner(System.in);

	System.out.println("JSON TO XML CONVERSION\n");

	System.out.print("Enter Filepath of the item to convert: ");
	String filePath = scanner.nextLine();
	scanner.close();

	String newFilePath = filePath.replace(".json", ".xml");

	try {
		File inputFile = new File(filePath);

		BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(inputFile), StandardCharsets.UTF_8));
		StringBuilder builder = new StringBuilder();

		String line;

		while ((line = reader.readLine()) != null) {
			builder.append(line);
		}
		String inputJson = builder.toString().trim();

		reader.close();

		inputJson = inputJson.replace(" ", "");
		String outputXml = U.jsonToXml(inputJson);

		System.out.println(outputXml);
		File targetFile = new File(newFilePath);
		OutputStream outStream = new FileOutputStream(targetFile);
		outStream.write(outputXml.getBytes());
		outStream.close();

	} catch (FileNotFoundException e) {
		System.out.println("File Not Found");
		e.printStackTrace();
	}

	System.out.println("Processing complete. File saved to " + newFilePath);
	}
}

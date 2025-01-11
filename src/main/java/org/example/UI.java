package org.example;
import java.util.Scanner;

public class UI {
public UI(){
}
public static void ui() {

	System.out.println("File Converter");
	System.out.println("(1) for JSON to XML");
	System.out.println("(2) for XML to JSON");
	System.out.println("(3) for DAT to XML");
	System.out.println("(Q) to Quit");
	System.out.print("> ");

	Scanner scanner = new Scanner(System.in);
	String input = scanner.nextLine();

	switch (input) {
		case "1":
			JsonToXml.start();
			break;
		case "2":
			System.out.println("Placeholder text");
			break;
		//XmlToJson.start();
		case "3":
			System.out.println("Placeholder text");
			break;
		//DatToXml.start();
		case "Q":
			System.out.println("Quit");
			System.exit(0);
	}
}


}



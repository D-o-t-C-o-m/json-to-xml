package org.example.UI;
import org.example.logic.JsonToXml;

import java.util.Scanner;

public class UI {
public UI(){
}
public static void ui() {
	System.out.println("==============");
	System.out.println("File Converter");
	System.out.println("==============\n");
	System.out.println("(1) JSON to XML");
	System.out.println("(2) XML to JSON");
	System.out.println("(3) DAT to XML");
	System.out.println("(A)ny other key to Quit");
	System.out.println(" ");
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
	}
}


}



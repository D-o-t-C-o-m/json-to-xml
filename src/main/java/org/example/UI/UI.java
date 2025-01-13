package org.example.UI;

import org.example.logic.DatToXml;
import org.example.logic.FileConverter;

import java.util.Scanner;

public class UI {
public UI() {
}

public static void ui() {
	System.out.println("==============");
	System.out.println("File Converter");
	System.out.println("==============\n");
	System.out.println("(1) JSON to XML");
	System.out.println("(2) XML to JSON");
	System.out.println("(3) DAT to XML");
	System.out.println("(A)ny other key to Quit");

	System.out.print("\n> ");

	Scanner scanner = new Scanner(System.in);
	String input = scanner.nextLine();

	switch (input) {
		case "1":
			FileConverter.start("json", "xml", "jsonToXml");
			break;
		case "2":
			FileConverter.start("xml", "json", "xmlToJson");
			break;
		case "3":
			DatToXml.start();
			break;
	}
}


}



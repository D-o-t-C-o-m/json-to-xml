package org.example.logic;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Scanner;

public class DatToXml {
public ArrayList<String> Items;

public DatToXml() {
	this.Items = new ArrayList<>();
}

public static void start() {
	DatToXml datToXml = new DatToXml();
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

	datToXml.readFile(filePath);

	writeFile(filePath.replace(".dat", ".xml"), datToXml.Items);
}

public static void writeFile(String filePath, ArrayList<String> input) {
	try {

		File targetFile = new File(filePath);
		OutputStream outStream = new FileOutputStream(targetFile);
		outStream.write(("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<root>\n").getBytes());
		for (String item : input) {
			String output = transform(item);
			outStream.write(output.getBytes());
		}
		outStream.write("</root>".getBytes());
		outStream.close();

		System.out.println("\nProcessing complete. File saved to " + filePath);
	} catch (Exception | Error e) {
		//TODO add real logging?
		e.printStackTrace();
		System.out.println(e.getMessage());
	}
}

public static String transform(String input) {
	String storeNum = input.substring(0, 4);
	String upc = input.substring(5, 18);
	String weightOrPriceRequired = input.substring(19, 20);
	String quantityAllowed = input.substring(20, 21);
	String priceRequired = input.substring(21, 22);
	String notForSale = input.substring(22, 23);
	String tax1 = input.substring(23, 24);
	String tax2 = input.substring(24, 25);
	String foodStamp = input.substring(25, 26);
	String emPoints = input.substring(26, 27);
	String itemType = input.substring(27, 28);
	String priceMethod = input.substring(28, 29);
	String department = input.substring(29, 30);
	String familyNumbers = input.substring(31, 37);
	String family1 = familyNumbers.substring(0, 3);
	String family2 = familyNumbers.substring(3, 6);
	String multipriceGroup = input.substring(38, 40);
	String quantity = input.substring(41, 43);
	String linkedTo = input.substring(50, 54);
	String description = input.substring(55, 73);
	String restrictedSale = input.substring(73, 75);
	String wIC = input.substring(75, 76);
	String itemAddedFlag = input.substring(76, 77);
	String tare = input.substring(77, 82);
	String foodperks = input.substring(82, 83);
	String qHP = input.substring(83, 84);
	String rX = input.substring(84, 85);
	String largeLinkedTo = input.substring(85, 98);
	String productRecall = input.substring(99, 100);
	String tax3 = input.substring(100, 101);
	String tax4 = input.substring(101, 102);
	//TODO: Come up with a better way to convert this
	return "<item>\n<storeNum>" + storeNum + "</storeNum>\n<UPC>" + upc + "</UPC>\n<WeightOrPriceRequired>" + weightOrPriceRequired + "</WeightOrPriceRequired>\n<QuantityAllowed>" + quantityAllowed + "</QuantityAllowed>\n<PriceRequired>" + priceRequired + "</PriceRequired>\n<NotForSale>" + notForSale + "</NotForSale>\n<tax1>" + tax1 + "</tax1>\n<tax2>" + tax2 + "</tax2>\n<foodStamp>" + foodStamp + "</foodStamp>\n<EMPoints>" + emPoints + "</EMPoints>\n<ItemType>" + itemType + "</ItemType>\n<PriceMethod>" + priceMethod + "</PriceMethod>\n<Department>" + department + "</Department>\n<family1>" + family1 + "</family1>\n<family2>" + family2 + "</family2>\n<MultiPriceGroup>" + multipriceGroup + "</MultiPriceGroup>\n<Quantity>" + quantity + "</Quantity>\n<LinkedTo>" + linkedTo + "</LinkedTo>\n<Description>" + description + "</Description>\n<RestrictedSale>" + restrictedSale + "</RestrictedSale>\n<WIC>" + wIC + "</WIC>\n<ItemAddedFlag>" + itemAddedFlag + "</ItemAddedFlag>\n<Tare>" + tare + "</Tare>\n<Foodperks>" + foodperks + "</Foodperks>\n<QHP>" + qHP + "</QHP>\n<RX>" + rX + "</RX>\n<LargeLinkedTo>" + largeLinkedTo + "</LargeLinkedTo>\n<ProductRecall>" + productRecall + "</ProductRecall>\n<Tax3>" + tax3 + "</Tax3>\n<Tax4>" + tax4 + "</Tax4>\n</item>\n";

}

public void readFile(String filePath) {

	try {
		File inputFile = new File(filePath);
		Scanner reader = new Scanner(inputFile);
		while (reader.hasNextLine()) {
			String line = reader.nextLine();
			if (line.contains("&")) {
				line = line.replace("&", " ");
			}
			this.Items.add(line);

		}
		reader.close();
		String.join("\n", this.Items);
	} catch (Exception | Error e) {
		System.out.println(e);
		System.out.println(e.getMessage());
	}
}
}




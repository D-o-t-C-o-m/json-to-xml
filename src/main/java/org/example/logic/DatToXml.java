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
			Scanner reader = new Scanner(inputFile);
			while (reader.hasNextLine()) {
				String line = reader.nextLine();
				return line;
			}
		return null;
		}
		catch (Exception | Error e) {
			System.out.println(e);
			System.out.println(e.getMessage());
			return null;
		}
	}

	public static void writeFile(String filePath, String input) {
		try {
			String CSV = transform(input);
			//TODO: Make this export as multiple lines and then begin the work of Transforming the data.
			//Currently exports as a text file with all entries on one line. Scratch.txt contains dat breakdown. - https://gist.github.com/D-o-t-C-o-m/b56c1d61931fbbc361aa9ac3cbf64967
			File targetFile = new File(filePath);
			OutputStream outStream = new FileOutputStream(targetFile);
			outStream.write(CSV.getBytes());
			outStream.close();

			System.out.println("\nProcessing complete. File saved to " + filePath);
		} catch (Exception | Error e) {
			//TODO add real logging?
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
	}
		public static String transform(String input){
		String storeNum = input.substring(0, 4);
		String upc = input.substring(5, 18);
		String weightOrPriceRequired = input.substring(19, 20);//N
		String quantityAllowed = input.substring(20, 21);//N
		String priceRequired = input.substring(21, 22);//N
		String notForSale = input.substring(22, 23);//N
		String tax1 = input.substring(23, 24);//N
		String tax2 = input.substring(24, 25);//N
		String foodStamp = input.substring(25, 26);//Y
		String emPoints = input.substring(26, 27);//4
		String itemType = input.substring(27, 28);//0
		String priceMethod = input.substring(28, 29);//9
		String department = input.substring(29, 30);//9
		String familyNumbers = input.substring(31, 37);//387000
			String family1 = familyNumbers.substring(0, 3);//387
			String family2 = familyNumbers.substring(3, 6);//000
		String multipriceGroup = input.substring(38, 40);//00
		String quantity = input.substring(41, 43);//00
		String linkedTo = input.substring(50, 54);//0000
		String description = input.substring(55, 73);//QUAKER STEAK $25
		String restrictedSale = input.substring(73, 75);//13
		String wIC = input.substring(75, 76);//n
		String itemAddedFlag = input.substring(76, 77);//n
		String tare = input.substring(77, 82);//00000
		String foodperks = input.substring(82, 83);
		String qHP = input.substring(83, 84);
		String rX = input.substring(84, 85);
		String largeLinkedTo = input.substring(85, 98);
		String productRecall = input.substring(99, 100);
		String tax3 = input.substring(100, 101);
		String tax4 = input.substring(101, 102);
		return "Store: "+storeNum+", UPC: "+upc+", WeightOrPriceRequired: "+weightOrPriceRequired+", QuantityAllowed: "+quantityAllowed+", PriceRequired: "+priceRequired+", NotForSale: "+notForSale+", tax1: "+tax1+", tax2: "+ tax2+", foodStamp: "+foodStamp+", EMPoints: "+emPoints+", ItemType: "+itemType+", PriceMethod: "+priceMethod+", Department: "+department +", family1: "+family1+", family2: "+family2+", MultiPriceGroup: "+multipriceGroup+ ", Quantity: "+quantity+", LinkedTo: "+linkedTo+", Description: "+description+", RestrictedSale: "+restrictedSale+", WIC: "+wIC+", ItemAddedFlag: "+itemAddedFlag+", Tare: "+tare+", Foodperks: "+foodperks+ ", QHP: "+qHP+", RX: "+rX+", LargeLinkedTo: "+largeLinkedTo+", ProductRecall: "+productRecall+", Tax3: "+tax3+", Tax4: "+tax4;

		}
	}




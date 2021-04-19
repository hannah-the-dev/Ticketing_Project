package amusementPark;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Menu {
	Scanner sc = new Scanner(System.in);
	public TicketType ticketTime() {
		System.out.println("Which ticket do you want to buy?");
		System.out.println("1. Daytime ticket");
		System.out.println("2. Nighttime ticket");
		int ticketType = sc.nextInt();
		System.out.println(ticketType);
		TicketType type = TicketType.valueOfLabel(ticketType);
		// if 1: DAYTIME, 2: NIGHTTIME
		return type;
	}
	
	public void inputID() {
		String[] ID_Str = null;
		Scanner sc = new Scanner(System.in);
		while (true) {					// repeats until user inputs id in correct format
			System.out.println("Please input ID number without '-'.");
			ID_Str = sc.nextLine().split("");	//
			
			if (ID_Str.length != 13) {
				System.out.println("Wrong ID format: too short or too long.");
			} else if (Integer.parseInt(ID_Str[2]+ID_Str[3]) < 1 || Integer.parseInt(ID_Str[2]+ID_Str[3]) > 12) {
//				 		if month digits are 00 or over 13
				System.out.println("Wrong ID format: month is not in bewteen Jan and Dec.");
			} else if (Integer.parseInt(ID_Str[4]+ID_Str[5]) < 1 || Integer.parseInt(ID_Str[4]+ID_Str[5]) > 31) {
//				 		if day digits are 00 or over 31
				System.out.println("Wrong ID format: day is not in a month");
			} else {
				try { 
					for (int i = 0; i < ID_Str.length; i++) { // try to put id number into CV ID_NUM
					SaveData.ID_NUM[i] = Integer.parseInt(ID_Str[i]); }
				} catch (NumberFormatException e) {
					System.out.println("Please input Arabic numerals(0-9) only.");
				} catch (InputMismatchException e) {
					System.out.println("Please input Arabic numerals(0-9) only.");
				} catch (Exception e) {
					e.printStackTrace();
				} 
				break;
			}
		}
	}
	
	public int ticketQty() {
		int qty = 0;
		while (true) {
			System.out.println("How many tickets do you want to buy? (Max: 10)");
			qty = sc.nextInt();
			if ((qty >= QtyMinMax.MIN.getQty()) && (qty <= QtyMinMax.MAX.getQty())) {
				break;
			} else {
				System.out.println("Quantity is too more than 10 or less than 1");
			}
		}
		return qty;
	}
	
	public Discount inputDiscount() {
		System.out.println("Please input a discount condition.");
		System.out.println("1. None (Age discount will be automatically applied)");
		System.out.println("2. Challenged and disabled");
		System.out.println("3. National merits");
		System.out.println("4. Multiple children");
		System.out.println("5. Pregnency");
		int dcStatus = sc.nextInt();
		Discount dcType = Discount.valueOfLabel(dcStatus);
		return dcType;
	}
	
	public boolean keeping() {
		int keepNum = 0;
		boolean keep = true;
		while(true) {
			System.out.println("Do you want continue to buy more?");
			System.out.println("1. Continue");
			System.out.println("2. Quit");
			keepNum = sc.nextInt();
			if (keepNum != 1 && keepNum != 2) {
				System.out.println("Wrong number. Please try again.");
			} else if (keepNum == 1) {
				keep = true;
				break;
			} else {
				keep = false;
				break;
			}
		}		
		return keep;
	}
	
	public boolean askSession() {
		System.out.println("Do you want to continue? (1: New session, 2: Close program) -> ");
		boolean newSession = Session.boolOfLabel(sc.nextInt());
		System.out.println();
		return newSession;
	}
}

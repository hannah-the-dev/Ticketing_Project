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
		TicketType type = TicketType.valueOfLabel(ticketType);
		return type;
	}
	
	public void inputID() {
		String[] ID_Str = null;
		Scanner sc = new Scanner(System.in);			// if omit: cannot take the number at the first time
		while (true) {					// repeats until user inputs id in correct format
			System.out.println("Please input ID number without space");
			ID_Str = sc.nextLine().replace("-", "").split("");	// in case user inputs hyphen, remove it
			
			if (ID_Str.length != 13) {				// if length is not correct
				System.out.println("Wrong ID format: too short or too long.");	
			} else if (Integer.parseInt(ID_Str[2]+ID_Str[3]) < 1 || 
					Integer.parseInt(ID_Str[2]+ID_Str[3]) > 12) {
//				 		if month digits are 00 or over 13, not a month
				System.out.println("Wrong ID format: month is not in bewteen Jan and Dec.");	
			} else if (Integer.parseInt(ID_Str[4]+ID_Str[5]) < 1 || 
					Integer.parseInt(ID_Str[4]+ID_Str[5]) > 31) {
//				 		if day digits are 00 or over 31, not a day
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
					System.out.println("An Error occured. Please try again.");
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
			if ((qty >= QtyMinMax.MIN.qty) && (qty <= QtyMinMax.MAX.qty)) {
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
		System.out.println("5. Pregnancy");
		int dcStatus = 0;
		Discount dcType = Discount.NONE;
		while (true) {
			dcStatus = sc.nextInt();
			if ((dcStatus > Discount.PREGNANCY.menu) || (dcStatus < Discount.NONE.menu)) {
				System.out.println("Wrong number. Please try again.");
			} else break;
		}
		dcType = Discount.valueOfLabel(dcStatus);
		// if pregnancy chosen, but not female, 
		if (dcStatus == Discount.PREGNANCY.menu && 
				!ASL.valueOfLabel(SaveData.ID_NUM[6]).female) {
			dcType = Discount.NONE;
			System.out.println("Currently, only female can get pregnancy discount");
		}
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
		System.out.println();
		System.out.println("Do you want to continue? (1: New session, 2: Close program) -> ");
		boolean newSession = Session.boolOfLabel(sc.nextInt());
		System.out.println();
		return newSession;
	}
}

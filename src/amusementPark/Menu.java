package amusementPark;

import java.util.Scanner;

public class Menu {
	Scanner sc = new Scanner(System.in);
	Savings save = new Savings();
	
	
	
	public String ticketTime() {
		System.out.println("Which ticket do you want to buy?");
		System.out.println("1. Daytime ticket");
		System.out.println("2. Nighttime ticket");
		int ticketType = sc.nextInt();
		TicketType type = TicketType.valueOfLabel(ticketType);
		String ticket = type.name();	// ticketType to String
		// if 1: DAYTIME, 2: NIGHTTIME
//		Savings.savingStr[WritingTitle.TICKET_TYPE.ordinal()] = ticket;
		save.setTicketType(ticket);
		return ticket;
	}
	
	public void inputID() {
		String[] ID_Str = null;
		sc.nextLine();
		while (true) {					// repeats until user inputs id in correct format
			System.out.println("Please input ID number without '-'.");
			ID_Str = sc.nextLine().split("");	//
			
			if (ID_Str.length != 13) {
				System.out.println("Wrong ID format. Please try again.");
			} else {
				try { 
					for (int i = 0; i < ID_Str.length; i++) { // try to put id number into CV ID_NUM
					TicketConstant.ID_NUM[i] = Integer.parseInt(ID_Str[i]); }
				} catch (NumberFormatException e) {
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
			if ((qty >= TicketingCVs.MIN_QTY) && (qty <= TicketingCVs.MAX_QTY)) {
				break;
			} else {
				System.out.println("Quantity is too more than 10 or less than 1");
			}
		}
//		Savings.savingStr[TicketConstant.QUANTITY] = qty+"";
//		Savings.savingStr[WritingTitle.QUANTITY.ordinal()] = qty+"";
		save.setQuantity(qty);
		
		return qty;
	}
	
	public String inputDiscount() {
		System.out.println("Please input a discount condition.");
		System.out.println("1. None (Age discount will be automatically applied)");
		System.out.println("2. Challenged and disabled");
		System.out.println("3. National merits");
		System.out.println("4. Multiple children");
		System.out.println("5. Pregnency");
		int dcStatus = sc.nextInt();
		String dcType = Discount.valueOfLabel(dcStatus).name();
//		Savings.savingStr[WritingTitle.QUANTITY.ordinal()] = dcType;
		save.setDiscount(dcType);
		
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
}

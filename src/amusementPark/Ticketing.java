package amusementPark;

import java.text.ParseException;

public class Ticketing {

	public static void main(String[] args) throws ParseException {
		// TODO Auto-generated method stub
		boolean keep = true;
		Menu menu = new Menu();
		PrintsTickets print = new PrintsTickets();
		CalAge ages = new CalAge();
		CalAmount amount = new CalAmount();
		while (keep == true) {
			int ticketType = menu.ticketTime();
			menu.inputID();
			int qty = menu.ticketQty();
			int dcGroup = menu.inputDiscount();
			int ageGroup = ages.age();
			int ticketAmount = amount.amount(ticketType, qty, ageGroup, dcGroup);
			print.printsAmount(ticketAmount);
			keep = menu.keeping();		//call Menu.menu(), if menu returns false, break
		}
		print.printsEnding();
	}

}

package amusementPark;

import java.text.ParseException;

public class Ticketing {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		boolean keep = true;
		Menu menu = new Menu();
		PrintsTickets print = new PrintsTickets();
		CalAge ages = new CalAge();
		CalAmount amount = new CalAmount();

		while (keep == true) {
//			ticket type > id > qty > discount > print price >continue? >>> close > print receipt > terminate? > report
			
			menu.ticketTime();		//DAYTIME OR NIGHTTIME
			menu.inputID();
			menu.ticketQty();
			menu.inputDiscount();
			ages.age();
			int totalAmount = amount.amount();
			print.printsAmount(totalAmount);
			keep = menu.keeping();		//call Menu.menu(), if menu returns false, break
		}
		print.printsEnding();	//ending gets total amount
		print.printsSummary();
		print.writingSales();
	}

}

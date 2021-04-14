package amusementPark;

import java.text.DecimalFormat;

public class PrintsTickets {
	public void printsAmount(int amount) {
		DecimalFormat df = new DecimalFormat("###,###"); 
		System.out.println("Total price is " + df.format(amount));
		System.out.println("Thank you.");
		System.out.println();
	}
	
	public void printsEnding() {
		System.out.println("Terminating Session. Thank you.");
		System.out.println();
		
//		call method printing receipts
		printsSummary();
	}
	
	public void printsSummary() {
		System.out.println("================ KOPOWORLD ================");
		
	}
}

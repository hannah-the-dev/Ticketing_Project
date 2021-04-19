package amusementPark;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Scanner;

public class PrintsTickets {
	ArrayList<ArrayList<Object>> savingList;
	DecimalFormat df = new DecimalFormat("###,###"); 
	public PrintsTickets(ArrayList<ArrayList<Object>> savingList) {
		this.savingList = savingList;
	}

	public void printsAmount(long totalAmount) {
		System.out.println("Total price is " + df.format(totalAmount));
		System.out.println("Thank you.");
		System.out.println();
	}
	
	public void printsEnding() {
		System.out.println("Terminating Session. Thank you.");
		System.out.println();
		
//		call method printing receipts
		printsSummary(savingList); 
	}
	
	public void printsSummary(ArrayList<ArrayList<Object>> savingList) {
		System.out.printf("============================= KOPOWORLD ============================\n");
		int sum = 0;
		int qty = 0;
		for (ArrayList<Object> x : savingList) {
			System.out.printf("%-6s%-6s\tX %2d\t%7d 원\t%-15s\n", 
					TicketType.KorOfVal(x.get(WritingTitle.TICKET_TYPE.getOrder())+""),
					AgeGroup.KorOfVal(x.get(WritingTitle.AGE.getOrder())+""),
					x.get(WritingTitle.QUANTITY.getOrder()),
					x.get(WritingTitle.AMOUNT.getOrder()),
					Discount.KorOfVal(x.get(WritingTitle.DISCOUNT.getOrder())+"")
					);
			qty += Integer.parseInt(x.get(WritingTitle.QUANTITY.getOrder())+"");
			sum += Integer.parseInt(x.get(WritingTitle.AMOUNT.getOrder())+"");
		}
		System.out.println();
		System.out.printf("입장료 총액은 %s원 입니다(총 %d 매).\n", df.format(sum), qty);
		System.out.printf("====================================================================\n");
	}
}
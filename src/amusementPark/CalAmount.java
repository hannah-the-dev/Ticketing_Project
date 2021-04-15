package amusementPark;

import java.util.List;

public class CalAmount {
	Savings save = new Savings();
	public int amount() {
//		ticket type 1 == day, 2 == night
		int ticketAmount = Ticket.valueOf(save.getTicketType()).getOnePrice(
				AgeGroup.valueOf(save.getAge()).getIndex()); 
		int qty = save.getQuantity();
		double rest = 1-Discount.valueOf(save.getDiscount()).getRate();
		
		
		int totalAmount = (int) Math.ceil(ticketAmount * qty * rest /10)*10;
		Savings save = new Savings();
		save.setAmount(totalAmount);
		PrintsTickets print = new PrintsTickets();
		print.toList();
		return totalAmount;
	}
	
}

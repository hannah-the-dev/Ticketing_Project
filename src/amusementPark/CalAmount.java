package amusementPark;

import java.util.List;

public class CalAmount {
	public int amount(int ticketType, int qty, int ageGroup, int dcGroup) {
//		ticket type 1 == day, 2 == night
		List<Integer> ticketPrice = TicketingCVs.TICKETS.get(ticketType-1); 		
		int ticketAmount = (int) Math.ceil
				(ticketPrice.get(ageGroup) * qty * 1-TicketingCVs.DISCOUNTS.get(dcGroup-1)/10)*10;
		return ticketAmount;
	}
}

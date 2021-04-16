package amusementPark;

public class CalAmount {
//	SaveData save = new SaveData();
	public long amount(AgeGroup age, TicketType type, int qty, Discount discount) {
//		ticket type 1 == day, 2 == night
//		saved age = adult, adolescent, ....
//		
		int ticketAmount = AgeGroup.getAgeGroup(age)	//ageGroup
				.getAnytime(type); 				//ticekt type
		double rest = 1-Discount.getDiscount(discount).getRate(); // after discount
		long totalAmount = (long) Math.ceil(ticketAmount * qty * rest /10)*10;
		
		return totalAmount;
	}
}

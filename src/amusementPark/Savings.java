package amusementPark;


public class Savings {
	private String date, ticket_Type, discount, age;
	private int quantity, amount;

	public String getTicketType() {
		return ticket_Type;
	}

	public void setTicketType(String ticketType) {
		this.ticket_Type = ticketType;
	}

	public String getDiscount() {
		return discount;
	}

	public void setDiscount(String discount) {
		this.discount = discount;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String ageGroup) {
		this.age = ageGroup;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int qty) {
		this.quantity = qty;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}
	
	public static String[] savingStr = new String[6];
}

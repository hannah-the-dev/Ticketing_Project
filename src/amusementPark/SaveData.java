package amusementPark;

import java.util.ArrayList;

public class SaveData {
	private String date; 
	private TicketType ticket_Type;
	private Discount discount;
	private AgeGroup age;
	private int quantity;
	private long amount;
	
	public static int[] ID_NUM = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};		// calculates ages 
	
	public static int[] getID_NUM() {
		return SaveData.ID_NUM;
	}
	public static void setID_NUM(int[] iD_Str) {
		SaveData.ID_NUM = iD_Str;
	}
	
	public TicketType getTicketType() {
		return ticket_Type;
	}

	public void setTicketType(TicketType ticketType) {
		this.ticket_Type = ticketType;
	}

	public Discount getDiscount() {
		return discount;
	}

	public void setDiscount(Discount discount) {
		this.discount = discount;
	}

	public AgeGroup getAge() {
		return age;
	}

	public void setAge(AgeGroup ageGroup) {
		this.age = ageGroup;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int qty) {
		this.quantity = qty;
	}

	public long getAmount() {
		return amount;
	}

	public void setAmount(long amount) {
		this.amount = amount;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}
	public ArrayList<Object> getAny() {
		ArrayList<Object> savingEach = new ArrayList<Object>();
		savingEach.add(getDate());
		savingEach.add(getTicketType());
		savingEach.add(getAge());
		savingEach.add(getQuantity());
		savingEach.add(getAmount());
		savingEach.add(getDiscount());
		return savingEach;
	}
}
	
	